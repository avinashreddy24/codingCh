package com.example.codingchallenge.models

data class People(
	val next: String? = null,
	val previous: Any? = null,
	val count: Int? = null,
	val results: List<ResultsItem?>? = null
)

data class ResultsItem(
	val films: List<String?>? = null,
	val homeworld: String? = null,
	val gender: String? = null,
	val skinColor: String? = null,
	val edited: String? = null,
	val created: String? = null,
	val mass: String? = null,
	val vehicles: List<String?>? = null,
	val url: String? = null,
	val hairColor: String? = null,
	val birthYear: String? = null,
	val eyeColor: String? = null,
	val species: List<Any?>? = null,
	val starships: List<String?>? = null,
	val name: String? = null,
	val height: String? = null
)

