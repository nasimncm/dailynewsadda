package com.example.dailynewsadda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.RecyclerView
import com.example.dailynewsadda.adapter.AnimalDetailsAdapter
import com.example.dailynewsadda.model.AnimalDetailsModel


class AnimalFragment : Fragment() {
    private lateinit var rvAnimalDetails: RecyclerView
    private lateinit var animalDetailsAdapter: AnimalDetailsAdapter
    private lateinit var animalDetailsList: ArrayList<AnimalDetailsModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_animal, container, false)

        rvAnimalDetails = view.findViewById(R.id.rvAnimalDetails)
        animalDetailsList = arrayListOf()
        animalDetailsAdapter = AnimalDetailsAdapter(requireContext(), animalDetailsList)

        animalDetailsList.add(AnimalDetailsModel(getString(R.string.about_us)))
        animalDetailsList.add(AnimalDetailsModel(getString(R.string.about_us)))
        animalDetailsList.add(AnimalDetailsModel(getString(R.string.about_us)))
        animalDetailsList.add(AnimalDetailsModel(getString(R.string.about_us)))
        animalDetailsList.add(AnimalDetailsModel(getString(R.string.about_us)))
        animalDetailsList.add(AnimalDetailsModel(getString(R.string.about_us)))

        rvAnimalDetails.adapter = animalDetailsAdapter
        animalDetailsAdapter.notifyDataSetChanged()
        return view
    }
}