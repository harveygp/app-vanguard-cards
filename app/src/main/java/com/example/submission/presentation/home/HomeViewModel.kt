package com.example.submission.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.submission.core.data.Resource
import com.example.submission.core.domain.model.Vanguard
import com.example.submission.core.domain.usecase.VanguardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val vanguardeUseCase : VanguardUseCase) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _data = MutableLiveData<List<Vanguard>?>()
    val data: LiveData<List<Vanguard>?> = _data

    init{
        vanguards()
    }

    fun vanguards() = viewModelScope.launch(Dispatchers.IO) {
        vanguardeUseCase.getAllVanguards().onEach { value ->
            when(value){
                is Resource.Loading -> _isLoading.value = true
                is Resource.Success -> {
                    _isLoading.value = false
                    _data.value = value.data
                }
                is Resource.Error -> _isLoading.value = false
            }
        }.launchIn(viewModelScope)
    }
}