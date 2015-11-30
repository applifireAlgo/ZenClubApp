package com.zen.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.zen.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.zen.app.server.repository.ClubRepository;
import com.zen.app.shared.app.Club;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.zen.app.shared.location.City;
import com.zen.app.server.repository.CityRepository;
import com.zen.app.shared.location.Country;
import com.zen.app.server.repository.CountryRepository;
import com.zen.app.shared.location.State;
import com.zen.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class ClubTestCase {

    @Autowired
    private ClubRepository<Club> clubRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("R6nhB8JnNAyBDeHPOPQx1CWfn5Xd4cEC");
            city.setCityDescription("imUjHl1MFBcD1JTQtQpHHM5TIBxqHMyW4oEfA69rIALp1Apk6n");
            city.setCityFlag("DSYwk4oDEJJIFlc1wddRsty0V9BF97iAUXOTQX7GqzXxgKmGSi");
            city.setCityLatitude(8);
            city.setCityLongitude(8);
            city.setCityName("2Q54Fn4p6VNMDT845iOzExVaiHXMnFwDNey3Qw6GIVGnxN994u");
            Country country = new Country();
            country.setCapital("841o47TTIwcqASw0MdBn6q5TWiGTH5Vl");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(10);
            country.setCountryCode1("Npa");
            country.setCountryCode2("fEI");
            country.setCountryFlag("K25zj9HJqx5sDa3FN13a4f6Z0zWw6rEwTvVZAfwAUBiT0G1EkP");
            country.setCountryName("CYooYV3OvPav4ju1qJnw3hpo8DmHGJwcx7BX3HfYIMEgvnRwvL");
            country.setCurrencyCode("9px");
            country.setCurrencyName("MjpMJfvRYa14IQE27iJwdF0TZqPIn7SDOk8aRPz0M4a1rveHIA");
            country.setCurrencySymbol("OVcEu2UAoEUqetdmZiyZUim4OHYZVSM7");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("ci4uizC8UM3iiPFZ2zqrfTGSzSI9KMcKNAvF3kf2rL3CnCxMMn");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(5);
            state.setStateCode(2);
            state.setStateCodeChar2("VXfImzLfQbZMPN0boHR9ouX6uLSng2Zt");
            state.setStateCodeChar3("q8fad7Ob8glovip2481YJqG7SWzaUVm0");
            state.setStateDescription("mZsfVsMDl74fe0CKViq7OWoFS7mKltQ6wyaVCXNp1zrfKLxiqW");
            state.setStateFlag("1o4HXVhagx0S1kEGHfha5siIUKc9zlgXqpf75i73BIdgeIKa6Z");
            state.setStateName("ffiEyCO7KX68PpbNJModYoRJQ2gsz3nreHknoEC67LFyN51Ek5");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("7jLp5RvpRKIMWyCSZ8dJ0C2TojoVTy7L");
            city.setCityDescription("LgPzdens9LMXj1ok2jOKOSpFtOM3VfJNxR9KsvAKh3c1x6R1t3");
            city.setCityFlag("hIWFmlPvKjzmZeIdEgzqRhQygDCXMuqBSuV1UB3HmiAVNGIvEw");
            city.setCityLatitude(10);
            city.setCityLongitude(2);
            city.setCityName("6WtwXZhDRy9Tl6KgzccfIbi46EC1j32mh3z0mgRnQh8uHBfOic");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Club club = new Club();
            club.setAddressLine("MXz4OFBUjIi7nYGIpzXp1iESC8vRuPL3vOy8Qqm3PKlIIoGKjg");
            club.setAddressLine2("TDOo5TKkvwuDVsePl7J0iKiKiZ4heufP2G7fp1b0ezFMpUKosk");
            club.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            club.setClubName("6SCslv6a3iMnOJSmFBbCDq43ozDX1ScMfQ7mDJWsFwCxURKMvO");
            club.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            club.setStateId((java.lang.String) StateTest._getPrimarykey());
            club.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            club.setEntityValidator(entityValidator);
            club.isValid();
            clubRepository.save(club);
            map.put("ClubPrimaryKey", club._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("ClubPrimaryKey"));
            Club club = clubRepository.findById((java.lang.String) map.get("ClubPrimaryKey"));
            club.setAddressLine("k0ykYyFG9IovZMXmJGwLoJSRtInx7wgPAC0lqWAcq1xxor8Hb5");
            club.setAddressLine2("sjATYrXUW1f4o6xbiSRbHp1HStv57YSBtq3cHFr8Iwg2s04MqH");
            club.setClubName("l9rEQ9BjiqyBOJGERnPs3he4BqE85KLTazOPyZnZTgunDYpLZq");
            club.setVersionId(1);
            club.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            clubRepository.update(club);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Club> listofcityId = clubRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ClubPrimaryKey"));
            clubRepository.findById((java.lang.String) map.get("ClubPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Club> listofcountryId = clubRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Club> listofstateId = clubRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ClubPrimaryKey"));
            clubRepository.delete((java.lang.String) map.get("ClubPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
