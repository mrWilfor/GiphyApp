package com.example.domain.usecases

import com.example.domain.SearchParamsRepository

class ReceiveNextPageUseCase(
    private val searchParamsRepository: SearchParamsRepository,
    private val searchGifsInfosUseCase: SearchGifsInfosUseCase
) {

    suspend operator fun invoke() {
        searchGifsInfosUseCase.invoke(searchParamsRepository.searchString)
    }
}