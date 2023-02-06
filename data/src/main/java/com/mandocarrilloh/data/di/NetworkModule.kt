package com.mandocarrilloh.data.di

import android.content.Context
import android.util.Log
import com.chuckerteam.chucker.api.ChuckerInterceptor
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import okhttp3.Interceptor
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 60_000L

/**
 * Provide the Network.
 */

internal val networkModule = module {
    single<String> { getBaseUrl() }
    single<Interceptor> { provideLoggerInterceptor(get()) }
    single<HttpClient> { provideNetworkClient(get()) }
}

private fun getBaseUrl(): String = "https://api.mercadolibre.com"

private fun provideLoggerInterceptor(
    context: Context
): Interceptor = ChuckerInterceptor(context)

private fun provideNetworkClient(
    loggerInterceptors: Interceptor
) = HttpClient(OkHttp) {
    install(JsonFeature) {
        serializer = KotlinxSerializer(
            kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            }
        )
    }

    engine {
        addInterceptor(loggerInterceptors)
        config {
            connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
        }
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.d("HTTP =>", message)
            }
        }
        level = LogLevel.ALL
    }

    install(ResponseObserver) {
        onResponse { response ->
            Log.d("HTTP => status: ", "${response.status.value}")
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
}