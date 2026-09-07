package com.plataformasmoviles.lab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plataformasmoviles.lab6.ui.theme.Lab6Theme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab6Theme {
                CounterScreen()
            }
        }
    }
}


@Composable
fun CounterScreen(){
    var contador by remember {
        mutableIntStateOf(0)
    }
    var contadorIncrementos by remember {
        mutableIntStateOf(0)
    }
    var contadorDecrementos by remember {
        mutableIntStateOf(0)
    }
    var contadorMaximo by remember{
        mutableIntStateOf(0)
    }
    var contadorMinimo by remember{
        mutableIntStateOf(0)
    }
    val listaNumeros = remember {
        mutableStateListOf<Int>()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        Arrangement.Center,

    ) {
        Text(
            text = "Axel Xitumul",
            fontSize = 28.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    contador--
                    contadorDecrementos++
                    if(contadorMinimo < contadorMaximo) {
                        contadorMinimo = contador
                    }
                    listaNumeros.add(contador)
                }
            ) { Text("-") }
            Text(
                text = "$contador",
                fontSize = 48.sp,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Button(
                onClick = {
                    contador++
                    contadorIncrementos++
                    if (contador > contadorMaximo) {
                        contadorMaximo = contador
                    }
                    listaNumeros.add(contador)
                    }
            ) { Text("+") }
        }
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 16.dp),
            thickness = 1.dp
        )

        Text(
            text = "Total incrementos: $contadorIncrementos",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)

        )
        Text(
            text = "Total decrementos: $contadorDecrementos",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)

        )
        Text(
            text = "Valor mínimo: $contadorMinimo",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)

        )
        Text(
            text = "Valor máximo: $contadorMaximo",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)

        )
        Text(
            text = "Total cambios: ${contadorDecrementos + contadorIncrementos}",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)

        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Historial:",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)

        )
        Spacer(modifier = Modifier.height(30.dp))
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            columns = GridCells.Fixed(5),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listaNumeros.size) { indice ->

                val anterior = if (indice == 0) {
                    0
                } else {
                    listaNumeros[indice - 1]
                }

                val colorCuadro = if (listaNumeros[indice] > anterior) {
                    Color(0xFF2E7D32)
                } else {
                    Color.Red
                }

                Card(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = colorCuadro
                        ),

                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${listaNumeros[indice]}",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
        Button(
            onClick = {
                contador = 0
                contadorIncrementos = 0
                contadorDecrementos = 0
                contadorMaximo = 0
                contadorMinimo = 0

                listaNumeros.clear()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reiniciar")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LabScreenPreview() {
    Lab6Theme{
        CounterScreen()
    }
}