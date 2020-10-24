class Libraries {
    object Ui {
        object Navigation {
            const val navigationUi = "androidx.navigation:navigation-ui-ktx:2.3.1"
            const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:2.3.1"
        }

        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.2"
        const val material = "com.google.android.material:material:1.2.1"
    }

    object Test {
        const val junit = "junit:junit:4.13.1"
        const val extJunit = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }

    object Core {
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        const val coreKtx = "androidx.core:core-ktx:1.3.2"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:1.4.10"
        const val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.10"
    }

    object DaggerHilt{
        const val hilt = "com.google.dagger:hilt-android:2.28-alpha"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:2.28-alpha"
    }
}