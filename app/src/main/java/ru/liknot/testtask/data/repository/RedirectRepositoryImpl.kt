package ru.liknot.testtask.data.repository

import ru.liknot.testtask.data.cache.SharedPreferencesImpl
import ru.liknot.testtask.domain.repository.RedirectRepository

class RedirectRepositoryImpl(
    private val local: SharedPreferencesImpl
) : RedirectRepository {
    override fun saveId(id: String) {
        local.saveId(id)
    }

    override fun saveUuId(uuid: String) {
        local.saveUuId(uuid)
    }

    override fun getId(): String? {
        return local.getId()
    }

    override fun getUuId(): String? {
        return local.getUuId()
    }
}
