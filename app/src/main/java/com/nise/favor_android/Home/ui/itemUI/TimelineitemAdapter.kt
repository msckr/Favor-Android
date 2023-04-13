package com.nise.favor_android.Home.ui.itemUI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nise.favor_android.R
import com.nise.favor_android.databinding.CardviewTimelineBinding

class TimelineitemAdapter : RecyclerView.Adapter<TimelineitemAdapter.TimelineitemViewHolder>() {
    var images = arrayListOf<Int>()

    private lateinit var binding: CardviewTimelineBinding

    /*class TimelineitemViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val photoimage: ImageView = itemview.findViewById(R.id.photo_image)
        fun bind()
    }*/

    inner class TimelineitemViewHolder(binding: CardviewTimelineBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Int) {
            binding.photoImage.setImageResource(data)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineitemViewHolder {
        binding = CardviewTimelineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        //var view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_timeline, parent, false)
        return TimelineitemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TimelineitemViewHolder, position: Int) {
        //holder.photoimage.setImageResource(images.get(position))
        holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}