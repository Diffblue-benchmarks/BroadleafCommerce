package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml",
    "/bl-profile-applicationContext-persistence.xml", "/bl-profile-applicationContext.xml",
    "/blc-config/admin/framework/bl-profile-applicationContext.xml",
    "/blc-config/site/framework/bl-profile-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CountrySubdivisionImplDiffblueTest {
  @Autowired
  private CountrySubdivisionImpl countrySubdivisionImpl;

  /**
   * Test {@link CountrySubdivisionImpl#getName()}.
   * <p>
   * Method under test: {@link CountrySubdivisionImpl#getName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3335 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.domain.CountrySubdivisionImpl countrySubdivisionImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CountrySubdivisionImpl()).getName();
  }

  /**
   * Test {@link CountrySubdivisionImpl#getName()}.
   * <ul>
   *   <li>Given {@link CountrySubdivisionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CountrySubdivisionImpl#getName()}
   */
  @Test
  public void testGetName_givenCountrySubdivisionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CountrySubdivisionImpl()).getName());
  }

  /**
   * Test {@link CountrySubdivisionImpl#getName()}.
   * <ul>
   *   <li>Given {@link CountrySubdivisionImpl} (default constructor) Country is
   * {@link CountryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountrySubdivisionImpl#getName()}
   */
  @Test
  public void testGetName_givenCountrySubdivisionImplCountryIsCountryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CountrySubdivisionImpl countrySubdivisionImpl = new CountrySubdivisionImpl();
    countrySubdivisionImpl.setCountry(mock(CountryImpl.class));

    // Act and Assert
    assertNull(countrySubdivisionImpl.getName());
  }

  /**
   * Test {@link CountrySubdivisionImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link CountrySubdivisionImpl#getMainEntityName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMainEntityName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3328 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.domain.CountrySubdivisionImpl countrySubdivisionImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CountrySubdivisionImpl()).getMainEntityName();
  }

  /**
   * Test {@link CountrySubdivisionImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CountrySubdivisionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CountrySubdivisionImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenCountrySubdivisionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CountrySubdivisionImpl()).getMainEntityName());
  }

  /**
   * Test {@link CountrySubdivisionImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CountrySubdivisionImpl} (default constructor) Country is
   * {@link CountryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountrySubdivisionImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenCountrySubdivisionImplCountryIsCountryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CountrySubdivisionImpl countrySubdivisionImpl = new CountrySubdivisionImpl();
    countrySubdivisionImpl.setCountry(mock(CountryImpl.class));

    // Act and Assert
    assertNull(countrySubdivisionImpl.getMainEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CountrySubdivisionImpl}
   *   <li>{@link CountrySubdivisionImpl#setAbbreviation(String)}
   *   <li>{@link CountrySubdivisionImpl#setAlternateAbbreviation(String)}
   *   <li>{@link CountrySubdivisionImpl#setCategory(CountrySubdivisionCategory)}
   *   <li>{@link CountrySubdivisionImpl#setCountry(Country)}
   *   <li>{@link CountrySubdivisionImpl#setName(String)}
   *   <li>{@link CountrySubdivisionImpl#getAbbreviation()}
   *   <li>{@link CountrySubdivisionImpl#getAlternateAbbreviation()}
   *   <li>{@link CountrySubdivisionImpl#getCategory()}
   *   <li>{@link CountrySubdivisionImpl#getCountry()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CountrySubdivisionImpl actualCountrySubdivisionImpl = new CountrySubdivisionImpl();
    actualCountrySubdivisionImpl.setAbbreviation("Abbreviation");
    actualCountrySubdivisionImpl.setAlternateAbbreviation("Alternate Abbreviation");
    CountrySubdivisionCategoryImpl category = new CountrySubdivisionCategoryImpl();
    actualCountrySubdivisionImpl.setCategory(category);
    CountryImpl country = new CountryImpl();
    actualCountrySubdivisionImpl.setCountry(country);
    actualCountrySubdivisionImpl.setName("Name");
    String actualAbbreviation = actualCountrySubdivisionImpl.getAbbreviation();
    String actualAlternateAbbreviation = actualCountrySubdivisionImpl.getAlternateAbbreviation();
    CountrySubdivisionCategory actualCategory = actualCountrySubdivisionImpl.getCategory();

    // Assert that nothing has changed
    assertEquals("Abbreviation", actualAbbreviation);
    assertEquals("Alternate Abbreviation", actualAlternateAbbreviation);
    assertSame(country, actualCountrySubdivisionImpl.getCountry());
    assertSame(category, actualCategory);
  }
}
