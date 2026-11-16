
package com.example.aplicacionclashroyale

import androidx.compose.runtime.mutableStateListOf

// Repositorio encargado de gestionar las cartas
object CartaRepository {

    // Lista de cartas guardadas en memoria
    private val cartas = mutableStateListOf(

        Carta(
            1,
            "Caballero",
            "Común",
            3,
            "Una unidad resistente que ataca a los enemigos cuerpo a cuerpo."
        ),

        Carta(
            2,
            "Gigante",
            "Especial",
            5,
            "Una unidad con muchos puntos de vida que ataca estructuras."
        ),

        Carta(
            3,
            "Mosquetera",
            "Especial",
            4,
            "Ataca a distancia y puede alcanzar unidades terrestres y aéreas."
        ),

        Carta(
            4,
            "Mini P.E.K.K.A.",
            "Especial",
            4,
            "Inflige mucho daño a un único objetivo mediante ataques cuerpo a cuerpo."
        ),

        Carta(
            5,
            "Mago",
            "Especial",
            5,
            "Lanza ataques de área que dañan a varios enemigos."
        ),

        Carta(
            6,
            "Dragón Bebé",
            "Épica",
            4,
            "Unidad aérea que realiza ataques de área contra sus enemigos."
        ),

        Carta(
            7,
            "Arqueras",
            "Común",
            3,
            "Dos unidades que atacan a distancia con sus arcos."
        ),

        Carta(
            8,
            "Valquiria",
            "Especial",
            4,
            "Una guerrera que realiza ataques giratorios contra enemigos cercanos."
        ),

        Carta(
            9,
            "Príncipe",
            "Épica",
            5,
            "Carga contra sus enemigos e inflige un gran daño."
        ),

        Carta(
            10,
            "Globo bombástico",
            "Épica",
            5,
            "Unidad aérea que ataca directamente las estructuras."
        ),

        Carta(
            11,
            "Bruja",
            "Épica",
            5,
            "Ataca a distancia e invoca esqueletos para ayudarla."
        ),

        Carta(
            12,
            "Ejército de esqueletos",
            "Épica",
            3,
            "Un grupo de esqueletos que rodea y ataca a sus enemigos."
        )
    )

    // Identificador que tendrá la siguiente carta
    private var siguienteId = 13

    // Obtener todas las cartas
    fun obtenerCartas(): List<Carta> {
        return cartas
    }

    // Añadir una carta nueva
    fun agregarCarta(
        nombre: String,
        rareza: String,
        elixir: Int,
        descripcion: String
    ) {
        val nuevaCarta = Carta(
            siguienteId,
            nombre,
            rareza,
            elixir,
            descripcion
        )

        cartas.add(nuevaCarta)
        siguienteId++
    }

    // Actualizar una carta existente
    fun actualizarCarta(cartaActualizada: Carta) {

        val indice = cartas.indexOfFirst {
            it.id == cartaActualizada.id
        }

        if (indice != -1) {
            cartas[indice] = cartaActualizada
        }
    }

    // Eliminar una carta
    fun eliminarCarta(id: Int) {

        val indice = cartas.indexOfFirst {
            it.id == id
        }

        if (indice != -1) {
            cartas.removeAt(indice)
        }
    }
}
