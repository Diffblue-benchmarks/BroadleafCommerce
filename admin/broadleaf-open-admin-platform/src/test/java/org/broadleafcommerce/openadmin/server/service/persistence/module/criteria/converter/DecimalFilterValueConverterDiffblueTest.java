package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.math.BigDecimal;
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
public class DecimalFilterValueConverterDiffblueTest {
  @Autowired
  private DecimalFilterValueConverter decimalFilterValueConverter;

  /**
   * Test {@link DecimalFilterValueConverter#convert(String)}.
   * <p>
   * Method under test: {@link DecimalFilterValueConverter#convert(String)}
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
    //   public class DiffblueFakeClass8363 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.DecimalFilterValueConverter decimalFilterValueConverter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DecimalFilterValueConverter()).convert("42");
  }

  /**
   * Test {@link DecimalFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DecimalFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert_when42_thenReturnBigDecimalWith42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    BigDecimal actualConvertResult = (new DecimalFilterValueConverter()).convert("42");

    // Assert
    assertEquals(new BigDecimal("42"), actualConvertResult);
  }

  /**
   * Test {@link DecimalFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DecimalFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert_whenEmptyString_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DecimalFilterValueConverter()).convert(""));
  }

  /**
   * Test {@link DecimalFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DecimalFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DecimalFilterValueConverter()).convert(null));
  }

  /**
   * Test {@link DecimalFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@code String Value}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DecimalFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert_whenStringValue_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DecimalFilterValueConverter()).convert("String Value"));
  }
}
