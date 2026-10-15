package mx.edu.utez.liverpool.ui.models

import java.util.UUID

data class Comentario(
    val id: String = UUID.randomUUID().toString(),
    val nombre: String,
    val comentario: String,
    val rating: Float
)