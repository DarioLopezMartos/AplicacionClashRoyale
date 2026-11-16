
package com.example.aplicacionclashroyale

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicacionclashroyale.ui.theme.AplicacionClashRoyaleTheme

@Composable
fun PantallaPrincipal(
    seleccionarCarta: (Int) -> Unit,
    crearCarta: () -> Unit
) {
    // Obtener las cartas del repositorio
    val cartas = CartaRepository.obtenerCartas()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = crearCarta
            ) {
                Text("+")
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Clash Wiki - Mis elementos",
                fontSize = 26.sp,
                color = Color(0xFF0D47A1),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(cartas) { carta ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                seleccionarCarta(carta.id)
                            }
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = carta.nombre,
                                fontSize = 20.sp
                            )

                            Text(
                                text = "Rareza: ${carta.rareza}",
                                fontSize = 14.sp
                            )

                            Text(
                                text = "Coste de elixir: ${carta.elixir}",
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPreviaPrincipal() {
    AplicacionClashRoyaleTheme {
        PantallaPrincipal(
            seleccionarCarta = {},
            crearCarta = {}
        )
    }
}
