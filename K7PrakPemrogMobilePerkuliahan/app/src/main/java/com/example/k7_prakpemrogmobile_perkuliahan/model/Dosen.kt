package com.example.k7_prakpemrogmobile_perkuliahan.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Dosen (
    @PrimaryKey val id: String,
    val nidn: String,
    val nama: String,
    val gelarDepan: String,
    val gelarBelakang: String,
    val pendidikan: Pendidikan
)

enum class Pendidikan (val pendidikan: String) {
    s2("S2"),
    s3("S3")
}