package com.devconcept.www.kotlinyoutube

import android.content.Intent
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
 // seem like let cell = dequereusable and return part
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return  CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

//seem like cellForRowAtIndexPath indexPath biding part
    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val video = homeFeed.videos[position]
        holder?.view?.textView_video_title?.text = video.name
        holder?.view?.textView_channel_name?.text = video.channel.name + "  -  " + "20kViews\n4 days ago"

        val thumbnailImageView = holder?.view?.imageView_video_thumbnail
        Picasso.with(holder?.view?.context).load(video.imageUrl).into(thumbnailImageView)

        val channelProfileImageView = holder?.view?.imageView_channel_profile
        Picasso.with(holder?.view?.context).load(video.channel.profileImageUrl).into(channelProfileImageView)

        holder?.video = video
    }

}

//seem like didSelectRowAtIndexPath Delegate
class CustomViewHolder(val view: View, var video: Video? = null) : RecyclerView.ViewHolder(view) {
    companion object {
        val VIDEO_TITLE_KEY = "VIDEO_TITLE"
        val VIDEO_ID_KEY = "VIDEO_ID"
    }

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, CourseDetailActivity::class.java)
            intent.putExtra(VIDEO_TITLE_KEY, video?.name)
            intent.putExtra(VIDEO_ID_KEY, video?.id)
            view.context.startActivity(intent)
        }
    }
}