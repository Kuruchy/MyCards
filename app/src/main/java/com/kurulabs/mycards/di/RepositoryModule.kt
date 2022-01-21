package com.kurulabs.mycards.di

import com.kurulabs.mycards.data.repositories.CardsRepository
import com.kurulabs.mycards.data.repositories.FakeCardsRepository
import com.kurulabs.mycards.data.sources.FakeCardsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideCardsRepository(
        cardsLocalDataSource: FakeCardsRemoteDataSource,
        coroutineDispatcher: CoroutineDispatcher
    ): CardsRepository {
        return FakeCardsRepository(cardsLocalDataSource, coroutineDispatcher)
    }
}