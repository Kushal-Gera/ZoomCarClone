package kushal.application.zoomcar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class Home_adapter(val list: Array<Int>, val flag: Boolean) :
    RecyclerView.Adapter<Home_viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Home_viewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_rec_view, parent, false)
        if (flag) {
            return Home_viewHolder(view)
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.home_rec_view2, parent, false)
        }
        return Home_viewHolder(view)

    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Home_viewHolder, position: Int) {
        holder.image.setImageResource(list[position])
    }


}