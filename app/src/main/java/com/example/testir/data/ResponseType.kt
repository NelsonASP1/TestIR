package com.example.testir.data

data class ResponseType(
    val Usuario: String,
    val Identificacion: String,
    val Nombre: String,
    val Apellido1: String,
    val Apellido2: String,
    val Cargo: String,
    val Aplicaciones: String,
    val Ubicaciones: String,
    val MensajeResultado: Int,
    val IdLocalidad: String,
    val NombreLocalidad: String,
    val NomRol: String,
    val IdRol: String,
    val TokenJWT: String,
    val ModulosApp: String,
)
