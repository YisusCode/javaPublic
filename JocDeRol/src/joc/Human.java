package joc;

/**
 *
 * @author Jesus Sala -- 1DamSemi
 */
public class Human extends Player {
    public Human(String name, int attackPoints, int defensePoints, int life){
        super(name,attackPoints,defensePoints, life);
        System.out.println("He creat un "+"Human");
    }
}
