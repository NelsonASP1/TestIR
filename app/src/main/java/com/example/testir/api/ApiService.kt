package com.example.testir.api

import com.example.testir.data.ResponseType
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("apicontrollerpruebas/api/ParametrosFramework/ConsultarParametrosFramework/VPStoreAppControl")
    fun getVersion(): Call<String>

    @POST("FtEntregaElectronica/MultiCanales/ApiSeguridadPruebas/api/Seguridad/AuthenticaUsuarioApp/")
    fun getUser(): Call<ResponseType>
}
