package com.example.e_commercetestapplication.presentation.ui.componenet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.e_commercetestapplication.R

@Composable
fun AppBar(
    counter : Int,
    onCartIconClick: () -> Unit
) {

            ConstraintLayout {
                val (notification, notificationCounter) = createRefs()

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFFF9F81))
                        .constrainAs(notification) {}
                        .clickable {
                            onCartIconClick()
                        },

                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cart_icon),
                        contentDescription = "Notification Icon"
                    )

                }
                //Cart count
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(color = Color.Red, shape = CircleShape)
                        .padding(3.dp)
                        .constrainAs(notificationCounter) {
                            top.linkTo(notification.top)
                            end.linkTo(notification.end)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = counter.toString(), fontSize = 11.sp, color = Color.White)
                }

            }




}