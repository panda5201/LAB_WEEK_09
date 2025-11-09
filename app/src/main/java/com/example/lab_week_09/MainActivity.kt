package com.example.lab_week_09

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab_week_09.ui.theme.LAB_WEEK_09Theme
import com.example.lab_week_09.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LAB_WEEK_09Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // ✅ Langkah 13: buat list dan panggil Home(list)
                    val list = listOf("Tanu", "Tina", "Tono")
                    Home(list)
                }
            }
        }
    }
}

@Composable
fun Home(itemsAwal: List<String>) {
    var text by remember { mutableStateOf("") }
    var items by remember { mutableStateOf(itemsAwal) } // mulai dari list awal

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.enter_item),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text("Masukkan item...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (text.isNotBlank()) {
                    items = items + text
                    text = ""
                }
            }
        ) {
            Text(text = stringResource(id = R.string.button_click))
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items) { item ->
                Text(
                    text = item,
                    modifier = Modifier.padding(vertical = 8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    LAB_WEEK_09Theme {
        Home(listOf("Tanu", "Tina", "Tono"))
    }
}
