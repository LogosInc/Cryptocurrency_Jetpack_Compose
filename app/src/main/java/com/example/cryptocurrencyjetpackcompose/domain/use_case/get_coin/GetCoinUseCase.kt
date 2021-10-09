package com.example.cryptocurrencyjetpackcompose.domain.use_case.get_coin

import com.example.cryptocurrencyjetpackcompose.common.Resource
import com.example.cryptocurrencyjetpackcompose.data.remote.dto.toCoin
import com.example.cryptocurrencyjetpackcompose.data.remote.dto.toCoinDetail
import com.example.cryptocurrencyjetpackcompose.domain.model.Coin
import com.example.cryptocurrencyjetpackcompose.domain.model.CoinDetail
import com.example.cryptocurrencyjetpackcompose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coins =repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach serve. Check your internet connection."))
        }
    }
}