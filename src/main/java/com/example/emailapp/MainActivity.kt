package com.example.emailapp

import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Properties
import javax.mail.Message
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        // Replace with your email and password
        val email = "rehankhan7209658@gmail.com"
        val password = "yyfayrttyubdtuyj"

        val recipientEmail = "royal9565318273@gmail.com"
        val subject = "asgjgsagjg /n/n hasbbasjb"
        val body = "bsadbjbbbsbdb"

        // Send email
        val buttonSendEmail: Button = findViewById(R.id.button_send_email)
        buttonSendEmail.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val mailSender = MailSender(email, password)
                    mailSender.sendMail(recipientEmail, subject, body)
                    showToast("Email sent successfully")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun showToast(message: String) {
        runOnUiThread {
            Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
        }
    }
}
