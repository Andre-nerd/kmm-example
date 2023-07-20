package com.example.kmm_example.data_base

import com.example.kmmexample.database.ItemRecord


internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    //        val androidSqlDriver = AndroidSqliteDriver(
    //            schema = Database.Schema,
    //            context = applicationContext,
    //            name = "items.db"
    //        )
    //
    //        queries = Database(androidSqlDriver).itemInCartEntityQueries
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.itemRowDataQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.clearDatabase()
        }
    }

    internal fun getAllLaunches(): List<ItemRecord> {
        return dbQuery.selectAll().executeAsList()
    }

    internal fun insert(itemRecord: ItemRecord){
        dbQuery.insertOrReplace(
            image = itemRecord.image,
            quantity = itemRecord.quantity,
            url = itemRecord.url,
        )
    }

//    private fun mapLaunchSelecting(
//        flightNumber: Long,
//        missionName: String,
//        details: String?,
//        launchSuccess: Boolean?,
//        launchDateUTC: String,
//        patchUrlSmall: String?,
//        patchUrlLarge: String?,
//        articleUrl: String?
//    ): RocketLaunch {
//        return RocketLaunch(
//            flightNumber = flightNumber.toInt(),
//            missionName = missionName,
//            details = details,
//            launchDateUTC = launchDateUTC,
//            launchSuccess = launchSuccess,
//            links = Links(
//                patch = Patch(
//                    small = patchUrlSmall,
//                    large = patchUrlLarge
//                ),
//                article = articleUrl
//            )
//        )
//    }

//    internal fun createLaunches(launches: List<RocketLaunch>) {
//        dbQuery.transaction {
//            launches.forEach { launch ->
//                insertLaunch(launch)
//            }
//        }
//    }

//    private fun insertLaunch(launch: RocketLaunch) {
//        dbQuery.insertLaunch(
//            flightNumber = launch.flightNumber.toLong(),
//            missionName = launch.missionName,
//            details = launch.details,
//            launchSuccess = launch.launchSuccess ?: false,
//            launchDateUTC = launch.launchDateUTC,
//            patchUrlSmall = launch.links.patch?.small,
//            patchUrlLarge = launch.links.patch?.large,
//            articleUrl = launch.links.article
//        )
//    }
}