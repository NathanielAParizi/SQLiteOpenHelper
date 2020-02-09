package com.example.roomkotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_add_employee.*

class AddEmployee : AppCompatActivity() {

    val db by lazy { EmployeeDatabaseHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)


    }


    fun onClick(view: View) {

        var firstName = etfirst_name.text.toString()
        var lastName = etlast_name.text.toString()
        var address = etaddress.text.toString()
        var city = etCity.text.toString()
        var state = etState.text.toString()
        var zip = etZip.text.toString()
        var taxID = ettaxID.text.toString()
        var position = etposition.text.toString()
        var department = etdepartment.text.toString()
        var newEmployee =
            Employee(firstName, lastName, address, city, state, zip, taxID, position, department)

        db.insertPersonIntoDatabase(newEmployee)

        Log.v("NEWEMP",db.getOnePersonFromDatabase(taxID).toString())


    }
}
