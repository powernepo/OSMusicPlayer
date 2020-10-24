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