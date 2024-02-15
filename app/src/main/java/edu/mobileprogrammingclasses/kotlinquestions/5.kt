package edu.mobileprogrammingclasses.kotlinquestions

/**
 * Use a loop to print non-null names of districts and streets.
 * Use null-safe operators to skip null values.
 * Expected output is:
 * District 1
 * District 2
 * Street1
 * Street2
 */
data class Street(val name: String)

data class District(val name: String, val streets: List<Street?>?)

data class City(val name: String, val districts: List<District?>)

fun main() {

}
