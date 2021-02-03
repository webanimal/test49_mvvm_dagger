package ru.webanimal.test49_mvvm_dagger.ui.details

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

class DetailsFragment : Fragment(), View.OnClickListener {
	
	private var tvMessage: TextView? = null
	private var btnBackToMain: Button? = null
	
	private var router: Router? = null
	
	private lateinit var viewModel: DetailsViewModel
	
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
		
		return inflater.inflate(R.layout.details_fragment, container, false)
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
		if (v?.id == R.id.btnBackToMain) {
			router?.toMain()
		}
	}
	
	private fun setupViews(parent: View) {
		tvMessage = parent.findViewById(R.id.tvMessage)
		btnBackToMain = parent.findViewById(R.id.btnBackToMain)
		
		btnBackToMain?.setOnClickListener(this)
	}
	
	private fun clearViews() {
		tvMessage = null
		btnBackToMain = null
	}
	
	private fun setupViewModel() {
		viewModel = ViewModelProvider(this, appComponent().viewModelFactory())
			.get(DetailsViewModel::class.java)
		
		viewModel.data.observe(this.viewLifecycleOwner) {
			bindViews(it)
		}
		
		viewModel.onViewCreated()
	}
	
	private fun bindViews(data: String) {
		tvMessage?.text = data
	}
	
	companion object {
		fun newInstance() = DetailsFragment()
	}
}