package foo.aplicativo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity2 : AppCompatActivity() {

    lateinit var menu: Spinner
    lateinit var textoSaida: String
    lateinit var textView1: TextView
    val estados = arrayOf("RS","PR", "AC")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        menu = findViewById(R.id.spinner)
        textView1 = findViewById(R.id.textViewSaida)



        menu.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, estados)

        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                textoSaida = estados[position]
                //Toast.makeText(applicationContext, "Selecionado: " + textoSaida, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    fun acaoExibir(view: View){
        var posicao = menu.selectedItemPosition
        textView1.setText("Selecionado: " + estados[posicao])
    }


}