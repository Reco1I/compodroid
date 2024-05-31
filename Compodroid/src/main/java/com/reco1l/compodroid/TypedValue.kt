package com.reco1l.compodroid

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.util.TypedValue.COMPLEX_UNIT_SP


/**
 * Converts a [Float] value to pixels using [TypedValue.applyDimension].
 *
 * @see COMPLEX_UNIT_DIP
 */
val Float.dp
    get() = TypedValue.applyDimension(COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)

/**
 * Converts an [Int] value to pixels using [TypedValue.applyDimension].
 *
 * @see COMPLEX_UNIT_DIP
 */
val Int.dp
    get() = TypedValue.applyDimension(COMPLEX_UNIT_DIP, toFloat(), Resources.getSystem().displayMetrics).toInt()


/**
 * Converts a [Float] value to pixels using [TypedValue.applyDimension].
 *
 * @see COMPLEX_UNIT_DIP
 */
fun Float.dp(context: Context): Float {
    return TypedValue.applyDimension(COMPLEX_UNIT_DIP, this, context.resources.displayMetrics)
}

/**
 * Converts an [Int] value to pixels using [TypedValue.applyDimension].
 *
 * @see COMPLEX_UNIT_DIP
 */
fun Int.dp(context: Context): Int {
    return TypedValue.applyDimension(COMPLEX_UNIT_DIP, toFloat(), context.resources.displayMetrics).toInt()
}

/**
 * Converts a [Float] value to scaled pixels using [TypedValue.applyDimension].
 *
 * @see COMPLEX_UNIT_SP
 */
val Float.sp
    get() = TypedValue.applyDimension(COMPLEX_UNIT_SP, this, Resources.getSystem().displayMetrics)

/**
 * Converts an [Int] value to scaled pixels using [TypedValue.applyDimension].
 *
 * @see COMPLEX_UNIT_SP
 */
val Int.sp
    get() = TypedValue.applyDimension(COMPLEX_UNIT_SP, toFloat(), Resources.getSystem().displayMetrics).toInt()


/**
 * Converts a [Float] value to scaled pixels using [TypedValue.applyDimension].
 *
 * @see COMPLEX_UNIT_SP
 */
fun Float.sp(context: Context): Float {
    return TypedValue.applyDimension(COMPLEX_UNIT_SP, this, context.resources.displayMetrics)
}

/**
 * Converts an [Int] value to scaled pixels using [TypedValue.applyDimension].
 *
 * @see COMPLEX_UNIT_SP
 */
fun Int.sp(context: Context): Int {
    return TypedValue.applyDimension(COMPLEX_UNIT_SP, toFloat(), context.resources.displayMetrics).toInt()
}