package com.example.testir.ui.login
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testir.repository.VersionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: VersionRepository
) : ViewModel() {

    private val _versionResult = MutableLiveData<String>()
    val versionResult: LiveData<String> get() = _versionResult

    fun fetchVersion() {
        viewModelScope.launch {
            try {
                val response = repository.getVersion()
                if (response.isSuccessful) {
                    val remoteVersion = response.body()?.trim()
                    _versionResult.postValue(remoteVersion ?: "Respuesta de versión remota es nula.")
                } else {
                    _versionResult.postValue("Error al obtener la versión: ${response.code()}")
                }
            } catch (e: HttpException) {
                _versionResult.postValue("Error al obtener la versión: ${e.message()}")
            }
        }
    }
}

