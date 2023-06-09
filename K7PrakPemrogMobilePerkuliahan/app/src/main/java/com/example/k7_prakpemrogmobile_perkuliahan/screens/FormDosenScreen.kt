package com.example.k7_prakpemrogmobile_perkuliahan.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.k7_prakpemrogmobile_perkuliahan.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun FormDosenScreen(navController : NavHostController, id: String? = null, modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<DosenViewModel>()
    val nidn = remember { mutableStateOf(TextFieldValue("")) }
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val gelar_depan = remember { mutableStateOf(TextFieldValue("")) }
    val gelar_belakang = remember { mutableStateOf(TextFieldValue("")) }
    val scope = rememberCoroutineScope()
    val isLoading = remember { mutableStateOf(false) }
    val buttonLabel = if (isLoading.value) "Mohon tunggu..." else "Simpan"

//  menu dropdown
    var expanded by remember { mutableStateOf(false) }
    val list = listOf("S2", "S3")
    var pendidikan by remember { mutableStateOf("") }
    var textFiledSize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        OutlinedTextField(
            label = { Text(text = "NIDN", color = Color.White) },
            value = nidn.value,
            onValueChange = {
                if (it.text.length <= 12) nidn.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            placeholder = { Text(text = "Contoh '00123041'", color = Color.White) },
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White, // Warna garis saat fokus
                unfocusedBorderColor = Color.White, // Warna garis saat tidak fokus
                cursorColor = Color.White // Warna kursor
            )
        )
        OutlinedTextField(
            label = { Text(text = "Nama", color = Color.White) },
            value = nama.value,
            onValueChange = { nama.value = it },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Contoh 'Waditra Irma'", color = Color.White) },
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White, // Warna garis saat fokus
                unfocusedBorderColor = Color.White, // Warna garis saat tidak fokus
                cursorColor = Color.White // Warna kursor
            )
        )
        OutlinedTextField(
            label = { Text(text = "Gelar Depan", color = Color.White) },
            value = gelar_depan.value,
            onValueChange = { gelar_depan.value = it },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Contoh 'Drs.'", color = Color.White) },
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White, // Warna garis saat fokus
                unfocusedBorderColor = Color.White, // Warna garis saat tidak fokus
                cursorColor = Color.White // Warna kursor
            )
        )
        OutlinedTextField(
            label = { Text(text = "Gelar Belakang", color = Color.White) },
            value = gelar_belakang.value,
            onValueChange = { gelar_belakang.value = it },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Contoh 'M.Pd'", color = Color.White) },
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White, // Warna garis saat fokus
                unfocusedBorderColor = Color.White, // Warna garis saat tidak fokus
                cursorColor = Color.White // Warna kursor
            )
        )

        OutlinedTextField(
            value = pendidikan,
            onValueChange = { pendidikan = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .clickable {
                    expanded = !expanded
                }
                .onGloballyPositioned { coordinates ->
                    textFiledSize = coordinates.size.toSize()
                },
            readOnly = true,
            label = { Text(text = "Pendidikan", color = Color.White) },
            trailingIcon = {
                Icon(icon, "",Modifier.clickable {
                    expanded = !expanded
                })
            },
            placeholder = { Text(text = "S2 / S3", color = Color.White) },
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White, // Warna garis saat fokus
                unfocusedBorderColor = Color.White, // Warna garis saat tidak fokus
                cursorColor = Color.White // Warna kursor
            )
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(with(LocalDensity.current) { textFiledSize.width.toDp() }),
        ) {
            list.forEach { label ->
                DropdownMenuItem(
                    onClick = {
                        pendidikan = label
                        expanded = false
                    }
                ) {
                    Text(text = label, color = Color.White)
                }
            }
        }


//        OutlinedTextField(
//            label = { Text(text = "Pendidikan") },
//            value = pendidikan.value,
//            onValueChange = {
//                pendidikan.value = it
//            },
//            modifier = Modifier
//                .padding(4.dp)
//                .fillMaxWidth(),
//            keyboardOptions = KeyboardOptions(capitalization =
//            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
//            placeholder = { Text(text = "XXXXX") }
//        )

        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = LightGreen2,
            contentColor = DeepBlue
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = LightRed,
            contentColor = DeepBlue
        )
        Row (modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                if (id == null) {
                    scope.launch {
                        viewModel.insert(
                            nidn.value.text,
                            nama.value.text,
                            gelar_depan.value.text,
                            gelar_belakang.value.text,
                            pendidikan.toString()
                        )
                    }
                } else {
                    scope.launch {
                        viewModel.update(
                            id,
                            nidn.value.text,
                            nama.value.text,
                            gelar_depan.value.text,
                            gelar_belakang.value.text,
                            pendidikan.toString()
                        )
                    }
                }
                navController.navigate("dosen")
            }, colors = loginButtonColors) {
                Text(
                    text = buttonLabel,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                nidn.value = TextFieldValue("")
                nama.value = TextFieldValue("")
                gelar_depan.value = TextFieldValue("")
                gelar_belakang.value = TextFieldValue("")
                pendidikan = ""
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
    viewModel.isLoading.observe(LocalLifecycleOwner.current) {
        isLoading.value = it
    }

    if (id != null) {
        LaunchedEffect(scope) {
            viewModel.loadItem(id) { dosen ->
                dosen?.let {
                    nidn.value = TextFieldValue(dosen.nidn)
                    nama.value = TextFieldValue(dosen.nama)
                    gelar_depan.value = TextFieldValue(dosen.gelar_depan)
                    gelar_belakang.value = TextFieldValue(dosen.gelar_belakang)
                    pendidikan = dosen.pendidikan

                }
            }
        }
    }
}