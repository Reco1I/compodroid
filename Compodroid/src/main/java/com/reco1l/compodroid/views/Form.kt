package com.reco1l.compodroid.views

import android.graphics.drawable.Drawable
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton.OnCheckedChangeListener
import com.reco1l.compodroid.modifiers.Modifier


fun ViewGroup.CheckBox(

    modifier: Modifier = Modifier,
    checked: Boolean = false,
    buttonDrawable: Drawable? = null,
    onChecked: OnCheckedChangeListener? = null,
    content: CheckBox.() -> Unit

): CheckBox {
    val view = CheckBox(context)
    view.layoutParams = generateLayoutParams(null)
    modifier(view)

    view.isChecked = checked
    view.buttonDrawable = buttonDrawable
    view.setOnCheckedChangeListener(onChecked)

    view.content()
    addView(view)
    return view
}

