plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.middlexmlhoroscopo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.middlexmlhoroscopo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.example.middlexmlhoroscopo.CustomTestRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue("string", "AppName", "Horoscopo")
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }
        getByName("debug") {
            isDebuggable = true
            resValue("string", "AppName", "[DEBUG]Horoscopo")
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    /*retrofit*/
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    /*navigation component*/
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    /*dagger hilt*/
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    /*Interceptor*/
    implementation(libs.logging.interceptor)

    /*CameraX*/
    implementation(libs.androidx.camera.core)
    implementation(libs.androidx.camera.camera2)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.view)
    implementation(libs.androidx.camera.extensions)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    /*Unit Tests*/
    testImplementation(libs.junit)
    testImplementation(libs.kotlintest.runner.junit5)
    testImplementation(libs.mockk)

    /*Ui Tests*/
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
    androidTestImplementation(libs.androidx.espresso.contrib)
    androidTestImplementation(libs.androidx.espresso.intents)
    androidTestImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.androidx.fragment.testing)
    kaptAndroidTest(libs.hilt.android.compiler)
}

