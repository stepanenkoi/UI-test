package ru.letu.ui.tests.oldtests.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import ru.letoile.android.format.DateTimeFormatPatterns.DAYS_MONTHS_YEARS_PATTERN_HYPHEN_SEPARATOR
import ru.letoile.android.format.DateTimeFormatUtils
import ru.letu.core.messaging.mindbox.data.MindboxPushDao
import ru.letu.core.messaging.mindbox.data.MindboxPushDatabase
import ru.letu.core.messaging.mindbox.data.MindboxPushItem
import java.util.Locale
import kotlin.random.Random

/**
 * Created by Vladislav Kochetov on 5/17/2023.
 */
@RunWith(AndroidJUnit4::class)
class MindboxPushDaoTest {

    private var db: MindboxPushDatabase? = null
    private var dao: MindboxPushDao? = null

    private fun formatMindboxPushDate(dateString: String) =
        DateTimeFormatUtils.parseDateTime(
            parseFormat = DateTimeFormatUtils.createDateTimeFormat(
                pattern = DAYS_MONTHS_YEARS_PATTERN_HYPHEN_SEPARATOR,
                locale = Locale("ru", "ru")
            ),
            dateString = dateString
        )?.time

    @Before
    fun setup() {
        // Create an in-memory Room database for testing
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), MindboxPushDatabase::class.java)
            .allowMainThreadQueries() // Allows database operations on the main thread (for testing purposes only)
            .build()
        dao = db?.mindboxPushDao()
    }

    @After
    fun tearDown() {
        // Clear and close the database after each test
        dao?.deleteAll()
        db?.close()
    }

    fun test_getAllByCategory() {
        val fakeCategoryId = Random.nextInt().toString()
        val fakeCategoryId2 = Random.nextInt().toString()
        val fakeCategoryId3 = Random.nextInt().toString()
        dao?.insert(MindboxPushItem(id = Random.nextInt().toString(), categoryId = fakeCategoryId))
        dao?.insert(MindboxPushItem(id = Random.nextInt().toString(), categoryId = fakeCategoryId))
        dao?.insert(MindboxPushItem(id = Random.nextInt().toString(), categoryId = fakeCategoryId2))
        dao?.insert(MindboxPushItem(id = Random.nextInt().toString(), categoryId = fakeCategoryId2))
        dao?.insert(MindboxPushItem(id = Random.nextInt().toString(), categoryId = fakeCategoryId3))
        dao?.insert(MindboxPushItem(id = Random.nextInt().toString(), categoryId = fakeCategoryId3))
        val pushItemList = dao?.getAllByCategory(fakeCategoryId2).orEmpty()
        assert(pushItemList.size == 2)
        assert(pushItemList.all { pushItem -> pushItem.categoryId == fakeCategoryId2 })
    }

    fun test_getAllFromDate() {
        val fakeDateOld = formatMindboxPushDate("01-04-2023") ?: 0L
        val fakeDateOld2 = formatMindboxPushDate("01-03-2023") ?: 0L
        val fakeDateOld3 = formatMindboxPushDate("01-05-2023") ?: 0L
        val fakeDateFresh = formatMindboxPushDate("01-05-2035") ?: 0L
        val fakeDateFresh2 = formatMindboxPushDate("01-05-2036") ?: 0L
        dao?.insert(MindboxPushItem(id = Random.nextInt().toString(), expirationDate = fakeDateOld))
        dao?.insert(MindboxPushItem(id = Random.nextInt().toString(), expirationDate = fakeDateOld2))
        dao?.insert(MindboxPushItem(id = Random.nextInt().toString(), expirationDate = fakeDateOld3))
        dao?.insert(MindboxPushItem(id = Random.nextInt().toString(), expirationDate = fakeDateFresh))
        dao?.insert(MindboxPushItem(id = Random.nextInt().toString(), expirationDate = fakeDateFresh2))
        val pushItemList = dao?.getAllFromDate(DateTimeFormatUtils.nowTime).orEmpty()
        assert(pushItemList.size == 2)
        assert(pushItemList.any { pushItem -> pushItem.expirationDate == fakeDateFresh })
        assert(pushItemList.any { pushItem -> pushItem.expirationDate == fakeDateFresh2 })
    }

    fun test_deleteUntilDate() {
        val fakeDateOld = formatMindboxPushDate("01-04-2023") ?: 0L
        val fakeDateOld2 = formatMindboxPushDate("30-04-2023") ?: 0L
        val fakeDateFresh = formatMindboxPushDate("01-05-2023") ?: 0L
        dao?.insert(MindboxPushItem(id = Random.nextInt().toString(), expirationDate = fakeDateOld))
        dao?.insert(MindboxPushItem(id = Random.nextInt().toString(), expirationDate = fakeDateOld2))
        dao?.insert(MindboxPushItem(id = Random.nextInt().toString(), expirationDate = fakeDateFresh))
        dao?.deleteUntilDate(fakeDateFresh)
        val pushItemList = dao?.getAll().orEmpty()
        assert(pushItemList.size == 1)
        assert(pushItemList.all { pushItem -> pushItem.expirationDate == fakeDateFresh })
    }
}
