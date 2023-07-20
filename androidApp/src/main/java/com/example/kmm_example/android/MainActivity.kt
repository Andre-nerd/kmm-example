package com.example.kmm_example.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.kmm_example.Greeting
import com.example.kmm_example.ProgressSDK
import com.example.kmm_example.data_base.DatabaseDriverFactory
import com.example.kmmexample.database.ItemRecord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val progressSdk: ProgressSDK by lazy { ProgressSDK(DatabaseDriverFactory(this)) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch(Dispatchers.IO) {
            repeat(5) {
                progressSdk.addItem(
                    ItemRecord(
                        id = 0,
                        image = "some Image",
                        url = "some URL",
                        quantity = 1L
                    )
                )
            }
            val list = progressSdk.getAllLaunches()
            Log.d("HHHH","List = $list")
        }

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView(Greeting().greet())
                }
            }
        }
    }
}

@Composable
fun ShowBD(sdk : ProgressSDK){

}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
