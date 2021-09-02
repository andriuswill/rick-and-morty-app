package com.andriuswill.rickandmortyapp.module

import com.andriuswill.rickandmortyapp.api.Api
import com.andriuswill.rickandmortyapp.api.Repository
import com.andriuswill.rickandmortyapp.api.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiBuilder {

    private val baseUrl = "https://rickandmortyapi.com/api/"

    @Singleton
    @Provides
    fun retrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl(baseUrl)
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
