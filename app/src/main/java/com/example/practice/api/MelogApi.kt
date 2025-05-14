package com.example.practice.api

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
    suspend fun registerUser(@Body request: UserCreateRequest): Response<UserRegisterResponse>

    @POST("/user/login")
    suspend fun loginUser(@Body request: UserLoginRequest): Response<UserLoginResponse>

    @POST("/user/logout")
    suspend fun logoutUser(): Response<Unit>

    @POST("/user/check-password")
    suspend fun checkPassword(@Body request: UserPasswordUpdateRequest): Response<Unit>

    @POST("/user/refresh")
    suspend fun refreshToken(): Response<UserLoginResponse>

    @GET("/user/me")
    suspend fun getUserInfo(): Response<UserResponse>

    @GET("/user/check/auth")
    suspend fun checkAuth(): Response<Unit>

    @PUT("/user/change/info")
    suspend fun updateUserInfo(@Body request: UserUpdateRequest): Response<UserResponse>

    @PUT("/user/change/password")
    suspend fun updatePassword(@Body request: UserPasswordUpdateRequest): Response<Unit>

    @DELETE("/user/delete")
    suspend fun deleteUser(): Response<Unit>

    @POST("/user/genre/{genre_id}")
    suspend fun addGenre(@Path("genre_id") genreId: Int): Response<Unit>

    @DELETE("/user/genre/{genre_id}")
    suspend fun deleteGenre(@Path("genre_id") genreId: Int): Response<Unit>

    @GET("/user/genre")
    suspend fun getUserGenres(): Response<List<UserGenreResponse>>

    // ---------------------- Diary 관련 ----------------------

    @GET("/diary")
    suspend fun getDiaries(): Response<List<DiaryResponse>>

    @POST("/diary")
    suspend fun createDiary(@Body request: DiaryCreateRequest): Response<List<SongResponse>>

    @POST("/diary/main")
    suspend fun createDiaryMain(@Body request: DiaryCreateRequest): Response<DiaryResponse>

    @GET("/diary/{diary_id}")
    suspend fun getDiary(@Path("diary_id") diaryId: Int): Response<DiaryResponse>

    @PUT("/diary/{diary_id}")
    suspend fun updateDiary(@Path("diary_id") diaryId: Int, @Body request: DiaryUpdateRequest): Response<DiaryResponse>

    @DELETE("/diary/{diary_id}")
    suspend fun deleteDiary(@Path("diary_id") diaryId: Int): Response<Unit>

    @GET("/diary/{year}/{month}")
    suspend fun getDiaryByDate(@Path("year") year: Int, @Path("month") month: Int): Response<List<DiaryResponse>>

    @GET("/diary/{year}/{month}/count")
    suspend fun getDiaryCountByDate(@Path("year") year: Int, @Path("month") month: Int): Response<DiaryCountResponse>

    // ---------------------- Genre 관련 ----------------------

    @GET("/genre")
    suspend fun getAllGenres(): Response<List<GenreResponse>>

    @POST("/genre/new")
    suspend fun addNewGenre(@Body request: GenreResponse): Response<GenreResponse>

    // ---------------------- Songs 관련 ----------------------

    @GET("/songs")
    suspend fun getSongs(): Response<List<SongResponse>>

    @GET("/songs/genre")
    suspend fun getSongsByGenre(): Response<List<SongResponse>>

    // ---------------------- Statistics 관련 ----------------------

    @GET("/statistics/current-month")
    suspend fun getCurrentMonthStatistics(): Response<List<EmotionStatisticsSchema>>

    @GET("/statistics")
    suspend fun getAllStatistics(): Response<List<EmotionStatisticsSchema>>

    @GET("/statistics/{year}/{month}")
    suspend fun getStatisticsByMonth(@Path("year") year: Int, @Path("month") month: Int): Response<List<EmotionStatisticsSchema>>

    // ---------------------- Default ----------------------

    @GET("/")
    suspend fun readRoot(): Response<String>
}