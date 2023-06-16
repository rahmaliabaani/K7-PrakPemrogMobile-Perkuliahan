package com.example.k7_prakpemrogmobile_perkuliahan.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.k7_prakpemrogmobile_perkuliahan.ui.theme.*
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import kotlinx.coroutines.launch
import java.time.format.DateTimeFormatter

@Composable
fun FormMahasiswaScreen(navController : NavHostController, id: String? = null, modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<MahasiswalViewModel>()
    val npm = remember { mutableStateOf(TextFieldValue("")) }
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val tanggal_lahir = remember { mutableStateOf(TextFieldValue("")) }
    val jenis_kelamin = remember { mutableStateOf("") }
    val tanggalDialogState = rememberMaterialDialogState()
    val scope = rememberCoroutineScope()
    val isLoading = remember { mutableStateOf(false) }
    val buttonLabel = if (isLoading.value) "Mohon tunggu..." else "Simpan"
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            label = { Text(text = "NPM", color = TextWhite) },
            value = npm.value,
            onValueChange = {
                if (it.text.length <= 12) npm.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType =
                KeyboardType.Decimal
            ),
            placeholder = { Text(text = "Contoh '202020020'" , color = TextWhite) },
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White, // Warna garis saat fokus
                unfocusedBorderColor = Color.White, // Warna garis saat tidak fokus
                cursorColor = Color.White // Warna kursor
            )
        )

        OutlinedTextField(
            label = { Text(text = "Nama", color = TextWhite) },
            value = nama.value,
            onValueChange = {
                nama.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                capitalization =
                KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text
            ),
            placeholder = { Text(text = "Contoh 'Rembulan'", color = TextWhite) },
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White, // Warna garis saat fokus
                unfocusedBorderColor = Color.White, // Warna garis saat tidak fokus
                cursorColor = Color.White // Warna kursor
            )
        )

        OutlinedTextField(
            label = { Text(text = "Tanggal Lahir", color = TextWhite) },
            value = tanggal_lahir.value,
            onValueChange = {
                tanggal_lahir.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .clickable {
                    tanggalDialogState.show()
                },
            placeholder = { Text(text = "yyyy-mm-dd", color = TextWhite) },
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White, // Warna garis saat fokus
                unfocusedBorderColor = Color.White, // Warna garis saat tidak fokus
                cursorColor = Color.White // Warna kursor
            ),
            enabled = false
        )


        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            RadioButton(
                selected = jenis_kelamin.value == "Laki-laki",
                onClick = { jenis_kelamin.value = "Laki-laki" },
                colors = RadioButtonDefaults.colors(
                    OrangeYellow1,
                    unselectedColor = Color.White
                )
            )
            Text(text = "Laki-laki", modifier = Modifier.padding(14.dp), color = TextWhite)
            RadioButton(
                selected = jenis_kelamin.value == "Perempuan",
                onClick = { jenis_kelamin.value = "Perempuan" },
                colors = RadioButtonDefaults.colors(
                    LightGreen1,
                    unselectedColor = Color.White
                )
            )
            Text(text = "Perempuan", modifier = Modifier.padding(14.dp), color = TextWhite)
        }


        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = LightGreen3,
            contentColor = DeepBlue
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = LightRed,
            contentColor = DeepBlue
        )
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Button(modifier = Modifier.weight(5f), onClick = {
                if (id == null) {
                    scope.launch {
                        viewModel.insert(
                            npm.value.text,
                            nama.value.text,
                            tanggal_lahir.value.text,
                            jenis_kelamin.value
                        )
                    }
                } else {
                    scope.launch {
                        viewModel.update(
                            id,
                            npm.value.text,
                            nama.value.text,
                            tanggal_lahir.value.text,
                            jenis_kelamin.value
                        )
                    }
                }
                navController.navigate("mahasiswa")
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
                npm.value = TextFieldValue("")
                nama.value = TextFieldValue("")
                tanggal_lahir.value = TextFieldValue("")
                jenis_kelamin.value = ""
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
            viewModel.loadItem(id) { mahasiswa ->
                mahasiswa?.let {
                    npm.value = TextFieldValue(mahasiswa.npm)
                    nama.value = TextFieldValue(mahasiswa.nama)
                    tanggal_lahir.value = TextFieldValue(mahasiswa.tanggal_lahir)
                    jenis_kelamin.value = mahasiswa.jenis_kelamin

                }
            }
        }
    }

    MaterialDialog(dialogState = tanggalDialogState, buttons = {
        positiveButton("OK")
        negativeButton("Batal")
    }) {
        datepicker { date ->
            tanggal_lahir.value = TextFieldValue(date.format(DateTimeFormatter.ISO_LOCAL_DATE))
        }
    }
}