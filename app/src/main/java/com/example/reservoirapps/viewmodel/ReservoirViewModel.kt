package com.example.reservoirapps.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reservoirapps.models.ReservoirInfo
import com.example.reservoirapps.repository.ReservoirRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ReservoirViewModel
@Inject constructor(private val repository:ReservoirRepo): ViewModel() {
    private val _response = MutableLiveData<ReservoirInfo>()

    val reservoirResponse: LiveData<ReservoirInfo>
        get() = _response


    init {
        getReservoir()
    }

    private fun getReservoir() = viewModelScope.launch {
        repository.getReservoir().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("response Error","getReservoir: ${response.code()}")
            }
        }
    }
}