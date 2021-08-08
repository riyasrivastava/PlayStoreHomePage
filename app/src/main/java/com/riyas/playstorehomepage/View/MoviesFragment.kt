package com.riyas.playstorehomepage.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.riyas.playstorehomepage.R

class MoviesFragment : Fragment() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.top_chart_fragment, null) as ViewGroup
        textView = root.findViewById(R.id.textView)
        textView.text = "Movies Fragment"
        return root
    }
}