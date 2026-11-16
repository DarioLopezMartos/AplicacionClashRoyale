
package com.example.aplicacionclashroyale

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicacionclashroyale.ui.theme.AplicacionClashRoyaleTheme

@Composable
fun PantallaDetalle(
    carta: `Carta`,
    volverLista: () -> Unit,
    editarCarta: () -> Unit,
    eliminarCarta: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Mostrar el nombre de la carta
        Text(
            text = carta.nombre,
            fontSize = 30.sp,
            color = Color(0xFF0D47A1)
        )

        // Mostrar la rareza
        Text(
            text = "Rareza: ${carta.rareza}",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 24.dp)
        )

        // Mostrar el coste de elixir
        Text(
            text = "Coste de elixir: ${carta.elixir}",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Mostrar la descripción
        Text(
            text = carta.descripcion,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 24.dp)
        )

        // Botón para volver al listado
        Button(
            onClick = volverLista,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
        ) {
            Text(text = "Volver a las cartas")
        }

        // Botón para editar la carta
        Button(
            onClick = editarCarta,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        ) {
            Text(text = "Editar carta")
        }

        // Botón para eliminar la carta
        Button(
            onClick = eliminarCarta,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        ) {
            Text(text = "Eliminar carta")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPreviaDetalle() {
    AplicacionClashRoyaleTheme {
        PantallaDetalle(
            carta = CartaRepository.obtenerCartas()[0],
            volverLista = {},
            editarCarta = {},
            eliminarCarta = {}
        )
    }
}
