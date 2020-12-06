package com.example.project_wheretoeat

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "ProfileDataBase"
val TABLE_NAME = "Users"
val COL_NAME = "name"
val COL_ADDRESS = "address"
val COL_PHONE_NUMBER = "phone_number"
val COL_EMAIL = "email"
val COL_ID = "id"

class DataBaseHandler(var context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " TEXT," +
                COL_ADDRESS + " TEXT," +
                COL_PHONE_NUMBER + " INTEGER," +
                COL_EMAIL + " TEXT)"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user:User){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, user.name)
        cv.put(COL_ADDRESS, user.address)
        cv.put(COL_PHONE_NUMBER, user.phone_number)
        cv.put(COL_EMAIL, user.email)
        var result = db.insert(TABLE_NAME,null, cv)
        if(result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }

    fun readData(): MutableList<User>{
        var list: MutableList<User> = ArrayList()

        val db = this.readableDatabase
        val query = "SELECT * FROM " + TABLE_NAME
        val result = db.rawQuery(query,null)
        if(result.moveToFirst())
        {
            do{
                var user = User()
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.name = result.getString(result.getColumnIndex(COL_NAME))
                user.address = result.getString(result.getColumnIndex(COL_ADDRESS))
                user.phone_number = result.getString(result.getColumnIndex(COL_PHONE_NUMBER)).toInt()
                user.email = result.getString(result.getColumnIndex(COL_EMAIL))
                list.add(user)
            }while(result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }

    fun updateData()
    {
        val db = this.writableDatabase
        val query = "SELECT * FROM " + TABLE_NAME
        val result = db.rawQuery(query,null)
        if(result.moveToFirst())
        {
            do{
                var cv = ContentValues()
                cv.put(COL_PHONE_NUMBER, result.getInt(result.getColumnIndex(COL_PHONE_NUMBER))+1)
                db.update(TABLE_NAME, cv, COL_ID + "=? AND " + COL_NAME + " =?",
                    arrayOf(result.getString(result.getColumnIndex(COL_ID)),
                            result.getString(result.getColumnIndex(COL_NAME)),
                            result.getString(result.getColumnIndex(COL_ADDRESS)),
                            result.getString(result.getColumnIndex(COL_EMAIL))))
            }while(result.moveToNext())
        }
        result.close()
        db.close()
    }

    fun deleteData(){
        val db = this.writableDatabase
        db.delete(TABLE_NAME,null,null)
        db.close()
    }

}