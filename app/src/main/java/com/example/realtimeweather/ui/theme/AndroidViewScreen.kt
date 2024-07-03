package com.example.realtimeweather.ui.theme

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.compose.foundation.layout.Column
//import androidx.compose.material.Button
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.material3.Button
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.platform.setContent
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.viewinterop.AndroidView
//import androidx.compose.ui.unit.dp
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyApp {
//                // Call your Composable that contains AndroidView
//                MyScreen()
//            }
//        }
//    }
//}
//
//@Composable
//fun MyScreen() {
//    // Example of using AndroidView to integrate XML layout
//    Column {
//        Text(text = "Welcome to Jetpack Compose", style = MaterialTheme.typography.h4)
//        AndroidView(
//            // Specify the view type
//            factory = { context ->
//                layoutInflater.inflate(R.layout.my_xml_layout, null)
//            },
//            // Update UI based on the view
//            update = { view ->
//                // Access and manipulate views inside the AndroidView
//                view.findViewById<Button>(R.id.button).setOnClickListener {
//                    // Handle button click
//                    // Example: Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
//                }
//            }
//        )
//    }
//}
