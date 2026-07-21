package com.example.zepto.data.model

import java.time.LocalTime

data class orderlist(
        val orderId: String? = null,
        val itemsName: String,
        val totalAmount: String,
        val tracking: String
)
