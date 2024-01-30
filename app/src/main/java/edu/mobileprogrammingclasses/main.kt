package edu.mobileprogrammingclasses

fun main() {

  val order = Order(BOX)
  when(order.packType) {
    BOX -> {}
    PALLET -> TODO()
    ENVELOPE -> TODO()
  }
}

data class Order(
  val packType: Int
)

const val BOX = 1
const val PALLET = 2
const val ENVELOPE = 3
const val SOMETHING_ELSE = 4
