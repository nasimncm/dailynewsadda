package com.example.dailynewsadda.model

data class TrendingFactsModel(
    var image:Int,
    var name:String
)

data class FeatureFactsModel(
    var image: Int,
    var name: String
)

data class TopCategoryModel(
    var image: Int,
    var name: String
)

data class TopCollectionFactsModel(
    var image: Int,
    var name: String
)

data class ScienceDetailsModel(
    var text: String
)

data class AnimalDetailsModel(
    var text: String
)

data class CountryDetailsModel(
    var text: String
)