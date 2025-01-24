package org.broadleafcommerce.profile.core.dao;

import static org.junit.Assert.assertNull;
import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.CountrySubdivisionImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml",
    "/bl-profile-applicationContext-persistence.xml", "/bl-profile-applicationContext.xml",
    "/blc-config/admin/framework/bl-profile-applicationContext.xml",
    "/blc-config/site/framework/bl-profile-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CountrySubdivisionDaoImplDiffblueTest {
  @Autowired
  private CountrySubdivisionDaoImpl countrySubdivisionDaoImpl;

  /**
   * Test {@link CountrySubdivisionDaoImpl#findSubdivisionByAbbreviation(String)}.
   * <p>
   * Method under test:
   * {@link CountrySubdivisionDaoImpl#findSubdivisionByAbbreviation(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSubdivisionByAbbreviation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass139 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.dao.CountrySubdivisionDaoImpl countrySubdivisionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CountrySubdivisionDaoImpl()).findSubdivisionByAbbreviation("Abbreviation");
  }

  /**
   * Test {@link CountrySubdivisionDaoImpl#findSubdivisionByAbbreviation(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CountrySubdivisionDaoImpl#findSubdivisionByAbbreviation(String)}
   */
  @Test
  public void testFindSubdivisionByAbbreviation_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CountrySubdivisionDaoImpl()).findSubdivisionByAbbreviation(null));
  }

  /**
   * Test
   * {@link CountrySubdivisionDaoImpl#findSubdivisionByCountryAndAltAbbreviation(String, String)}.
   * <p>
   * Method under test:
   * {@link CountrySubdivisionDaoImpl#findSubdivisionByCountryAndAltAbbreviation(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSubdivisionByCountryAndAltAbbreviation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass224 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.dao.CountrySubdivisionDaoImpl countrySubdivisionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CountrySubdivisionDaoImpl()).findSubdivisionByCountryAndAltAbbreviation("GB", "Alt Abbreviation");
  }

  /**
   * Test
   * {@link CountrySubdivisionDaoImpl#findSubdivisionByCountryAndName(String, String)}.
   * <p>
   * Method under test:
   * {@link CountrySubdivisionDaoImpl#findSubdivisionByCountryAndName(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSubdivisionByCountryAndName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass238 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.dao.CountrySubdivisionDaoImpl countrySubdivisionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CountrySubdivisionDaoImpl()).findSubdivisionByCountryAndName("GB", "Name");
  }

  /**
   * Test {@link CountrySubdivisionDaoImpl#findSubdivisions()}.
   * <p>
   * Method under test: {@link CountrySubdivisionDaoImpl#findSubdivisions()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSubdivisions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass252 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.dao.CountrySubdivisionDaoImpl countrySubdivisionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CountrySubdivisionDaoImpl()).findSubdivisions();
  }

  /**
   * Test {@link CountrySubdivisionDaoImpl#findSubdivisions(String)} with
   * {@code String}.
   * <p>
   * Method under test: {@link CountrySubdivisionDaoImpl#findSubdivisions(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSubdivisionsWithString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass253 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.dao.CountrySubdivisionDaoImpl countrySubdivisionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CountrySubdivisionDaoImpl()).findSubdivisions("GB");
  }

  /**
   * Test
   * {@link CountrySubdivisionDaoImpl#findSubdivisionsByCountryAndCategory(String, String)}.
   * <p>
   * Method under test:
   * {@link CountrySubdivisionDaoImpl#findSubdivisionsByCountryAndCategory(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSubdivisionsByCountryAndCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass563 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.dao.CountrySubdivisionDaoImpl countrySubdivisionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CountrySubdivisionDaoImpl()).findSubdivisionsByCountryAndCategory("GB", "Category");
  }

  /**
   * Test {@link CountrySubdivisionDaoImpl#create()}.
   * <p>
   * Method under test: {@link CountrySubdivisionDaoImpl#create()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass138 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.dao.CountrySubdivisionDaoImpl countrySubdivisionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CountrySubdivisionDaoImpl()).create();
  }

  /**
   * Test {@link CountrySubdivisionDaoImpl#save(CountrySubdivision)}.
   * <p>
   * Method under test: {@link CountrySubdivisionDaoImpl#save(CountrySubdivision)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSave() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass577 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.dao.CountrySubdivisionDaoImpl countrySubdivisionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CountrySubdivisionDaoImpl countrySubdivisionDaoImpl2 = new CountrySubdivisionDaoImpl();

    // Act
    countrySubdivisionDaoImpl2.save(new CountrySubdivisionImpl());
  }
}
