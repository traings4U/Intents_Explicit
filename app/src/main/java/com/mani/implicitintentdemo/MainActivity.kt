package com.mani.implicitintentdemo

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  tvContact = findViewById<TextView>(R.id.tvContact)
        val  tvBrowse = findViewById<TextView>(R.id.tvBrowse)
        val  tvSearch = findViewById<TextView>(R.id.tvSearch)
        val  tvMap = findViewById<TextView>(R.id.tvMap)
        val  tvDail = findViewById<TextView>(R.id.tvDail)
        val  tvEmail = findViewById<TextView>(R.id.tvEmail)
        val  tvShare = findViewById<TextView>(R.id.tvShare)

        tvContact.setOnClickListener(this)
        tvBrowse.setOnClickListener(this)
        tvSearch.setOnClickListener(this)
        tvMap.setOnClickListener(this)
        tvDail.setOnClickListener(this)
        tvEmail.setOnClickListener(this)
        tvShare.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v!!.id)
        {
            R.id.tvContact->{

                intent = Intent(Intent.ACTION_VIEW,ContactsContract.Contacts.CONTENT_URI)
                startActivity(intent)

            }

            R.id.tvBrowse->{

                intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
                startActivity(intent)
            }

            R.id.tvSearch->{

                intent = Intent(Intent.ACTION_WEB_SEARCH)
                intent.putExtra(SearchManager.QUERY,"Android Training Institute in Bangalore")
                startActivity(intent)
            }

            R.id.tvMap->{

                intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Manipal University,Bangalore"))
                startActivity(intent)
            }

            R.id.tvDail->{

                intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Uri.encode("+91 7022503201")))
                startActivity(intent)
            }

            R.id.tvEmail->{

                intent = Intent(Intent.ACTION_SENDTO)
                intent.type= "text/plain"
                intent.data = Uri.parse("mailto:")
                intent.putExtra(Intent.EXTRA_EMAIL,arrayOf("vmkrmca@gmail.com"))
                intent.putExtra(Intent.EXTRA_SUBJECT,"Apply for Leave")
                intent.putExtra(Intent.EXTRA_TEXT,"I am Suffering with Fever i am not able to attend office")
                startActivity(Intent.createChooser(intent,"Choose Email Client..."))


            }

            R.id.tvShare->{

                intent = Intent(Intent.ACTION_SEND)
                intent.type= "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=com.pinterest")
                startActivity(Intent.createChooser(intent,"Sahre Via..."))

            }

        }
    }
}