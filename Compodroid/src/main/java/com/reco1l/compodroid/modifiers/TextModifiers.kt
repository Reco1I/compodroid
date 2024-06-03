package com.reco1l.compodroid.modifiers

import android.graphics.drawable.Drawable
import android.widget.TextView


fun Modifier.textAlignment(alignment: Int) = Modifier {
    invoke(it)
    it.textAlignment = alignment
}

fun Modifier.textDirection(direction: Int) = Modifier {
    invoke(it)
    it.textDirection = direction
}

fun Modifier.compoundDrawable(left: Drawable? = null, top: Drawable? = null, right: Drawable? = null, bottom: Drawable? = null) = Modifier {
    require(it is TextView) { "Cannot apply this modifier to a non-TextView view" }
    invoke(it)
    it.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom)
}

fun Modifier.compoundDrawableRelative(start: Drawable? = null, top: Drawable? = null, end: Drawable? = null, bottom: Drawable? = null) = Modifier {
    require(it is TextView) { "Cannot apply this modifier to a non-TextView view" }
    invoke(it)
    it.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)
}
