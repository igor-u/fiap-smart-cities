package br.com.fiap.myapp.service

import br.com.fiap.myapp.model.Cidade
import br.com.fiap.myapp.model.Estado
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LocalidadeService {

    @GET("https://servicodados.ibge.gov.br/api/v1/localidades/estados")
    fun getEstados(): Call<List<Estado>>

    @GET("https://servicodados.ibge.gov.br/api/v1/localidades/estados/{idEstado}/municipios")
    fun getCidadesByEstado(@Path ("idEstado") idEstado: Int): Call<List<Cidade>>

}