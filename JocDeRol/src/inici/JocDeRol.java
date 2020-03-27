package inici;

import io.*;
import joc.*;

public class JocDeRol {

    public static void main(String[] args) {
    provaFase();
    }
    public static void provaFase(){
       Human p1=new Human("Manolo Garcia",10,2,30);
       Warrior p2=new Warrior("Maximo Decimo Meridio",15,4,18);
       Alien p3=new Alien("John Carter",12,5,32);
       
        System.out.println("Atack 1");
       p1.attack(p2);
        System.out.println("Atack 2");
       p1.attack(p2);
        System.out.println("Atack 3");
       p1.attack(p2);
        System.out.println("Atack 4");
       p1.attack(p2);
        System.out.println("Atack 5");
       p3.attack(p1);
    }

}
