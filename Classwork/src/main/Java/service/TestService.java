package service;

import model.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestService {
    private static List<Test>testList = new ArrayList<Test>(Arrays.asList(
            new Test(1, "name1"),
            new Test(2, "name2"),
            new Test(3, "name3"),
            new Test(4, "name4")
    ));
    public List<Test> getTestList(){
        return testList;
    }
    public Test creaTest(Test test){
        testList.add(test);
        return test;
    }
    public Optional<Test> getTestById(int id){
        return testList.stream().filter(t -> t.getId() == id).findFirst();
    }
}
