package dev.enderman.thinking.concepts

interface Concept : Cloneable {
    public override fun clone(): Concept
}
