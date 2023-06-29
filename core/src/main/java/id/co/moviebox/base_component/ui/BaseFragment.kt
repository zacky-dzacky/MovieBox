package id.co.moviebox.base_component.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import id.co.moviebox.base_component.vm.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment: DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    // --------------------------------------
    // layout
    // --------------------------------------
    abstract val layout: Int
    private var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getInflatedLayout(inflater, container)
    }

    private fun getPersistentView(inflater: LayoutInflater, container: ViewGroup?): View? {
        if (rootView == null) {
            // save the initialized layout to an object
            rootView = getInflatedLayout(inflater, container)
        } else {
            // Do not inflate the layout again.
            // The returned View of onCreateView will be added into the fragment.
            // However it is not allowed to be added twice even if the parent is same.
            // So we must remove rootView from the existing parent view group
            // (it will be added back).
            (rootView?.parent as? ViewGroup)?.removeView(rootView)
        }
        return rootView
    }

    private fun getInflatedLayout(inflater: LayoutInflater, container: ViewGroup?): View? {
        return inflater.inflate(layout, container, false)
    }
}