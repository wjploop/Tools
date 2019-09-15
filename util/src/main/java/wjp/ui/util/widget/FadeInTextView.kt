package wjp.ui.util.widget

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.TextView

/**
 * 文字透明度逐渐浮现
 */
class FadeInTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleDef: Int = 0
) : TextView(context, attrs, defStyleDef) {


    var finished = false

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (!finished) {
            finished = true
            ValueAnimator.ofFloat(0.5f, 1f).apply {
                addUpdateListener {
                    alpha = it.animatedValue as Float
                }
                duration = 1000
            }.start()

        }


    }

}