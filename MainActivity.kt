package com.example.selfpromoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
//import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private var contactNameEditText:TextInputEditText?=null
    private var contactNumberEditText:TextInputEditText?=null
    private var myDisplayNameEditText:TextInputEditText?=null
    private var startDateEditText:TextInputEditText?=null
    private var juniorCheckBox:CheckBox?=null
    private var immediateStartCheckBox:CheckBox?=null
    private var jobTitleSpinner: Spinner?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contactNameEditText=findViewById(R.id.edit_text_contact_name)
        contactNumberEditText=findViewById(R.id.edit_text_contact_number)
        myDisplayNameEditText=findViewById(R.id.edit_text_display_name)
        startDateEditText=findViewById(R.id.edit_text_start_date)
        juniorCheckBox=findViewById(R.id.check_box_include_junior)
        immediateStartCheckBox=findViewById(R.id.check_box_immediate_start)
        jobTitleSpinner=findViewById(R.id.spinner_job_title)
        val previewbutton: Button = findViewById(R.id.button_message)
        previewbutton.setOnClickListener {
            OnPreviewClicked()
        }
        val spinnerValues:Array<String> = arrayOf("Android Developer","Software Developer","Web Developer","Software Tester")
        val spinnerAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,spinnerValues)
        jobTitleSpinner?.adapter = spinnerAdapter

    }

    private fun OnPreviewClicked() {


        val message = Message(
            contactNameEditText?.text.toString(),
            contactNumberEditText?.text.toString(),
            myDisplayNameEditText?.text.toString(),
            juniorCheckBox?.isChecked,
            jobTitleSpinner?.selectedItem?.toString(),
            immediateStartCheckBox?.isChecked,
            startDateEditText?.text.toString()
        )


       
        val previewActivityIntent= Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)

        startActivity(previewActivityIntent)


//
    }
}
