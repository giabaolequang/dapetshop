package com.example.da_ltdd_petshop.ui.theme.Model

import java.util.Date

data class DataStaff
    (
    val staff_id: Int,
    val stafyf_name:String,
    val staff_day: Date,
    val staff_sex: Boolean,
    val staff_name: String,
    val staff_email:String,
    val staff_addres: String,
    val staff_position: String,
    val staff_nowstartworking: Date)