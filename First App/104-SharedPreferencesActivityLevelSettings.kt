package com.example.SharedPreferences


import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceManager
import com.example.sampleapp.databinding.ActivityLevelSharedPreferencesBinding

class SharedPreferencesActivityLevel : AppCompatActivity() {
    private lateinit var binding: ActivityLevelSharedPreferencesBinding
//    lecture 103 and 104
    private lateinit var listener:SharedPreferences.OnSharedPreferenceChangeListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLevelSharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        lecture 103 and 104
        val manager=PreferenceManager.getDefaultSharedPreferences(this)
        listener=SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            if(key.equals("change_UI")){
                if(manager.getBoolean("change_UI",false)==true){
                    binding.mainLayout.setBackgroundColor(Color.BLUE)
                }else
                    binding.mainLayout.setBackgroundColor(Color.TRANSPARENT)
            }
        }
        manager.registerOnSharedPreferenceChangeListener(listener)

        val editor=getPreferences(MODE_PRIVATE)
        binding.name.setText(editor.getString("Name",null))
        binding.checkBox.isChecked=editor.getBoolean("Checked",true)

        binding.saveBtn.setOnClickListener {
            val editor=getPreferences(MODE_PRIVATE).edit()
            editor.putString("Name",binding.name.text.toString())
            editor.putBoolean("Checked",binding.checkBox.isChecked)
            editor.apply()
        }

        binding.settingIcon.setOnClickListener{
            val intent= Intent(this,SettingSharePreferencesActivity::class.java)
            startActivity(intent)
//            finish()
        }

    }
}
