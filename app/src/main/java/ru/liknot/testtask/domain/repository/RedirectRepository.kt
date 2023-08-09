package ru.liknot.testtask.domain.repository

interface RedirectRepository {

    fun saveId(id: String)
    fun saveUuId(uuid: String)

    fun getId(): String?
    fun getUuId(): String?
}
