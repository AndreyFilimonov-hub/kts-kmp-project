package com.filimonov.vkclientkmp.data.repository

import com.filimonov.vkclientkmp.domain.repository.LoginRepository

class LoginRepositoryImpl : LoginRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Result<Unit> {
        return if (email.contains("@")) {
            Result.success(Unit)
        } else {
            Result.failure(IllegalStateException("Invalid email"))
        }
    }
}