package com.tw.chuxing.transportation.service

import com.tw.chuxing.transportation.model.TransportationProposal
import com.tw.chuxing.transportation.repository.TransportationRepository

class TransportationUsecase(private val transportationRepository: TransportationRepository) {
    suspend fun fetchProposals(id: String): List<TransportationProposal>? {
        val proposals = transportationRepository.fetchProposals(id)
        return proposals.data
    }
}