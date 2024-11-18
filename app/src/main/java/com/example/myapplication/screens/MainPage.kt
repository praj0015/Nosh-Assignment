package com.example.myapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.data.model.DishesLocalModel
import com.example.myapplication.screens.components.ButtonComponents
import com.example.myapplication.screens.components.DialogComponent
import com.example.myapplication.screens.components.Recommendation
import com.example.myapplication.screens.components.TopBarComponent
import com.example.myapplication.screens.components.WhatsOnYourMind
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {

    var selectedDish by remember { mutableStateOf<DishesLocalModel?>(
        value = null
    ) }
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()

    var showDialog by remember { mutableStateOf(false) }

    when {
        bottomSheetScaffoldState.bottomSheetState.isVisible -> {
            DialogComponent(onDismissRequest = { showDialog = false })
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TopBarComponent()
        WhatsOnYourMind()
        Recommendation(showDialog = {
            scope.launch {
                bottomSheetScaffoldState.bottomSheetState.show()
            }
        }, onDishClick = {dish -> selectedDish = dish})
        ButtonComponents()
    }
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    MainPage()
}