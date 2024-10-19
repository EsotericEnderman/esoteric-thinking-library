export abstract class MathObject {
    public equals(otherObject: MathObject): boolean {
        return otherObject === this;
    };

    abstract clone(): typeof this;
}
