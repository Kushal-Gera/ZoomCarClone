package kushal.application.zoomcar


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_admin_dash.view.*

class AdminDash : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_dash, container, false)

        view.photo.setOnClickListener {

            val i = Intent()
            i.type = "image/*"
            i.action = Intent.ACTION_GET_CONTENT

            startActivityForResult(Intent.createChooser(i, "Choose from :"), 1)
        }
        view.upload.setOnClickListener {
            Toast.makeText(context, "In Working Phase", Toast.LENGTH_SHORT).show()
        }

        return view
    }


}
