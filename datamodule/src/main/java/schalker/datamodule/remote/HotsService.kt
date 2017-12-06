package schalker.datamodule.remote

import io.reactivex.Single
import retrofit2.http.GET
import schalker.datamodule.models.Hero

interface HotsService {
    @GET("/heroes")
    fun getHeroes(): Single<List<Hero>>
}