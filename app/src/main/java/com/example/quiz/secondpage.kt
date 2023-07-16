package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

 class secondpage : AppCompatActivity() , View.OnClickListener{
    private var mcurrentposition:Int=1
    private var mquestionlist:ArrayList<questions>?=null
    private var mselectedno:Int=0
     private var mcorrectanswers:Int=4
     private  var musername:String?=null
    private var progressbar:ProgressBar?=null
    private var progressno:TextView?=null
    private var image:ImageView?=null
    private var tvquestion:TextView?=null
    private var optiona:TextView?=null
    private var optionb:TextView?=null
    private var optionc:TextView?=null
    private var optiond:TextView?=null
    private  var submi:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondpage)
        musername=intent.getStringExtra(realquestions.username)
        progressbar=findViewById(R.id.progressbar)
        progressno=findViewById(R.id.progressno)
        image=findViewById(R.id.images)
        tvquestion=findViewById(R.id.questions)
        optiona=findViewById(R.id.optiona)
        optionb=findViewById(R.id.optionb)
        optionc=findViewById(R.id.optionc)
        optiond=findViewById(R.id.optiond)
        submi=findViewById(R.id.submit)
         optiona?.setOnClickListener(this)
        optionb?.setOnClickListener(this)
        optionc?.setOnClickListener(this)
        optiond?.setOnClickListener(this)
        submi?.setOnClickListener(this)
        mquestionlist = realquestions.getquestions();
        setfunction()
        defaultoption()


    }

    private fun setfunction() {
        defaultoption()
        val question: questions = mquestionlist!![mcurrentposition - 1]
        progressbar?.progress = mcurrentposition;
        progressno?.text = "$mcurrentposition/${progressbar?.max}"
        tvquestion?.text = question.question
        image?.setImageResource(question.image)
        optiona?.text = question.optiona
        optionb?.text = question.optionb
        optionc?.text = question.optionc
        optiond?.text = question.optiond
        if(mcurrentposition==mquestionlist!!.size){
            submi?.text="Finish"
        }
        else{
            submi?.text="Submit"
        }

    }
    private fun defaultoption(){
        val options=ArrayList<TextView>()
        optiona?.let{
            options.add(0,it)

        }
        optionb?.let{
            options.add(1,it)
        }
        optionc?.let{
            options.add(2,it)
        }
        optiond?.let{
            options.add(3,it)
        }
        for(o in options){

            o.typeface= Typeface.DEFAULT
            o.background=ContextCompat.getDrawable(
                this,
                R.drawable.button
            )
        }
    }

    private fun selectedbutton(tv:TextView,selectno:Int){
        defaultoption()
        mselectedno=selectno
        tv.setTextColor(Color.parseColor("#FF6200EE"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.custombutton
        )

    }



    override fun onClick(View: View?) {
        when(View?.id){
            R.id.optiona->{
                optiona?.let{
                    selectedbutton(it,1)
                }
            }
            R.id.optionb->{
                optionb?.let{
                    selectedbutton(it,2)
                }
            }
            R.id.optionc->{
                optionc?.let{
                    selectedbutton(it,3)
                }
            }
            R.id.optiond->{
                optiond?.let{
                    selectedbutton(it,4)
                }
            }
            R.id.submit->{
                if(mselectedno==0){
                    mcurrentposition++;

                       if( mcurrentposition<=mquestionlist!!.size){

                            setfunction()
                        }else{
                            val e=Intent(this,result::class.java)
                            e.putExtra(realquestions.username,musername)
                        e.putExtra(realquestions.correctanswer,mcorrectanswers)
                        e.putExtra(realquestions.totalquestion,mquestionlist?.size)
                            startActivity(e)
                        finish()

                        }

                    }else{
                    val question = mquestionlist?.get(mcurrentposition - 1)
                    if (question!!.correctoption != (mselectedno-1)) {
                        answerview((mselectedno - 1), R.drawable.wronganser)
                        mcorrectanswers--
                    }
                    answerview(
                        question.correctoption,
                        R.drawable.correctanswer
                    )
                    if (mcurrentposition == mquestionlist!!.size) {
                        submi?.text = "Finish"

                    } else {
                        submi?.text = "Next question"
                    }
                    mselectedno=0;

                }

            }

        }

    }

    private fun answerview(answer:Int,drawableview:Int){
        when(answer){
            0->{
                optiona?.background=ContextCompat.getDrawable(
                    this,
                    drawableview
                )
            }
            1->{
                optionb?.background=ContextCompat.getDrawable(
                    this,
                    drawableview
                )
            }
            2->{
                optionc?.background=ContextCompat.getDrawable(
                    this,
                    drawableview
                )
            }
            3->{
                optiond?.background=ContextCompat.getDrawable(
                    this,
                    drawableview
                )
            }
        }
    }


}