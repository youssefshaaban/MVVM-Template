package com.example.mvvm_template.di

import com.example.mvvm_template.data.ServiceGenerator
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

import javax.inject.Singleton
@Module
@InstallIn(ApplicationComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideServiceGenerator() : ServiceGenerator = ServiceGenerator()

}