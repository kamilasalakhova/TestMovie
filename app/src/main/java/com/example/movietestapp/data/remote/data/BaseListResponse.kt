package com.example.movietestapp.data.remote.data

import com.google.gson.annotations.SerializedName

class BaseListResponse<T>(var page: Int,
                          var results: List<T>,
                          @SerializedName("total_pages")
                          var totalPages: Int
)