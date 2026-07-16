package com.example.zepto.di

import android.app.Application

class AddressList: Application(){
    override fun onCreate() {
        super.onCreate()
        Graph.provider(this
        )
    }
}