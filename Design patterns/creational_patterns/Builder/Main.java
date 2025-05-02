public class Main {
    public static void main(String[] args) {
        Student student = new Student.Builder("John", 21)
                            .address("New York")
                            .major("Computer Science")
                            .marks(90)
                            // .club1("Chess Club") --> optional field
                            .build();
        
        student.display();
    }
}