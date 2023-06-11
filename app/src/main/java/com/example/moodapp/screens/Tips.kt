package com.example.moodapp.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.moodapp.R
import com.example.moodapp.ui.theme.Pinky


@Composable
fun Tips() {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Pinky),
        contentAlignment = Alignment.Center
    ) {
        /*Text(
            text = "Arnela",
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )*/




        val drawableImages = listOf(
            /*R.drawable.change_your_state,
            R.drawable.change_your_focus,
            R.drawable.be_grateful,
                    R.drawable.get_support,
                    R.drawable.meditate,
                    R.drawable.use_viualization
*/
            R.drawable.slika1,
            R.drawable.slika2,
            R.drawable.slika3,
            R.drawable.slika4,
            R.drawable.slika5,
            R.drawable.slika6,
            R.drawable.slika7


        )
        var randomImageId by remember { mutableStateOf(drawableImages[0]) }

        val context = LocalContext.current

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = randomImageId),
                contentDescription = null,
                modifier = Modifier
                    .size(450.dp)
                    .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)),
               // contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                randomImageId = getRandomImageId(drawableImages, context)
            }) {
                Text(text = "Click for tip")
            }
        }

    }


    }
private fun getRandomImageId(imageList: List<Int>, context: Context): Int {
    val randomIndex = (0 until imageList.size).random()
    return imageList[randomIndex]}

@Composable
@Preview

fun ProfileScreenPreview() {
    Tips()
}


