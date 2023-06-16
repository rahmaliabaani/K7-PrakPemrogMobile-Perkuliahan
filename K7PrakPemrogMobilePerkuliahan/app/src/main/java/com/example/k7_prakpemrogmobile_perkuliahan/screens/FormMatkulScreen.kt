package com.example.k7_prakpemrogmobile_perkuliahan.screens

import androidx.compose.foundation.layout.*
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
import kotlinx.coroutines.launch

@Composable
fun FormMatkulScreen(navController : NavHostController, id: String? = null, modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<MatkulViewModel>()
    val kode = remember { mutableStateOf(TextFieldValue("")) }
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val sks = remember { mutableStateOf(TextFieldValue("")) }
    val praktikum = remember { mutableStateOf("") }
    val deskripsi = remember { mutableStateOf(TextFieldValue("")) }
    val scope = rememberCoroutineScope()
    val isLoading = remember { mutableStateOf(false) }
    val buttonLabel = if (isLoading.value) "Mohon tunggu..." else "Simpan"
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        OutlinedTextField(
            label = { Text(text = "Kode", color = TextWhite) },
            value = kode.value,
            onValueChange = {
                if (it.text.length <= 12) kode.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Contoh 'IF231'", color = TextWhite) },
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White, // Warna garis saat fokus
                unfocusedBorderColor = Color.White, // Warna garis saat tidak fokus
                cursorColor = Color.White // Warna kursor
            ),
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
            placeholder = { Text(text = "Contoh 'Pemrograman Mobile'", color = TextWhite) },
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White, // Warna garis saat fokus
                unfocusedBorderColor = Color.White, // Warna garis saat tidak fokus
                cursorColor = Color.White // Warna kursor
            ),
        )
        OutlinedTextField(
            label = { Text(text = "Jumlah SKS", color = TextWhite) },
            value = sks.value,
            onValueChange = {
                if (it.text.length < 2) sks.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "Contoh '2'", color = TextWhite) },
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White, // Warna garis saat fokus
                unfocusedBorderColor = Color.White, // Warna garis saat tidak fokus
                cursorColor = Color.White // Warna kursor
            ),
        )

//        OutlinedTextField(
//            label = { Text(text = "Praktikum") },
//            value = praktikum.value,
//            onValueChange = {
//                praktikum.value = it
//            },
//            modifier = Modifier
//                .padding(4.dp)
//                .fillMaxWidth(),
//            placeholder = { Text(text = "IF231") }
//        )

        Spacer(modifier = Modifier.size(16.dp).padding(start = 4.dp))
        Text(text = "Praktikum", color = TextWhite, fontSize = 18.sp)
        Row (modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            RadioButton(
                selected = praktikum.value == "1",
                onClick = { praktikum.value = "1" },
                colors = RadioButtonDefaults.colors(OrangeYellow1, unselectedColor = Color.White),
            )
            Text(
                text = "Ya", color = TextWhite,

                modifier = Modifier.padding(14.dp)

            )
            RadioButton(
                selected = praktikum.value == "0",
                onClick = { praktikum.value = "0" },
                colors = RadioButtonDefaults.colors(LightRed, unselectedColor = Color.White)
            )
            Text(
                text = "Tidak", color = TextWhite,
                modifier = Modifier.padding(14.dp)
            )
        }

        OutlinedTextField(
            label = { Text(text = "Deskrpsi", color = TextWhite) },
            value = deskripsi.value,
            onValueChange = {
                deskripsi.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "Contoh 'Belajar membuat aplikasi mobile dengan android studio'", color = TextWhite) },
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White, // Warna garis saat fokus
                unfocusedBorderColor = Color.White, // Warna garis saat tidak fokus
                cursorColor = Color.White // Warna kursor
            ),
        )

        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = LightGreen3,
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
                            kode.value.text,
                            nama.value.text,
                            sks.value.text.toInt(),
                            praktikum.value.toInt(),
                            deskripsi.value.text
                        )
                    }
                } else {
                    scope.launch {
                        viewModel.update(
                            id,
                            kode.value.text,
                            nama.value.text,
                            sks.value.text.toInt(),
                            praktikum.value.toInt(),
                            deskripsi.value.text
                        )
                    }
                }
                navController.navigate("matkul")
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
                kode.value = TextFieldValue("")
                nama.value = TextFieldValue("")
                sks.value = TextFieldValue("")
                praktikum.value = ""
                deskripsi.value = TextFieldValue("")
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
            viewModel.loadItem(id) { matkul ->
                matkul?.let {
                    kode.value = TextFieldValue(matkul.kode)
                    nama.value = TextFieldValue(matkul.nama)
                    sks.value = TextFieldValue(matkul.sks.toString())
                    praktikum.value = matkul.praktikum.toString()
                    deskripsi.value = TextFieldValue(matkul.deskripsi)
                }
            }
        }
    }
}