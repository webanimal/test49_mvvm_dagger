package ru.webanimal.test49_mvvm_dagger

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import ru.webanimal.test49_mvvm_dagger.data.DetailsRepository
import ru.webanimal.test49_mvvm_dagger.data.MainRepository
import ru.webanimal.test49_mvvm_dagger.ui.ViewModelFactory

class MyApp : Application(), AppComponent {
	
	private lateinit var viewModelFactory: ViewModelFactory
	private lateinit var mainRepository: MainRepository
	private lateinit var detailsRepository: DetailsRepository
	
	override fun onCreate() {
		super.onCreate()
		
		mainRepository = MainRepository()
		detailsRepository = DetailsRepository()
		viewModelFactory = ViewModelFactory(mainRepository, detailsRepository)
	}
	
	override fun viewModelFactory(): ViewModelFactory = viewModelFactory
}

fun Context.appComponent() = (applicationContext as MyApp)

fun Fragment.appComponent() = requireContext().appComponent()