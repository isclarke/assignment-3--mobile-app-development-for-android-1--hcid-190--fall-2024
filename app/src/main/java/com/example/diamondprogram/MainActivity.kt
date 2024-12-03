package com.example.diamondprogram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

  // Use vertical and horizontal scroll states
  val verticalScrollState = rememberScrollState()
  val horizontalScrollState = rememberScrollState()

  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)
      .verticalScroll(verticalScrollState), // Enable vertical scrolling
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top // Align to the top
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
    // Wrap the diamond output in a horizontally scrollable Row
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .horizontalScroll(horizontalScrollState) // Enable horizontal scrolling
        .padding(16.dp),
      horizontalArrangement = Arrangement.Center
    ) {
      Text(
        text = diamondOutput,
        textAlign = TextAlign.Center,
        fontSize = 14.sp,
        modifier = Modifier.align(Alignment.CenterVertically)
      )
    }
  }
}

fun generateDiamond(input: String): String {
  val number = input.toIntOrNull() ?: return "Invalid input"
  if (number <= 0) return "Please enter a positive number"

  val stringBuilder = StringBuilder()
  val isEven = number % 2 == 0

  fun generateDiamond(input: String): String {
    val number = input.toIntOrNull() ?: return "Invalid input"
    if (number <= 0) return "Please enter a positive number"

    val stringBuilder = StringBuilder()
    val isEven = number % 2 == 0

    if (isEven) {
      // For even numbers: Create a symmetric diamond with spaces between stars
      // Top single star
      val topSpaces = number / 2 - 1
      stringBuilder.append(" ".repeat(topSpaces) + "*")
      stringBuilder.appendLine()

      // Top half of the diamond (excluding the middle)
      for (i in 1..number / 2) {
        val spaceCount = number / 2 - i
        val starCount = 2 * i

        // Print spaces
        stringBuilder.append(" ".repeat(spaceCount))
        // Print stars with a space between them
        stringBuilder.append("* ".repeat(starCount).trimEnd())
        stringBuilder.appendLine()
      }

      // Bottom half of the diamond (excluding the middle)
      for (i in number / 2 - 1 downTo 1) {
        val spaceCount = number / 2 - i
        val starCount = 2 * i

        // Print spaces
        stringBuilder.append(" ".repeat(spaceCount))
        // Print stars with a space between them
        stringBuilder.append("* ".repeat(starCount).trimEnd())
        stringBuilder.appendLine()
      }

      // Bottom single star
      stringBuilder.append(" ".repeat(topSpaces) + "*")
      stringBuilder.appendLine()
    } else {
      // For odd numbers
      for (i in 0 until number / 2 + 1) {
        val oddSpaceCount = number / 2 - i
        val oddStarCount = 2 * i + 1

        // Print spaces
        stringBuilder.append(" ".repeat(oddSpaceCount))
        // Print stars without spaces
        stringBuilder.append("* ".repeat(oddStarCount).trimEnd())
        stringBuilder.appendLine()
      }

      for (i in number / 2 - 1 downTo 0) {
        val oddSpaceCount = number / 2 - i
        val oddStarCount = 2 * i + 1

        // Print spaces
        stringBuilder.append(" ".repeat(oddSpaceCount))
        // Print stars without spaces
        stringBuilder.append("* ".repeat(oddStarCount).trimEnd())
        stringBuilder.appendLine()
      }
    }

    return TODO("Provide the return value")
  }
  return stringBuilder.toString().trimEnd() // Trim the last newline
}

