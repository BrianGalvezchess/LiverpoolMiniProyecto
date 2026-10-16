package mx.edu.utez.liverpool.ui.models
import androidx.annotation.DrawableRes
import java.util.UUID

data class Producto(
    val id: String = UUID.randomUUID().toString(),
    val brand: String,
    val name: String,
    val price: Double,
    val reviewCount: Int,
    val rating: Float,
    val isFreeShipping: Boolean = true,
    val description: String,
    val reviews: List<Comentario> = emptyList(),
    val isFavorite: Boolean = false,
    @DrawableRes val image: Int?
)