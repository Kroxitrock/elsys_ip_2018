package resources;

import model.Test;
import service.TestService;

import javax.ws.rs.*;
import java.util.List;
import java.util.Optional;

@Path("/test")
public class TestResource {
    private TestService testService = new TestService();

    @GET
    @Produces("application/json")
    public List<Test> getTests(){
        return testService.getTestList();
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Test getTests(@PathParam("id") int id, @QueryParam("query") String query){
        Optional<Test> opt =  testService.getTestById(id);
        if(opt.isPresent()){
            return opt.get();
        } else {
            return null;
        }
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Test createTest(Test test){
        return testService.creaTest(test);
    }

}
