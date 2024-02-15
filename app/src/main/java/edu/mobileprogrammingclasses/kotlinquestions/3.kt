package edu.mobileprogrammingclasses.kotlinquestions

/**
 * Change the declaration of the foo function in a way that makes the code using foo compile (no red errors).
 * Use default and named arguments.
 */

fun foo(name: String, number: Int, toUpperCase: Boolean) =
  (if (toUpperCase) name.uppercase() else name) + number

fun useFoo() = listOf(
  foo("a"),
  foo("b", number = 1),
  foo("c", toUpperCase = true),
  foo(name = "d", number = 2, toUpperCase = true)
)