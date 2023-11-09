package com.example.homework_7


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.TextView
import com.example.homework_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var stringCount: Int = 0
    private var numberCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUp()
        checkedNumeric()


    }

    private fun setUp(){
        binding.apply {
            acbButton.setOnClickListener {
                if (!cbNumeric.isChecked && !etName.text.isNullOrBlank()) {
                    // use createTextView(isInt: Boolean)
                    textLayout.addView(
                        createTextView(cbNumeric.isChecked)
                    )
                }
                if (cbNumeric.isChecked && !etName.text.isNullOrBlank()) {
                    // use createTextView(isInt: Boolean)
                    intLayout.addView(
                        createTextView(cbNumeric.isChecked)
                    )
                }
            }
        }
    }

    private fun createTextView(isInt: Boolean): TextView{
        val view = TextView(this)
        view.apply {
            text = if(isInt) {
                "${++numberCount})  ${binding.etName.text}"
            }else{
                "${++stringCount})  ${binding.etName.text}"
            }
            setPadding(10, 5, 5, 10)
            return this
        }
    }

    private fun checkedNumeric(){
        binding.apply {
            cbNumeric.setOnCheckedChangeListener { _, isChecked ->
                etName.text?.clear()
                if(isChecked){
                    etName.inputType = InputType.TYPE_CLASS_NUMBER
                    etName.hint = resources.getString(R.string.enter_field_numeric)
                }else{
                    etName.inputType = InputType.TYPE_CLASS_TEXT
                    etName.hint = resources.getString(R.string.enter_field_name)
                }
            }
        }
    }

}