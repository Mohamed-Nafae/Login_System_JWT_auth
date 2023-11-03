package com.plcoding.jwtauthktorandroid.ui

import com.plcoding.jwtauthktorandroid.auth.Patient

data class AuthState(
    val isLoading: Boolean = false,
    val patient: Patient? = null,
    val signInUsername: String = "",
    val signInPassword: String = ""
)
