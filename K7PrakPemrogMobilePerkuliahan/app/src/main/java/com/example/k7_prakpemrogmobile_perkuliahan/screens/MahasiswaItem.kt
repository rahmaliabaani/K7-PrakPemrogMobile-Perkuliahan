package com.example.k7_prakpemrogmobile_perkuliahan.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.message
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import com.vanpra.composematerialdialogs.title
import com.example.k7_prakpemrogmobile_perkuliahan.model.Mahasiswa

@Composable
fun MahasiswaItem(item: Mahasiswa, navController: NavHostController, onDelete: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val subMenus = listOf("Edit", "Delete")
    val confirmationDialogState = rememberMaterialDialogState()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("edit-mahasiswa/" + item.id)
            }
            .clickable { expanded = true }
    ) {
        Row(modifier = Modifier
            .padding(15.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "NPM", fontWeight = FontWeight.Bold)
                Text(text = "Nama", fontWeight = FontWeight.Bold)
                Text(text = "Tanggal Lahir", fontWeight = FontWeight.Bold)
                Text(text = "Jenis Kelamin", fontWeight = FontWeight.Bold)

            }

            Column(modifier = Modifier.weight(1f)) {
                Text(item.npm, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = item.nama, fontSize = 16.sp,
                    fontWeight = FontWeight.Bold)
                Text(item.tanggal_lahir, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(item.jenis_kelamin, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
            ) {
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .clickable {
                            expanded = true
                        }
                ) {
                    Icon(
                        Icons.Default.MoreVert,
                        modifier = Modifier
                            .size(40.dp)
                            .clickable { expanded = true },
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }

        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(x = (-66).dp, y = (-10).dp)
        ) {
            subMenus.forEachIndexed { _, s ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    when (s) {
                        "Edit" -> {
                            navController.navigate("edit-mahasiswa/${item.id}")
                        }
                        "Delete" -> {
                            confirmationDialogState.show()
                        }
                    }
                }) {
                    Text(text = s)
                }
            }
        }
    }
    Divider(modifier = Modifier.fillMaxWidth())
    MaterialDialog(dialogState = confirmationDialogState,
        buttons = {
            positiveButton("Ya", onClick = {
                onDelete(item.id)
            })
            negativeButton("Tidak")
        }) {
        title(text = "Konfirmasi")
        message(text = "Apakah anda yakin ingin menghapus data?")
    }
}