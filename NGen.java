// NGen.java
// This class was not written by me and was taken off of the CSCI 1933 Spring 2020 canvas page

public class NGen <T> {
  
    // constructors
    
    public NGen () {}

    public NGen (T o, NGen<T> link) {
        data = o;
        next = link;
    }

    // selectors

    public T getData() {
        return data;
    }

    public void setData(T o) {
        data = o;
    }

    public NGen<T> getNext() {
        return next;
    }

    public void setNext(NGen<T> link) {
        next = link;
    }

    // instance variables

    private T data;
    private NGen<T> next;

}  // NGen class
