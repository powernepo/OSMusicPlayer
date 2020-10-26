buildscript {
    val kotlin_version by extra("1.4.10")
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
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
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