package ru.liknot.testtask.domain.useCase

import ru.liknot.testtask.domain.repository.RedirectRepository

class SaveRedirectIdUseCase(
    private val repository: RedirectRepository,
) {
}
