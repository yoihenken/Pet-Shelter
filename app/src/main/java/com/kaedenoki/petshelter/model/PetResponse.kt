package com.kaedenoki.petshelter.model

import com.google.gson.annotations.SerializedName

data class PetResponse(

	@field:SerializedName("CatList")
	val catList: List<CatListItem?>? = null,

	@field:SerializedName("DogList")
	val dogList: List<DogListItem?>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("description")
	val description: String? = null

)

data class CatListItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("endpoint")
	val endpoint: String? = null,
)

data class DogListItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("img")
	val img: String? = null,

	@field:SerializedName("endpoint")
	val endpoint: String? = null,
)