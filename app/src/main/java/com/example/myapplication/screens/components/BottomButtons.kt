package com.example.myapplication.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
fun ButtonComponents() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier
                .padding(end = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE68737)
            ),
            shape = RoundedCornerShape(30),
            onClick = { }
        ) {
            Text(
                stringResource(R.string.explore_all_dishes_text),
                color = Color.White
            )
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE68737)
            ),
            shape = RoundedCornerShape(30),
            onClick = { }
        ) {
            Text(
                stringResource(R.string.what_to_cook_text),
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun ButtonComponentPreview() {
    ButtonComponents()
}