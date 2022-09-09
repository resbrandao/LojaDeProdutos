package br.com.fiap.lojadeprodutos

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DetalheProdutoActivityTest {

    @Test
    fun test_activityEstaVisivel() {
        val activityCenario = ActivityScenario.launch(DetalheProdutoActivity::class.java)
        onView(withId(R.id.detalhe_produto)).check(matches(isDisplayed()))
    }

    @Test
    fun test_botaoNaoEstaHabilitado() {
        val activityCenario = ActivityScenario.launch(DetalheProdutoActivity::class.java)
        onView(withId(R.id.button_carrinho)).check(matches(isNotEnabled()))
    }
}

