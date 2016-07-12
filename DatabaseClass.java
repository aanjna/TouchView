package com.example.mahe.touch;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Choudhary on 20-May-16.
 */
public class DatabaseClass {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_X = "x";
    public static final String KEY_Y = "y";

    private static final String DATABASE_NAME = "Details";
    private static final String DATABASE_TABLE = "DetailsTable";
    private static final int DATABASE_VERSION = 1;

    private DbHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;

    private static class DbHelper extends SQLiteOpenHelper {

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_X + " TEXT, " + KEY_Y + " TEXT);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    public DatabaseClass(Context c) {
        ourContext = c;
    }

    public DatabaseClass open() throws SQLException {
        ourHelper = new DbHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        ourHelper.close();
    }

    public long createEntry(String x, String y) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_X, x);
        cv.put(KEY_Y, y);
        return ourDatabase.insert(DATABASE_TABLE, null, cv);
    }

    public ArrayList<DataPoint> getData() {
        ourDatabase = ourHelper.getReadableDatabase();
        ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>();
        String[] col = new String[]{KEY_ROWID, KEY_X, KEY_Y};
        Cursor c = ourDatabase.query(DATABASE_TABLE, col, null, null, null, null, null);
        int ix = c.getColumnIndex(KEY_X);
        int iy = c.getColumnIndex(KEY_Y);
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

        }
        return dataPoints;
    }
}
