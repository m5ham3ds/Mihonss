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
fun SettingsScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } },
                actions = { IconButton(onClick = {}) { Icon(Icons.Filled.Search, "Search") } }
            )
        }
    ) { padding ->
        LazyColumn(Modifier.padding(padding)) {
            item { SimpleListItem(Icons.Filled.Settings, "General", null, onClick = {}) }
            item { SimpleListItem(Icons.Filled.Palette, "Appearance", "Theme, date & time format", onClick = { navController.navigate("settings_appearance") }) }
            item { SimpleListItem(Icons.Filled.Book, "Library", "Categories, global update, chapter swipe", onClick = { navController.navigate("settings_library") }) }
            item { SimpleListItem(Icons.Filled.ChromeReaderMode, "Reader", "Reading mode, display, navigation", onClick = { navController.navigate("settings_reader") }) }
            item { SimpleListItem(Icons.Filled.Download, "Downloads", "Automatic download, download ahead", onClick = { navController.navigate("settings_downloads") }) }
            item { SimpleListItem(Icons.Filled.Sync, "Tracking", "One-way progress sync, enhanced sync", onClick = { navController.navigate("settings_tracking") }) }
            item { SimpleListItem(Icons.Filled.Explore, "Browse", "Sources, extensions, global search", onClick = { navController.navigate("settings_browse") }) }
            item { SimpleListItem(Icons.Filled.Storage, "Data and storage", "Manual & automatic backups, storage space", onClick = { navController.navigate("settings_data_storage") }) }
            item { SimpleListItem(Icons.Filled.Security, "Security and privacy", "App lock, secure screen", onClick = { navController.navigate("settings_security_privacy") }) }
            item { SimpleListItem(Icons.Filled.Code, "Advanced", "Dump crash logs, battery optimizations", onClick = { navController.navigate("settings_advanced") }) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppearanceScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Appearance") }, navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } }) }
    ) { padding -> LazyColumn(Modifier.padding(padding)) { 
        item { Text("Theme", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.Palette, "Theme", "Default Dynamic", onClick = {}) } 
        item { SwitchListItem(Icons.Filled.DarkMode, "Pure black dark mode", null, checked = false) {} }
        item { Text("Display", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.Language, "App language", "Default", onClick = {}) }
        item { SimpleListItem(Icons.Filled.Tablet, "Tablet UI", "Auto", onClick = {}) }
        item { Text("Date format", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.DateRange, "Date format", "Default (25/08/2026)", onClick = {}) }
        item { SwitchListItem(Icons.Filled.Update, "Relative timestamps", "\"Today\" instead of \"25/08/2026\"", checked = true) {} }
    } }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsLibraryScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Library") }, navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } }) }
    ) { padding -> LazyColumn(Modifier.padding(padding)) { 
        item { Text("Categories", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.Label, "Edit categories", "0 categories", onClick = {}) }
        item { SimpleListItem(Icons.Filled.Label, "Default category", "Always ask", onClick = {}) }
        item { SwitchListItem(Icons.Filled.Sort, "Per-category settings for sort", null, checked = false) {} }
        item { Text("Global update", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.Update, "Automatic updates", "Every 12 hours", onClick = {}) }
        item { SimpleListItem(Icons.Filled.Wifi, "Automatic updates device restrictions", "Restrictions: Only on Wi-Fi, When charging", onClick = {}) }
        item { SimpleListItem(Icons.Filled.Label, "Categories", "Include: All, Exclude: None", onClick = {}) }
        item { SwitchListItem(Icons.Filled.Image, "Check for new cover and details when updating", null, checked = true) {} }
        item { SimpleListItem(Icons.Filled.Update, "Smart update", "Skip entries with unread chapters...", onClick = {}) }
        item { Text("Behavior", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.Swipe, "Chapter on swipe to left", "Download", onClick = {}) }
        item { SimpleListItem(Icons.Filled.Swipe, "Chapter on swipe to right", "Mark as read", onClick = {}) }
    } }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsReaderScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Reader") }, navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } }) }
    ) { padding -> LazyColumn(Modifier.padding(padding)) { 
        item { SimpleListItem(Icons.Filled.ChromeReaderMode, "Default reading mode", "Long strip", onClick = {}) }
        item { SimpleListItem(Icons.Filled.Animation, "Double tap animation speed", "Normal", onClick = {}) }
        item { SwitchListItem(Icons.Filled.Visibility, "Show reading mode", "Briefly show current mode", checked = true) {} }
        item { Text("Display", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.ScreenRotation, "Default rotation", "Free", onClick = {}) }
        item { SimpleListItem(Icons.Filled.FormatColorFill, "Background color", "Black", onClick = {}) }
        item { SwitchListItem(Icons.Filled.Fullscreen, "Fullscreen", "Show content in cutout area", checked = true) {} }
        item { SwitchListItem(Icons.Filled.ScreenLockPortrait, "Keep screen on", null, checked = true) {} }
        item { SwitchListItem(Icons.Filled.Numbers, "Show page number", null, checked = true) {} }
    } }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsDownloadsScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Downloads") }, navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } }) }
    ) { padding -> LazyColumn(Modifier.padding(padding)) { 
        item { SwitchListItem(Icons.Filled.Wifi, "Only on Wi-Fi", null, checked = true) {} }
        item { SwitchListItem(Icons.Filled.Archive, "Save as CBZ archive", null, checked = false) {} }
        item { SwitchListItem(Icons.Filled.Image, "Split tall images", "Improves reader performance", checked = false) {} }
        item { SimpleListItem(Icons.Filled.Download, "Concurrent source downloads", "5", onClick = {}) }
        item { SimpleListItem(Icons.Filled.Download, "Concurrent page downloads", "5", onClick = {}) }
        item { Text("Delete chapters", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.Delete, "After manually marked as read", null, onClick = {}) }
        item { SimpleListItem(Icons.Filled.DeleteOutline, "After reading automatically delete", "Disabled", onClick = {}) }
        item { Text("Auto-download", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.Download, "Download new chapters", null, onClick = {}) }
        item { SimpleListItem(Icons.Filled.DownloadDone, "Download ahead", "Auto download while reading: Disabled", onClick = {}) }
    } }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsTrackingScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Tracking") }, navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } }) }
    ) { padding -> LazyColumn(Modifier.padding(padding)) { 
        item { SwitchListItem(Icons.Filled.Sync, "Update progress after reading", null, checked = true) {} }
        item { SimpleListItem(Icons.Filled.SyncAlt, "Update progress when marked as read", "Always", onClick = {}) }
        item { Text("Trackers", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.Sync, "MyAnimeList", null, onClick = {}) }
        item { SimpleListItem(Icons.Filled.Sync, "AniList", null, onClick = {}) }
        item { SimpleListItem(Icons.Filled.Sync, "Kitsu", null, onClick = {}) }
        item { SimpleListItem(Icons.Filled.Sync, "MangaUpdates", null, onClick = {}) }
        item { SimpleListItem(Icons.Filled.Sync, "Shikimori", null, onClick = {}) }
        item { SimpleListItem(Icons.Filled.Sync, "Bangumi", null, onClick = {}) }
    } }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsBrowseScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Browse") }, navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } }) }
    ) { padding -> LazyColumn(Modifier.padding(padding)) { 
        item { Text("Sources", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SwitchListItem(Icons.Filled.VisibilityOff, "Hide entries already in library", null, checked = false) {} }
        item { Text("Extension stores", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.Store, "Extension stores", "1 store", onClick = {}) }
        item { Text("NSFW (18+) sources", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SwitchListItem(Icons.Filled.Warning, "Show in sources and extensions lists", "Requires app restart", checked = false) {} }
    } }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataAndStorageScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Data and storage") }, navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } }) }
    ) { padding -> LazyColumn(Modifier.padding(padding)) { 
        item { SimpleListItem(Icons.Filled.Folder, "Storage location", "/storage/emulated/0/Download/Mihon", onClick = {}) }
        item { Text("Backup and restore", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.Backup, "Create backup", null, onClick = {}) }
        item { SimpleListItem(Icons.Filled.Restore, "Restore backup", null, onClick = {}) }
        item { SimpleListItem(Icons.Filled.Schedule, "Automatic backup frequency", "Daily", onClick = {}) }
        item { Text("Storage usage", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.Storage, "/storage/emulated/0", "Available: --- / Total: ---", onClick = {}) }
        item { SimpleListItem(Icons.Filled.Delete, "Clear chapter cache", "Used: 0 B", onClick = {}) }
        item { SwitchListItem(Icons.Filled.DeleteSweep, "Clear chapter cache on app launch", null, checked = false) {} }
    } }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecurityPrivacyScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Security and privacy") }, navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } }) }
    ) { padding -> LazyColumn(Modifier.padding(padding)) { 
        item { Text("Security", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SwitchListItem(Icons.Filled.Lock, "Require unlock", null, checked = false) {} }
        item { SimpleListItem(Icons.Filled.ScreenLockPortrait, "Lock when idle", "Always", onClick = {}) }
        item { SwitchListItem(Icons.Filled.NotificationsOff, "Hide notification content", null, checked = true) {} }
        item { SwitchListItem(Icons.Filled.Security, "Secure screen", "Incognito mode", checked = true) {} }
        item { Text("Analytics and Crash logs", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SwitchListItem(Icons.Filled.BugReport, "Send crash logs", "Send anonymized crash logs", checked = false) {} }
        item { SwitchListItem(Icons.Filled.Analytics, "Allow analytics", "Send anonymized usage data", checked = false) {} }
    } }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsAdvancedScreen(navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Advanced") }, navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back") } }) }
    ) { padding -> LazyColumn(Modifier.padding(padding)) { 
        item { SimpleListItem(Icons.Filled.Share, "Share crash logs", "Saves error logs to a file", onClick = {}) }
        item { SwitchListItem(Icons.Filled.DeveloperMode, "Verbose logging", "Print verbose logs", checked = false) {} }
        item { SimpleListItem(Icons.Filled.Info, "Debug info", null, onClick = {}) }
        item { SimpleListItem(Icons.Filled.Notifications, "Manage notifications", null, onClick = {}) }
        item { Text("Background activity", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.BatteryAlert, "Disable battery optimization", "Helps with background library updates", onClick = {}) }
        item { SimpleListItem(Icons.Filled.Warning, "Don't kill my app!", "Some manufacturers have additional app restrictions", onClick = {}) }
        item { Text("Data", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp)) }
        item { SimpleListItem(Icons.Filled.Refresh, "Reindex downloads", "Force app to recheck downloaded chapters", onClick = {}) }
        item { SimpleListItem(Icons.Filled.Delete, "Clear database", "Delete history for entries not saved", onClick = {}) }
    } }
}
