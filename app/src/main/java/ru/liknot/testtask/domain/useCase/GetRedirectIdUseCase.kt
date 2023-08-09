package ru.liknot.testtask.domain.useCase

import ru.liknot.testtask.domain.repository.RedirectRepository

class GetRedirectIdUseCase(
    private val repository: RedirectRepository,
) {
}
