package com.example.android.myuni;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Registration extends AppCompatActivity {


    public static DatabaseHelper dbHelper;


    private Button bRegister, bLogin;
    private TextView tvRegister;
    private EditText etUserName, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registration);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);
        bLogin = (Button) findViewById(R.id.bLogin);


        dbHelper = new DatabaseHelper(this);

        //  dbHelper.timeTableLeeren();
        // dbHelper.student_dataLeeren();

        // dbHelper.onCreate(dbHelper.getWritableDatabase());
        //dbHelper.dropTable(dbHelper.getWritableDatabase());

        //String s=dbHelper.getDeviceIDFromDB(getDeviceID());
        // Toast.makeText(Registration.this, "data from db: "+s, Toast.LENGTH_LONG).show();

        // dbHelper.student_dataLeeren();
        if (verifyDeviceID()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
        }
        Log.d("ASB", "verify called");

      /*  if(dbHelper.verifyDeviceID(getDeviceID())){
            startActivity(new Intent(this, MainActivity.class));

        }else{}*/

        //testmethod
        // dbHelper.deleteRow(getDeviceID());

    }

    private boolean verifyDeviceID() {
        boolean result = false;
        String deviceID = getDeviceID();


        try {
            String deviceIDdb = dbHelper.getDeviceIDFromDB(getDeviceID());

            if (deviceID.equals(deviceIDdb)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }

        return result;
    }


    private String getDeviceID() {
        String deviceId = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return deviceId;
    }


    public void bLoginOnClick(View view) {
        getDeviceID();
    }

    public void bRegisterOnClick(View view) {
        //gets device ID

        // String deviceId = Settings.Secure.getString(this.getContentResolver(),
        //        Settings.Secure.ANDROID_ID);
        //gets UserName and Password
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        //  String type="register";


        boolean isInserted = dbHelper.insertRegistrationData(getDeviceID(), userName, password);
        if (isInserted = true)


            Log.d("ASB", "INSERT REGISTRATION DATA CALLED");
        //start new activity
        startActivity(new Intent(this, MainActivity.class));

        // BackgroundWorker bgw=new BackgroundWorker(this);
        // bgw.execute(type,deviceId, userName, password);


    }
}
