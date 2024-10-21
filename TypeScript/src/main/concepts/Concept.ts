export abstract class Concept {

    public equals(otherConcept: Concept): boolean {
        return otherConcept === this;
    };

    public abstract clone(): typeof this;
}
