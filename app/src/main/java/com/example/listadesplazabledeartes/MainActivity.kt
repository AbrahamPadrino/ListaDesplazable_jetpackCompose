package com.example.listadesplazabledeartes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listadesplazabledeartes.data.Datasource
import com.example.listadesplazabledeartes.model.Art
import com.example.listadesplazabledeartes.ui.theme.ListaDesplazableDeArtesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaDesplazableDeArtesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ArtApp()

                }
            }
        }
    }
}
// Crea una tarjeta del elemento de lista
@Composable
fun ArtCard(arte: Art, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(arte.imageResourceId),
                contentDescription = stringResource(arte.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(arte.stringResourceId),
                modifier = Modifier
                    .padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

// Crea una lista de tarjetas de artes
@Composable
fun ArtList(artesList: List<Art>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(artesList) { arte ->
            ArtCard(
                arte = arte,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

// Define el contenido de la actividad
@Composable
fun ArtApp() {
    ArtList(
        artesList = Datasource().loadArts()
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListaDesplazableDeArtesTheme {
        ArtApp()
    }
}