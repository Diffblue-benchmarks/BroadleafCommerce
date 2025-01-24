package org.broadleafcommerce.cms.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.presentation.model.BroadleafAttributeModifier;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml",
    "/applicationContext-servlet-cms-contentCreator.xml", "/bl-cms-applicationContext-entity.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class HrefUrlRewriteProcessorDiffblueTest {
  @Autowired
  private HrefUrlRewriteProcessor hrefUrlRewriteProcessor;

  /**
   * Test {@link HrefUrlRewriteProcessor#getName()}.
   * <p>
   * Method under test: {@link HrefUrlRewriteProcessor#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("href", (new HrefUrlRewriteProcessor()).getName());
  }

  /**
   * Test
   * {@link HrefUrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link HrefUrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetModifiedAttributes() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3404 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.HrefUrlRewriteProcessor hrefUrlRewriteProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    HrefUrlRewriteProcessor hrefUrlRewriteProcessor2 = new HrefUrlRewriteProcessor();

    // Act
    hrefUrlRewriteProcessor2.getModifiedAttributes("https://example.org/example", new HashMap<>(),
        "https://example.org/example", "https://example.org/example", mock(BroadleafTemplateContext.class));
  }

  /**
   * Test
   * {@link HrefUrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code useCDN}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code useCDN} is {@code useCDN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HrefUrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_givenUseCDN_whenHashMapUseCDNIsUseCDN() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HrefUrlRewriteProcessor hrefUrlRewriteProcessor = new HrefUrlRewriteProcessor();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("useCDN", "useCDN");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = hrefUrlRewriteProcessor.getModifiedAttributes(
        "https://example.org/example", tagAttributes, "https://example.org/example", "https://example.org/example",
        context);

    // Assert
    verify(context).parseExpression(eq("https://example.org/example"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("Parse Expression", added.get("href"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link HrefUrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Added size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HrefUrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_whenHashMap_thenReturnAddedSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HrefUrlRewriteProcessor hrefUrlRewriteProcessor = new HrefUrlRewriteProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = hrefUrlRewriteProcessor.getModifiedAttributes(
        "https://example.org/example", tagAttributes, "https://example.org/example", "https://example.org/example",
        context);

    // Assert
    verify(context).parseExpression(eq("https://example.org/example"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("Parse Expression", added.get("href"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }

  /**
   * Test
   * {@link HrefUrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return Added size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HrefUrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testGetModifiedAttributes_whenSlash_thenReturnAddedSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HrefUrlRewriteProcessor hrefUrlRewriteProcessor = new HrefUrlRewriteProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    BroadleafAttributeModifier actualModifiedAttributes = hrefUrlRewriteProcessor.getModifiedAttributes(
        "https://example.org/example", tagAttributes, "https://example.org/example", "/", context);

    // Assert
    verify(context).parseExpression(eq("@{ / }"));
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("Parse Expression", added.get("href"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }
}
