abstract class Character {
    protected String name;
    protected String role;
    private int health;     

    public Character(String name, String role, int health){
        this.name=name;
        this.role=role;
        setHealth(health);
    }

    public void setHealth(int health){
        if(health<0){
            this.health=0;
        } else if(health>100){
            this.health=100;
        } else{
            this.health=health;
        }
    }

    public int getHealth(){
        return health;
    }

    abstract void Duo();

    public void charaInfo(){
        System.out.println("Name : " + name + ", Role : " + role + ", HP : " + health);
    }
}
