package com.example.roomkotlindemo

/*
*    1. FirstName
    2. LastName
    3. StreetAddress
    4. City
    5. State
    6. Zip
    7. TaxID
    8. Position
    9. Department
* */

const val DATABASE_NAME = "data_per_database"
const val TABLE_NAME = "employee"
const val DATABASE_VERSION = 1

const val COLUMN_FIRSTNAME = "first_name"
const val COLUMN_LASTNAME = "last_name"
const val COLUMN_ADDRESS = "address"
const val COLUMN_CITY = "city"
const val COLUMN_STATE = "state"
const val COLUMN_ZIP = "zip"
const val COLUMN_TAXID = "taxID"
const val COLUMN_POSITION = "position"
const val COLUMN_DEPARTMENT = "department"


const val CREATE_PERSON_TABLE =
        " CREATE TABLE $TABLE_NAME (" +
        "$COLUMN_FIRSTNAME String," +
        "$COLUMN_LASTNAME String," +
        "$COLUMN_ADDRESS String, " +
        "$COLUMN_CITY String," +
        "$COLUMN_STATE String," +
        "$COLUMN_ZIP String," +
        "$COLUMN_TAXID String PRIMARY_KEY," +
        "$COLUMN_POSITION String," +
        "$COLUMN_DEPARTMENT String" +
        ")"
