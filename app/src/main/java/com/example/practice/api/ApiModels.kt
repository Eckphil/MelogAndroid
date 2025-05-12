package com.example.practice.api

// Diary 관련

data class DiaryCreateRequest(
    val content: String
)

data class DiaryUpdateRequest(
    val content: String?
)

data class DiaryResponse(
    val id: Int,
    val user_id: Int,
    val content: String,
    val emotiontype_id: Int?,
    val confidence: Float?,
    val recommended_songs: List<SongResponse>,
    val top_emotions: List<EmotionStatisticsSchema>,
    val created_at: String,
    val updated_at: String
)


data class DiaryCountResponse(
    val user_id: Int,
    val year: Int,
    val month: Int,
    val diary_count: Int
)

// Emotion 관련

data class EmotionStatisticsSchema(
    val emotiontype_id: Int,
    val count: Int,
    val quadrant: Int?
)

data class EmotionSummaryResponse(
    val top_emotion_group: String,
    val group_distribution: Map<String, Int>,
    val message: String,
    val suggestion: String
)

// Genre 관련

data class GenreResponse(
    val id: Int,
    val name: String
)

// Song 관련

data class SongResponse(
    val song_id: Int,
    val song_name: String,
    val artist: List<String>,
    val genre: String,
    val album_image: String,
    val best_lyric: String,
    val similarity_score: Float
)

// User 관련

data class UserCreateRequest(
    val user_id: String,
    val password: String,
    val nickname: String,
    val phone: String?
)

data class UserLoginRequest(
    val user_id: String,
    val password: String
)

data class UserLoginResponse(
    val access_token: String,
    val refresh_token: String
)

data class UserRegisterResponse(
    val user_id: String,
    val nickname: String,
    val phone: String?
)

data class UserResponse(
    val user_id: String,
    val nickname: String,
    val phone: String?,
    val user_genres: List<UserGenreInfoResponse>
)

data class UserPasswordUpdateRequest(
    val password: String
)

data class UserUpdateRequest(
    val nickname: String?,
    val phone: String?
)

data class UserGenreResponse(
    val id: Int,
    val user_id: Int,
    val genre: GenreResponse,
    val created_at: String
)

data class UserGenreInfoResponse(
    val genre: GenreResponse
)

// Validation Error 관련

data class ValidationError(
    val loc: List<Any>,
    val msg: String,
    val type: String
)

data class HTTPValidationError(
    val detail: List<ValidationError>
)
