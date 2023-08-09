package ru.liknot.testtask.presentation.screens.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.liknot.testtask.di.locateLazy
import ru.liknot.testtask.domain.useCase.GetRedirectIdUseCase
import ru.liknot.testtask.domain.useCase.SaveRedirectIdUseCase

class MainViewModel : ViewModel() {

    sealed class UiState {

        class Default(val id: String?, val uuid: String?) : UiState()
        object Loading : UiState()

        class Success(val id: String?, val uuid: String?) : UiState()

        data class Error(val exception: Throwable) : UiState()

    }

    private val getRedirectIdUseCase: GetRedirectIdUseCase by locateLazy()
    private val saveRedirectIdUseCase: SaveRedirectIdUseCase by locateLazy()

    private val _uiState = MutableStateFlow<UiState>(UiState.Default(null, null))
    val uiState: StateFlow<UiState> = _uiState

    init {
        defaultID()
    }

    private fun defaultID() {
        val id = getRedirectIdUseCase.getId()
        val uuid = getRedirectIdUseCase.getUuId()

        _uiState.value = UiState.Default(id, uuid)
    }

    fun saveId(id: String?, uuid: String?) {
        id?.let { saveRedirectIdUseCase.saveId(it) }
        uuid?.let { saveRedirectIdUseCase.saveId(it) }

        _uiState.value = UiState.Success(id, uuid)
    }


}
