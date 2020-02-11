package com.example.kotlinfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

typealias EmployeeSet = ArrayList<Employee>

class MainActivity : AppCompatActivity() {

    // Kotlin is a statically typed language. The type of expressions is checked at run-time.
    //Kotlin uses type-inference. The compiler can infer the type of a variable based on the
    //context in which its being used.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val means the variable is immutable. it can only be assigned once. ( java -> final )
        // Compiler requires assignment of either a value or type

        //With var, the data-type is fixed at declaration
        // Val usage over Var is considered good practice.


        //***** Primitive Data Types: **********
        //
        val number: Short = 25

        val bool: Boolean = true  //1bit

        val byte: Byte = 127  // 8bits

        val short: Short = 32767 // 16bits
        val char: Char = 'a'    // 16bits

        val int: Int = 2000000000 // 32bits
        val float: Float = 2.000000000f  //32bits

        val long: Long = 9000000000000000000  //64bits
        val double: Double = 9.0             // 64bits


        // Scientific Numbers

        val scFloat = 12E3f
        val scDouble = 4e7  // Defaults to double


        val employee1 = Employee("Nathan", 500)
        employee1.name = "Schrodinger's Cat"

        val employee2: Employee
        val number2 = 100

        if (scFloat < number2) {
            employee2 = Employee("Coolcat", 153)
        } else {
            employee2 = Employee("Lamecat", 150)
        }

        //** type-alias
        var emp : EmployeeSet


        val names = arrayListOf("John","Jane","Mary")
        Log.v("TAG",names[1])


        //**** Ternary operator     q = x ? y : z
        // Elvis operator              ?:

        //static keyword replacement
        // done with top level functions

        // Referential vs Structural equality
        //
        // Structurally equal =  Employee("John",2) is equal to Employee("John",2)
        // Refertially equal = Comparing objects but not data that they contain.





    }



}

class Employee(var name: String, val id: Int)
