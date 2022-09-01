package main.rice.obj;

import java.util.Collection;
import java.util.Set;

public class PySetObj<InnerType extends APyObj> extends APyObj {
    /**
     * The value of this PySetObj.
     */
    private Set<InnerType> set;

    /**
     * Constructor for a PySetObj.
     * Sets the field object, set, to the parameter setParam.
     * Initializes the object with the input.
     *
     * @param setParam a set representing the value of this PySetObj
     */
    public PySetObj(Set<InnerType> setParam) {
        this.set = setParam;
    }

    /**
     * Declared to return a Collection but should actually return a set
     * Set extends Collection
     *
     * @return the underlying (Java) representation of this Python object
     */
    @Override
    public Collection<InnerType> getValue() {
        return this.set;
    }

    /**
     * Builds and returns a string representation of this object that mirrors the Python
     * string representation.
     *
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        if (this.getValue().size() == 0) {
            return "set()";
        }
        // build a string builder so we can properly format
        StringBuilder str = new StringBuilder();
        // add beginning before iterating
        str.append("{");
        // get size of set since order does not matter in sets so you cannot call by index
        int size = this.set.size();
        // create counter for reason above
        int j = 0;
        // iterate over each object in the set to add to str
        for (Object i : this.set) {
            // you always want to append your object
            str.append(i);
            // we want to do different things based off of two cases
            if (j < size - 1) {
                // if we aren't at the end of the set, we simply continue with the normal inner
                // set python syntax
                str.append(", ");

            }
            // always up your counter
            j++;

        }
        // if we are, we want to end the list with a square bracket rather than the comma and space
        str.append("}");
        // return the string builder as a string
        return str.toString();
    }
}
