package kushal.application.zoomcar

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var IS_SHORT = false
    var ON_HOME = false
    val number = 8588910153

    val fManager by lazy {
        supportFragmentManager
    }

    private val menuItemList by lazy {
        arrayListOf<TextView>(
            home_tv, admin, super_club, policies, help, trips
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        drawer.setOnClickListener {
            menu.visibility = View.VISIBLE
            layout
                .animate().translationX(350f)
                .translationY(0f)
                .scaleX(0.6f)
                .scaleY(0.6f)
                .duration = 1000

            window.statusBarColor = resources.getColor(R.color.backgroundColorDark)
            container.setBackgroundColor(resources.getColor(R.color.backgroundColorDark))

            drawer.visibility = View.INVISIBLE
            IS_SHORT = true
        }
        settings.setOnClickListener {
            //            startActivity(Intent(this, Settings::class.java))
            Toast.makeText(this, "settings Clicked", Toast.LENGTH_SHORT).show()
        }

        setAllGray()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            home_tv.compoundDrawableTintList =
                resources.getColorStateList(R.color.white)
        }
        home_tv.setTextColor(resources.getColor(R.color.white))

        setUpMenuItems()
        fManager.beginTransaction().replace(R.id.layout, HomeFrag()).commit()

    }

    private fun setUpMenuItems() {

        home_tv.setOnClickListener {
            header_text.text = getString(R.string.app_name)
            colorToWhite(it)
            fManager.beginTransaction().replace(R.id.layout, HomeFrag()).commit()
            ON_HOME = true

            onBackPressed()
        }
        trips.setOnClickListener {
            header_text.text = "My Trips"
            colorToWhite(it)
            fManager.beginTransaction().replace(R.id.layout, MyTrips()).commit()
            ON_HOME = false

            onBackPressed()
        }
        admin.setOnClickListener {
            colorToWhite(it)
            header_text.text = "Admin Dash Board"
            fManager.beginTransaction().replace(R.id.layout, AdminDash()).commit()
            ON_HOME = false

            onBackPressed()
        }
        super_club.setOnClickListener {
            val builder = AlertDialog.Builder(
                this,
                R.style.AlertDialog
            )
            builder.setTitle("In Working Phase")
                .setMessage("This feature is related to back-end and services, So it is currently in developing phase.\nHere Membership page would open in final build.")
                .setPositiveButton("Understood") { dialog: DialogInterface, pos: Int ->

                }
                .setNegativeButton("dismiss") { dialogInterface: DialogInterface, i: Int ->

                }
            builder.create().show()
        }
        policies.setOnClickListener {
            val builder = AlertDialog.Builder(
                this,
                R.style.AlertDialog
            )
            builder.setTitle("In Working Phase")
                .setMessage("This feature is related to back-end and services, So it is currently in developing phase.\nHere Policies page would open in final build.")
                .setPositiveButton("Understood") { dialog: DialogInterface, pos: Int ->

                }
                .setNegativeButton("dismiss") { dialogInterface: DialogInterface, i: Int ->

                }
            builder.create().show()
        }

        main_photo.setOnClickListener {
            Toast.makeText(this, "Verification Clicked", Toast.LENGTH_SHORT).show()
        }
        verified.setOnClickListener {
            Toast.makeText(this, "Verification Clicked", Toast.LENGTH_SHORT).show()
        }
        help.setOnClickListener {
            val builder = AlertDialog.Builder(
                this,
                R.style.AlertDialog
            )
            builder.setTitle("Contact Us Here")
                .setMessage("We are available 24 / 7 at your service.\nPlease choose anyone:")
                .setPositiveButton("Live Chat") { dialog: DialogInterface, pos: Int ->
                    Toast.makeText(this, "Chat Clicked", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Call Us") { dialogInterface, pos ->
                    val i = Intent(Intent.ACTION_DIAL)
                    i.data = Uri.parse("tel:$number")
                    startActivity(i)
                }
            builder.create().show()
        }

    }

    private fun setAllGray() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            menuItemList.forEach {

                it.compoundDrawableTintList = resources.getColorStateList(R.color.gray)

                it.setTextColor(resources.getColorStateList(R.color.gray))
            }
        }

    }

    private fun colorToWhite(view: View) {
        setAllGray()
        val it = view as TextView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            it.compoundDrawableTintList =
                resources.getColorStateList(R.color.white)
        }
        it.setTextColor(resources.getColor(R.color.white))

    }

    override fun onBackPressed() {
        if (IS_SHORT) {
            layout.animate().translationX(0f)
                .translationY(0f)
                .scaleX(1f)
                .scaleY(1f)
                .duration = 600

            Handler().postDelayed({
                drawer.visibility = View.VISIBLE
                menu.visibility = View.INVISIBLE
                window.statusBarColor = resources.getColor(R.color.backgroundColorDark)
                container.setBackgroundColor(resources.getColor(R.color.toolbarColor))
            }, 600)

            IS_SHORT = !IS_SHORT

        } else if (!ON_HOME) {
            fManager.beginTransaction().replace(R.id.layout, HomeFrag()).commit()
            header_text.text = "Zoom Car"
            colorToWhite(home_tv)
            ON_HOME = !ON_HOME
        } else
            super.onBackPressed()

    }


}
