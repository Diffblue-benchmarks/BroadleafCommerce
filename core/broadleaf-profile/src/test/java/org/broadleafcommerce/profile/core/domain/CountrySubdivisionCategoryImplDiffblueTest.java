package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
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
public class CountrySubdivisionCategoryImplDiffblueTest {
  @Autowired
  private CountrySubdivisionCategoryImpl countrySubdivisionCategoryImpl;

  /**
   * Test {@link CountrySubdivisionCategoryImpl#getName()}.
   * <p>
   * Method under test: {@link CountrySubdivisionCategoryImpl#getName()}
   */
  @Test
  public void testGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CountrySubdivisionCategoryImpl()).getName());
  }

  /**
   * Test {@link CountrySubdivisionCategoryImpl#getName()}.
   * <p>
   * Method under test: {@link CountrySubdivisionCategoryImpl#getName()}
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
    //   public class DiffblueFakeClass3324 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.domain.CountrySubdivisionCategoryImpl countrySubdivisionCategoryImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CountrySubdivisionCategoryImpl()).getName();
  }

  /**
   * Test {@link CountrySubdivisionCategoryImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link CountrySubdivisionCategoryImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CountrySubdivisionCategoryImpl()).getMainEntityName());
  }

  /**
   * Test {@link CountrySubdivisionCategoryImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link CountrySubdivisionCategoryImpl#getMainEntityName()}
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
    //   public class DiffblueFakeClass3320 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.domain.CountrySubdivisionCategoryImpl countrySubdivisionCategoryImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CountrySubdivisionCategoryImpl()).getMainEntityName();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link CountrySubdivisionCategoryImpl}
   *   <li>{@link CountrySubdivisionCategoryImpl#setId(Long)}
   *   <li>{@link CountrySubdivisionCategoryImpl#setName(String)}
   *   <li>{@link CountrySubdivisionCategoryImpl#getId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CountrySubdivisionCategoryImpl actualCountrySubdivisionCategoryImpl = new CountrySubdivisionCategoryImpl();
    actualCountrySubdivisionCategoryImpl.setId(1L);
    actualCountrySubdivisionCategoryImpl.setName("Name");

    // Assert that nothing has changed
    assertEquals(1L, actualCountrySubdivisionCategoryImpl.getId().longValue());
  }
}
