package com.filimonov.project

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.filimonov.project.navigation.NavGraph
import com.filimonov.project.ui.theme.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        NavGraph()
    }
}