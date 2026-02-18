package com.filimonov.project.screens.welcomescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import kts_kmp_project.composeapp.generated.resources.Res
import kts_kmp_project.composeapp.generated.resources.compose_multiplatform
import kts_kmp_project.composeapp.generated.resources.start
import kts_kmp_project.composeapp.generated.resources.welcome
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    navigateToLoginScreen: () -> Unit
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = "https://static.vecteezy.com/system/resources/previews/013/038/290/non_2x/people-greet-gesture-flat-illustration-set-people-wave-hello-men-women-in-casual-wear-say-hello-vector.jpg",
                contentDescription = null,
                placeholder = painterResource(Res.drawable.compose_multiplatform)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(Res.string.welcome),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(32.dp))
            StartButton(
                onClick = navigateToLoginScreen
            )
        }
    }
}

@Composable
fun StartButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.width(260.dp)
            .heightIn(min = 48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
        onClick = onClick
    ) {
        Text(
            text = stringResource(Res.string.start),
            fontSize = 19.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}