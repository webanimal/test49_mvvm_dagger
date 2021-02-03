package ru.webanimal.test49_mvvm_dagger.data

interface Repository {
	
	suspend fun getData(): String
}