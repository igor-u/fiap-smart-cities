package br.com.fiap.validoc.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "https://servicodados.ibge.gov.br/api/docs/localidades/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getLocalidadeService(): LocalidadeService {
        return retrofitFactory.create(LocalidadeService::class.java)
    }
}