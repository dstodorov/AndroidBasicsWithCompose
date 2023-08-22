package com.dstod.a30daysmotivation

import AuthorStyle
import QuoteStyle
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.ModifierLocal
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dstod.a30daysmotivation.data.Quote
import com.dstod.a30daysmotivation.data.quotes

@Composable
fun QuotesList(
    quotes: List<Quote>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(quotes) { quote ->
            QuoteCard(quote = quote, modifier = modifier.padding(8.dp))
        }
    }
}

@Composable
fun QuoteCard(quote: Quote, modifier: Modifier = Modifier) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
        ) {
            Row(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                QuoteTitle(dayNumberRes = quote.dayNumber, titleRes = quote.title)
                QuoteDetailsButton(expanded = expanded, onClick = { expanded = !expanded })

            }

            if (expanded)
                QuoteDetails(
                    quote = quote.quote,
                    author = quote.author,
                    modifier = Modifier.fillMaxWidth()
                )
        }
    }
}

@Composable
fun QuoteTitle(@StringRes dayNumberRes: Int, @StringRes titleRes: Int) {
    Text(text = stringResource(id = dayNumberRes), style = MaterialTheme.typography.labelLarge)
    Text(text = stringResource(id = titleRes), style = MaterialTheme.typography.bodyMedium)
}

@Composable
fun QuoteDetails(quote: Int, author: Int, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(start = 32.dp, end = 32.dp, top = 16.dp, bottom = 16.dp)
    ) {
        Text(text = "\"" + stringResource(id = quote) + "\"", style = QuoteStyle)
    }
    Column(
        horizontalAlignment = Alignment.End,
        modifier = modifier
            .padding(end = 8.dp, bottom = 8.dp, start = 8.dp)
    ) {
        Text(text = "by " + stringResource(id = author), style = AuthorStyle)
    }
}

@Composable
private fun QuoteDetailsButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
@Preview
fun QuoteListPreview() {
    QuotesList(quotes = quotes)
}