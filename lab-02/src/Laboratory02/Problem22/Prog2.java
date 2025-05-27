package Laboratory02.Problem22;

import static Laboratory02.Problem22.RandomNumbers.getRandomInt;

/*

### Program 2-2
Create a class called Prog2. In the main method of the class, output to the console the
result of doing the following two computations:
1. get a random number x in the range 1 .. 9 and compute πx
   .
2. get a random number y in the range 3 .. 14 and compute yπ
   .
   Use the RandomNumbers.java class that has been provided for you. (Do not use the
   Random class directly.)

 */
public class Prog2 {
    int x = (int) (Math.PI *  getRandomInt(1,9));
    int y = (int) (Math.PI *  getRandomInt(3,14));

    public void Prog2_ToString(){
        System.out.println("a random number x in the range 1 .. 9 and compute πx: "+ x);
        System.out.println("a random number y in the range 3 .. 14 and compute yπ: "+ y);

    }

}
