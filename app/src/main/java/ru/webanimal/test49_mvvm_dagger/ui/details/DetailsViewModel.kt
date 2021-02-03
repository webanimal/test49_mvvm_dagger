package ru.webanimal.test49_mvvm_dagger.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.webanimal.test49_mvvm_dagger.data.DetailsRepository

class DetailsViewModel(private val detailsRepository: DetailsRepository) : ViewModel() {
	
	private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
		Log.e(TAG, "ExceptionHandler throwable:$throwable")
	}
	
	private val _data = MutableLiveData("Initial details")
	
	val data: LiveData<String> get() = _data
	
	fun onViewCreated() {
		viewModelScope.launch(coroutineExceptionHandler) {
			delay(DELAY_FOR_DETAILED_WORK)
			_data.value = detailsRepository.getData()
		}
	}
	
	companion object {
		private const val DELAY_FOR_DETAILED_WORK = 2000L
		
		private val TAG = DetailsViewModel::class.java.simpleName
	}
}