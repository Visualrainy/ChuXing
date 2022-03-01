package com.tw.chuxing.transportation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tw.chuxing.transportation.model.TransportationProposal
import com.tw.chuxing.transportation.repository.TransportationRepository
import com.tw.chuxing.transportation.service.TransportationUsecase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private var transportationUsecase: TransportationUsecase
    private val _proposals: MutableLiveData<List<TransportationProposal>> = MutableLiveData()
    val proposals: LiveData<List<TransportationProposal>> = _proposals

    init {
        val transportationRepository = TransportationRepository()
        transportationUsecase = TransportationUsecase(transportationRepository)
    }

    fun fetchProposals(id: String) {
        viewModelScope.launch {
            _proposals.value = transportationUsecase.fetchProposals(id)
        }
    }
}