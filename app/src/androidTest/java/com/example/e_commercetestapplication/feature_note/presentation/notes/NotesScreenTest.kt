package com.example.e_commercetestapplication.feature_note.presentation.notes

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.core.app.ApplicationProvider
import com.example.e_commercetestapplication.di.AppModule
import com.example.e_commercetestapplication.presentation.AllScreenRote
import com.example.e_commercetestapplication.presentation.theme.ECommerceTestApplicationTheme
import com.example.e_commercetestapplication.presentation.ui.MainActivity
import com.example.e_commercetestapplication.presentation.ui.ScreenRoute
import com.example.e_commercetestapplication.presentation.ui.screen.CartScreen
import com.example.e_commercetestapplication.presentation.ui.screen.HomePage
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class NotesScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @ExperimentalAnimationApi
    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            val navController = rememberNavController()
            ECommerceTestApplicationTheme {
                NavHost(
                    navController = navController,
                    startDestination = AllScreenRote.Home.route
                ) {
                    composable(route = AllScreenRote.Home.route) {
                        HomePage(navController,viewModel = mockk())
                    }
                }
            }
        }
    }

    @Test
    fun clickToggleOrderSection_isVisible() {
        composeRule.onNodeWithTag("HomeTest").assertDoesNotExist()
        composeRule.onNodeWithTag("HomeTest").assertIsDisplayed()
    }
}