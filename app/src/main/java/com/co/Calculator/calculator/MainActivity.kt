package com.co.Calculator.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

import kotlin.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_clear.setOnClickListener{
            input.text = ""
            output.text = ""
        }

        button_bracketi.setOnClickListener{
            input.text = agregarInput("(")
        }

        button_bracketd.setOnClickListener{
            input.text = agregarInput(")")
        }


        button_uno.setOnClickListener{
            input.text = agregarInput("1")
        }

        button_dos.setOnClickListener{
            input.text = agregarInput("2")
        }

        button_tres.setOnClickListener{
            input.text = agregarInput("3")
        }

        button_cuatro.setOnClickListener{
            input.text = agregarInput("4")
        }

        button_cinco.setOnClickListener{
            input.text = agregarInput("5")
        }

        button_seis.setOnClickListener{
            input.text = agregarInput("6")
        }

        button_siete.setOnClickListener{
            input.text = agregarInput("7")
        }
        button_ocho.setOnClickListener{
            input.text = agregarInput("8")
        }


        button_nueve.setOnClickListener{
            input.text = agregarInput("9")
        }

        button_cero.setOnClickListener{
            input.text = agregarInput("0")
        }


        button_division.setOnClickListener{
            input.text = agregarInput("÷")
        }

        button_por.setOnClickListener{
            input.text = agregarInput("×")
        }

        button_mas.setOnClickListener{
            input.text = agregarInput("+")
        }

        button_menos.setOnClickListener {
            input.text = agregarInput("-")
        }

        button_punto.setOnClickListener{
            input.text = agregarInput(".")
        }

        button_igual.setOnClickListener{
            resultado()
        }
        
        }
    private fun agregarInput(buttonValue: String): String{
        return "${input.text}$buttonValue"
    }

    private fun getInput():String{
        var expression = input.text.replace(Regex ("÷"), "/" )
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun resultado(){
        try {
                val expression = getInput()
            val result = Expression(expression).calculate()
            if (result.isNaN()){
                //Show error message
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))

        }

    }

}