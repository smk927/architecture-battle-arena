package com.example.architecturebattlearena.domain.repository

import com.example.architecturebattlearena.domain.model.ArchitectureStats
import com.example.architecturebattlearena.domain.model.Movie
import com.example.architecturebattlearena.domain.model.UserEvent
import kotlinx.coroutines.flow.Flow

interface BattleRepository {
    suspend fun getMovies(): List<Movie>
    suspend fun searchMovies(query: String): List<Movie>
    fun getEvents(): Flow<List<UserEvent>>
    suspend fun logEvent(event: UserEvent)
    fun getArchitectureStats(): List<ArchitectureStats>
}
