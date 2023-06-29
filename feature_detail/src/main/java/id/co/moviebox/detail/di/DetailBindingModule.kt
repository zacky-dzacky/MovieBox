package id.co.moviebox.detail.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import id.co.moviebox.base_component.di.ActivityScope
import id.co.moviebox.base_component.di.ViewModelKey
import id.co.moviebox.detail.ui.DetailFragment
import id.co.moviebox.detail.vm.DetailViewModel

@Module
interface DetailBindingModule {
    @ActivityScope
    @ContributesAndroidInjector
    fun bindDetailFragment(): DetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun DetailViewModel.provideDetailViewModel() : ViewModel
}