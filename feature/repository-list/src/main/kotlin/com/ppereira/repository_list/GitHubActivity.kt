package com.ppereira.repository_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ppereira.repository_list.presentation.compose.GitHubReposScreen
import com.ppereira.ui_core.theme.GitHubReposTheme

class GitHubActivity : ComponentActivity() {
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
