package ru.webanimal.test49_mvvm_dagger

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import ru.webanimal.test49_mvvm_dagger.di.AppComponent
import ru.webanimal.test49_mvvm_dagger.di.DaggerAppComponent

class MyApp : Application() {
	
	lateinit var appComponent: AppComponent
	
	override fun onCreate() {
		super.onCreate()
		
		initDagger()
	}
	
	private fun initDagger() {
		appComponent = DaggerAppComponent.factory()
			.create(
				this.applicationContext,
				this
			)
	}
}

fun Context.appComponent(): AppComponent = (applicationContext as MyApp).appComponent

fun Fragment.appComponent(): AppComponent = requireContext().appComponent()