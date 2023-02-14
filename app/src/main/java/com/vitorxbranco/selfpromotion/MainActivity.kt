package com.vitorxbranco.selfpromotion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_previa.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_previa.setOnClickListener {
            onPreviaClique()
        }

        val spinnerValeus: Array<String> = arrayOf("Desenvolvedor Android", "Engenheiro Android", "Engenheiro de Software")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValeus)
        spinner_titulo_emprego.adapter = spinnerAdapter
    }

    private fun onPreviaClique() {

        val message = Message(
            edit_text_nome_do_contato.text.toString(),
            edit_text_numero_do_contato.text.toString(),
            edit_text_meu_nome.text.toString(),
            check_box_junior.isChecked,
            spinner_titulo_emprego.selectedItem?.toString(),
            check_box_comeco_imediato.isChecked,
            edit_text_data_disponivel.text.toString()
        )

        val previaActivityIntent = Intent(this, PreviaActivity::class.java)
        previaActivityIntent.putExtra("Message", message)
        startActivity(previaActivityIntent)
    }
}