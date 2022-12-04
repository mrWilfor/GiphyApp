package com.example.domain.usecases

import com.example.domain.GifInfoRepository

class SearchGifsInfosUseCase(
    private val gifInfoRepository: GifInfoRepository,
) {
    private var lastSearchStr = DEFAULT_SEARCH_STRING
    private var offset = DEFAULT_OFFSET

    suspend operator fun invoke(searchStr: String) {
        if (lastSearchStr == searchStr) {
            offset += PAGE_SIZE
        } else {
            lastSearchStr = searchStr
            offset = 0
        }

        gifInfoRepository.searchGifs(searchStr, offset)
    }

    companion object {
        private const val DEFAULT_SEARCH_STRING = ""
        private const val DEFAULT_OFFSET = 0
        private const val PAGE_SIZE = 20
    }
}