package com.android.marvelapi.api

import com.android.marvelapi.utils.Constants.Api.HASH
import com.android.marvelapi.utils.Constants.Api.MARVEL_BASE_URL
import com.android.marvelapi.utils.Constants.Api.MARVEL_KEY_PARAMETER_NAME
import com.android.marvelapi.utils.Constants.Api.MARVEL_PRIVATE_KEY
import com.android.marvelapi.utils.Constants.Api.MARVEL_PUBLIC_KEY
import com.android.marvelapi.utils.Constants.Api.TIMESTAMP
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.concurrent.TimeUnit

object MarvelApiService {
    val marvelAPI: MarvelAPI = getMarvelApiClient().create(MarvelAPI::class.java)

    private fun getMarvelApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(MARVEL_BASE_URL)
            .client(getInterceptorClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getInterceptorClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptor = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val currentTimestamp = System.currentTimeMillis()
                val url = chain.request().url().newBuilder()
                    .addQueryParameter(TIMESTAMP, currentTimestamp.toString())
                    .addQueryParameter(MARVEL_KEY_PARAMETER_NAME, MARVEL_PUBLIC_KEY)
                    .addQueryParameter(HASH, createMD5hash(currentTimestamp.toString() + MARVEL_PRIVATE_KEY + MARVEL_PUBLIC_KEY))
                    .build()
                chain.proceed(chain.request().newBuilder().url(url).build())
            }
            .addInterceptor(loggingInterceptor)
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
        return interceptor.build()
    }

    private fun createMD5hash(data: String): String {
        var string = data
        var encryptedString: String? = null
        val md5: MessageDigest
        try {
            md5 = MessageDigest.getInstance("MD5")
            md5.update(string.toByteArray(), 0, string.length)
            string = BigInteger(1, md5.digest()).toString(16)
            while(string.length < 32) {
                string = "0$string"
            }

            encryptedString = string

        } catch(e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return encryptedString ?: ""
    }
}