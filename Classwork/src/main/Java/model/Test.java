package model;

public class Test {
    public int id;
    private String name;

    public Test(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Test(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
