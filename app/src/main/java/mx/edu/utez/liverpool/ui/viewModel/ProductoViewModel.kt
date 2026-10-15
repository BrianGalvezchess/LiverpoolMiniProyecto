package mx.edu.utez.liverpool.ui.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import mx.edu.utez.liverpool.R
import mx.edu.utez.liverpool.ui.models.Comentario
import mx.edu.utez.liverpool.ui.models.Producto

class ProductoViewModel : ViewModel() {
    private val _productos = MutableStateFlow<List<Producto>>(
        listOf(
            Producto(
                brand = "DIOR",
                name = "Sauvage Eau de Perfum",
                price = 2250.0,
                rating = 4.8f,
                reviewCount = 128,
                description = "Una composicion rotundamente fresca, un aroma sexi y cool con Notas de Bergamota de Reggio de Calabria.",
                image = R.drawable.dior,
                reviews = listOf(
                    Comentario(author = "Brian Emiliano Galvez", comentario = "Excelente aroma y duracion", rating = 5.0f),
                    Comentario(author = "Alan Emir Vargas", comentario = "Llego muy rapido, empaquetado y el diseño todo bien", rating = 4.8f)
                )
            ),
            Producto(
                brand = "LG",
                name = "Smart TV LG 55\" 4K UHD ThinQ AI",
                price = 9999.0,
                rating = 4.2f,
                reviewCount = 94,
                description = "Disfruta de colores nítidos y detalles realistas con la tecnología 4K real y procesador inteligente.",
                image = R.drawable.smartv,
                reviews = listOf(
                    Comentario(author = "Juan Gabriel Galvez", comentario = "La calidad de imagen es brutal por el precio.", rating = 5.0f),
                    Comentario(author = "Laura Karla", comentario = "La pantalla y los colores muy impresionantes, por su precio se ve que es de los mejores", rating = 4.5f)
            )
        ),
            Producto(
                brand = "NIKE",
                name = "Tenis Nike Air Max Para Hombre",
                price = 2899.0,
                rating = 4.7f,
                reviewCount = 210,
                description = "Amortiguación Max Air visible diseñada originalmente para el running de alto rendimiento y comodida al dia a dia.",
                image = R.drawable.nike,
                reviews = listOf(
                    Comentario(author = "Kevin Galvez Gabriel", comentario = "Súper cómodos para el uso diario.", rating = 5.0f)
            )
    ),
            Producto(
                brand = "APPLE",
                name = "iPhone 15 128GB Negro",
                price = 19499.0,
                rating = 4.9f,
                reviewCount = 340,
                description = "Dinamic Island, cámara principal de 48 MP con teleobjetivo de 2x y diseño de vidrio con infusión de color.",
                image = R.drawable.iphone,
                reviews = listOf(
                    Comentario(author = "Valeria Gomez Sanchez", comentario = "La cámara es una locura, vale totalmente la pena.", rating = 4.0f)
                )
            ),
            Producto(
                brand = "NESPRESSO",
                name = "Cafetera Vertuo Pop",
                price = 2490.0,
                rating = 4.5f,
                reviewCount = 67,
                description = "Compacta y colorida, prepara diferentes tamaños de taza con sólo tocar un botón gracias al sistema Centrifusion.",
                image = R.drawable.cafetera,
                reviews = listOf(
                    Comentario(author = "Jorge Castellanos", comentario = "El café sale con una espuma deliciosa.", rating = 4.5f)
                )
            ),
            Producto(
                brand = "APPLE",
                name = "Smartwatch Apple Watch SE 2nd Gen",
                price = 5599.0,
                rating = 4.8f,
                reviewCount = 115,
                description = "Funciones esenciales para mantenerte conectado, activo, seguro y saludable con pantalla Retina OLED.",
                image = R.drawable.smartwatch,
                reviews = listOf(
                    Comentario(author = "Emmanuel Ramirez Villalva.", comentario = "Ligero y la batería le dura bastante bien.", rating = 4.4f)
                )
            ),
            Producto(
                brand = "HP",
                name = "Laptop HP Pavilion 15.6\" Core i5",
                price = 14999.0,
                rating = 4.4f,
                reviewCount = 52,
                description = "Rendimiento confiable para tus estudios de desarrollo de software, multitarea fluida y diseño elegante.",
                image = R.drawable.laptop,
                reviews = listOf(
                    Comentario(author = "Johana Galvez Alvarez", comentario =  "Ideal para programar y correr entornos pesados.", rating = 3.9f)
                )
            )
        )
    )

    val productos : StateFlow<List<Producto>> = _productos.asStateFlow()
    private val _productoSeleccionado = MutableStateFlow<Producto?>(null)
    val productoSeleccionado : StateFlow<Producto?> = _productoSeleccionado.asStateFlow()

    fun seleccionarProducto(producto: Producto){
        _productoSeleccionado.value = producto
    }
}