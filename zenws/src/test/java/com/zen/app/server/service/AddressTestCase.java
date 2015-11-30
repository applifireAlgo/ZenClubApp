package com.zen.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.zen.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.zen.app.server.repository.AddressRepository;
import com.zen.app.shared.location.Address;
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
import com.zen.app.shared.location.AddressType;
import com.zen.app.server.repository.AddressTypeRepository;
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
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("rHD5lflbgTobG472R15t3oYYrncwJSUXmTYf6egBz7wYWNUdlv");
            addresstype.setAddressTypeDesc("5sXfi7PUqnvrQxplfUkIffEmGDFJQRspxvMq0CBnvR1c9yEsZn");
            addresstype.setAddressTypeIcon("V69hAgAOvHRbNgbFircoUr4FBDmGUSbBmOEZXYwu8wPNTKEQVX");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("045umY8fvP5XRvsEUkxedHgCKvoGJDR8");
            city.setCityDescription("UEShk7PkWJ0wGc3y61YVCiF1hObUaXX6lBI22zWBtSqmnHkXyo");
            city.setCityFlag("UI8Rvu1WDKWNtLOSm1wNE0gotBQNcXe4qRplwZssByqfZ3QLvv");
            city.setCityLatitude(3);
            city.setCityLongitude(3);
            city.setCityName("Wzf1OeISukru3F6PaBT4OUa3Ebla3zIJLAERXxanc53MbCXk0K");
            Country country = new Country();
            country.setCapital("Hf7wqbCxI9bRbiLNq0yUnCVGQN42o6pm");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(0);
            country.setCountryCode1("6Mb");
            country.setCountryCode2("3Eu");
            country.setCountryFlag("A7qjo2yIxwZffzXW55melTE076U5hweYm7MReqBBzQ9ViTn521");
            country.setCountryName("ZLaGqMWjUVEVBfUxceVJWLEkocb46Crgbv75Zekufpxm49vdqe");
            country.setCurrencyCode("GhF");
            country.setCurrencyName("olVjFiRbN4ThNQYg2UMHUtgS6cgPSentGbNTuTSINUh9Pppv2t");
            country.setCurrencySymbol("7xaos6FSVPeQyaRYaGEPcZi9V4hYXqcQ");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("2nHjqx2sLYxgaEbj4lz2h84fpZcIm5OYdymOKyomF1Khtg0Bst");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(7);
            state.setStateCode(2);
            state.setStateCodeChar2("6AF10QdekdyGK30lLbjRvfgT4DzUPH0u");
            state.setStateCodeChar3("qP2LOuqBxF4NEA5vso5UQy39sUX2RJkj");
            state.setStateDescription("2tYEnygYM6nuF6kvgJsfpgjvxyM3MeMLJ9QqyOixpGtkZWZ1dz");
            state.setStateFlag("U6tQMSwLkV749WKelGL33yD7YNbX3GSIPm1gJpmbvwEzznUieW");
            state.setStateName("1mlbIY2FFPlrfz9wXVfUYNy95V9T0lRbRYxGV929Q1vuWDs1DB");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("g5p2r8PUFO5gF0heUOUlOsCoXnkpEi31");
            city.setCityDescription("by5UC4CC9saSrPi8onrtxxXuKxdV6jq7RP3LEM1NaJbOELTOm9");
            city.setCityFlag("i0VYONIF2iSZmLmOk50AFd8aveOhs5lWGs3FT28vbIqUN49bYj");
            city.setCityLatitude(10);
            city.setCityLongitude(0);
            city.setCityName("hdPAtwRxv8HX9YAi1MfHVRTZzrg5As9Eajn5Jo9lvowhOdrAP5");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("LwBpAqeBoYqTAmAim5mcm61Q44PzotdedY5GT6WrDLVkwyXnEe");
            address.setAddress2("6c27Svq2s99BXaGCA6Vh3AX59ZTs17kQlaH8QGJAJKB0LW5qGq");
            address.setAddress3("e519RL6D00lzcKipPPDpUf8qB7tktlSgrScOLl4kZUGrarlQYG");
            address.setAddressLabel("1HJaJhv8JyI");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("60J50ETXrzlpzLXSDZ2yfnumxbQBmq9cWYkNl58jkTh35cnw09");
            address.setLongitude("0T1fMbFvbBHkvocVvuRPDEBOdfgKdvrs8EIml7tmBGbKXVrBng");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("AmiooZ");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("rAzVfG4U5CZujo7mP6cQ5Qofs4FUBIUE4ixMKexMcV1XmvAxQp");
            address.setAddress2("p7RZTYdYZT6RfWAZFQVSTrKJ8KuhxX7vWGr3UAwpWuPPAo8COh");
            address.setAddress3("Mkbz0EwXJjSwVpNHKroHSoqv4RLo8I3kA17v36RenUV0CrzqsN");
            address.setAddressLabel("USvxcyd2w5b");
            address.setLatitude("v64SQ4i2z06g6e3OqxViu2FXdXMehhkBKUw8gNRRk6HtCBBC4j");
            address.setLongitude("vQQcSxJeNOr9PBhbynIaNlrvNDzOyupHkh3FHVbQd7OEzc3569");
            address.setVersionId(1);
            address.setZipcode("Zd2aQ1");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
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
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
