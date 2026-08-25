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
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text(
                "English",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }
        items(10) { index ->
            ListItem(
                headlineContent = { Text("Extension Name $index") },
                supportingContent = { Text("v1.2.3 • all") },
                leadingContent = {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Filled.Extension, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                },
                trailingContent = {
                    Button(onClick = {}, shape = RoundedCornerShape(16.dp)) {
                        Text("Install")
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen() {
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
            item { SwitchListItem(Icons.Filled.CloudOff, "Downloaded only", false) }
            item { SwitchListItem(Icons.Filled.VisibilityOff, "Incognito mode", false) }
            item { HorizontalDivider() }
            item { SimpleListItem(Icons.Filled.Download, "Download queue") }
            item { SimpleListItem(Icons.Filled.Label, "Categories") }
            item { SimpleListItem(Icons.Filled.BarChart, "Statistics") }
            item { SimpleListItem(Icons.Filled.SettingsBackupRestore, "Backup and restore") }
            item { HorizontalDivider() }
            item { SimpleListItem(Icons.Filled.Settings, "Settings") }
            item { SimpleListItem(Icons.Filled.Info, "About") }
            item { SimpleListItem(Icons.Filled.HelpOutline, "Help") }
        }
    }
}

@Composable
fun SimpleListItem(icon: ImageVector, title: String) {
    ListItem(
        headlineContent = { Text(title) },
        leadingContent = { Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant) },
        modifier = Modifier.clickable { }
    )
}

@Composable
fun SwitchListItem(icon: ImageVector, title: String, checked: Boolean) {
    ListItem(
        headlineContent = { Text(title) },
        leadingContent = { Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant) },
        trailingContent = { Switch(checked = checked, onCheckedChange = {}) },
        modifier = Modifier.clickable { }
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
