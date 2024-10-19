package dev.enderman.math.objects

interface MathObject : Comparable<MathObject>, Cloneable {
    override fun equals(other: Any?): Boolean
    override fun clone(): MathObject
}
