/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        val puppiesList = listOf(
            Puppy("Puppy 0", R.drawable.puppy_0, "Details of Puppy 0 ....."),
            Puppy("Puppy 1", R.drawable.puppy_1, "Details of Puppy 1 ....."),
            Puppy("Puppy 2", R.drawable.puppy_2, "Details of Puppy 2 ....."),
            Puppy("Puppy 3", R.drawable.puppy_3, "Details of Puppy 3 ....."),
            Puppy("Puppy 4", R.drawable.puppy_4, "Details of Puppy 4 ....."),
            Puppy("Puppy 5", R.drawable.puppy_5, "Details of Puppy 5 ....."),
            Puppy("Puppy 6", R.drawable.puppy_6, "Details of Puppy 6 ....."),
            Puppy("Puppy 7", R.drawable.puppy_7, "Details of Puppy 7 ....."),
            Puppy("Puppy 8", R.drawable.puppy_8, "Details of Puppy 8 ....."),
            Puppy("Puppy 9", R.drawable.puppy_9, "Details of Puppy 9 .....")
        )
        PuppiesList(puppiesList)
    }
}

@Composable
fun PuppiesList(puppies: List<Puppy>) {
    LazyColumn {
        this.items(puppies) { puppy ->
            PuppiesListItem(puppy)
        }
    }
}

@Composable
fun PuppiesListItem(puppy: Puppy) {
    var context: Context? = null
    Row(
        modifier = Modifier.clickable {

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("PUPPY", puppy)
            context?.startActivity(intent)
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        context = LocalContext.current
        Text(puppy.name)
        Spacer(Modifier.size(20.dp))
        Image(
            painter = painterResource(id = puppy.resId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
