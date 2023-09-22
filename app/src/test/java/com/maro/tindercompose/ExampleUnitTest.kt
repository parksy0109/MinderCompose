package com.maro.tindercompose

import org.junit.Test

import org.junit.Assert.*
import java.util.LinkedList
import java.util.Queue

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        var data: Queue<String> = LinkedList()
        data.add("1")
        data.add("2")
        data.add("3")

        println(data.map { it }.joinToString(","))
    }
}