package org.broadleafcommerce.core.web.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.common.i18n.domain.ISOCountry;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class BasicAddressVariableExpressionDiffblueTest {
  @Autowired
  private BasicAddressVariableExpression basicAddressVariableExpression;

  /**
   * Test {@link BasicAddressVariableExpression#getName()}.
   * <p>
   * Method under test: {@link BasicAddressVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("address", (new BasicAddressVariableExpression()).getName());
  }

  /**
   * Test {@link BasicAddressVariableExpression#getStateOptions()}.
   * <p>
   * Method under test: {@link BasicAddressVariableExpression#getStateOptions()}
   */
  @Test
  @DisplayName("Test getStateOptions()")
  @Disabled("TODO: Complete this test")
  void testGetStateOptions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2796 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.BasicAddressVariableExpression basicAddressVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicAddressVariableExpression()).getStateOptions();
  }

  /**
   * Test
   * {@link BasicAddressVariableExpression#getCountrySubOptionsByISOCountry(ISOCountry)}.
   * <p>
   * Method under test:
   * {@link BasicAddressVariableExpression#getCountrySubOptionsByISOCountry(ISOCountry)}
   */
  @Test
  @DisplayName("Test getCountrySubOptionsByISOCountry(ISOCountry)")
  @Disabled("TODO: Complete this test")
  void testGetCountrySubOptionsByISOCountry() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2787 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.BasicAddressVariableExpression basicAddressVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicAddressVariableExpression basicAddressVariableExpression2 = new BasicAddressVariableExpression();

    // Act
    basicAddressVariableExpression2.getCountrySubOptionsByISOCountry(new ISOCountryImpl());
  }

  /**
   * Test
   * {@link BasicAddressVariableExpression#getCountrySubOptionsByISOCountry(ISOCountry)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicAddressVariableExpression#getCountrySubOptionsByISOCountry(ISOCountry)}
   */
  @Test
  @DisplayName("Test getCountrySubOptionsByISOCountry(ISOCountry); when 'null'; then return Empty")
  void testGetCountrySubOptionsByISOCountry_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BasicAddressVariableExpression()).getCountrySubOptionsByISOCountry(null).isEmpty());
  }

  /**
   * Test
   * {@link BasicAddressVariableExpression#getCountrySubOptionsByCountryAbbrev(String)}.
   * <p>
   * Method under test:
   * {@link BasicAddressVariableExpression#getCountrySubOptionsByCountryAbbrev(String)}
   */
  @Test
  @DisplayName("Test getCountrySubOptionsByCountryAbbrev(String)")
  @Disabled("TODO: Complete this test")
  void testGetCountrySubOptionsByCountryAbbrev() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2479 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.BasicAddressVariableExpression basicAddressVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicAddressVariableExpression()).getCountrySubOptionsByCountryAbbrev("GB");
  }

  /**
   * Test {@link BasicAddressVariableExpression#getCountryOptions()}.
   * <p>
   * Method under test: {@link BasicAddressVariableExpression#getCountryOptions()}
   */
  @Test
  @DisplayName("Test getCountryOptions()")
  @Disabled("TODO: Complete this test")
  void testGetCountryOptions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2478 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.BasicAddressVariableExpression basicAddressVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicAddressVariableExpression()).getCountryOptions();
  }
}
