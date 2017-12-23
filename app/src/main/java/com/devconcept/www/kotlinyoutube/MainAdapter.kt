package com.devconcept.www.kotlinyoutube

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

/**
 * Created by harry on 22/12/2017.
 */

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return  CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val video = homeFeed.videos[position]
        holder?.itemView?.textView_video_title?.text = video.name
        holder?.itemView?.textView_channel_name?.text = video.channel.name + "  -  " + "20kViews\n4 days ago"

        val thumbnailImageView = holder?.itemView?.imageView_video_thumbnail
        Picasso.with(holder?.itemView?.context).load(video.imageUrl).into(thumbnailImageView)

        val channelProfileImageView = holder?.itemView?.imageView_channel_profile
        Picasso.with(holder?.itemView?.context).load(video.channel.profileImageUrl).into(channelProfileImageView)
    }

}

class CustomViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

}