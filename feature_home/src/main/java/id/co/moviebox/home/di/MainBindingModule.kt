package id.co.moviebox.home.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import id.co.moviebox.base_component.di.ActivityScope
import id.co.moviebox.base_component.di.ViewModelKey
import id.co.moviebox.home.ui.FavoriteFragment
import id.co.moviebox.home.ui.HomeFragment
import id.co.moviebox.home.ui.MainActivity
import id.co.moviebox.home.vm.MainViewModel

@Module
interface MainBindingModule {
    @ActivityScope
    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector
    fun bindHomeFragment(): HomeFragment

    @ActivityScope
    @ContributesAndroidInjector
    fun bindFavoriteFragment(): FavoriteFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun MainViewModel.provideMainViewModel(): ViewModel
}