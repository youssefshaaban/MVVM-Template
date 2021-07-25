package com.example.mvvm_template.utils


// A generic class that contains data and status about loading this data.

sealed class Resource<T>(
) {
    class Success<T>(data: T) : Resource<T>()
    class Loading<T> : Resource<T>()
    class DataError<T>(val error: String) : Resource<T>()

}


sealed class ResourceUpload<out T : Any> {
    class Success(val codeSuccess: Int) : ResourceUpload<Nothing>()
    class OnProgress<out T : Any>(val data: T? = null) : ResourceUpload<T>()
    class Failure(val exception: String) : ResourceUpload<Nothing>()
}
