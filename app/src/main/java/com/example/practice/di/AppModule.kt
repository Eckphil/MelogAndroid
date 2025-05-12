package com.example.practice.di

import com.example.practice.api.MelogApi
import com.example.practice.repository.DiaryRepository
import com.example.practice.repository.DiaryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMelogApi(): MelogApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://melog.ngrok.app") // 실제 API URL로 교체
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(MelogApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDiaryRepository(melogApi: MelogApi): DiaryRepository {
        return DiaryRepositoryImpl(melogApi)
    }
}
