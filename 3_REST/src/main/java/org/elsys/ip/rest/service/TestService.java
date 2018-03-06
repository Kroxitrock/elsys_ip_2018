package org.elsys.ip.rest.service;

import org.elsys.ip.rest.model.Test;
import org.elsys.ip.rest.repository.TestRepository;
import org.elsys.ip.rest.repository.TestRepositoryHibernate;
import org.elsys.ip.rest.repository.TestRepositoryJdbc;

import java.util.List;

public class TestService {

  private TestRepository testRepository = new TestRepository();
  private TestRepositoryHibernate testRepositoryJdbc = new TestRepositoryHibernate();

  public List<Test> getTestList() {
    return testRepositoryJdbc.getTestList();
  }

  public Test getTestById(Integer id) {
    return testRepositoryJdbc.getTestById(id).orElse(null);
  }

  public Test saveTest(Test test) {
    return testRepository.saveTest(test);
  }

  public Test updateTest(Integer id, Test test) {
    return testRepository.updateTest(id, test);
  }

  public void deleteTest(Integer id) {
    testRepository.deleteTest(id);
  }

  public void addEmpty(){testRepositoryJdbc.addEmpty();}
}
