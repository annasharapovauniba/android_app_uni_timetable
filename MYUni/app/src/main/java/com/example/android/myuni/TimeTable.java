package com.example.android.myuni;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.example.android.myuni.Registration.dbHelper;


public class TimeTable extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Top
    private static TextView tvDate;
    private static Button bNext;
    private static Button bPrevious;

    //Bottom
    private static Button bAddCourse;
    private static Button bSave;
    private static Button bDeleteDay;

    //EditText Time
    private static EditText et8, et10, et12, et14, et16, et18;

    //EditText Course
    private static EditText et8Course, et10Course, et12Course, et14Course, et16Course, et18Course;

    //EditText Room
    private static EditText et8Room, et10Room, et12Room, et14Room, et16Room, et18Room;

    //Spinners Campus
    private static Spinner s8Campus, s10Campus, s12Campus, s14Campus, s16Campus, s18Campus;

    private static ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        bSave = (Button) findViewById(R.id.bSave);
        bPrevious = (Button) findViewById(R.id.bPrevoius);
        bNext = (Button) findViewById(R.id.bNext);
        tvDate = (TextView) findViewById(R.id.date);
        bDeleteDay = (Button) findViewById(R.id.bDeleteDay);

        createSpinners();
        createEditText();
        getSupportActionBar().hide();

        setDate();
        disableViews();


        setTimeTable(tvDate.getText().toString());

    }

    public void bDeleteDayOnClick(View view) {
        dbHelper.deleteRow(tvDate.getText().toString(), "1");
        dbHelper.deleteRow(tvDate.getText().toString(), "2");
        dbHelper.deleteRow(tvDate.getText().toString(), "3");
        dbHelper.deleteRow(tvDate.getText().toString(), "4");
        dbHelper.deleteRow(tvDate.getText().toString(), "5");
        dbHelper.deleteRow(tvDate.getText().toString(), "6");

        et8.setText("08-10");
        et10.setText("10-12");
        et12.setText("12-14");
        et14.setText("14-16");
        et16.setText("16-18");
        et18.setText("18-20");

        et8Course.setText("");
        et10Course.setText("");
        et12Course.setText("");
        et14Course.setText("");
        et16Course.setText("");
        et18Course.setText("");

        s8Campus.setSelection(adapter.getPosition(""));
        s10Campus.setSelection(adapter.getPosition(""));
        s12Campus.setSelection(adapter.getPosition(""));
        s14Campus.setSelection(adapter.getPosition(""));
        s16Campus.setSelection(adapter.getPosition(""));
        s18Campus.setSelection(adapter.getPosition(""));


        et8Room.setText("");
        et10Room.setText("");
        et12Room.setText("");
        et14Room.setText("");
        et16Room.setText("");
        et18Room.setText("");

    }


    public void bPreviousOnClick(View view) {
        String previous = bPrevious.getText().toString();
        tvDate.setText(previous);
        setTimeTable(tvDate.getText().toString());

        switch (previous) {
            case "Monday":
                bPrevious.setText("Sunday");
                bNext.setText("Tuesday");
                break;
            case "Tuesday":
                bPrevious.setText("Monday");
                bNext.setText("Wednesday");
                break;
            case "Wednesday":
                bPrevious.setText("Tuesday");
                bNext.setText("Thursday");
                break;
            case "Thursday":
                bPrevious.setText("Wednesday");
                bNext.setText("Friday");
                break;
            case "Friday":
                bPrevious.setText("Thursday");
                bNext.setText("Saturday");
                break;
            case "Saturday":
                bPrevious.setText("Friday");
                bNext.setText("Sunday");
                break;
            case "Sunday":
                bPrevious.setText("Saturday");
                bNext.setText("Monday");
                break;
            default:
                bPrevious.setText("");
        }
    }

    public void bNextOnClick(View view) {
        String next = bNext.getText().toString();
        tvDate.setText(bNext.getText().toString());
        setTimeTable(tvDate.getText().toString());


        switch (next) {
            case "Monday":
                bPrevious.setText("Sunday");
                bNext.setText("Tuesday");
                break;
            case "Tuesday":
                bPrevious.setText("Monday");
                bNext.setText("Wednesday");
                break;
            case "Wednesday":
                bPrevious.setText("Tuesday");
                bNext.setText("Thursday");
                break;
            case "Thursday":
                bPrevious.setText("Wednesday");
                bNext.setText("Friday");
                break;
            case "Friday":
                bPrevious.setText("Thursday");
                bNext.setText("Saturday");
                break;
            case "Saturday":
                bPrevious.setText("Friday");
                bNext.setText("Sunday");
                break;
            case "Sunday":
                bPrevious.setText("Saturday");
                bNext.setText("Monday");
                break;
            default:
                bPrevious.setText("");
        }
    }


    //EditText
    private void createEditText() {
        //Time
        et8 = (EditText) findViewById(R.id.et8);
        et10 = (EditText) findViewById(R.id.et10);
        et12 = (EditText) findViewById(R.id.et12);
        et14 = (EditText) findViewById(R.id.et14);
        et16 = (EditText) findViewById(R.id.et16);
        et18 = (EditText) findViewById(R.id.et18);

        //Course
        et8Course = (EditText) findViewById(R.id.et8Course);
        et10Course = (EditText) findViewById(R.id.et10Course);
        et12Course = (EditText) findViewById(R.id.et12Course);
        et14Course = (EditText) findViewById(R.id.et14Course);
        et16Course = (EditText) findViewById(R.id.et16Course);
        et18Course = (EditText) findViewById(R.id.et18Course);


        //Room
        et8Room = (EditText) findViewById(R.id.et8Room);
        et10Room = (EditText) findViewById(R.id.et10Room);
        et12Room = (EditText) findViewById(R.id.et12Room);
        et14Room = (EditText) findViewById(R.id.et14Room);
        et16Room = (EditText) findViewById(R.id.et16Room);
        et18Room = (EditText) findViewById(R.id.et18Room);

    }


    //Spinners Campus

    public void createSpinners() {
        adapter = ArrayAdapter.createFromResource(this, R.array.campuses, android.R.layout.simple_spinner_item);

        s8Campus = (Spinner) findViewById(R.id.s8Campus);
        s8Campus.setAdapter(adapter);
        s8Campus.setOnItemSelectedListener(TimeTable.this);

        s10Campus = (Spinner) findViewById(R.id.s10Campus);
        s10Campus.setAdapter(adapter);
        s10Campus.setOnItemSelectedListener(TimeTable.this);

        s12Campus = (Spinner) findViewById(R.id.s12Campus);
        s12Campus.setAdapter(adapter);
        s12Campus.setOnItemSelectedListener(TimeTable.this);

        s14Campus = (Spinner) findViewById(R.id.s14Campus);
        s14Campus.setAdapter(adapter);
        s14Campus.setOnItemSelectedListener(TimeTable.this);

        s16Campus = (Spinner) findViewById(R.id.s16Campus);
        s16Campus.setAdapter(adapter);
        s16Campus.setOnItemSelectedListener(TimeTable.this);

        s18Campus = (Spinner) findViewById(R.id.s18Campus);
        s18Campus.setAdapter(adapter);
        s18Campus.setOnItemSelectedListener(TimeTable.this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //TextView spinnerDialogText=(TextView) view;
        //Toast.makeText(this, spinnerDialogText.getText(), Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void setDate() {

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        String dayOfTheWeek = sdf.format(date);

        tvDate.setText(dayOfTheWeek);
        Log.d("ASB", "SetTimeTableBefore");


        Log.d("ASB", "SetTimeTableAfter");

        Calendar today = Calendar.getInstance();
        today.setTime(date);
        today.add(Calendar.DAY_OF_YEAR, 1);
        String nextDate = sdf.format(today.getTime());
        bNext.setText(nextDate);

        today.add(Calendar.DAY_OF_YEAR, 5);
        String previousDate = sdf.format(today.getTime());
        bPrevious.setText(previousDate);

        Log.d("ASB", "setDateEnd");

    }

    public String getDeviceId() {
        String deviceId = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return deviceId;
    }

    public void bAddCourseOnClick(View view) {
        enableViews();
    }

    public void bSaveOnClick(View view) {
        //disable all input fields
        disableViews();

        //gets content
        String deviceId = getDeviceId();
        String day = tvDate.getText().toString();

        String time1 = et8.getText().toString();
        String course1 = et8Course.getText().toString();
        String campus1 = s8Campus.getSelectedItem().toString();
        String room1 = et8Room.getText().toString();

        String time2 = et10.getText().toString();
        String course2 = et10Course.getText().toString();
        String campus2 = s10Campus.getSelectedItem().toString();
        String room2 = et10Room.getText().toString();

        String time3 = et12.getText().toString();
        String course3 = et12Course.getText().toString();
        String campus3 = s12Campus.getSelectedItem().toString();
        String room3 = et12Room.getText().toString();

        String time4 = et14.getText().toString();
        String course4 = et14Course.getText().toString();
        String campus4 = s14Campus.getSelectedItem().toString();
        String room4 = et14Room.getText().toString();

        String time5 = et16.getText().toString();
        String course5 = et16Course.getText().toString();
        String campus5 = s16Campus.getSelectedItem().toString();
        String room5 = et16Room.getText().toString();

        String time6 = et18.getText().toString();
        String course6 = et18Course.getText().toString();
        String campus6 = s18Campus.getSelectedItem().toString();
        String room6 = et18Room.getText().toString();

        String content[] = new String[26];
        content[0] = deviceId;
        content[1] = day;

        content[2] = time1;
        content[3] = course1;
        content[4] = campus1;
        content[5] = room1;

        content[6] = time2;
        content[7] = course2;
        content[8] = campus2;
        content[9] = room2;

        content[10] = time3;
        content[11] = course3;
        content[12] = campus3;
        content[13] = room3;

        content[14] = time4;
        content[15] = course4;
        content[16] = campus4;
        content[17] = room4;

        content[18] = time5;
        content[19] = course5;
        content[20] = campus5;
        content[21] = room5;

        content[22] = time6;
        content[23] = course6;
        content[24] = campus6;
        content[25] = room6;


        boolean b1 = dbHelper.insertRow1(content);
        boolean b2 = dbHelper.insertRow2(content);
        boolean b3 = dbHelper.insertRow3(content);
        boolean b4 = dbHelper.insertRow4(content);
        boolean b5 = dbHelper.insertRow5(content);
        boolean b6 = dbHelper.insertRow6(content);


        Toast.makeText(TimeTable.this, "insertInDB1: " + String.valueOf(b1), Toast.LENGTH_LONG).show();
        Toast.makeText(TimeTable.this, "insertInDB2: " + String.valueOf(b2), Toast.LENGTH_LONG).show();
        Toast.makeText(TimeTable.this, "insertInDB3: " + String.valueOf(b3), Toast.LENGTH_LONG).show();
        Toast.makeText(TimeTable.this, "insertInDB4: " + String.valueOf(b4), Toast.LENGTH_LONG).show();
        Toast.makeText(TimeTable.this, "insertInDB5: " + String.valueOf(b5), Toast.LENGTH_LONG).show();
        Toast.makeText(TimeTable.this, "insertInDB6: " + String.valueOf(b6), Toast.LENGTH_LONG).show();

      /*  String userName="root";
        String userPassword="";
        String type="login";*/

        //  BackgroundWorker bWorker=new BackgroundWorker(this);
        // bWorker.execute(type, userName, userPassword);

    }

    private void enableViews() {
        et8.setEnabled(true);
        et10.setEnabled(true);
        et12.setEnabled(true);
        et14.setEnabled(true);
        et16.setEnabled(true);
        et18.setEnabled(true);

        et8Course.setEnabled(true);
        et10Course.setEnabled(true);
        et12Course.setEnabled(true);
        et14Course.setEnabled(true);
        et16Course.setEnabled(true);
        et18Course.setEnabled(true);

        et8Room.setEnabled(true);
        et10Room.setEnabled(true);
        et12Room.setEnabled(true);
        et14Room.setEnabled(true);
        et16Room.setEnabled(true);
        et18Room.setEnabled(true);
        ;
        s8Campus.setEnabled(true);
        s10Campus.setEnabled(true);
        s12Campus.setEnabled(true);
        s14Campus.setEnabled(true);
        s16Campus.setEnabled(true);
        s18Campus.setEnabled(true);
    }

    private void disableViews() {
        et8.setEnabled(false);
        et10.setEnabled(false);
        et12.setEnabled(false);
        et14.setEnabled(false);
        et16.setEnabled(false);
        et18.setEnabled(false);

        et8Course.setEnabled(false);
        et10Course.setEnabled(false);
        et12Course.setEnabled(false);
        et14Course.setEnabled(false);
        et16Course.setEnabled(false);
        et18Course.setEnabled(false);

        et8Room.setEnabled(false);
        et10Room.setEnabled(false);
        et12Room.setEnabled(false);
        et14Room.setEnabled(false);
        et16Room.setEnabled(false);
        et18Room.setEnabled(false);

        s8Campus.setEnabled(false);
        s10Campus.setEnabled(false);
        s12Campus.setEnabled(false);
        s14Campus.setEnabled(false);
        s16Campus.setEnabled(false);
        s18Campus.setEnabled(false);

    }

    public void setTimeTable(String day) {


        String[] row1 = dbHelper.getTimeTableHelper(day).getRow1();

        et8.setText(row1[3]);
        et8Course.setText(row1[4]);
        s8Campus.setSelection(adapter.getPosition(row1[5]));
        et8Room.setText(row1[6]);

        String[] row2 = dbHelper.getTimeTableHelper(day).getRow2();

        et10.setText(row2[3]);
        et10Course.setText(row2[4]);
        s10Campus.setSelection(adapter.getPosition(row2[5]));
        et10Room.setText(row2[6]);

        String[] row3 = dbHelper.getTimeTableHelper(day).getRow3();

        et12.setText(row3[3]);
        et12Course.setText(row3[4]);
        s12Campus.setSelection(adapter.getPosition(row3[5]));
        et12Room.setText(row3[6]);

        String[] row4 = dbHelper.getTimeTableHelper(day).getRow4();

        et14.setText(row4[3]);
        et14Course.setText(row4[4]);
        s14Campus.setSelection(adapter.getPosition(row4[5]));
        et14Room.setText(row4[6]);

        String[] row5 = dbHelper.getTimeTableHelper(day).getRow5();

        et16.setText(row5[3]);
        et16Course.setText(row5[4]);
        s16Campus.setSelection(adapter.getPosition(row5[5]));
        et16Room.setText(row5[6]);

        String[] row6 = dbHelper.getTimeTableHelper(day).getRow6();

        et18.setText(row6[3]);
        String s = row6[3];
        et18Course.setText(row6[4]);
        String s1 = row6[4];
        s18Campus.setSelection(adapter.getPosition(row6[5]));
        String s2 = row6[5];
        et18Room.setText(row6[6]);
        String s3 = row6[6];


    }


}
