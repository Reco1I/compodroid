package com.reco1l.compodroid.views

import android.graphics.drawable.Drawable
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.reco1l.compodroid.modifiers.Modifier

/**
 * FrameLayout is designed to block out an area on the screen to display a single item. Generally,
 * FrameLayout should be used to hold a single child view, because it can be difficult to organize
 * child views in a way that's scalable to different screen sizes without the children overlapping
 * each other. You can, however, add multiple children to a FrameLayout and control their position
 * within the FrameLayout by assigning gravity to each child
 *
 * @param measureAllChildren Sets whether to consider all children, or just those in the VISIBLE or
 * INVISIBLE state, when measuring. Defaults to false.
 */
fun ViewGroup.FrameLayout(

    modifier: Modifier = Modifier,
    measureAllChildren: Boolean? = null,
    content: FrameLayout.() -> Unit

): FrameLayout {

    val view = FrameLayout(context)
    view.layoutParams = generateLayoutParams(null)
    modifier(view)

    measureAllChildren?.let { view.measureAllChildren = it }

    view.content()
    addView(view)

    return view
}

/**
 * A layout that arranges other views either horizontally in a single column
 * or vertically in a single row.
 *
 * @param orientation Should the layout be a column or a row.
 * @param gravity Describes how the child views are positioned. Defaults to GRAVITY_TOP. If
 * this layout has a VERTICAL orientation, this controls where all the child
 * views are placed if there is extra vertical space. If this layout has a
 * HORIZONTAL orientation, this controls the alignment of the children.
 * @param showDividers Set how dividers should be shown between items in this layout
 * @param dividerDrawable Set a drawable to be used as a divider between items.
 */
fun ViewGroup.LinearLayout(

    modifier: Modifier = Modifier,
    orientation: Int? = null,
    gravity: Int? = null,
    showDividers: Int? = null,
    dividerDrawable: Drawable? = null,
    weightSum: Float? = null,
    baselineAligned: Boolean? = null,
    baselineAlignedChildIndex: Int? = null,
    measureWithLargestChildEnabled: Boolean? = null,
    content: LinearLayout.() -> Unit

): LinearLayout {

    val view = LinearLayout(context)
    view.layoutParams = generateLayoutParams(null)
    modifier(view)

    dividerDrawable?.let { view.dividerDrawable = it }
    showDividers?.let { view.showDividers = it }
    orientation?.let { view.orientation = it }
    gravity?.let { view.gravity = it }
    weightSum?.let { view.weightSum = it }
    baselineAligned?.let { view.isBaselineAligned = it }
    baselineAlignedChildIndex?.let { view.baselineAlignedChildIndex = it }
    measureWithLargestChildEnabled?.let { view.isMeasureWithLargestChildEnabled = it }

    view.content()
    addView(view)

    return view
}

/**
 * A Layout where the positions of the children can be described in relation to each other or to the
 * parent.
 *
 * @param gravity Describes how the child views are positioned. Defaults to START | TOP.
 * Note that since RelativeLayout considers the positioning of each child relative to one another to
 * be significant, setting gravity will affect the positioning of all children as a single unit within
 * the parent. This happens after children have been relatively positioned.
 * @param verticalGravity The vertical gravity of the child views.
 * @param horizontalGravity The horizontal gravity of the child views.
 */
fun ViewGroup.RelativeLayout(

    modifier: Modifier = Modifier,
    gravity: Int? = null,
    verticalGravity: Int? = null,
    horizontalGravity: Int? = null,
    ignoreGravityOnChild: Int? = null,
    content: RelativeLayout.() -> Unit

): RelativeLayout {

    val view = RelativeLayout(context)
    view.layoutParams = generateLayoutParams(null)
    modifier(view)

    gravity?.let { view.gravity = it }
    verticalGravity?.let { view.setVerticalGravity(it) }
    horizontalGravity?.let { view.setHorizontalGravity(it) }
    ignoreGravityOnChild?.let { view.ignoreGravity = it }

    view.content()
    addView(view)

    return view
}

/**
 * A layout that places its children in a rectangular <em>grid</em>.
 *
 * @param alignmentMode Sets the alignment mode to be used for all of the alignments between the
 * children of this container. The default value of this property is ALIGN_MARGINS.
 * @param rowCount RowCount is used only to generate default row/ column indices when they are not
 * specified by a component's layout parameters
 * @param rowOrderPreserved When this property is `true`, GridLayout is forced to place the row boundaries
 * so that their associated grid indices are in ascending order in the view.
 * When this property is `false` GridLayout is at liberty to place the vertical row boundaries in whatever
 * order best fits the given constraints.
 * The default value of this property is `true`.
 * @param columnCount is used only to generate default column/ column indices when they are not specified
 * by a component's layout parameters
 * @param columnOrderPreserved When this property is `true`, GridLayout is forced to place the column
 * boundaries so that their associated grid indices are in ascending order in the view.
 * When this property is `false` GridLayout is at liberty to place the horizontal column boundaries in
 * whatever order best fits the given constraints.
 * The default value of this property is `true`.
 * @param useDefaultMargins When `true`, GridLayout allocates default margins around children based on
 * the child's visual characteristics. Each of the margins so defined may be independently overridden
 * by an assignment to the appropriate layout parameter.
 * When `false`, the default value of all margins is zero.
 * When setting to `true`, consider setting the value of the alignmentMode property to ALIGN_BOUNDS.
 * The default value of this property is `false`.
 */
fun ViewGroup.GridLayout(

    modifier: Modifier = Modifier,
    alignmentMode: Int? = null,
    rowCount: Int? = null,
    rowOrderPreserved: Boolean? = null,
    columnCount: Int? = null,
    columnOrderPreserved: Boolean? = null,
    useDefaultMargins: Boolean? = null,
    content: GridLayout.() -> Unit

): GridLayout {

    val view = GridLayout(context)
    view.layoutParams = generateLayoutParams(null)
    modifier(view)

    alignmentMode?.let { view.alignmentMode = it }
    rowCount?.let { view.rowCount = it }
    rowOrderPreserved?.let { view.isRowOrderPreserved = it }
    columnCount?.let { view.columnCount = it }
    columnOrderPreserved?.let { view.isColumnOrderPreserved = it }
    useDefaultMargins?.let { view.useDefaultMargins = it }

    view.content()
    addView(view)

    return view
}