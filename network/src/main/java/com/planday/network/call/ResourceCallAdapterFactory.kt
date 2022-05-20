package com.planday.network.call

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class ResourceCallAdapterFactory : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java) return null
        check(returnType is ParameterizedType) { "Return type must be a parameterized type." }

        val responseType = getParameterUpperBound(0, returnType)
        if (getRawType(responseType) != Resource::class.java) return null
        check(responseType is ParameterizedType) { "Response type must be a parameterized type." }

        val dataType = getParameterUpperBound(0, responseType)
        return ResourceCallAdapter<Resource<*>>(dataType)
    }
}