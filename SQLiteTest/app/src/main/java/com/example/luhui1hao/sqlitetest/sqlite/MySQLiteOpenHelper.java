package com.example.luhui1hao.sqlitetest.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.luhui1hao.sqlitetest.R;

import java.util.Calendar;

/**
 * Created by luhui on 2016/10/28.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper{

    public static final String CREATE_TABLE_WEBSITES = "CREATE TABLE Websites ("
            + "id integer primary key autoincrement, "
            + "name text, "
            + "url text, "
            + "alexa integer, "
            + "country text )";

    private Context mContext;
    private static MySQLiteOpenHelper mySQLiteOpenHelper;

    private MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    public static MySQLiteOpenHelper getInstance(Context context){
        if(mySQLiteOpenHelper == null){
            mySQLiteOpenHelper = new MySQLiteOpenHelper(context, "Test.db", null ,1);
            return mySQLiteOpenHelper;
        }

        return mySQLiteOpenHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_WEBSITES);
        Toast.makeText(mContext, "DB has created!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * 清空数据库
     */
    public int deleteAll(String tableName){
        SQLiteDatabase database = mySQLiteOpenHelper.getWritableDatabase();
        return database.delete(tableName, null, null);
    }

    /**
     * 插入初始化Demo数据
     * @param tableName
     */
    public void initData(String tableName){
        deleteAll(tableName);

        SQLiteDatabase database = mySQLiteOpenHelper.getWritableDatabase();

        Resources resources = mContext.getResources();
        String[] name = resources.getStringArray(R.array.name);
        String[] url = resources.getStringArray(R.array.url);
        int[] alexa = resources.getIntArray(R.array.alexa);
        String[] country = resources.getStringArray(R.array.country);

        ContentValues values = new ContentValues();
        for(int i = 0; i < 5; i++){
            values.put("id", i);
            values.put("name",name[i]);
            values.put("url", url[i]);
            values.put("alexa", alexa[i]);
            values.put("country", country[i]);
            Log.i("luhui", values.toString());
            long result = database.insert(tableName, null, values);
            Log.i("luhui", result + "");
//            Log.i("luhui", name[i]);
            values.clear();
        }
    }

    public void insertData(){
        SQLiteDatabase database = mySQLiteOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("alexa", System.currentTimeMillis());
        database.insert("Websites", null, values);
    }

    public void deleteData(){
        SQLiteDatabase database = mySQLiteOpenHelper.getWritableDatabase();
        database.delete("Websites", "country = ?", new String[]{"CN"});
    }

    /**
     * 修改country=CN的alexa
     */
    public void updateData(){
        SQLiteDatabase database = mySQLiteOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
//        values.put("name", "name");
//        values.put("url", "url");
        values.put("alexa", System.currentTimeMillis());
//        values.put("country", "CN");
        database.update("Websites", values, "country = ?", new String[]{"CN"});
    }

    /**
     * 使用SQL语句来删除表的内容
     * @param tableName
     */
    public void deleteAll2(String tableName){
        String cmd = "DELETE FROM " + tableName;
        SQLiteDatabase database = mySQLiteOpenHelper.getWritableDatabase();
        database.execSQL(cmd);
    }

    /**
     *使用SQL语句进行数据插入
     * @param tableName
     * @param name
     * @param url
     * @param alexa
     * @param country
     */
    public void insertData2(String tableName, String name, String url, int alexa, String country){
        String cmd = "INSERT INTO " + tableName + "(name, url, alexa, country)" + " VALUES ('"
                + name + "', '"
                + url + "', "
                + alexa + ", '"
                + country + "')";

        SQLiteDatabase database = mySQLiteOpenHelper.getWritableDatabase();
        database.execSQL(cmd);
    }
}
