package com.sudzu.trtlmtest.data.network

import com.sudzu.trtlmtest.data.model.BugsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BugsApi {
    @GET("bug")
    suspend fun getBugs(
        @Query("product") product: String = "Thunderbird",
        @Query("limit") limit: Int = 20
    ): BugsResponse
}