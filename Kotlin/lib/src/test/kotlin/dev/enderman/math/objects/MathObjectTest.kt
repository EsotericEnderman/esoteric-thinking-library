package dev.enderman.math.objects

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class MathObjectTest {

    private val myListA = MyList(1, 2)

    @Test fun equalityIsReflexive() {
        assertEquals(myListA, myListA, "MathObject equality is reflexive")
    }

    @Test fun objectsAreNeverEqualToNull() {
        val a: MyList? = null

        assertNotEquals(a, myListA, "MathObject instances are never equal to null")
    }

    @Test fun equalityWorks() {
        val myListB = MyList(1, 2)

        assertEquals(myListA, myListB, "MathObject equality should return 'true' when object values are equal")
    }

    @Test fun equalityAfterCloningWorks() {
        val myListC = MyList(42, 0)
        val myListD = myListC.clone()

        assertEquals(myListD, myListC, "MathObject equality should return 'true' after cloning")
    }

    private class MyList(a: Int, b: Int) : MathObject {

        val array: List<Int> = listOf(a, b);

        override fun clone(): MyList {
            return MyList(array[0], array[1])
        }

        override fun equals(other: Any?): Boolean {
            if (super.equals(other)) {
                return true
            }

            if (other !is MyList) {
                return false
            }

            return other.array == array
        }
    }
}
