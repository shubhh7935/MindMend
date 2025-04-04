package com.example.mindmend_mobileappformentalhealth

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File
import java.io.FileOutputStream

class ExternalStorage : AppCompatActivity() {
    lateinit var enterName: EditText
    lateinit var save: Button
    lateinit var readName: TextView
    lateinit var read: Button

    val filename = "Myfiledemo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external_storage)

        enterName = findViewById(R.id.enterName)
        save = findViewById(R.id.save)

        read = findViewById(R.id.read)
        readName = findViewById((R.id.readName))

        save.setOnClickListener { // Corrected line
            saveToexternal(enterName.text.toString())
        }

        read.setOnClickListener {
            readName.text = readFromExternal()
        }

    }

    private fun readFromExternal():String {
        val externalfile = getExternalFilesDir(null)
        val file = File(externalfile,filename)
        return try{
            FileReader(file).readText()
        }catch(e:Exception){
            null
            Toast.makeText(this,"Couldn't read your data", Toast.LENGTH_SHORT).show()
        }
    }

    fun saveToexternal(s:String){
        val fileloc = getExternalFilesDir(null)
        val file = File(fileloc,filename)

        try {
            FileOutputStream(file).use{
                it.write(s.toByteArray())
                Toast.makeText(this,"Data Saved successfully", Toast.LENGTH_SHORT).show()
            }
        }catch (e:Exception){ // corrected
            Toast.makeText(this,"Couldn't save your data", Toast.LENGTH_SHORT).show()
        }
    }
}