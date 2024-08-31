package com.example.dolpiggery.MainScreen.UIComponents.NavigationBar

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dolpiggery.MainScreen.DataClass.NavBarItem.NavBarItem
import com.example.dolpiggery.MainScreen.NavRoutes.Cubicle
import com.example.dolpiggery.MainScreen.NavRoutes.Environment
import com.example.dolpiggery.MainScreen.NavRoutes.Settings
import com.example.dolpiggery.R
import com.example.dolpiggery.ui.theme.Cerulean5
import com.example.dolpiggery.ui.theme.LightBlue30
import com.example.dolpiggery.ui.theme.PacificCyan5
import com.example.dolpiggery.ui.theme.Snow60

fun createNavBarItemsList(): List<NavBarItem> {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNavBar(navController: NavHostController) {
    var selectedItemIndexed by rememberSaveable { mutableStateOf(0) }

    NavigationBar(
        modifier = Modifier
            .clip(RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp)),
        containerColor = PacificCyan5,
        contentColor = Snow60,
    ) {
        createNavBarItemsList().forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndexed == index,
                onClick = {
                    selectedItemIndexed = index
                    navController.popBackStack()
                    navController.navigate(item.route)
                },
                label = { Text(text = item.title) },
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