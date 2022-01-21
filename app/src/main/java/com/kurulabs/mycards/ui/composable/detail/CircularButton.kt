package com.kurulabs.mycards.ui.composable.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CircularButton(modifier: Modifier, imageVector: ImageVector, onClick: () -> Unit) {
    Surface(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
            .size(34.dp),
        elevation = 8.dp,
        shape = CircleShape
    ) {
        Box(
            modifier = modifier
                .clickable(onClick = onClick)
                .clip(CircleShape)
        ) {
            Icon(
                modifier = modifier
                    .fillMaxSize()
                    .padding(8.dp),
                tint = MaterialTheme.colors.onSurface,
                imageVector = imageVector,
                contentDescription = null
            )
        }
    }
}