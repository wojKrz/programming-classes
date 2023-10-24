// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  id("com.android.application") version "8.1.2" apply false
  id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

buildscript {
  repositories {
    google()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:4.1.3")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
    val nav_version = "2.7.4"
    classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
  }
}