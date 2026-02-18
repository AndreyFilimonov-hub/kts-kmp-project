package com.filimonov.project.screens.loginscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import kts_kmp_project.composeapp.generated.resources.Res
import kts_kmp_project.composeapp.generated.resources.compose_multiplatform
import kts_kmp_project.composeapp.generated.resources.email_label
import kts_kmp_project.composeapp.generated.resources.password_label
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        val emailValue = rememberSaveable { mutableStateOf("") }
        val passwordValue = rememberSaveable { mutableStateOf("") }
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 26.dp)
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                modifier = Modifier.heightIn(max = 300.dp),
                model = "https://ds-ryabinka-kuminskij-r86.gosweb.gosuslugi.ru/netcat_files/82/5e227329363657.55ef8df90a1ca_0.png",
                contentDescription = null,
                placeholder = painterResource(Res.drawable.compose_multiplatform)
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = emailValue.value,
                onValueChange = {
                    emailValue.value = it
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Blue,
                    unfocusedTextColor = Color.Blue,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Blue,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedLabelColor = Color.Blue.copy(alpha = 0.4f),
                    unfocusedLabelColor = Color.Blue.copy(alpha = 0.4f)
                ),
                label = {
                    Text(
                        text = stringResource(Res.string.email_label)
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email
                ),
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = passwordValue.value,
                onValueChange = {
                    passwordValue.value = it
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Blue,
                    unfocusedTextColor = Color.Blue,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Blue,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedLabelColor = Color.Blue.copy(alpha = 0.4f),
                    unfocusedLabelColor = Color.Blue.copy(alpha = 0.4f)
                ),
                label = {
                    Text(
                        text = stringResource(Res.string.password_label)
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                ),
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton(
                onClick = { /* no logic */ }
            )
        }
    }
}

@Composable
private fun LoginButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth()
            .heightIn(min = 48.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    ) {
        Text(
            text = "Войти",
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold
        )
    }
}