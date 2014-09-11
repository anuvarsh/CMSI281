package edu.lmu.cmsi.mike.packageperson;

/* Our Person representation, in a Java package */
public class Person {

    private int age;
    private String firstName;
    private String lastName;
    private int leftFootSize;
    private int rightFootSize;
    private boolean leftFootLifted;
    private boolean rightFootLifted;

    public Person(int age, String fn, String ln, 
                  int leftFootSize, int rightFootSize, 
                  boolean leftFootLifted, boolean rightFootLifted) {
      
        this.age = age;
        this.firstName = fn;
        this.lastName = ln;
        this.rightFootSize = rightFootSize;
        this.leftFootSize = leftFootSize;
        this.leftFootLifted = leftFootLifted;
        this.rightFootLifted = rightFootLifted;
        this.checkAge();
    }

    public int getAge() {
        return this.age;
    }

    /* Increments the age and checks to make
     * sure it's still in a valid range */
    public void birthday() {
        this.age++;
        this.checkAge();
    }

    public String getFn() {
        return this.firstName;
    }

    public String getLn() {
        return this.lastName;
    }

    public int getRightFootSize() {
        return this.rightFootSize;
    }

    public int getLeftFootSize() {
        return this.leftFootSize;
    }

    public boolean isLeftFootLifted() {
        return this.leftFootLifted;
    }

    public boolean isRightFootLifted() {
        return this.rightFootLifted;
    }

    /* Is the age still correct? */
    private void checkAge() {
        if(this.age > 150) {
            throw new IllegalArgumentException("Age: " + this.age + " is too high.");
        }
    }

    /* Ugh this should not be here. We'll fix this soon enough */
    public static void main(String[] args) {
        Person p = new Person(99, "Mike", "Megally", 10, 10, true, false);
        System.out.println(p.getFn() + " " + p.getLn());
        System.out.println(p.getAge());
        p.birthday();
        System.out.println(p.getAge());
    }
}