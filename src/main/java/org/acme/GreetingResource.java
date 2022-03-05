package org.acme;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.Employee;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLEnumType;
import graphql.schema.GraphQLSchema;
import io.smallrye.graphql.api.Context;

@Path("/hello")
@GraphQLApi
public class GreetingResource {

    @Inject
    Context context;



    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @Query
    @Description("Get a Films from a galaxy far far away")
    public Employee getFilm(Context context) {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        return employee;
    }

    DataFetchingEnvironment dfe = context.unwrap(DataFetchingEnvironment.class);
        /***
         * 
        java.lang.RuntimeException: java.lang.NullPointerException: 
        Cannot invoke "io.smallrye.graphql.execution.context.SmallRyeContext.unwrap(java.lang.Class)" 
        because the return value of "io.smallrye.graphql.execution.context.SmallRyeContext.getContext()" is null

         */
    
    public GraphQLSchema.Builder addMyOwnEnum(@Observes GraphQLSchema.Builder builder) {

        

        // Here add your own features directly, example adding an Enum
        GraphQLEnumType myOwnEnum = GraphQLEnumType.newEnum()
                .name("SomeEnum")
                .description("Adding some enum type")
                .value("value1")
                .value("value2").build();
    
        return builder.additionalType(myOwnEnum);
    }
}