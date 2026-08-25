package com.example

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdatesScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Updates", style = MaterialTheme.typography.titleLarge) },
                actions = { IconButton(onClick = {}) { Icon(Icons.Filled.Refresh, "Refresh") } }
            )
        }
    ) { padding ->
        EmptyState(
            icon = Icons.Filled.NewReleases,
            text = "No recent updates",
            modifier = Modifier.padding(padding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("History", style = MaterialTheme.typography.titleLarge) },
                actions = { IconButton(onClick = {}) { Icon(Icons.Filled.Delete, "Delete") } }
            )
        }
    ) { padding ->
        EmptyState(
            icon = Icons.Filled.History,
            text = "Nothing read recently",
            modifier = Modifier.padding(padding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrowseScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Sources", "Extensions", "Migrate")
    
    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = { Text("Browse", style = MaterialTheme.typography.titleLarge) },
                    actions = {
                        IconButton(onClick = {}) { Icon(Icons.Filled.Search, "Search") }
                        IconButton(onClick = {}) { Icon(Icons.Filled.FilterList, "Filter") }
                    }
                )
                TabRow(selectedTabIndex = selectedTab) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = { Text(title) }
                        )
                    }
                }
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding).fillMaxSize()) {
            when (selectedTab) {
                0 -> EmptyState(Icons.Filled.Explore, "No sources installed")
                1 -> ExtensionsList()
                2 -> EmptyState(Icons.Filled.Sync, "No migrations available")
            }
        }
    }
}

@Composable
fun ExtensionsList() {
    EmptyState(Icons.Filled.Extension, "No extensions found")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("More", style = MaterialTheme.typography.titleLarge) })
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).fillMaxSize()) {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Filled.Book,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        "Mihon",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        "v0.16.5",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            item { HorizontalDivider() }
            item { SwitchListItem(Icons.Filled.CloudOff, "Downloaded only", "Filters all entries in your library", false) }
            item { SwitchListItem(Icons.Filled.VisibilityOff, "Incognito mode", "Pauses reading history", false) }
            item { HorizontalDivider() }
            item { SimpleListItem(Icons.Filled.Download, "Download queue", null) { navController.navigate("download_queue") } }
            item { SimpleListItem(Icons.Filled.Label, "Categories", null) { navController.navigate("categories") } }
            item { SimpleListItem(Icons.Filled.BarChart, "Statistics") { navController.navigate("statistics") } }
            item { SimpleListItem(Icons.Filled.Storage, "Data and storage") { navController.navigate("settings_data_storage") } }
            item { HorizontalDivider() }
            item { SimpleListItem(Icons.Filled.Settings, "Settings") { navController.navigate("settings") } }
            item { SimpleListItem(Icons.Filled.Favorite, "Support Us") { navController.navigate("support_us") } }
            item { SimpleListItem(Icons.Filled.Info, "About") { navController.navigate("about") } }
            item { SimpleListItem(Icons.Filled.HelpOutline, "Help") { navController.navigate("help") } }
        }
    }
}

@Composable
fun SimpleListItem(icon: ImageVector, title: String, subtitle: String? = null, onClick: () -> Unit = {}) {
    ListItem(
        headlineContent = { Text(title) },
        supportingContent = if (subtitle != null) { { Text(subtitle) } } else null,
        leadingContent = { Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant) },
        modifier = Modifier.clickable { onClick() }
    )
}

@Composable
fun SwitchListItem(icon: ImageVector, title: String, subtitle: String? = null, checked: Boolean, onCheckedChange: (Boolean) -> Unit = {}) {
    ListItem(
        headlineContent = { Text(title) },
        supportingContent = if (subtitle != null) { { Text(subtitle) } } else null,
        leadingContent = { Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant) },
        trailingContent = { Switch(checked = checked, onCheckedChange = onCheckedChange) },
        modifier = Modifier.clickable { onCheckedChange(!checked) }
    )
}

@Composable
fun EmptyState(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier.size(64.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}
