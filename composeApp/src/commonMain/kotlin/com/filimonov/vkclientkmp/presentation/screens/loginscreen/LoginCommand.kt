package com.filimonov.vkclientkmp.presentation.screens.loginscreen

sealed interface LoginCommand {

    data class InputEmail(val value: String) : LoginCommand

    data class InputPassword(val value: String) : LoginCommand

    data object Login : LoginCommand
}