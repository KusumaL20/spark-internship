package com.anvitha.basicbankingapp.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.anvitha.basicbankingapp.DB.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(8860,'Anvitha', 'anvi@gmail.com','8584','7765463238', 16000)");
        db.execSQL("insert into " + TABLE_NAME + " values(6862,'Chaitanya', 'chaitu@gmail.com','2258','9876654099', 6000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8895,'Krishna Pratap', 'krishna@gmail.com','9896','7456776252', 2000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2258,'Vihala Timmaih', 'vishala@gmail.com','8752','9876595421', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8410,'Shivanna kumar', 'shiva@gmail.com','4669','9076543212', 8500)");
        db.execSQL("insert into " + TABLE_NAME + " values(9529,'Joshitha', 'joshitha@gmail.com','8985','8907532145', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4698,'Yash Pratap', 'yash@gmail.com','3207','9695640215', 5500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8853,'Khushika Gowda', 'khushi@gmail.com','5522','9984634355', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(5562,'Ritika Sharma', 'ritika@gmail.com','7582','9309587238', 11500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3365,'Rohit Sharma', 'rohit@gmail.com','6450','8965432198', 9950)");
        db.execSQL("insert into " + TABLE_NAME + " values(8854,'Anushma Joy', 'anu@gmail.com','3656','9015641287', 9880)");
        db.execSQL("insert into " + TABLE_NAME + " values(4621,'Harshitha', 'harshi@gmail.com','2203','7865431908', 12000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5122,'Neharika Gowda', 'neha772@gmail.com','6566','9189766554', 6800)");
        db.execSQL("insert into " + TABLE_NAME + " values(10512,'Gangambika', 'ganga56@gmail.com','3236','6287765444', 5500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8530,'Bhavana Naik', 'bhav90@gmail.com','8692','9876554430', 5010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}