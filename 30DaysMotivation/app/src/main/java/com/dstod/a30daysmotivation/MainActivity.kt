package com.dstod.a30daysmotivation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dstod.a30daysmotivation.data.Quote
import com.dstod.a30daysmotivation.data.quotes
import com.dstod.a30daysmotivation.ui.theme._30DaysMotivationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysMotivationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MotivationApp()
                }
            }
        }
    }
}

@Composable
fun MotivationApp(modifier: Modifier = Modifier) {

    val quotes = quotes
    
    QuotesList(quotes = quotes)

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _30DaysMotivationTheme {

    }
}