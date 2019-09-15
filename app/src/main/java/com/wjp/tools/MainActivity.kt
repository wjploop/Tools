import android.app.ListActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ListView
import android.widget.SimpleAdapter
import wjp.ui.util.activity.HeightProvider
import wjp.ui.util.context.KeyboardHeightProvider
import wjp.ui.util.context.showToast
import wjp.ui.util.dialog.showInputDialogFromView

class MainActivity : ListActivity() {

    val data =
        listOf(
            "toast",
            "comment popup",
            "keyboard height"
        )
            .map {
                mapOf("action" to it)
            }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = SimpleAdapter(
            this, data, android.R.layout.simple_list_item_1, arrayOf("action"),
            intArrayOf(android.R.id.text1)
        )
        listAdapter = adapter
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        when (position) {
            0 -> showToast("there is will")
            1 -> showInputDialogFromView {
                showToast("send a Message")
            }
            2 ->
//                KeyboardHeightProvider(this) {
//                showToast("keyboard height:$it")
//            }
                HeightProvider(this).init().setHeightListener {
                    showToast("cur:d$it")
                }
        }
    }
}
