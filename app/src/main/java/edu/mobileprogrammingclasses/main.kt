package edu.mobileprogrammingclasses

fun main() {

  val myCat = DomesticCat("Orange", "Mr Fluff")

  val myTiger = Tiger("Tiger")

  val myLion = Lion("Simba")

  val allMyCats = listOf(myCat, myTiger)

  val myModifiedCats = allMyCats.toMutableList().apply { add(myLion) }.toList()


  println("${myTiger.color?.length ?: 0}")

  allMyCats.forEach(Cat::saySomething)

  myModifiedCats.forEach(Cat::saySomething)
}

interface CatsVoice {
  val name: String

  fun saySomething()
}

class Meow(override val name: String) : CatsVoice {

  override fun saySomething() = println("Meow! I'm $name")
}

class Roar(override val name: String): CatsVoice {
  override fun saySomething() = println("Roar! I'm $name")
}

abstract class Cat(
  val color: String? = null,
  override val name: String,
  voice: CatsVoice
): CatsVoice by voice {

  val colorAndName: String = "$color $name"

}

class DomesticCat(color: String = "Black", name: String): Cat(color, name, Meow(name)) {
  lateinit var eyesColor: String

  fun assignCatsEyesColor() {
    eyesColor = "Green"
  }

  fun exampleFunctionWithAnotherFunction(a: Int, func: (Int) -> String): String {
    val anotherValue = func(a + 5)
    return "Result $anotherValue"
  }
}

class Tiger(name: String): Cat(null, name, Roar(name))

class Lion(name: String): Cat("Yellow", name, Roar(name))
