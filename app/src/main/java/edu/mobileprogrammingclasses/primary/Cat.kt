package edu.mobileprogrammingclasses.primary

import javax.inject.Inject

interface Cat {
  fun doTheSound(): String
}

class Tiger @Inject constructor(
  @Meow private val meow: String
) : Cat {
  override fun doTheSound(): String = meow

}
