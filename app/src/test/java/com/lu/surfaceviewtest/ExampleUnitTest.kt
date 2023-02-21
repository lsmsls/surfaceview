package com.lu.surfaceviewtest

import android.util.Log
import org.junit.Test

import org.junit.Assert.*
import java.io.File

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        var dir = File("d:\\testDir")
//        if(!dir.exists()){
//            dir.mkdir();
//        }
//       var file = File("d:\\testDir\\fff3.txt")
//        if(!file.exists()){
//            file.createNewFile()
//        }
//
//        println("path:" + file.absolutePath)
//        var file = File("d:\\projects\\")
//        if(file.exists()){
//            val listFiles = file.listFiles()
//            listFiles.forEach {
//                println(it)
//            }
//        }

        var file1 = File("hello.txt");
        file1 = File("hello1.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        var file2 = File("d:\\io");
        file2 =  File("d:\\io1");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());

    }
}