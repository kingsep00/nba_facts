package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "favorite_team.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        // create tables here
        db?.execSQL("CREATE TABLE favorite_team (id INTEGER PRIMARY KEY, abv TEXT, full_name TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // handle database upgrades here
        db?.execSQL("DROP TABLE IF EXISTS favorite_team")
        onCreate(db)
    }
}