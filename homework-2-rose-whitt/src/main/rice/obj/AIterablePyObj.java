package main.rice.obj;

import java.util.Collection;
import java.util.List;

/**
 * An abstract class representing an iterable Python object.
 *
 * @param <InnerType> the type of object contained within this iterable object
 */

// "InnerType" represents the type of APyObj instances contained
    // internal representation must be a Collection<InnerType>
    // must re-declare getValue() to return a Collection<InnerType>
// Serves as a superclass for two or more of the concrete classes
    // I have to decide which ones should extend it
// Design and implement this class first!!!!!! (before concretes)

public abstract class AIterablePyObj<InnerType extends APyObj> extends APyObj {

    /**
     * The value of this AIterablePyObj.
     */
    protected List<InnerType> list;

    /**
     * Default constructor for AIterablePyObj
     *
     * No parameters
     */
    public AIterablePyObj() {

    }

    /**
     * Constructor for a AIterablePyObj
     * Sets the field object to the value of the of the inputted List object
     *
     * @param list a list representing the value of this PyListObj
     */
    public AIterablePyObj(List<InnerType> list) {
        this.list = list;
    }

    /**
     * @return the Java collection representing this iterable object
     */
    @Override
    public Collection<InnerType> getValue() {
        return this.list;
    }
}