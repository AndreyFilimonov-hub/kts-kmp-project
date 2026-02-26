package com.filimonov.vkclientkmp.domain.usecase

import com.filimonov.vkclientkmp.domain.repository.LoginRepository

class LoginUseCase(private val repository: LoginRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}