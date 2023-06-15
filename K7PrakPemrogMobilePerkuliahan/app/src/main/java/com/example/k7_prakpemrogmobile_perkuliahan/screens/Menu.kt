package com.example.k7_prakpemrogmobile_perkuliahan.screens

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import com.example.k7_prakpemrogmobile_perkuliahan.R

enum class Menu(
    @StringRes val title: Int,
    val icon: Int,
    val route: String
){
    HOME(R.string.home, R.drawable.baseline_house_24, "home"),
    DOSEN(R.string.dosen, R.drawable.baseline_how_to_reg_24, "dosen"),
    MAHASISWA(R.string.mahasiswa, R.drawable.baseline_people_alt_24, "mahasiswa"),
    MATKUL(R.string.matkul, R.drawable.baseline_menu_book_24, "matkul");

    companion object {
        fun getTabFromResource(@StringRes resource: Int) : Menu
        {
            return when (resource) {
                R.string.home -> HOME
                R.string.dosen -> DOSEN
                R.string.mahasiswa -> MAHASISWA
                R.string.matkul -> MATKUL
                else -> MATKUL
            }
        }
    }
}