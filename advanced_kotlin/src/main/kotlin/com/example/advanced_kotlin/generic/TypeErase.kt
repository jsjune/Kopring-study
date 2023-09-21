package com.example.advanced_kotlin.generic


inline fun <reified T> List<*>.hasAnyInstanceOf(): Boolean {
    return this.any { it is T }
}


fun main() {

}
