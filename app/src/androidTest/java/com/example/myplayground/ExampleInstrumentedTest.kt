package com.example.myplayground

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.myplayground", appContext.packageName)
    }
}

class MainScreen : Screen<MainScreen>() {
    val textViewHello = KView{
        withId(R.id.textViewHello)
    }
    val imageView = KImageView{
        withId(R.id.imageView)
    }
//    val textViewStoreComingSoon = KTextView{
//        withId(R.id.textViewStoreComingSoon)
//    }
//    val textViewStoreComingSoonDesc = KTextView{
//        withId(R.id.textViewStoreComingSoonDesc)
//    }
//    val buttonContinue = KButton { withId(RCoreId.buttonContinue) }
//    //    val buttonAddToCart = KButton { withId(RCoreId.buttonCheckout) }
//    val snackbar = KView {
//        withId(RCoreId.snackbar_action)
//    }
}

@LargeTest
class SearchUITests {

    @Rule
    @JvmField
    var rule = ActivityScenarioRule(MainActivity::class.java)

    private val screen = MainScreen()

    @Test
    fun search_withEmptyText_shouldShowSnackbarError() {
        screen {
            textViewHello.isDisplayed()
            imageView.isDisplayed()
//            textViewStoreComingSoon.isDisplayed()
//            textViewStoreComingSoonDesc.isDisplayed()
//            buttonContinue.isDisplayed()
//            buttonAddToCart.isDisplayed()
//            searchButton.click()
//            snackbar.isNotDisplayed()
//            recentButton.isDisplayed()
        }
    }

    @Test
    fun textViewHello_shouldNotDisplayed() {
        screen {
            val a  = textViewHello.isNotDisplayed()
            val b  = imageView.isNotDisplayed()
//            textViewStoreComingSoon.isDisplayed()
//            textViewStoreComingSoonDesc.isDisplayed()
//            buttonContinue.isDisplayed()
//            buttonAddToCart.isDisplayed()
//            searchButton.click()
//            snackbar.isNotDisplayed()
//            recentButton.isDisplayed()
        }
    }
}
