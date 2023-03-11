package com.example.dailynewsadda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailynewsadda.adapter.CountryDetailsAdapter
import com.example.dailynewsadda.model.CountryDetailsModel


class CountriesFragment : Fragment() {

    private lateinit var rvCountryDetails: RecyclerView
    private lateinit var countryDetailsAdapter: CountryDetailsAdapter
    private lateinit var countryDetailsList: ArrayList<CountryDetailsModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_countries, container, false)
        rvCountryDetails=view.findViewById(R.id.rvCountryDetails)
        countryDetailsList= arrayListOf()
        countryDetailsAdapter = CountryDetailsAdapter(requireContext(), countryDetailsList)

        countryDetailsList.add(CountryDetailsModel(getString(R.string.about_us)))
        countryDetailsList.add(CountryDetailsModel(getString(R.string.about_us)))
        countryDetailsList.add(CountryDetailsModel(getString(R.string.about_us)))
        countryDetailsList.add(CountryDetailsModel(getString(R.string.about_us)))
        countryDetailsList.add(CountryDetailsModel(getString(R.string.about_us)))
        rvCountryDetails.adapter = countryDetailsAdapter
        countryDetailsAdapter.notifyDataSetChanged()
        return view
    }
}