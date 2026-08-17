package com.plataformasmoviles.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plataformasmoviles.laboratorio4.ui.theme.Laboratorio4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Laboratorio4Theme {
                LabScreen()
            }
        }
    }
}

@Composable
fun LabScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(
                width = 10.dp,
                color = Color(0xFF16752B)
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.escudo_uvg),
            contentDescription = "Escudo UVG",
            modifier = Modifier
                .align(Alignment.Center)
                .size(300.dp)
                .alpha(0.15f)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 120.dp,
                    bottom = 120.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text( text = "Universidad del Valle\nde Guatemala", textAlign = TextAlign.Center, fontSize = 30.sp, fontWeight = FontWeight.Bold)

            Text( text = "Programación de plataformas\nmóviles, Seccion 30", textAlign = TextAlign.Center, fontSize = 24.sp)

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text( text = "INTEGRANTES", fontSize = 15.sp, fontWeight = FontWeight.Bold)

                Text( text = "Axel Xitumul\nKenett Ortega\nJunior Lancerio", fontSize = 15.sp)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text( text = "CATEDRÁTICO", fontSize = 15.sp, fontWeight = FontWeight.Bold)

                Text( text = "Juan Carlos Durini", fontSize = 15.sp)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text( text = "Axel Antonio Xitumul Chén", fontSize = 15.sp)

                Text( text =  "25783", fontSize = 15.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LabScreenPreview() {
    Laboratorio4Theme {
        LabScreen()
    }
}