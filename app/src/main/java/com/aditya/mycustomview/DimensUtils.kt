package com.aditya.mycustomview

import android.content.res.Resources

fun Int.toDp(): Float = this * Resources.getSystem().displayMetrics.density