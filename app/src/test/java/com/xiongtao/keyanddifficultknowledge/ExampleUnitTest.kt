package com.xiongtao.keyanddifficultknowledge

import android.util.Log
import org.junit.Test

import org.junit.Assert.*
import java.io.FileInputStream
import java.io.FileOutputStream

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
//    @Test
//    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)
//    }

    @Test
    public fun testFileIO() {

        val fis = FileInputStream("F:\\Download\\kougou\\kugou.exe")
        val fos = FileOutputStream("F:\\Download\\kougou\\kugou1.exe")
        var len = 0
        val buffer = ByteArray(4096)
        while ((fis.read(buffer).also { len = it }) != -1) {
            fos.write(buffer, 0, len)
        }
        fis.close()
        fos.close()


    }

    @Test
    public fun testFileChannerl() {

        val inChannel = FileInputStream("F:\\Download\\kougou\\kugou.exe").channel
        val outChannel = FileOutputStream("F:\\Download\\kougou\\kugou2.exe").channel

        outChannel.transferFrom(inChannel, 0, inChannel.size())
        inChannel.close()
        outChannel.close()


    }
}