package com.example.marvelapp.framework.remote

import com.example.core.data.repository.CharactersRemoteDataSource
import com.example.marvelapp.framework.network.MarvelAPI
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import javax.inject.Inject

class RetrofitCharactersDataSource @Inject constructor(
    private val marvelAPI: MarvelAPI
) : CharactersRemoteDataSource<DataWrapperResponse> {

    override suspend fun fetchCharacters(query: Map<String, String>): DataWrapperResponse {
        return marvelAPI.getCharacters(query)
    }

}