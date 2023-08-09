package ru.liknot.testtask.data.repository

import ru.liknot.testtask.data.cache.SharedPreferencesImpl
import ru.liknot.testtask.domain.repository.RedirectRepository

class RedirectRepositoryImpl (
    private val local: SharedPreferencesImpl
): RedirectRepository {
    override fun saveId(id: String?, uuid: String?) {
        TODO("Not yet implemented")
    }

    override fun getId(): String {
        TODO("Not yet implemented")
    }
}
