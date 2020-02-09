package com.example.roomkotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.main.activity_update_employee.*

class UpdateEmployee : AppCompatActivity() {

    val db by lazy { EmployeeDatabaseHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_employee)


    }

    fun onClick(view: View) {


        when (view.id) {

            R.id.loadBtn -> {

                var taxID = etUpdate.text.toString()
                var emp = db.getOnePersonFromDatabase(taxID)

                var firstName = emp?.firstName
                var lastName = emp?.lastName
                var address = emp?.address
                var city = emp?.city
                var state = emp?.state
                var zip = emp?.zip
                var position = emp?.position
                var department = emp?.department

                employeeStatus.text = "$firstName\n" +
                        " $lastName\n" +
                        " $address\n" +
                        " $city\n" +
                        " $state\n" +
                        " $zip\n" +
                        " $position\n" +
                        " $department"


                Log.v("TAG", emp.toString())
            }
            R.id.updateBtn -> {

                var taxID = etUpdate.text.toString()
                var emp = db.getOnePersonFromDatabase(taxID)

                if (emp != null) {





                    db.updatePersonInDatabase(emp)

                } else {
                    Toast.makeText(
                        this, "Please load an" +
                                " existing employee before updating", LENGTH_LONG
                    ).show()
                }

            }
        }

    }
}
