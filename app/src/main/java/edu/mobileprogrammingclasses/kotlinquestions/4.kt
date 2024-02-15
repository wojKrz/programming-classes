package edu.mobileprogrammingclasses.kotlinquestions

/**
 * Put a 'map' function in a call chain to make program print
 * list of numbers multiplied by 3.
 */

fun main() {
  listOf(1,2,4,6,8)
    .apply {
      println(this)
    }
}
