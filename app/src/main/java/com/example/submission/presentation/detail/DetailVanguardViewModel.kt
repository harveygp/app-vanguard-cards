package com.example.submission.presentation.detail

import androidx.lifecycle.ViewModel
import com.example.submission.core.domain.model.Vanguard
import com.example.submission.core.domain.usecase.VanguardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailVanguardViewModel @Inject constructor(private val vanguardUseCase: VanguardUseCase) : ViewModel() {
    fun setFavoriteVanguard(vanguard: Vanguard, newStatus:Boolean) =
        vanguardUseCase.updateFavoriteVanguard(vanguard, newStatus)
}

