package wjp.ui.util.context

import android.app.Activity
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.view.*
import android.widget.PopupWindow
import wjp.ui.util.R

class KeyboardHeightProvider(val activity: Activity, callback: (keyboardHeight: Int) -> Unit) :
    PopupWindow(0, -1) {

    var heightMax = 0

    init {
        val rootView = View(activity)

        contentView = rootView
        rootView.viewTreeObserver.addOnGlobalLayoutListener {
            val rect = Rect()
            rootView.getWindowVisibleDisplayFrame(rect)
            if (rect.bottom > heightMax) {
                heightMax = rect.bottom
            }
            val diff = heightMax - rect.bottom
            callback(diff)

        }

        setBackgroundDrawable(ColorDrawable(0))
        softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        inputMethodMode = INPUT_METHOD_NEEDED

        activity.window.decorView.apply {
            postDelayed({
                showAtLocation(activity.window.decorView, Gravity.BOTTOM, 0, 0)
            }, 500)
        }


    }


}