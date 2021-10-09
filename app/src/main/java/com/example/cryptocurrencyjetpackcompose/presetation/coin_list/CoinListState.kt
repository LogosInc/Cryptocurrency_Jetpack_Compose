package com.example.cryptocurrencyjetpackcompose.presetation.coin_list

import com.example.cryptocurrencyjetpackcompose.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)