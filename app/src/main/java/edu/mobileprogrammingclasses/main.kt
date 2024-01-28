package edu.mobileprogrammingclasses

/**
 * Every product has an id.
 * Additionally, book has a number of pages, videogame has requirements and movie has a cast.
 * Each product needs to be passed to the external library as an id and that additional property.
 * Rewrite the code to make in null safe and utilise 'when' statement and sealed classes.
 */

fun main() {

  val products = listOf(
    Product(id = 1, type = PRODUCT_BOOK, numberOfPages = 300),
    Product(id = 2, type = PRODUCT_MOVIE, cast = "actors and such"),
    Product(id = 3, type = PRODUCT_VIDEOGAME, requirements = "Working computer")
  )

  products.forEach { product ->
    if (product.type == PRODUCT_BOOK) {
      handleBook(product.id, product.numberOfPages ?: 0)
    } else if (product.type == PRODUCT_VIDEOGAME) {
      handleVideogame(product.id, product.requirements.orEmpty())
    } else if (product.type == PRODUCT_MOVIE) {
      handleMovie(product.id, product.cast.orEmpty())
    }
  }
}

fun handleBook(id: Int, pages: Int) {}
fun handleVideogame(id: Int, requirements: String) {}

fun handleMovie(id: Int, cast: String) {}


val PRODUCT_BOOK = 0
val PRODUCT_VIDEOGAME = 1
val PRODUCT_MOVIE = 2

class Product(
  val id: Int,
  val type: Int,
  val cast: String? = null,
  val requirements: String? = null,
  val numberOfPages: Int? = null
)
