package com.reco1l.compodroid.views

import android.graphics.Typeface
import android.text.Editable
import android.text.TextUtils.TruncateAt
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
    fontSize: Float? = null,
    fontStyle: Int? = null,
    letterSpacing: Float? = null,
    textAlignment: Int? = null,
    typeface: Typeface? = null,
    maxLines: Int? = null,
    ellipsize: TruncateAt? = null,
    @GravityInt gravity: Int? = null,
    content: TextView.() -> Unit
): TextView {
    val view = TextView(context)
    view.layoutParams = generateLayoutParams(null)
    modifier(view)

    view.text = text
    view.hint = hint
    color?.let { view.setTextColor(it) }
    gravity?.let { view.gravity = gravity }
    fontSize?.let { view.textSize = it }
    fontStyle?.let { view.typeface = typeface }
    letterSpacing?.let { view.letterSpacing = it }
    textAlignment?.let { view.textAlignment = it }
    maxLines?.let { view.maxLines = it }
    ellipsize?.let { view.ellipsize = it }

    view.content()
    addView(view)
    return view
}

fun ViewGroup.EditText(
    modifier: Modifier = Modifier,
    text: Editable? = null,
    hint: CharSequence? = null,
    color: Int? = null,
    fontSize: Float? = null,
    fontStyle: Int? = null,
    ems: Int? = null,
    letterSpacing: Float? = null,
    textAlignment: Int? = null,
    typeface: Typeface? = null,
    maxLines: Int? = null,
    ellipsize: TruncateAt? = null,
    @GravityInt gravity: Int? = null,
    content: EditText.() -> Unit
): EditText {
    val view = EditText(context)
    view.layoutParams = generateLayoutParams(null)
    modifier(view)

    view.text = text
    view.hint = hint

    color?.let { view.setTextColor(it) }
    gravity?.let { view.gravity = gravity }
    fontSize?.let { view.textSize = it }
    fontStyle?.let { view.typeface = typeface }
    ems?.let { view.setEms(it) }
    letterSpacing?.let { view.letterSpacing = it }
    textAlignment?.let { view.textAlignment = it }
    maxLines?.let { view.maxLines = it }
    ellipsize?.let { view.ellipsize = it }

    view.content()
    addView(view)
    return view
}
