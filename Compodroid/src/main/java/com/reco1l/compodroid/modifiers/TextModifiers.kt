package com.reco1l.compodroid.modifiers

import android.graphics.drawable.Drawable
import android.widget.TextView


fun Modifier.compoundDrawable(left: Drawable? = null, top: Drawable? = null, right: Drawable? = null, bottom: Drawable? = null) = Modifier {
    invoke(it)
    if (it is TextView) {
        it.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom)
    }
}

fun Modifier.compoundDrawableRelative(start: Drawable? = null, top: Drawable? = null, end: Drawable? = null, bottom: Drawable? = null) = Modifier {
    invoke(it)
    if (it is TextView) {
        it.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)
    }
}
