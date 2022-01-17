package com.heptaco.projectbabygenerator

import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class DBHelperTest(private val myContext: Context) :
    SQLiteOpenHelper(myContext, DB_NAME, null, 10) {
    var DB_PATH: String? = null
    private var myDataBase: SQLiteDatabase? = null

    companion object {
        private const val DB_NAME = "db_babygen.db"
    }

    init {
        DB_PATH = "/data/data/" + myContext.packageName + "/" + "databases/"
        Log.e("Path 1", DB_PATH)
    }
    @Throws(IOException::class)

    fun createDataBase() {
        val dbExist = checkDataBase()
        if (dbExist) {
        } else {
            this.readableDatabase
            try {
                copyDataBase()
            } catch (e: IOException) {
                throw Error("Error copying database")
            }
        }
    }

    private fun checkDataBase(): Boolean {
        var checkDB: SQLiteDatabase? = null
        try {
            val myPath = DB_PATH + DB_NAME
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY)
        } catch (e: SQLiteException) {
        }
        checkDB?.close()
        return if (checkDB != null) true else false
    }

    @Throws(IOException::class)
    private fun copyDataBase() {
        val myInput =
            myContext.assets.open(DB_NAME)
        val outFileName = DB_PATH + DB_NAME
        val myOutput: OutputStream = FileOutputStream(outFileName)
        val buffer = ByteArray(10)
        var length: Int
        while (myInput.read(buffer).also { length = it } > 0) {
            myOutput.write(buffer, 0, length)
        }
        myOutput.flush()
        myOutput.close()
        myInput.close()
    }

    @Throws(SQLException::class)
    fun openDataBase() {
        val myPath = DB_PATH + DB_NAME
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY)

    }

    @Synchronized
    override fun close() {
        if (myDataBase != null) myDataBase!!.close()
        super.close()
    }
    override fun onOpen(db: SQLiteDatabase) {
        db.disableWriteAheadLogging() // Here the solution
        super.onOpen(db)
    }
    
    override fun onCreate(db: SQLiteDatabase) {

    }
    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        if (newVersion > oldVersion) try {
            copyDataBase()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    //EROPA
    fun rawqueryERP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Eropa","Romantic","P"))
    }
    fun rawqueryERL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Eropa","Romantic","L"))
    }
    fun rawqueryECP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Eropa","Creative","P"))
    }
    fun rawqueryECL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Eropa","Creative","L"))
    }
    fun rawqueryESP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Eropa","Supportive","P"))
    }
    fun rawqueryESL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Eropa","Supportive","L"))
    }
    fun rawqueryEEP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Eropa","Energetic","P"))
    }
    fun rawqueryEEL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Eropa","Energetic","L"))
    }

    //ARAB
    fun rawqueryARP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Arab","Romantic","P"))
    }
    fun rawqueryARL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Arab","Romantic","L"))
    }
    fun rawqueryACP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Arab","Creative","P"))
    }
    fun rawqueryACL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Arab","Creative","L"))
    }
    fun rawqueryASP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Arab","Supportive","P"))
    }
    fun rawqueryASL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Arab","Supportive","L"))
    }
    fun rawqueryAEP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Arab","Energetic","P"))
    }
    fun rawqueryAEL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Arab","Energetic","L"))
    }

    //SANSEKERTA
    fun rawquerySRP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Sansekerta","Romantic","P"))
    }
    fun rawquerySRL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Sansekerta","Romantic","L"))
    }
    fun rawquerySCP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Sansekerta","Creative","P"))
    }
    fun rawquerySCL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Sansekerta","Creative","L"))
    }
    fun rawquerySSP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Sansekerta","Supportive","P"))
    }
    fun rawquerySSL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Sansekerta","Supportive","L"))
    }
    fun rawquerySEP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Sansekerta","Energetic","P"))
    }
    fun rawquerySEL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Sansekerta","Energetic","L"))
    }

    //INDONESIA
    fun rawqueryIRP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Indonesia","Romantic","P"))
    }
    fun rawqueryIRL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Indonesia","Romantic","L"))
    }
    fun rawqueryICP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Indonesia","Creative","P"))
    }
    fun rawqueryICL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Indonesia","Creative","L"))
    }
    fun rawqueryISP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Indonesia","Supportive","P"))
    }
    fun rawqueryISL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Indonesia","Supportive","L"))
    }
    fun rawqueryIEP(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Indonesia","Energetic","P"))
    }
    fun rawqueryIEL(
        sql: String?,
        selectionArgs: Array<String?>?
    ): Cursor {
        return myDataBase!!.rawQuery("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
            arrayOf("Indonesia","Energetic","L"))
    }
}