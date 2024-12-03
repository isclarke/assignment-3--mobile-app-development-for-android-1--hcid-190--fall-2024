package com.example.diamondprogram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diamondprogram.ui.theme.DIamondProgramTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      DIamondProgramTheme {
        DiamondInputScreen()
      }
    }
  }
}

@Composable
fun DiamondInputScreen() {
  var input by remember { mutableStateOf("") }
  var diamondOutput by remember { mutableStateOf("") }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    TextField(
      value = input,
      onValueChange = { input = it },
      label = { Text("Enter a positive number") },
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
    Button(onClick = {
      diamondOutput = generateDiamond(input)
    }) {
      Text("Generate Diamond")
    }
    Spacer(modifier = Modifier.height(16.dp))
    // Center the diamond output
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      Text(
        text = diamondOutput,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(16.dp)
      )
    }
  }
}

fun generateDiamond(input: String): String {
  val number = input.toIntOrNull() ?: return "Invalid input"
  if (number <= 0) return "Please enter a positive number"

  val stringBuilder = StringBuilder()
  val evenNumber = number % 2 == 0

  if (evenNumber) {
    // For even numbers
    for (i in 0 until 1) {
      val spaceCount = number / 2 - i
      val starPoint = 1

      // Print spaces
      for (j in 0 until spaceCount) {
        stringBuilder.append("  ")
      }

      // Print star
      for (j in 0 until starPoint) {
        stringBuilder.append("  *")
      }
      stringBuilder.appendLine()

      for (i in 1 until number / 2 + 1) {
        val spaceCount = number / 2 - i
        val starCount = 2 * (i + 1) - 2

        // Print spaces
        for (j in 0 until spaceCount) {
          stringBuilder.append("  ")
        }

        // Print stars
        for (j in 0 until starCount) {
          stringBuilder.append(" *")
        }
        stringBuilder.appendLine()
      }

      for (i in 0 until number / 2 - 1) {
        val spaceCount = i + 1
        val starCount = number - 2 * (i + 1)

        // Print spaces
        for (j in 0 until spaceCount) {
          stringBuilder.append("  ")
        }

        // Print stars
        for (j in 0 until starCount) {
          stringBuilder.append(" *")
        }
        stringBuilder.appendLine()
      }

      for (i in 0 until 1) {
        val spaceCount = number / 2 - i
        val bottomStar = 1

        // Print spaces
        for (j in 1 until spaceCount) {
          stringBuilder.append("  ")
        }

        // Print star
        for (j in 0 until bottomStar) {
          stringBuilder.append("  *")
        }
        stringBuilder.appendLine()
      }
    }
  } else {
    // For odd numbers
    for (i in 0 until number / 2 + 1) {
      val oddSpaceCount = number / 2 - i
      val oddStarCount = 2 * i + 1

      // Print spaces
      for (j in 0 until oddSpaceCount) {
        stringBuilder.append(" ")
      }
      for (j in 0 until oddStarCount) {
        stringBuilder.append("*")
      }
      stringBuilder.appendLine()
    }

    for (i in 0 until number / 2) {
      val oddSpaceCount = i + 1
      val oddStarCount = number - 2 * (i + 1)

      // Print spaces
      for (j in 0 until oddSpaceCount) {
        stringBuilder.append(" ")
      }

      // Print stars
      for (j in 0 until oddStarCount) {
        stringBuilder.append("*")
      }
      stringBuilder.appendLine()
    }
  }

  return stringBuilder.toString().trimEnd() // Trim the last newline
}


