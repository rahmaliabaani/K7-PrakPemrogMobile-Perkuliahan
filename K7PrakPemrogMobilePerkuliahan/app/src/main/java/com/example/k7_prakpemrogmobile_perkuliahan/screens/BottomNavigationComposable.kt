package com.example.k7_prakpemrogmobile_perkuliahan.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.k7_prakpemrogmobile_perkuliahan.ui.theme.AquaBlue
import com.example.k7_prakpemrogmobile_perkuliahan.ui.theme.ButtonBlue
import com.example.k7_prakpemrogmobile_perkuliahan.ui.theme.DeepBlue

@Composable
fun BottomNavigationComposable(title: String, onClick: (Menu) -> Unit) {
    val tabs = Menu.values()
    val selectedTab = remember { mutableStateOf(title) } // Menyimpan tab yang terpilih

    BottomNavigation(elevation = 15.dp) {
        tabs.forEach { tab ->
            BottomNavigationItem(
                selected = tab.name == selectedTab.value,
                onClick = {
                    selectedTab.value = tab.name
                    onClick(tab)
                },
                icon = {
                    Icon(
                        painterResource(id = tab.icon),
                        modifier = Modifier
                            .height(32.dp)
                            .width(32.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                if (tab.name == selectedTab.value) ButtonBlue
                                else DeepBlue
                            ),
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = LocalContentColor.current,
                modifier = Modifier.background(DeepBlue).padding(8.dp)
            )
        }
    }
}

