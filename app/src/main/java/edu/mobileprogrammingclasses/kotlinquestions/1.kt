package edu.mobileprogrammingclasses.kotlinquestions

/**
 * Add necessary parameters to the Person class in order to make the code compile.
 * Deduce them by parameters already present in the code.
 * Use data class to implement an equals function and make the main() function
 * print 'true'.
 */

class Person

fun getPeople(): List<Person> {
  return listOf(Person("Alice", 29), Person("Bob", 31))
}

fun comparePeople(): Boolean {
  val p1 = Person("Alice", 29)
  val p2 = Person("Alice", 29)
  return p1 == p2  // should be true
}

fun main() {
  println(comparePeople())
}
