import Libraries.Dependencies.daggerVersion

const val kotlinVersion = "1.7.20"
const val navigationVersion = "2.4.1"
const val composeVersion = "1.3.3"
const val composeMaterialVersion = "1.3.1"
const val composeCompilerVersion = "1.3.2"

object Libraries {
    private object Dependencies {
        const val ktxVersion = "1.7.0"
        const val constraintLayoutVersion = "2.0.4"
        const val glideVersion = "4.10.0"
        const val lifecycleVersion = "2.5.1"
        const val androidMaterialVersion = "1.2.0-alpha05"
        const val coroutinesVersion = "1.6.1"
        const val daggerVersion = "2.41"
        const val activityVersion = "1.4.0"
        const val fragmentVersion = "1.4.1"
        const val groupieVersion = "2.9.0"
        const val junitVersion = "4.13"
        const val mockitoVersion = "2.19.0"
        const val mockitoKotlinVersion = "2.2.0"
        const val powerMockVersion = "1.6.5"
        const val powerMockModuleApiVersion = "2.0.0"
        const val junitRulesVersion = "1.2.0"
        const val junitExtVersion = "1.1.1"
        const val testVersion = "1.4.0"
        const val espressoVersion = "3.2.0"
        const val inappmessagingVersion = "20.0.0"
        const val ktorVersion = "1.6.8"
        const val kotlinxDatetimeVersion = "0.3.2"
        const val viewPager2Version = "1.1.0-alpha01"
        const val serializationVersion = "1.3.2"
        const val navComposeVersion = "2.5.3"
    }

    // Testing
    val testingLibraries = arrayOf(
        "junit:junit:${Dependencies.junitVersion}",
        "org.mockito:mockito-core:${Dependencies.mockitoVersion}",
        "org.mockito:mockito-inline:${Dependencies.mockitoVersion}",
        "com.nhaarman.mockitokotlin2:mockito-kotlin:${Dependencies.mockitoKotlinVersion}"
    )
    val androidTestLibraries = arrayOf(
        "androidx.test:core:${Dependencies.testVersion}",
        "androidx.test:runner:${Dependencies.testVersion}",
        "androidx.test:rules:${Dependencies.junitRulesVersion}",
        "androidx.test.ext:junit:${Dependencies.junitExtVersion}",
        "androidx.test.espresso:espresso-core:${Dependencies.espressoVersion}"
    )

    // PowerMock
    val powerMockLibraries = arrayOf(
        "org.powermock:powermock:${Dependencies.powerMockVersion}",
        "org.powermock:powermock-module-junit4:${Dependencies.powerMockModuleApiVersion}",
        "org.powermock:powermock-api-mockito2:${Dependencies.powerMockModuleApiVersion}",
        "org.powermock:powermock-module-junit4:${Dependencies.powerMockModuleApiVersion}"
    )

