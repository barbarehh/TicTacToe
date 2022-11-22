package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var reset: Button
    private lateinit var nextround: Button
    private lateinit var name1: TextView
    private lateinit var name2: TextView
    private lateinit var qula1: TextView
    private lateinit var qula2: TextView
    private var score1 = 0
    private var score2 = 0
    private var winner = 0
    private var activeplayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondplayer = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        game()
        name1 = findViewById(R.id.name1)
        name2 = findViewById(R.id.name2)
        qula1 = findViewById(R.id.qula1)
        qula2 = findViewById(R.id.qula2)
        name1.text = intent?.extras?.getString("player 1")
        name2.text = intent?.extras?.getString("player 2")


    }

    private fun game() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        reset = findViewById(R.id.reset)
        nextround=findViewById(R.id.nextround)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        reset.setOnClickListener(this)
        nextround.setOnClickListener(this)

    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var ButtonNum = 0
            when (clickedView.id) {
                R.id.button1 -> ButtonNum = 1
                R.id.button2 -> ButtonNum = 2
                R.id.button3 -> ButtonNum = 3
                R.id.button4 -> ButtonNum = 4
                R.id.button5 -> ButtonNum = 5
                R.id.button6 -> ButtonNum = 6
                R.id.button7 -> ButtonNum = 7
                R.id.button8 -> ButtonNum = 8
                R.id.button9 -> ButtonNum = 9

            }
            if (ButtonNum != 0) {
                playgame(clickedView, ButtonNum)
            }



        }
    }

    private fun playgame(clickedView: Button, ButtonNum: Int) {
        if (activeplayer == 1) {
            clickedView.text = "X"
            clickedView.textSize= 39F
            activeplayer = 2
            firstPlayer.add(ButtonNum)
        } else if (activeplayer == 2) {
            clickedView.text = "O"
            clickedView.textSize= 39F
            activeplayer = 1
            secondplayer.add(ButtonNum)
        }
        clickedView.isEnabled=false
        reset()
        nextround()
        check()

    }
    private fun check() {
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winner = 1
        }
        if (secondplayer.contains(1) && secondplayer.contains(2) && secondplayer.contains(3)) {
            winner = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winner = 1
        }
        if (secondplayer.contains(4) && secondplayer.contains(5) && secondplayer.contains(6)) {
            winner = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winner = 1
        }
        if (secondplayer.contains(7) && secondplayer.contains(8) && secondplayer.contains(9)) {
            winner = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winner = 1
        }
        if (secondplayer.contains(1) && secondplayer.contains(4) && secondplayer.contains(7)) {
            winner = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winner = 1
        }
        if (secondplayer.contains(2) && secondplayer.contains(5) && secondplayer.contains(8)) {
            winner = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winner = 1
        }
        if (secondplayer.contains(3) && secondplayer.contains(6) && secondplayer.contains(9)) {
            winner = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winner = 1
        }
        if (secondplayer.contains(1) && secondplayer.contains(5) && secondplayer.contains(9)) {
            winner = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winner = 1
        }
        if (secondplayer.contains(3) && secondplayer.contains(5) && secondplayer.contains(7)) {
            winner = 2
        }
        if (firstPlayer.size + secondplayer.size == 9 && winner == 0) {
            winner=3
            Toast.makeText(this, "megobrobam gaimarjva,Frea <3 ", Toast.LENGTH_SHORT).show()
        }
        if (winner == 1) {
            Toast.makeText(this, "Msxlis limonati fershi midis gvino,mogebulia X  ", Toast.LENGTH_SHORT).show()
            score1 += 1

        }
        if (winner == 2) {
            Toast.makeText(this, "Batono nikoloz,mogebulia O...", Toast.LENGTH_SHORT).show()
            score2 += 1
        }
        if (winner==1 || winner==2){
            button1.isEnabled=false
            button2.isEnabled=false
            button3.isEnabled=false
            button4.isEnabled=false
            button5.isEnabled=false
            button6.isEnabled=false
            button7.isEnabled=false
            button8.isEnabled=false
            button9.isEnabled=false

        }
        qula1.text=score1.toString()
        qula2.text=score2.toString()
    }
    private fun reset() {
         reset.setOnClickListener {
             button1.text = ""
             button2.text = ""
             button3.text = ""
             button4.text = ""
             button5.text = ""
             button6.text = ""
             button7.text = ""
             button8.text = ""
             button9.text = ""
             button1.isEnabled = true
             button2.isEnabled = true
             button3.isEnabled = true
             button4.isEnabled = true
             button5.isEnabled = true
             button6.isEnabled = true
             button7.isEnabled = true
             button8.isEnabled = true
             button9.isEnabled = true
             activeplayer=1
             winner=0
             firstPlayer = ArrayList<Int>()
             secondplayer = ArrayList<Int>()
             score1=0
             score2=0
             qula1.text=score1.toString()
             qula2.text=score2.toString()

         }

    }
    private fun nextround() {
        nextround.setOnClickListener {
           if(winner==1||winner==2||winner==3){ button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true
            activeplayer=1
            winner=0
            firstPlayer = ArrayList<Int>()
            secondplayer = ArrayList<Int>()}
        }
    }
    }

