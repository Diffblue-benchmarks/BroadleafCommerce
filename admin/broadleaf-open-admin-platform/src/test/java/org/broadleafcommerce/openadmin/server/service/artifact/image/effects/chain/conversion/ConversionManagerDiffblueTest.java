package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.ConverterNotFoundException;
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
public class ConversionManagerDiffblueTest {
  @Autowired
  private ConversionManager conversionManager;

  /**
   * Test
   * {@link ConversionManager#convertParameter(String, String, Double, boolean)}.
   * <p>
   * Method under test:
   * {@link ConversionManager#convertParameter(String, String, Double, boolean)}
   */
  @Test
  public void testConvertParameter() throws ConverterNotFoundException, ConversionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ConverterNotFoundException.class,
        () -> (new ConversionManager()).convertParameter("42", "Type", 10.0d, true));
  }

  /**
   * Test
   * {@link ConversionManager#convertParameter(String, String, Double, boolean)}.
   * <p>
   * Method under test:
   * {@link ConversionManager#convertParameter(String, String, Double, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertParameter2() throws ConverterNotFoundException, ConversionException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.ConversionManager conversionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ConversionManager()).convertParameter("42", "Type", 10.0d, true);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ConversionManager#setConverters(Map)}
   *   <li>{@link ConversionManager#getConverters()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ConversionManager conversionManager = new ConversionManager();
    HashMap<String, ParameterConverter> converters = new HashMap<>();

    // Act
    conversionManager.setConverters(converters);
    Map<String, ParameterConverter> actualConverters = conversionManager.getConverters();

    // Assert that nothing has changed
    assertTrue(actualConverters.isEmpty());
    assertSame(converters, actualConverters);
  }
}
