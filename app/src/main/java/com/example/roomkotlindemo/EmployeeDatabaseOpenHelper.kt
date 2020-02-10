package com.example.roomkotlindemo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class EmployeeDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {

        // Don't want to pass a nullified database
        sqLiteDatabase?.execSQL(CREATE_PERSON_TABLE)

    }

    override fun onUpgrade(sqlLiteDatabase: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onCreate(sqlLiteDatabase)

    }


    fun insertPersonIntoDatabase(employee: Employee) {

        val database = writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COLUMN_FIRSTNAME, employee.firstName)
        contentValues.put(COLUMN_LASTNAME, employee.lastName)
        contentValues.put(COLUMN_ADDRESS, employee.address)
        contentValues.put(COLUMN_CITY, employee.city)
        contentValues.put(COLUMN_STATE, employee.state)
        contentValues.put(COLUMN_ZIP, employee.zip)
        contentValues.put(COLUMN_TAXID, employee.taxID)
        contentValues.put(COLUMN_POSITION, employee.position)
        contentValues.put(COLUMN_DEPARTMENT, employee.department)

        database.insert(TABLE_NAME, null, contentValues)
        database.close()

    }

    fun getOnePersonFromDatabase(taxID: String): Employee? {

        val database = readableDatabase
        var employee: Employee? = null


        val cursor = database.rawQuery(
            "SELECT * FROM $TABLE_NAME WHERE $COLUMN_TAXID =  '$taxID'", null
        )


        if (cursor.moveToFirst()) {

            val firstName = cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME))
            val lastName = cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME))
            val address = cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS))
            val city = cursor.getString(cursor.getColumnIndex(COLUMN_CITY))
            val state = cursor.getString(cursor.getColumnIndex(COLUMN_STATE))
            val zip = cursor.getString(cursor.getColumnIndex(COLUMN_ZIP))
            val taxID = cursor.getString(cursor.getColumnIndex(COLUMN_TAXID))
            val position = cursor.getString(cursor.getColumnIndex(COLUMN_POSITION))
            val department = cursor.getString(cursor.getColumnIndex(COLUMN_DEPARTMENT))

            val resultPerson = Employee(
                firstName, lastName, address, city, state, zip, taxID,
                position, department
            )

            return resultPerson
        }

        cursor.close()
        database.close()
        return null

    }

    fun getAllPersonFromSameDepartment(department: String): ArrayList<Employee> {

        val database = readableDatabase
        var personList: ArrayList<Employee> = ArrayList<Employee>()
        var employee: Employee? = null


        val cursor = database.rawQuery(
            "SELECT * FROM $TABLE_NAME WHERE $COLUMN_DEPARTMENT =  '$department'", null
        )

        if (cursor.moveToFirst()) {


            do {
                val firstName = cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME))
                val lastName = cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME))
                val address = cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS))
                val city = cursor.getString(cursor.getColumnIndex(COLUMN_CITY))
                val state = cursor.getString(cursor.getColumnIndex(COLUMN_STATE))
                val zip = cursor.getString(cursor.getColumnIndex(COLUMN_ZIP))
                val taxID = cursor.getString(cursor.getColumnIndex(COLUMN_TAXID))
                val position = cursor.getString(cursor.getColumnIndex(COLUMN_POSITION))
                val department = cursor.getString(cursor.getColumnIndex(COLUMN_DEPARTMENT))

                val person = Employee(
                    firstName, lastName, address, city, state, zip, taxID, position
                    , department
                )
                personList.add(person)

            } while (cursor.moveToNext())

        }

        cursor.close()
        database.close()
        return personList



    }

    fun getAllPeopleFromDatabase(): ArrayList<Employee> {

        val database = readableDatabase
        var personList: ArrayList<Employee> = ArrayList<Employee>()
        var person: Employee? = null


        val cursor = database.rawQuery(
            "SELECT * FROM $TABLE_NAME", null
        )

        if (cursor.moveToFirst()) {


            do {
                val firstName = cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME))
                val lastName = cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME))
                val address = cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS))
                val city = cursor.getString(cursor.getColumnIndex(COLUMN_CITY))
                val state = cursor.getString(cursor.getColumnIndex(COLUMN_STATE))
                val zip = cursor.getString(cursor.getColumnIndex(COLUMN_ZIP))
                val taxID = cursor.getString(cursor.getColumnIndex(COLUMN_TAXID))
                val position = cursor.getString(cursor.getColumnIndex(COLUMN_POSITION))
                val department = cursor.getString(cursor.getColumnIndex(COLUMN_DEPARTMENT))

                val person = Employee(
                    firstName, lastName, address, city, state, zip, taxID, position
                    , department
                )
                personList.add(person)

            } while (cursor.moveToNext())

        }

        cursor.close()
        database.close()
        return personList


    }

    fun updatePersonInDatabase(person: Employee) {

        val database = writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COLUMN_FIRSTNAME, person.firstName)
        contentValues.put(COLUMN_LASTNAME, person.lastName)
        contentValues.put(COLUMN_ADDRESS, person.address)
        contentValues.put(COLUMN_CITY, person.city)
        contentValues.put(COLUMN_STATE, person.state)
        contentValues.put(COLUMN_ZIP, person.zip)
        contentValues.put(COLUMN_TAXID, person.taxID)
        contentValues.put(COLUMN_POSITION, person.position)
        contentValues.put(COLUMN_DEPARTMENT, person.department)

        database.update(TABLE_NAME, contentValues, "$COLUMN_TAXID = ?", arrayOf(person.taxID))


        database.close()

    }

    fun removePersonFromDatabase(taxID: String) {

        val database = writableDatabase
        database.delete(TABLE_NAME, "$COLUMN_TAXID = ?", arrayOf(taxID))
        database.close()

    }
}