package com.ppereira.networking.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

fun <T> toResultFlow(call: suspend () -> Response<T>?) : Flow<T> {
    return flow {
        val c = call()
        c?.let {
            try {
                if (c.isSuccessful && c.body() != null) {
                    c.body()?.let {
                        emit(it)
                    }
                } else {
                    throw Exception()
                }
            }catch (e: Exception){
                throw Exception()
            }
        }
    }.flowOn(Dispatchers.IO)
}