package com.abhinay.cleanarchitecturenoteapp.feature_note.presentation.notes

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abhinay.cleanarchitecturenoteapp.core.util.TestTags
import com.abhinay.cleanarchitecturenoteapp.di.AppModule
import com.abhinay.cleanarchitecturenoteapp.feature_note.presentation.MainActivity
import com.abhinay.cleanarchitecturenoteapp.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.abhinay.cleanarchitecturenoteapp.feature_note.presentation.util.Screen
import com.abhinay.cleanarchitecturenoteapp.ui.theme.CleanArchitectureNoteAppTheme
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/**
 * Created by Abhinay on 04/02/25.
 * 
 *
 *
 */
@HiltAndroidApp
@UninstallModules(AppModule::class)
class NotesEndToEndTest {

    @get: Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get: Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            CleanArchitectureNoteAppTheme {

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.NotesScreen.route
                ) {
                    composable(route = Screen.NotesScreen.route) {
                        NotesScreen(navController = navController)
                    }

                    composable(
                        route = Screen.AddEditNoteScreen.route +
                                "?noteId={noteId}&noteColor={noteColor}",
                        arguments = listOf(
                            navArgument(
                                name = "noteId"
                            ) {
                                type = NavType.IntType
                                defaultValue = -1
                            },
                            navArgument(
                                name = "noteColor"
                            ) {
                                type = NavType.IntType
                                defaultValue = -1
                            },
                        )
                    ) {
                        val color = it.arguments?.getInt("noteColor") ?: -1
                        AddEditNoteScreen(
                            navController = navController,
                            noteColor = color
                        )

                    }

                }

            }
        }
    }

    @Test
    fun saveNewNote_editAfterwards() {
        //click on FAB to get to add note screen
        composeRule.onNodeWithContentDescription("Add").performClick()

        //Enter texts in content and title text fields
        composeRule
            .onNodeWithTag(TestTags.TITLE_TEXT_FIELD)
            .performTextInput("test-title")
        composeRule
            .onNodeWithTag(TestTags.CONTENT_TEXT_FIELD)
            .performTextInput("test-content")


        //save the new
        composeRule.onNodeWithContentDescription("Save").performClick()

        //make sure there is a note in the list with our title and content
        composeRule.onNodeWithText("test-title").assertIsDisplayed()
        //click on a note to edit it
        composeRule.onNodeWithText("test-title").performClick()

        //make sure title and content text fields contain note title and content
        composeRule
            .onNodeWithTag(TestTags.TITLE_TEXT_FIELD)
            .assertTextEquals("test-title")
        composeRule
            .onNodeWithTag(TestTags.CONTENT_TEXT_FIELD)
            .assertTextEquals("test-content")
        //add the text 2 to the title text field
        composeRule
            .onNodeWithTag(TestTags.TITLE_TEXT_FIELD)
            .performTextInput("2")
        //update the note
        composeRule
            .onNodeWithContentDescription("Save").performClick()

        //make sure update is applied to the list
        composeRule
            .onNodeWithText("text-title2").assertIsDisplayed()

    }

    @Test
    fun saveNewNote_orderByTitleDescending() {
        for(i in 1..3) {
            //click on FAB to get to add note screen
            composeRule.onNodeWithContentDescription("Add").performClick()

            //Enter texts in content and title text fields
            composeRule
                .onNodeWithTag(TestTags.TITLE_TEXT_FIELD)
                .performTextInput(i.toString())
            composeRule
                .onNodeWithTag(TestTags.CONTENT_TEXT_FIELD)
                .performTextInput(i.toString())


            //save the new
            composeRule.onNodeWithContentDescription("Save").performClick()
        }
        composeRule.onNodeWithText("1").assertIsDisplayed()
        composeRule.onNodeWithText("2").assertIsDisplayed()
        composeRule.onNodeWithText("3").assertIsDisplayed()

        composeRule
            .onNodeWithContentDescription("Sort")
            .performClick()

        composeRule
            .onNodeWithContentDescription("Title")
            .performClick()

        composeRule
            .onNodeWithContentDescription("Descending")
            .performClick()

        composeRule
            .onAllNodesWithTag(TestTags.NOTE_ITEM)[0]
            .assertTextContains("3")
        composeRule
            .onAllNodesWithTag(TestTags.NOTE_ITEM)[1]
            .assertTextContains("2")
        composeRule
            .onAllNodesWithTag(TestTags.NOTE_ITEM)[2]
            .assertTextContains("1")
    }

}