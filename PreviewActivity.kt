package com.example.selfpromoapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
import android.widget.Button
import android.widget.TextView
//import com.google.android.material.textfield.TextInputEditText

class PreviewActivity : AppCompatActivity() {
    lateinit var message:Message
    lateinit var messagePreviewText:String
   // private lateinit var message: Message
  //  private lateinit var messagePreviewText: String
    //private val messagebutton :Button = findViewById(R.id.button_send_message)
   // private var messagebutton:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_preview)
        displayMessage()
        // displayMessage()
        setupButton()


//        val contactName=intent.getStringExtra("Contact Name")
//        val contactNumber=intent.getStringExtra("Contact Number")
//        val myDisplayName=intent.getStringExtra("My Display Name")
//        val includeJunior=intent.getBooleanExtra("Include Junior",false)
//        val jobTitle=intent.getStringExtra("Job Title")
//        val immediateStart=intent.getBooleanExtra("Immediate Start",false)
//        val startDate=intent.getStringExtra("Start Date")
//       val testString="Contact Name: $contactName, Contact Number: $contactNumber, My Display Name: $myDisplayName, Include Junior: $includeJunior,Job Title: $jobTitle, Immediate Start: $immediateStart, Start Date: $startDate"
//        val textView = findViewById<TextView>(R.id.text_view_message).apply {
//            text = testString

    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("Message") as Message
        messagePreviewText = """
                     Hi ${message.contactName}
                     
                     My name is ${message?.myDisplayName} and I am ${message.getFullJobDescription()}.
                   
                     I have a portfolio of apps to demonstrate my technical skills that I can show on request.
                   
                     I am able to start a new position ${message.getAvailability()}.
                  
                     Please get in touch if you have any suitable roles for me.
                   
                     Thanks and best regards.
                 """.trimIndent()
        val textview = findViewById<TextView>(R.id.text_view_message).apply {
            text = messagePreviewText
        }
    }
    private fun setupButton(){
        val messagebutton :Button = findViewById(R.id.button_send_message)

        messagebutton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:" + message.contactNumber)  // Only SMS apps respond to this.
                val hello = "Hi ${message?.contactName}"
                putExtra("sms_body", messagePreviewText)

            }
            startActivity(intent)

        }

    }

//    private fun displayMessage() {
//        message = intent.getSerializableExtra("Message") as Message
//        messagePreviewText = """
//               Hi ${message.contactName}
//
//               My name is ${message.myDisplayName} and I am ${message.getFullJobDescription()}.
//
//               I have a portfolio of apps to demonstrate my technical skills that I can show on request.
//
//               I am able to start a new position ${message.getAvailability()}.
//
//               Please get in touch if you have any suitable roles for me.
//
//               Thanks and best regards.
//           """.trimIndent()



        }
//    private fun setupButton(){
//        messagebutton.setOnClickListener {
//            val intent = Intent(Intent.ACTION_SENDTO).apply {
//                data = Uri.parse("smsto: ${message.contactNumber}")
//                putExtra("sms_body",messagePreviewText)
//            }
//            startActivity(intent)
//        }
//    }









