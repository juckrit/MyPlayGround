package com.example.myplayground.navigation

import android.net.Uri
import androidx.navigation.*

class NavManager constructor() {
    private var navEventListener: ((navDirections: NavDirections, extra: Navigator.Extras?) -> Unit)? =
        null
    private var navUp: (() -> Unit)? = null
    private var navUri: ((uri: Uri) -> Unit)? = null

    fun navigate(navDirections: NavDirections, extra: Navigator.Extras? = null) {
        navEventListener?.invoke(navDirections, extra)
    }

    fun setOnNavEvent(navEventListener: (navDirections: NavDirections, extra: Navigator.Extras?) -> Unit) {
        this.navEventListener = navEventListener
    }

    fun buttonNavUp() {
        navUp?.invoke()
    }

    fun setOnNavUp(navUp: (() -> Unit)) {
        this.navUp = navUp
    }

    fun navigate(uri: Uri) {
        navUri?.invoke(uri)
    }

    fun setOnNavUri(navUri: ((uri: Uri) -> Unit)) {
        this.navUri = navUri
    }

    private val mBackStackField by lazy {
        val field = NavController::class.java.getDeclaredField("mBackStack")
        field.isAccessible = true
        field
    }

    fun popToRoot(navController: NavController) {
        val arrayDeque =
            mBackStackField.get(navController) as java.util.ArrayDeque<NavBackStackEntry>
        val graph = arrayDeque.first.destination as NavGraph
        val rootDestinationId = graph.startDestination

        val navOptions = NavOptions.Builder()
            .setPopUpTo(rootDestinationId, false)
            .build()

        navController.navigate(rootDestinationId, null, navOptions)
    }
}