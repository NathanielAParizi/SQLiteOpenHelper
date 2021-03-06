package com.example.roomkotlindemo

import android.app.Activity
import android.content.Intent
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {


    val db by lazy { EmployeeDatabaseHelper(this) }
    var employees = ArrayList<Employee>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadSomeData()



    }

    private fun loadSomeData() {

        var emp1 = Employee(
            "Nathan", "Parizi", "123 Street", "Columbia",
            "Sc", "29229",
            "9142141", "Android Developer", "Finance"
        )
        var emp2 = Employee(
            "CJ", "Johnson", "123 Blvd", "HR",
            "Indiana", "29282",
            "2358774", "Android Developer", "IT"
        )
        var emp3 = Employee(
            "Gylnis", "Burton", "123 Krunk", "New York",
            "NY", "98228",
            "985189", "Android Developer", "IT"
        )
        var emp4 = Employee(
            "Kyung", "Pak", "123 Vegan Bike Hipster Ave", "Portland",
            "OR", "777723",
            "555555555", "Android Developer", "IT"
        )
        var emp5 = Employee(
            "Andrew", "Millsap", "123 Cool St", "New York",
            "NY", "999222",
            "3333999", "Android Developer", "Management"
        )
        var emp6 = Employee(
            "Eric", "Van Brunson", "123 The Boi Aint Right Ct.", "Austin",
            "TX", "444222",
            "000999", "Android Developer", "IT"
        )
        var emp7 = Employee(
            "Craig", "Vitirinyu", "123  Keg Stand Alpha-Psi Blvd.", "Boston",
            "MA", "222211",
            "03953112", "Android Developer", "Finance"
        )
        var emp8 = Employee(
            "Aaron", "Hoskins", "123 Jack Daniels St.", "Woodstock",
            "TN", "305333",
            "44444", "Senior Android Developer", "Management"
        )

        employees.add(emp1)
        employees.add(emp2)
        employees.add(emp3)
        employees.add(emp4)
        employees.add(emp5)
        employees.add(emp6)
        employees.add(emp7)
        employees.add(emp8)

        for (i in 0..employees.size-1) {
            db.insertPersonIntoDatabase(employees.get(i))
        }
        var qq = db.getOnePersonFromDatabase("000999")
        db.removePersonFromDatabase("44444")


    }


    fun onClick(view: View) {

        when (view.id) {

            R.id.saveActivity -> {
                intent = Intent(this, AddEmployee::class.java)
                startActivity(intent)
            }
            R.id.deleteActivity -> {
                intent = Intent(this, DeleteEmployee::class.java)
                startActivity(intent)
            }
            R.id.updateActivityBtn -> {
                intent = Intent(this, UpdateEmployee::class.java)
                startActivity(intent)
            }
            R.id.detailsActivityBtn -> {
                intent = Intent(this, EmployeeDetailsActivity::class.java)
                startActivity(intent)
            }

        }

    }


}
