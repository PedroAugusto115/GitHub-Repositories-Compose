package com.ppereira.feature_repos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ppereira.feature_repos.presentation.compose.GitHubReposScreen
import com.ppereira.feature_repos.ui.theme.GitHubReposTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GitHubReposTheme {
                GitHubReposScreen()
            }
        }
    }
}
