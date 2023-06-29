plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = Config.namespace
    compileSdk = Config.compiledSDK

    defaultConfig {
        applicationId = Config.applicationID
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = Config.isMinifyEnabled
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()//Config.jvmTarget
    }
//    dynamicFeatures += setOf(":feature_home", ":feature_detail")
}

dependencies {
    implementation(Dependency.CoreLibrary.KTX)
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    kapt("com.google.dagger:dagger-compiler:${Dependency.DaggerLibrary.DAGGER_VERSION}")
//    kapt("com.google.dagger:dagger-android-processor:${Dependency.DaggerLibrary.DAGGER_VERSION}")
//    implementation("com.google.dagger:dagger:${Dependency.DaggerLibrary.DAGGER_VERSION}")
//    implementation(Dependency.DaggerLibrary.DAGGER_SUPPORT)
    importDagger()
    importPaging()
    implementation(serviceGenre)
    implementation(core)
    //    implementation("androidx.activity:activity-ktx:$activity_version")
    implementation("androidx.fragment:fragment-ktx:1.2.4")
    implementation(featureHome)
    implementation(featureDetail)
    implementation(featureSearch)



    // jetpack navigation
    val nav_version = "2.5.3"

    // Java language implementation
    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui:$nav_version")

    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")

    implementation(Dependency.APILibrary.RETROFIT2)
    implementation(Dependency.APILibrary.RETROFIT2_GSON)
    implementation(Dependency.APILibrary.OKHTTP3_LOGGING)
    importBaseAPI()

    importRoom()

//    implementation("android.arch.navigation:navigation-fragment-ktx:2.3.0")
//    implementation("android.arch.navigation:navigation-ui-ktx:2.3.0")
//    implementation("androidx.legacy:legacy-support-v4:1.0.0")
}