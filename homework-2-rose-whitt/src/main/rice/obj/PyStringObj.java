package main.rice.obj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PyStringObj extends AIterablePyObj {
    /**
     * The value of this PySetObj as a list of PyCharObj.
     */
    private List<PyCharObj> charList;

    /**
     * Constructor for a PyStringObj with List type parameter
     * Initializes the charList List (type: PyCharObj)
     *
     * @param charList a list representing the value of this PyCharObj
     */
    public PyStringObj(List<PyCharObj> charList) {
        this.charList = charList;
    }

    /**
     * Constructor for a PyStringObj
     * Initialize String
     * Create charList of characters in the string
     *
     * @param str a string representing the value of this PyStringObj
     */
    public PyStringObj(String str) {
        // initialize the charList List
        this.charList = new ArrayList<>();
        // iterate over the characters of the string
        for (int i = 0; i < str.length(); i++) {
            // get the character from the string at the current index
            // make the character a PyCharObj
            // add the PyCharObj to charList
            this.charList.add(new PyCharObj(str.charAt(i)));
        }
//        this.pyString = str;
    }

    /**
     * Declare to return a Collection of PyCharObjs but actually return a List of PyCharObjs
     *
     * @return the underlying (Java) representation of this Python object
     */
    @Override
    public Collection<PyCharObj> getValue() {
        return this.charList;
    }

    /**
     * Builds and returns a string representation of this object that mirrors the Python
     * string representation.
     *
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        // create string and initialize it with the value '
        // because you want the string to have a ' and ' at the beginning and end
        String str = "'";
        // iterate over each character in the charList
        for (PyCharObj charEntry : this.charList) {
            // add each character in the charList
            // get the character at index 1 because the toString() causes the character
            // to have "" surrounding the character and we only want the character itself
            str += charEntry.toString().charAt(1);
        }
        // add the ' to the end
        str += "'";
        // return the string!
        return str;
    }
}
