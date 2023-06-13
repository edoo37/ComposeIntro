package com.yasinsenel.composeintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yasinsenel.composeintro.ui.theme.ComposeIntroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIntroTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

    @Composable
    fun MyApp(){
        var moneyCounterr by remember {
            mutableStateOf(0)
        }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF54637A),
        ) {
            Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "${moneyCounterr} TL",
                    style = TextStyle(
                        color = Color.White,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.ExtraBold)
                )
                Spacer(modifier = Modifier.height(30.dp))
                CreateCircle(moneyCounter =moneyCounterr){
                    moneyCounterr = it
                }
            }
        }
    }


    @Composable
    fun CreateCircle(moneyCounter : Int=0,updateMoneyCounter : (Int)->Unit){
        Card(modifier = Modifier
            .padding(12.dp)
            .size(45.dp)
            .clickable {
                updateMoneyCounter(moneyCounter+1)
            },
        shape = CircleShape,
        elevation = 8.dp,
        border = BorderStroke(2.dp,Color.Cyan)
        ) {
            Box(contentAlignment = Alignment.Center){
                Text(text = "Tap", modifier = Modifier)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeIntroTheme {
            MyApp()
        }
    }