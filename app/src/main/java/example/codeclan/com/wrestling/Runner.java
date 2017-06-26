package example.codeclan.com.wrestling;

import java.util.Scanner;

import static example.codeclan.com.wrestling.Subject.getCouselorDetails;

/**
 * Created by michaelrobertson on 26/06/2017.
 */

public class Runner {



    public static void main(String[] args) {

//        Councelor.deleteAll();
//        Subject.deleteAll();

        Subject.all();

        Scanner reader = new Scanner(System.in);
        System.out.println("Please Choose the id of the Counselor you require.");
        int n = reader.nextInt();
        System.out.println(getCouselorDetails(n));
    }

}
