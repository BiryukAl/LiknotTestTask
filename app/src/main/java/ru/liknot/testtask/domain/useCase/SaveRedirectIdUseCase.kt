package ru.liknot.testtask.domain.useCase

import ru.liknot.testtask.domain.repository.RedirectRepository

class SaveRedirectIdUseCase(
    private val repository: RedirectRepository,
) {
    fun saveId(id: String) {
        repository.saveId(id)
    }

    fun saveUuId(uuid: String) {
        repository.saveUuId(uuid)
    }
}
