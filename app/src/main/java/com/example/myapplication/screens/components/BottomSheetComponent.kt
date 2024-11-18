package com.example.myapplication.screens.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("InvalidColorHexValue")
@Composable
fun DialogComponent(
    onDismissRequest : () -> Unit
) {

    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = false,
    )

    BottomSheetScaffold(
        sheetSwipeEnabled = true,
        scaffoldState = rememberBottomSheetScaffoldState(),
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        stringResource(R.string.cooking_time_text),
                        color = Color(0xFF282E87),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                    IconButton(
                        modifier = Modifier
                            .scale(0.5f)
                            .background(color = Color.LightGray, shape = RoundedCornerShape(50)),
                        onClick = {
                            onDismissRequest.invoke()
                        }) {
                        Icon(
                            Icons.Filled.Close,
                            "Close Icon",
                            modifier = Modifier
                                .size(24.dp),
                            tint =  Color(0xFF282E87)
                        )
                    }
                }
                TimeInput(
                    timePickerState
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        stringResource(R.string.delete_text),
                        color = Color(0xFFEE5F5F),
                        fontSize = 12.sp,
                        textDecoration = TextDecoration.Underline
                    )
                    Button(
                        modifier = Modifier
                            .wrapContentHeight(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        border = BorderStroke(1.dp, Color(0xFFE68737)),
                        shape = RoundedCornerShape(30),
                        onClick = {
                            onDismissRequest.invoke()
                        }
                    ) {
                        Text(
                            stringResource(R.string.reschedule_text),
                            color = Color(0xFFE68737)
                        )
                    }
                    Button(
                        modifier = Modifier
                            .wrapContentSize(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE68737)
                        ),
                        shape = RoundedCornerShape(30),
                        onClick = {
                            onDismissRequest.invoke()
                        }
                    ) {
                        Text(
                            stringResource(R.string.cook_now_text),
                            color = Color.White
                        )
                    }
                }
            }
        },
        sheetPeekHeight = 0.dp
    ) {

    }
}

@Preview
@Composable
fun DialogPreview() {
    DialogComponent { true }
}