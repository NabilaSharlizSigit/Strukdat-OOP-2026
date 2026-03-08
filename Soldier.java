class Soldier extends Character{
    
    public Soldier(String name){
        super(name, "Wanted", 100);
    }
    
    @Override
    void Duo(){
        System.out.println("I'm Here");
    }
}