package com.example.architecturebattlearena.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.architecturebattlearena.ui.theme.Success
import com.example.architecturebattlearena.ui.theme.Warning
import com.example.architecturebattlearena.ui.theme.Error

enum class BadgeStatus {
    SUCCESS, WARNING, ERROR, NEUTRAL
}

@Composable
fun StatusBadge(
    text: String,
    status: BadgeStatus,
    modifier: Modifier = Modifier
) {
    val backgroundColor = when (status) {
        BadgeStatus.SUCCESS -> Success.copy(alpha = 0.15f)
        BadgeStatus.WARNING -> Warning.copy(alpha = 0.15f)
        BadgeStatus.ERROR -> Error.copy(alpha = 0.15f)
        BadgeStatus.NEUTRAL -> MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f)
    }

    val contentColor = when (status) {
        BadgeStatus.SUCCESS -> Success
        BadgeStatus.WARNING -> Warning
        BadgeStatus.ERROR -> Error
        BadgeStatus.NEUTRAL -> MaterialTheme.colorScheme.secondary
    }

    Box(
        modifier = modifier
            .background(backgroundColor, RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = text.uppercase(),
            color = contentColor,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5.sp
        )
    }
}
