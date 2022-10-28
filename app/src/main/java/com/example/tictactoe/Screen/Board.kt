package com.example.tictactoe.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun board() {


    val s1 = remember {
        mutableStateOf("")
    }
    val s2 = remember {
        mutableStateOf("")
    }
    val s3 = remember {
        mutableStateOf("")
    }
    val s4 = remember {
        mutableStateOf("")
    }
    val s5 = remember {
        mutableStateOf("")
    }
    val s6 = remember {
        mutableStateOf("")
    }
    val s7 = remember {
        mutableStateOf("")
    }
    val s8 = remember {
        mutableStateOf("")
    }
    val s9 = remember {
        mutableStateOf("")
    }

    val player = remember {
        mutableStateOf("X")
    }
    
    val winner = remember {
        mutableStateOf("")
    }
    val p1 = remember {
        mutableStateOf(0)
    }
    val p2 = remember {
        mutableStateOf(0)
    }

    val visi = remember {
        mutableStateOf(false)
    }

    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(), color = Color(0xF85B71E4)) {



        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

            Card(modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 10.dp)
                .fillMaxWidth()
                .height(80.dp), shape = RoundedCornerShape(corner = CornerSize(12.dp)), backgroundColor = Color.White
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Tic Tac Toe",
                        fontSize = 45.sp,
                        fontFamily = FontFamily.Cursive,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(50.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
            Card(modifier = Modifier
                .padding(5.dp)
                .height(50.dp)
                .width(140.dp), shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            backgroundColor = Color(0xF8BA87F3)
            ) {
                Column(modifier = Modifier.fillMaxWidth(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(text = "Player 1(X) : ${p1.value}", fontSize = 17.sp)
                }
            }
            Card(modifier = Modifier
                .padding(5.dp)
                .height(50.dp)
                .width(90.dp), shape = RoundedCornerShape(corner = CornerSize(15.dp))) {
                Column(modifier = Modifier.fillMaxWidth(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(text = "${player.value} plays ", fontSize = 20.sp)
                }
            }
            Card(modifier = Modifier
                .padding(5.dp)
                .height(50.dp)
                .width(140.dp), shape = RoundedCornerShape(corner = CornerSize(15.dp)),backgroundColor = Color(0xF8BA87F3)) {
                Column(modifier = Modifier.fillMaxWidth(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(text = "Player 2 (O): ${p2.value}", fontSize = 17.sp)
                }
            }
        }
            if(winner.value != "") {
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .height(50.dp)
                        .width(120.dp), shape = RoundedCornerShape(corner = CornerSize(15.dp))
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Text(
                            text = "${winner.value} ",
                            fontSize = 20.sp,
                            color = Color.White,
                            fontFamily = FontFamily.Cursive
                        )


                    }
                }
            }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .height(310.dp)
                    .width(310.dp),
                shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                elevation = 10.dp,
                backgroundColor = Color(0x833061F3)
            ) {

                boardbase()
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                        .height(300.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .width(300.dp)
                            .height(100.dp),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        card(s1, player, winner) {
                            if ((s1.value != "" && s1.value == s2.value && s1.value == s3.value) || (s3.value != "" && s3.value == s5.value && s3.value == s7.value) || (s4.value != "" && s4.value == s5.value && s4.value == s6.value) ||
                                (s7.value != "" && s7.value == s8.value && s8.value == s9.value) || (s1.value != "" && s1.value == s4.value && s4.value == s7.value) ||
                                (s5.value != "" && s5.value == s2.value && s5.value == s8.value) || (s3.value != "" && s3.value == s6.value && s3.value == s9.value) || (s1.value != "" && s1.value == s5.value && s5.value == s9.value)
                            ) {
                                winner.value = "${s1.value} wins"
                                if (s1.value == "X") {
                                    p1.value++
                                } else {
                                    p2.value++
                                }
                                visi.value = true
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""

                            }
                            if(s1.value != "" && s2.value!="" && s3.value != "" && s4.value!="" && s5.value != "" && s6.value!="" && s7.value != "" && s8.value!="" && s9.value!="") {
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                                winner.value = "Draw"
                            }

                        }
                        card(s2, player, winner) {
                            if ((s1.value != "" && s1.value == s2.value && s1.value == s3.value) || (s3.value != "" && s3.value == s5.value && s3.value == s7.value) || (s4.value != "" && s4.value == s5.value && s4.value == s6.value) ||
                                (s7.value != "" && s7.value == s8.value && s8.value == s9.value) || (s1.value != "" && s1.value == s4.value && s4.value == s7.value) ||
                                (s5.value != "" && s5.value == s2.value && s5.value == s8.value) || (s3.value != "" && s3.value == s6.value && s3.value == s9.value) || (s1.value != "" && s1.value == s5.value && s5.value == s9.value)
                            ) {
                                winner.value = "${s2.value} wins"
                                if (s2.value == "X") {
                                    p1.value++
                                } else {
                                    p2.value++
                                }
                                visi.value = true
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                            }
                            if(s1.value != "" && s2.value!="" && s3.value != "" && s4.value!="" && s5.value != "" && s6.value!="" && s7.value != "" && s8.value!="" && s9.value!="") {
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                                winner.value = "Draw"
                            }

                        }

                        card(s3, player, winner) {
                            if ((s1.value != "" && s1.value == s2.value && s1.value == s3.value) || (s3.value != "" && s3.value == s5.value && s3.value == s7.value) || (s4.value != "" && s4.value == s5.value && s4.value == s6.value) ||
                                (s7.value != "" && s7.value == s8.value && s8.value == s9.value) || (s1.value != "" && s1.value == s4.value && s4.value == s7.value) ||
                                (s5.value != "" && s5.value == s2.value && s5.value == s8.value) || (s3.value != "" && s3.value == s6.value && s3.value == s9.value) || (s1.value != "" && s1.value == s5.value && s5.value == s9.value)
                            ) {
                                winner.value = "${s3.value} wins"
                                if (s3.value == "X") {
                                    p1.value++
                                } else {
                                    p2.value++
                                }
                                visi.value = true
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                            }
                            if(s1.value != "" && s2.value!="" && s3.value != "" && s4.value!="" && s5.value != "" && s6.value!="" && s7.value != "" && s8.value!="" && s9.value!="") {
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                                winner.value = "Draw"
                            }

                        }
                    }
                    Row(
                        modifier = Modifier
                            .width(300.dp)
                            .height(100.dp),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        card(s4, player, winner) {
                            if ((s1.value != "" && s1.value == s2.value && s1.value == s3.value) || (s3.value != "" && s3.value == s5.value && s3.value == s7.value) || (s4.value != "" && s4.value == s5.value && s4.value == s6.value) ||
                                (s7.value != "" && s7.value == s8.value && s8.value == s9.value) || (s1.value != "" && s1.value == s4.value && s4.value == s7.value) ||
                                (s5.value != "" && s5.value == s2.value && s5.value == s8.value) || (s3.value != "" && s3.value == s6.value && s3.value == s9.value) || (s1.value != "" && s1.value == s5.value && s5.value == s9.value)
                            ) {
                                winner.value = "${s4.value} wins"
                                if (s4.value == "X") {
                                    p1.value++
                                } else {
                                    p2.value++
                                }
                                visi.value = true
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""

                            }
                            if(s1.value != "" && s2.value!="" && s3.value != "" && s4.value!="" && s5.value != "" && s6.value!="" && s7.value != "" && s8.value!="" && s9.value!="") {
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                                winner.value = "Draw"
                            }

                        }
                        card(s5, player, winner) {
                            if ((s1.value != "" && s1.value == s2.value && s1.value == s3.value) || (s3.value != "" && s3.value == s5.value && s3.value == s7.value) || (s4.value != "" && s4.value == s5.value && s4.value == s6.value) ||
                                (s7.value != "" && s7.value == s8.value && s8.value == s9.value) || (s1.value != "" && s1.value == s4.value && s4.value == s7.value) ||
                                (s5.value != "" && s5.value == s2.value && s5.value == s8.value) || (s3.value != "" && s3.value == s6.value && s3.value == s9.value) || (s1.value != "" && s1.value == s5.value && s5.value == s9.value)
                            ) {
                                winner.value = "${s5.value} wins"
                                if (s5.value == "X") {
                                    p1.value++
                                } else {
                                    p2.value++
                                }
                                visi.value = true
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                            }
                            if(s1.value != "" && s2.value!="" && s3.value != "" && s4.value!="" && s5.value != "" && s6.value!="" && s7.value != "" && s8.value!="" && s9.value!="") {
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                                winner.value = "Draw"
                            }

                        }

                        card(s6, player, winner) {
                            if ((s1.value != "" && s1.value == s2.value && s1.value == s3.value) || (s3.value != "" && s3.value == s5.value && s3.value == s7.value) || (s4.value != "" && s4.value == s5.value && s4.value == s6.value) ||
                                (s7.value != "" && s7.value == s8.value && s8.value == s9.value) || (s1.value != "" && s1.value == s4.value && s4.value == s7.value) ||
                                (s5.value != "" && s5.value == s2.value && s5.value == s8.value) || (s3.value != "" && s3.value == s6.value && s3.value == s9.value) || (s1.value != "" && s1.value == s5.value && s5.value == s9.value)
                            ) {
                                winner.value = "${s6.value} wins"
                                if (s6.value == "X") {
                                    p1.value++
                                } else {
                                    p2.value++
                                }
                                visi.value = true
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                            }
                            if(s1.value != "" && s2.value!="" && s3.value != "" && s4.value!="" && s5.value != "" && s6.value!="" && s7.value != "" && s8.value!="" && s9.value!="") {
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                                winner.value = "Draw"
                            }

                        }


                    }
                    Row(
                        modifier = Modifier
                            .width(300.dp)
                            .height(100.dp),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        card(s7, player, winner) {
                            if ((s1.value != "" && s1.value == s2.value && s1.value == s3.value) || (s3.value != "" && s3.value == s5.value && s3.value == s7.value) || (s4.value != "" && s4.value == s5.value && s4.value == s6.value) ||
                                (s7.value != "" && s7.value == s8.value && s8.value == s9.value) || (s1.value != "" && s1.value == s4.value && s4.value == s7.value) ||
                                (s5.value != "" && s5.value == s2.value && s5.value == s8.value) || (s3.value != "" && s3.value == s6.value && s3.value == s9.value) || (s1.value != "" && s1.value == s5.value && s5.value == s9.value)
                            ) {
                                winner.value = "${s7.value} wins"
                                if (s7.value == "X") {
                                    p1.value++
                                } else {
                                    p2.value++
                                }
                                visi.value = true
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                            }
                            if(s1.value != "" && s2.value!="" && s3.value != "" && s4.value!="" && s5.value != "" && s6.value!="" && s7.value != "" && s8.value!="" && s9.value!="") {
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                                winner.value = "Draw"
                            }

                        }

                        card(s8, player, winner) {
                            if ((s1.value != "" && s1.value == s2.value && s1.value == s3.value) || (s3.value != "" && s3.value == s5.value && s3.value == s7.value) || (s4.value != "" && s4.value == s5.value && s4.value == s6.value) ||
                                (s7.value != "" && s7.value == s8.value && s8.value == s9.value) || (s1.value != "" && s1.value == s4.value && s4.value == s7.value) ||
                                (s5.value != "" && s5.value == s2.value && s5.value == s8.value) || (s3.value != "" && s3.value == s6.value && s3.value == s9.value) || (s1.value != "" && s1.value == s5.value && s5.value == s9.value)
                            ) {
                                winner.value = "${s8.value} wins"
                                if (s8.value == "X") {
                                    p1.value++
                                } else {
                                    p2.value++
                                }
                                visi.value = true
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                            }
                            if(s1.value != "" && s2.value!="" && s3.value != "" && s4.value!="" && s5.value != "" && s6.value!="" && s7.value != "" && s8.value!="" && s9.value!="") {
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                                winner.value = "Draw"
                            }

                        }

                        card(s9,player,winner) {
                            if ((s1.value != "" && s1.value == s2.value && s1.value == s3.value) || (s3.value != "" && s3.value == s5.value && s3.value == s7.value) || (s4.value != "" && s4.value == s5.value && s4.value == s6.value) ||
                                (s7.value != "" && s7.value == s8.value && s8.value == s9.value) || (s1.value != "" && s1.value == s4.value && s4.value == s7.value) ||
                                (s5.value != "" && s5.value == s2.value && s5.value == s8.value) || (s3.value != "" && s3.value == s6.value && s3.value == s9.value) || (s1.value != "" && s1.value == s5.value && s5.value == s9.value)
                            ) {
                                winner.value = "${s9.value} wins"
                                if (s9.value == "X") {
                                    p1.value++
                                } else {
                                    p2.value++
                                }
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""

                                visi.value = true

                            }
                            if(s1.value != "" && s2.value!="" && s3.value != "" && s4.value!="" && s5.value != "" && s6.value!="" && s7.value != "" && s8.value!="" && s9.value!="") {
                                s1.value = ""
                                s2.value = ""
                                s3.value = ""
                                s4.value = ""
                                s5.value = ""
                                s6.value = ""
                                s7.value = ""
                                s8.value = ""
                                s9.value = ""
                                winner.value = "Draw"
                            }

                        }

                    }
                }

            }

            Spacer(modifier = Modifier.height(60.dp))

            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .height(60.dp)
                    .width(180.dp)
                ,
                shape = RoundedCornerShape(CornerSize(15.dp)),
                backgroundColor = Color.White,
                elevation = 10.dp
            ) {


                    Button(onClick = {
                        s1.value=""
                        s2.value=""
                        s3.value=""
                        s4.value=""
                        s5.value=""
                        s6.value=""
                        s7.value=""
                        s8.value=""
                        s9.value=""
                        p1.value=0
                        p2.value=0
                    }) {
                        Text(text = "New Game", fontSize = 17.sp, color = Color.Black)
                    }
            }
        }

    }
    }
}


