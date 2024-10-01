package com.robertobizzozzero.primeraapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robertobizzozzero.primeraapp.ui.theme.PrimeraAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            /* ACA ES DONDE SE INICIALIZA EL COMPOSABLE PRIMERA APP */
            PrimeraApp()

        }
    }

    /* -------- Solamente para previsualizar -------- */
    @Preview(showBackground = true)
    @Composable
    fun PrimeraAppPreview() {
        PrimeraAppTheme {
            PrimeraApp()
        }
    }


    @Composable
    /* Contenedor de los tres "Composables", se arma en una columna y se introduce en el "Surface" */
    fun PrimeraApp() {
        var entrada by remember { mutableStateOf("") }
        var etiqueta by remember { mutableStateOf("") }

        MaterialTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize() // el campo ocupa toda la pantalla
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center // alinea el conjunto en el centro si es center
                ) {
                    Etiqueta(text = etiqueta)
                    Entrada(value = entrada, onValueChange = { entrada = it })
                    Boton(onClick = {
                        etiqueta = entrada
                        entrada = "" // vacia el campo al darle click al boton
                    })
                }
            }
        }
    }

    @Composable // no hace falta entender aun
    /* -------- Contructor -------- */
    fun Etiqueta(text: String) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium, // lo de rojo son clases que hay que importar
            modifier = Modifier.padding(bottom = 16.dp) // dp es el tamaño del texto
        )
    }

    @Composable
    /* -------- Campo de entrada -------- */
    fun Entrada(value: String, onValueChange: (String) -> Unit) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = "Ingrese un texto") },
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    /* -------- Botón -------- */
    fun Boton(onClick: () -> Unit) {
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Cambiar Etiqueta")
        }
    }







}