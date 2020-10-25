import kotlin.collections.setOf

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    buildFeatures {
        viewBinding = true
    }

    androidExtensions{
        features = setOf("parcelize")
    }

    compileSdkVersion(Configuration.Android.compileSdkVersion)
    buildToolsVersion(Configuration.Android.buildToolsVersion)

    defaultConfig {
        applicationId(Configuration.DefaultConfig.applicationId)
        minSdkVersion(Configuration.DefaultConfig.minSdkVersion)
        targetSdkVersion(Configuration.DefaultConfig.targetSdkVersion)
        versionCode(Configuration.DefaultConfig.versionCode)
        versionName(Configuration.DefaultConfig.versionName)
        testInstrumentationRunner(Configuration.DefaultConfig.testInstrumentationRunner)
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
    implementation(project(":common_android"))

    implementation(Libraries.Core.stdlibJdk8)
    implementation(Libraries.Core.stdlib)
    implementation(Libraries.Core.coreKtx)
    implementation(Libraries.Core.appCompat)

    implementation(Libraries.Ui.material)
    implementation(Libraries.Ui.constraintLayout)

    implementation(Libraries.Ui.Navigation.navigationFragment)
    implementation(Libraries.Ui.Navigation.navigationUi)
    kapt(Libraries.Ui.Navigation.navigationSafeArgs)

    implementation(Libraries.Ui.ViewModel.viewModel)

    implementation(Libraries.DaggerHilt.hilt)
    implementation(Libraries.DaggerHilt.viewModel)
    kapt(Libraries.DaggerHilt.hiltCompiler)
    kapt(Libraries.DaggerHilt.viewModelCompiler)

    implementation(platform(Libraries.Core.Google.platformBom))
    implementation(Libraries.Core.Google.crashlyticsKtx)
    implementation(Libraries.Core.Google.analyticsKtx)
    implementation(Libraries.Core.Google.analytics)
    implementation(Libraries.Core.Google.crashlytics)

    testImplementation(Libraries.Test.junit)
    androidTestImplementation(Libraries.Test.extJunit)
    androidTestImplementation(Libraries.Test.espresso)
}

kapt {
    correctErrorTypes = true
}