@Composable
fun card(
    square: MutableState<String>,
    player: MutableState<String>,
    winner: MutableState<String>,
    validate: () -> Unit
) {
    val state = remember {
        mutableStateOf(0)
    }
    Card(modifier = Modifier
        .height(100.dp)
        .width(100.dp)
        .clickable {
            if (state.value == 0) {
                square.value = player.value
                state.value = 1

            }
            if (player.value == "X") {
                player.value = "O"
            } else {
                player.value = "X"
            }
            winner.value = ""
            validate.invoke()
            state.value = 0


        } , shape = RectangleShape , backgroundColor = Color.Transparent) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = square.value, modifier = Modifier, fontSize = 50.sp , color = Color.Black)

        }
    }
}


@Composable
fun boardbase(){
    Canvas(modifier = Modifier
        .padding(8.dp)
        .size(300.dp)
        .background(Color.White)
        .clip(shape = RoundedCornerShape(corner = CornerSize(15.dp)))){
        drawLine(
            color = Color.Black,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*1/3 , y = 0f),
            end = Offset(x = size.width*1/3 , y = size.height)
        )
        drawLine(
            color = Color.Black,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*2/3 , y = 0f),
            end = Offset(x = size.width*2/3 , y = size.height)
        )
        drawLine(
            color = Color.Black,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f , y = size.height*1/3),
            end = Offset(x = size.width , y = size.height*1/3)
        )
        drawLine(
            color = Color.Black,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f , y = size.height*2/3),
            end = Offset(x = size.width , y = size.height*2/3)
        )


    }
}

