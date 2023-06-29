plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "${Config.namespace}.service_genre"
    compileSdk = Config.compiledSDK

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = Config.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(Dependency.CoreLibrary.KTX)
    implementation(project(":api"))
    implementation(core)

    // retrofit
    importBaseAPI()
//    implementation(Dependency.APILibrary.RETROFIT2)
//    implementation(Dependency.APILibrary.RETROFIT2_GSON)
//    implementation(Dependency.APILibrary.OKHTTP3_LOGGING)

    //Dagger2-Kotlin
//    kapt("com.google.dagger:dagger-compiler:${Dependency.DaggerLibrary.DAGGER_VERSION}")
//    kapt("com.google.dagger:dagger-android-processor:${Dependency.DaggerLibrary.DAGGER_VERSION}")
//    implementation("com.google.dagger:dagger:${Dependency.DaggerLibrary.DAGGER_VERSION}")
    importDagger()
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    importRoom()
    importPaging()

    // Room
//    implementation(Dependency.RoomLibrary.ROOM_KTX)
//    implementation(Dependency.RoomLibrary.ROOM_RUNTIME)
//    annotationProcessor(Dependency.RoomLibrary.ROOM_COMPILER)
}