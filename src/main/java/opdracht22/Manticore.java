package opdracht22;

public class Manticore extends HuntingTheManticoreGame{
    // define the properties of the new manticore:
    private String name;
    private int health;
    private int attackPower;

    // Constructor to assemble the object :
    public Manticore(String name, int health, int attackPower){
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
    public void attack(){
        System.out.println(name + "Charge with : " + attackPower + "!");
    }
    public int getHealth(){
        return health;
    }
    public void takeDamage(int damage){
        health -= damage;
        System.out.println(name + "takes " + damage + "damage! Health is now : " + health);
    }
}