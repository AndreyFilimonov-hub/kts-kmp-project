package com.filimonov.project.screens.welcomescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.filimonov.project.ui.theme.AppTheme
import com.filimonov.project.ui.utils.LargeVerticalSpacer
import com.filimonov.project.ui.utils.MediumVerticalSpacer
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
            MediumVerticalSpacer()
            Text(
                text = stringResource(Res.string.welcome),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            LargeVerticalSpacer()
            StartButton(
                onClick = navigateToLoginScreen
            )
        }
    }
}

@Composable
private fun StartButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.width(260.dp)
            .heightIn(min = 48.dp),
        onClick = onClick
    ) {
        Text(
            text = stringResource(Res.string.start),
            fontSize = 19.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    AppTheme {
        WelcomeScreen(
            navigateToLoginScreen = {}
        )
    }
}