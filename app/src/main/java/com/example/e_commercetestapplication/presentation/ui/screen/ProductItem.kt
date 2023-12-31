package com.example.e_commercetestapplication.presentation.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.e_commercetestapplication.data.remote.ProductItem

@Composable
fun ProductItem(product: ProductItem,clickItem : (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .padding(20.dp)
            .clickable {
                clickItem(true)
            }
    ) {

        Image(
            painter = rememberAsyncImagePainter(product.image),
            contentDescription = "",
            modifier = Modifier.size(128.dp)
        )
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(
                text = product.title,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.heightIn(10.dp))
            Text(text = product.description,
                color = Color.Gray,
                maxLines = 2
            )
        }

        Box(modifier = Modifier
            .height(20.dp)
            .width(20.dp)
            .padding(4.dp)
            .aspectRatio(1f)
            .background( color = colorCode(product.productStatus), shape = CircleShape)
        )


    }

}

fun colorCode(productStatus: String): Color {
    var selectColor = Color.Green
    when(productStatus){
        "Available" ->{
            selectColor = Color.Green
        }
        "StockOut" ->{
            selectColor = Color.Red
        }
        "Coming Soon"->{
            selectColor = Color.Blue
        }
    }
    return selectColor
}
