package com.plcoding.jwtauthktorandroid.auth

import android.content.SharedPreferences
import retrofit2.HttpException
import java.lang.Exception

class AuthRepositoryImp(
    private val api: AuthApi,
    private val perfs: SharedPreferences
):AuthRepository {
    override suspend fun signIn(email: String, password: String): AuthResult<Unit> {
        return try {
            val response = api.singIn(
                 AuthRequest(
                    email = email,
                    password = password
                )
            )
            println(response.id+response.accessToken)
            perfs.edit()
                .putString("jwt",response.accessToken)
                .putString("id",response.id)
                .apply()
            AuthResult.Authorized()
        }
        catch (e : HttpException){
            if (e.code() == 401)
                AuthResult.Unauthorized()
            else{
                println(e.message())
                AuthResult.UnknownError()
            }
        }
        catch (e:Exception){
            println(e.message)
            AuthResult.UnknownError()
        }
    }

    override suspend fun authenticate(): AuthResult<Patient> {
        return try {
            val token = perfs.getString("jwt",null)?:return AuthResult.Unauthorized()
            val id = perfs.getString("id", null)?: return AuthResult.Unauthorized()
            val response = api.authenticate("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDVhYzExZDZiZGRjOTBhMzNlZDI2ZjUiLCJlbWFpbF9hZGRyZXNzIjoiam9obmRvQGV4YW1wbGUuY29tIiwicm9sZSI6MjAwMiwiaWF0IjoxNjg0NzUyMDU1LCJleHAiOjE2ODQ3NTI2NTV9.E7jugsvxK5yfu6lmdoNHmpMkLaIYSKhBtol_rD5ne8U", "645ac11d6bddc90a33ed26f5")
            println(response.first_name)
            AuthResult.Authorized(data = response )
        }
        catch (e : HttpException){
            if (e.code() == 401)
                AuthResult.Unauthorized()
            else
                AuthResult.UnknownError()
        }
        catch (e:Exception){
            AuthResult.UnknownError()
        }
    }

}