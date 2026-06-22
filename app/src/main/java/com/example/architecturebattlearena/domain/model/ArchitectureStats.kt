package com.example.architecturebattlearena.domain.model

data class ArchitectureStats(
    val name: String,
    val boilerplateScore: Int, // 1-10
    val testabilityScore: Int,
    val scalabilityScore: Int,
    val maintainabilityScore: Int,
    val complexityScore: Int
)
