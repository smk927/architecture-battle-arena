package com.example.architecturebattlearena.domain.model

import java.time.LocalDateTime

data class UserEvent(
    val id: String,
    val timestamp: LocalDateTime,
    val description: String,
    val architecture: String,
    val type: EventType
)

enum class EventType {
    ACTION, STATE_CHANGE, API_REQUEST, API_RESPONSE
}
