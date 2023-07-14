package com.dstod.lemonade

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dstod.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()

            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun LemonadeImageWithText(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {

    var currentButtonNumber by remember { mutableStateOf(1) }
    var currentButtonImageString by remember { mutableStateOf(R.string.select_lemon) }

    var numberOfSqueezesNeeded by remember { mutableStateOf((2..4).random()) }
    var squeezes by remember { mutableStateOf(1) }

    val imageResource = when (currentButtonNumber) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Yellow,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = Color.Yellow
                )
            )
        }
    ) {
            innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        if (currentButtonNumber == 1) {
                            currentButtonNumber = 2
                            currentButtonImageString = R.string.squeeze_lemon
                        } else if (currentButtonNumber == 2) {
                            if (squeezes < numberOfSqueezesNeeded) squeezes++
                            else {
                                currentButtonNumber = 3
                                currentButtonImageString = R.string.drink_lemonade
                            }
                        } else if (currentButtonNumber == 3) {
                            currentButtonNumber = 4
                            currentButtonImageString = R.string.start_again
                        } else {
                            currentButtonNumber = 1
                            currentButtonImageString = R.string.select_lemon
                            numberOfSqueezesNeeded = (2..4).random()
                            squeezes = 1
                        }
                    },
                    shape = RoundedCornerShape(15),
                    modifier = Modifier
                        .height(260.dp)
                        .width(260.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(161, 201, 177)
                    )
                ) {
                    Image(
                        painter = painterResource(id = imageResource),
                        contentDescription = stringResource(id = currentButtonImageString),
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    stringResource(id = currentButtonImageString),
                    fontSize = 18.sp
                )
            }
        }
    }



}

@Composable
@Preview
fun LemonadeApp() {
    LemonadeImageWithText()
}