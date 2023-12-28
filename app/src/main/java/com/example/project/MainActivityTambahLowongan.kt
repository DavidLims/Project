package com.example.project

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.example.project.databinding.ActivityMainTambahLowonganBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.text.DateFormat
import java.util.Calendar

class MainActivityTambahLowongan : AppCompatActivity() {

    private lateinit var binding: ActivityMainTambahLowonganBinding
    private lateinit var ref: DatabaseReference

    var imageURL: String? = null
    var uri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTambahLowonganBinding.inflate(layoutInflater)
       // setContentView(R.layout.activity_main_tambah_lowongan)
        setContentView(binding.root)

//        val activityResultLauncher = registerForActivityResult<Intent, ActivityResult>(
//            ActivityResultContracts.StartActivityForResult()){ result ->
//            if (result.resultCode == RESULT_OK){
//                val data = result.data
//                uri = data!!.data
//                binding.uploadImage.setImageURI(uri)
//            } else {
//                Toast.makeText(this@MainActivityTambahLowongan, "Tidak ada gambar yang dipilih", Toast.LENGTH_SHORT).show()
//            }
//        }

        val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                uri = data!!.data
                binding.uploadImage.setImageURI(uri)
            } else {
                Toast.makeText(this@MainActivityTambahLowongan, "Tidak ada gambar yang dipilih", Toast.LENGTH_SHORT).show()
            }
        }


        binding.uploadImage.setOnClickListener{
            val photoPicker = Intent(Intent.ACTION_PICK)
            photoPicker.type = "image/*"
            activityResultLauncher.launch(photoPicker)
        }
        binding.tambahButton.setOnClickListener{
            saveData()
        }
    }
    private fun saveData(){
        val storageReference = FirebaseStorage.getInstance().reference.child("Task Images")
            .child(uri!!.lastPathSegment!!)

        val builder = AlertDialog.Builder(this@MainActivityTambahLowongan)
        builder.setCancelable(false)
        builder.setView(R.layout.activity_progress)
        val dialog = builder.create()
        dialog.show()

        storageReference.putFile(uri!!).addOnSuccessListener { taskSnapshot ->
            val uriTask = taskSnapshot.storage.downloadUrl
            while (!uriTask.isComplete);
            val urlImage = uriTask.result
            imageURL = urlImage.toString()
            uploadData()
            dialog.dismiss()
        }.addOnFailureListener{
            dialog.dismiss()
        }
    }
    private fun uploadData(){
        val IDLowongan = ref.push().key
        val posisi = binding.uploadPosisi.text.toString()
        val durasi = binding.uploadDurasi.text.toString()
        val syarat = binding.uploadSyarat.text.toString()
        val datalowongan = dataLowongan(IDLowongan, posisi, durasi, syarat, imageURL)
        val currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().time)

        FirebaseDatabase.getInstance().getReference("dataLowongan").child(currentDate)
            .setValue(datalowongan).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this@MainActivityTambahLowongan, "Disimpan", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }.addOnFailureListener { e ->
                Toast.makeText(this@MainActivityTambahLowongan, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
    }
}