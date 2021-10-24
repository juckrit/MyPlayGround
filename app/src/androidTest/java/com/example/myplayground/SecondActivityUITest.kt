package com.example.myplayground

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.intent.KIntent
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import org.junit.Rule
import org.junit.Test


class SecondScreen : Screen<SecondScreen>() {
    //    val textViewHello = KView {
//        withId(R.id.imageView)
//    }
    val imageView = KImageView {
        withId(R.id.imageView)
    }
    val buttonToMainActivity2 = KButton {
        withId(R.id.buttonToMainActivity2)
    }

//    val textViewStoreComingSoon = KTextView{
//        withId(R.id.textViewStoreComingSoon)
//    }
//    val textViewStoreComingSoonDesc = KTextView{
//        withId(R.id.textViewStoreComingSoonDesc)
//    }
//    val buttonContinue = KButton { withId(RCoreId.buttonContinue) }
//    val snackbar = KView {
//        withId(RCoreId.snackbar_action)
//    }
}

@LargeTest
class SecondActivityUITest {

    @Rule
    @JvmField
    var rule = ActivityScenarioRule(SecondActivity::class.java)

    private val secondScreen = SecondScreen()

    @Test
    fun imageView_shouldDisplayed() {
        secondScreen {
            imageView.isDisplayed()
        }
    }

    @Test
    fun imageView_shouldNotDisplayed() {
        secondScreen {
            imageView.isNotDisplayed()
        }
    }
}