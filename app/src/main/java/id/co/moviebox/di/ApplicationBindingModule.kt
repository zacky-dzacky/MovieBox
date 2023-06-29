package id.co.moviebox.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import id.co.moviebox.ui.SplashActivity
import id.co.moviebox.base_component.di.ActivityScope
import id.co.moviebox.base_component.di.ViewModelKey
import id.co.moviebox.ui.HostActivity
import id.co.moviebox.vm.SplashViewModel

@Module
interface ApplicationBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    fun bindSplashActivity(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector
    fun bindHostActivity(): HostActivity



    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun SplashViewModel.provideSplasViewModel(): ViewModel

}