package edu.mobileprogrammingclasses.todo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TodosApiModule {

  @Singleton
  @Provides
  fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
      .addInterceptor(HttpLoggingInterceptor().apply { this.setLevel(HttpLoggingInterceptor.Level.BODY) })
      .build()

  @Singleton
  @Provides
  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

  @Singleton
  @Provides
  fun provideTodosApiService(retrofit: Retrofit): TodosApiService =
    retrofit.create(TodosApiService::class.java)
}
