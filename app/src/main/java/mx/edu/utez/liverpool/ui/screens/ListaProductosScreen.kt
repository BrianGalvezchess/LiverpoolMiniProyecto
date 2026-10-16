package mx.edu.utez.liverpool.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import mx.edu.utez.liverpool.ui.models.Producto
import mx.edu.utez.liverpool.ui.viewModel.ProductoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaProductosScreen(
    viewModel: ProductoViewModel = viewModel(),
    onProductoClick: () -> Unit,
    onBackClick: () -> Unit
) {
    val productos by viewModel.productos.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                },
                title = {
                    // Barra de búsqueda decorativa
                    TextField(
                        value = "",
                        onValueChange = {}, // No realiza ninguna acción por el momento
                        placeholder = {
                            Text(
                                text = "Buscar en Liverpool...",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        },
                        singleLine = true,
                        readOnly = true, // Desactiva el teclado al tocarla
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Buscar",
                                tint = Color.Gray
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(46.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(productos) { producto ->
                TarjetaProductoGridItem(
                    producto = producto,
                    onClick = {
                        viewModel.seleccionarProducto(producto)
                        onProductoClick()
                    }
                )
            }
        }
    }
}

@Composable
fun TarjetaProductoGridItem(
    producto: Producto,
    onClick: () -> Unit
) {
    val liverpoolPink = Color(0xFFE91E63)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                contentAlignment = Alignment.Center
            ) {
                producto.image?.let { imgRes ->
                    Image(
                        painter = painterResource(id = imgRes),
                        contentDescription = producto.name,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = producto.brand.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = liverpoolPink,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = producto.name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "$${producto.price}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
            )

            Text(
                text = "⭐ ${producto.rating} (${producto.reviewCount})",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                fontSize = 11.sp
            )
        }
    }
}