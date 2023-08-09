package ru.liknot.testtask

import android.app.Application
import android.content.Context
import ru.liknot.testtask.data.cache.SharedPreferencesImpl
import ru.liknot.testtask.data.repository.RedirectRepositoryImpl
import ru.liknot.testtask.di.ServiceLocator
import ru.liknot.testtask.di.locate
import ru.liknot.testtask.domain.repository.RedirectRepository
import ru.liknot.testtask.domain.useCase.GetRedirectIdUseCase
import ru.liknot.testtask.domain.useCase.SaveRedirectIdUseCase

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        ServiceLocator.register<Context>(this)

        // Data
        ServiceLocator.register<SharedPreferencesImpl>(SharedPreferencesImpl(locate()))
        ServiceLocator.register<RedirectRepository>(RedirectRepositoryImpl(locate()))

        // Domain
        ServiceLocator.register<GetRedirectIdUseCase>(GetRedirectIdUseCase(locate()))
        ServiceLocator.register<SaveRedirectIdUseCase>(SaveRedirectIdUseCase(locate()))

        // Presentation

    }
}
