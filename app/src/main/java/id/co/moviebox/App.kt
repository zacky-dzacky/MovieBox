package id.co.moviebox

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import id.co.moviebox.base_component.di.CoreComponent
import id.co.moviebox.base_component.di.CoreComponentProvider
import id.co.moviebox.base_component.di.CoreModule
import id.co.moviebox.base_component.di.DaggerCoreComponent
import id.co.moviebox.di.DaggerApplicationComponent


class App: DaggerApplication(), CoreComponentProvider {
    private lateinit var coreComponent: CoreComponent
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent
            .builder()
            .application(this)
            .coreComponent(this.provideCoreComponent())
            .build()

    }
////
    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            coreComponent = DaggerCoreComponent
                .builder()
                .coreModule(CoreModule(this))
                .build()
        }
        return coreComponent
    }
}