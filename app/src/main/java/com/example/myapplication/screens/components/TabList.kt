package com.example.myapplication.screens.components

import androidx.compose.runtime.Composable
import com.example.myapplication.R

@Composable
fun TabList() {
    val tabs = listOf(
        TabItem("Cook", R.drawable.outdoor_grill_24px),
        TabItem("Favorites", R.drawable.favorite_24px),
        TabItem("Manual", R.drawable.manual_icon),
        TabItem("Device", R.drawable.devices_24px),
        TabItem("Preference", R.drawable.preference_24px),
        TabItem("Setting", R.drawable.settings_24px)
    )

    //TODO add tab list
}

data class TabItem(val title:String, val icon: Int)