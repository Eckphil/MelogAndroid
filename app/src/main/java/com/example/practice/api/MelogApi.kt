package com.example.practice.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MelogApi {
// ---------------------- User 관련 ----------------------

    @POST("/user/register")
    fun registerUser(@Body request: UserCreateRequest): Call<UserRegisterResponse>

    @POST("/user/login")
    fun loginUser(@Body request: UserLoginRequest): Call<UserLoginResponse>

    @POST("/user/logout")
    fun logoutUser(): Call<Unit>

    @POST("/user/check-password")
    fun checkPassword(@Body request: UserPasswordUpdateRequest): Call<Unit>

    @POST("/user/refresh")
    fun refreshToken(): Call<UserLoginResponse>

    @GET("/user/me")
    fun getUserInfo(): Call<UserResponse>

    @GET("/user/check/auth")
    fun checkAuth(): Call<Unit>

    @PUT("/user/change/info")
    fun updateUserInfo(@Body request: UserUpdateRequest): Call<UserResponse>

    @PUT("/user/change/password")
    fun updatePassword(@Body request: UserPasswordUpdateRequest): Call<Unit>

    @DELETE("/user/delete")
    fun deleteUser(): Call<Unit>

    @POST("/user/genre/{genre_id}")
    fun addGenre(@Path("genre_id") genreId: Int): Call<Unit>

    @DELETE("/user/genre/{genre_id}")
    fun deleteGenre(@Path("genre_id") genreId: Int): Call<Unit>

    @GET("/user/genre")
    fun getUserGenres(): Call<List<UserGenreResponse>>

    // ---------------------- Diary 관련 ----------------------

    @GET("/diary")
    fun getDiaries(): Call<List<DiaryResponse>>

    @POST("/diary")
    fun createDiary(@Body request: DiaryCreateRequest): Call<List<SongResponse>>

    @POST("/diary/main")
    fun createDiaryMain(@Body request: DiaryCreateRequest): Call<List<SongResponse>>

    @GET("/diary/{diary_id}")
    fun getDiary(@Path("diary_id") diaryId: Int): Call<DiaryResponse>

    @PUT("/diary/{diary_id}")
    fun updateDiary(@Path("diary_id") diaryId: Int, @Body request: DiaryUpdateRequest): Call<DiaryResponse>

    @DELETE("/diary/{diary_id}")
    fun deleteDiary(@Path("diary_id") diaryId: Int): Call<Unit>

    @GET("/diary/{year}/{month}")
    fun getDiaryByDate(@Path("year") year: Int, @Path("month") month: Int): Call<List<DiaryResponse>>

    @GET("/diary/{year}/{month}/count")
    fun getDiaryCountByDate(@Path("year") year: Int, @Path("month") month: Int): Call<DiaryCountResponse>

    // ---------------------- Genre 관련 ----------------------

    @GET("/genre")
    fun getAllGenres(): Call<List<GenreResponse>>

    @POST("/genre/new")
    fun addNewGenre(@Body request: GenreResponse): Call<GenreResponse>

    // ---------------------- Songs 관련 ----------------------

    @GET("/songs")
    fun getSongs(): Call<List<SongResponse>>

    @GET("/songs/genre")
    fun getSongsByGenre(): Call<List<SongResponse>>

    // ---------------------- Statistics 관련 ----------------------

    @GET("/statistics/current-month")
    fun getCurrentMonthStatistics(): Call<List<EmotionStatisticsSchema>>

    @GET("/statistics")
    fun getAllStatistics(): Call<List<EmotionStatisticsSchema>>

    @GET("/statistics/{year}/{month}")
    fun getStatisticsByMonth(@Path("year") year: Int, @Path("month") month: Int): Call<List<EmotionStatisticsSchema>>

    // ---------------------- Default ----------------------

    @GET("/")
    fun readRoot(): Call<String>
}