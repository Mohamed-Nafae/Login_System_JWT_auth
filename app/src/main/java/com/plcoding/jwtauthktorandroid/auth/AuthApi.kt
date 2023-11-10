package com.plcoding.jwtauthktorandroid.auth

import android.content.SharedPreferences
import retrofit2.http.*



interface AuthApi {
    @POST("login")
    suspend fun singIn(
        @Body request: AuthRequest
    ): TokenResponse

    @GET("{id}")
    suspend fun authenticate(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ):Patient
}
