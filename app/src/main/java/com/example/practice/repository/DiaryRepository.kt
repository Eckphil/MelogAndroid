package com.example.practice.repository

import com.example.practice.api.DiaryResponse

interface DiaryRepository {
    suspend fun getDiariesByMonth(year: Int, month: Int): List<DiaryResponse>
}
