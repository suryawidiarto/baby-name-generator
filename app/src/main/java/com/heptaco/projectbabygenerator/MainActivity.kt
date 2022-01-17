package com.heptaco.projectbabygenerator

import android.content.Intent
import android.database.Cursor
import android.database.SQLException
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.heptaco.projectbabygenerator.SliderItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.news.*
import java.io.IOException
import java.util.ArrayList
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var c: Cursor? = null
    lateinit var option: Spinner
    lateinit var option2: Spinner
    lateinit var option3: Spinner
    lateinit var PERSONALITY:String
    var JENIS_KELAMIN: String = "P"
    lateinit var ASAL:String
    lateinit var NAMA_BELAKANG:String
    lateinit var KATA:String

    private lateinit var viewPager2: ViewPager2
    private val sliderHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //FUNGSI BUTTON UTAMA (DATABASE)
        (findViewById<View>(R.id.button01) as Button).setOnClickListener {
            val myDbHelper = DBHelperTest(this@MainActivity)
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
            if(ASAL == "Eropa" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                c = myDbHelper.rawqueryERP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Romantic","P"))
                if (c!!.moveToPosition(random)) {
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ERP3
            else if(ASAL == "Eropa" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                c = myDbHelper.rawqueryERP("SELECT * FROM tb_data WHERE asal = ? AND personality = ? AND jenis_kelamin = ?",
                    arrayOf("Eropa","Romantic","P"))
                if (c!!.moveToPosition(random)) {
                    var nama1 = c!!.getString(1)
                    var arti1 = c!!.getString(5)
                    random = rand(start, end)
                    c!!.moveToPosition(random)
                    var nama2 = c!!.getString(1)
                    var arti2 = c!!.getString(5)
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)

                }
            }
            //ERL2
            else if(ASAL == "Eropa" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ERL3
            else if(ASAL == "Eropa" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }

            //ECP2
            else if(ASAL == "Eropa" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ECP3
            else if(ASAL == "Eropa" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //ECL2
            else if(ASAL == "Eropa" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ECL3
            else if(ASAL == "Eropa" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //ESP2
            else if(ASAL == "Eropa" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ESP3
            else if(ASAL == "Eropa" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //ESL2
            else if(ASAL == "Eropa" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ESL3
            else if(ASAL == "Eropa" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //EEP2
            else if(ASAL == "Eropa" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //EEP3
            else if(ASAL == "Eropa" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //EEL2
            else if(ASAL == "Eropa" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //EEL3
            else if(ASAL == "Eropa" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }

            //START INDONESIA
            //IRP2
            else if(ASAL == "Indonesia" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //IRP3
            else if(ASAL == "Indonesia" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)

                }
            }
            //IRL2
            else if(ASAL == "Indonesia" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //IRL3
            else if(ASAL == "Indonesia" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }

            //ICP2
            else if(ASAL == "Indonesia" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ICP3
            else if(ASAL == "Indonesia" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //ICL2
            else if(ASAL == "Indonesia" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ICL3
            else if(ASAL == "Indonesia" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //ISP2
            else if(ASAL == "Indonesia" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ISP3
            else if(ASAL == "Indonesia" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //ISL2
            else if(ASAL == "Indonesia" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ISL3
            else if(ASAL == "Indonesia" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //IEP2
            else if(ASAL == "Indonesia" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //IEP3
            else if(ASAL == "Indonesia" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //IEL2
            else if(ASAL == "Indonesia" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //IEL3
            else if(ASAL == "Indonesia" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }

            //START ARAB
            //ARP2
            else if(ASAL == "Arab" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ARP3
            else if(ASAL == "Arab" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)

                }
            }
            //ARL2
            else if(ASAL == "Arab" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ARL3
            else if(ASAL == "Arab" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }

            //ACP2
            else if(ASAL == "Arab" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ACP3
            else if(ASAL == "Arab" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //ACL2
            else if(ASAL == "Arab" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ACL3
            else if(ASAL == "Arab" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //ASP2
            else if(ASAL == "Arab" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ASP3
            else if(ASAL == "Arab" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //ASL2
            else if(ASAL == "Arab" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //ASL3
            else if(ASAL == "Arab" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //AEP2
            else if(ASAL == "Arab" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //AEP3
            else if(ASAL == "Arab" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //AEL2
            else if(ASAL == "Arab" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //AEL3
            else if(ASAL == "Arab" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //START SANSEKERTA
            //SRP2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //SRP3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)

                }
            }
            //SRL2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //SRL3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Romantic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }

            //SCP2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //SCP3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Creative" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //SCL2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //SCL3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Creative" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //SSP2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //SSP3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //SSL2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //SSL3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Supportive" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //SEP2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //SEP3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "P" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }
            //SEL2
            else if(ASAL == "Sansekerta" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "2"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    var hasil = (c!!.getString(1) +" "+ NAMA_BELAKANG)
                    var artiPindah = (c!!.getString(5))
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPertama = (c!!.getString(1))
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti", artiPindah)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pertama", namaPertama)
                    startActivity(intent)
                }
            }
            //SEL3
            else if(ASAL == "Sansekerta" && PERSONALITY == "Energetic" && JENIS_KELAMIN == "L" && KATA == "3"){

                //FUNGSI GET NAMA BELAKANG
                NAMA_BELAKANG = t_nama_belakang.text.toString()

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
                    while (nama1 == nama2){
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama1 = c!!.getString(1)
                        arti1 = c!!.getString(5)
                        random = rand(start, end)
                        c!!.moveToPosition(random)
                        nama2 = c!!.getString(1)
                        arti2 = c!!.getString(5)
                    }
                    var hasil = nama1 +" "+ nama2 +" "+ NAMA_BELAKANG
                    var personalityPindah = PERSONALITY
                    var asalPindah = ASAL
                    var kataPindah = KATA
                    var jenis_kelaminPindah = JENIS_KELAMIN
                    var namabelakangPindah = NAMA_BELAKANG
                    var namaPindah1 = nama1
                    var namaPindah2 = nama2
                    var artiPindah1 = arti1
                    var artiPindah2 = arti2
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    intent.putExtra("Hasil", hasil)
                    intent.putExtra("Arti1", artiPindah1)
                    intent.putExtra("Arti2", artiPindah2)
                    intent.putExtra("Personality", personalityPindah)
                    intent.putExtra("Asal", asalPindah)
                    intent.putExtra("Kata", kataPindah)
                    intent.putExtra("Jenis_kelamin", jenis_kelaminPindah)
                    intent.putExtra("Nama_belakang", namabelakangPindah)
                    intent.putExtra("Nama_pindah1", namaPindah1)
                    intent.putExtra("Nama_pindah2", namaPindah2)
                    startActivity(intent)
                }
            }

            else{
                Toast.makeText(this@MainActivity,"Ada Yang Error", Toast.LENGTH_SHORT)
            }

        }

        //Back End Spinner1 (PERSONALITY)
        option = findViewById(R.id.btn_spinner) as Spinner

        val options = arrayOf("Creative","Romantic","Supportive", "Energetic")

        option.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                PERSONALITY = options.get(position)
            }

        }

        //Back End Spinner2 (ASAL)
        option2 = findViewById(R.id.btn_spinner2) as Spinner

        val options2 = arrayOf("Arab","Eropa","Sansekerta", "Indonesia")

        option2.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options2)

        option2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                ASAL = options2.get(position)
            }

        }

        //Back End Spinner3 (KATA)
        option3 = findViewById(R.id.btn_spinner3) as Spinner

        val options3 = arrayOf("2","3")

        option3.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options3)

        option3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                KATA = options3.get(position)
            }

        }
        //Back End Switch
        btn_switch.setOnCheckedChangeListener(){CompoundButton, onSwitch ->
            if(onSwitch){
                JENIS_KELAMIN = "L"
                t_textswitch.setText("Laki-Laki")
            }
            else{
                JENIS_KELAMIN = "P"
                t_textswitch.setText("Perempuan")
            }
        }

        //BACK END SLIDE 2
        //Back End Image Slider
        viewPager2 = findViewById(R.id.viewpager)
        val sliderItems: MutableList<SliderItem> = ArrayList()
        sliderItems.add(SliderItem(R.drawable.main1))
        sliderItems.add(SliderItem(R.drawable.main2))
        sliderItems.add(SliderItem(R.drawable.main3))
        sliderItems.add(SliderItem(R.drawable.main4))
        sliderItems.add(SliderItem(R.drawable.main5))

        viewPager2.setAdapter(SliderAdapter(sliderItems, viewPager2))
        viewPager2.setClipToPadding(false)
        viewPager2.setClipChildren(false)
        viewPager2.setOffscreenPageLimit(3)
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        viewPager2.setPageTransformer(compositePageTransformer)
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })



        //Back End ListView
        var listview = findViewById<ListView>(R.id.listView)

        var list = mutableListOf<ListData>()

        list.add(ListData("10 New Normal Starter Pack yang Wajib Ibu Hamil Bawa","By : Prenagen",R.drawable.berita1))
        list.add(ListData("6 Rekomendasi Merek Vitamin untuk Ibu Hamil Muda Beserta Harganya","By : PopMama",R.drawable.berita2))
        list.add(ListData("Kehamilan Lebih Menyenangkan di Fase The New Normal, Apa yang Sebaiknya Dilakukan?","By : The Asiant Parent",R.drawable.berita3))
        list.add(ListData("Tips Agar Mudik Saat Hamil Tetap Sehat dan Menyenangkan","By : Prenagen",R.drawable.berita4))
        list.add(ListData("Ingin Bersepeda saat Hamil? Simak 10 Tips Ini Agar Aman dan Nyaman","By : The Asian Parent",R.drawable.berita5))
        list.add(ListData("5 Tips Persiapan Menyusui Sejak Masa Kehamilan","By : Prenagen",R.drawable.berita6))
        list.add(ListData("Terkenal Paling Unggul, Ini Pola Asuh Anak Generasi Alpha","By : PopMama",R.drawable.berita7))
        list.add(ListData("Supaya Cepat Melahirkan, Lakukan 13 Gerakan dan Posisi Ini!","By : Prenagen",R.drawable.berita8))
        list.add(ListData("10 Ide Menu MPASI Variatif untuk Bayi 6 Bulan","By : PopMama",R.drawable.berita9))
        list.add(ListData("Cara Mengeluarkan Dahak pada Bayi dengan Aman","By : Prenagen",R.drawable.berita10))


        listview.adapter = ListDataAdapter(this@MainActivity,R.layout.listbaris_tester,list)

        listview.setOnItemClickListener { parent:AdapterView<*>, view:View, position:Int, id:Long ->
            if (position == 0){
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.prenagen.com/id/new-normal-starter-pack-bumil"))
                startActivity(i)
            }
            else if(position == 1){
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.popmama.com/pregnancy/first-trimester/fx-dimas-prasetyo/rekomendasi-merek-vitamin-untuk-ibu-hamil-muda-beserta-harganya"))
                startActivity(i)
            }
            else if(position == 2){
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://id.theasianparent.com/hamil-saat-new-normal"))
                startActivity(i)
            }
            else if(position == 3){
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.prenagen.com/id/tips-agar-mudik-saat-hamil-tetap-sehat-dan-menyenangkan"))
                startActivity(i)
            }
            else if(position == 4){
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://id.theasianparent.com/tips-bersepeda-saat-hamil"))
                startActivity(i)
            }
            else if(position == 5){
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.prenagen.com/id/5-tips-persiapan-menyusui-sejak-masa-kehamilan"))
                startActivity(i)
            }
            else if(position == 6){
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.popmama.com/big-kid/6-9-years-old/ninda/pola-asuh-anak-generasi-alpha"))
                startActivity(i)
            }
            else if(position == 7){
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.prenagen.com/id/cara-agar-supaya-cepat-melahirkan"))
                startActivity(i)
            }
            else if(position == 8){
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.popmama.com/baby/0-6-months/sarrah-ulfah/ide-menu-mpasi-variatif-untuk-bayi-6-bulan-beserta-resepnya"))
                startActivity(i)
            }
            else if(position == 9){
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.prenagen.com/id/cara-mengeluarkan-dahak-pada-bayi"))
                startActivity(i)
            }

        }
    }

    //Back End Image Slide
    private val sliderRunnable =
        Runnable { viewPager2!!.currentItem = viewPager2!!.currentItem + 1 }

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, 3000)
    }

}