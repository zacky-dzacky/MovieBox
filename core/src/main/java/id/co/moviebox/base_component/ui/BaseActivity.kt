package id.co.moviebox.base_component.ui

import android.os.Bundle
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity
import id.co.moviebox.base_component.vm.ViewModelFactory
import javax.inject.Inject

abstract class BaseActivity(layout: Int): DaggerAppCompatActivity(layout) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("test", "base")
    }
}