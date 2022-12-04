package com.example.domain

interface SearchParamsRepository {
    var searchString: String
    var offset: Int

    fun isSearchStringTheSame(searchStr: String): Boolean
    fun incrementOffset()
    fun resetOffset()
}
