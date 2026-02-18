package com.filimonov.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.filimonov.project.navigation.NavGraph

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavGraph()
    }
}