package com.ceiba.dataaccess.models

sealed class Result <out R> {

    object Loading: Result<Nothing>()
    data class Success<out T>(val dataProduct: T): Result<T>()
    data class Error(val exception: Throwable): Result<Nothing>()
}
