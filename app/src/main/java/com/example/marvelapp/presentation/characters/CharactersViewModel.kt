package com.example.marvelapp.presentation.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.core.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    fun charactersPagingData(query: String): Flow<PagingData<com.example.core.domain.model.Character>> {
        return getCharactersUseCase(
            GetCharactersUseCase.GetCharactersParams(query = query, getPagerConfig())
        ).cachedIn(viewModelScope)
    }

    private fun getPagerConfig(): PagingConfig {
        return PagingConfig(
            pageSize = 20
        )
    }

}