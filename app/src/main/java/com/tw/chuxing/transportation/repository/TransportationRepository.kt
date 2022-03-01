package com.tw.chuxing.transportation.repository

import com.tw.chuxing.transportation.model.TransportationProposal
import com.tw.chuxing.transportation.repository.model.ResponseWrapper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TransportationRepository : RemoteRepository {

    private val transportationService: TransportationService = Retrofit.Builder()
        .baseUrl("http://yapi.smart-xwork.cn/mock/134490/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TransportationService::class.java)

    suspend fun fetchProposals(id: String): ResponseWrapper<List<TransportationProposal>> {
        return transportationService.fetchProposals(id)
    }
}