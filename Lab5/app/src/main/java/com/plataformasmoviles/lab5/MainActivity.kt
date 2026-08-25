package com.plataformasmoviles.lab5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material.icons.filled.SystemUpdate
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.plataformasmoviles.lab5.ui.theme.Lab5Theme
import java.text.SimpleDateFormat
import java.util.Locale
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Lab5Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    RestaurantScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun RestaurantScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val spanishLocale = Locale.forLanguageTag("es-GT")

    val birthday = java.util.Calendar.getInstance().apply {
        set(2026, java.util.Calendar.MAY, 29)
    }.time

    val dayFormatter = SimpleDateFormat("EEEE", spanishLocale)
    val dateFormatter = SimpleDateFormat("d 'de' MMMM", spanishLocale)

    val dayName = dayFormatter.format(birthday)
        .replaceFirstChar { it.uppercase() }

    val date = dateFormatter.format(birthday)

    val schedule = "7 a.m. – 10 p.m."

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.SystemUpdate,
                contentDescription = "Actualización disponible",
                tint = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "Actualización disponible",
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp),
                style = MaterialTheme.typography.bodyMedium
            )

            TextButton(
                onClick = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(
                            "https://play.google.com/store/apps/details?id=com.whatsapp"
                        )
                    )
                    context.startActivity(intent)
                }
            ) {
                Text("Descargar")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Día actual
        Text(
            text = dayName,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = date,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Información del restaurante
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Pizza Hut",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )

                    IconButton(
                        onClick = {
                            val latitude = 14.6474611
                            val longitude = -90.4806876

                            val mapUri = Uri.parse(
                                "geo:$latitude,$longitude?q=$latitude,$longitude(Pizza Hut)"
                            )

                            val mapIntent = Intent(
                                Intent.ACTION_VIEW,
                                mapUri
                            )

                            context.startActivity(mapIntent)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Directions,
                            contentDescription = "Abrir ubicación en Maps",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Text(
                    text = "C.C. Hipernorte, Carretera al Atlántico",
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = schedule,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Button(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Axel Antonio Xitumul Chén",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    ) {
                        Text("Iniciar")
                    }

                    TextButton(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Tipo de comida: Pizzas y pastas\nPrecio: QQ (moderado)",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    ) {
                        Text("Detalles")
                    }
                }
            }
        }
    }
}