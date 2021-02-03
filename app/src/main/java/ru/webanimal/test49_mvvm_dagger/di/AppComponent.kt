package ru.webanimal.test49_mvvm_dagger.di

import android.app.Application
import android.content.Context
import androidx.annotation.NonNull
import dagger.BindsInstance
import dagger.Component
import ru.webanimal.test49_mvvm_dagger.ui.details.DetailsFragment
import ru.webanimal.test49_mvvm_dagger.ui.main.MainFragment
import javax.inject.Singleton

@Component(modules = [AppDataModule::class, DataModule::class, NetworkModule::class])
@Singleton
interface AppComponent {
	
	@Component.Factory
	interface Factory {
		@NonNull
		fun create(
			@BindsInstance @NonNull context: Context,
			@BindsInstance @NonNull application: Application
		): AppComponent
	}
	
	fun inject(fragment: MainFragment)
	
	fun inject(fragment: DetailsFragment)
}