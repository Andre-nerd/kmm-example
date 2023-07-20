package com.example.kmm_example.data_base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class RocketLaunch(
    @SerialName("flight_number")
    val flightNumber: Int,
    @SerialName("name")
    val missionName: String,
    @SerialName("date_utc")
    val launchDateUTC: String,
    @SerialName("details")
    val details: String?,
    @SerialName("success")
    val launchSuccess: Boolean?,
)

@Serializable
data class RowData(
    @SerialName("id")
    val id: Long,
    @SerialName("image")
    val image: String,
    @SerialName("quantity")
    val quantity: Long,
    @SerialName("url")
    val url: String
)

