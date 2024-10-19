package dev.enderman.math.objects

abstract class MathObject : Comparable<MathObject>, Cloneable {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
    abstract override fun clone(): MathObject
}
