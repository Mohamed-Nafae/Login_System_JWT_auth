package com.plcoding.jwtauthktorandroid.auth

interface AuthRepository {
    suspend fun  signIn( email: String , password : String):AuthResult<Unit>
    suspend fun  authenticate():AuthResult<Patient>
}