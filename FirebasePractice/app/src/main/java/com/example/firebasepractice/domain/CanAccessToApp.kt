package com.example.firebasepractice.domain

import com.example.firebasepractice.data.Repository

class CanAccessToApp {

    val repository = Repository()

    suspend operator fun invoke(): Boolean {
        val currentVersion = repository.getCurrentVersion()
        val minimumVersion = repository.getMinimumVersion()

        for ((currentPart, minVersionPart) in currentVersion.zip(minimumVersion)) {
            if (currentPart != minVersionPart) {
                return currentPart > minVersionPart
            }
        }
        return true
    }
}