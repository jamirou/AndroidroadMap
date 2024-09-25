package com.example.xmlstudynavigation.settings

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.xmlstudynavigation.R
import com.example.xmlstudynavigation.databinding.ActivitySettingsBinding
import com.example.xmlstudynavigation.model.SettingsModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsActivity : AppCompatActivity() {
    companion object {
        const val VOLUME_LVL = "volume_lvl"
        const val DARK_MODE = "dark_mode"
        const val BLUETOOTH = "bluetooth"
        const val VIBRATION = "vibration"
    }

    private lateinit var binding: ActivitySettingsBinding
    private var saveDataValues = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CoroutineScope(Dispatchers.IO).launch {
            getSettingsPreference().filter { saveDataValues }.collect { settingsModel ->
                if (settingsModel != null) {
                    runOnUiThread {
                        binding.ChangeToDarkModeSwitch.isChecked = settingsModel.darkMode
                        binding.BluetoothSwitch.isChecked = settingsModel.bluetooth
                        binding.VibrationSwitch.isChecked = settingsModel.vibration
                        binding.RangeSliderVolume.setValues(settingsModel.volume?.toFloat() ?: 0f)
                        saveDataValues != saveDataValues
                    }
                }
            }
        }
        /*View, padding, etc*/
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUI()
    }

    private fun initUI() {
        binding.RangeSliderVolume.addOnChangeListener { _, value, _ ->
//            Log.i("JamiroLog", "RangeSlider Value: $value")
            CoroutineScope(Dispatchers.IO).launch {
                saveVolume(value.toInt())
            }
            /*DarMode*/
            binding.ChangeToDarkModeSwitch.setOnCheckedChangeListener { _, value ->

                if(value) {
                    enableDarkMode()
                } else {
                    disableDarkMode()
                }

                CoroutineScope(Dispatchers.IO).launch {
                    saveOptions(DARK_MODE, value)
                }
            }
            /*BlueTooth*/
            binding.BluetoothSwitch.setOnCheckedChangeListener { _, value ->
                CoroutineScope(Dispatchers.IO).launch {
                    saveOptions(BLUETOOTH, value)
                }
            }
            /*Vibration*/
            binding.VibrationSwitch.setOnCheckedChangeListener { _, value ->
                CoroutineScope(Dispatchers.IO).launch {
                    saveOptions(VIBRATION, value)
                }
            }
        }
    }

    private suspend fun saveVolume(value: Int) {
        dataStore.edit { prefs ->
            prefs[intPreferencesKey(VOLUME_LVL)] = value
        }
    }

    private suspend fun saveOptions(key: String, value: Boolean) {
        dataStore.edit { preference ->
            preference[booleanPreferencesKey(key)] = value
        }
    }

    private fun getSettingsPreference(): Flow<SettingsModel?> {
        return dataStore.data.map { preference ->
            SettingsModel(
                volume = preference[intPreferencesKey(VOLUME_LVL)] ?: 15,
                darkMode = preference[booleanPreferencesKey(DARK_MODE)] ?: true,
                bluetooth = preference[booleanPreferencesKey(BLUETOOTH)] ?: false,
                vibration = preference[booleanPreferencesKey(VIBRATION)] ?: true
            )
        }
    }

    private fun enableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

}




