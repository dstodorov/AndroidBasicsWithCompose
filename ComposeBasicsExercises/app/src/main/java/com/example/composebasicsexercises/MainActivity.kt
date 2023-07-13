package com.example.composebasicsexercises

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
//                    Article(
//                        title = stringResource(R.string.title),
//                        textOne = stringResource(R.string.text_one),
//                        textTwo = stringResource(R.string.text_two)
//                    )
//                    TaskManager(
//                        label = "All tasks completed",
//                        message = "Nice work"
//                    )
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun Article(
    title: String,
    textOne: String,
    textTwo: String,
    modifier: Modifier = Modifier
) {
    Column {
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

@Composable
fun TaskManager(
    label: String,
    message: String,
    modifier: Modifier = Modifier
) {
    Column(verticalArrangement = Arrangement.Center) {
        val image = painterResource(R.drawable.ic_task_completed)

        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier.align(alignment = Alignment.CenterHorizontally)
        )

        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 16.sp
        )

        Text(
            text = message,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ComposeQuadrantApp() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.first_title),
                description = stringResource(R.string.first_description),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.second_title),
                description = stringResource(R.string.second_description),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.third_title),
                description = stringResource(R.string.third_description),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.fourth_title),
                description = stringResource(R.string.fourth_description),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF686868)),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            modifier = modifier
                .padding(top = 256.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PersonInfo(
                fullName = "Dimitar Todorov",
                role = "Android Developer"
            )
        }

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(92.dp),
        ) {
            ContactDetails(
                phoneNumber = "+359897065558",
                socialMedia = "@SocialMediaAccount",
                email = "d.todorov.vn@gmail.com"
            )
        }

    }
}

@Composable
fun PersonInfo(
    fullName: String,
    role: String,
    modifier: Modifier = Modifier
) {
    val logo = painterResource(R.drawable.ic_launcher_foreground)

    Image(
        logo, modifier = modifier
            .width(100.dp)
            .height(100.dp), contentDescription = null
    )
    Text(
        text = fullName,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
    Text(text = role, fontWeight = FontWeight.Bold)
}

@Composable
fun ContactDetails(
    phoneNumber: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Row {
        Icon(
            Icons.Rounded.Phone,
            contentDescription = "Text",
            modifier = modifier.padding(end = 5.dp)
        )
        Text(text = phoneNumber, fontSize = 14.sp,color = Color.White)
    }
    Row {
        Icon(
            Icons.Rounded.Star,
            contentDescription = "Text",
            modifier = modifier.padding(end = 5.dp)
        )
        Text(text = socialMedia, fontSize = 14.sp,color = Color.White)
    }
    Row {
        Icon(
            Icons.Rounded.Email,
            contentDescription = "Text",
            modifier = modifier.padding(end = 5.dp)
        )
        Text(text = email, fontSize = 14.sp,color = Color.White)
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicsExercisesTheme {
//        Article(
//            title = stringResource(R.string.title),
//            textOne = stringResource(R.string.text_one),
//            textTwo = stringResource(R.string.text_two)
//        )

//        TaskManager(label = "All tasks completed", message = "Nice work")
//        ComposeQuadrantApp()

        BusinessCardApp()
    }
}