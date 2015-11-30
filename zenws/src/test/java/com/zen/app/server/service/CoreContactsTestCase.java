package com.zen.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.zen.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.zen.app.server.repository.CoreContactsRepository;
import com.zen.app.shared.contacts.CoreContacts;
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
import com.zen.app.shared.contacts.Gender;
import com.zen.app.server.repository.GenderRepository;
import com.zen.app.shared.location.Language;
import com.zen.app.server.repository.LanguageRepository;
import com.zen.app.shared.location.Timezone;
import com.zen.app.server.repository.TimezoneRepository;
import com.zen.app.shared.contacts.Title;
import com.zen.app.server.repository.TitleRepository;
import com.zen.app.shared.location.Address;
import com.zen.app.server.repository.AddressRepository;
import com.zen.app.shared.location.AddressType;
import com.zen.app.server.repository.AddressTypeRepository;
import com.zen.app.shared.location.City;
import com.zen.app.server.repository.CityRepository;
import com.zen.app.shared.location.Country;
import com.zen.app.server.repository.CountryRepository;
import com.zen.app.shared.location.State;
import com.zen.app.server.repository.StateRepository;
import com.zen.app.shared.contacts.CommunicationData;
import com.zen.app.shared.contacts.CommunicationGroup;
import com.zen.app.server.repository.CommunicationGroupRepository;
import com.zen.app.shared.contacts.CommunicationType;
import com.zen.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("RavXwM8wj6DywEwvFBGHt3243I3OjjjMi7HgEj2VfWg2aDbh1n");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("lv");
            language.setAlpha3("egB");
            language.setAlpha4("pz5v");
            language.setAlpha4parentid(6);
            language.setLanguage("cMoEaVpqkxPiwgVbj0OujmtnIDh8DoCOhmF46p9EFDX0vpmjcb");
            language.setLanguageDescription("3MMI5D0eiV7k37dqS7cewukaOUsJZC5gsHeGiik4VIW1nQ6viB");
            language.setLanguageIcon("GSVFA5jR9JgtaOGB7ObDhJnlUT7jsUtCus86m8ReFLgmHUdCP3");
            language.setLanguageType("w3ozvER9doa1gRHq97p35n8QSWPk29Kc");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("SULQsh41ATv7QmETyLuhX7WHhCPOnUytoWW9kz47JDzvaJAPb3");
            timezone.setCountry("HpSkCh0esrVwgAu6OFBR6FUBtaSJCcSZBLL1toO6qDF3lTcHqM");
            timezone.setGmtLabel("p3GLKtYyES6keLBiUMuXllGapwK0n4mi8HoCkp18ErLl3CFYed");
            timezone.setTimeZoneLabel("0uiTN33i8qoPMBOBHd3Zqvmggy4c5krErwTS1yTSdNYJRLxCMO");
            timezone.setUtcdifference(8);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("upLU86OJHpeMFhCOTdESUaR9yZHhxPVACNUNvgZa1N3eai9kCg");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(67);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("xVq2LHOzuvQ9J06SAuuUlKQEZpKXdJHmwq1cQWbecYCgwA2XV1");
            corecontacts.setFirstName("zPGEd2JpcAKPl0x8fkxwMloCpwZrFtmacaRO54fhE0VBpwCB1P");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("G7UoxHWINo2CG7looGT1sSE2jCGbpD6U50cWUU2AHBCoPkpXOx");
            corecontacts.setMiddleName("bXxpebnM4UJ9czplzMuHDL914rHgEY9eRynyt72AwafXm9uLYs");
            corecontacts.setNativeFirstName("8NwoSe1pVutOgQryTWhLnxWnKqEjqKRQBOBaCabMlIDRFlZxcC");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("gDCmjYkkAr1L7zXIYS3w2A7lARfVpnPXmrWm0xFKFUU8oL7pB2");
            corecontacts.setNativeMiddleName("h1plAfd4aOakcZO8fMWZ5qMPFzmPnQsEDnWSYrceTjoSCbz8C6");
            corecontacts.setNativeTitle("JHZzeyLor5njurW8MWktnctpSxNoNo4scL5o9fYMgZi0OmKKtU");
            corecontacts.setPhoneNumber("q8gFPPGd2HXjGUJHPYfE");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("PfZvO5mjuvAaAWSGicqdtv1LobPkFJhusNUyGqCOBhxzdoTgGR");
            address.setAddress2("5tH1uDRgWUXwztyDkGhh5sHsffUxL5IjXHWzcGNMzkTNTZdLDi");
            address.setAddress3("CgBUylOg5IdzeO2nLiphMakaeJKcLldzuyQjIaZhzNDCeOWNUg");
            address.setAddressLabel("CLsvVxkFHth");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("f6G1RDbEpQM3bQwGsMAXlnkiVwsrkLutGpVfaRcDW5EA9gmuV9");
            addresstype.setAddressTypeDesc("bAo7513sVl5Pm6IhBPlXKmLZE2yD6HBDQoUJjG2D82aTwZRF5V");
            addresstype.setAddressTypeIcon("tJO6YyVprR27XqEE1EHAOsEtIpwFKdJPl7UfLdSwbAR23N8Isx");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("nZxbnB9TAnVkenwTYDcX1dSGW7uJcXF3");
            city.setCityDescription("BlJLB2GDstr0mC2jxylxCy8q1BgQwvnh0Uhzd3U6zJqfrnvGly");
            city.setCityFlag("zEpEyc6lXkJXADkrge1PeA6WwopLi06aSgHqWAA1uIwYcc48G1");
            city.setCityLatitude(2);
            city.setCityLongitude(2);
            city.setCityName("IUE1JUWU0q4JpqJqenKKALVOzxAA2fWnnJoIyT83c9mFpeGhtQ");
            Country country = new Country();
            country.setCapital("6NwMRTsTN4YU0ezPqemVzakoVpjtGORp");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(3);
            country.setCountryCode1("7rP");
            country.setCountryCode2("0Rl");
            country.setCountryFlag("bD78t7xz1WnzbMescvZL7iHuwh0tzvfC15GPcoLQDOD0wEfUuU");
            country.setCountryName("extABavio2JJdtUR2ZWlVWnzFSWTWA6s4iTuKWu5joEiB4Iu5E");
            country.setCurrencyCode("eqb");
            country.setCurrencyName("S5LfnB9AnUd4dKZcGi6kFluPLBdES91WeJN6oa2G24wAE4LGdQ");
            country.setCurrencySymbol("0paepJIVje9392k8452rYIUSnRI2d0sE");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("ibWSDd1No7pgcpYOwqRF8W5pSY8n5mgXtgQZHn34rQyHqIZIqw");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(6);
            state.setStateCode(2);
            state.setStateCodeChar2("qpapFjRxiefzL1uSQm744u3vMm53Z01Z");
            state.setStateCodeChar3("4iKNs5oh9OBwlAoP5cvf763Ib9ttUbOj");
            state.setStateDescription("DrAAO9wQMuoHiLP0GGQxm1ARV3l6pBQKC9qJUHl6yzGElsaxVK");
            state.setStateFlag("dpXjxT6QjiowscA3rNx6MkVATynAGSP7sCCjdzGtv8RmG5zaJE");
            state.setStateName("H643PcXsl1iJvkaUjpIUcF5zIHLM6j2E4utioAmvHFvHAurIjZ");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("DQthbGxpR3uLbkedlmcorQCHG60Dx7xd");
            city.setCityDescription("hZWfxuECYO5GTx0n0zal4INcXYsTNlYnjxWad7AMk7g2rl79iC");
            city.setCityFlag("2SVaMxJiX1Qdcjz6lzzD94J7zD3zQTAFGbktfRCCWVvGAXCya9");
            city.setCityLatitude(8);
            city.setCityLongitude(9);
            city.setCityName("xT811FuQyYSim2raPwq17oABvmJZuVbIxWQyxy6WiWhmo0z6m1");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("zdxnsfG28JVsXsd7Se9himvQAVr3xBGNOXLZkOziOg4TluEas6");
            address.setAddress2("W7t4rdtMj6idYOsY4kdoXuRFNZDM5xkp4mSJw12ra6DwvJLk4s");
            address.setAddress3("ywKqT4qGm8A04tDnrVS0Mn2KFlBQMhpRk7cm2lPTj5LQnmoJmQ");
            address.setAddressLabel("jLacUUvDjhf");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("Vl079Jqvyg6WYgi5UBDD8aZ0tJOLz8jbpkGJtW4yOQbCRiR1Qi");
            address.setLongitude("C4dUritqbtrGvZuCbB8FBQW44DbUiwwkroS9blAG2N1djvFxSC");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("isnTyO");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("2In");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("B4pnjTmbDDf8yrpRdqeRVSGTxup97Q6Zop1o2c9jNA8BrVtVJC");
            communicationgroup.setCommGroupName("BbI7E2ehyfnfMTwVIUsIcvWiv9Z7A5qFGv09ak4KMQuUFijuVm");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("ThZgX85sBdJZTs8BJnf0oQSdLIR08lQOmZCeC2xgXwEFPJrzy8");
            communicationtype.setCommTypeName("eWY0roqz3hMgPOgDzFlmgOi5IfWG8YRy9zPcbG0WjkYWlnhZxO");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("fFs");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(44);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("qDUtGIYX1n8X4HQH4Kssn6HWlAdPL1CLIEseDFzhTwyTeaPloQ");
            corecontacts.setFirstName("ZTfKm5xisQdQKrzTZZJHDatvcMxtMNyzvM9rqyZzRLj1k3p6Pt");
            corecontacts.setLastName("Z42Q0rKRqIUnv6ZeVeZAIjYrnEUxqStdFjGUiXDhoWE5ru8gI2");
            corecontacts.setMiddleName("cFltSuXZIb8yuaEsimkJwBR4JgXZQMHcvKtSFV9UTpuoiCZrCf");
            corecontacts.setNativeFirstName("TH05XybpgzN4ONStagm2N2FhkvMAl1212TGrfYgH7v8Ldtw4xn");
            corecontacts.setNativeLastName("2M8mMNrkXQzF5cABMcRbGZ1cNRXLJTj6R20Ud5CJWJtBXaxnz9");
            corecontacts.setNativeMiddleName("lRORSTcq0P1ETGZd3qgxo2dwu9SH2GMzFkBlR6Tx8pe5gL21B1");
            corecontacts.setNativeTitle("HNAutUWapTY9FpVymtxhBAPEpM44O1EaHEkMBKJy4SiaPOJbRC");
            corecontacts.setPhoneNumber("VX7aRBSvQTdYjt27DMbU");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytimeZone() {
        try {
            java.util.List<CoreContacts> listoftimeZone = corecontactsRepository.findByTimeZone((java.lang.String) map.get("TimezonePrimaryKey"));
            if (listoftimeZone.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
