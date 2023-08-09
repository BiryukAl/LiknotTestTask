package ru.liknot.testtask.domain.repository

interface RedirectRepository {

    fun saveId(id: String?, uuid: String?)

    fun getId(): String
}
