package com.lumstep.app.example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.lumstep.flashlighter.FlashLighter

@Composable
fun Example1() {
    FlashLighter(radius = 200f) {
        Text(
            text =
            "Once upon a time, in a lush forest, there lived a curious little squirrel named Hazel. Hazel had a penchant for exploring, and one day, she stumbled upon a mysterious glade bathed in golden light. In the center stood a majestic, ancient oak tree.\n" +
                    "\n" +
                    "As Hazel approached, the oak tree's bark shimmered, revealing a kindly face carved into its trunk. It introduced itself as Old Oak, the guardian of the enchanted glade. Old Oak explained that the glade held a secret: a hidden garden of blooming roses that could grant a single heartfelt wish.\n" +
                    "\n" +
                    "Eager and with eyes sparkling, Hazel embarked on her quest, guided by Old Oak's wisdom. Along the way, she met a gentle rabbit named Thistle and a wise owl named Luna, both joining her on the journey. Together, they faced trials and overcame obstacles, strengthening their friendship with every challenge.\n" +
                    "\n" +
                    "Finally, after many adventures, they arrived at the heart of the garden. Surrounded by radiant roses, Hazel closed her eyes and made her wish with all her heart. Suddenly, the garden blossomed in a riot of colors, petals swirling around them like a kaleidoscope.\n" +
                    "\n" +
                    "Hazel's wish had come true, but instead of asking for something for herself, she wished for the forest to be forever filled with peace, love, and harmony. The glade sparkled with newfound magic, and the animals rejoiced.\n" +
                    "\n" +
                    "From that day on, Hazel, Thistle, and Luna became the cherished protectors of the enchanted glade, ensuring that its magic would touch the hearts of all who ventured there, and that the forest would forever be a place of wonder and dreams. And so, their tale became a whispered legend, passed down through generations, inspiring adventurers and dreamers alike.",
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .background(Color.White),
        )
    }
}

@Composable
@Preview
private fun Example1Preview(){
    Example1()
}