package wjp.ui.util.dialog

import android.app.Activity
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.WindowManager
import android.widget.EditText
import android.widget.PopupWindow
import android.widget.TextView
import kotlinx.android.synthetic.main.dialog_comment.view.*
import wjp.ui.util.R
import wjp.ui.util.context.dp2px
import wjp.ui.util.context.getNavigationHeight
import wjp.ui.util.context.showSoftInput
import wjp.ui.util.context.statusHeight


fun Activity.showInputDialogFromView(sureAction: () -> Unit = {}) {
    PopupWindow(MATCH_PARENT, WRAP_CONTENT).apply popup@{
        layoutInflater.inflate(R.layout.dialog_comment, null).apply {
            val etComment = findViewById<EditText>(R.id.et_comment)
            val tvCancel = findViewById<TextView>(R.id.tv_cancel)
            val tvSure = findViewById<TextView>(R.id.tv_sure)

            etComment.apply {
                addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {

                    }

                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        tvSure.isEnabled = !s.isNullOrBlank()
                    }
                })
                postDelayed({
                    //                    showSoftInput(this)
                }, 200)
            }

            tvCancel.setOnClickListener {
                this@popup.dismiss()
            }

            tvSure.setOnClickListener {
                sureAction()
                this@popup.dismiss()

            }
        }.let {
            contentView = it
        }

        setBackgroundDrawable(BitmapDrawable())
        isFocusable = true
        softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        animationStyle = R.style.PopupFromBottomStyle
        window.attributes = window.attributes.apply {
            alpha = 0.7f
        }
        setOnDismissListener {
            window.attributes = window.attributes.apply {
                alpha = 1.0f
            }
        }

        var keyboardOffsetX = 0

        window.decorView.rootView.apply {
            viewTreeObserver.addOnGlobalLayoutListener {
                val rect = Rect()

                rootView.getWindowVisibleDisplayFrame(rect)
                keyboardOffsetX = rect.height()
            }
        }

        val h = getNavigationHeight()

        showAtLocation(window.decorView, Gravity.BOTTOM, 0, keyboardOffsetX + h)


    }
}