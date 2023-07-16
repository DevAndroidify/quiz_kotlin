package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class result : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val d=findViewById<TextView>(R.id.resulttext)
        val k=intent.getIntExtra(realquestions.correctanswer,0)
        val l=intent.getIntExtra(realquestions.totalquestion,0)

        val f=intent.getStringExtra(realquestions.username)
        d.text="Name: $f"
       val i=findViewById<TextView>(R.id.scoretext)
        i.text="the score is $k/$l"
        var a=findViewById<Button>(R.id.finish)
        a.setOnClickListener {
            finish()
        }
    }
}