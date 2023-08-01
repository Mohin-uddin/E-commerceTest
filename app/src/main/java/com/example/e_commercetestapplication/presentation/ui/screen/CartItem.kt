package com.example.e_commercetestapplication.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.e_commercetestapplication.data.remote.ProductItem

@Composable
fun CartItem (productItem: ProductItem){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(productItem.image),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .background(Color(0x8DB3B0B0), shape = RoundedCornerShape(10.dp))
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Column() {
            Text(
                text = productItem.title,
                fontWeight = FontWeight(700),
                fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row() {
                Text(
                    text = productItem.price.toString(),
                    color = Color.Magenta,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "  x${productItem.counter}", color = Color.Black)
            }
        }
    }

}