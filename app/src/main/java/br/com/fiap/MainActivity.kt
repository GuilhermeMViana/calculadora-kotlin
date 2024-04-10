package br.com.fiap

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

/**
 * MainActivity é a classe principal que estende ComponentActivity.
 * Esta classe é responsável por gerenciar a interface do usuário e interações do usuário.
 */
class MainActivity : ComponentActivity() {
    /**
     * Declaração de uma variável TextView que será usada para exibir os números e resultados.
     */
    private lateinit var displayTextView: TextView

    /**
     * O método onCreate() é chamado quando a atividade é iniciada.
     * @param savedInstanceState é um objeto Bundle que o sistema passa para onCreate().
     * Ele contém o estado salvo da atividade da última vez que foi encerrada pelo sistema.
     * Por exemplo, se a atividade foi destruída porque o usuário girou a tela, o objeto Bundle
     * conterá os valores mais recentes que foram salvos.
     * Se a atividade está sendo criada pela primeira vez, savedInstanceState será nulo.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /** Define o layout da atividade.
         * A função setContentView é usado para definir o layout de uma atividade, transformando
         * um arquivo XML de layout em uma hierarquia de views que pode ser renderizada na tela.
         * @param R.layout.activity_main é o arquivo XML de layout que será inflado.
         */
        setContentView(R.layout.activity_main)

        /** A função findViewById é uma maneira de conectar seu código Kotlin/Java com seu layout XML,
         * permitindo que você interaja com as views definidas no XML
        */
        displayTextView = findViewById(R.id.textViewDisplay)

        // Declaração de variáveis para armazenar o operador e a primeira expressão.
        var operator = ""
        var firstExpression = ""

        /** Inicialização dos botões numéricos e operadores através do id definido no arquivo XML
         * usado como layout.
         *
         */
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

        val buttonErase = findViewById<Button>(R.id.button_erase)
        val buttonClear = findViewById<Button>(R.id.button_clear)

        /**
         * Configuração dos listeners dos botões numéricos.
         * Quando um botão numérico é pressionado, o número correspondente é adicionado ao display.
         * @param view é a view que foi clicada.
         */
        val numberClickListener = { view: android.view.View ->
            // Obtem o dígito do botão clicado, e o texto atual do display.
            val digit = (view as Button).text
            val currentText = displayTextView.text.toString()

            // Atualiza o texto do display com o dígito clicado ou concatena o dígito ao texto atual.
            displayTextView.text = if (currentText == "0") digit else "$currentText$digit"
        }

        // Configuração da função que aguarda um clique nos botões numéricos.
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

        /**
         * Configuração dos listeners dos operadores.
         * Quando um botão de operador é pressionado, o operador é armazenado e o display é limpo.
         */
        val operatorClickListener = { view: android.view.View ->
            // Verifica se o display não está vazio e se a primeira expressão está vazia para
            // impossibilitar o clique de duas operações consecutivas.
            if (displayTextView.text.toString().isNotEmpty() && firstExpression == "") {
                operator = (view as Button).text.toString()
                firstExpression = displayTextView.text.toString()
                displayTextView.text = "0"
            }
        }

        // Configuração da função que aguarda um clique nos operadores.
        buttonAdd.setOnClickListener(operatorClickListener)
        buttonSubtract.setOnClickListener(operatorClickListener)
        buttonMultiply.setOnClickListener(operatorClickListener)
        buttonDivide.setOnClickListener(operatorClickListener)

        /**
         * Configuração do listener para o botão de igual.
         * Quando o botão de igual é pressionado, a expressão é avaliada e o resultado é exibido.
         */
        buttonEqual.setOnClickListener {
            // Verifica se a primeira expressão não está vazia pois caso esteja não há como
            // realizar uma operação.
            if (firstExpression != "") {
                val expression = displayTextView.text.toString()

                // Avalia a expressão com base no operador armazenado e exibe o resultado.
                val result = when (operator) {
                    "+" -> firstExpression.toDouble() + expression.toDouble()
                    "-" -> firstExpression.toDouble() - expression.toDouble()
                    "*" -> firstExpression.toDouble() * expression.toDouble()
                    "/" -> firstExpression.toDouble() / expression.toDouble()
                    else -> 0
                }
                displayTextView.text = result.toString()

                firstExpression = ""
            }
        }

        /**
         * Configuração do listener do botão de excluir.
         * Quando o botão de excluir é pressionado, o último dígito do display é removido.
         */
        buttonErase.setOnClickListener {
            if (displayTextView.text.length >= 1){
                displayTextView.text = displayTextView.text.toString().dropLast(1)
            }
        }

        /**
         * Configuração do listener do botão de limpar.
         * Quando o botão de limpar é pressionado, o display é limpo e as variáveis são redefinidas.
         */
        buttonClear.setOnClickListener {
            displayTextView.text = "0"
            firstExpression = ""
            operator = ""
        }
    }
}