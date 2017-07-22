package com.example.android.myuni;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Anna on 27.05.2017.
 * <p>
 * DatabaseHelper class creates and upgrades local SQLLite database
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "my_uni.db";

    public static final String TABLE_NAME = "student_data";
    public static final String TABLE_TimeTable = "timetable_data";


    //Student_data
    public static final String COL_1 = "device_id";
    public static final String COL_2 = "username";
    public static final String COL_3 = "password";

    //Timetable_data
    public static final String COL_4 = "day";
    public static final String COL_5 = "time";
    public static final String COL_6 = "course";
    public static final String COL_7 = "campus";
    public static final String COL_8 = "room";
    public static final String COL_9 = "row_id";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    //creates a table
    @Override
    public void onCreate(SQLiteDatabase db) {


        String sql = String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY, %s TEXT, " +
                "%s TEXT)", TABLE_NAME, COL_1, COL_2, COL_3);
        db.execSQL(sql);
        Log.d("ASB", " TABLE CREATED on create");

        String sql1 = String.format("CREATE TABLE %s (%s TEXT, %s TEXT, %s TEXT, " +
                        "%s TEXT, %s TEXT, %s TEXT, %s TEXT, PRIMARY KEY(%s,%s)," +
                        " FOREIGN KEY(%s) REFERENCES %s(%s))",
                TABLE_TimeTable, COL_4, COL_9, COL_1, COL_5, COL_6, COL_7, COL_8, COL_4, COL_9, COL_1, TABLE_NAME, COL_1);

        db.execSQL(sql1);
        Log.d("ASB", " TABLE CREATED on create");


    }


    public void deleteTimeTableDayValues(String day) {
        SQLiteDatabase db = getWritableDatabase();
        String sqlDelete = String.format("DELETE * FROM %s WHERE %s='%s'", TABLE_TimeTable, COL_4, day);
        db.close();

    }

    public void student_dataLeeren() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

    public void timeTableLeeren() {
        SQLiteDatabase db = getWritableDatabase();
        String sqlDelete = String.format(TABLE_TimeTable, null, null);
        db.close();
    }


    public boolean insertTimeTableData(String[] content) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put(COL_1, content[0]);
            values.put(COL_4, content[1]);
            values.put(COL_9, "1");
            values.put(COL_5, content[2]);
            values.put(COL_6, content[3]);
            values.put(COL_7, content[4]);
            values.put(COL_8, content[5]);

            values.put(COL_1, content[0]);
            values.put(COL_4, content[1]);
            values.put(COL_9, "2");
            values.put(COL_5, content[6]);
            values.put(COL_6, content[7]);
            values.put(COL_7, content[8]);
            values.put(COL_8, content[9]);

            values.put(COL_1, content[0]);
            values.put(COL_4, content[1]);
            values.put(COL_9, "3");
            values.put(COL_5, content[10]);
            values.put(COL_6, content[11]);
            values.put(COL_7, content[12]);
            values.put(COL_8, content[13]);


            //insert returns -1 if error occurs
            long result = db.insert(TABLE_TimeTable, null, values);
            db.close();
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } catch (SQLiteException e) {

        }

        return true;

    }

    public boolean insertRow1(String[] content) {
        try {
            deleteRow(content[1], "1");
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(COL_1, content[0]);
            values.put(COL_4, content[1]);
            values.put(COL_9, "1");
            values.put(COL_5, content[2]);
            values.put(COL_6, content[3]);
            values.put(COL_7, content[4]);
            values.put(COL_8, content[5]);

            //insert returns -1 if error occurs
            long result = db.insert(TABLE_TimeTable, null, values);
            db.close();
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } catch (SQLiteException e) {

        }

        return true;
    }

    public boolean insertRow2(String[] content) {
        try {
            deleteRow(content[1], "2");
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(COL_1, content[0]);
            values.put(COL_4, content[1]);
            values.put(COL_9, "2");
            values.put(COL_5, content[6]);
            values.put(COL_6, content[7]);
            values.put(COL_7, content[8]);
            values.put(COL_8, content[9]);

            //insert returns -1 if error occurs
            long result = db.insert(TABLE_TimeTable, null, values);
            db.close();
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } catch (SQLiteException e) {

        }

        return true;
    }

    public boolean insertRow3(String[] content) {
        try {
            deleteRow(content[1], "3");
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(COL_1, content[0]);
            values.put(COL_4, content[1]);
            values.put(COL_9, "3");
            values.put(COL_5, content[10]);
            values.put(COL_6, content[11]);
            values.put(COL_7, content[12]);
            values.put(COL_8, content[13]);

            //insert returns -1 if error occurs
            long result = db.insert(TABLE_TimeTable, null, values);
            db.close();
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } catch (SQLiteException e) {

        }

        return true;
    }

    public boolean insertRow4(String[] content) {
        try {
            deleteRow(content[1], "4");
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(COL_1, content[0]);
            values.put(COL_4, content[1]);
            values.put(COL_9, "4");
            values.put(COL_5, content[14]);
            values.put(COL_6, content[15]);
            values.put(COL_7, content[16]);
            values.put(COL_8, content[17]);

            //insert returns -1 if error occurs
            long result = db.insert(TABLE_TimeTable, null, values);
            db.close();
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } catch (SQLiteException e) {

        }

        return true;
    }


    public boolean insertRow5(String[] content) {
        try {
            deleteRow(content[1], "5");
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(COL_1, content[0]);
            values.put(COL_4, content[1]);
            values.put(COL_9, "5");
            values.put(COL_5, content[18]);
            values.put(COL_6, content[19]);
            values.put(COL_7, content[20]);
            values.put(COL_8, content[21]);

            //insert returns -1 if error occurs
            long result = db.insert(TABLE_TimeTable, null, values);
            db.close();
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } catch (SQLiteException e) {

        }

        return true;
    }

    public boolean insertRow6(String[] content) {
        try {
            deleteRow(content[1], "6");
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(COL_1, content[0]);
            values.put(COL_4, content[1]);
            values.put(COL_9, "6");
            values.put(COL_5, content[22]);
            values.put(COL_6, content[23]);
            values.put(COL_7, content[24]);
            values.put(COL_8, content[25]);

            //insert returns -1 if error occurs
            long result = db.insert(TABLE_TimeTable, null, values);
            db.close();
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } catch (SQLiteException e) {

        }

        return true;
    }


    public boolean insertRegistrationData(String deviceId, String name, String password) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("device_id", deviceId);
            values.put("username", name);
            values.put("password", password);

            //insert returns -1 if error occurs
            long result = db.insert(TABLE_NAME, null, values);
            if (result == -1) {
                return false;
            } else {
                return true;
            }


            //TODO popup
        } catch (SQLiteException e) {
            Log.d("ASB", "DB could not be opened");
        }

        return true;

    }

    public String getDeviceIDFromDB(String deviceID) {
        boolean result = true;
        //opens database
        SQLiteDatabase db = getReadableDatabase();
        //query
        String sql = String.format("SELECT %s FROM %s WHERE %s='%s'", COL_1, TABLE_NAME, COL_1, deviceID);
        //runs sql and returns Cursor
        //Cursor: provides random read-write access to the result set returned by a database query.
        Cursor cursor = db.rawQuery(sql, null);

        //  String data = cursor.getString(cursor.getColumnIndex(COL_1));
        String data = null;
        boolean b = cursor.moveToFirst();
        data = cursor.getString(cursor.getColumnIndex("device_id"));
        boolean b1 = cursor.moveToNext();
       /* if (cursor.moveToFirst()){

            do{ data=cursor.getString(cursor.getColumnIndex("device_id"));

                // do what ever you want here
            }while(cursor.moveToNext());

        }*/
        cursor.close();

        db.close();

        return data;
    }

    public TimeTableHelper getTimeTableHelper(String day) {
        Log.d("ASB", "getTimeTableRow called: ");

        SQLiteDatabase db = getReadableDatabase();
        String sql1 = String.format("SELECT * FROM %s WHERE %s='%s' AND %s='%s'", TABLE_TimeTable, COL_4, day, COL_9, "1");
        String sql2 = String.format("SELECT * FROM %s WHERE %s='%s' AND %s='%s'", TABLE_TimeTable, COL_4, day, COL_9, "2");
        String sql3 = String.format("SELECT * FROM %s WHERE %s='%s' AND %s='%s'", TABLE_TimeTable, COL_4, day, COL_9, "3");
        String sql4 = String.format("SELECT * FROM %s WHERE %s='%s' AND %s='%s'", TABLE_TimeTable, COL_4, day, COL_9, "4");
        String sql5 = String.format("SELECT * FROM %s WHERE %s='%s' AND %s='%s'", TABLE_TimeTable, COL_4, day, COL_9, "5");
        String sql6 = String.format("SELECT * FROM %s WHERE %s='%s' AND %s='%s'", TABLE_TimeTable, COL_4, day, COL_9, "6");


        Cursor cursor1 = db.rawQuery(sql1, null);
        Cursor cursor2 = db.rawQuery(sql2, null);
        Cursor cursor3 = db.rawQuery(sql3, null);
        Cursor cursor4 = db.rawQuery(sql4, null);
        Cursor cursor5 = db.rawQuery(sql5, null);
        Cursor cursor6 = db.rawQuery(sql6, null);

        cursor1.moveToFirst();
        cursor2.moveToFirst();
        cursor3.moveToFirst();
        cursor4.moveToFirst();
        cursor5.moveToFirst();
        cursor6.moveToFirst();

        String dayDB;
        String rowID;
        String deviceID;
        String time;
        String course;
        String campus;
        String room;

        String[] row1 = new String[7];
        try {
            dayDB = cursor1.getString(0);
            rowID = cursor1.getString(1);
            deviceID = cursor1.getString(2);
            time = cursor1.getString(3);
            course = cursor1.getString(4);
            campus = cursor1.getString(5);
            room = cursor1.getString(6);

            row1[0] = dayDB;
            row1[1] = rowID;
            row1[2] = deviceID;
            row1[3] = time;
            row1[4] = course;
            row1[5] = campus;
            row1[6] = room;
        } catch (Exception e) {

            for (int i = 0; i < row1.length; i++) {
                row1[i] = "";
            }
            row1[3] = "08-10";


        }

        String[] row2 = new String[7];
        try {
            dayDB = cursor2.getString(0);
            rowID = cursor2.getString(1);
            deviceID = cursor2.getString(2);
            time = cursor2.getString(3);
            course = cursor2.getString(4);
            campus = cursor2.getString(5);
            room = cursor2.getString(6);

            row2[0] = dayDB;
            row2[1] = rowID;
            row2[2] = deviceID;
            row2[3] = time;
            row2[4] = course;
            row2[5] = campus;
            row2[6] = room;
        } catch (Exception e) {

            for (int i = 0; i < row2.length; i++) {
                row2[i] = "";
            }
            row2[3] = "10-12";
        }

        String[] row3 = new String[7];

        try {
            dayDB = cursor3.getString(0);
            rowID = cursor3.getString(1);
            deviceID = cursor3.getString(2);
            time = cursor3.getString(3);
            course = cursor3.getString(4);
            campus = cursor3.getString(5);
            room = cursor3.getString(6);

            row3[0] = dayDB;
            row3[1] = rowID;
            row3[2] = deviceID;
            row3[3] = time;
            row3[4] = course;
            row3[5] = campus;
            row3[6] = room;

        } catch (Exception e) {

            for (int i = 0; i < row3.length; i++) {
                row3[i] = "";
            }
            row3[3] = "12-14";

        }
        String[] row4 = new String[7];

        try {
            dayDB = cursor4.getString(0);
            rowID = cursor4.getString(1);
            deviceID = cursor4.getString(2);
            time = cursor4.getString(3);
            course = cursor4.getString(4);
            campus = cursor4.getString(5);
            room = cursor4.getString(6);

            row4[0] = dayDB;
            row4[1] = rowID;
            row4[2] = deviceID;
            row4[3] = time;
            row4[4] = course;
            row4[5] = campus;
            row4[6] = room;

        } catch (Exception e) {

            for (int i = 0; i < row4.length; i++) {
                row4[i] = "";
            }
            row4[3] = "14-16";
        }
        String[] row5 = new String[7];

        try {
            dayDB = cursor5.getString(0);
            rowID = cursor5.getString(1);
            deviceID = cursor5.getString(2);
            time = cursor5.getString(3);
            course = cursor5.getString(4);
            campus = cursor5.getString(5);
            room = cursor5.getString(6);

            row5[0] = dayDB;
            row5[1] = rowID;
            row5[2] = deviceID;
            row5[3] = time;
            row5[4] = course;
            row5[5] = campus;
            row5[6] = room;

        } catch (Exception e) {

            for (int i = 0; i < row5.length; i++) {
                row5[i] = "";
            }
            row5[3] = "16-18";
        }
        String[] row6 = new String[7];

        try {
            dayDB = cursor6.getString(0);
            rowID = cursor6.getString(1);
            deviceID = cursor6.getString(2);
            time = cursor6.getString(3);
            course = cursor6.getString(4);
            campus = cursor6.getString(5);
            room = cursor6.getString(6);

            row6[0] = dayDB;
            row6[1] = rowID;
            row6[2] = deviceID;
            row6[3] = time;
            row6[4] = course;
            row6[5] = campus;
            row6[6] = room;

        } catch (Exception e) {

            for (int i = 0; i < row6.length; i++) {
                row6[i] = "";
            }
            row6[3] = "18-20";
        }

        TimeTableHelper timeTableHelper = new TimeTableHelper(row1, row2, row3, row4, row5, row6);

        db.close();
        Log.d("ASB", "timetable returned");
        return timeTableHelper;

    }

    public void deleteRow(String day, String rowID) {
        SQLiteDatabase db = getWritableDatabase();
        String sqlDelete = String.format("DELETE FROM %s WHERE %s='%s' AND %s='%s'", TABLE_TimeTable, "day", day, "row_id", rowID);
        db.execSQL(sqlDelete);
        db.close();
        Log.d("ASB", "deleteRow After");
    }


    public void dropTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE  " + TABLE_NAME);
        db.execSQL("DROP TABLE  " + TABLE_TimeTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS  " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS  " + TABLE_TimeTable);
        onCreate(db);


    }
}
