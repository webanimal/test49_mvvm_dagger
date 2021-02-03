package ru.webanimal.test49_mvvm_dagger

import ru.webanimal.test49_mvvm_dagger.ui.ViewModelFactory

interface AppComponent {
    fun viewModelFactory(): ViewModelFactory
}