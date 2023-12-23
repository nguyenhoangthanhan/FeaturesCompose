package com.nguyenhoangthanhan.authmodule.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class StringExtensionTest {

    @Test
    fun `test string contains no number returns false when check for it`(){
        val result = "NoNumber".containsNumbers()
        assertThat(result).isFalse()
    }

    @Test
    fun `test string contains a number returns true when check for it`(){
        val result = "No5Number".containsNumbers()
        assertThat(result).isTrue()
    }

    @Test
    fun `test string contains no upper case returns false when check for it`(){
        val result = "number".containsUppersCase()
        assertThat(result).isFalse()
    }

    @Test
    fun `test string contains an upper case returns true when check for it`(){
        val result = "No5Number".containsUppersCase()
        assertThat(result).isTrue()
    }

    @Test
    fun `test string contains no special char returns false when check for it`(){
        val result = "nsdumber".containsSpecialChar()
        assertThat(result).isFalse()
    }

    @Test
    fun `test string contains a special char returns true when check for it`(){
        val result = "nsdumSbe!r".containsSpecialChar()
        assertThat(result).isTrue()
    }
}