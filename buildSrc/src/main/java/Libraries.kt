class Libraries {

    object BuildScript {
        const val gradle = "com.android.tools.build:gradle:4.1.0"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10"
        const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
    }

    object Ui {

        object Versions{
            const val navigation = "2.3.1"
            const val material = "1.2.1"
            const val constraintLayout = "2.0.2"
            const val viewModel = "2.3.0-beta01"
        }

        object Navigation {
            const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
            const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
            const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-generator:${Versions.navigation}"
            const val navigationSafeArgsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
        }

        object ViewModel {
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
        }

        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    object Test {

        object Versions{
            const val junit = "4.13.1"
            const val extJunit = "1.1.2"
            const val expresso = "3.3.0"
        }

        const val junit = "junit:junit:${Versions.junit}"
        const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.expresso}"

    }

    object Core {

        object Versions{
            const val kotlin = "1.4.10"
            const val coreKtx = "1.3.2"
            const val appCompat = "1.2.0"
            const val googleService = "4.3.4"
            const val crashlytics = "2.3.0"
            const val firebaseBom = "25.12.0"
            const val firebase = "17.2.2"
        }

        object Google{
            const val service = "com.google.gms:google-services:${Versions.googleService}"
            const val crashlyticsPlugin = "com.google.firebase:firebase-crashlytics-gradle:${Versions.crashlytics}"
            const val crashlyticsKtx = "com.google.firebase:firebase-crashlytics-ktx"
            const val analyticsKtx = "com.google.firebase:firebase-analytics-ktx"
            const val platformBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
            const val analytics ="com.google.firebase:firebase-analytics:${Versions.firebase}"
            const val crashlytics ="com.google.firebase:firebase-crashlytics:${Versions.firebase}"
        }

        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    }

    object DaggerHilt{

        object Versions{
            const val daggerHilt = "2.28-alpha"
            const val viewModelHilt = "1.0.0-alpha02"
        }

        const val hilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
        const val viewModelCompiler = "androidx.hilt:hilt-compiler:${Versions.viewModelHilt}"
        const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.viewModelHilt}"
    }
}