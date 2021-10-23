package com.kurulabs.mycards

import Action
import ActionTitle
import Card
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kurulabs.mycards.ui.theme.MyCardsTheme

class MainActivity : ComponentActivity() {

    private val viewModel: CardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCardsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    DefaultPreview(viewModel, this)
                }
            }
        }
    }
}

@Composable
fun DefaultPreview(viewModel: CardViewModel, context: Context) {
    MyCardsTheme {
        val cards = viewModel.cards
        val rowState = rememberLazyListState()

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
        ) {

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 8.dp)
                    .background(color = MaterialTheme.colors.background),
                state = rowState,
            ) {
                items(
                    items = cards.value,
                    itemContent = { item ->
                        Card(modifier = Modifier.width(400.dp), cardData = item)
                    }
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth()
                    .padding(horizontal = 8.dp)
                    .background(color = MaterialTheme.colors.background),
            ) {
                val actions = cards.value[rowState.firstVisibleItemIndex].actions
                actions.groupBy { it.groupTitle.index }.forEach { (_, actions) ->
                    item {
                        ActionTitle(modifier = Modifier, actions.first().groupTitle)
                    }
                    items(actions) { action ->
                        Action(cardAction = action) {
                            Toast.makeText(context, action.name, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}