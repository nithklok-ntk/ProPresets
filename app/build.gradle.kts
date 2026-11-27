plugins {
    id("com.android.application") version "9.1.1"
}

android {
    namespace = "com.propresets.camera"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.propresets.camera"
        minSdk = 31
        targetSdk = 36
        versionCode = 1
        versionName = "0.1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
