
package com.example.aplicacionclashroyale

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Diálogo para crear o editar una carta
@Composable
fun DialogoCarta(
    carta: Carta?,
    guardarCarta: (String, String, Int, String) -> Unit,
    cancelar: () -> Unit
) {

    // Paso 1: guardar los valores de los campos
    var nombre by remember(carta) {
        mutableStateOf(carta?.nombre ?: "")
    }

    var rareza by remember(carta) {
        mutableStateOf(carta?.rareza ?: "")
    }

    var elixir by remember(carta) {
        mutableStateOf(carta?.elixir?.toString() ?: "")
    }

    var descripcion by remember(carta) {
        mutableStateOf(carta?.descripcion ?: "")
    }

    // Paso 2: guardar los mensajes de error
    var errorNombre by remember {
        mutableStateOf("")
    }

    var errorRareza by remember {
        mutableStateOf("")
    }

    var errorElixir by remember {
        mutableStateOf("")
    }

    var errorDescripcion by remember {
        mutableStateOf("")
    }

    // Paso 3: mostrar el diálogo
    AlertDialog(
        onDismissRequest = cancelar,

        title = {
            Text(
                text = if (carta == null) {
                    "Nueva carta"
                } else {
                    "Editar carta"
                }
            )
        },

        text = {
            Column {

                // Campo del nombre
                OutlinedTextField(
                    value = nombre,
                    onValueChange = {
                        nombre = it
                        errorNombre = ""
                    },
                    label = {
                        Text("Nombre")
                    },
                    isError = errorNombre.isNotEmpty(),
                    singleLine = true
                )

                if (errorNombre.isNotEmpty()) {
                    Text(
                        text = errorNombre,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }

                // Campo de la rareza
                OutlinedTextField(
                    value = rareza,
                    onValueChange = {
                        rareza = it
                        errorRareza = ""
                    },
                    label = {
                        Text("Rareza")
                    },
                    isError = errorRareza.isNotEmpty(),
                    singleLine = true
                )

                if (errorRareza.isNotEmpty()) {
                    Text(
                        text = errorRareza,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }

                // Campo del coste de elixir
                OutlinedTextField(
                    value = elixir,
                    onValueChange = {
                        elixir = it
                        errorElixir = ""
                    },
                    label = {
                        Text("Coste de elixir")
                    },
                    isError = errorElixir.isNotEmpty(),
                    singleLine = true
                )

                if (errorElixir.isNotEmpty()) {
                    Text(
                        text = errorElixir,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }

                // Campo de la descripción
                OutlinedTextField(
                    value = descripcion,
                    onValueChange = {
                        descripcion = it
                        errorDescripcion = ""
                    },
                    label = {
                        Text("Descripción")
                    },
                    isError = errorDescripcion.isNotEmpty()
                )

                if (errorDescripcion.isNotEmpty()) {
                    Text(
                        text = errorDescripcion,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
            }
        },

        // Paso 4: guardar o cancelar
        confirmButton = {
            TextButton(
                onClick = {

                    // Comprobar que el nombre no esté vacío
                    if (nombre.isBlank()) {
                        errorNombre = "Introduce un nombre"
                    }

                    // Comprobar que la rareza no esté vacía
                    if (rareza.isBlank()) {
                        errorRareza = "Introduce una rareza"
                    }

                    // Comprobar que el elixir sea un número entre 1 y 10
                    val costeElixir = elixir.toIntOrNull()

                    if (costeElixir == null || costeElixir !in 1..10) {
                        errorElixir = "Introduce un valor entre 1 y 10"
                    }

                    // Comprobar que la descripción no esté vacía
                    if (descripcion.isBlank()) {
                        errorDescripcion = "Introduce una descripción"
                    }

                    // Guardar solamente si todos los campos son correctos
                    if (
                        nombre.isNotBlank() &&
                        rareza.isNotBlank() &&
                        costeElixir != null &&
                        costeElixir in 1..10 &&
                        descripcion.isNotBlank()
                    ) {
                        guardarCarta(
                            nombre,
                            rareza,
                            costeElixir,
                            descripcion
                        )
                    }
                }
            ) {
                Text("Guardar")
            }
        },

        dismissButton = {
            TextButton(
                onClick = cancelar
            ) {
                Text("Cancelar")
            }
        }
    )
}

// Diálogo para confirmar la eliminación de una carta
@Composable
fun DialogoEliminarCarta(
    carta: Carta,
    confirmarEliminar: () -> Unit,
    cancelar: () -> Unit
) {

    AlertDialog(
        onDismissRequest = cancelar,

        // Título del diálogo
        title = {
            Text("Eliminar carta")
        },

        // Mensaje de confirmación
        text = {
            Text(
                "¿Estás seguro de que quieres eliminar ${carta.nombre}?"
            )
        },

        // Botón para confirmar la eliminación
        confirmButton = {
            TextButton(
                onClick = confirmarEliminar
            ) {
                Text("Eliminar")
            }
        },

        // Botón para cancelar
        dismissButton = {
            TextButton(
                onClick = cancelar
            ) {
                Text("Cancelar")
            }
        }
    )
}
