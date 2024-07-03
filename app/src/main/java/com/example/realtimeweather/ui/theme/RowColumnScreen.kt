package com.example.realtimeweather.ui.theme

import android.util.Log
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RowColumnScreen(){
//    Text(text = "heloo")
    var scrollState= rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .horizontalScroll(scrollState)
    ) {
        for (i in 1..100) {
            Log.i("rendor","Item $i")
            Text(text = "Item $i",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                fontSize = 22.sp
            );

        }
        for (i in 1..5) {
            Text(text = "welcome",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                textAlign = TextAlign.Center,
                fontSize = 40.sp
            );
        }
//        Row{
//            for (i in 1..50) {
//                Text(text = "Item $i");
//            }
//            for (i in 1..50) {
//                Text(text = "welcome");
//            }
//        }
    }
}
@Composable
fun LazyRowColumnScreen(){
    var screenScroll = rememberScrollState()
    var myList = listOf<String>("a","b","c","d")
    // LazyColumn only rendors and load data that is on screen
//    LazyColumn(
//        content ={
//            items(100, itemContent = {
//                TextItem(name = "Item $it")
//            })
//        }
//    )
    LazyColumn(
        content = {
            itemsIndexed(myList, itemContent = {
                index, item: String -> TextItem(name = "Item $item")
            })
        }
    )
//    LazyColumn {
//        item { TextItem(name = "Item") }
//    }
}

@Composable
fun LazyColumnScreen(){
    var screenScroll = rememberScrollState()
    LazyColumn(
        content ={
            items(100, itemContent = {
                Log.i("lazycolumn","Item $it")
                TextItem(name = "Item $it")
            })
        }
    )
//    LazyColumn(
//        content = {
//            itemsIndexed(myList, itemContent = {
//                    index, item: String -> TextItem(name = "Item $item")
//            })
//        }
//    )
//    LazyColumn {
//        item { TextItem(name = "Item") }
//    }
}




@Composable
fun TextItem(name: String){
    Log.i("rendor",name)
    Text(text = name,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        fontSize = 20.sp
    )
}
@Composable
fun LazyColumnGrid(){
    val numbers = (0..20).toList()
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(10){
            Text(text = "Number $it", fontSize = 20.sp)
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
////                Text(text = "Number $it")
//            }
        }

    }

//    LazyVerticalGrid(
//        columns = GridCells.Fixed(4)
//    ) {
//        items(numbers.size) {
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Text(text = "Number")
//                Text(text = "  $it",)
//            }
//        }
//    }
//    val numbers = (0..20).toList()
//
//    LazyVerticalGrid(
//        columns = GridCells.Adaptive(minSize = 64.dp)
//    ) {
//        items(numbers) {
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Text(text = "Number")
//                Text(text = "  $it",)
//            }
//        }
//    }
}
