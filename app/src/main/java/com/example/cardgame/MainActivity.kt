package com.example.cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

lateinit var card1 : ImageView
lateinit var card2 : ImageView

lateinit var player1 : TextView
lateinit var player2 : TextView

lateinit var cardgame : TextView

lateinit var playButton : Button

lateinit var random: kotlin.random.Random

var plc1 = 0
var plc2 = 0
var cardsArray = intArrayOf(
    R.drawable.hearts2,
    R.drawable.hearts3,
    R.drawable.hearts4,
    R.drawable.hearts5,
    R.drawable.hearts6,
    R.drawable.hearts7,
    R.drawable.hearts8,
    R.drawable.hearts9,
    R.drawable.hearts10,
    R.drawable.hearts12,
    R.drawable.hearts13,
    R.drawable.hearts14,
    R.drawable.hearts15
)



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        random = kotlin.random.Random
        card1 = findViewById(R.id.card1)
        card2 = findViewById(R.id.card2)

        card1.setImageResource(R.drawable.card_back)
        card2.setImageResource(R.drawable.card_back)

        player1 = findViewById(R.id.pl1)
        player2 = findViewById(R.id.pl2)

        cardgame = findViewById(R.id.text)
        cardgame.visibility = View.INVISIBLE

        playButton = findViewById(R.id.button)

        playButton.setOnClickListener {
            cardgame.visibility = View.INVISIBLE

            val cardplayer1 = random.nextInt(cardsArray.size)
            val cardplayer2 = random.nextInt(cardsArray.size)

            setCardImage(cardplayer1, card1)
            setCardImage(cardplayer2, card2)

            if(cardplayer1 > cardplayer2)
            {
                plc1++
                player1.text = " Player 1 : $plc1"
            }else if(cardplayer2 > cardplayer1)
            {
                plc2++
                player2.text  = " Player 2 : $plc2"
            }else
            {
                cardgame.visibility = View.INVISIBLE
            }

        }
    }
    private fun setCardImage(number : Int,image : ImageView)
    {
    image.setImageResource(cardsArray[number])
    }
}