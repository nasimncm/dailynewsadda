package com.example.dailynewsadda

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.dailynewsadda.adapter.FeatureFactsAdapter
import com.example.dailynewsadda.adapter.TopCategoryFactsAdapter
import com.example.dailynewsadda.adapter.TopCollectionFactsAdapter
import com.example.dailynewsadda.adapter.TrendingFactsAdapter
import com.example.dailynewsadda.model.FeatureFactsModel
import com.example.dailynewsadda.model.TopCategoryModel
import com.example.dailynewsadda.model.TopCollectionFactsModel
import com.example.dailynewsadda.model.TrendingFactsModel
import kotlin.math.abs

class HomeFragment : Fragment() {

    //Code For View Pager
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter: ImageAdapter

    //Code For Recycler View (Trending Facts)
    private lateinit var rvTrendingFacts: RecyclerView
    private lateinit var trendingFactsAdapter: TrendingFactsAdapter
    private lateinit var trendingfactsList: ArrayList<TrendingFactsModel>

    //Code For Recycler View (Top Category Facts)
    private lateinit var rvTopCategoryFacts: RecyclerView
    private lateinit var topCategoryFactsAdapter: TopCategoryFactsAdapter
    private lateinit var topCategoryFactsList: ArrayList<TopCategoryModel>

    //Code For Recycler View (Top Collection Facts)
    private lateinit var rvTopCollectionFacts: RecyclerView
    private lateinit var topCollectionFactsAdapter: TopCollectionFactsAdapter
    private lateinit var topCollectionFactsList: ArrayList<TopCollectionFactsModel>

    //Code For Recycler View (Feature Facts)
    private lateinit var rvFeatureFacts: RecyclerView
    private lateinit var featureFactsAdapter: FeatureFactsAdapter
    private lateinit var featurefactsList: ArrayList<FeatureFactsModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        init(view)

        return view

        //Code For View Pager
        setUpTransformer()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)
            }
        })


    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 2000)
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    private fun setUpTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        viewPager2.setPageTransformer(transformer)
    }

    private fun init(view: View) {

        val clBookmark: ConstraintLayout = view.findViewById(R.id.clBookmark)
        clBookmark.setOnClickListener {
            val intent = Intent(requireContext(),BookmarkActivity::class.java)
            context?.startActivity(intent)
        }

        //Code For View Pager
        viewPager2 = view.findViewById(R.id.viewPager2)
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()
        imageList.add(R.drawable.nature_1)
        imageList.add(R.drawable.science_2)
        imageList.add(R.drawable.diet_3)
        imageList.add(R.drawable.beauty_4)

        adapter = ImageAdapter(imageList, viewPager2)
        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER


        //Code For Recycler View(Trending Facts)
        rvTrendingFacts = view.findViewById(R.id.rvTrendingFacts)
        trendingfactsList = arrayListOf()
        trendingFactsAdapter = TrendingFactsAdapter(requireContext(), trendingfactsList)

        trendingfactsList.add(TrendingFactsModel(R.drawable.camera, "Gadgets"))
        trendingfactsList.add(TrendingFactsModel(R.drawable.medicine, "Medicine"))
        trendingfactsList.add(TrendingFactsModel(R.drawable.personal, "Personal Care"))
        trendingfactsList.add(TrendingFactsModel(R.drawable.mama, "Lotion"))

        rvTrendingFacts.adapter = trendingFactsAdapter

        //Code For Recycler View (Top Category Facts)
        rvTopCategoryFacts = view.findViewById(R.id.rvCategoryFacts)
        topCategoryFactsList = arrayListOf()
        topCategoryFactsAdapter = TopCategoryFactsAdapter(requireContext(), topCategoryFactsList)

        topCategoryFactsList.add(TopCategoryModel(R.drawable.weird, "Weird Facts"))
        topCategoryFactsList.add(TopCategoryModel(R.drawable.car, "Car Facts"))
        topCategoryFactsList.add(TopCategoryModel(R.drawable.internet, "Internet Facts"))
        topCategoryFactsList.add(TopCategoryModel(R.drawable.`fun`, "Fun Facts"))

        rvTopCategoryFacts.adapter = topCategoryFactsAdapter

        //Code For Recycler View (Top Collection Facts)
        rvTopCollectionFacts = view.findViewById(R.id.rvCollection)
        topCollectionFactsList = arrayListOf()
        topCollectionFactsAdapter =
            TopCollectionFactsAdapter(requireContext(), topCollectionFactsList)

        topCollectionFactsList.add(TopCollectionFactsModel(R.drawable.autism, "Autism Facts"))
        topCollectionFactsList.add(TopCollectionFactsModel(R.drawable.drug, "Drug Facts"))
        topCollectionFactsList.add(TopCollectionFactsModel(R.drawable.bullying, "Bullying Facts"))
        topCollectionFactsList.add(TopCollectionFactsModel(R.drawable.smoking, "Smoking Facts"))
        topCollectionFactsList.add(
            TopCollectionFactsModel(
                R.drawable.depression,
                "Depression Facts"
            )
        )
        topCollectionFactsList.add(TopCollectionFactsModel(R.drawable.eyes, "Eyes Facts"))
        rvTopCollectionFacts.adapter = topCollectionFactsAdapter


        //Code For Recycler View (Feature Facts)
        rvFeatureFacts = view.findViewById(R.id.rvFeatureFacts)
        featurefactsList = arrayListOf()
        featureFactsAdapter = FeatureFactsAdapter(requireContext(), featurefactsList)

        featurefactsList.add(FeatureFactsModel(R.drawable.feature, "Laptop"))
        featurefactsList.add(FeatureFactsModel(R.drawable.nivea, "Skin Care Products"))
        featurefactsList.add(FeatureFactsModel(R.drawable.ayurved, "Ayurvedic Products"))
        featurefactsList.add(FeatureFactsModel(R.drawable.bisk, "Bisk Farm"))

        rvFeatureFacts.adapter = featureFactsAdapter



        adapter.notifyDataSetChanged()
    }
}