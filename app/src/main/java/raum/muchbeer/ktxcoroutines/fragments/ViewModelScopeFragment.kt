package raum.muchbeer.ktxcoroutines.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import raum.muchbeer.ktxcoroutines.R
import raum.muchbeer.ktxcoroutines.viewmodel.CorotineViewModel


class ViewModelScopeFragment : Fragment() {

    private lateinit var corotinViewModel: CorotineViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_view_model_scope, container, false)
        corotinViewModel = ViewModelProvider(this).get(CorotineViewModel::class.java)

        corotinViewModel.getUserData()
        corotinViewModel.mutableResult.observe(viewLifecycleOwner, Observer { myResult->
            myResult.forEach {
                Log.d("ViewModelScopeFragment", "Familia ya Machibya ni ${it.userName}")
          }
        })
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ViewModelScopeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}