plugins {
//    id("com.android.dynamic-feature")
    id("com.android.library")
//    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-android")
}
android {
    namespace = "${Config.namespace}.search"
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
    implementation(Dependency.CoreLibrary.KTX)
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    testImplementation(Dependency.TestLibrary.JUNIT)// 'junit:junit:4.13.2'
    androidTestImplementation(Dependency.TestLibrary.EXT_JUNIT)// 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation(Dependency.TestLibrary.ESPRESSO_CORE)// 'androidx.test.espresso:espresso-core:3.5.1'
    androidTestImplementation(Dependency.TestLibrary.ANNOTATION)// 'androidx.annotation:annotation:1.6.0'


    importDagger()
    implementation(core)
    implementation(serviceGenre)
    importPaging()

    implementation("androidx.fragment:fragment-ktx:1.2.4")
}