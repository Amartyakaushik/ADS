package com.example.sampleapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleapp.databinding.ActivityLevelSharedPreferencesBinding

class SharedPreferencesActivityLevel : AppCompatActivity() {
    private lateinit var binding: ActivityLevelSharedPreferencesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLevelSharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editor=getPreferences(MODE_PRIVATE)
        binding.name.setText(editor.getString("Name",null))
        binding.checkBox.isChecked=editor.getBoolean("Checked",true)

        binding.saveBtn.setOnClickListener {
            val editor=getPreferences(MODE_PRIVATE).edit()
            editor.putString("Name",binding.name.text.toString())
            editor.putBoolean("Checked",binding.checkBox.isChecked)
            editor.apply()
        }

//        binding.settingIcon.setOnClickListener{
//            val intent= Intent(this,FetchData::class.java)
//        }

    }
}
