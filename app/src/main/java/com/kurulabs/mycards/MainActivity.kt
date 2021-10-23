package com.kurulabs.mycards

import Action
import Card
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.demo.getDemoCards
import com.kurulabs.mycards.ui.theme.MyCardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCardsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DefaultPreview()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCardsTheme {
        val cards = remember {
            mutableStateOf(getDemoCards())
        }
        val actions = remember {
            mutableStateOf(cards.value[0].actions)
        }
        val rowState = rememberLazyListState()

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        ) {

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 8.dp)
                    .background(color = MaterialTheme.colors.background),
                state = rowState
            ) {
                items(
                    items = cards.value,
                    itemContent = { item ->
                        actions.value = item.actions
                        Card(modifier = Modifier.width(400.dp), cardData = item)
                    }
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth()
                    .padding(horizontal = 8.dp)
                    .background(color = MaterialTheme.colors.background)
            ) {
                items(
                    items = actions.value,
                    itemContent = { item ->
                        Action(modifier = Modifier, cardActionItem = item)
                    }
                )
            }
        }
    }
}