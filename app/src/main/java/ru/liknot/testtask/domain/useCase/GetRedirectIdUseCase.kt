package ru.liknot.testtask.domain.useCase

import ru.liknot.testtask.domain.repository.RedirectRepository

class GetRedirectIdUseCase(
    private val repository: RedirectRepository,
) {

    fun getId(): String? {
        return repository.getId()
    }

    fun getUuId(): String? {
        return repository.getUuId()
    }
}
