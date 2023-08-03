package com.example.e_commercetestapplication.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commercetestapplication.R
import com.example.e_commercetestapplication.presentation.ui.MainViewModel

@Composable
fun CartScreen(viewModel: MainViewModel,
               popBack: () -> Unit
) {
    Box{
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp, top = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        popBack()
                    },
                    modifier = Modifier
                        .background(color = Color(0xFFB4B4B4), shape = CircleShape)
                        .clip(CircleShape)

                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_back),
                        contentDescription = "BACK TO HOME"
                    )
                }

                Text(
                    text = "CART",
                    fontSize = 20.sp,
                    color = Color(0xFF000000),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 25.dp)
                )


            }
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)) {
                items(viewModel.cartListLItem.value) { product ->
                    CartItem(product)
                }
            }
        }


    }
}