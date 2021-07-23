plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("android.extensions")
    kotlin("android")
}

android {
    compileSdkVersion(AppConfig.compileSdkVersion)

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdkVersion(AppConfig.minSdkVersion)
        targetSdkVersion(AppConfig.targetSdkVersion)
        versionCode(AppConfig.versionCode)
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
}

val kotlin_coroutine_version = "1.3.1"

dependencies {
//    implementation(AppDependencies.kotlinStdlib)
//    implementation(AppDependencies.kotlinCore)
//    implementation(AppDependencies.appCompat)
//    implementation(AppDependencies.materialDesign)
//    implementation(AppDependencies.constraintLayout)

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlin_coroutine_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlin_coroutine_version")
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.10")
    implementation("androidx.fragment:fragment-ktx:1.4.0-alpha04")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation(AppDependencies.jUnit)
    androidTestImplementation(AppDependencies.extJunit)
    androidTestImplementation(AppDependencies.expresso)
}