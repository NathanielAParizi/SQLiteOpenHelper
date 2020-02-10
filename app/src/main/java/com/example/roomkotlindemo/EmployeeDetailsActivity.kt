package com.example.roomkotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_employee_details.*
import kotlinx.android.synthetic.main.activity_main.*

class EmployeeDetailsActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    val db by lazy { EmployeeDatabaseHelper(this) }

    var employeeList = ArrayList<Employee>()
    var sb = StringBuilder()
    var departmentItem = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)

        val spinner: Spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.employee_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = this

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        departmentItem = spinner.selectedItem.toString()
        sb.clear()
        txtDetails.text = ""

    }



    fun onClick(view: View) {


        var employeeList = db.getAllPersonFromSameDepartment(departmentItem)

        for (i in 0..employeeList.size-1) {
            var tempEmp = employeeList.get(i)
            sb.append(tempEmp.firstName + " " + tempEmp.lastName + " \n" + tempEmp.address + " " +
            tempEmp.city + " " + tempEmp.state + " \n" + tempEmp.taxID + " " + tempEmp.position +
            " " + tempEmp.department + "\n\n")
        }

        txtDetails.text = sb.toString()


    }




}
