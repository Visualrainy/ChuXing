package com.tw.chuxing.transportation.repository

import com.tw.chuxing.transportation.model.TransportationProposal
import com.tw.chuxing.transportation.repository.model.ResponseWrapper
import retrofit2.http.POST
import retrofit2.http.Path

internal interface TransportationService {
    @POST("transportation-requests/{id}")
    suspend fun fetchProposals(@Path("id") requestId: String): ResponseWrapper<List<TransportationProposal>>
}