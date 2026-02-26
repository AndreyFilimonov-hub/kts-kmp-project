package com.filimonov.vkclientkmp.presentation.screens.loginscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filimonov.vkclientkmp.data.repository.LoginRepositoryImpl
import com.filimonov.vkclientkmp.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val repository = LoginRepositoryImpl()
    private val loginUseCase = LoginUseCase(repository)

    private val _state = MutableStateFlow(LoginUiState("", "", false))
    val state = _state.asStateFlow()

    private val _loginEvent = MutableSharedFlow<LoginUiEvent>()
    val loginEvent = _loginEvent.asSharedFlow()

    fun processCommand(command: LoginCommand) {
        viewModelScope.launch {
            when (command) {
                is LoginCommand.InputEmail -> {
                    _state.update { previousState ->
                        previousState.copy(email = command.value, isError = false)
                    }
                }

                is LoginCommand.InputPassword -> {
                    _state.update { previousState ->
                        previousState.copy(password = command.value, isError = false)
                    }
                }

                LoginCommand.Login -> {
                    loginUseCase(_state.value.email, _state.value.password)
                        .onSuccess {
                            _loginEvent.emit(LoginUiEvent.LoginSuccessEvent)
                        }
                        .onFailure {
                            _state.value = _state.value.copy(isError = true)
                        }
                }
            }
        }
    }
}