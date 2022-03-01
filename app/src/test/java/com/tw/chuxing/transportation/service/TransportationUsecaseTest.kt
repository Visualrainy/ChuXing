package com.tw.chuxing.transportation.service

import com.tw.chuxing.transportation.model.TransportationProposal
import com.tw.chuxing.transportation.repository.TransportationRepository
import com.tw.chuxing.transportation.repository.model.ResponseWrapper
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TransportationUsecaseTest {

    private lateinit var transportationRepository: TransportationRepository
    private lateinit var transportationUsecase: TransportationUsecase

    @Before
    fun setup() {
        transportationRepository = mockk()
        transportationUsecase = TransportationUsecase(transportationRepository)
    }

    @Test
    fun should_return_proposals_data_when_repository_return_is_not_empty() {
        val result = ResponseWrapper(200, listOf(TransportationProposal("small", 20, 19)))
        coEvery { transportationRepository.fetchProposals(any()) } returns result

        runBlocking {
            val proposals = transportationUsecase.fetchProposals("123")
            assertEquals(1, proposals?.size)
        }
    }
}