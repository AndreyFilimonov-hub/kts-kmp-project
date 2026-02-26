package com.filimonov.vkclientkmp.presentation.screens.loginscreen

data class LoginUiState(
    val email: String,
    val password: String,
    val isError: Boolean
) {
    val isLoginButtonActive: Boolean
        get() = email.isNotEmpty() && password.isNotEmpty()
}
