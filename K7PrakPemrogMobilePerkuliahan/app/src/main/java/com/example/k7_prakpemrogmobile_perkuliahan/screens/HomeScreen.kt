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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.k7_prakpemrogmobile_perkuliahan.R

@Composable @Preview
fun HomeScreen () {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column {
            Card(modifier = Modifier
                .size(170.dp)
                .padding(15.dp),
                shape = RoundedCornerShape(25.dp),
                elevation = 45.dp
            ) {
                Image(painter = painterResource(id = R.drawable.agung), "",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                )
            }
            Text("Agung Septiana\n203040102\n", Modifier.padding(start = 15.dp, end =  15.dp, bottom =  15.dp))
        }
        Column {
            Card(modifier = Modifier
                .size(170.dp)
                .padding(15.dp),
                shape = RoundedCornerShape(25.dp),
                elevation = 45.dp
            ){
                Image(painter = painterResource(id = R.drawable.ulum), "",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                )
            }

            Text("Bahrul Ulum\n203040089\n", Modifier.padding(start = 15.dp, end =  15.dp, bottom =  15.dp))
        }
        Column {
            Card(modifier = Modifier
                .size(170.dp)
                .padding(15.dp),
                shape = RoundedCornerShape(25.dp),
                elevation = 45.dp
            ){
                Image(painter = painterResource(id = R.drawable.rahma), "",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                )
            }
            Text("Rahmalia Nuursya'baani\n203040084\n", Modifier.padding(start = 15.dp, end =  15.dp, bottom =  15.dp))
        }
    }

    Row(modifier = Modifier
        .fillMaxSize(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Top
    ) {
        Column {
            Column {
                Card(modifier = Modifier
                    .size(170.dp)
                    .padding(15.dp),
                    shape = RoundedCornerShape(25.dp),
                    elevation = 45.dp
                ) {
                    Image(painter = painterResource(id = R.drawable.anam), "",
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                    )
                }
                Text("Khoerul Anam\n203040096\n", Modifier.padding(start = 15.dp, end =  15.dp, bottom =  15.dp))

            }

            Column {
                Card(modifier = Modifier
                    .size(170.dp)
                    .padding(15.dp),
                    shape = RoundedCornerShape(25.dp),
                    elevation = 45.dp
                ) {
                    Image(painter = painterResource(id = R.drawable.febrian), "",
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                    )
                }
                Text("Febrian Fauzan R\n203040057\n", Modifier.padding(start = 15.dp, end =  15.dp, bottom =  15.dp))
            }

            Column {
                Card(modifier = Modifier
                    .size(170.dp)
                    .padding(15.dp),
                    shape = RoundedCornerShape(25.dp),
                    elevation = 45.dp
                ){
                    Image(painter = painterResource(id = R.drawable.logo), "",
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                    )
                }
                Text("K7 Perkuliahan", Modifier.padding(start = 15.dp, end =  15.dp, bottom =  15.dp))
            }
        }
    }
}
