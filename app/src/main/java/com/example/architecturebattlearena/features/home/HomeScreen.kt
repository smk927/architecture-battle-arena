package com.example.architecturebattlearena.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.architecturebattlearena.common.components.ArenaCard
import com.example.architecturebattlearena.common.components.BadgeStatus
import com.example.architecturebattlearena.common.components.StatusBadge
import com.example.architecturebattlearena.domain.model.ArchitectureStats
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Hero Section
        Column {
            Text(
                text = "Architecture Battle Arena",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Compare MVC, MVP, MVVM and MVI through real Android implementations.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary
            )
        }

        // Architecture Cards
        Text(text = "Core Architectures", style = MaterialTheme.typography.headlineMedium)
        
        // Using a custom layout since LazyVerticalGrid inside a verticalScroll Column can be tricky without fixed height
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            maxItemsInEachRow = 2,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val itemModifier = Modifier.weight(1f).heightIn(min = 200.dp)
            uiState.stats.forEach { stat ->
                ArchitectureOverviewCard(stat, modifier = itemModifier)
            }
        }

        // Popularity Chart (Simplified)
        Text(text = "Architecture Popularity", style = MaterialTheme.typography.headlineMedium)
        PopularityChart(uiState.stats)
        
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ArchitectureOverviewCard(stats: ArchitectureStats, modifier: Modifier = Modifier) {
    ArenaCard(modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stats.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                StatusBadge(
                    text = "Lvl ${stats.complexityScore}",
                    status = if (stats.complexityScore > 7) BadgeStatus.ERROR else BadgeStatus.SUCCESS
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            StatRow("Boilerplate", stats.boilerplateScore)
            StatRow("Testability", stats.testabilityScore)
            StatRow("Scalability", stats.scalabilityScore)
        }
    }
}

@Composable
fun StatRow(label: String, score: Int) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$label: ",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.width(90.dp)
        )
        LinearProgressIndicator(
            progress = { score / 10f },
            modifier = Modifier
                .weight(1f)
                .height(6.dp)
                .clip(RoundedCornerShape(3.dp)),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.outlineVariant
        )
        Text(
            text = " $score/10",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun PopularityChart(stats: List<ArchitectureStats>) {
    ArenaCard {
        Column(modifier = Modifier.padding(16.dp)) {
            // Simulated popularity based on industry trends
            val popularityMap = mapOf(
                "MVC" to 15,
                "MVP" to 35,
                "MVVM" to 92,
                "MVI" to 78
            )

            stats.forEach { stat ->
                val popularity = popularityMap[stat.name] ?: 50
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stat.name,
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.width(50.dp)
                    )
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(24.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(MaterialTheme.colorScheme.outlineVariant)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(popularity / 100f)
                                .fillMaxHeight()
                                .background(
                                    if (popularity > 80) MaterialTheme.colorScheme.primary 
                                    else MaterialTheme.colorScheme.secondary
                                )
                        )
                    }
                    Text(
                        text = "$popularity%",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}
