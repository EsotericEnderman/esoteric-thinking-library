package dev.enderman.math.objects

interface MathObject {
    fun equals(otherObject: MathObject?): Boolean
    fun clone(): MathObject?
}
