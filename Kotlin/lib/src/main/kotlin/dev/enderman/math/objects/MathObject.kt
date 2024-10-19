package dev.enderman.math.objects

abstract class MathObject : Cloneable {
    abstract override fun clone(): MathObject
}
