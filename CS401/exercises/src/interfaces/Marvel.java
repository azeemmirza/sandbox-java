package interfaces;

import java.util.ArrayList;

public class Marvel implements ComicBook {
    @Override
    public void print() {
        System.out.println("Marvel");
    }

    @Override
    public void interfaceAbstractMethod() {
        System.out.println("Marvel interfaceAbstractMethod");
    }

    public void classMethod() {
        System.out.println("Marvel classMethod");
    }
}
