package com.example.submission.presentation.favorite

import androidx.lifecycle.*
import com.example.vanguard.core.domain.usecase.VanguardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel  @Inject constructor(vanguardeUseCase : VanguardUseCase) : ViewModel() {
    val favoriteVanguards = vanguardeUseCase.getFavoriteVanguard().asLiveData()
}