package com.powernepo.device_content.generator

interface ContentGenerator<T> {
    fun generate() : List<T>
}