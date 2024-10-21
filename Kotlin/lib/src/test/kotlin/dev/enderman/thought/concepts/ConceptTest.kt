package dev.enderman.thought.concepts

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class ConceptTest {

    private val myListA = MyList(1, 2)

    @Test fun equalityIsReflexive() {
        assertEquals(myListA, myListA, "Concept equality is reflexive")
    }

    @Test fun objectsAreNeverEqualToNull() {
        val a: Any? = null

        assertNotEquals(a, myListA, "Concept instances are never equal to null")
    }

    @Test fun equalityWorks() {
        val myListB = MyList(1, 2)

        assertEquals(myListA, myListB, "Concept equality should return 'true' when concept values are equal")
    }

    @Test fun cloningCreatesAnEqualObject() {
        val myListC = MyList(42, 0)
        val myListD = myListC.clone()

        assertEquals(myListD, myListC, "Concept equality should return 'true' after cloning")
    }

    private class MyList(a: Int, b: Int) : Concept {

        val array: List<Int> = listOf(a, b)

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

        override fun hashCode(): Int {
            return array.hashCode()
        }
    }
}
