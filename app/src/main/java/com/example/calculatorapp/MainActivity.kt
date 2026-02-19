package com.example.calculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.fillMaxWidth












class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CalculatorScreen()
        }
    }
}



@Composable
fun CalculatorScreen() {

    var input by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = input,
            fontSize = 48.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            textAlign = TextAlign.End
        )

        Row {
            CalcButton("7") { input += "7" }
            CalcButton("8") { input += "8" }
            CalcButton("9") { input += "9" }
            CalcButton("/") { input += "/" }
        }

        Row {
            CalcButton("4") { input += "4" }
            CalcButton("5") { input += "5" }
            CalcButton("6") { input += "6" }
            CalcButton("*") { input += "*" }
        }

        Row {
            CalcButton("1") { input += "1" }
            CalcButton("2") { input += "2" }
            CalcButton("3") { input += "3" }
            CalcButton("-") { input += "-" }
        }

        Row {
            CalcButton("0") { input += "0" }
            CalcButton("C") { input = "" }
            CalcButton("=") { input = calculate(input) }
            CalcButton("+") { input += "+" }
        }
    }
}


fun calculate(expression: String): String {
    return try {
        val parts: List<String>

        if (expression.contains("+")) {
            parts = expression.split("+")
            (parts[0].toDouble() + parts[1].toDouble()).toString()
        } else if (expression.contains("-")) {
            parts = expression.split("-")
            (parts[0].toDouble() - parts[1].toDouble()).toString()
        } else if (expression.contains("*")) {
            parts = expression.split("*")
            (parts[0].toDouble() * parts[1].toDouble()).toString()
        } else if (expression.contains("/")) {
            parts = expression.split("/")
            (parts[0].toDouble() / parts[1].toDouble()).toString()
        } else {
            expression
        }

    } catch (e: Exception) {
        "Error"
    }
}


@Composable
fun CalcButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(4.dp)
    ) {
        Text(text = text, fontSize = 20.sp)
    }
}



