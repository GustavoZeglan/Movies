package devandroid.zeglan.movies.server.repository.local

import devandroid.zeglan.movies.server.model.GenreListModel


object GenreListMock {

        val list: List<GenreListModel.GenreModel> = arrayListOf(
                GenreListModel.GenreModel("Ação", "28"),//1800
                GenreListModel.GenreModel("Terror", "27"),//2100
                GenreListModel.GenreModel("Aventura", "12"),//1023
                GenreListModel.GenreModel("Animação", "16"),//2300
                GenreListModel.GenreModel("Comédia", "35"),//6079
                GenreListModel.GenreModel("Crime", "80"),//1500
                GenreListModel.GenreModel("Documentário", "99"),//6800
                GenreListModel.GenreModel("Drama", "18"),//9900
                GenreListModel.GenreModel("Família", "10751"),//1100
                GenreListModel.GenreModel("Fantasia", "14"),//946
                GenreListModel.GenreModel("História", "36"),//741
                GenreListModel.GenreModel("Música", "10402"),//1785
                GenreListModel.GenreModel("Mistério", "9648"),//851
                GenreListModel.GenreModel("Romance", "10749"),//2300
                GenreListModel.GenreModel("Ficção científica", "878"),//901
                GenreListModel.GenreModel("Cinema TV", "10770"),//1098
                GenreListModel.GenreModel("Thriller", "53"),//2035
                GenreListModel.GenreModel("Guerra", "10752"),//478
                GenreListModel.GenreModel("Faroeste", "37")//417
        )

}
