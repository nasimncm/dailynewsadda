package com.example.dailynewsadda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.dailynewsadda.adapter.ScienceDetailsAdapter
import com.example.dailynewsadda.model.ScienceDetailsModel


class ScienceFragment : Fragment() {

    private lateinit var rvScienceDetails: RecyclerView
    private lateinit var scienceDetailsAdapter: ScienceDetailsAdapter
    private lateinit var scienceDetailsList: ArrayList<ScienceDetailsModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_science, container, false)

        rvScienceDetails = view.findViewById(R.id.rvScienceDetails)
        scienceDetailsList = arrayListOf()
        scienceDetailsAdapter = ScienceDetailsAdapter(requireContext(), scienceDetailsList)

        scienceDetailsList.add(ScienceDetailsModel(getString(R.string.about_us)))
        scienceDetailsList.add(ScienceDetailsModel(getString(R.string.about_us)))
        scienceDetailsList.add(ScienceDetailsModel(getString(R.string.about_us)))
        scienceDetailsList.add(ScienceDetailsModel(getString(R.string.about_us)))
        scienceDetailsList.add(ScienceDetailsModel(getString(R.string.about_us)))
        scienceDetailsList.add(ScienceDetailsModel(getString(R.string.about_us)))
        scienceDetailsList.add(ScienceDetailsModel(getString(R.string.about_us)))

        rvScienceDetails.adapter = scienceDetailsAdapter
        scienceDetailsAdapter.notifyDataSetChanged()
        return view
    }
}