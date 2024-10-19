export interface MathObject {
    equals(otherObject: MathObject): boolean;
    clone(): typeof this;
}
