package com.example.myapplication.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.data.model.DishesLocalModel

@Composable
fun WhatsOnYourMind() {

    val dishCategory = listOf(
        DishesLocalModel("Dessert", R.drawable.ic_launcher_background.toString()),
        DishesLocalModel("Indian", R.drawable.indian_dish.toString()),
        DishesLocalModel("Italian", R.drawable.italian.toString()),
        DishesLocalModel("Mexican", R.drawable.mexican.toString()),
        DishesLocalModel("Rice items", R.drawable.rice_dish.toString())
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp)
    ) {
        Text(
            stringResource(R.string.what_on_mind_text),
            modifier = Modifier
                .fillMaxWidth(),
            fontSize = 24.sp,
            color = Color(0xFF282E87),
            fontWeight = FontWeight.SemiBold
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(dishCategory) { dish ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 4.dp)
                        .shadow(
                            elevation = 10.dp,
                            shape = RoundedCornerShape(50),
                            spotColor = Color(0xFFE68737)
                        )
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Image(
                        painter = painterResource(dish.image.toInt()),
                        modifier = Modifier
                            .padding(start = 6.dp, top = 6.dp, bottom = 6.dp)
                            .size(32.dp)
                            .clip(RoundedCornerShape(50)),
                        contentDescription = ""
                    )
                    Text(
                        dish.name,
                        modifier = Modifier
                            .padding(6.dp, end = 8.dp),
                        color = Color(0xFF282E87),
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    WhatsOnYourMind()
}
