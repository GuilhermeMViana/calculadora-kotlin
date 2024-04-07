package br.com.fiap

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    private lateinit var displayTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayTextView = findViewById(R.id.textViewDisplay)

        // Definir os listeners dos botões
        val button1 = findViewById<Button>(R.id.button_1)
        val button2 = findViewById<Button>(R.id.button_2)
        val button3 = findViewById<Button>(R.id.button_3)
        val button4 = findViewById<Button>(R.id.button_4)
        val button5 = findViewById<Button>(R.id.button_5)
        val button6 = findViewById<Button>(R.id.button_6)
        val button7 = findViewById<Button>(R.id.button_7)
        val button8 = findViewById<Button>(R.id.button_8)
        val button9 = findViewById<Button>(R.id.button_9)
        val button0 = findViewById<Button>(R.id.button_0)

        val buttonAdd = findViewById<Button>(R.id.button_add)
        val buttonSubtract = findViewById<Button>(R.id.button_subtract)
        val buttonMultiply = findViewById<Button>(R.id.button_multiply)
        val buttonDivide = findViewById<Button>(R.id.button_divide)
        val buttonEqual = findViewById<Button>(R.id.button_equal)

        // Configurar os listeners dos botões numéricos
        val numberClickListener = { view: android.view.View ->
            val digit = (view as Button).text
            val currentText = displayTextView.text.toString()
            displayTextView.text = if (currentText == "0") digit else "$currentText$digit"
        }

        button1.setOnClickListener(numberClickListener)
        button2.setOnClickListener(numberClickListener)
        button3.setOnClickListener(numberClickListener)
        button4.setOnClickListener(numberClickListener)
        button5.setOnClickListener(numberClickListener)
        button6.setOnClickListener(numberClickListener)
        button7.setOnClickListener(numberClickListener)
        button8.setOnClickListener(numberClickListener)
        button9.setOnClickListener(numberClickListener)
        button0.setOnClickListener(numberClickListener)

        // Configurar os listeners dos operadores
        val operatorClickListener = { view: android.view.View ->
            val operator = (view as Button).text
            val currentText = displayTextView.text.toString()
            if (currentText.isNotEmpty()) {
                // Implemente o código para lidar com os operadores aqui
            }
        }

        buttonAdd.setOnClickListener(operatorClickListener)
        buttonSubtract.setOnClickListener(operatorClickListener)
        buttonMultiply.setOnClickListener(operatorClickListener)
        buttonDivide.setOnClickListener(operatorClickListener)

        // Configurar o listener para o botão de igual
        buttonEqual.setOnClickListener {
            val expression = displayTextView.text.toString()
            // Implemente o código para calcular o resultado da expressão aqui
        }
    }
}
