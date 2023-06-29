plugins {
//    id("com.android.dynamic-feature")
    id("com.android.library")
//    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-android")
}
android {
    namespace = "${Config.namespace}.home"
    compileSdk = Config.compiledSDK

    defaultConfig {
        minSdk = Config.minSdk
        testInstrumentationRunner = Config.testInstrumentationRunner
    }
    buildFeatures {
        viewBinding = true
    }
    buildTypes {
        release {
            isMinifyEnabled = Config.isMinifyEnabled
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
}

dependencies {
    val nav_version = "2.5.3"
//    implementation(project(":app"))
    implementation(Dependency.CoreLibrary.KTX)
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    testImplementation(Dependency.TestLibrary.JUNIT)
    androidTestImplementation(Dependency.TestLibrary.EXT_JUNIT)
    androidTestImplementation(Dependency.TestLibrary.ESPRESSO_CORE)
    androidTestImplementation(Dependency.TestLibrary.ANNOTATION)

    importDagger()

    implementation(serviceGenre)
    implementation(core)
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
}