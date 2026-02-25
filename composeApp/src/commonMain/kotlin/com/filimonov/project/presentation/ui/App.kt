package com.filimonov.project.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.filimonov.project.presentation.navigation.NavGraph
import com.filimonov.project.presentation.ui.theme.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        NavGraph()
    }
}