    // Kotlin
    val kotlinLibraries = arrayOf(
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}",
        "org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Dependencies.coroutinesVersion}"
    )

    // Ktx
    val kotlinKtx = arrayOf(
        "androidx.core:core-ktx:${Dependencies.ktxVersion}",
        "androidx.activity:activity-ktx:${Dependencies.activityVersion}",
        "androidx.fragment:fragment-ktx:${Dependencies.fragmentVersion}",
        "androidx.paging:paging-runtime-ktx:2.1.1",
        "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0",
        "androidx.work:work-runtime:2.7.1",
        "androidx.work:work-runtime-ktx:2.7.1",
        "com.google.android.play:core-ktx:1.8.1",
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Dependencies.serializationVersion}",
    )

    // Glide
    val glideLibraries = arrayOf(
        "com.github.bumptech.glide:glide:${Dependencies.glideVersion}",
        "com.github.bumptech.glide:okhttp-integration:${Dependencies.glideVersion}",
        "com.github.2coffees1team:GlideToVectorYou:v2.0.0",
        "com.github.skydoves:landscapist-glide:1.5.1",
        "io.coil-kt:coil-compose:2.0.0-rc03",
    )
    const val glideAnnotationProcessor =
        "com.github.bumptech.glide:compiler:${Dependencies.glideVersion}"

    // Lifecycle
    val lifecycleLibraries = arrayOf(
        "androidx.lifecycle:lifecycle-runtime:${Dependencies.lifecycleVersion}",
        "androidx.lifecycle:lifecycle-extensions:2.2.0",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Dependencies.lifecycleVersion}",
        "androidx.lifecycle:lifecycle-runtime-ktx:${Dependencies.lifecycleVersion}",
        "androidx.lifecycle:lifecycle-common-java8:${Dependencies.lifecycleVersion}",
        "androidx.lifecycle:lifecycle-livedata-ktx:${Dependencies.lifecycleVersion}"
    )

    // Permissions
    const val permissionsLibrary = "org.permissionsdispatcher:permissionsdispatcher:4.8.0"
    const val permissionsKaptLibrary =
        "org.permissionsdispatcher:permissionsdispatcher-processor:4.8.0"

    // AndroidX
    val androidXLibraries = arrayOf(
        "com.google.android.material:material:${Dependencies.androidMaterialVersion}",
        "androidx.cardview:cardview:1.0.0",
        "androidx.legacy:legacy-support-v4:1.0.0",
        "androidx.appcompat:appcompat:1.1.0",
        "androidx.recyclerview:recyclerview:1.1.0",
        "androidx.vectordrawable:vectordrawable:1.1.0",
        "androidx.constraintlayout:constraintlayout:${Dependencies.constraintLayoutVersion}",
        "androidx.viewpager2:viewpager2:${Dependencies.viewPager2Version}"
    )

    // Preference
    const val preferenceLibrary = "androidx.preference:preference:1.1.1"

    // Navigation
    val navigationLibraries = arrayOf(
        "androidx.navigation:navigation-fragment-ktx:$navigationVersion",
        "androidx.navigation:navigation-ui-ktx:$navigationVersion"
    )

    // Dagger
    val daggerLibrary = arrayOf(
        "com.google.dagger:dagger:$daggerVersion",
        "com.google.dagger:dagger-android:$daggerVersion",
        "com.google.dagger:dagger-android-support:$daggerVersion"
    )
    val daggerKaptLibrary = arrayOf(
        "com.google.dagger:dagger-compiler:$daggerVersion",
        "com.google.dagger:dagger-android-processor:$daggerVersion"
    )

    //Koin
    val koinLibraries = arrayOf(
        "io.insert-koin:koin-android:3.1.6",
        "io.insert-koin:koin-androidx-navigation:3.1.6",
        "io.insert-koin:koin-androidx-compose:3.1.6",
        //"org.koin:koin-androidx-scope:2.2.2",
        //"org.koin:koin-androidx-viewmodel:2.2.2",
        //"org.koin:koin-androidx-fragment:2.2.2",
    )

    //Chuck
    const val chuckDebugLibrary = "com.github.chuckerteam.chucker:library:3.5.2"
    const val chuckReleaseLibrary = "com.github.chuckerteam.chucker:library-no-op:3.5.2"

    //Groupie
    val groupieLibrary = arrayOf(
        "com.xwray:groupie:${Dependencies.groupieVersion}",
        "com.xwray:groupie-databinding:${Dependencies.groupieVersion}"
    )

    //Ktor
    const val ktorCoreLibrary = "io.ktor:ktor-client-core:${Dependencies.ktorVersion}"
    const val ktorLoggerLibrary = "io.ktor:ktor-client-logging:${Dependencies.ktorVersion}"
    const val ktorClientSerializationLibrary =
        "io.ktor:ktor-client-serialization:${Dependencies.ktorVersion}"
    const val ktorAndroidLibrary = "io.ktor:ktor-client-android:${Dependencies.ktorVersion}"
    const val ktorOkHttpLibrary = "io.ktor:ktor-client-okhttp:${Dependencies.ktorVersion}"
    const val dateTimeLibrary =
        "org.jetbrains.kotlinx:kotlinx-datetime:${Dependencies.kotlinxDatetimeVersion}"
    const val loggingLibrary = "com.squareup.okhttp3:logging-interceptor:4.9.3"

    //Room
    val roomLibrary = arrayOf(
        "androidx.room:room-ktx:2.4.3",
        "androidx.room:room-runtime:2.4.3"
    )
    val roomLibraryKapt = "androidx.room:room-compiler:2.4.3"

    //Leakcanary
    val leakcanaryLibrary = "com.squareup.leakcanary:leakcanary-android:2.9.1"

    //Compose
    val composeLibrary = arrayOf(
        "androidx.compose.ui:ui:$composeVersion",
        "androidx.compose.material:material:$composeMaterialVersion",
        "androidx.compose.ui:ui-tooling-preview:$composeVersion",
        "androidx.activity:activity-compose:1.5.0-rc01",
        "androidx.compose.compiler:compiler:$composeCompilerVersion",
        "androidx.constraintlayout:constraintlayout-compose:1.0.1",
        "androidx.compose.runtime:runtime-livedata:$composeVersion",
        "androidx.navigation:navigation-compose:${Dependencies.navComposeVersion}",
        //"androidx.compose.material.pullrefresh:1.3.0"
    )
}