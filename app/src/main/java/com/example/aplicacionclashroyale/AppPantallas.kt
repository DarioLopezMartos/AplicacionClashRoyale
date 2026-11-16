
package com.example.aplicacionclashroyale

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun AppPantallas() {

    // Paso 1: guardar el identificador de la carta seleccionada
    var cartaSeleccionadaId by rememberSaveable {
        mutableStateOf<Int?>(null)
    }

    // Paso 2: controlar los diálogos
    var mostrarDialogoCrear by rememberSaveable {
        mutableStateOf(false)
    }

    var mostrarDialogoEditar by rememberSaveable {
        mutableStateOf(false)
    }

    var mostrarDialogoEliminar by rememberSaveable {
        mutableStateOf(false)
    }

    // Paso 3: obtener la carta seleccionada
    val cartas = CartaRepository.obtenerCartas()

    val cartaSeleccionada = cartas.find {
        it.id == cartaSeleccionadaId
    }

    // Paso 4: controlar el botón Atrás del dispositivo
    BackHandler(
        enabled = cartaSeleccionadaId != null
    ) {
        cartaSeleccionadaId = null
    }

    // Paso 5: decidir qué pantalla mostrar
    if (cartaSeleccionada == null) {

        PantallaPrincipal(
            seleccionarCarta = { id ->
                cartaSeleccionadaId = id
            },
            crearCarta = {
                mostrarDialogoCrear = true
            }
        )

    } else {

        PantallaDetalle(
            carta = cartaSeleccionada,

            volverLista = {
                cartaSeleccionadaId = null
            },

            editarCarta = {
                mostrarDialogoEditar = true
            },

            eliminarCarta = {
                mostrarDialogoEliminar = true
            }
        )
    }

    // Paso 6: mostrar el diálogo de creación
    if (mostrarDialogoCrear) {

        DialogoCarta(
            carta = null,

            guardarCarta = { nombre, rareza, elixir, descripcion ->

                CartaRepository.agregarCarta(
                    nombre,
                    rareza,
                    elixir,
                    descripcion
                )

                mostrarDialogoCrear = false
            },

            cancelar = {
                mostrarDialogoCrear = false
            }
        )
    }

    // Paso 7: mostrar el diálogo de edición
    if (mostrarDialogoEditar && cartaSeleccionada != null) {

        DialogoCarta(
            carta = cartaSeleccionada,

            guardarCarta = { nombre, rareza, elixir, descripcion ->

                val cartaActualizada = Carta(
                    id = cartaSeleccionada.id,
                    nombre = nombre,
                    rareza = rareza,
                    elixir = elixir,
                    descripcion = descripcion
                )

                CartaRepository.actualizarCarta(cartaActualizada)

                mostrarDialogoEditar = false
            },

            cancelar = {
                mostrarDialogoEditar = false
            }
        )
    }

    // Paso 8: mostrar el diálogo de eliminación
    if (mostrarDialogoEliminar && cartaSeleccionada != null) {

        DialogoEliminarCarta(
            carta = cartaSeleccionada,

            confirmarEliminar = {

                CartaRepository.eliminarCarta(
                    cartaSeleccionada.id
                )

                mostrarDialogoEliminar = false
                cartaSeleccionadaId = null
            },

            cancelar = {
                mostrarDialogoEliminar = false
            }
        )
    }
}
