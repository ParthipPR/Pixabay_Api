package com.Parthip.pixabay.utils

/**
 * @author Android Devs Academy (Ahmed Guedmioui)
 */
sealed class Screen(val rout: String) {
    object Home : Screen("main")
    object Details : Screen("details")
}