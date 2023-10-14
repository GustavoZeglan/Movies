package devandroid.zeglan.movies.server.repository.local

import devandroid.zeglan.movies.server.model.GenreListModel


object GenreListMock {

        val list: List<GenreListModel.GenreModel> = arrayListOf(
                GenreListModel.GenreModel("Ação", "28"),
                GenreListModel.GenreModel("Terror", "27"),
                GenreListModel.GenreModel("Aventura", "12"),
                GenreListModel.GenreModel("Animação", "16"),
                GenreListModel.GenreModel("Comédia", "35"),
                GenreListModel.GenreModel("Crime", "80"),
                GenreListModel.GenreModel("Documentário", "99"),
                GenreListModel.GenreModel("Drama", "18"),
                GenreListModel.GenreModel("Família", "10751"),
                GenreListModel.GenreModel("Fantasia", "14"),
                GenreListModel.GenreModel("História", "36"),
                GenreListModel.GenreModel("Música", "10402"),
                GenreListModel.GenreModel("Mistério", "9648"),
                GenreListModel.GenreModel("Romance", "10749"),
                GenreListModel.GenreModel("Ficção científica", "878"),
                GenreListModel.GenreModel("Cinema TV", "10770"),
                GenreListModel.GenreModel("Thriller", "53"),
                GenreListModel.GenreModel("Guerra", "10752"),
                GenreListModel.GenreModel("Faroeste", "37")
        )

}
