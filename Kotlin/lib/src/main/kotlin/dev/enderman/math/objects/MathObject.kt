package dev.enderman.math.objects

abstract class MathObject : Comparable<MathObject>, Cloneable {
    abstract override fun equals(other: Any?): Boolean
    abstract override fun clone(): MathObject
}
