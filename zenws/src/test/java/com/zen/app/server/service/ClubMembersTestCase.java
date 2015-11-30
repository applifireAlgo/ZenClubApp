package com.zen.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.zen.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.zen.app.server.repository.ClubMembersRepository;
import com.zen.app.shared.app.ClubMembers;
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
import com.zen.app.shared.app.Club;
import com.zen.app.server.repository.ClubRepository;
import com.zen.app.shared.location.City;
import com.zen.app.server.repository.CityRepository;
import com.zen.app.shared.location.Country;
import com.zen.app.server.repository.CountryRepository;
import com.zen.app.shared.location.State;
import com.zen.app.server.repository.StateRepository;
import com.zen.app.shared.contacts.CoreContacts;
import com.zen.app.server.repository.CoreContactsRepository;
import com.zen.app.shared.contacts.Gender;
import com.zen.app.server.repository.GenderRepository;
import com.zen.app.shared.location.Language;
import com.zen.app.server.repository.LanguageRepository;
import com.zen.app.shared.location.Timezone;
import com.zen.app.server.repository.TimezoneRepository;
import com.zen.app.shared.contacts.Title;
import com.zen.app.server.repository.TitleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class ClubMembersTestCase {

    @Autowired
    private ClubMembersRepository<ClubMembers> clubmembersRepository;

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
            Club club = new Club();
            club.setAddressLine("fbSfrpMB7zjlPEtWh7vdlNPc3lF9GZChwjFtkDnUPXtMv0jpgE");
            club.setAddressLine2("UykBDt2mw582unO82MaIT2z3HcTdEoBE86S4zH97sA8s1OW1Iw");
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("nip0kLWUvJEK3w4EX5EAheRyxwJr4COF");
            city.setCityDescription("fQCwdYJdKw8zJD6HsQhQMeCXf0ZbbhVPTKkuKTf1JlOaEU5J98");
            city.setCityFlag("X1zivVfPlpVoAKRyoE4IvSzi3QbB9UQaDqqyDsdm8tnYTeT4Bz");
            city.setCityLatitude(10);
            city.setCityLongitude(5);
            city.setCityName("KOeqsWxOZWpErSXQsTPmRUSwtJxB7bRH1Z2nKJmk8XbiGZD93J");
            Country country = new Country();
            country.setCapital("b02sWy9B9TYtsmyGY2Y1XYcTrfxd9HsG");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(5);
            country.setCountryCode1("5qK");
            country.setCountryCode2("PX7");
            country.setCountryFlag("pw5yo8w5MnxMPY8GpOHRty9JmnTywuypcmfLAlX2Cv22woCTcK");
            country.setCountryName("IK20DplOKQMRG23vmxPTNCBXivyrPCyUysM3HxJmIe4EROkefc");
            country.setCurrencyCode("5AX");
            country.setCurrencyName("Zi7EyGDxh67sBGZv5MACIbMlctOB2ZyQUl2FumsIDKXorOGtWZ");
            country.setCurrencySymbol("Hb2KNWjJhHB2X8QGTV1768aG67QiUNxD");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("BCD9ZWpJO50vaYsixxE5qRolvyqjguMW38tI5f6RsQ3VHdrctP");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(6);
            state.setStateCode(1);
            state.setStateCodeChar2("R2JpxKVownxIs5uAClfII2JeSXWRefJ0");
            state.setStateCodeChar3("47Pkpt9CYRr2sTOLUXWF8FCEbD0eG7r2");
            state.setStateDescription("uuW2xc6dSsKXTwGwhRO9NOeGUPHTzmAI3KrTFYsWTZkLmNHsMl");
            state.setStateFlag("5O1ZCzeZgzeD15EOJeEMopCt3dmGTA1b1quPBMXTHU2a5yK0od");
            state.setStateName("pJF5XxA7x5xtEsKgPNf6uzQQ2anf7aF3VzhSPRPvSSARzDz2e3");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("D4f5WlMZqFJjuueLF6nuBz0yBkuqW6Ci");
            city.setCityDescription("FIXAmcMDO4ct8T62zVlYHc0HeqYpFizZX49itCS7vw83hjArzc");
            city.setCityFlag("Npq1SJ9cCT8lnmTtbw2EDfLd4gx9cc0yAaP10OYOn0RwbtCDEF");
            city.setCityLatitude(8);
            city.setCityLongitude(6);
            city.setCityName("BgGlsgwDv73PA2yAcjz4NFnQjOcoG0a4Pf0zfjP8t6ZKNi8qc1");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            club.setAddressLine("07p1lVJXMKMRPIXXYECIWwiYrNZiMplKBkleDJ2g4PTCqEP1Dr");
            club.setAddressLine2("601CmKAI14UtmRiVXEpxtUkD2kfpbjaJDtLNvzbJ1mJEKiwglR");
            club.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            club.setClubName("4ULLPtx8JwB2zIJKVNsXEzIzc1WOFVz4FBkc4mL8jgH3Zh5P2g");
            club.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            club.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Club ClubTest = clubRepository.save(club);
            map.put("ClubPrimaryKey", club._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(99);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("fzmeagqZsTWMhnJoLuCvL9Y4f9RmcXmm2L5G9yJwh0M3y2pkBH");
            corecontacts.setFirstName("cTKdRSvwh1x84BuFuUHmGKbOn7JHmeJag2zjtuh2rIYs96SX1O");
            Gender gender = new Gender();
            gender.setGender("ECW4e0RnxyZ8Hi9LeDmKXpVYnJisu4PM8jSfdKI6KVjh9UEquz");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("bY");
            language.setAlpha3("Zo8");
            language.setAlpha4("TeFl");
            language.setAlpha4parentid(5);
            language.setLanguage("m5BlOxGZENRMWMgACeQLt09WkSjwztVqsPejHB6oHhwEfF6kUe");
            language.setLanguageDescription("DrIf9z5s5vSpKd55M9pKnNWJxobtjRhyxvxd53k6AkSP7O8dpk");
            language.setLanguageIcon("ejUwjZowMTekvQCAU3tDzSTdVLxXKILFwHhnG9Kq5xhH2yCVGa");
            language.setLanguageType("ddg2K64qfXIMoZfS5Zuz1NRJCO5cxgUY");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("qvH3G1z9Bw7gWzH0ruwTJlaG6vEYyjwIQ1d0G6ADdtK8E2Zdv2");
            timezone.setCountry("SFh9z1J9a1XKXsQ1eLR0NFfr9TNbNjg3V21Y03Sgdj9SAybhME");
            timezone.setGmtLabel("lBKrCbgW28ebp90L1YQlfrjPBYBVbN6MikSSCtrpTsq77OrKWM");
            timezone.setTimeZoneLabel("5F2bHepxQVwzOcKm9EakE9fiktoMDIbT76TdOOAQIeeQBh1VrZ");
            timezone.setUtcdifference(7);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("CFD7mf0bIoqOEsVqGk6Apnpvbt3opOpjs5S0lYbH4x3h2pMpcq");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(60);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("ZVLAAYrN6lwxtRB3xERJBPWlshNDA5cFyZXBAuNhiV1QBUQsc8");
            corecontacts.setFirstName("vgD7GcVxxhywh19scuQEBrWpCZxxwBpTok9VPFsSyV3NoofM3Q");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("j7uXWbDLUPZlyVE09OjN7xIVOuUVmzpkookDghhcMBlSGEu9gl");
            corecontacts.setMiddleName("8fDcvaD7YOGVqUoFtzmV3uAuxRfkKhrC2EHKxi4E6RUif1TLoh");
            corecontacts.setNativeFirstName("E4DiYIayVKxme0RGWDlhF9X53XO3f2fJFToYcpCfm310JTWyST");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("GKq3sja9ENd38jXPw0p7CxUSUV70bImk2qnJbcMXzoWmRJKwIM");
            corecontacts.setNativeMiddleName("d4zPVXfWstysir9DKWW2KCBCN3bOl6epJxquDiXJIHolzGEFoR");
            corecontacts.setNativeTitle("armmKQNig08ochiAxOkEn1UIFYSngXp6vuzfsI62wH6G4ZadSm");
            corecontacts.setPhoneNumber("KI4ci3Nf3W61tXJGoskc");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            ClubMembers clubmembers = new ClubMembers();
            clubmembers.setClubId((java.lang.String) ClubTest._getPrimarykey()); /* ******Adding refrenced table data */
            clubmembers.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
            clubmembers.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            clubmembers.setEntityValidator(entityValidator);
            clubmembers.isValid();
            clubmembersRepository.save(clubmembers);
            map.put("ClubMembersPrimaryKey", clubmembers._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private ClubRepository<Club> clubRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("ClubMembersPrimaryKey"));
            ClubMembers clubmembers = clubmembersRepository.findById((java.lang.String) map.get("ClubMembersPrimaryKey"));
            clubmembers.setVersionId(1);
            clubmembers.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            clubmembersRepository.update(clubmembers);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByclubId() {
        try {
            java.util.List<ClubMembers> listofclubId = clubmembersRepository.findByClubId((java.lang.String) map.get("ClubPrimaryKey"));
            if (listofclubId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("ClubMembersPrimaryKey"));
            clubmembersRepository.findById((java.lang.String) map.get("ClubMembersPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<ClubMembers> listofcontactId = clubmembersRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("ClubMembersPrimaryKey"));
            clubmembersRepository.delete((java.lang.String) map.get("ClubMembersPrimaryKey")); /* Deleting refrenced data */
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
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
