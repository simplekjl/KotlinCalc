package share.dev.com.kotlincalc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var oldNumber: String = ""
    var isNewOperation: Boolean = true
    var op: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberClicked(view: View) {
        if (isNewOperation) {
            entryValues.setText("")
        }
        isNewOperation = false
        val buClicked = view as Button
        var value: String = entryValues.text.toString()
        when (buClicked.id) {
            bu0.id -> {
                value += "0"
            }
            bu1.id -> {
                value += "1"
            }
            bu2.id -> {
                value += "2"
            }
            bu3.id -> {
                value += "3"
            }
            bu4.id -> {
                value += "4"
            }
            bu5.id -> {
                value += "5"
            }
            bu6.id -> {
                value += "6"
            }
            bu7.id -> {
                value += "7"
            }
            bu8.id -> {
                value += "8"
            }
            bu9.id -> {
                value += "9"
            }
            buAC.id -> {
                value= "0"
            }

            buSign.id -> {
                //TODO: fix using string builder
                if (value.contains("-")) {
                    value = value.replace("-", "+")
                } else if (value.contains("+")) {
                    value = value.replace("+", "-")
                } else {
                    value = "-" + value
                }
            }
            buDot.id -> {
                if (!value.contains(".")) {
                    value += "."
                }

            }

        }
        entryValues.setText(value)
    }

    fun buOpSelected(view: View) {
        var value: String = entryValues.text.toString()
        var buClicked = view as Button
        when (buClicked.id) {
            buMult.id -> {
                op = "*"
            }
            buMinus.id -> {
                op = "-"
            }
            buPlus.id -> {
                op = "+"
            }
            buPercentage.id -> {
                op = "%"
            }
        }
        oldNumber = entryValues.text.toString()
        isNewOperation = true

    }

    fun buResult(view: View) {
        var newNumber = entryValues.text.toString()
        var finalNumber: Double? = null
        when (op) {

            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
        }
        entryValues.setText(finalNumber.toString())
    }
}
