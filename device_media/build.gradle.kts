plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Configuration.Android.compileSdkVersion)
    buildToolsVersion(Configuration.Android.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Configuration.DefaultConfig.minSdkVersion)
        targetSdkVersion(Configuration.DefaultConfig.targetSdkVersion)
        versionCode(Configuration.DefaultConfig.versionCode)
        versionName(Configuration.DefaultConfig.versionName)

        testInstrumentationRunner(Configuration.DefaultConfig.testInstrumentationRunner)
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(project(":device_content"))

    implementation(Libraries.Room.runtime)
    kapt(Libraries.Room.compile)

    implementation(Libraries.DaggerHilt.hilt)
    kapt(Libraries.DaggerHilt.hiltCompiler)

    implementation(Libraries.Log.timber)
}