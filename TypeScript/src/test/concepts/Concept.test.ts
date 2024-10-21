import { Concept } from "../../main/concepts/Concept";

class MyList extends Concept {

    public readonly list: number[] = [];

    constructor(a: number, b: number) {
        super();
        this.list = [a, b];
    }

    public equals(otherConcept: Concept): boolean {
        if (super.equals(otherConcept)) {
            return true;
        }

        if (!(otherConcept instanceof MyList)) {
            return false;
        }

        return otherConcept.list[0] === this.list[0] && otherConcept.list[1] === this.list[1];
    }

    public clone(): this {
        return new MyList(this.list[0], this.list[1]) as this;
    }
}

describe("Concept", () => {
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

    it("Clones to an equal concept", () => {
        const listC = new MyList(42, 0);
        const listD = listC.clone();
        expect(listC.equals(listD)).toBe(true);
    })
});
