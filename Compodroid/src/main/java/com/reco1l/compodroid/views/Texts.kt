package com.reco1l.compodroid.views

import android.graphics.Typeface
import android.text.Editable
import android.text.InputFilter
import android.text.TextUtils.TruncateAt
import android.text.TextWatcher
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.GravityInt
import com.reco1l.compodroid.modifiers.Modifier


fun ViewGroup.TextView(

    modifier: Modifier = Modifier,
    text: CharSequence? = null,
    hint: CharSequence? = null,
    color: Int? = null,
    gravity: Int? = null,
    typeface: Typeface? = null,
    ems: Int? = null,
    maxLines: Int? = null,
    fontSize: Float? = null,
    ellipsize: TruncateAt? = null,
    textWatcher: TextWatcher? = null,
    content: TextView.() -> Unit

): TextView {
    val view = TextView(context)
    view.layoutParams = generateLayoutParams(null)
    modifier(view)

    view.text = text
    view.hint = hint

    ems?.let { view.setEms(it) }
    color?.let { view.setTextColor(it) }
    gravity?.let { view.gravity = it }
    typeface?.let { view.typeface = it }
    maxLines?.let { view.maxLines = it }
    ellipsize?.let { view.ellipsize = it }
    fontSize?.let { view.textSize = it }
    textWatcher?.let { view.addTextChangedListener(it) }

    view.content()
    addView(view)
    return view
}

fun ViewGroup.EditText(

    modifier: Modifier = Modifier,
    text: Editable? = null,
    hint: CharSequence? = null,
    color: Int? = null,
    gravity: Int? = null,
    typeface: Typeface? = null,
    ems: Int? = null,
    maxLines: Int? = null,
    fontSize: Float? = null,
    ellipsize: TruncateAt? = null,
    textWatcher: TextWatcher? = null,
    content: EditText.() -> Unit

): EditText {
    val view = EditText(context)
    view.layoutParams = generateLayoutParams(null)
    modifier(view)

    view.text = text
    view.hint = hint

    ems?.let { view.setEms(it) }
    color?.let { view.setTextColor(it) }
    gravity?.let { view.gravity = it }
    typeface?.let { view.typeface = it }
    maxLines?.let { view.maxLines = it }
    ellipsize?.let { view.ellipsize = it }
    fontSize?.let { view.textSize = it }
    textWatcher?.let { view.addTextChangedListener(it) }

    view.content()
    addView(view)
    return view
}
