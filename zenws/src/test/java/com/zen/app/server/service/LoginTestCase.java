package com.zen.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.zen.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.zen.app.server.repository.LoginRepository;
import com.zen.app.shared.authentication.Login;
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
import com.zen.app.shared.authentication.User;
import com.zen.app.server.repository.UserRepository;
import com.zen.app.shared.authentication.UserAccessDomain;
import com.zen.app.server.repository.UserAccessDomainRepository;
import com.zen.app.shared.authentication.UserAccessLevel;
import com.zen.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(43);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("H90RbIDCsy4zUksJ6XFKmALqpZhlopsDRFeUOjyzSTDQjAIJrU");
            corecontacts.setFirstName("ry11y08qM0oy18CL9G2DUN06NxEWyF56j1TJZvi4iptwuSbbBP");
            Gender gender = new Gender();
            gender.setGender("KeNpO8evqGEhSedPhLNR7AZjVaFRkSCfLb3fr3xXD44Ll2Cj3N");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("QE");
            language.setAlpha3("iGV");
            language.setAlpha4("F0gU");
            language.setAlpha4parentid(8);
            language.setLanguage("oOzuyH9OXXcDl9TUHQpT6GdZkqeivUmDducFK8CvMQzPxuPqnG");
            language.setLanguageDescription("cYts7Y7vzJ31TFUTd5dOTrpi4Be9Ys3IKPPNC1rmS8y9CtnFvn");
            language.setLanguageIcon("3bSJqFqj85rNg54H7BryszOjTHKb7UL9HFgCdgEpBYNhXsuwoZ");
            language.setLanguageType("qcnRX4Ds1ANgTdg58cBPSwEp2M87RK4o");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("timTr0bGhusHp5D1Qye7yqbeGjzujXnVErs5KTf5YnDUSAIWxe");
            timezone.setCountry("PfGTj5EHTaDaLm71pKxFmPE5AnAy2refZNK39zXSyTA8C7UL1I");
            timezone.setGmtLabel("xCVjQ4cRGZODxO5evRuzXahpwvP4FtbkyOESoUFMe6uSncOUSv");
            timezone.setTimeZoneLabel("zX1k04KHV96BUkh4qZJNTqjTN3ycRYwhuex4ZiIKBbWwjx3vWh");
            timezone.setUtcdifference(11);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("VhpHyIsYU5qmbqUsju0x9ZnAjNWBO0gt4L1FpGnkbM482FYc5V");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(24);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("p7yUdQYLxr2StrOAalZKZ6fZ370sTJDNZMyRgmjMewqwYHISlF");
            corecontacts.setFirstName("3DWUkaIAPXKVvXTfp3qDg652tR1BbvSF7g3004yJRtxQSXZIri");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("NxnpbQNpz6kyefcJvfdBF3zgJHVyX2kgwpZegJ8hFCEyfuFwLl");
            corecontacts.setMiddleName("4t6arnBtbuoELCzic05WfykrwbdJdUfD3OxAE5rNVDoCRxxiM7");
            corecontacts.setNativeFirstName("CbPlYkHrXDghksinpE8PXJXUlPDp4TYa8nJKXMgCQCDqqmJDS9");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("iYA54DvCdQb4RpT6ck6mcpSR3dyi83YGEHTiWpTEhQgTTrhYbW");
            corecontacts.setNativeMiddleName("O2ys7yVVnwLTZXK4cz6fgkZuMRojH06PwTotnDHmDhpmu2P8o1");
            corecontacts.setNativeTitle("Alp5XNvmljnyrHqHXsiiKI2j3eaW82rgOiCUXPiPRvWjZN7jdw");
            corecontacts.setPhoneNumber("BAEWVxypBphYEYUXGdeo");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("cPS8oA4348mEQfEtrKAsMky9dS6UD1VFd93FHGxT7jePHsdGHl");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1796);
            user.setUserAccessCode(10);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("Z5IEuGHDlrE49TdU96pNuSnW4RZzQXVyP7WH19SkfGWWEPBGOR");
            useraccessdomain.setDomainHelp("xqw5B2wPyyO5AsBGaWpQGPOuBPrLaUNrbWXoRvEqeXx5YBrqke");
            useraccessdomain.setDomainIcon("hMaYuOnHKQwe9BBaQNcHlEavRtIGa8kJ8oGNgVobqlQvMks86Q");
            useraccessdomain.setDomainName("4FSZRps9lCHtTu2GaDZtmX3ahpnqOAGJyPDvAxuqJOuplu6h3n");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("3G6TLbRbiBLPpN981eog7BgjOwiRl7Bnd14nPzBn8FRtnzKIW6");
            useraccesslevel.setLevelHelp("LJe95GmPRicZg7fKsiqrgEoz3HNB1IAbLSxe98it2XCOge7ajR");
            useraccesslevel.setLevelIcon("iZM3IaduIFjdxZB1B4t9m0Do7yQbqkd27yGva8jYNLXKFiHOTs");
            useraccesslevel.setLevelName("yZ6G77uvlRwZk71zLixfY67TPCdouFtXqfsPY4oaKQSeDn1oxk");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("ywehKviYSTovMs6241s49Yl9WBK91Ox9HdoYVZx3mu5FyCaNcX");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(380);
            user.setUserAccessCode(6);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(3);
            login.setIsAuthenticated(true);
            login.setLoginId("YRkbJYlWzjhlDsldJOVIbspd6XGyXhCi8QOPtOkJ0yimywSDRw");
            login.setServerAuthImage("p9jxmIeHFM2Uk5hUed7PFNAWnYGKXWPj");
            login.setServerAuthText("GRmQ0FIJErLytynJ");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(7);
            login.setLoginId("MuGnWfcwrFoKUquHLsk1a2TT72SXyZn2rp5HH42zNKf9bPDCVu");
            login.setServerAuthImage("JO3Rn2e07f2j2zvIcgjROOTDITjWbsEl");
            login.setServerAuthText("nNruZ8yTHDXZ3nVj");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
