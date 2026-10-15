package mx.edu.utez.liverpool.ui.models

import androidx.annotation.DrawableRes
import mx.edu.utez.liverpool.R
import java.util.UUID

data class Producto(
    val id: String = UUID.randomUUID().toString(),
    val brand: String,
    val name: String,
    val price: Double,
    val ratin: Float,
    val reviewCount: Int,
    val isFreeShipping: Boolean = true,
    val description: String,
    @DrawableRes val img: Int?,
    val reviews: List<Comentario> = emptyList(),
    val isFavorite: Boolean = false
)