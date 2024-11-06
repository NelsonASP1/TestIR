package com.example.testir.api

import com.example.testir.data.LocalidadResponse
import com.example.testir.data.LoginRequest
import com.example.testir.data.LoginResponse
import com.example.testir.data.database.entity.EsquemaEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @GET("apicontrollerpruebas/api/ParametrosFramework/ConsultarParametrosFramework/VPStoreAppControl")
    suspend fun getVersion(): Response<String>


    @Headers(
        "Usuario:pam.meredy21",
        "Identificacion:987204545",
        "Accept:text/json",
        "IdUsuario:pam.meredy21",
        "IdCentroServicio:1295",
        "NombreCentroServicio:PTO/BOGOTA/CUND/COL/OF PRINCIPAL - CRA 30",
        "IdAplicativoOrigen:9",
        "Content-Type:application/json"
    )
    @POST("FtEntregaElectronica/MultiCanales/ApiSeguridadPruebas/api/Seguridad/AuthenticaUsuarioApp")
    suspend fun authenticateUser(@Body body: LoginRequest): Response<LoginResponse>

    @GET("apicontrollerpruebas/api/SincronizadorDatos/ObtenerEsquema/true")
    suspend fun getEsquemas(): Response<List<EsquemaEntity>>

    @GET("apicontrollerpruebas/api/ParametrosFramework/ObtenerLocalidadesRecogidas")
    suspend fun getLocalidadesRecogidas(): Response<List<LocalidadResponse>>
}
