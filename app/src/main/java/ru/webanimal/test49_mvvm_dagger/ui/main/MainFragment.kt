package ru.webanimal.test49_mvvm_dagger.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import ru.webanimal.test49_mvvm_dagger.MainActivity
import ru.webanimal.test49_mvvm_dagger.R
import ru.webanimal.test49_mvvm_dagger.appComponent
import ru.webanimal.test49_mvvm_dagger.ui.Router

// https://developer.android.com/training/dependency-injection/dagger-android?hl=ur
// https://developer.android.com/codelabs/android-dagger?index=..%2F..index#0
// https://medium.com/@shashankmohabia/dagger-android-with-mvvm-dependency-injection-for-android-3a7e33ad1013
class MainFragment : Fragment(), View.OnClickListener {
	
	private var tvMessage: TextView? = null
	private var btnRouteToDetails: Button? = null
	
	private var router: Router? = null
	
	private lateinit var viewModel: MainViewModel
	
	override fun onAttach(context: Context) {
		super.onAttach(context)
		
		if (context is MainActivity) {
			router = context
		}
	}
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		
		return inflater.inflate(R.layout.main_fragment, container, false)
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		setupViews(view)
		setupViewModel()
	}
	
	override fun onDestroyView() {
		clearViews()
		
		super.onDestroyView()
	}
	
	override fun onDetach() {
		router = null
		
		super.onDetach()
	}
	
	override fun onClick(v: View?) {
		if (v?.id == R.id.btnToDetails) {
			router?.toDetails()
		}
	}
	
	private fun setupViews(parent: View) {
		tvMessage = parent.findViewById(R.id.tvMessage)
		btnRouteToDetails = parent.findViewById(R.id.btnToDetails)
		
		btnRouteToDetails?.setOnClickListener(this)
	}
	
	private fun clearViews() {
		tvMessage = null
		btnRouteToDetails = null
	}
	
	private fun setupViewModel() {
		viewModel = ViewModelProvider(this, appComponent().viewModelFactory())
			.get(MainViewModel::class.java)
		
		viewModel.data.observe(this.viewLifecycleOwner) {
			bindViews(it)
		}
		
		viewModel.onViewCreated()
	}
	
	private fun bindViews(data: String) {
		tvMessage?.text = data
	}
	
	companion object {
		fun newInstance() = MainFragment()
	}
}