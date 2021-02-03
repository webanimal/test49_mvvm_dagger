package ru.webanimal.test49_mvvm_dagger.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.webanimal.test49_mvvm_dagger.data.MainRepository

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
	
	private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
		Log.e(TAG, "ExceptionHandler throwable:$throwable")
	}
	
	private val _data = MutableLiveData("Hello!")
	
	val data: LiveData<String> get() = _data
	
	fun onViewCreated() {
		viewModelScope.launch(coroutineExceptionHandler) {
			delay(DELAY_FOR_MAIN_WORK)
			_data.value = mainRepository.getData()
		}
	}
	
	companion object {
		private const val DELAY_FOR_MAIN_WORK = 3000L
		
		private val TAG = MainViewModel::class.java.simpleName
	}
}