package com.example.practice.repository

import com.example.practice.api.DiaryResponse
import com.example.practice.api.MelogApi
import javax.inject.Inject

class DiaryRepositoryImpl @Inject constructor(
    private val melogApi: MelogApi
) : DiaryRepository {
    override suspend fun getDiariesByMonth(year: Int, month: Int): List<DiaryResponse> {
        val response = melogApi.getDiaryByDate(year, month)
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList() // 실패 시 빈 리스트 반환
        }
    }
}
