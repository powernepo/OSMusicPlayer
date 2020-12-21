allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }
}

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
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}