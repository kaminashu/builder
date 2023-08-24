package www.uzmd.builder

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class LocalLocalDatabaseImpl(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION), LocalDatabase {
    companion object {
        val DATABASE_NAME = "builder.db"
        val DATABASE_VERSION = 1
        val TAB_NAME = "users"
        val DB_NAME = "name"
        val DB_PAROL = "parol"
        val ID = "id"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE $TAB_NAME($ID integer not null primary key autoincrement," +
                "$DB_NAME text not null," +
                "$DB_PAROL text not null)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


    override fun add(userModel: UserModel) {
        val datbase = this.readableDatabase
        val con = ContentValues()
        con.put(DB_NAME, userModel.name)
        con.put(DB_PAROL, userModel.parol)
        datbase.insert(TAB_NAME, null, con)
    }

    override fun edit(userModel: UserModel) {
        TODO("Not yet implemented")
    }

    @SuppressLint("Recycle")
    override fun allList(): List<UserModel> {
        val list = mutableListOf<UserModel>()
        val database = this.readableDatabase
        val query = "SELECT * FROM $TAB_NAME"
        val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val parol = cursor.getString(2)
                val userModel = UserModel(id, name, parol)
                list.add(userModel)
            } while (cursor.moveToNext())
        }
        return list
    }

    override fun delete() {
        TODO("Not yet implemented")
    }

}