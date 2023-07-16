package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button=findViewById<Button>(R.id.submit)
        val edit=findViewById<EditText>(R.id.text)
        button.setOnClickListener(){ view->
            if(edit.text.isEmpty()){
                Toast.makeText(this,"please enter your name",Toast.LENGTH_LONG).show()
            }else{
                var a=Intent(this,secondpage::class.java)
                a.putExtra(realquestions.username,edit.text.toString())
                startActivity(a)



                finish()
            }


        }
    }
}