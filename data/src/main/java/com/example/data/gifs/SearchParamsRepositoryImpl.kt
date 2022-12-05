package com.example.data.gifs

import com.example.domain.SearchParamsRepository

class SearchParamsRepositoryImpl: SearchParamsRepository {
    override var searchString: String = DEFAULT_SEARCH_STRING
    override var offset: Int = DEFAULT_OFFSET
    override val pageSize: Int = PAGE_SIZE

    override fun isSearchStringTheSame(searchStr: String) = this.searchString == searchStr

    override fun incrementOffset() {
        offset += PAGE_SIZE
    }

    override fun resetOffset() {
        offset = DEFAULT_OFFSET
    }

    companion object {
        private const val DEFAULT_SEARCH_STRING = ""
        private const val DEFAULT_OFFSET = 0
        private const val PAGE_SIZE = 20
    }
}