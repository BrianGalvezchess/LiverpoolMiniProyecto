package mx.edu.utez.liverpool.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import mx.edu.utez.liverpool.R
import mx.edu.utez.liverpool.ui.viewModel.ProductoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetallesProductoScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    viewModel: ProductoViewModel = viewModel()
) {
    val productoSeleccionado by viewModel.productoSeleccionado.collectAsState()

    val liverpoolPink = Color(0xFFE91E63)
    val lightBackground = Color(0xFFF9F5F8)
    val greenEnvio = Color(0xFFE8F5E9)
    val greenText = Color(0xFF2E7D32)

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.Black
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Compartir",
                            tint = Color.Black
                        )
                    }
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Favorito",
                            tint = liverpoolPink
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shadowElevation = 8.dp,
                color = Color.White
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Button(
                        onClick = {  },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = liverpoolPink)
                    ) {
                        Text(
                            text = "Agregar a mi bolsa",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(lightBackground),
                contentAlignment = Alignment.Center
            ) {
                val imgRes = productoSeleccionado?.image ?: R.drawable.liverpool
                Image(
                    painter = painterResource(id = imgRes),
                    contentDescription = productoSeleccionado?.name ?: "Producto",
                    modifier = Modifier
                        .size(180.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Fit
                )

                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(liverpoolPink)
                    )
                    repeat(3) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = productoSeleccionado?.brand?.uppercase() ?: "",
                color = liverpoolPink,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = productoSeleccionado?.name ?: "Producto no disponible",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(6.dp))


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(text = "⭐", fontSize = 14.sp)
                Text(
                    text = "${productoSeleccionado?.rating ?: 0.0}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = "(${productoSeleccionado?.reviewCount ?: 0} opiniones)",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = "$${productoSeleccionado?.price ?: 0.0} MXN",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(10.dp))


            Surface(
                color = greenEnvio,
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "🚚 Envío gratis",
                        color = greenText,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            HorizontalDivider(color = Color(0xFFEEEEEE))
            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = "Descripción",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = productoSeleccionado?.description ?: "Sin descripción disponible.",
                color = Color.DarkGray,
                fontSize = 14.sp,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(20.dp))
            HorizontalDivider(color = Color(0xFFEEEEEE))
            Spacer(modifier = Modifier.height(16.dp))

            // 7. Opiniones de Clientes
            Text(
                text = "Opiniones de clientes",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))

            productoSeleccionado?.reviews?.forEach { opinion ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = lightBackground),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = opinion.author,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                            Text(
                                text = "⭐ ${opinion.rating}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "\"${opinion.comentario}\"",
                            fontSize = 13.sp,
                            color = Color.Gray
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}