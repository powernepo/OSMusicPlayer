setOf(
    ":app",
    ":common_android",
    ":data:offline",
    ":device_media",
    ":device_content"
).forEach {
    include(it)
}

rootProject.name = "OS Music Player"