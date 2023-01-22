package com.example.submission.presentation.favorite

import androidx.lifecycle.*
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
class FavoriteViewModel  @Inject constructor(vanguardeUseCase : VanguardUseCase) : ViewModel() {
    val favoriteVanguards = vanguardeUseCase.getFavoriteVanguard().asLiveData()
}