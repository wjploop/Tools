package wjp.ui.util.context

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import wjp.ui.util.R

/**
 * 个人认为比较好看的toast
 */
fun Context.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).apply {

        //设置自定View
        LayoutInflater.from(this@showToast).inflate(R.layout.toast_layout, null).apply {
            findViewById<TextView>(R.id.tv_msg).text = text
        }.let {
            view = it
        }
        setGravity(Gravity.CENTER, 0, 70)

        //设置自定义弹出动画

        val tn = javaClass.getDeclaredField("mTN").apply {
            isAccessible = true
        }
        val tnObj = tn[this]
        val layoutParam = tnObj.javaClass.getDeclaredField("mParams").apply {
            isAccessible = true
        }
        val layoutParamsObj = layoutParam[tnObj] as WindowManager.LayoutParams

        layoutParamsObj.windowAnimations = R.style.ToastStyle


    }.show()
}
