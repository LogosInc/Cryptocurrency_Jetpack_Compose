package com.example.cryptocurrencyjetpackcompose.domain.use_case.get_coins

import com.example.cryptocurrencyjetpackcompose.common.Resource
import com.example.cryptocurrencyjetpackcompose.data.remote.dto.toCoin
import com.example.cryptocurrencyjetpackcompose.domain.model.Coin
import com.example.cryptocurrencyjetpackcompose.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins =repository.getCoins().map{ it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach serve. Check your internet connection."))
        }
    }
}