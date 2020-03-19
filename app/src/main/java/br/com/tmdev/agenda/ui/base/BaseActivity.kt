package br.com.tmdev.agenda.ui.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    companion object {
        var countStart = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        countStart++
    }

    fun openActivity(@NonNull activity: AppCompatActivity, @NonNull clazz: Class<*>, finish: Boolean = true, args: Bundle?) {
        val intent = Intent(activity, clazz)
        if (args == null) {
            activity.startActivity(intent)
        } else{
            activity.startActivity(intent, args)
        }

        if (finish)  {
            activity.finish()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }

    fun makeText(activity: Activity, text: String) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }

}