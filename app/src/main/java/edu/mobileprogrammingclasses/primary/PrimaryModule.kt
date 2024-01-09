package edu.mobileprogrammingclasses.primary

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.mobileprogrammingclasses.R
import javax.inject.Named
import javax.inject.Qualifier

@InstallIn(SingletonComponent::class)
@Module
abstract class PrimaryModule {

  @Binds
  abstract fun bindTigerToCat(tiger: Tiger): Cat

  companion object {

    @Provides
    @FirstString
    fun provideFirstString(@ApplicationContext context: Context): String =
      context.resources.getString(R.string.first)

    @Provides
    @SecondString
    fun provideSecondString(@ApplicationContext context: Context): String =
      context.resources.getString(R.string.second)

    @Provides
    @Meow
    fun provideMeow(@ApplicationContext context: Context): String =
      context.resources.getString(R.string.meow)
  }
}

@Qualifier
annotation class FirstString

@Qualifier
annotation class SecondString

@Qualifier
annotation class Meow
