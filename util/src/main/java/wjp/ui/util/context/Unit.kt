package wjp.ui.util.context

import android.content.Context

fun Context.dp2px(dp: Int): Int {
    val density = resources.displayMetrics.density
    return (dp * density + 0.5f).toInt()
}