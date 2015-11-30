package com.zen.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.zen.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.zen.app.server.repository.VillageRepository;
import com.zen.app.shared.location.Village;
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
import com.zen.app.shared.location.Country;
import com.zen.app.server.repository.CountryRepository;
import com.zen.app.shared.location.District;
import com.zen.app.server.repository.DistrictRepository;
import com.zen.app.shared.location.Region;
import com.zen.app.server.repository.RegionRepository;
import com.zen.app.shared.location.State;
import com.zen.app.server.repository.StateRepository;
import com.zen.app.shared.location.Taluka;
import com.zen.app.server.repository.TalukaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class VillageTestCase {

    @Autowired
    private VillageRepository<Village> villageRepository;

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
            Country country = new Country();
            country.setCapital("kRQgoQRVaTwftoSouwHmEHqLROaKWXy9");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(2);
            country.setCountryCode1("qyR");
            country.setCountryCode2("PMj");
            country.setCountryFlag("bRwGZ9vPrf5o4QAXqvUROX1FnB0UPxdR4u8FXw5oNHcu2IxtWT");
            country.setCountryName("jcM75N1H9aKsJD81YBF82W3fLKDYxiSzODnl839aflvLuNjGBs");
            country.setCurrencyCode("LtB");
            country.setCurrencyName("SHmZvT5Cl2WTreNNznwSVqiQK9dle87zfNApTrwApOl8SzbnMz");
            country.setCurrencySymbol("DOL1nvh2isy7toAX0dxzIV14k9UL4Bes");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("kieImIV26XczZHMdYrZ4SRULPEDwnq0p");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("FAvNHJb9qEPeIayGUhsyByScRCA1oh0wJq9TNGx5Muw68IKCNh");
            state.setStateCapitalLatitude(11);
            state.setStateCapitalLongitude(1);
            state.setStateCode(0);
            state.setStateCodeChar2("VYtYEHWUAqfcfhL6H0jCgsKy5QebzMAt");
            state.setStateCodeChar3("2rJDW9BCQtU1AzYpOmWdD4MpJvbRMoXi");
            state.setStateDescription("x5DPIDwAW41wm1TrTX0bW4bkjTEdFRvc7dBw7eaS306YynQM1e");
            state.setStateFlag("lqW5BH2XfhVMEeSFFuPOO7ZbIaQexbh7O6BwrBxrkaP0GXHkp7");
            state.setStateName("hGAv1jOkEdtbqaU6uuzXQiNOhkRzMbc6GjeMAjIkalBxxjpYdP");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(1);
            region.setRegionCodeChar2("qPDbCs1TXVzyff2MUYq2OpjS9OZSYTwu");
            region.setRegionDescription("K2aF8XYlLgoXRqZoDaFQyW6V707DAHKS1BH0Z81rNVx991hngT");
            region.setRegionFlag("hOQ7fiLEBjVfXLZ6NDvq8SYJ6g5Z8Uh2F0ensIBZRcFe46XXIC");
            region.setRegionLatitude(6);
            region.setRegionLongitude(10);
            region.setRegionName("UBC6j5U2ORHWnnBPJtRTkqRmeLCfT70vYDWCyBRIOj4t7WDSpR");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("1Y03XhssAatjsJwEgb5H0sdV9SFGiGRi");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("OqU9I2t2m5jJfl3s5BqZR7JeMgxX6NTii3m21O1aPHcOIN4Ffi");
            district.setDistrictFlag("8n3Z1Cu4NFyy1TWNg1IeNxXCSTJhoV90DXfa8TiSodsmzbgmrb");
            district.setDistrictLatitude(9);
            district.setDistrictLongitude(3);
            district.setName("Le0l0aDKDL6sM2X0wpIa323VCEqTkNx8zbZX1kZqbvk8gK7nIU");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setTalukaCode("C1pSJHBy9JonkyiS4un88Akrjg5A96Ee");
            taluka.setTalukaDescription("3HhuJ77riUKvnhMSg6iAb8WalIDIA7dKampRBU1ehIXb8FNukp");
            taluka.setTalukaFlag("bKTjyn8cZVnDGqwUEBZLAK3CaiDELkP2Z2Mvd0JDm35x7xNJS4");
            taluka.setTalukaLatitude(1);
            taluka.setTalukaLongitude(1);
            taluka.setTalukaName("03p8QB0CACClsBr3fyskDJFa2DE52xIqs64MI4Y5yeFYjph5pf");
            Taluka TalukaTest = talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
            Village village = new Village();
            village.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey());
            village.setVillageCode("9IuNxACfhXfmhX578rVFNDabX3SrrNo4");
            village.setVillageDescription("zgu6u9GuIjAUWq7tQ2NXYjFqOmt7I2cdl5QOpMGaPHDrDJozKO");
            village.setVillageFlag("MdNdirMcAWxsEPpXFIKJwZc5X3Aq47JeDZ95fUHVfZDPkUqicD");
            village.setVillageLatitude(0);
            village.setVillageLongtitude(0);
            village.setVillageName("cKhjlPRyGdil9UbqGbMpYk1QUod0YJd5QDUoPUwbO5GRAXYf75");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            village.setEntityValidator(entityValidator);
            village.isValid();
            villageRepository.save(village);
            map.put("VillagePrimaryKey", village._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private DistrictRepository<District> districtRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            Village village = villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
            village.setVersionId(1);
            village.setVillageCode("BJoiSE5AGyDXkZliZLygt7BCSYgRyeYe");
            village.setVillageDescription("KBrhDIUtoqn2eci22pH2ASgyEZauGeGckWi259yC20IxLirvMf");
            village.setVillageFlag("Y3ar9D3tAgrAXxxwv4GfNjddkNkYABcN4BlqoVwCf1s0At7FMu");
            village.setVillageLatitude(7);
            village.setVillageLongtitude(8);
            village.setVillageName("7AKbgx9BCVIyYt5V0EyXdJXWl7NA3FpVOImE6aVyfXDienZ3uc");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            villageRepository.update(village);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Village> listofcountryId = villageRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBydistrictId() {
        try {
            java.util.List<Village> listofdistrictId = villageRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
            if (listofdistrictId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Village> listofregionId = villageRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
            if (listofregionId.size() == 0) {
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
            java.util.List<Village> listofstateId = villageRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3findBytalukaaId() {
        try {
            java.util.List<Village> listoftalukaaId = villageRepository.findByTalukaaId((java.lang.String) map.get("TalukaPrimaryKey"));
            if (listoftalukaaId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.delete((java.lang.String) map.get("VillagePrimaryKey")); /* Deleting refrenced data */
            talukaRepository.delete((java.lang.String) map.get("TalukaPrimaryKey")); /* Deleting refrenced data */
            districtRepository.delete((java.lang.String) map.get("DistrictPrimaryKey")); /* Deleting refrenced data */
            regionRepository.delete((java.lang.String) map.get("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
