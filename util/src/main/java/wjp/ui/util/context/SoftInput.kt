package wjp.ui.util.context

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


/***
 *  显示软键盘，注意必须布局必须完成加载，否则不可以显示
 *  @param view 必须是已经获取到焦点的view,比如editText
 *  @param flag 默认就用0,其存在是为了对应隐藏输入的flag, 如hide_implicit_only只隐藏show_implicit的开启的键盘。
 */
fun Context.showSoftInput(view: View, flag: Int = 0) {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).let {
        view.requestFocus()
        it.showSoftInput(view, flag)
    }
}

fun Context.hideSoftInput(view: View, flag: Int = 0) {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).let {
        it.hideSoftInputFromWindow(view.windowToken, flag)
    }
}

