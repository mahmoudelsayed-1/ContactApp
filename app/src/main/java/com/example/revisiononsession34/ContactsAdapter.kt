package com.example.revisiononsession34

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.revisiononsession34.databinding.ContactItemBinding

class ContactsAdapter (var items:List<Contacts?>?=null):RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val viewBinding = ContactItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items!![position]
        holder.itemBinding.textContact.text =item?.Name
        holder.itemBinding.phone.text = item?.phone
        holder.itemBinding.personDetails.setOnClickListener{
            onProfileClick?.onClick(position,item!!)
        }
        holder.itemBinding.dial.setOnClickListener{
            onCallClick?.onClick(position,item!!)
        }
    }

    override fun getItemCount(): Int =
        items?.size?:0


    var onProfileClick:OnItemClickListener?=null
    var onCallClick : OnItemClickListener?=null

//

    fun interface OnItemClickListener{
        fun onClick(position: Int,items: Contacts)
    }



class ViewHolder(val itemBinding: ContactItemBinding) : RecyclerView.ViewHolder(itemBinding.root)

}
