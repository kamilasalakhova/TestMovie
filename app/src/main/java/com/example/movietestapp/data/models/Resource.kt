package com.example.movietestapp.data.models

data class Resource<T>(val status: Status, var data: T?, val message: String?) {
    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object{
        fun <T> success(data: T): Resource<T>{
            return Resource(Status.SUCCESS, data, null)
        }
        fun <T> error(message: String?, data: T? = null): Resource<T>{
            return Resource(Status.ERROR, data, message)
        }
        fun <T> loading(data: T? = null): Resource<T>{
            return Resource(Status.LOADING, data, null)
        }
    }
}

data class ResourceZip<T, A>(var first: T?, var second: A?)