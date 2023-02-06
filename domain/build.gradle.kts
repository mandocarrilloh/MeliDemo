plugins {
    id(Pluggins.androidLibrary)
    kotlin(Pluggins.kotlinAndroid)
    id(Pluggins.kotlinParcelizeExtensions)
    kotlin(Pluggins.kotlinKapt)
    kotlin(Pluggins.serialization) version kotlinVersion
}

android {
    compileSdk = Application.compileSdk

    defaultConfig {
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    //Kotlin
    Libraries.kotlinLibraries.forEach {
        implementation(it)
    }

    //Kotlin KTX
    Libraries.kotlinKtx.forEach {
        implementation(it)
    }

    //Koin
    Libraries.koinLibraries.forEach { implementation(it) }

    //Ktor
    implementation(Libraries.ktorCoreLibrary)
    implementation(Libraries.ktorClientSerializationLibrary)
    implementation(Libraries.dateTimeLibrary)
    implementation(Libraries.ktorAndroidLibrary)
    implementation(Libraries.ktorOkHttpLibrary)
    implementation(Libraries.ktorLoggerLibrary)
    implementation(Libraries.loggingLibrary)

    //Testing
    Libraries.testingLibraries.forEach { testImplementation(it) }
    Libraries.androidTestLibraries.forEach { androidTestImplementation(it) }
    Libraries.powerMockLibraries.forEach { testImplementation(it) }
}