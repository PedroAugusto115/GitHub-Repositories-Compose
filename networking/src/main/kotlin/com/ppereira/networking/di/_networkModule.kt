package com.ppereira.networking.di

import com.ppereira.networking.provider.ApiProvider
import org.koin.dsl.module

val _networkModule = module {
    single { ApiProvider() }
}