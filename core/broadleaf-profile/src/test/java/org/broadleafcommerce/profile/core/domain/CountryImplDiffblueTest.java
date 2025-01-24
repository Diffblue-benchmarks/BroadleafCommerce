package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
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
public class CountryImplDiffblueTest {
  @Autowired
  private CountryImpl countryImpl;

  /**
   * Test {@link CountryImpl#getName()}.
   * <p>
   * Method under test: {@link CountryImpl#getName()}
   */
  @Test
  public void testGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CountryImpl()).getName());
  }

  /**
   * Test {@link CountryImpl#getName()}.
   * <p>
   * Method under test: {@link CountryImpl#getName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetName2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3316 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.domain.CountryImpl countryImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CountryImpl()).getName();
  }

  /**
   * Test {@link CountryImpl#equals(Object)}, and {@link CountryImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CountryImpl#equals(Object)}
   *   <li>{@link CountryImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Abbreviation");
    countryImpl.setName("Name");

    CountryImpl countryImpl2 = new CountryImpl();
    countryImpl2.setAbbreviation("Abbreviation");
    countryImpl2.setName("Name");

    // Act and Assert
    assertEquals(countryImpl, countryImpl2);
    int expectedHashCodeResult = countryImpl.hashCode();
    assertEquals(expectedHashCodeResult, countryImpl2.hashCode());
  }

  /**
   * Test {@link CountryImpl#equals(Object)}, and {@link CountryImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CountryImpl#equals(Object)}
   *   <li>{@link CountryImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation(null);
    countryImpl.setName("Name");

    CountryImpl countryImpl2 = new CountryImpl();
    countryImpl2.setAbbreviation(null);
    countryImpl2.setName("Name");

    // Act and Assert
    assertEquals(countryImpl, countryImpl2);
    int expectedHashCodeResult = countryImpl.hashCode();
    assertEquals(expectedHashCodeResult, countryImpl2.hashCode());
  }

  /**
   * Test {@link CountryImpl#equals(Object)}, and {@link CountryImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CountryImpl#equals(Object)}
   *   <li>{@link CountryImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Abbreviation");
    countryImpl.setName(null);

    CountryImpl countryImpl2 = new CountryImpl();
    countryImpl2.setAbbreviation("Abbreviation");
    countryImpl2.setName(null);

    // Act and Assert
    assertEquals(countryImpl, countryImpl2);
    int expectedHashCodeResult = countryImpl.hashCode();
    assertEquals(expectedHashCodeResult, countryImpl2.hashCode());
  }

  /**
   * Test {@link CountryImpl#equals(Object)}, and {@link CountryImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CountryImpl#equals(Object)}
   *   <li>{@link CountryImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Abbreviation");
    countryImpl.setName("Name");

    // Act and Assert
    assertEquals(countryImpl, countryImpl);
    int expectedHashCodeResult = countryImpl.hashCode();
    assertEquals(expectedHashCodeResult, countryImpl.hashCode());
  }

  /**
   * Test {@link CountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Name");
    countryImpl.setName("Name");

    CountryImpl countryImpl2 = new CountryImpl();
    countryImpl2.setAbbreviation("Abbreviation");
    countryImpl2.setName("Name");

    // Act and Assert
    assertNotEquals(countryImpl, countryImpl2);
  }

  /**
   * Test {@link CountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation(null);
    countryImpl.setName("Name");

    CountryImpl countryImpl2 = new CountryImpl();
    countryImpl2.setAbbreviation("Abbreviation");
    countryImpl2.setName("Name");

    // Act and Assert
    assertNotEquals(countryImpl, countryImpl2);
  }

  /**
   * Test {@link CountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Abbreviation");
    countryImpl.setName("Abbreviation");

    CountryImpl countryImpl2 = new CountryImpl();
    countryImpl2.setAbbreviation("Abbreviation");
    countryImpl2.setName("Name");

    // Act and Assert
    assertNotEquals(countryImpl, countryImpl2);
  }

  /**
   * Test {@link CountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Abbreviation");
    countryImpl.setName(null);

    CountryImpl countryImpl2 = new CountryImpl();
    countryImpl2.setAbbreviation("Abbreviation");
    countryImpl2.setName("Name");

    // Act and Assert
    assertNotEquals(countryImpl, countryImpl2);
  }

  /**
   * Test {@link CountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Abbreviation");
    countryImpl.setName("Name");

    // Act and Assert
    assertNotEquals(countryImpl, null);
  }

  /**
   * Test {@link CountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Abbreviation");
    countryImpl.setName("Name");

    // Act and Assert
    assertNotEquals(countryImpl, "Different type to CountryImpl");
  }

  /**
   * Test {@link CountryImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link CountryImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CountryImpl()).getMainEntityName());
  }

  /**
   * Test {@link CountryImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link CountryImpl#getMainEntityName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMainEntityName2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3312 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.domain.CountryImpl countryImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CountryImpl()).getMainEntityName();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CountryImpl}
   *   <li>{@link CountryImpl#setAbbreviation(String)}
   *   <li>{@link CountryImpl#setName(String)}
   *   <li>{@link CountryImpl#getAbbreviation()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CountryImpl actualCountryImpl = new CountryImpl();
    actualCountryImpl.setAbbreviation("Abbreviation");
    actualCountryImpl.setName("Name");

    // Assert that nothing has changed
    assertEquals("Abbreviation", actualCountryImpl.getAbbreviation());
  }
}
