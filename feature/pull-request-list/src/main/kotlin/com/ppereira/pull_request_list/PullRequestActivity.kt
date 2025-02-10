package com.ppereira.pull_request_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ppereira.pull_request_list.presentation.compose.PullRequestScreen
import com.ppereira.ui_core.theme.GitHubReposTheme

class PullRequestActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = intent.extras?.getString("REPOSITORY")
        val owner = intent.extras?.getString("OWNER")
        val ownerUrl = intent.extras?.getString("OWNER_URL")

        requireNotNull(repository)
        requireNotNull(ownerUrl)
        requireNotNull(owner)

        enableEdgeToEdge()
        setContent {
            GitHubReposTheme {
                PullRequestScreen(owner, ownerUrl, repository)
            }
        }
    }
}
