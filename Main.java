public class Main {
    public static void main(String[] args) throws Exception {
        Character female = new Medic("Rebecca Chambers");
        Character male = new Soldier("Billy Coen");

        female.charaInfo();
        female.Duo();

        male.charaInfo();
        male.Duo();
    }
}
