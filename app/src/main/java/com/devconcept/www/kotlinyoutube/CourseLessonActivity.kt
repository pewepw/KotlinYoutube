package com.devconcept.www.kotlinyoutube

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_course_lesson.*

/**
 * Created by harry on 31/12/2017.
 */

class CourseLessonActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_course_lesson)

        val courseLink = intent.getStringExtra(CourseDetailActivity.CourseLessonViewHolder.COURSE_LESSON_LINK_KEY)
        webview_course_lesson.settings.javaScriptEnabled = true
        webview_course_lesson.settings.loadWithOverviewMode = true
        webview_course_lesson.settings.useWideViewPort = true
        webview_course_lesson.loadUrl("https://www.google.com")
    }
}