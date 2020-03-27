package joc;

/**
 *
 * @author Jesus Sala -- 1DamSemi
 */
public abstract class Player {

    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;

    public Player(String name, int attackPoints, int defensePoints, int life) {
        System.out.println("He creat un " + "Player");
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public int getLife() {
        return life;
    }

    /**
     * *
     * Efectua un atack, fa verificacions per comprovar si els jugadors estan
     * vius i en cas afirmatiu ataca depres de cada atac si el objectiu esta
     * encara viu (life>0) fa un contratack. S'utilitza el metode hit per a
     * modificar la vida
     *
     * @param p Un objecte de tipus Player, es a dir cualsevol personatje del
     * joc
     */
    public void attack(Player p) {
        //Si els 2 players implicats estan vius efectua l'atac
        if (life > 0 && p.getLife() > 0) {
            //ABANS DE L'ATAC
            System.out.println("---------------------------\n" + this.toString() + "\n" + p.toString() + "\n---------------------------");
            //ATAC
            p.hit(this.attackPoints);
            if (p.getLife() > 0) {
                this.hit(p.getAttackPoints());
            }
            //DESPRES DE L'ATAC
            System.out.println("---------------------------\n" + this.toString() + "\n" + p.toString());
            //Si algun dels 2 esta mort no ni ha atac, verifica quin es i mostra un avis 
        } else {
            if (life == 0) {
                System.out.println(name + " està mort, no pot atacar.");
            }
            if (p.getLife() == 0) {
                System.out.println(p.getName() + " està mort, no pot atacar.");
            }
        }
    }

    /**
     * *
     * Metode per a rebre un atac, no acepta numeros negatius, fa el calcul
     * imprimix un misatge i modifica la variable life amb la nova vida del
     * player
     *
     * @param attackPoints Punts de atac del player que fa l'atac.
     */
    protected void hit(int attackPoints) {
        //Verifica que el int del atac no un un numero negatiu
        if (attackPoints > 0) {
            int dany = attackPoints - defensePoints;
            // Si la vida despres del atac es superior a 0 mostra ixe numero sino mostra 0
            if (life - dany > 0) {
                System.out.println(name + " és colpejat amb " + attackPoints + " punts i es defén amb " + defensePoints + ".  Vides: " + life + " - " + dany + " = " + (life - dany));
                life -= dany;
            } else {
                System.out.println(name + " és colpejat amb " + attackPoints + " punts i es defén amb " + defensePoints + ".  Vides: " + life + " - " + dany + " = " + 0);
                life = 0;
                System.out.println(name + " esta mort, descansa en pau.");
            }
        } else {
            //Misatge per a parametre d'atac negatiu.
            System.out.println("El parametre d'atac es negatiu...tramposet");
        }
    }

    @Override
    public String toString() {
        return name + " PA:" + attackPoints + " / PD:" + defensePoints + " / PV:" + life;
    }
}
