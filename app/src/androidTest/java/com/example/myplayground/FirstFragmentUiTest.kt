package com.example.myplayground

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.filters.LargeTest
import com.example.myplayground.fragment.FirstFragment
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import org.junit.Test

class FragmentOneScreen : Screen<FragmentOneScreen>() {
    val imageView = KImageView {
        withId(R.id.imageView)
    }
    val buttonToMainActivity2 = KButton {
        withId(R.id.buttonToMainActivity2)
    }
}

@LargeTest
class FragmentOneUiTest {

    @Test
    fun fragmentOneNotCrash() {
        val scenario = launchFragmentInContainer<FirstFragment>(
            initialState = Lifecycle.State.INITIALIZED
        )
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

//    @Test
//    fun imageView_shouldNotDisplayed() {
//        secondScreen {
//            imageView.isNotDisplayed()
//        }
//    }
}