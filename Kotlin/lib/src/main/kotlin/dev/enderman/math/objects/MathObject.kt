package dev.enderman.math.objects

interface MathObject : Cloneable {
    override fun clone(): MathObject
}
