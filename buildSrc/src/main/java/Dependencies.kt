object Dependencies {

    const val AndroidGradlePlugin =
        "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val HiltClathPath =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT_VERSION}"


    val AndroidXCore = arrayOf("androidx.core:core:1.5.0", "androidx.core:core-ktx:1.5.0")

    val AndroidXLibs = arrayOf(
        // Android Annotation
        "androidx.annotation:annotation:1.2.0",

        "androidx.appcompat:appcompat:${Versions.AndroidX.main}",
        // MultiDex
        "androidx.multidex:multidex:${Versions.AndroidX.multiDex}",
        // ConstraintLayout
        "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}",
        // Android Material
        "com.google.android.material:material:${Versions.AndroidX.material}",
        "androidx.recyclerview:recyclerview:${Versions.RECYCLEVIEW_VERSION}"
    )

    val AndroidArchComponent = arrayOf(
        "androidx.lifecycle:lifecycle-extensions:${Versions.AndroidX.lifeCycle}",
        "androidx.lifecycle:lifecycle-reactivestreams:${Versions.AndroidX.lifeCycle}"
    )


    val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val LifeCycleAnnotations =
        "androidx.lifecycle:lifecycle-compiler:${Versions.AndroidX.lifeCycle}"

    val Testing = arrayOf(
        // Android Unit Testing
        "androidx.test:runner:${Versions.Testing.runner}",
        "androidx.test.espresso:espresso-core:${Versions.Testing.espresso}",

        // Mockito
        "org.mockito:mockito-core:${Versions.Testing.mockito}",

        // JUnit
        "junit:junit:${Versions.Testing.junit}"
    )

    const val Kotlin =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.std}"
    const val KotlinPlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin.std}"


    val RxJava = arrayOf(
        "io.reactivex.rxjava3:rxkotlin:${Versions.RX.rxKotlin}",
        "io.reactivex.rxjava3:rxjava:${Versions.RX.rxJava}"
    )
    val RxAndroid = arrayOf(
        "io.reactivex.rxjava3:rxandroid:${Versions.RX.rxAndroid}"
    )

    val Retrofit = arrayOf(
        "com.squareup.okhttp3:okhttp:${Versions.Retrofit.okHttp}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.Retrofit.okHttp}",
        "com.squareup.okhttp3:okhttp-urlconnection:${Versions.Retrofit.okHttp}",
        "com.squareup.retrofit2:retrofit:${Versions.Retrofit.retrofit}",
        "com.squareup.retrofit2:adapter-rxjava3:${Versions.Retrofit.retrofit}",
        "com.squareup.retrofit2:converter-gson:${Versions.Retrofit.retrofit}"
    )


    val Coroutines = arrayOf(
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutines.coroutinesCoreVersion}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Versions.Coroutines.coroutinesCommonVersion}",
        "androidx.lifecycle:lifecycle-extensions:${Versions.Coroutines.lifecycleExtensionsVersion}",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Coroutines.lifecycleKTXVersion}",
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Coroutines.lifecycleKTXVersion}"
    )


    val Room = arrayOf(
        "androidx.room:room-runtime:${Versions.AndroidX.lifeCycle}",
        "androidx.room:room-rxjava2:${Versions.AndroidX.lifeCycle}"
    )

    const val RoomKapt =
        "androidx.room:room-compiler:${Versions.AndroidX.lifeCycle}"
    const val HiltDagger = "com.google.dagger:hilt-android:${Versions.HILT_VERSION}"
    const val HiltKapt = "com.google.dagger:hilt-compile:${Versions.HILT_VERSION}"
    const val Koin =
        "org.koin:koin-androidx-scope:${Versions.KOIN}"

    val KoinAndroid = arrayOf(
        Koin,
        "org.koin:koin-androidx-viewmodel:${Versions.KOIN}",
        "org.koin:koin-androidx-ext:${Versions.KOIN}"
    )

    const val Gson = "com.google.code.gson:gson:${Versions.GSON}"

    const val Ktlint = "com.pinterest:ktlint:${Versions.KTLINT}"

    const val SDB = "com.intuit.sdp:sdp-android:${Versions.SDB_VERSION}"

    const val CIRCLE_IMAGE = "de.hdodenhof:circleimageview:${Versions.CIRCLE_IMAGE}"

    const val LOADING = "com.github.ybq:Android-SpinKit:${Versions.SPIN_KIT}"
    val exo_player = arrayOf(
        "com.google.android.exoplayer:exoplayer:${Versions.EXO_VERSION}",
        "com.google.android.exoplayer:exoplayer-core:${Versions.EXO_VERSION}",
        "com.google.android.exoplayer:exoplayer-dash:${Versions.EXO_VERSION}",
        "com.google.android.exoplayer:exoplayer-ui:${Versions.EXO_VERSION}"
    )


}
