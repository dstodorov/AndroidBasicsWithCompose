package com.example.composebasicsexercises

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasicsexercises.ui.theme.ComposeBasicsExercisesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsExercisesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Article(
                        title = stringResource(R.string.title),
                        textOne = stringResource(R.string.text_one),
                        textTwo = stringResource(R.string.text_two)
                    )
                }
            }
        }
    }
}

@Composable
fun Article(title: String,
            textOne: String,
            textTwo: String,
            modifier: Modifier = Modifier
) {
    Column{
        val image = painterResource(R.drawable.bg_compose_background)
        Image(painter = image, contentDescription = null)
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = textOne,
            modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = textTwo,
            modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify

        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicsExercisesTheme {
        Article(
            title = stringResource(R.string.title),
            textOne = stringResource(R.string.text_one),
            textTwo = stringResource(R.string.text_two)
        )
    }
}