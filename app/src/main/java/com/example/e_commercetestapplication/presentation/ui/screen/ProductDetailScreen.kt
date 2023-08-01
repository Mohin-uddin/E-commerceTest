package com.example.e_commercetestapplication.presentation.ui.screen


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.e_commercetestapplication.R
import com.example.e_commercetestapplication.presentation.ui.MainViewModel

@Composable
fun productDetailScreen(
    viewModel: MainViewModel,
    popBack: () -> Unit
) {

    val context = LocalContext.current

        val product = viewModel.selectProduct.collectAsState().value
        var quantity by remember { mutableStateOf(1) }



        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0x8DE2E2E2)),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
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
                        .background(color = Color.White, shape = CircleShape)
                        .clip(CircleShape)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_back),
                        contentDescription = null
                    )
                }
                Text(
                    text = "CART",
                    fontSize = 20.sp,
                    color = Color(0xFF000000),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 20.dp)
                )


            }
            //image
            Image(
                painter = rememberAsyncImagePainter(product?.image),
                contentDescription = null,
                modifier = Modifier.size(250.dp)
            )

            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                    )
                //   .padding(15.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp)
                    ) {
                        val scroll = rememberScrollState(0)
                        val interactionSource = remember { MutableInteractionSource() }
                        Text(
                            text = product?.title?:"",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )

                        Spacer(modifier = Modifier.height(25.dp))

                        Box(
                            modifier = Modifier
                                .height(60.dp)
                                .fillMaxWidth()
                                .offset(y = .7.dp)
                                .padding(horizontal = 10.dp)
                        ) {

                            Text(
                                text = product?.description?:"",
                                fontSize = 14.sp,
                                lineHeight = 15.sp,
                                color = Color(0xFF757575),
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .verticalScroll(scroll)
                            )

                        }

                        Spacer(modifier = Modifier.padding(bottom = 25.dp))

                    }

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color(0xFFFF9F81),
                            shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                        )
                        .padding(15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                                if (quantity > 1) {
                                    quantity--
                                }
                            },
                            modifier = Modifier
                                .background(color = Color.White, shape = CircleShape)
                                .clip(CircleShape)

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_arrow_back),
                                contentDescription = null
                            )
                        }
                        Text(
                            text = quantity.toString(),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .width(35.dp)
                                .wrapContentHeight()
                        )
                        IconButton(
                            onClick = {
                                if (quantity < 5) {
                                    quantity++
                                } else {
                                    Toast.makeText(
                                        context,
                                        "You can add maximum 5 item at a time.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            },
                            modifier = Modifier
                                .background(color = Color.White, shape = CircleShape)
                                .clip(CircleShape)

                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_arrow_forward),
                                contentDescription = null
                            )
                        }
                    }
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                        )
                        .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .width(200.dp)
                            .padding(top = 30.dp, bottom = 30.dp)
                            .height(60.dp)
                            .clip(RoundedCornerShape(15.dp)),
                        onClick = {
                            product?.counter = quantity
                            viewModel.cartDataAdd(productItem = product!!)
                            Toast.makeText(
                                context,
                                "Successfully added to cart",
                                Toast.LENGTH_SHORT
                            ).show()
                            popBack()
                        },
                    ) {
                        Text(text = "Add to Cart", fontSize = 16.sp)
                    }
                }


            }


        }

}