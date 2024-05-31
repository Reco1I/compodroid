package com.reco1l.compodroid.modifiers

import android.graphics.Outline
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.MarginLayoutParams
import android.view.ViewOutlineProvider
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.setMargins
import androidx.core.view.setPadding



fun interface Modifier {

    operator fun invoke(view: View)

    companion object : Modifier {

        override fun invoke(view: View) = Unit

    }

}


// Size

fun Modifier.size(size: Int) = Modifier {
    invoke(it)
    it.layoutParams.apply {
        width = size
        height = size
    }
}

fun Modifier.size(width: Int, height: Int) = Modifier {
    invoke(it)
    it.layoutParams.apply {
        this.width = width
        this.height = height
    }
}

fun Modifier.matchParent() = Modifier {
    invoke(it)
    it.layoutParams.apply {
        width = LayoutParams.MATCH_PARENT
        height = LayoutParams.MATCH_PARENT
    }
}

fun Modifier.wrapContent() = Modifier {
    invoke(it)
    it.layoutParams.apply {
        width = LayoutParams.WRAP_CONTENT
        height = LayoutParams.WRAP_CONTENT
    }
}

fun Modifier.matchParentWidth() = Modifier {
    invoke(it)
    it.layoutParams.width = LayoutParams.MATCH_PARENT
}

fun Modifier.matchParentHeight() = Modifier {
    invoke(it)
    it.layoutParams.height = LayoutParams.MATCH_PARENT
}

fun Modifier.fillParentWidth(weight: Float = 1f) = Modifier {
    invoke(it)
    (it.layoutParams as? LinearLayout.LayoutParams)?.apply {
        this.width = 0
        this.weight = weight
    }
}

fun Modifier.fillParentHeight(weight: Float = 1f) = Modifier {
    invoke(it)
    (it.layoutParams as? LinearLayout.LayoutParams)?.apply {
        this.height = 0
        this.weight = weight
    }
}

fun Modifier.columnSpan(span: Int) = Modifier {
    invoke(it)
    (it.layoutParams as? GridLayout.LayoutParams)?.apply {
        columnSpec = GridLayout.spec(GridLayout.UNDEFINED, span)
    }
}

fun Modifier.rowSpan(span: Int) = Modifier {
    invoke(it)
    (it.layoutParams as? GridLayout.LayoutParams)?.apply {
        rowSpec = GridLayout.spec(GridLayout.UNDEFINED, span)
    }
}


// Layout gravity

fun Modifier.layoutGravity(gravity: Int) = Modifier {
    invoke(it)
    (it.layoutParams as? LinearLayout.LayoutParams)?.apply {
        this.gravity = gravity
    }
}


// Padding

fun Modifier.padding(size: Int) = Modifier {
    invoke(it)
    it.setPadding(size)
}

fun Modifier.padding(horizontal: Int, vertical: Int) = Modifier {
    invoke(it)
    it.setPadding(horizontal, vertical, horizontal, vertical)
}

fun Modifier.padding(left: Int, top: Int, right: Int, bottom: Int) = Modifier {
    invoke(it)
    it.setPadding(left, top, right, bottom)
}


// Margin

fun Modifier.margin(size: Int) = Modifier {
    invoke(it)
    (it.layoutParams as? MarginLayoutParams)?.setMargins(size)
}

fun Modifier.margin(horizontal: Int, vertical: Int) = Modifier {
    invoke(it)
    (it.layoutParams as? MarginLayoutParams)?.setMargins(horizontal, vertical, horizontal, vertical)
}

fun Modifier.margin(left: Int, top: Int, right: Int, bottom: Int) = Modifier {
    invoke(it)
    (it.layoutParams as? MarginLayoutParams)?.setMargins(left, top, right, bottom)
}


// Corner radius

fun Modifier.cornerRadius(radius: Float) = Modifier {
    invoke(it)
    it.outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline) {
            outline.setRoundRect(0, 0, view.width, view.height, radius)
        }
    }
}

fun Modifier.outline(provider: ViewOutlineProvider) = Modifier {
    invoke(it)
    it.outlineProvider = provider
}

fun Modifier.outline(provider: (View, Outline) -> Unit) = Modifier {
    invoke(it)
    it.outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline) = provider(view, outline)
    }
}


// Background

fun Modifier.background(@DrawableRes id: Int) = Modifier {
    invoke(it)
    it.setBackgroundResource(id)
}

fun Modifier.background(drawable: Drawable) = Modifier {
    invoke(it)
    it.background = drawable
}

fun Modifier.backgroundColor(color: Int) = Modifier {
    invoke(it)
    it.setBackgroundColor(color)
}


// Foreground

fun Modifier.foreground(@DrawableRes id: Int) = Modifier {
    invoke(it)
    it.foreground = AppCompatResources.getDrawable(it.context, id)
}

fun Modifier.foreground(drawable: Drawable) = Modifier {
    invoke(it)
    it.foreground = drawable
}

fun Modifier.foregroundColor(color: Int) = Modifier {
    invoke(it)
    it.foreground = ColorDrawable(color)
}


// Transformation

fun Modifier.translation(x: Float, y: Float, z: Float) = Modifier {
    invoke(it)
    it.translationX = x
    it.translationY = y
    it.translationZ = z
}

fun Modifier.rotation(value: Float) = Modifier {
    invoke(it)
    it.rotation = value
}

fun Modifier.rotation(x: Float, y: Float, z: Float) = Modifier {
    invoke(it)
    it.rotationX = x
    it.rotationY = y
    it.rotation = z
}

fun Modifier.scale(value: Float) = Modifier {
    invoke(it)
    it.scaleX = value
    it.scaleY = value
}

fun Modifier.scale(x: Float, y: Float) = Modifier {
    invoke(it)
    it.scaleX = x
    it.scaleY = y
}

fun Modifier.alpha(value: Float) = Modifier {
    invoke(it)
    it.alpha = value
}