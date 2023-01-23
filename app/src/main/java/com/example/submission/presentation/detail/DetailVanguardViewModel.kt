package com.example.submission.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vanguardappp.core.domain.model.Vanguard
import com.example.vanguardappp.core.domain.usecase.VanguardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailVanguardViewModel @Inject constructor(private val vanguardUseCase: VanguardUseCase) : ViewModel() {
    suspend fun setFavoriteVanguard(vanguard: Vanguard, newStatus:Boolean) =
        viewModelScope.launch(Dispatchers.IO) { vanguardUseCase.updateFavoriteVanguard(vanguard, newStatus) }
}

