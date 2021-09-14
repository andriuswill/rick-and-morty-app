package com.andriuswill.rickandmortyapp.module

import com.andriuswill.rickandmortyapp.BuildConfig
import com.andriuswill.rickandmortyapp.api.Api
import com.andriuswill.rickandmortyapp.api.Repository
import com.andriuswill.rickandmortyapp.api.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiBuilder {

    private val baseUrl = "https://rickandmortyapi.com/api/"

    private fun getClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()

        interceptor.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun retrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun instance(): Api =
        retrofit().create(Api::class.java)


    @Singleton
    @Provides
    fun providerHelper(repository: RepositoryImpl): Repository = repository



}
