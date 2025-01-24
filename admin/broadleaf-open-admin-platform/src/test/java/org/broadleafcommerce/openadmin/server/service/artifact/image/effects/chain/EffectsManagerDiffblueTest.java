package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.service.artifact.OperationBuilder;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.ConversionManager;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.AlterHSB;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.AlterRGB;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.AutoLevelsRGB;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.Crop;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.GaussianBlur;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.Resize;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.Rotate;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.UnsharpMask;
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
public class EffectsManagerDiffblueTest {
  @Autowired
  private EffectsManager effectsManager;

  /**
   * Test {@link EffectsManager#buildOperations(Map, InputStream, String)}.
   * <p>
   * Method under test:
   * {@link EffectsManager#buildOperations(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperations() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EffectsManager effectsManager = new EffectsManager();
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertEquals(0, effectsManager.buildOperations(parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")),
        "Mime Type").length);
  }

  /**
   * Test {@link EffectsManager#buildOperations(Map, InputStream, String)}.
   * <p>
   * Method under test:
   * {@link EffectsManager#buildOperations(Map, InputStream, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildOperations2() throws UnsupportedEncodingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1622 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.EffectsManager effectsManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    EffectsManager effectsManager2 = new EffectsManager();
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act
    effectsManager2.buildOperations(parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Mime Type");
  }

  /**
   * Test
   * {@link EffectsManager#renderEffect(String, Double, UnmarshalledParameter[], BufferedImage)}
   * with {@code effectName}, {@code factor}, {@code parameters}, {@code src}.
   * <p>
   * Method under test:
   * {@link EffectsManager#renderEffect(String, Double, UnmarshalledParameter[], BufferedImage)}
   */
  @Test
  public void testRenderEffectWithEffectNameFactorParametersSrc() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EffectsManager effectsManager = new EffectsManager();

    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");

