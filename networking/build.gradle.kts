plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.google.ksp)
}

android {
    namespace = "com.ppereira.networking"
    compileSdk = 35

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    api(libs.jetbrains.stdlib.jdk8)
    api(libs.square.retrofit.main)
    api(libs.square.retrofit.moshi)
    api(libs.square.okhttp.core)
    api(libs.square.moshi.kotlin)
    api(libs.square.okhttp.logging)
    api(libs.square.timber)
    api(libs.android.koin)
    api(libs.android.coil.http)

    ksp(libs.square.moshi.codegen)
}