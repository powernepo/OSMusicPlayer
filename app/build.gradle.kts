plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        applicationId("com.powernepo.osmusicplayer")
        minSdkVersion(22)
        targetSdkVersion(30)
        versionCode(1)
        versionName("1.0")
        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildTypes {
        getByName("release"){
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

    implementation(Libraries.Core.stdlibJdk8)
    implementation(Libraries.Core.stdlib)
    implementation(Libraries.Core.coreKtx)
    implementation(Libraries.Core.appCompat)

    implementation(Libraries.Ui.material)
    implementation(Libraries.Ui.constraintLayout)

    implementation(Libraries.Ui.Navigation.navigationFragment)
    implementation(Libraries.Ui.Navigation.navigationUi)

    implementation(Libraries.DaggerHilt.hilt)
    kapt(Libraries.DaggerHilt.hiltCompiler)

    testImplementation(Libraries.Test.junit)
    androidTestImplementation(Libraries.Test.extJunit)
    androidTestImplementation(Libraries.Test.espresso)
}