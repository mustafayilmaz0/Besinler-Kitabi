package com.mustafayilmaz.besinlerkitabi.servis

import io.reactivex.Single
import com.mustafayilmaz.besinlerkitabi.model.Besin
import retrofit2.http.GET

interface BesinAPI {

    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    fun getBesin(): Single<List<Besin>>
}