package com.mock.ws.rest.test.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mock.ws.rest.ApplicationConfiguration;
import com.mock.ws.rest.DataSourceConfiguration;
import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;
import com.mock.ws.rest.bso.model.BsoStatus;
import com.mock.ws.rest.bso.repository.AgentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfiguration.class, DataSourceConfiguration.class }, loader = AnnotationConfigWebContextLoader.class)
@ActiveProfiles(value=ApplicationConfiguration.PROFILE_H2)
@WebAppConfiguration
public class AgentRepositoryTest {

    @Autowired
    private AgentRepository agentRepository;
    
    @Test
    public void testFindById() {
        Long id = Long.valueOf(18);
        Agent agent = agentRepository.findById(id).get();
        assertNotNull(agent);
        assertEquals(Long.valueOf(1991573), agent.getCode());
    }
    
    @Test
    @Transactional
    public void testSave() {
        Agent agent1 = new Agent();
        agent1.setFirstName("Светлана");
        agent1.setLastName("Новикова");
        agent1.setCode(10l);
        agent1.setLnr(0l);
        agent1.setSkk(0l);
        Agent savedAgent = agentRepository.save(agent1);
        assertNotNull(savedAgent);
    }
    
    @Test
    @Transactional
    public void testSaveWithBso() {
        Agent agent1 = new Agent();
        agent1.setFirstName("Светлана");
        agent1.setLastName("Новикова");
        agent1.setCode(11l);
        agent1.setLnr(0l);
        agent1.setSkk(0l);
        
        Bso bso1 = new Bso();
        bso1.setAgent(agent1);
        bso1.setNumber("100");
        bso1.setSeries("AAA");
        bso1.setStatus(BsoStatus.NEW);
        bso1.setType("40");
        
        agent1.addBso(bso1);
        
        Agent savedAgent = agentRepository.save(agent1);
        assertNotNull(savedAgent.getId());
    }
    
    @Test
    public void testFindByLnrAndSkk() {
        Long lnr = Long.valueOf(111111);
        Long skk = Long.valueOf(16208330);
        Agent agent = agentRepository.findByLnrAndSkk(lnr, skk).get();
        assertEquals(lnr, agent.getCode());
    }
}
