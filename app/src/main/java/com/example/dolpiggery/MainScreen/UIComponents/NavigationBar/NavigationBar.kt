package com.example.dolpiggery.MainScreen.UIComponents.NavigationBar

import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dolpiggery.MainScreen.NavigationCurrentPosition.NavigationCurrentPosition
import com.example.dolpiggery.MainScreen.DataClass.NavBarItem.NavBarItem
import com.example.dolpiggery.MainScreen.NavRoutes.AddSched
import com.example.dolpiggery.MainScreen.NavRoutes.Cubicle
import com.example.dolpiggery.MainScreen.NavRoutes.Environment
import com.example.dolpiggery.MainScreen.NavRoutes.Scheduling
import com.example.dolpiggery.MainScreen.NavRoutes.Settings
import com.example.dolpiggery.R
import com.example.dolpiggery.ui.theme.Cerulean5
import com.example.dolpiggery.ui.theme.LightBlue30
import com.example.dolpiggery.ui.theme.PacificCyan5
import com.example.dolpiggery.ui.theme.Snow60

fun createNavBarItemsList(): List<NavBarItem> {
    // Create a list of nav buttons
    val items = listOf(
        NavBarItem(
            title = "Cubicles",
            route = Cubicle,
            selectedIcon = R.drawable.filled_pig,
            unselectedIcon = R.drawable.outlined_pig,
            hasNews = false
        ),
        NavBarItem(
            title = "Environment",
            route = Environment,
            selectedIcon = R.drawable.filled_monitor,
            unselectedIcon = R.drawable.outlined_monitor,
            hasNews = false
        ),
        NavBarItem(
            title = "Settings",
            route = Settings,
            selectedIcon = R.drawable.filled_settings,
            unselectedIcon = R.drawable.outlined_settings,
            hasNews = false
        )
    )

    return items
}

@Composable
fun CreateNavBar(navController: NavHostController) {
    /* rememberSaveable is used to save the state even
        after configuration like screen rotation*/
    var selectedItemIndexed by rememberSaveable { mutableStateOf(0) }

    NavigationBar(
        modifier = Modifier
            .clip(RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp)),
        containerColor = PacificCyan5,
        contentColor = Snow60,
    ) {
        createNavBarItemsList().forEachIndexed { index, item -> // Iterate the list created
            NavigationBarItem(
                // return true if the selected item is equals to index
                selected = selectedItemIndexed == index,
                onClick = {
                    /* if an item is clicked reassign the selectedItemIndexed
                with the index of the clicked item */
                    selectedItemIndexed = index
                    navController.popBackStack()
                    navController.navigate(item.route) //navigate to the route assign to the clicked item
                },
                label = { Text(text = item.title) }, // assign the text of the label to the title of the item
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBlue30,
                    selectedTextColor = LightBlue30,
                    indicatorColor = Cerulean5,
                ),
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(
                                /*if the index of the item is equals to selected item, display the Selected Icon.
                             else display the selected icon */
                                id = if (index == selectedItemIndexed) item.selectedIcon else item.unselectedIcon
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTopBar(navController: NavHostController) {
    val currentNavLoc = NavigationCurrentPosition.currentNavPosition.value

    TopAppBar(
        title = {
            Text(
                text = "Swine Shine",
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = PacificCyan5
        ),
        actions = {
            if (currentNavLoc == Scheduling.toString()) {
                IconButton(
                    onClick = { navController.navigate(AddSched())},
                    colors = IconButtonDefaults.iconButtonColors(contentColor = Snow60)
                ) {
                    Icon(imageVector = Icons.Outlined.Add, contentDescription = null)
                }
            }
        }
    )
}

