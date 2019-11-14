package com.mock.ws.rest.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mock.ws.rest.ApplicationConfiguration;
import com.mock.ws.rest.bso.model.Agent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfiguration.class }, loader = AnnotationConfigWebContextLoader.class)
@ActiveProfiles(value=ApplicationConfiguration.PROFILE_H2)
@WebAppConfiguration
public class AgentTest {
    
    @Test
    public void test() {
        Agent agent = new Agent();
        agent.setFirstName("Witek");
        agent.setLastName("Wojnarowicz");
        agent.setLnr(Long.valueOf(100));
        
        assertEquals(Long.valueOf(100), agent.getLnr());
    }

}
