package ru.webanimal.test49_mvvm_dagger.di

import dagger.Module
import dagger.Provides
import ru.webanimal.test49_mvvm_dagger.data.DetailsRepository
import ru.webanimal.test49_mvvm_dagger.data.MainRepository
import ru.webanimal.test49_mvvm_dagger.ui.ViewModelFactory
import javax.inject.Singleton

@Module
class AppDataModule {
	
	@Provides
	@Singleton
	fun provideViewModelFactory(
		mainRepository: MainRepository,
		detailsRepository: DetailsRepository
	) = ViewModelFactory(mainRepository, detailsRepository)
}