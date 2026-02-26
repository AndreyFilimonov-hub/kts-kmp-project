package com.filimonov.vkclientkmp.presentation.screens.loginscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.filimonov.vkclientkmp.presentation.ui.theme.AppTheme
import com.filimonov.vkclientkmp.presentation.ui.utils.MediumVerticalSpacer
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import vkclientkmp.composeapp.generated.resources.Res
import vkclientkmp.composeapp.generated.resources.compose_multiplatform
import vkclientkmp.composeapp.generated.resources.email_label
import vkclientkmp.composeapp.generated.resources.invalid_data
import vkclientkmp.composeapp.generated.resources.login
import vkclientkmp.composeapp.generated.resources.password_label

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel { LoginViewModel() },
    navigateToMainScreen: () -> Unit
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        val state by viewModel.state.collectAsStateWithLifecycle()

        LaunchedEffect(key1 = Unit) {
            viewModel.loginEvent.collect { loginUiEvent ->
                when (loginUiEvent) {
                    LoginUiEvent.LoginSuccessEvent -> navigateToMainScreen()
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 26.dp)
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LoginImage()
            MediumVerticalSpacer()
            EmailOutlinedTextField(
                email = state.email,
                onValueChange = { value ->
                    viewModel.processCommand(LoginCommand.InputEmail(value))
                },
                isError = state.isError
            )
            MediumVerticalSpacer()
            PasswordOutlinedTextField(
                password = state.password,
                onValueChange = { value ->
                    viewModel.processCommand(LoginCommand.InputPassword(value))
                },
                isError = state.isError
            )
            ErrorDataText(isError = state.isError)
            MediumVerticalSpacer()
            LoginButton(
                enabled = state.isLoginButtonActive,
                onClick = { viewModel.processCommand(LoginCommand.Login) }
            )
        }
    }
}

@Composable
private fun LoginImage(
    modifier: Modifier = Modifier
) {
    val imageUrl = remember { "https://ds-ryabinka-kuminskij-r86.gosweb.gosuslugi.ru/netcat_files/82/5e227329363657.55ef8df90a1ca_0.png" }

    AsyncImage(
        modifier = modifier.heightIn(max = 300.dp),
        model = imageUrl,
        contentDescription = null,
        placeholder = painterResource(Res.drawable.compose_multiplatform)
    )
}

@Composable
private fun ErrorDataText(
    modifier: Modifier = Modifier,
    isError: Boolean
) {
    Box(
        modifier = modifier.fillMaxWidth()
            .height(52.dp)
    ) {
        Text(
            text = if (isError) stringResource(Res.string.invalid_data) else "",
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun EmailOutlinedTextField(
    modifier: Modifier = Modifier,
    email: String,
    onValueChange: (String) -> Unit,
    isError: Boolean
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth()
            .semantics {
                contentType = ContentType.Username + ContentType.EmailAddress
            },
        value = email,
        onValueChange = onValueChange,
        label = {
            Text(
                text = stringResource(Res.string.email_label)
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email
        ),
        maxLines = 1,
        isError = isError
    )
}

@Composable
private fun PasswordOutlinedTextField(
    modifier: Modifier = Modifier,
    password: String,
    onValueChange: (String) -> Unit,
    isError: Boolean
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = password,
        onValueChange = onValueChange,
        label = {
            Text(
                text = stringResource(Res.string.password_label)
            )
        },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        maxLines = 1,
        isError = isError
    )
}


@Composable
private fun LoginButton(
    modifier: Modifier = Modifier,
    enabled: Boolean,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth()
            .heightIn(min = 48.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
        enabled = enabled
    ) {
        Text(
            text = stringResource(Res.string.login),
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    AppTheme {
        LoginScreen(
            navigateToMainScreen = {}
        )
    }
}