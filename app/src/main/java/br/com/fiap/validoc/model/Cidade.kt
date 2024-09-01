package br.com.fiap.validoc.model

import com.google.gson.annotations.SerializedName

class Cidade {

    val nome: String = "Cidade"
    @SerializedName("UF")
    val estado: Estado = Estado()

}