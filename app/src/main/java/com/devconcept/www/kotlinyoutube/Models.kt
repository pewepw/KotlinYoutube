package com.devconcept.www.kotlinyoutube

/**
 * Created by harry on 23/12/2017.
 */

class HomeFeed(val videos: List<Video>)

class Video(val id: Int, val name: String, val link: String, val imageUrl: String, val numberOfViews: String, val channel: Channel)

class Channel(val name: String, val profileImageUrl: String)