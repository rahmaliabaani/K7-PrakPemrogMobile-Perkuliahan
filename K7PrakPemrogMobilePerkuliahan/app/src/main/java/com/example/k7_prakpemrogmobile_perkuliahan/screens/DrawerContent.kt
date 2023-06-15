package com.example.k7_prakpemrogmobile_perkuliahan.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.k7_prakpemrogmobile_perkuliahan.ui.theme.BlueViolet3
import com.example.k7_prakpemrogmobile_perkuliahan.ui.theme.LightGreen3
import com.example.k7_prakpemrogmobile_perkuliahan.ui.theme.TextWhite

@Composable
fun DrawerContent (onClick: (String) -> Unit){
    val menus = listOf(
        Menu.HOME,
        Menu.DOSEN,
        Menu.MAHASISWA,
        Menu.MATKUL
    )

    val listState = rememberLazyListState()

    Column(
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Perkuliahan",
                modifier = Modifier
                    .padding(8.dp)
                    .height(32.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }

        Divider(startIndent = 8.dp, thickness = 1.dp, color = Color.Black)

        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(0.dp)
        ) {
            items(menus) { menu ->
                Card(
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    backgroundColor = Color(0xff8f98fd),
                    contentColor = Color.White
                ) {
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                onClick(menu.route)
                            }
                    ) {
                        Icon(
                            painter = painterResource(id = menu.icon),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            stringResource(id = menu.title),
                            modifier = Modifier
                                .height(32.dp)
                                .padding(start = 8.dp),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}