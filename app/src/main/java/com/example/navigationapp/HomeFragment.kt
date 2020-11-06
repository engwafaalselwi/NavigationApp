package com.example.navigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
private const val container = "item"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var item: Int? = null
    lateinit var textView :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            item = it.getInt(container)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var  view=inflater.inflate(R.layout.fragment_home, container, false)
        textView=view.findViewById(R.id.textView)

        when(item){
            R.id.profile-> {
                view.setBackgroundResource(R.color.design_default_color_primary)
                textView.setText("Your Profile")
            }
            R.id.setting->{
                view.setBackgroundResource(R.color.colorAccent)
                textView.setText("The Setting")
            }
            R.id.aboutUs->{
                view.setBackgroundResource(R.color.design_default_color_error)
                textView.setText("aboutUs")
            }
            else->{textView.setText(" aboutUs")}
        }
        return view
    }

    companion object {
        fun newInstance(param1: String , item :Int) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putInt(container,item)

                }
            }
    }
}