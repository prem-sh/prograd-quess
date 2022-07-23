public class AbstractExperiment {
    public static void main(String[] args) {
        GamesTeacher shalini = new GamesTeacher("Kho-Kho");
        MathTeacher sankar = new MathTeacher("Coordinate Geometry");
        EnglishTeacher karthick = new EnglishTeacher("Active voice");
        System.out.println();
        System.out.println("shalini mam teaches "+shalini.subject);
        System.out.println("sankar sir teaches "+sankar.subject);
        System.out.println("karthick sir teaches "+karthick.subject);
    }
}

abstract class Teacher{
    String subject = "no subjects";
    Teacher(){
        System.out.print("Teacher => ");
    }
    Teacher(String subject){
        this.subject = subject;
    }
    abstract void command();
}

class GamesTeacher extends Teacher{
    GamesTeacher(String subject){
        super(subject);
        System.out.print("GamesTeacher\n");
    }
    @Override
    void command() {
        System.out.println("Get out to the Play ground !!");
    }
}

class MathTeacher extends Teacher{
    MathTeacher(String subject){
        super(subject);
        System.out.print("MathTeacher\n");
    }
    @Override
    void command() {
        System.out.println("Write 13 table 10 times in the rough note");
    }
}

class EnglishTeacher extends Teacher{
    EnglishTeacher(String subject){
        super(subject);
        System.out.print("EnglishTeacher\n");
    }
    @Override
    void command() {
        System.out.println("Sing the poem loudly !!");
    }
}