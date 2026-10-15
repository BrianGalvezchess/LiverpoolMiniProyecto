package mx.edu.utez.liverpool.ui.models
import androidx.annotation.DrawableRes
import java.util.UUID

data class Producto(
    val id: String = UUID.randomUUID().toString(),
    val brand: String,
    val name: String,
    val price: Double,
    val rating: Float,
    val reviewCount: Int,
    val isFreeShipping: Boolean = true,
    val description: String,
    @DrawableRes val image: Int?,
    val reviews: List<Comentario> = emptyList(),
    val isFavorite: Boolean = false
)