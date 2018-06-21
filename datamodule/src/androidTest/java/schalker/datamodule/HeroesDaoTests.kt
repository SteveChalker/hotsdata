package schalker.datamodule

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import schalker.datamodule.local.AppDatabase
import schalker.datamodule.local.HeroesDao
import schalker.datamodule.models.Hero
import kotlin.jvm.java


@RunWith(AndroidJUnit4::class)
class HeroesDaoTests {
    lateinit var heroDao: HeroesDao
    lateinit var appDatabase: AppDatabase

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries().build()
        heroDao = appDatabase.heroDao()
    }

    @After
    fun closeDb() {
        appDatabase.close()
    }

    @Test
    fun insert_one_hero() {
        val name = "Test Hero"
        val hero = Hero(name = name)
        heroDao.insertHero(hero)

        val heroList = heroDao.getHeroByName(name).blockingObserve()
        assertThat(heroList?.size, equalTo(1))
        assertThat(heroList?.get(0)?.name, equalTo(name))
    }
}