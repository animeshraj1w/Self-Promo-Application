package com.example.selfpromoapp

import java.io.Serializable

data class Message(
    val contactName: String,
    val contactNumber: String,
    val myDisplayName: String,
    val includeJunior: Boolean?,
    val jobTitle: String?,
    val immediateStart: Boolean?,
    val startDate: String?
) : Serializable{

    fun getFullJobDescription(): String =if(includeJunior == true) "a Junior $jobTitle" else "an $jobTitle"

    fun getAvailability() = if (immediateStart==true) "immediately" else "from $startDate"
}
