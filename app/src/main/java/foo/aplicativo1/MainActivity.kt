package foo.aplicativo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.RatingBar

class MainActivity : AppCompatActivity() {

    lateinit var nomeUsuario: EditText
    lateinit var botao: Button
    lateinit var ratingBar: RatingBar
    lateinit var textoRating: TextView
    lateinit var switch: Switch
    lateinit var textoSwitch: TextView
    lateinit var seekBar: SeekBar
    lateinit var textoSeekBar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nomeUsuario = findViewById(R.id.nomeUsuario)
        botao = findViewById(R.id.botao)
        ratingBar = findViewById(R.id.rating)
        textoRating = findViewById(R.id.textoRating)
        switch = findViewById(R.id.switch1)
        textoSwitch = findViewById(R.id.textViewSwitch)
        seekBar = findViewById(R.id.seekBar)
        textoSeekBar = findViewById(R.id.textView5)

        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            textoRating.text = "" + rating
        };

        switch.setOnCheckedChangeListener{
            ButtonView, isChecked -> isChecked
            var textoStatus = ""
            if(isChecked){
                textoStatus = "Ligado"
            }else{
                textoStatus = "Desligado"
            }
            textoSwitch.text = textoStatus
            Toast.makeText(applicationContext, textoStatus, Toast.LENGTH_SHORT).show()
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textoSeekBar.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                println("começou")
                Toast.makeText(applicationContext, "Começou", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                println("parou")
                Toast.makeText(applicationContext, "Parou", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun acaoSair(view: View) {
        finish()
    }

    fun acaoExibir(view: View) {
        var textoDigitado = nomeUsuario.text.toString() + " " + textoRating.text
        Toast.makeText(applicationContext, textoDigitado, Toast.LENGTH_LONG).show()
    }

    fun acaoBotaoProximo(view: View){
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
        finish()
    }
}