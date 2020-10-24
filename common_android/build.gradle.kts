plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        minSdkVersion(Configuration.DefaultConfig.minSdkVersion)
        targetSdkVersion(Configuration.DefaultConfig.targetSdkVersion)
        versionCode(Configuration.DefaultConfig.versionCode)
        versionName(Configuration.DefaultConfig.versionName)

        testInstrumentationRunner(Configuration.DefaultConfig.testInstrumentationRunner)
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release"){
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
    implementation(Libraries.Core.appCompat)

}