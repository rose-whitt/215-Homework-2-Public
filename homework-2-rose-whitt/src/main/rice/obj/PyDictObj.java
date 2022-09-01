package main.rice.obj;

import java.util.*;

public class PyDictObj<KeyType extends APyObj, ValType extends APyObj> extends APyObj {
    /**
     * The value of this PyDictObj.
     */
    private Map<KeyType, ValType> map;

    /**
     * Constructor for a PyDictObj; initializes its value to a dict of the input.
     *
     * @param mapParam a Map representing the value of this PyDictObj
     */
    public PyDictObj(Map<KeyType, ValType> mapParam) {
        this.map = mapParam;
    }

    /**
     * Declared as a Map and return as a Map
     * @return the underlying (Java) representation of this Python object
     */
    @Override
    public Map<KeyType, ValType> getValue() {
        return this.map;
    }

    /**
     * Builds and returns a string representation of this object that mirrors the Python
     * string representation.
     *
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        // build a string so we can properly format the dictionary
        StringBuilder str = new StringBuilder();
        str.append("{");
        int size = this.getValue().size();
        // counter so we can keep track of how far into the dictionary we are since dictionaries are not ordered
        int j = 0;

        // iterate over elements of the dictionary
        for (Map.Entry<KeyType, ValType> entry : this.getValue().entrySet()) {
            // add the key value pair with the python formatting
            str.append(entry.getKey());
            str.append(": ");
            str.append(entry.getValue());

            // we do not want to add a ", " when we are at the end of the dictionary
            if (j < size - 1) {
                str.append(", ");
            }
            // up the counter
            j++;
        }

        // properly format the last key value pair and end the dictionary formatting
        str.append("}");

        // convert the string builder to a string and return
        return str.toString();
    }
}
