package com.example.revisiononsession34

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.revisiononsession34.databinding.ContactDetailsBinding

class ContactDetails:AppCompatActivity() {

    lateinit var viewBinding:ContactDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ContactDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // to recieve data from intent
        viewBinding.name.text = intent.getStringExtra("name")
        viewBinding.phone.text = intent.getStringExtra("phone")

    }
}