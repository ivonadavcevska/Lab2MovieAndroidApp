package mk.ukim.finki.lab2movieapp.domain.movie.model

import com.google.gson.annotations.SerializedName

data class CastResponse(

    val id: Int,
    val cast: List<CastDetails>
) {

}
