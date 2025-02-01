package com.example.simple_to_do_list.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simple_to_do_list.presentation.components.BottomNavBar
import com.example.simple_to_do_list.presentation.ui.theme.Simple_to_do_listTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Simple_to_do_listTheme {
                Main()
            }
        }
    }
}
@Composable
fun Main() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = "task-list",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("search") {Screen()}
            composable("task-list") {Screen()}
            composable("add-task") {Screen()}
        }
    }
}
@Composable
fun Screen() {
    Text("HelloWorld")
}
