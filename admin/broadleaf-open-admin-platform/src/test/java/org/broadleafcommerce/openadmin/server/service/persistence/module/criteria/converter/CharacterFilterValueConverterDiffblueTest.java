package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter;

import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CharacterFilterValueConverterDiffblueTest {
  @Autowired
  private CharacterFilterValueConverter characterFilterValueConverter;

  /**
   * Test {@link CharacterFilterValueConverter#convert(String)}.
   * <p>
   * Method under test: {@link CharacterFilterValueConverter#convert(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvert() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8278 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.CharacterFilterValueConverter characterFilterValueConverter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CharacterFilterValueConverter()).convert("42");
  }

  /**
   * Test {@link CharacterFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return charValue is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharacterFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert_when42_thenReturnCharValueIs4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('4', (new CharacterFilterValueConverter()).convert("42").charValue());
  }

  /**
   * Test {@link CharacterFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@link Boolean#FALSE} toString.</li>
   *   <li>Then return charValue is {@code N}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharacterFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert_whenFalseToString_thenReturnCharValueIsN() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CharacterFilterValueConverter characterFilterValueConverter = new CharacterFilterValueConverter();

    // Act and Assert
    assertEquals('N', characterFilterValueConverter.convert(Boolean.FALSE.toString()).charValue());
  }

  /**
   * Test {@link CharacterFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@link Boolean#TRUE} toString.</li>
   *   <li>Then return charValue is {@code Y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharacterFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert_whenTrueToString_thenReturnCharValueIsY() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CharacterFilterValueConverter characterFilterValueConverter = new CharacterFilterValueConverter();

    // Act and Assert
    assertEquals('Y', characterFilterValueConverter.convert(Boolean.TRUE.toString()).charValue());
  }
}
