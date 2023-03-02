package mk.ukim.finki.lab2movieapp.domain.movie.model

import com.google.gson.annotations.SerializedName

data class CastDetails(

    @SerializedName("name") val name: String
) {


}