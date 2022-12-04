package com.example.domain.usecases

import com.example.domain.GifInfoRepository
import com.example.domain.SearchParamsRepository
import kotlinx.coroutines.flow.map

class GetGifsInfosUseCase(
    private val gifInfoRepository: GifInfoRepository,
    private val searchParamsRepository: SearchParamsRepository
) {

    operator fun invoke() = gifInfoRepository.searchedGifsInfos
        .map { gifInfoDomainList ->
            gifInfoDomainList.filter { gifInfoDomain ->
                gifInfoDomain.searchRequest == searchParamsRepository.searchString
                        && !gifInfoDomain.isDeleted
            }
        }
}