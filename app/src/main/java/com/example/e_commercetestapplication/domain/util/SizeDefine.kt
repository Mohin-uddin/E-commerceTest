package com.example.e_commercetestapplication.domain.util


import androidx.compose.ui.unit.Dp
var ScaleFactor = 1f
var DeviceWidth = 0f
var DeviceHeight = 0f

var Density = 0f

inline val Number.PxToDp get() = this.toFloat() / Density


inline val Number.dw: Dp
    get() = Dp(value = (ScaleFactor * this.toFloat() * Math.min(DeviceWidth, DeviceHeight)).PxToDp)

inline val Number.dh: Dp
    get() = Dp(value = (ScaleFactor * this.toFloat() * Math.max(DeviceWidth, DeviceHeight)).PxToDp)

