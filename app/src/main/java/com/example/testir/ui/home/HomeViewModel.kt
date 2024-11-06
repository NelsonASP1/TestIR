package com.example.testir.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testir.data.LocalidadResponse
import com.example.testir.data.LoginRequest
import com.example.testir.data.LoginResponse
import com.example.testir.data.database.entity.UserEntity
import com.example.testir.repository.LocalidadRepository
import com.example.testir.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: LoginRepository,
    private val localidadRepository: LocalidadRepository
) : ViewModel() {

    private val _loginResult = MutableLiveData<LoginResponse?>()
    val loginResult: LiveData<LoginResponse?> get() = _loginResult

    private val _localidades = MutableLiveData<List<LocalidadResponse>>()
    val localidades: LiveData<List<LocalidadResponse>> get() = _localidades

    fun login(request: LoginRequest) {
        viewModelScope.launch {
            try {
                val response = repository.authenticateUser(request)
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    loginResponse?.let {
                        saveUser(it)
                        _loginResult.postValue(it)
                        Log.d("TAG","$it")
                    }
                } else {
                    _loginResult.postValue(null)
                }
            } catch (e: HttpException) {
                _loginResult.postValue(null)
            }
        }
    }

    fun localidades() {
        viewModelScope.launch {
            try { val response = localidadRepository.fetchLocalidades()
                if (response.isSuccessful) { response.body()?.let { _localidades.postValue(it) } }
                    else { _localidades.postValue(emptyList())
                }
            } catch (e: Exception) { _localidades.postValue(emptyList())
                _localidades.postValue(emptyList())
            }
        }
    }

    private suspend fun saveUser(loginResponse: LoginResponse) {
        val user = UserEntity(
            usuario = loginResponse.Usuario,
            identificacion = loginResponse.Identificacion,
            nombre = loginResponse.Nombre,
            apellido1 = loginResponse.Apellido1
        )
        repository.saveUser(user)
    }
}
