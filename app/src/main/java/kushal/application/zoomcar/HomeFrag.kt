package kushal.application.zoomcar


import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.util.*

class HomeFrag : Fragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        val list = arrayOf(
            R.drawable.bg_blue,
            R.drawable.bg_green,
            R.drawable.bg_yellow,
            R.drawable.bg_blue,
            R.drawable.bg_green
        )

        view.home_recView2.adapter = Home_adapter(list, false)
        val llm = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        view.home_recView2.layoutManager = llm


        view.home_recView1.adapter = Home_adapter(list, true)
        val llm2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        view.home_recView1.layoutManager = llm2


        view.startTime.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                TimePickerDialog(
                    context!!,
                    R.style.TimeDailog,
                    this,
                    Calendar.HOUR_OF_DAY,
                    Calendar.MINUTE,
                    false
                ).show()
            }
        }

        view.dropTime.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                TimePickerDialog(
                    context!!,
                    R.style.TimeDailog,
                    this,
                    Calendar.HOUR_OF_DAY,
                    Calendar.MINUTE,
                    false
                ).show()
            }
        }

        view.findCar.setOnClickListener {
            val p = ProgressDialog(context, R.style.TimeDailog)
            p.setTitle("Loading Please Wait")
            p.show()
            Handler().postDelayed({
                p.dismiss()
            }, 2500)
        }


        return view
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

    }


}
