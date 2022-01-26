package com.kurulabs.mycards.di

import com.kurulabs.mycards.data.repositories.CardsMapper
import com.kurulabs.mycards.data.repositories.CardsMapperImpl
import com.kurulabs.mycards.data.repositories.CardsRemoteRepository
import com.kurulabs.mycards.data.repositories.CardsRepository
import com.kurulabs.mycards.data.sources.CardsRemoteDataSource
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
    fun provideCardsMapper(): CardsMapper {
        return CardsMapperImpl()
    }

    @Provides
    @ViewModelScoped
    fun provideCardsRepository(
        cardsLocalDataSource: CardsRemoteDataSource,
        cardsMapper: CardsMapper,
        coroutineDispatcher: CoroutineDispatcher
    ): CardsRepository {
        return CardsRemoteRepository(coroutineDispatcher, cardsMapper, cardsLocalDataSource)
    }
}