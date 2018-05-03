package com.example.shahityaa.parlouradmin;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDB {
	private static final String DB_Name="Mydb.db";
	private static final int version=1;
	private static final String crea="create table Services(_id integer primary key autoincrement, Service text not null , Price text not null);";
	private SQLiteDatabase db;
	private final Context c;
	private MyDBHelper dbh;
	public MyDB(Context co){
		c=co;
		dbh=new MyDBHelper(c,DB_Name,null,version);
	}
	public MyDB open() throws SQLException {
		db=dbh.getWritableDatabase();
		return this;
	}
	public void close(){
		db.close();
	}
	public void insertEntry(String service,String price){
		ContentValues value=new ContentValues();
		value.put("Service", service);
		value.put("Price", price);
		db.insert("Services", null, value);
	}
	public void updateEntry(String service,String price){
		ContentValues value=new ContentValues();
		value.put("Price", price);
		db.update("Services",value,"Service = '"+service +"'",null);
	}
	public int searchCount(){
		Cursor c=db.query("Services", null, null, null, null, null, null);
		int n =c.getCount();
		return n;
	}
	public void deleteVal(String name)
	{
		db.delete("Services", "Service "+ "= '" + name +"'", null);
		//db.execSQL("DELETE FROM Sample WHERE Name = '"  + name + "'");
	}
	public void selectVal()
	{

	}

	public String getAllRecords() {
		String query = "Select * FROM Services" ;
		StringBuilder results = new StringBuilder();
		String output = "SNo\t\t\tService Name\t\t\t Price\n\n" ;
		//String output = " ";
		Cursor cursor = db.rawQuery(query, null);

		int colCount = cursor.getColumnCount();

			cursor.moveToFirst();

			while (true) {
				for (int i = 0; i < colCount; i++) {
					results.append(cursor.getString(i));
					output =  output + cursor.getString(i) + "\t\t\t"  ;
				}
				output = output + "\n";
				if (cursor.isLast())
				{
					break;
				}
				cursor.moveToNext();
			}
			cursor.close();
			return output;

	}

	private static class MyDBHelper extends SQLiteOpenHelper {
		public MyDBHelper(Context con,String name,CursorFactory cf,int ver){
			super(con,name,cf,ver);
		}
		public void onCreate(SQLiteDatabase sd){
			sd.execSQL(crea);
		}
		public void onUpgrade(SQLiteDatabase sd,int ov,int nv){
			
		}
	}

}
