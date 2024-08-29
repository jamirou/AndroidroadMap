package com.example.exercisingjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.exercisingjetpackcompose.ui.theme.ExercisingJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExercisingJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ExerciseOne(
                    )
                }
            }
        }
    }
}

const val myText = "Inside Column"

@Composable
fun MyColumn() {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            Text(myText)
            Text(myText)
            Text(myText)
        }
        Column() {
            Text(myText)
            Text(myText)
            Text(myText)
        }
    }
}

@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            MyColumn()
            MyColumn()
        }
    }
}

@Composable
fun ExerciseOne() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color.Cyan)
        ) {
            Text(
                text = "Ejemplo1",
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Red)
            ) {
                Text(
                    text = "Ejemplo 2",
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Green)
            ) {
                Text(
                    text = "Ejemplo 3",
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color.Magenta)
        ) {
            Text(
                text = "Ejemplo4",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ExercisingJetpackComposeTheme {
        ExerciseOne()
    }
}