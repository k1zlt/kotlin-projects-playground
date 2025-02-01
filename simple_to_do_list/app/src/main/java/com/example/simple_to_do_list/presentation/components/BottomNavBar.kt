package com.example.simple_to_do_list.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomNavBar(navController: NavController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Search, contentDescription = "Search")},
//            label = { Text("Search") },
            selected = false,
            onClick = {navController.navigate("search")}
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Dashboard")},
//            label = { Text("Task List") },
            selected = false,
            onClick = {navController.navigate("task-list")}
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Add, contentDescription = "Add new task")},
//            label = { Text("Add new task") },
            selected = false,
            onClick = {navController.navigate("add-task")}
        )
    }
}