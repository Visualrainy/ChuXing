package com.tw.chuxing.transportation.repository

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TransportationRepositoryTest {

    private lateinit var transportationRepository: TransportationRepository

    @Before
    fun setup() {
        transportationRepository = TransportationRepository()
    }

    @Test
    fun should_return_success_when_fetch_proposals() {
        runBlocking {
            val proposals = transportationRepository.fetchProposals("123")
            assertEquals(200, proposals.code)
            assertNotNull(proposals.data)
        }
    }
}