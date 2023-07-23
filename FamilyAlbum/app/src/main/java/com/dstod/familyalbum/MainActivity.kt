package com.dstod.familyalbum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.dstod.familyalbum.ui.theme.FamilyAlbumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FamilyAlbumTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FamilyAlbumLayout()
                }
            }
        }
    }
}

@Composable
fun FamilyAlbumLayout() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {

        var image by remember { mutableStateOf(0) }
        var name by remember { mutableStateOf("") }
        var age by remember { mutableStateOf(0) }

        var current by remember { mutableStateOf(1) }


        when (current) {
            1 -> {
                image = R.drawable.zara
                name = stringResource(R.string.svetozara_todorova)
                age = 4
            }

            2 -> {
                image = R.drawable.dimitar
                name = stringResource(R.string.dimitar_todorov)
                age = 36
            }

            3 -> {
                image = R.drawable.tea
                name = stringResource(R.string.tea_todorova)
                age = 3
            }

            4 -> {
                image = R.drawable.dobrina
                name = stringResource(R.string.dobrina_dimova)
                age = 39
            }

            else -> {
                image = R.drawable.zara
                name = stringResource(R.string.svetozara_todorova)
                age = 4
            }
        }

        ImageLayoutRow(
            imageId = image,
            modifier = Modifier.padding(top = 64.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
        )

        Spacer(modifier = Modifier.weight(1f))
        FamilyMemberInfo(
            name = name,
            age = age,
            modifier = Modifier
                .padding(16.dp)
                .shadow(2.dp)
        )
        MemberNavigationButtons(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            onButtonClick = {
                if (it == 1) {
                    if (current != 1) current--
                } else {
                    if (current < 4) current++
                }
            }
        )
    }

}

@Composable
fun ImageLayoutRow(
    modifier: Modifier = Modifier,
    @DrawableRes imageId: Int = 0,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(350.dp)
            .shadow(2.dp)
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null
        )
    }
}

@Composable
fun FamilyMemberInfo(
    name: String,
    age: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = age.toString(),
                fontSize = 24.sp,
            )
        }
    }
}

@Composable
fun MemberNavigationButtons(
    modifier: Modifier = Modifier,
    onButtonClick: (buttonNumber: Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Button(
            onClick = { onButtonClick(1) }, modifier = Modifier
                .padding(start = 0.dp)
                .width(150.dp)
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = { onButtonClick(2) }, modifier = Modifier
                .padding(start = 0.dp)
                .width(150.dp)
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FamilyAlbumTheme {
        FamilyAlbumLayout()
    }
}