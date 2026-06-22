package com.example.architecturebattlearena.data.repository

import com.example.architecturebattlearena.domain.model.*
import com.example.architecturebattlearena.domain.repository.BattleRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDateTime
import java.util.UUID

class BattleRepositoryImpl : BattleRepository {

    private val _events = MutableStateFlow<List<UserEvent>>(emptyList())
    
    private val mockMovies = listOf(
        Movie("1", "Inception", "A thief who steals corporate secrets through the use of dream-sharing technology.", 8.8, "", "2010"),
        Movie("2", "The Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham.", 9.0, "", "2008"),
        Movie("3", "Interstellar", "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", 8.7, "", "2014"),
        Movie("4", "The Matrix", "A computer hacker learns from mysterious rebels about the true nature of his reality.", 8.7, "", "1999")
    )

    override suspend fun getMovies(): List<Movie> {
        delay(1000) // Simulate network delay
        return mockMovies
    }

    override suspend fun searchMovies(query: String): List<Movie> {
        delay(800)
        return if (query.isEmpty()) mockMovies 
        else mockMovies.filter { it.title.contains(query, ignoreCase = true) }
    }

    override fun getEvents(): Flow<List<UserEvent>> = _events.asStateFlow()

    override suspend fun logEvent(event: UserEvent) {
        _events.update { current -> listOf(event) + current }
    }

    override fun getArchitectureStats(): List<ArchitectureStats> {
        return listOf(
            ArchitectureStats("MVC", 2, 3, 4, 3, 2),
            ArchitectureStats("MVP", 6, 7, 6, 6, 5),
            ArchitectureStats("MVVM", 7, 8, 9, 8, 7),
            ArchitectureStats("MVI", 9, 9, 10, 9, 9)
        )
    }
}
