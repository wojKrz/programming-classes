package edu.mobileprogrammingclasses.data

import javax.inject.Inject

interface Cat {
  fun doSound(): String
}

class Tiger @Inject constructor() : Cat {
  override fun doSound(): String = "Roar"
}

class DomesticCat @Inject constructor(
  private val name: String
) : Cat {
  override fun doSound(): String = "Meow, I'm $name"
}

class Lion @Inject constructor() : Cat {
  override fun doSound(): String = "Roar but not like a tiger"

}
