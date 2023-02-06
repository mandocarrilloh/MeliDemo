plugins {
    id(Pluggins.androidApplication)
    kotlin(Pluggins.kotlinAndroid)
    id(Pluggins.kotlinParcelizeExtensions)
    kotlin(Pluggins.kotlinKapt)
    id(Pluggins.androidNavigation)
    kotlin(Pluggins.serialization) version kotlinVersion
}

android {
    compileSdk = Application.compileSdk

    defaultConfig {
        applicationId = Application.appId
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeCompilerVersion
    }
}

repositories {
    maven { url = uri("https://maven.google.com") }
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    //Domain
    implementation(project(":domain"))

    //Data
    implementation(project(":data"))

    //Kotlin
    Libraries.kotlinLibraries.forEach { implementation(it) }
    implementation(Libraries.dateTimeLibrary)

    //Kotlin KTX
    Libraries.kotlinKtx.forEach { implementation(it) }

    //Compose
    Libraries.composeLibrary.forEach { implementation(it) }

    //Ktor
    implementation(Libraries.ktorAndroidLibrary)
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //Glide
    Libraries.glideLibraries.forEach { implementation(it) }
    annotationProcessor(Libraries.glideAnnotationProcessor)

    //Lifecycle
    Libraries.lifecycleLibraries.forEach { implementation(it) }

    //Permissions
    implementation(Libraries.permissionsLibrary)
    kapt(Libraries.permissionsKaptLibrary)

    //AndroidX
    Libraries.androidXLibraries.forEach { implementation(it) }

    //Navigation
    Libraries.navigationLibraries.forEach { implementation(it) }

    //Preferences
    implementation(Libraries.preferenceLibrary)

    //Koin
    Libraries.koinLibraries.forEach { implementation(it) }

    //Testing
    Libraries.testingLibraries.forEach { testImplementation(it) }
    Libraries.androidTestLibraries.forEach { androidTestImplementation(it) }
    Libraries.powerMockLibraries.forEach { testImplementation(it) }

    //Room
    Libraries.roomLibrary.forEach { implementation(it) }

    //Chuck
    debugImplementation(Libraries.chuckDebugLibrary)
    releaseImplementation(Libraries.chuckReleaseLibrary)

    //Leakcanary
    debugImplementation(Libraries.leakcanaryLibrary)

    //Ktor
    implementation(Libraries.ktorCoreLibrary)
    implementation(Libraries.ktorClientSerializationLibrary)
    implementation(Libraries.dateTimeLibrary)
    implementation(Libraries.ktorAndroidLibrary)
    implementation(Libraries.ktorOkHttpLibrary)
    implementation(Libraries.ktorLoggerLibrary)
    implementation(Libraries.loggingLibrary)

    //Groupie
    Libraries.groupieLibrary.forEach { implementation(it) }
}