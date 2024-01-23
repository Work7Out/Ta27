package appdenga.newyears2024.domain.di

import com.edurda77.data.repository.TaRepositoryImpl
import com.edurda77.domain.repository.TaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule {
    @Binds
    @Singleton
    abstract fun bindRepository(taRepository: TaRepositoryImpl): TaRepository
}