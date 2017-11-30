package com.egco428.basicsqlite

/**
 * Created by 6272user on 11/30/2017 AD.
 */
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class MySQLiteHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(database: SQLiteDatabase) {
        database.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Log.w(MySQLiteHelper::class.java!!.name,
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data")
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS)
        onCreate(db)
    }

    companion object {

        val TABLE_COMMENTS = "comments"
        val COLUMN_ID = "_id"
        val COLUMN_COMMENT = "comment"

        private val DATABASE_NAME = "commments.db"
        private val DATABASE_VERSION = 1

        // Database creation sql statement
        private val ATABASE_CREATE = ("create table "
                + TABLE_COMMENTS + "(" + COLUMN_ID
                + " integer primary key autoincrement, " + COLUMN_COMMENT
                + " text not null);")
    }

}
