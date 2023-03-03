package com.nise.favor_android.Home.ui.itemUI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nise.favor_android.R
import kotlinx.android.synthetic.main.cardview_timeline.view.*

class TimelineitemAdapter():RecyclerView.Adapter<TimelineitemAdapter.TimelineitemViewHolder>() {
    var images = intArrayOf(R.drawable.favor_icon,
                            R.drawable.favor_icon,
                            R.drawable.favor_icon,
                            R.drawable.favor_icon,)

    class TimelineitemViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        val photoimage: ImageView = itemview.findViewById(R.id.photo_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineitemViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_timeline,parent,false)
        return TimelineitemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimelineitemViewHolder, position: Int) {
        holder.photoimage.setImageResource(images.get(position))
    }

    override fun getItemCount(): Int {
        return images.size
    }
}