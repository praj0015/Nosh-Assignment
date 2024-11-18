package com.example.myapplication.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent() {
    var searchInput by remember {
        mutableStateOf("")
    }
    var active by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SearchBar(
            query = searchInput,
            onQueryChange = { searchInput = it},
            onSearch = {active = false},
            active = active,
            onActiveChange = {active = it},
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(top = 8.dp, bottom = 8.dp)
                .border(border = BorderStroke(1.dp, color = Color.Blue), shape = RoundedCornerShape(50)),
            placeholder = {
                Text(
                    "Search for dish or ingredient",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFF282E87)
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null,
                    tint = Color.Blue,
                )
            },
            colors = SearchBarDefaults.colors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerLow,

                )
        ) {

        }
        IconButton(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp),
            onClick = { }
        ) {
            Icon(
                Icons.Outlined.Notifications,
                "notification icon",
                modifier = Modifier
                    .size(24.dp),
                tint = Color(0xFF282E87)
            )
        }
        Image(
            painterResource(R.drawable.power_settings_new_24dp),
            "power setting icon",
            modifier = Modifier
                .size(24.dp),
            colorFilter = ColorFilter.tint(Color(0xFFEB3C3C))
        )
    }
}