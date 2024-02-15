package edu.mobileprogrammingclasses.kotlinquestions

/**
 * Currently this program prints
 *   I'm getting created
 *   Program start
 *   1
 * Without changing the main function and using lazy property
 * make it print
 *   Program start
 *   I'm getting created
 *   1
 */
class DataToCreate(val value: Int) {
  init {
    println("I'm getting created")
  }
}

class LazyProperty {
  val lazyValue: DataToCreate = DataToCreate(1)
}

fun main() {
  val prop = LazyProperty()

  println("Program start")

  println(prop.lazyValue.value)
}
