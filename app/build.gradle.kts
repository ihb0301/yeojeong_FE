import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

fun getApiKey(key: String): String {
    return gradleLocalProperties(rootDir, providers).getProperty(key)
}

android {
    namespace = "com.example.yeojeong"
    compileSdk = 35

    viewBinding.isEnabled = true

    defaultConfig {
        manifestPlaceholders["GOOGLE_MAP_API_KEY"] = getApiKey("GOOGLE_MAP_API_KEY")
        buildConfigField("String","GOOGLE_MAP_API_KEY","\""+getApiKey("GOOGLE_MAP_API_KEY")+"\"")
        applicationId = "com.example.yeojeong"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation(libs.play.services.maps)
    implementation("com.google.maps.android:android-maps-utils:3.8.0")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}