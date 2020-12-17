package raum.muchbeer.ktxcoroutines.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.w3c.dom.Text
import raum.muchbeer.ktxcoroutines.R
import raum.muchbeer.ktxcoroutines.UserDataConcurrency


class FirstCorotineFragment : Fragment() {

    private var count = 0
    private lateinit var txtLoop : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first_corotine, container, false)
        val txtCount = view.findViewById<TextView>(R.id.txtCount)
         txtLoop = view.findViewById<TextView>(R.id.txtDsiplayLoop)
        val btnDownloadTask = view.findViewById<Button>(R.id.downloadTask)
        val btnCount = view.findViewById<Button>(R.id.btnCount)

        btnDownloadTask.setOnClickListener {
            //This launch builder is used when we don't expect to return any result
            CoroutineScope(Dispatchers.IO).launch {
              //  downloadData()
             //   downloadDataOnText()
                txtLoop.text = UserDataConcurrency().getThreadsConcurrency().toString()
            }
        }

        btnCount.setOnClickListener {
            txtCount.text = count++.toString()
        }

        return  view
    }

    private fun downloadData() {
        for(i in 1..200000) {
            Log.d("FirstCoroutine", "The loop $i is executed in ${Thread.currentThread().name}")
        }
    }

    private suspend fun downloadDataOnText() {
        for(i in 1..200000) {
            withContext(Dispatchers.Main) {
                txtLoop.text = "Looping counts $i"
            }

            Log.d("FirstCoroutine", "The loop $i is executed in ${Thread.currentThread().name}")
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstCorotineFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstCorotineFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}