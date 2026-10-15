package mx.edu.utez.liverpool.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import mx.edu.utez.liverpool.ui.models.Producto
import mx.edu.utez.liverpool.ui.viewModel.ProductoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaProductosScreen(
    viewModel: ProductoViewModel,
    onProductoClick : () -> Unit
) {
    val productos by viewModel.productos.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Liverpool - Catalogo de productos", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(productos) { producto ->
                TarjetaProductoItem(
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
fun TarjetaProductoItem(
    producto : Producto,
    onClick : () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick()},
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            producto.image?.let { imgRes ->
                Image(
                    painter = painterResource(id = imgRes),
                    contentDescription = producto.name,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Información principal
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = producto.brand.uppercase(),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = producto.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "$${producto.price} MXN",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "⭐ ${producto.rating} (${producto.reviewCount} opiniones)",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}