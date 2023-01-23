package com.example.vanguard.favorite

import androidx.lifecycle.*
import com.example.vanguard.core.domain.usecase.VanguardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class FavoriteViewModel  @Inject constructor(vanguardeUseCase : VanguardUseCase) : ViewModel() {
    val favoriteVanguards = vanguardeUseCase.getFavoriteVanguard().asLiveData()
}