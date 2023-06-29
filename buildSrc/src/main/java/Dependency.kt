@file:Suppress("unused", "ClassName", "SpellCheckingInspection")
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

class Dependency {

    object Proguard {
        const val ANDROID_OPTIMIZED = "proguard-android-optimize.txt"
        const val PROGUARD_RULES = "proguard-rules.pro"
        const val CONSUMER_RULES = "consumer-rules.pro"
    }
    object CoreLibrary {
        const val KTX = "androidx.core:core-ktx:1.8.0"
        const val SPLASH_SCREEN = "androidx.core:core-splashscreen:1.0.0"
    }

    object RoomLibrary {
        private const val ROOM_VERSION = "2.4.2"
        const val ROOM_KTX = "androidx.room:room-ktx:$ROOM_VERSION"
        const val ROOM_RUNTIME = "androidx.room:room-runtime:$ROOM_VERSION"
        const val ROOM_COMPILER = "androidx.room:room-compiler:$ROOM_VERSION"
    }

    object Paging {
        private const val paging = "3.1.0"
        const val common = "androidx.paging:paging-common-ktx:${paging}"
        const val runtime = "androidx.paging:paging-runtime-ktx:${paging}"
    }

    object DaggerLibrary {
        const val DAGGER_VERSION  = "2.42"
        const val DAGGER = "com.google.dagger:dagger-android:2.27"
        const val DAGGER_SUPPORT = "com.google.dagger:dagger-android-support:$DAGGER_VERSION" // if you use the support libraries
        const val DAGGER_PROCESSOR = "com.google.dagger:dagger-android-processor:$DAGGER_VERSION"
        const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:$DAGGER_VERSION"
    }

    object TestLibrary {
        const val JUNIT = "junit:junit:4.13.2"
        const val EXT_JUNIT = "androidx.test.ext:junit:1.1.5"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.5.1"
        const val ANNOTATION = "androidx.annotation:annotation:1.3.0"
    }

    object APILibrary {
        const val RETROFIT2 = "com.squareup.retrofit2:retrofit:2.9.0"
        const val RETROFIT2_GSON = "com.squareup.retrofit2:converter-gson:2.8.0"
        const val OKHTTP3 = "com.squareup.okhttp3:okhttp:3.14.7"
        const val OKHTTP3_LOGGING = "com.squareup.okhttp3:logging-interceptor:4.7.2"
    }

    object JetpackNavigation {
        const val NAV_VERSION = "2.5.3"

        // kotlin
        const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:$NAV_VERSION"
        const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:$NAV_VERSION"

        // Feature module Support
        const val NAVIGATION_DYNAMIC_FEATURE = "androidx.navigation:navigation-dynamic-features-fragment:$NAV_VERSION"

        // Testing Navigation
        const val NAVIGATION_TESTING = "androidx.navigation:navigation-testing:$NAV_VERSION"

        const val NAVIGATION_COMPOSE = "androidx.navigation:navigation-compose:$NAV_VERSION"
    }
}
fun DependencyHandler.importUnitTest(testImplementation: Boolean = true) {
    val configName = if (testImplementation) "testImplementation" else "implementation"

    add(configName, Dependency.TestLibrary.JUNIT)
}

fun DependencyHandler.importAndroidTest(androidTestImplementation: Boolean = true) {
    val configName = "androidTestImplementation"

    add(configName, Dependency.TestLibrary.EXT_JUNIT)
    add(configName, Dependency.TestLibrary.ESPRESSO_CORE)
    add(configName, Dependency.TestLibrary.ANNOTATION)
}

fun DependencyHandler.importDagger() {

    add("implementation", Dependency.DaggerLibrary.DAGGER)
    add("implementation", Dependency.DaggerLibrary.DAGGER_SUPPORT)
    add("kapt", Dependency.DaggerLibrary.DAGGER_PROCESSOR)
    add("kapt", Dependency.DaggerLibrary.DAGGER_COMPILER)
}

fun DependencyHandler.importRoom() {

    add("implementation", Dependency.RoomLibrary.ROOM_KTX)
    add("implementation", Dependency.RoomLibrary.ROOM_RUNTIME)
    add("kapt", Dependency.RoomLibrary.ROOM_COMPILER)
}

fun DependencyHandler.importPaging() {

    add("implementation", Dependency.Paging.runtime)
    add("testImplementation", Dependency.Paging.common)
}

fun DependencyHandler.importBaseAPI() {
    val configName = "implementation"
    add(configName, Dependency.APILibrary.RETROFIT2)
    add(configName, Dependency.APILibrary.RETROFIT2_GSON)
    add(configName, Dependency.APILibrary.OKHTTP3)
    add(configName, Dependency.APILibrary.OKHTTP3_LOGGING)
}

inline val DependencyHandler.serviceGenre get() = project(":service_genre")
inline val DependencyHandler.core get() = project(":core")
inline val DependencyHandler.baseMvi get() = project(":base_mvi")
inline val DependencyHandler.featureHome get() = project(":feature_home")
inline val DependencyHandler.featureDetail get() = project(":feature_detail")
inline val DependencyHandler.featureSearch get() = project(":feature_search")
inline val DependencyHandler.app get() = project(":app")