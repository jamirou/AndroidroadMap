package com.example.middlexmlhoroscopo.ui.horoscopo

import com.example.middlexmlhoroscopo.data.providers.HoroscopoProvider
import com.example.middlexmlhoroscopo.motherobject.HoroscopoMotherObject.horoscopoInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class HoroscopoViewModelTest {
    @MockK
    lateinit var horoscopoProvider: HoroscopoProvider

    private lateinit var viewModel: HoroscopoViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when ViewModel is created should get Horoscopo as a list`() {
        /*Given*/
        every { horoscopoProvider.getHoroscopo() } returns horoscopoInfoList
        viewModel = HoroscopoViewModel(horoscopoProvider)

        val horoscopes = viewModel.horoscopo.value
        assertTrue(horoscopes.isNotEmpty())
    }
}