package com.example.veterinaria.presentation.screens.calificacion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.veterinaria.domain.model.AspectoDestacado
import com.example.veterinaria.domain.model.Calificacion
import com.example.veterinaria.domain.repository.CalificacionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalificacionViewModel @Inject constructor(
    private val repository: CalificacionRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CalificacionUiState())
    val uiState: StateFlow<CalificacionUiState> = _uiState.asStateFlow()

    init {
        cargarCita()
    }

    private fun cargarCita() {
        viewModelScope.launch {
            val cita = repository.obtenerUltimaCitaFinalizada()
            // Si esa cita ya fue calificada, mostramos lo que se guardó en Room
            val guardada = repository.observarCalificacion(cita.id).first()
            _uiState.update {
                if (guardada != null) {
                    it.copy(
                        cargando = false,
                        cita = cita,
                        estrellas = guardada.estrellas,
                        aspectos = guardada.aspectos,
                        comentario = guardada.comentario,
                        enviada = true
                    )
                } else {
                    it.copy(cargando = false, cita = cita)
                }
            }
        }
    }

    // ----- Eventos de la UI -----

    fun onEstrellasSeleccionadas(valor: Int) {
        if (_uiState.value.enviada) return
        _uiState.update { it.copy(estrellas = valor, error = null) }
    }

    fun onAspectoClick(aspecto: AspectoDestacado) {
        if (_uiState.value.enviada) return
        _uiState.update {
            val nuevos = if (aspecto in it.aspectos) it.aspectos - aspecto else it.aspectos + aspecto
            it.copy(aspectos = nuevos)
        }
    }

    fun onComentarioChange(texto: String) {
        if (texto.length <= 300) _uiState.update { it.copy(comentario = texto) }
    }

    fun onEnviar() {
        val estado = _uiState.value
        val cita = estado.cita ?: return
        if (estado.estrellas == 0) {
            _uiState.update { it.copy(error = "Selecciona de 1 a 5 estrellas antes de enviar") }
            return
        }
        viewModelScope.launch {
            _uiState.update { it.copy(enviando = true) }
            repository.guardar(
                Calificacion(
                    citaId = cita.id,
                    estrellas = estado.estrellas,
                    aspectos = estado.aspectos,
                    comentario = estado.comentario.trim()
                )
            )
            _uiState.update { it.copy(enviando = false, enviada = true) }
        }
    }
}
