package mx.edu.utez.liverpool.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import mx.edu.utez.liverpool.R
import mx.edu.utez.liverpool.ui.theme.Pink40
import mx.edu.utez.liverpool.ui.theme.Pink80

@Composable
fun InicioScreen(
    onNavigationToListado: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.padding(vertical = 50.dp)
                .size(120.dp),
            painter = painterResource(R.drawable.liverpool),
            contentDescription = "Logo de Liverpool"
        )

        Text("Bienvenido a Liverpool",
            style = MaterialTheme.typography.titleSmall,
            color = Color.Black,
            fontSize = 5.em
        )
        Text("Es parte de mi vida",
            style = MaterialTheme.typography.titleSmall,
            color = Color.Black,
        )

        Button(
            modifier = Modifier.fillMaxWidth()
                .padding(50.dp)
                .height(60.dp),
            onClick = {
                onNavigationToListado()
            },
            colors = ButtonColors(
                containerColor = Pink40,
                contentColor = Color.White,
                disabledContainerColor = Pink40,
                disabledContentColor = Pink80
            )
        ) {
            Text("Ver Productos",
                style = MaterialTheme.typography.titleSmall,
                color = Color.White,
                fontSize = 3.em
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InicioScreenPreview() {
    InicioScreen(
        onNavigationToListado = {}
    )
}