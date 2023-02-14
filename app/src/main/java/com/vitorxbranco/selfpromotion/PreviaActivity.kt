package com.vitorxbranco.selfpromotion

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_previa.*

class PreviaActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreviewText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previa)
        displayMessage()
        setUpButton()
    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("Message") as Message
        messagePreviewText = """
                Olá ${message.nomeContato},
                
                Meu nome é ${message.meuNome}, e eu sou ${message.getFullJobDescription()}. Tenho um portfólio de aplicativos para demonstrar minhas habilidades técnicas que posso mostrar se tiver interesse.
                
                Posso começar a trabalhar ${message.getAvailability()}. Por favor entrar em contato caso tenha algum cargo adequado para mim.
                
                Desde já, muito obrigado.
                
                Atenciosamente,
                
                ${message.meuNome}            
            """.trimIndent()
        text_view_previa_de_mensagem.text = messagePreviewText
    }

    private fun setUpButton() {
        button_enviar_mensagem.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.numeroContato}")
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }

    }
}