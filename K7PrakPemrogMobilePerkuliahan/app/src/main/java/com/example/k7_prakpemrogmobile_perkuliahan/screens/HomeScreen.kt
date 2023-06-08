package com.example.k7_prakpemrogmobile_perkuliahan.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.k7_prakpemrogmobile_perkuliahan.R

@Composable @Preview
fun HomeScreen () {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Card(modifier = Modifier
            .size(130.dp),
            shape = RoundedCornerShape(25.dp),
            elevation = 45.dp
        ) {
            Image(painter = painterResource(id = R.drawable.agung), "",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            )
        }
        Column {
            Text("Agung Septiana\n203040102\n")
        }
        Card(modifier = Modifier
            .size(130.dp),
            shape = RoundedCornerShape(25.dp),
            elevation = 45.dp
        ){
            Image(painter = painterResource(id = R.drawable.ulum), "",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            )
        }
        Column {
            Text("Bahrul Ulum\n203040089\n")
        }
        Card(modifier = Modifier
            .size(130.dp),
            shape = RoundedCornerShape(25.dp),
            elevation = 45.dp
        ){
            Image(painter = painterResource(id = R.drawable.rahma), "",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            )
        }
        Column {
            Text("Rahmalia Nuursya'baani\n203040084\n")
        }
    }

    Row(modifier = Modifier
        .fillMaxSize(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Top
    ) {
        Column {
            Card(modifier = Modifier
                .size(130.dp),
                shape = RoundedCornerShape(25.dp),
                elevation = 45.dp
            ) {
                Image(painter = painterResource(id = R.drawable.anam), "",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                )
            }
            Column {
                Text("Khoerul Anam\n203040096\n")

            }
            Card(modifier = Modifier
                .size(130.dp),
                shape = RoundedCornerShape(25.dp),
                elevation = 45.dp
            ) {
                Image(painter = painterResource(id = R.drawable.febrian), "",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                )
            }
            Column {
                Text("Febrian Fauzan R\n203040057\n")
            }
        }
    }
}
