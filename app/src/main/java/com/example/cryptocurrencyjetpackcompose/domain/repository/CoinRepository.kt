package com.example.cryptocurrencyjetpackcompose.domain.repository

import com.example.cryptocurrencyjetpackcompose.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyjetpackcompose.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}