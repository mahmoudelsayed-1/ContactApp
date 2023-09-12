package com.example.revisiononsession34

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.revisiononsession34.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    lateinit var recycler: RecyclerView
    lateinit var adapter: ContactsAdapter
    lateinit var contactList: MutableList<Contacts>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        contactList = ArrayList()
        adapter = ContactsAdapter(contactList)
        viewBinding.recycler.adapter = adapter




        viewBinding.btnSave.setOnClickListener {

              var name = viewBinding.editTxtName.text.toString().trim()
            var phone = viewBinding.editTxtPhone.text.toString().trim()
            var descr = viewBinding.editTxtDesc.text.toString().trim()


            if (name.length < 3) {

                Toast.makeText(this, "name must be grater than 3", Toast.LENGTH_SHORT)
                    .show()

            } else if (phone.length != 11) {
                Toast.makeText(this, "number must include 11 number", Toast.LENGTH_SHORT)
                    .show()

            } else {
                // add contact to recycler
                val newContact = Contacts(name, phone, descr)
                contactList.add(newContact)
                adapter.notifyDataSetChanged()

                clearInput()
            }




        }

        adapter.onProfileClick = object : ContactsAdapter.OnItemClickListener{

            override fun onClick(position: Int, items: Contacts) {
                val intent = Intent(this@MainActivity,ContactDetails::class.java)
                intent.putExtra("name",items.Name)
                intent.putExtra("phone",items.phone)
                startActivity(intent)

            }


        }

        adapter.onCallClick = object :ContactsAdapter.OnItemClickListener{ // to show diaalog call
            override fun onClick(position: Int, items: Contacts) {

                // intent Dial

                var dialogIntent = Intent(Intent.ACTION_DIAL)
                dialogIntent.data = Uri.parse("tel:" + items.phone)
                startActivity(dialogIntent)


                // intent view -> to open any link
//                var dialogIntent = Intent(Intent.ACTION_VIEW)
//                dialogIntent.data = Uri.parse("https://youtu.be/Xw50ChxticA?si=IrKSw2RX55faisDb")
//                startActivity(dialogIntent)


            }
        }


    }


    private fun clearInput() {
        viewBinding.editTxtName.setText("")
        viewBinding.editTxtPhone.setText("")
        viewBinding.editTxtDesc.setText("")
    }

}


