package co.ke.sharedprefferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    //saving data
    fun saveData(view: View) {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString("name", et_name.text.toString())
            putString("code", et_number.text.toString())
            commit()
        }
    }

    fun getData(view: View) {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        val str_name = sharedPref.getString("name", "")
        val int_number = sharedPref.getString("number", "")
        Toast.makeText(this, "$str_name $int_number", Toast.LENGTH_LONG).show()

    }
}
