package com.ppereira.networking.di

import com.ppereira.networking.provider.ApiProvider
import org.koin.dsl.module

val networkModule = module {
    single { ApiProvider() }
}
