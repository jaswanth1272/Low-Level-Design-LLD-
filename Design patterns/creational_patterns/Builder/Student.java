public class Student {
    private String name;
    private int age;
    private String address;
    private String major;
    private int marks;
    private String club1;
    private String club2;
    private String job;

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.major = builder.major;
        this.marks = builder.marks;
        this.club1 = builder.club1;
        this.club2 = builder.club2;
        this.job = builder.job;
    }

    public static class Builder {
        private String name;
        private int age;
        private String address;
        private String major;
        private int marks;
        private String club1;
        private String club2;
        private String job;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder major(String major) {
            this.major = major;
            return this;
        }

        public Builder marks(int marks) {
            this.marks = marks;
            return this;
        }

        public Builder club1(String club1) {
            this.club1 = club1;
            return this;
        }

        public Builder club2(String club2) {
            this.club2 = club2;
            return this;
        }

        public Builder job(String job) {
            this.job = job;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Address: " + address + ", Major: " + major);
    }
}

