//package com.example.data.gifs
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.example.data.gifs.network.GifInfoNetwork
//import com.example.domain.GifInfoDomain
//
//class GifInfoPagingSource(
//    private val gifInfoRemoteDataSource: GifInfoRemoteDataSource,
//    private val gifInfoLocalDataSource: GifInfoLocalDataSource
//) : PagingSource<Int, List<GifInfoDomain>>() {
//
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, List<GifInfoDomain>> {
//        val pageIndex = params.key ?: STARTING_PAGE_INDEX
//
//        gifInfoRemoteDataSource.searchGifs(searchStr)
//            .takeIf { searchGifsResponse -> searchGifsResponse.isSuccessful && searchGifsResponse.body()?.meta?.status == 200 }
//            .let { searchGifsResponse ->
//                val searchGifs = searchGifsResponse?.body()
//                    ?.data
//                    ?.map(GifInfoNetwork::toDb)
//                    ?: emptyList()
//
//                gifInfoLocalDataSource.saveGifsInfo(searchGifs)
//            }
//
//        val nextKey =
//            if (movies.isEmpty()) {
//                null
//            } else {
//                // By default, initial load size = 3 * NETWORK PAGE SIZE
//                // ensure we're not requesting duplicating items at the 2nd request
//                pageIndex + (params.loadSize / NETWORK_PAGE_SIZE)
//            }
//        LoadResult.Page(
//            data = gifInfoLocalDataSource.getGifsInfoFlow(),
//            prevKey = if (pageIndex == STARTING_PAGE_INDEX) null else pageIndex,
//            nextKey = nextKey
//        )
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, MovieResponse>): Int? {
//        // We need to get the previous key (or next key if previous is null) of the page
//        // that was closest to the most recently accessed index.
//        // Anchor position is the most recently accessed index.
//        return state.anchorPosition?.let { anchorPosition ->
//            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
//                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
//        }
//    }
//
//    companion object {
//        private const val STARTING_PAGE_INDEX = 1
//        const val NETWORK_PAGE_SIZE = 20
//    }
//}