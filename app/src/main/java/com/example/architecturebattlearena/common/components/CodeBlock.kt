package com.example.architecturebattlearena.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.architecturebattlearena.ui.theme.Background

@Composable
fun CodeBlock(
    code: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .background(Background)
            .padding(12.dp)
    ) {
        Text(
            text = code,
            color = MaterialTheme.colorScheme.onBackground,
            fontFamily = MaterialTheme.typography.labelLarge.fontFamily, // Monospace
            fontSize = 13.sp,
            lineHeight = 18.sp,
            modifier = Modifier.horizontalScroll(rememberScrollState())
        )
    }
}
