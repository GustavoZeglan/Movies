package devandroid.zeglan.movies.server.model

import com.google.gson.annotations.SerializedName

data class MovieDetailModel(

    @SerializedName("adult")
    var adult: Boolean? = false,

    @SerializedName("backdrop_path")
    var backdrop_path: String? = "",

    @SerializedName("budget")
    val budget: Float? = 0f,

    @SerializedName("genres")
    val genres: List<GenreListModel.GenreModel> = arrayListOf(),

    @SerializedName("imdb_id")
    val imdbId: String? = "",

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompaniesModel> = arrayListOf(),

    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountriesModel> = arrayListOf(),

    @SerializedName("original_language")
    val original_language: String? = "en",

    @SerializedName("original_title")
    val original_title: String? = "",

    @SerializedName("overview")
    val overview: String? = "",

    @SerializedName("popularity")
    val popularity: Double? = 0.0,

    @SerializedName("poster_path")
    val poster_path: String? = "",

    @SerializedName("release_date")
    val release_date: String? = "",

    @SerializedName("revenue")
    val revenue: Float? = 0f,

    @SerializedName("runtime")
    val runtime: Int? = 0,

    @SerializedName("status")
    val status: String? = "",

    @SerializedName("tagline")
    val tagline: String = "",

    @SerializedName("title")
    val title: String? = "",

    @SerializedName("video")
    val video: Boolean? = false,

    @SerializedName("vote_average")
    val vote_average: Double? = 0.0,

    @SerializedName("vote_count")
    val vote_count: Int? = 0,

    ) {

    data class ProductionCompaniesModel (

        @SerializedName("id")
        val id: Int = 0,

        @SerializedName("logo_path")
        val logoPath: String? = "",

        @SerializedName("name")
        val name: String? = "",

        @SerializedName("origin_country")
        val originCountry: String? = "",

        )

    data class ProductionCountriesModel (

        @SerializedName("iso_3166_1")
        val iso: String? = "",

        @SerializedName("name")
        val name: String? = "",

        )

}
