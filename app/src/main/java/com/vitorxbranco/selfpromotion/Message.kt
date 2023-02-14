package com.vitorxbranco.selfpromotion

data class Message(
    val nomeContato: String,
    val numeroContato: String,
    val meuNome: String,
    val incluirJunior: Boolean,
    val tituloEmprego: String?,
    val comecoImediato: Boolean,
    val dataDisponivel: String?
) : java.io.Serializable {

    fun getFullJobDescription() = if (incluirJunior) "um $tituloEmprego Junior" else "um $tituloEmprego"

    fun getAvailability() = if (comecoImediato) "imediatamente" else "a partir de $dataDisponivel"

}