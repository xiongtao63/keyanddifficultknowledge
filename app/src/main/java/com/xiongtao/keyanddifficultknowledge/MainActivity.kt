package com.xiongtao.keyanddifficultknowledge

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tencent.mmkv.MMKV
import java.security.Provider
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var mmkv: MMKV
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences  = getSharedPreferences("test", MODE_PRIVATE)
        MMKV.initialize(filesDir.absolutePath + "/mmkv_2")
        mmkv = MMKV.defaultMMKV()
    }

    private fun testMMKV() {
        Log.e("MMKV","SharedPreferences开始写入")
        val edit = sharedPreferences.edit()
        val start = System.currentTimeMillis()
        for (i in 1..3000) {
            edit.putInt(i.toString(),Random(3000).nextInt()).commit()
        }
        val end = System.currentTimeMillis()
        Log.e("MMKV","SharedPreferences耗时====${end-start}ms")

    }

    private fun testSharedPreferences() {
        Log.e("MMKV","mmkv开始写入")
        val start = System.currentTimeMillis()
        for (i in 1..3000) {
            mmkv.putInt(i.toString(),Random(3000).nextInt())
        }
        val end = System.currentTimeMillis()
        Log.e("MMKV","mmkv耗时====${end-start}ms")

    }

    fun test(view: android.view.View) {
        testSharedPreferences()
        testMMKV()
    }
}