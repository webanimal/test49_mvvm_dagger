package ru.webanimal.test49_mvvm_dagger.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.webanimal.test49_mvvm_dagger.data.DetailsRepository
import ru.webanimal.test49_mvvm_dagger.data.MainRepository
import ru.webanimal.test49_mvvm_dagger.ui.details.DetailsViewModel
import ru.webanimal.test49_mvvm_dagger.ui.main.MainViewModel

class ViewModelFactory(
    private val mainRepository: MainRepository,
    private val detailsRepository: DetailsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MainViewModel::class.java -> MainViewModel(mainRepository)
            DetailsViewModel::class.java -> DetailsViewModel(detailsRepository)
            else -> throw IllegalArgumentException("ViewModel of class:$modelClass is not supported")
        } as T
    }
}