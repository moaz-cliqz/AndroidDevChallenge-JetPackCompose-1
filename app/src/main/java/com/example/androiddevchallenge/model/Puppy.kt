package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes
import java.io.Serializable

data class Puppy(val name: String = "" , @DrawableRes val resId: Int = -1, val details: String = ""): Serializable
