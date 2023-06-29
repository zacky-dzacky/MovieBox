package id.co.moviebox.feature_search.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import id.co.moviebox.base_component.di.ActivityScope
import id.co.moviebox.base_component.di.ViewModelKey
import id.co.moviebox.feature_search.ui.SearchFragment
import id.co.moviebox.feature_search.vm.SearchViewModel

@Module
interface SearchBindingModule {
    @ActivityScope
    @ContributesAndroidInjector
    fun bindSearchFragment(): SearchFragment

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun SearchViewModel.provideSearchViewModel() : ViewModel
}