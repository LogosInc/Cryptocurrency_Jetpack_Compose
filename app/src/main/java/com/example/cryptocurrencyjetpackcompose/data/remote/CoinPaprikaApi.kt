package com.example.cryptocurrencyjetpackcompose.data.remote

import com.example.cryptocurrencyjetpackcompose.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyjetpackcompose.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

}