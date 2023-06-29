package id.co.moviebox.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import id.co.moviebox.App
import id.co.moviebox.base_component.di.AppScope
import id.co.moviebox.base_component.di.CoreComponent
import id.co.moviebox.base_component.di.ViewModelModule
import id.co.moviebox.detail.di.DetailModule
import id.co.moviebox.home.di.MainModule
import id.co.moviebox.service_genre.di.UserServiceModule
import id.co.moviebox.feature_search.di.SearchModule


@AppScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        APIModule::class,

        // binding
        ApplicationModule::class,
        DetailModule::class,
        SearchModule::class,
        MainModule::class,

        // service
        UserServiceModule::class
    ],
    dependencies = [CoreComponent::class]
)
interface ApplicationComponent: AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun coreComponent(coreComponent: CoreComponent): Builder
        fun build(): ApplicationComponent
    }
}