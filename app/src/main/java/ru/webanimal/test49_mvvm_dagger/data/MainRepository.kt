package ru.webanimal.test49_mvvm_dagger.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository : Repository {
	
	override suspend fun getData(): String = withContext(Dispatchers.IO) {
		"...main data"
	}
}