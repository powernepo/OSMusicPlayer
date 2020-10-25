buildscript {
    repositories {
        maven { url = uri("https://jitpack.io") }
        google()
        jcenter()
    }
    dependencies {
        classpath(Libraries.BuildScript.gradle)
        classpath(Libraries.BuildScript.kotlinGradlePlugin)
        classpath(Libraries.BuildScript.hiltAndroidGradlePlugin)
        classpath(Libraries.Ui.Navigation.navigationSafeArgsPlugin)
        classpath(Libraries.Core.Google.crashlyticsPlugin)
        classpath(Libraries.Core.Google.service)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}