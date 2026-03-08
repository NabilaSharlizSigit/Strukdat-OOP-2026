class Medic extends Character{
    
    public Medic(String name){
        super(name, "Medic", 80);
    }
    
    @Override
    void Duo(){
        System.out.println("Billy!");
    }
}