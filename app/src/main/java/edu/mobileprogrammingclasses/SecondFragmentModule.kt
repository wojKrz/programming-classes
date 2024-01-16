package edu.mobileprogrammingclasses

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.mobileprogrammingclasses.data.Cat
import edu.mobileprogrammingclasses.data.DomesticCat
import edu.mobileprogrammingclasses.data.Lion
import edu.mobileprogrammingclasses.data.Tiger
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
abstract class SecondFragmentModule {

  @Binds
  abstract fun bindCat(tiger: Lion): Cat

  companion object {
    @Provides
    @PlainCat
    fun providePlainCat(): DomesticCat = DomesticCat("Just cat")

    @Provides
    @FancyCat
    fun provideFancyCat(): DomesticCat = DomesticCat("Mr Fluff")
  }
}

@Qualifier
annotation class PlainCat

@Qualifier
annotation class FancyCat
