import {MathObject} from "../../main/objects/MathObject";

class MyList extends MathObject {

    public readonly list: number[] = [];

    constructor(a: number, b: number) {
        super();
        this.list = [a, b];
    }

    public equals(otherObject: MathObject): boolean {
        if (super.equals(otherObject)) {
            return true;
        }

        if (!(otherObject instanceof MyList)) {
            return false;
        }

        return otherObject.list[0] === this.list[0] && otherObject.list[1] === this.list[1];
    }

    public clone(): this {
        return new MyList(this.list[0], this.list[1]) as this;
    }
}

describe("MathObject", () => {
    const listA = new MyList(1, 2);

    it("Implements reflexive equality", () => {
        expect(listA.equals(listA)).toBe(true);
    })

    it("Doesn't equal to null", () => {
        expect(listA.equals(null)).toBe(false);
    });

    it("Implements equality correctly", () => {
        const listB = new MyList(1, 2);
        expect(listA.equals(listB)).toBe(true);
    })

    it("Clones to an equal object", () => {
        const listC = new MyList(42, 0);
        const listD = listC.clone();
        expect(listC.equals(listD)).toBe(true);
    })
});
