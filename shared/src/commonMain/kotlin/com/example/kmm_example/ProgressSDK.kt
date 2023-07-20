package com.example.kmm_example

import com.example.kmm_example.data_base.Database
import com.example.kmm_example.data_base.DatabaseDriverFactory
import com.example.kmmexample.database.ItemRecord


class ProgressSDK (databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
//    private val api = SpaceXApi()

//    @Throws(Exception::class) suspend fun getLaunches(forceReload: Boolean): List<RowData> {
//        val cachedLaunches = database.getAllLaunches()
//        return if (cachedLaunches.isNotEmpty() && !forceReload) {
//            cachedLaunches
//        } else {
////            api.getAllLaunches().also {
////                database.clearDatabase()
////                database.createLaunches(it)
////            }
//            emptyList()
//        }
//    }

    suspend fun clearDatabase(){
        database.clearDatabase()
    }

    suspend fun addItem(item: ItemRecord){
        database.insert(item)
    }

    suspend fun getAllLaunches(): List<ItemRecord> {
        return database.getAllLaunches()
    }
}
