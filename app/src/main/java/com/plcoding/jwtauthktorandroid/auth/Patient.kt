package com.plcoding.jwtauthktorandroid.auth

import java.time.LocalDate


data class Patient(
    val __v: Int,
    val _id: String,
    val appointments: List<String>?=null,
    val birth_date: LocalDate,
    val createdAt: String,
    val email_address: String,
    val first_name: String,
    val gender: String,
    val image: String?=null,
    val last_name: String,
    val location: Location,
    val medical_folder: String,
    val medical_reports: List<String>?=null,
    val password: String?=null,
    val phone_number: Int
)
