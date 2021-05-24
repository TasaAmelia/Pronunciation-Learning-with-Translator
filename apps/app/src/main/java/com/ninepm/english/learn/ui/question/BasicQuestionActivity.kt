package com.ninepm.english.learn.ui.question

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.ninepm.english.learn.R
import com.ninepm.english.learn.databinding.ActivityQuestionBasicBinding
import com.ninepm.english.learn.databinding.QuestionBasicContentDetailBinding

class BasicQuestionActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: QuestionBasicContentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val basicQuestionActivity = ActivityQuestionBasicBinding.inflate(layoutInflater)
        basicQuestionActivity.btnBack.setOnClickListener(this)
        binding = basicQuestionActivity.questionBasicContentDetail
        setSupportActionBar(basicQuestionActivity.questionBasicToolbar)
        setContentView(basicQuestionActivity.root)
        
        basicQuestionActivity.imgMenu.setOnClickListener{
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener { item ->
                when(item.itemId){
                    R.id.about -> {
                        val intent = Intent (this, AboutActivity::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.history -> {
                        val intent = Intent (this, HistoryActivity::class.java)
                        startActivity(intent)
                        true
                    }
                    else -> false
                }
            }
            popupMenu.inflate(R.menu.popup_menu)
            popupMenu.show()
        }
        
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_back -> {
                MaterialAlertDialogBuilder(this)
                    .setTitle(resources.getString(R.string.are_you_sure))
                    .setMessage(resources.getString(R.string.leave_message))
                    .setNegativeButton(resources.getString(R.string.cancel)) { dialog, which ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(resources.getString(R.string.yes)) { dialog, which ->
                        dialog.dismiss()
                        finish()
                    }
                    .show()
            }
        }
    }
}
