package com.example.myapplication.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.myapplication.data.model.DishesLocalModel
import com.example.noshassignment.viewModel.MainViewModel

@Composable
fun Recommendation(showDialog : () -> Unit, onDishClick : (DishesLocalModel) -> Unit) {

    val viewModel = MainViewModel()
    val dishesList = viewModel.list.observeAsState().value

    Column(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, bottom = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Recommendations",
                fontSize = 24.sp,
                color = Color(0xFF282E87),
                fontWeight = FontWeight.SemiBold
            )
            Text(
                "Show all",
                fontSize = 12.sp,
                color = Color(0xFF282E87)
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
        ) {
            if(!dishesList.isNullOrEmpty()) {
                items(dishesList) { dish ->
                    Card(
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp), spotColor = Color.Yellow)
                            .wrapContentHeight(),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFFFFFFF)
                        ),
                        onClick = {
                            showDialog.invoke()
                            onDishClick(dish)
                        }
                    ) {
                        Column(
                            modifier = Modifier
                                .wrapContentHeight(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Card(
                                modifier = Modifier
                                    .fillParentMaxSize()
                                    .padding(4.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color.Gray)
                            ) {
                                AsyncImage(
                                    model = dish.image,
                                    contentDescription = "Dishes Image",
                                    modifier = Modifier
                                        .size(80.dp)
                                        .clip(RoundedCornerShape(50))
                                )
                            }
                            Text(
                                dish.name,
                                textAlign = TextAlign.Center,
                                color = Color(0xFF282E87),
                                fontSize = 16.sp
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    "30 min",
                                    modifier = Modifier
                                        .padding(start = 4.dp, end = 4.dp),
                                    fontSize = 12.sp,
                                    color = Color(0xFF8A92BE)
                                )
                                Spacer(
                                    modifier = Modifier
                                        .size(3.dp)
                                        .background(
                                            shape = CircleShape,
                                            color = Color(0xFF8A92BE)
                                        )
                                )
                                Text(
                                    "Medium prep.",
                                    modifier = Modifier
                                        .padding(start = 4.dp),
                                    fontSize = 12.sp,
                                    color = Color(0xFF8A92BE)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RecommendationsPreview() {
    Recommendation(showDialog = { true }, { })
}