package main.rice.obj;

import java.util.List;

public class PyListObj<InnerType extends APyObj> extends AIterablePyObj<InnerType> {

    /**
     * Constructor for a PyListObj; calls the superclass to initialize value of list.
     *
     * @param listParam a list representing the value of this PyListObj
     */
    public PyListObj(List<InnerType> listParam) {
        // call to super
        super(listParam);
    }



    /**
     * Builds and returns a string representation of this object that mirrors the Python
     * string representation.
     *
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        return list.toString();
    }


    /**
     * Compares this to the input object by value.
     * Used when comparing PyListObj and PyTupleObj because both of them have an internal
     * representation of a List, but they should not be equal due to their
     * Python difference.
     *
     * @param obj the object to compare against
     * @return true if this is equivalent by value to obj; false otherwise
     */
    public boolean equals(Object obj) {
        // check that is an instance of PyListObj
        if (!(obj instanceof PyListObj)) {
            // if not, return false
            return false;
        }

        // Compare by value
        return this.getValue().equals(((APyObj) obj).getValue());
    }
}
