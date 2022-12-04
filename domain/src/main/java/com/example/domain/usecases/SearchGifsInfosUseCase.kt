package com.example.domain.usecases

import com.example.domain.GifInfoRepository
import com.example.domain.SearchParamsRepository

class SearchGifsInfosUseCase(
    private val gifInfoRepository: GifInfoRepository,
    private val searchParamsRepository: SearchParamsRepository
) {

    suspend operator fun invoke(searchStr: String) {
        with(searchParamsRepository) {
            if (isSearchStringTheSame(searchStr)) {
                incrementOffset()
            } else {
                searchString = searchStr
                resetOffset()
            }

            gifInfoRepository.searchGifs(searchString, offset)
        }
    }
}