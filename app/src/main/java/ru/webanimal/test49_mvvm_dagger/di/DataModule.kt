package ru.webanimal.test49_mvvm_dagger.di

import dagger.Module
import dagger.Provides
import ru.webanimal.test49_mvvm_dagger.data.DetailsRepository
import ru.webanimal.test49_mvvm_dagger.data.MainRepository
import javax.inject.Singleton

@Module
class DataModule {
	
	@Provides
	@Singleton
	fun provideMainRepository() = MainRepository()
	
	@Provides
	@Singleton
	fun provideDetailsRepository() = DetailsRepository()
}