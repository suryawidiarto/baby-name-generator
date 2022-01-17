package com.heptaco.projectbabygenerator

import android.content.*
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.io.IOException
import android.database.SQLException
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.news.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.alert_dialog.view.*
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {

    var c: Cursor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var intent: Intent
        intent = getIntent()
        val hasil = intent.getStringExtra("Hasil")
        var ARTI = intent.getStringExtra("Arti")
        var ARTI1 = intent.getStringExtra("Arti1")
        var ARTI2 = intent.getStringExtra("Arti2")
        var NAMA1 = intent.getStringExtra("Nama_pindah1")
        var NAMA2 = intent.getStringExtra("Nama_pindah2")
        var NAMA_PERTAMA = intent.getStringExtra("Nama_pertama")
        val PERSONALITY = intent.getStringExtra("Personality")
        val ASAL = intent.getStringExtra("Asal")
        val KATA = intent.getStringExtra("Kata")
        val JENIS_KELAMIN = intent.getStringExtra("Jenis_kelamin")
        val NAMA_BELAKANG = intent.getStringExtra("Nama_belakang")

        t_balik.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent)
        }

        val result = findViewById<TextView>(R.id.t_result2)
        result.text = hasil

        var s_result_nama: String = hasil
        var s_result_arti: String? = null

        val arti = findViewById<TextView>(R.id.t_arti)
        if (KATA == "2") {
            arti.text = NAMA_PERTAMA + " : " + ARTI
            s_result_arti = arti.text as String
        } else if (KATA == "3") {
            arti.text = NAMA1 + " : " + ARTI1 + "\n" + NAMA2 + " : " + ARTI2
            s_result_arti = arti.text as String
        }

        // Get the clipboard system service
        var clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager


        btn_copy.setOnClickListener(){
            var textToCopy = s_result_nama +"\n\n"+ s_result_arti
            var clip = ClipData.newPlainText("",textToCopy)
            clipboard.setPrimaryClip(clip)

            val alert_tampilan = LayoutInflater.from(this).inflate(R.layout.alert_dialog, null)
            val alert = AlertDialog.Builder(this)
                alert.setView(alert_tampilan)


            val alert_dialog = alert.create()
            alert_dialog.show()
            alert_dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            alert_tampilan.btn_ok.setOnClickListener {
                alert_dialog.dismiss()
            }
        }


        //FUNGSI BUTTON UTAMA (DATABASE)
        (findViewById<View>(R.id.button02) as Button).setOnClickListener {
            val myDbHelper = DBHelperTest(this@SecondActivity)
            try {
                myDbHelper.createDataBase()
            } catch (ioe: IOException) {
                throw Error("Unable to create database")
            }
            try {
                myDbHelper.openDataBase()
            } catch (sqle: SQLException) {
                throw sqle
            }

            //FUNGSI ALL IN
            //START EROPA
            //ERP2
            if (ASAL == "Eropa" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "2") {

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }

                val start = 0
                val end = 39
                val random = rand(start, end)


                //FUNGSI QUERY
                c = myDbHelper.rawqueryERP(
                    "SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa", "Romantic", "P")
                )
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ERP3
            else if (ASAL == "Eropa" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "3") {

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }

                val start = 0
                val end = 39
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryERP(
                    "SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa", "Romantic", "P")
                )
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ERL2
            else if(ASAL == "Eropa" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 31
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryERL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Romantic","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ERL3
            else if(ASAL == "Eropa" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 31
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryERL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Romantic","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }

            //ECP2
            else if(ASAL == "Eropa" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 45
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryECP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Creative","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ECP3
            else if(ASAL == "Eropa" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 45
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryECP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Creative","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ECL2
            else if(ASAL == "Eropa" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 42
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryECL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Creative","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ECL3
            else if(ASAL == "Eropa" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 42
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryECL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Creative","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ESP2
            else if(ASAL == "Eropa" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 29
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryESP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Supportive","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ESP3
            else if(ASAL == "Eropa" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 29
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryESP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Supportive","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ESL2
            else if(ASAL == "Eropa" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 37
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryESL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Supportive","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ESL3
            else if(ASAL == "Eropa" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 37
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryESL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Supportive","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //EEP2
            else if(ASAL == "Eropa" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 31
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryEEP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Energetic","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //EEP3
            else if(ASAL == "Eropa" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 31
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryEEP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Energetic","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //EEL2
            else if(ASAL == "Eropa" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 38
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryEEL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Energetic","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //EEL3
            else if(ASAL == "Eropa" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 38
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryEEL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Energetic","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }

            //START INDONESIA
            //IRP2
            else if(ASAL == "Indonesia" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 49
                val random = rand(start, end)


                //FUNGSI QUERY
                c = myDbHelper.rawqueryIRP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Romantic","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //IRP3
            else if(ASAL == "Indonesia" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 49
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryIRP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Romantic","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //IRL2
            else if(ASAL == "Indonesia" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 37
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryIRL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Romantic","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //IRL3
            else if(ASAL == "Indonesia" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 37
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryIRL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Romantic","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }

            //ICP2
            else if(ASAL == "Indonesia" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 47
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryICP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Creative","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ICP3
            else if(ASAL == "Indonesia" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 47
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryICP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Creative","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ICL2
            else if(ASAL == "Indonesia" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 51
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryICL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Creative","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ICL3
            else if(ASAL == "Indonesia" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 51
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryICL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Creative","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ISP2
            else if(ASAL == "Indonesia" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 10
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryISP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Supportive","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ISP3
            else if(ASAL == "Indonesia" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 10
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryISP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Supportive","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ISL2
            else if(ASAL == "Indonesia" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 22
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryISL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Supportive","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ISL3
            else if(ASAL == "Indonesia" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 22
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryISL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Supportive","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //IEP2
            else if(ASAL == "Indonesia" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 35
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryIEP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Energetic","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //IEP3
            else if(ASAL == "Indonesia" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 35
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryIEP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Energetic","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //IEL2
            else if(ASAL == "Indonesia" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 41
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryIEL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Energetic","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //IEL3
            else if(ASAL == "Indonesia" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 41
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryIEL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Indonesia","Energetic","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }

            //START ARAB
            //ARP2
            else if(ASAL == "Arab" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 23
                val random = rand(start, end)


                //FUNGSI QUERY
                c = myDbHelper.rawqueryARP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Romantic","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ARP3
            else if(ASAL == "Arab" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 23
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryARP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Romantic","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ARL2
            else if(ASAL == "Arab" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 25
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryARL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Romantic","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ARL3
            else if(ASAL == "Arab" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 25
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryARL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Romantic","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }

            //ACP2
            else if(ASAL == "Arab" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 32
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryACP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Creative","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ACP3
            else if(ASAL == "Arab" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 32
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryACP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Creative","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ACL2
            else if(ASAL == "Arab" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 43
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryACL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Creative","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ACL3
            else if(ASAL == "Arab" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 43
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryACL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Creative","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ASP2
            else if(ASAL == "Arab" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 58
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryASP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Supportive","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ASP3
            else if(ASAL == "Arab" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 58
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryASP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Supportive","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ASL2
            else if(ASAL == "Arab" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 51
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryASL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Supportive","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //ASL3
            else if(ASAL == "Arab" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 51
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryASL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Supportive","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //AEP2
            else if(ASAL == "Arab" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 26
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryAEP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Energetic","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //AEP3
            else if(ASAL == "Arab" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 26
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryAEP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Energetic","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //AEL2
            else if(ASAL == "Arab" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 34
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryAEL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Energetic","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //AEL3
            else if(ASAL == "Arab" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 34
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawqueryAEL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Arab","Energetic","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //START SANSEKERTA
            //SRP2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 25
                val random = rand(start, end)


                //FUNGSI QUERY
                c = myDbHelper.rawquerySRP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Romantic","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //SRP3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 25
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySRP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Romantic","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //SRL2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 37
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySRL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Romantic","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //SRL3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 37
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySRL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Romantic","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }

            //SCP2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 36
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySCP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Creative","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //SCP3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 36
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySCP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Creative","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //SCL2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 42
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySCL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Creative","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //SCL3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 42
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySCL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Creative","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //SSP2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 28
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySSP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Supportive","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //SSP3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 28
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySSP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Supportive","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //SSL2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 36
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySSL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Supportive","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //SSL3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 36
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySSL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Supportive","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //SEP2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 22
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySEP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Energetic","P"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //SEP3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 22
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySEP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Energetic","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //SEL2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 66
                val random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySEL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Energetic","L"))
                if (c!!.moveToPosition(random)) {
                    t_result2.setText(c!!.getString(1) + " " + NAMA_BELAKANG)
                    t_arti.setText(c!!.getString(1) + " : " + c!!.getString(5))
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }
            //SEL3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GENERATE RANDOM ANGKA
                fun rand(start: Int, end: Int): Int {
                    require(start <= end) { "Illegal Argument" }
                    val rand = Random(System.nanoTime())
                    return (start..end).random(rand)
                }
                val start = 0
                val end = 66
                var random = rand(start, end)

                //FUNGSI QUERY
                c = myDbHelper.rawquerySEL("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Sansekerta","Energetic","L"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2) {
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    t_result2.setText(nama1 + " " + nama2 + " " + NAMA_BELAKANG)
                    t_arti.setText(nama1 + " : " + arti1 + "\n" + nama2 + " : " + arti2)
                }
                s_result_nama = t_result2.text as String
                s_result_arti = t_arti.text as String
            }

            else{
                Toast.makeText(this@SecondActivity,"Ada Yang Error", Toast.LENGTH_SHORT)
            }

        }

    }
}