    // Act and Assert
    assertThrows(FilterNotFoundException.class, () -> effectsManager.renderEffect("Effect Name", 10.0d,
        new UnmarshalledParameter[]{unmarshalledParameter}, new BufferedImage(1, 1, 1)));
  }

  /**
   * Test
   * {@link EffectsManager#renderEffect(String, Double, UnmarshalledParameter[], BufferedImage)}
   * with {@code effectName}, {@code factor}, {@code parameters}, {@code src}.
   * <p>
   * Method under test:
   * {@link EffectsManager#renderEffect(String, Double, UnmarshalledParameter[], BufferedImage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRenderEffectWithEffectNameFactorParametersSrc2() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1652 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.EffectsManager effectsManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    EffectsManager effectsManager2 = new EffectsManager();

    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");

    // Act
    effectsManager2.renderEffect("Effect Name", 10.0d, new UnmarshalledParameter[]{unmarshalledParameter},
        new BufferedImage(1, 1, 1));
  }

  /**
   * Test
   * {@link EffectsManager#renderEffect(String, Double, UnmarshalledParameter[], BufferedImage, String)}
   * with {@code effectName}, {@code factor}, {@code parameters}, {@code src},
   * {@code formatName}.
   * <p>
   * Method under test:
   * {@link EffectsManager#renderEffect(String, Double, UnmarshalledParameter[], BufferedImage, String)}
   */
  @Test
  public void testRenderEffectWithEffectNameFactorParametersSrcFormatName() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EffectsManager effectsManager = new EffectsManager();

    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");

    // Act and Assert
    assertThrows(FilterNotFoundException.class, () -> effectsManager.renderEffect("Effect Name", 10.0d,
        new UnmarshalledParameter[]{unmarshalledParameter}, new BufferedImage(1, 1, 1), "Format Name"));
  }

  /**
   * Test
   * {@link EffectsManager#renderEffect(String, Double, UnmarshalledParameter[], BufferedImage, String)}
   * with {@code effectName}, {@code factor}, {@code parameters}, {@code src},
   * {@code formatName}.
   * <p>
   * Method under test:
   * {@link EffectsManager#renderEffect(String, Double, UnmarshalledParameter[], BufferedImage, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRenderEffectWithEffectNameFactorParametersSrcFormatName2() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1682 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.EffectsManager effectsManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    EffectsManager effectsManager2 = new EffectsManager();

    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");

    // Act
    effectsManager2.renderEffect("Effect Name", 10.0d, new UnmarshalledParameter[]{unmarshalledParameter},
        new BufferedImage(1, 1, 1), "Format Name");
  }

  /**
   * Test {@link EffectsManager#setFilters(Map)}.
   * <p>
   * Method under test: {@link EffectsManager#setFilters(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetFilters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1712 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.EffectsManager effectsManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    EffectsManager effectsManager2 = new EffectsManager();

    // Act
    effectsManager2.setFilters(new HashMap<>());
  }

  /**
   * Test {@link EffectsManager#setFilters(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link EffectsManager} (default constructor) Filters size is
   * nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link EffectsManager#setFilters(Map)}
   */
  @Test
  public void testSetFilters_givenFoo_thenEffectsManagerFiltersSizeIsNine() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EffectsManager effectsManager = new EffectsManager();

    HashMap<String, OperationBuilder> filters = new HashMap<>();
    filters.put("foo", mock(OperationBuilder.class));

    // Act
    effectsManager.setFilters(filters);

    // Assert
    Map<String, OperationBuilder> filters2 = effectsManager.getFilters();
    assertEquals(9, filters2.size());
    assertTrue(filters2.containsKey("alterhsb"));
    assertTrue(filters2.containsKey("gaussianblur"));
    assertTrue(filters2.containsKey("resize"));
    assertTrue(filters2.containsKey("rotate"));
    assertTrue(filters2.containsKey("unsharpmask"));
  }

  /**
   * Test {@link EffectsManager#setFilters(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link EffectsManager} (default constructor) Filters size is
   * eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link EffectsManager#setFilters(Map)}
   */
  @Test
  public void testSetFilters_whenHashMap_thenEffectsManagerFiltersSizeIsEight() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EffectsManager effectsManager = new EffectsManager();

    // Act
    effectsManager.setFilters(new HashMap<>());

    // Assert
    Map<String, OperationBuilder> filters = effectsManager.getFilters();
    assertEquals(8, filters.size());
    assertTrue(filters.containsKey("alterhsb"));
    assertTrue(filters.containsKey("autolevelsrgb"));
    assertTrue(filters.containsKey("gaussianblur"));
    assertTrue(filters.containsKey("resize"));
    assertTrue(filters.containsKey("rotate"));
    assertTrue(filters.containsKey("unsharpmask"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EffectsManager#setConversionManager(ConversionManager)}
   *   <li>{@link EffectsManager#getConversionManager()}
   *   <li>{@link EffectsManager#getFilters()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    EffectsManager effectsManager = new EffectsManager();
    ConversionManager conversionManager = new ConversionManager();

    // Act
    effectsManager.setConversionManager(conversionManager);
    ConversionManager actualConversionManager = effectsManager.getConversionManager();
    Map<String, OperationBuilder> actualFilters = effectsManager.getFilters();

    // Assert that nothing has changed
    assertEquals(8, actualFilters.size());
    assertTrue(actualFilters.get("alterhsb") instanceof AlterHSB);
    assertTrue(actualFilters.get("alterrgb") instanceof AlterRGB);
    assertTrue(actualFilters.get("autolevelsrgb") instanceof AutoLevelsRGB);
    assertTrue(actualFilters.get("crop") instanceof Crop);
    assertTrue(actualFilters.get("gaussianblur") instanceof GaussianBlur);
    assertTrue(actualFilters.get("resize") instanceof Resize);
    assertTrue(actualFilters.get("rotate") instanceof Rotate);
    assertTrue(actualFilters.get("unsharpmask") instanceof UnsharpMask);
    assertSame(conversionManager, actualConversionManager);
  }
}
