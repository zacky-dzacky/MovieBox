package id.co.moviebox.ui

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.view.ContextThemeWrapper
import id.co.moviebox.R
import id.co.moviebox.base_component.ui.ThemeInflater

class ThemeInflaterImpl: ThemeInflater {
    override fun generateThemeInflater(
        context: Context,
        activity: Activity,
        inflater: LayoutInflater
    ): LayoutInflater {
        val styleTheme = R.style.AppTheme
//        val styleTheme = R.style.AppThemeHome
        val contextThemeWrapper = ContextThemeWrapper(activity, styleTheme)
        val localInflater = inflater.cloneInContext(contextThemeWrapper)
        context.theme?.applyStyle(styleTheme, true)
        return localInflater
    }
}