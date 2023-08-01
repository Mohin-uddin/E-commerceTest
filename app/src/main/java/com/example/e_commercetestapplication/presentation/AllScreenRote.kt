package com.example.e_commercetestapplication.presentation


sealed class AllScreenRote(
    val route: String,
) {

    // for home
    object Home: AllScreenRote(
        route = "home"
    )

    // for report
    object ProductDetails: AllScreenRote(
        route = "productDetails"
    )
    object CartList: AllScreenRote(
        route = "cartList"
    )
}
