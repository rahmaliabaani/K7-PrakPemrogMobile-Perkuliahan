package com.example.k7_prakpemrogmobile_perkuliahan.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.k7_prakpemrogmobile_perkuliahan.R
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.example.k7_prakpemrogmobile_perkuliahan.ui.theme.*

@Composable
fun MainScreen() {
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val title = remember { mutableStateOf("") }
    val appBarHorizontalPadding = 4.dp
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = DeepBlue,
                elevation = 0.dp,
                modifier = Modifier.fillMaxWidth()
            )
            {
                //TopAppBar Content
                Box(
                    Modifier
                        .background(DeepBlue)
                        .height(32.dp)) {
                    Row(
                        Modifier
                            .fillMaxHeight()
                            .width(72.dp - appBarHorizontalPadding),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CompositionLocalProvider(
                            LocalContentAlpha provides
                                    ContentAlpha.high,
                        ) {
                            IconButton(
                                onClick = {
                                    scope.launch {
                                        scaffoldState.drawerState.open()
                                    }
                                },
                                enabled = true,
                            ) {
                                Icon(
                                    Icons.Filled.Menu, null,
                                    tint = Color.White
                                )
                            }
                        }
                    }
                    //  Title
                    Row(
                        Modifier.fillMaxSize(),
                        verticalAlignment =
                        Alignment.CenterVertically
                    ) {
                        ProvideTextStyle(
                            value =
                            MaterialTheme.typography.h6
                        ) {
                            CompositionLocalProvider(
                                LocalContentAlpha provides
                                        ContentAlpha.high,
                            ) {
                                Text(
                                    modifier =
                                    Modifier.fillMaxWidth(),
                                    textAlign =
                                    TextAlign.Center,
                                    color = Color.White,
                                    maxLines = 1,
                                    text = title.value
                                )
                            }
                        }
                    }
                }
            }
        },
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHost(it) { data ->
                Snackbar(
                    actionColor = Color.Green,
                    contentColor = Color.White,
                    snackbarData = data
                )
            }
        },
        drawerContent = {
            DrawerContent { route ->
                navController.navigate(route)
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }
        },
        bottomBar = {
            BottomNavigationComposable(title.value, onClick = { tab ->
                navController.navigate(tab.route)
            })
        },
    )

    { innerPadding ->
        Column(
            modifier = Modifier
                .background(BlueViolet3)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    title.value = "Perkuliahan Kelompok 7"

                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .verticalScroll(state = scrollState)
                    ) {
                        Text(
                            text = "Perkulaiahan",
                            style = MaterialTheme.typography.h5,
                            color = TextWhite,
                            modifier = Modifier.padding(10.dp)
                        )
                        Fitur(chips = listOf("Dosen", "Mahasiswa", "Matakuliah"))
                        harian()
                        Text(
                            text = "Anggota : ",
                            style = MaterialTheme.typography.h5,
                            color = TextWhite,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(10.dp)
                        )

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(10.dp)
                            ) {
                                HomeScreen(
                                    painter = painterResource(id = R.drawable.febrian),
                                    contentDescription = "Febrian",
                                    title = "Febrian Fauzan Rachman - 203040057"
                                )
                            }

                            Box(modifier = Modifier.padding(10.dp)) {
                                HomeScreen(
                                    painter = painterResource(id = R.drawable.rahma),
                                    contentDescription = "Rahma",
                                    title = "Rahmalia Nuursya'baani - 203040084"
                                )
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(10.dp)
                            ) {
                                HomeScreen(
                                    painter = painterResource(id = R.drawable.ulum),
                                    contentDescription = "Bahrul",
                                    title = "Bahrul Ulum - 203040089"
                                )
                            }

                            Box(modifier = Modifier.padding(10.dp)) {
                                HomeScreen(
                                    painter = painterResource(id = R.drawable.anam),
                                    contentDescription = "Khoerul",
                                    title = "Khoerul Anam - 203040096"
                                )
                            }

                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(10.dp)
                            ) {
                                HomeScreen(
                                    painter = painterResource(id = R.drawable.agung),
                                    contentDescription = "Agung",
                                    title = "Agung Septiana - 203040102"
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .background(DeepBlue)
                                .padding(30.dp)
                                .fillMaxWidth()
                        ) {

                        }
                    }
                }
//route dosen
                composable("dosen") {
                    title.value = "Dosen"
                    DosenScreen(
                        navController = navController,
                        snackbarHostState = scaffoldState.snackbarHostState, modifier =
                        Modifier.padding(innerPadding)
                    )
                }
                composable("tambah-dosen") {
                    title.value = "Tambah Dosen"
                    FormDosenScreen(
                        navController =
                        navController, modifier = Modifier.padding(innerPadding)
                    )
                }
                composable("edit-dosen/{id}",
                    listOf(
                        navArgument("id") {
                            type = NavType.StringType
                        }
                    )) { backStackEntry ->
                    title.value = "Edit Dosen"
                    val id =
                        backStackEntry.arguments?.getString("id")
                            ?: return@composable
                    FormDosenScreen(
                        navController = navController, id = id, modifier =
                        Modifier.padding(innerPadding)
                    )
                }
//route mahasiswa
                composable("mahasiswa") {
                    title.value = "Mahasiswa"
                    MahasiswaScreen(
                        navController = navController,
                        snackbarHostState = scaffoldState.snackbarHostState, modifier =
                        Modifier.padding(innerPadding)
                    )
                }
                composable("tambah-mahasiswa") {
                    title.value = "Tambah Mahasiswa"
                    FormMahasiswaScreen(
                        navController =
                        navController, modifier = Modifier.padding(innerPadding)
                    )
                }
                composable("edit-mahasiswa/{id}",
                    listOf(
                        navArgument("id") {
                            type = NavType.StringType
                        }
                    )) { backStackEntry ->
                    title.value = "Edit Mahasiswa"
                    val id =
                        backStackEntry.arguments?.getString("id")
                            ?: return@composable
                    FormMahasiswaScreen(
                        navController = navController, id = id, modifier =
                        Modifier.padding(innerPadding)
                    )
                }
//                route matkul
                composable("matkul") {
                    title.value = "Matakuliah"
                    MatkulScreen(
                        navController = navController,
                        snackbarHostState = scaffoldState.snackbarHostState, modifier =
                        Modifier.padding(innerPadding)
                    )
                }
                composable("tambah-matkul") {
                    title.value = "Tambah Matakuliah"
                    FormMatkulScreen(
                        navController =
                        navController, modifier = Modifier.padding(innerPadding)
                    )
                }
                composable("edit-matkul/{id}",
                    listOf(
                        navArgument("id") {
                            type = NavType.StringType
                        }
                    )) { backStackEntry ->
                    title.value = "Edit Matakuliah"
                    val id =
                        backStackEntry.arguments?.getString("id")
                            ?: return@composable
                    FormMatkulScreen(
                        navController = navController, id = id, modifier =
                        Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun harian(
    color: Color = LightRed,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Jadwal hari ini",
                style = MaterialTheme.typography.h6,
                color = TextWhite
            )
            Text(
                text = "Praktikum Pemograman Mobile",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }
    }
}
