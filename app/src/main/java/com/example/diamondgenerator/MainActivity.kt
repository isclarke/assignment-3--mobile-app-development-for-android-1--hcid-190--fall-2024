package com.example.diamondgenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diamondgenerator.ui.theme.DiamondGeneratorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
          DiamondGeneratorTheme {
            Surface(
              modifier = Modifier.fillMaxSize(),
              color = MaterialTheme.colorScheme.background
            ) {
              Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
              ) {
                Column(
                  modifier = Modifier
                    .fillMaxWidth(),
                  verticalArrangment = Arrangement.Center,
                  horiziontalAlignment = Alignment.CenterHorizontally
                ) {
                  GreetingText(meesage = "Diamond Generator")
                  Spacer(modifier = Modifier.height(16.dp))
                }
              }
            }
          }


          @Composable
          fun Greeting(name: String, modifier: Modifier = Modifier) {
            Text(
              text = "Diamond amount",
              modifier = modifier
            )
          }

          @Preview(showBackground = true)
          @Composable
          fun GreetingPreview() {
            DiamondGeneratorTheme {
              Greeting("Android")
            }
          }
        }
