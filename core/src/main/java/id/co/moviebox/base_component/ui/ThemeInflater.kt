package id.co.moviebox.base_component.ui

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater

interface ThemeInflater {
    fun generateThemeInflater(context: Context, activity: Activity, inflater: LayoutInflater):LayoutInflater
}