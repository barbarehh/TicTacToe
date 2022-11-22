package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EnterYourName : AppCompatActivity() {
    private lateinit var saxeli1: EditText
    private lateinit var saxeli2: EditText
    private lateinit var enter: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_your_name)
        saxeli1=findViewById(R.id.saxeli1)
        saxeli2=findViewById(R.id.saxeli2)
        enter=findViewById(R.id.enter)
        enter.setOnClickListener {
            val name1=saxeli1.text.toString()
            val name2=saxeli2.text.toString()
            if (saxeli1.text.toString()=="" || saxeli1.text.toString().length>10|| saxeli2.text.toString()== ""){
                Toast.makeText(this, "Please enter player names", Toast.LENGTH_SHORT).show()
            } else{
                val i= Intent(this,MainActivity::class.java)
                i.putExtra("player 1",name1)
                i.putExtra("player 2",name2)
                startActivity(i)
            }
        }
    }
}