package com.example.testir.ui.login

import android.util.Log
import com.example.testir.repository.Repository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val repository = Repository()
    private val _data = MutableLiveData<String>()
    val data: LiveData<String> get() = _data

    fun fetchData() {
        val call = repository.getVersion()
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    _data.value = response.body()
                    Log.d("API_RESPONSE", "Data recibida: ${response.body()}")
                }

            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                // Manejar el error

                Log.e("API_RESPONSE", "Fallo al hacer la solicitud: ", t)
            }
        })
    }
}

