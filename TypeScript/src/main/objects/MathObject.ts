export abstract class MathObject {

    public equals(otherObject: MathObject): boolean {
        return otherObject === this;
    };

    public abstract clone(): typeof this;
}
