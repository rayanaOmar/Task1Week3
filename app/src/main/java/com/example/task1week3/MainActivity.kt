package com.example.task1week3

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    lateinit var clMain:ConstraintLayout
    lateinit var text: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clMain= findViewById(R.id.clMain)
        text= findViewById(R.id.text)
        button = findViewById(R.id.buttonid)


        button.setOnClickListener {
            showAlertDialog("WELCOME")
        }
    }

    private fun showAlertDialog(title: String) {
        // build alert dialog
        val dialogBuilder = AlertDialog.Builder(this)

        // set message of alert dialog
        dialogBuilder.setMessage(title)
            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id ->
                this.recreate()
            })
            // negative button text and action
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })

        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("Game Over")
        // show alert dialog
        alert.show()
    }
    //menu section
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.goItem -> {
                goToIntent()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    fun goToIntent(){
        val intent = Intent(this, printOut::class.java)
        intent.putExtra("Text", "Hi, it is the 2nd Activity")
        startActivity(intent)
    }
}