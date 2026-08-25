package com.example

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DownloadQueueScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Download queue") },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } },
                actions = { 
                    IconButton(onClick = {}) { Icon(Icons.Filled.Pause, "Pause") }
                    IconButton(onClick = {}) { Icon(Icons.Filled.MoreVert, "More") } 
                }
            )
        }
    ) { padding ->
        EmptyState(Icons.Filled.Download, "No downloads in queue", Modifier.padding(padding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit categories") },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } },
                actions = { IconButton(onClick = {}) { Icon(Icons.Filled.Add, "Add") } }
            )
        }
    ) { padding ->
        EmptyState(Icons.Filled.Label, "No categories", Modifier.padding(padding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatisticsScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Statistics") },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } }
            )
        }
    ) { padding ->
        LazyColumn(Modifier.padding(padding)) {
            item { Text("Overview", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
            item { SimpleListItem(Icons.Filled.AccessTime, "Read duration", "0d 0h 0m", onClick = {}) }
            item { SimpleListItem(Icons.Filled.LibraryBooks, "In library", "0 Entries", onClick = {}) }
            item { SimpleListItem(Icons.Filled.Sync, "In global update", "0 Chapters", onClick = {}) }
            item { SimpleListItem(Icons.Filled.Storage, "Local", "0 Downloaded", onClick = {}) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackupRestoreScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Backup and restore") },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } }
            )
        }
    ) { padding ->
        LazyColumn(Modifier.padding(padding)) {
            item { SimpleListItem(Icons.Filled.SettingsBackupRestore, "Create backup", null, onClick = {}) }
            item { SimpleListItem(Icons.Filled.Restore, "Restore backup", null, onClick = {}) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("About") },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } }
            )
        }
    ) { padding ->
        LazyColumn(Modifier.padding(padding)) {
            item { SimpleListItem(Icons.Filled.Info, "Version", "Stable 0.20.4 (05/08/2026 6:27 pm)", onClick = {}) }
            item { SimpleListItem(Icons.Filled.Update, "Check for updates", null, onClick = {}) }
            item { SimpleListItem(Icons.Filled.NewReleases, "What's new", null, onClick = {}) }
            item { SimpleListItem(Icons.Filled.Code, "Open source licenses", null, onClick = {}) }
            item { SimpleListItem(Icons.Filled.PrivacyTip, "Privacy policy", null, onClick = {}) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Help") },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } }
            )
        }
    ) { padding ->
        EmptyState(Icons.Filled.Help, "Help center", Modifier.padding(padding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SupportUsScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Support Us") },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } }
            )
        }
    ) { padding ->
        LazyColumn(Modifier.padding(padding)) {
            item { Text("Patrons get access to exclusive channels, with more perks to come.", modifier = Modifier.padding(16.dp)) }
            item { SimpleListItem(Icons.Filled.Favorite, "Patreon (preferred)", null, onClick = {}) }
            item { SimpleListItem(Icons.Filled.Group, "OpenCollective", null, onClick = {}) }
            item { Text("Mihon is currently backed by 200+ patrons. We want to thank each and everyone of you. Let's make Mihon even better together.", modifier = Modifier.padding(16.dp)) }
            item { Text("For alternative options or any related questions, join our Discord server.", modifier = Modifier.padding(16.dp)) }
            item { SimpleListItem(Icons.Filled.ChatBubble, "Discord", null, onClick = {}) }
        }
    }
}
