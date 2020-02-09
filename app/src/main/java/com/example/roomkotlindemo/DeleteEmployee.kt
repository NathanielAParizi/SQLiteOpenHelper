package com.example.roomkotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.main.activity_delete_employee.*

class DeleteEmployee : AppCompatActivity() {

    val db by lazy { EmployeeDatabaseHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_employee)


    }

    fun onClick(view: View) {

        var taxID = etTaxID.text.toString()
        var employee = db.getOnePersonFromDatabase(taxID)
        var firstName = employee?.firstName.toString()
        var lastName = employee?.lastName.toString()

        if (employee != null) {
            Toast.makeText(
                this,
                "Deleting Employee: " + firstName + " " + lastName +
                        " " + "\nObject: " + db.getOnePersonFromDatabase(taxID).toString(),
                LENGTH_LONG
            ).show()
            db.removePersonFromDatabase(taxID)
        } else {
            Toast.makeText(this,"Employee not found", LENGTH_LONG).show()
        }


    }
}
