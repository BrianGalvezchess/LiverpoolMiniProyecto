package mx.edu.utez.liverpool.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import mx.edu.utez.liverpool.R
import mx.edu.utez.liverpool.ui.theme.Pink40
import mx.edu.utez.liverpool.ui.theme.Pink80

@Composable
fun InicioScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Liverpool",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Red,
            fontSize = 10.em
        )
        Text("Es parte de mi vida",
            style = MaterialTheme.typography.titleSmall,
            color = Color.Red,
            fontSize = 5.em
        )

        Image(
            modifier = Modifier.padding(vertical = 50.dp),
            painter = painterResource(R.drawable.liverpool),
            contentDescription = "Logo de Liverpool"
        )

        Button(
            modifier = Modifier.fillMaxWidth()
                .padding(50.dp),
            onClick = {  },
            colors = ButtonColors(
                Color.Red,
                contentColor = Color.Black,
                disabledContainerColor = Color.Red,
                disabledContentColor = Color.Red
            )
        ) {
            Text("Entrar a Liverpool")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InicioScreenPreview() {
    // Si tu pantalla usa un ViewModel o callbacks, pasa datos ficticios
    InicioScreen(
        onBackClick = {}
    )
}