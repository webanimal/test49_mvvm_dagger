package ru.webanimal.test49_mvvm_dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.webanimal.test49_mvvm_dagger.ui.Router
import ru.webanimal.test49_mvvm_dagger.ui.details.DetailsFragment
import ru.webanimal.test49_mvvm_dagger.ui.main.MainFragment

class MainActivity : AppCompatActivity(), Router {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.main_activity)
		
		if (savedInstanceState == null) {
			toMain()
		}
	}
	
	override fun toDetails() {
		navigateTo(DetailsFragment.newInstance())
	}
	
	override fun toMain() {
		navigateTo(MainFragment.newInstance())
	}
	
	private fun navigateTo(fragment: Fragment) {
		supportFragmentManager.beginTransaction()
			.replace(R.id.container, fragment)
			.commit()
	}
}