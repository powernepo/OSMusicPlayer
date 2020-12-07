setOf(
    ":app",
    ":common_android",
    ":data:offline",
    ":device_media"
).forEach {
    include(it)
}

rootProject.name = "OS Music Player"