package com.tw.chuxing.transportation.repository.model

data class ResponseWrapper<T>(
    val code: Int?,
    val data: T?
)