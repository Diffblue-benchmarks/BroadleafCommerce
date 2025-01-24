package org.broadleafcommerce.cms.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.function.BiFunction;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.cms.structure.domain.StructuredContentType;
import org.broadleafcommerce.cms.structure.domain.StructuredContentTypeImpl;
import org.broadleafcommerce.common.TimeDTO;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml",
    "/applicationContext-servlet-cms-contentCreator.xml", "/bl-cms-applicationContext-entity.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ContentProcessorDiffblueTest {
  @Autowired
  private ContentProcessor contentProcessor;

  /**
   * Test {@link ContentProcessor#getName()}.
   * <p>
   * Method under test: {@link ContentProcessor#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("content", (new ContentProcessor()).getName());
  }

  /**
   * Test {@link ContentProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link ContentProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new ContentProcessor()).getPrecedence());
  }

  /**
   * Test {@link ContentProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link ContentProcessor#getPrecedence()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPrecedence2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3314 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.ContentProcessor contentProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ContentProcessor()).getPrecedence();
  }

  /**
   * Test {@link ContentProcessor#getAttributeValue(Map, String, String)}.
   * <p>
   * Method under test:
   * {@link ContentProcessor#getAttributeValue(Map, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAttributeValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3145 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.ContentProcessor contentProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ContentProcessor contentProcessor2 = new ContentProcessor();

    // Act
    contentProcessor2.getAttributeValue(new HashMap<>(), "42", "42");
  }

  /**
   * Test {@link ContentProcessor#getAttributeValue(Map, String, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#getAttributeValue(Map, String, String)}
   */
  @Test
  public void testGetAttributeValue_given42_whenHashMap42IsFoo_thenReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("42", "foo");

    // Act and Assert
    assertEquals("foo", contentProcessor.getAttributeValue(tagAttributes, "42", "42"));
  }

  /**
   * Test {@link ContentProcessor#getAttributeValue(Map, String, String)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#getAttributeValue(Map, String, String)}
   */
  @Test
  public void testGetAttributeValue_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals("42", contentProcessor.getAttributeValue(tagAttributes, "42", "42"));
  }

  /**
   * Test {@link ContentProcessor#getAttributeValue(Map, String, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#getAttributeValue(Map, String, String)}
   */
  @Test
  public void testGetAttributeValue_whenHashMap_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    // Act and Assert
    assertEquals("42", contentProcessor.getAttributeValue(new HashMap<>(), "42", "42"));
  }

  /**
   * Test
   * {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateModelVariables() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3384 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.ContentProcessor contentProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ContentProcessor contentProcessor2 = new ContentProcessor();

    // Act
    contentProcessor2.populateModelVariables("Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));
  }

  /**
   * Test
   * {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link HashMap#HashMap()} {@code contentType} is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testPopulateModelVariables_givenEmptyString_whenHashMapContentTypeIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("contentType", "");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> contentProcessor.populateModelVariables("Tag Name", tagAttributes, mock(BroadleafTemplateContext.class)));
  }

  /**
   * Test
   * {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testPopulateModelVariables_whenHashMap_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> contentProcessor.populateModelVariables("Tag Name",
        new HashMap<>(), mock(BroadleafTemplateContext.class)));
  }

  /**
   * Test
   * {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetContentItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3171 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.ContentProcessor contentProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ContentProcessor contentProcessor2 = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    contentProcessor2.getContentItems("Not all who wander are lost", 3, request, mvelParameters, currentSandbox,
        structuredContentType, locale, "Tag Name", tagAttributes, new HashMap<>(),
        mock(BroadleafTemplateContext.class));
  }

  /**
   * Test
   * {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#getScheme()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testGetContentItems_givenIllegalArgumentExceptionWithFoo_thenCallsGetScheme() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getScheme()).thenThrow(new IllegalArgumentException("foo"));
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    contentProcessor.getContentItems("Not all who wander are lost", 3, request, mvelParameters, currentSandbox,
        structuredContentType, locale, "Tag Name", tagAttributes, new HashMap<>(),
        mock(BroadleafTemplateContext.class));

    // Assert
    verify(request).getScheme();
  }

  /**
   * Test
   * {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#getScheme()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testGetContentItems_givenIllegalArgumentExceptionWithFoo_thenCallsGetScheme2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getScheme()).thenThrow(new IllegalArgumentException("foo"));
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    contentProcessor.getContentItems(null, 3, request, mvelParameters, currentSandbox, structuredContentType, locale,
        "Tag Name", tagAttributes, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(request).getScheme();
  }

  /**
   * Test
   * {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#getScheme()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testGetContentItems_givenIllegalArgumentExceptionWithFoo_thenCallsGetScheme3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getScheme()).thenThrow(new IllegalArgumentException("foo"));
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    contentProcessor.getContentItems("Not all who wander are lost", 3, request, mvelParameters, currentSandbox, null,
        locale, "Tag Name", tagAttributes, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(request).getScheme();
  }

  /**
   * Test
   * {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then calls {@link ServletRequestWrapper#getScheme()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#getContentItems(String, Integer, HttpServletRequest, Map, SandBox, StructuredContentType, Locale, String, Map, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testGetContentItems_whenEmptyString_thenCallsGetScheme() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getScheme()).thenThrow(new IllegalArgumentException("foo"));
    HashMap<String, Object> mvelParameters = new HashMap<>();
    SandBoxImpl currentSandbox = new SandBoxImpl();
    StructuredContentTypeImpl structuredContentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();
    HashMap<String, String> tagAttributes = new HashMap<>();

    // Act
    contentProcessor.getContentItems("", 3, request, mvelParameters, currentSandbox, structuredContentType, locale,
        "Tag Name", tagAttributes, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(request).getScheme();
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildMvelParameters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3069 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.ContentProcessor contentProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ContentProcessor contentProcessor2 = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    contentProcessor2.buildMvelParameters(request, new HashMap<>(), mock(BroadleafTemplateContext.class));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code Parse Expression}.</li>
   *   <li>Then return {@code category} is {@code Parse Expression}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_givenParseExpression_thenReturnCategoryIsParseExpression() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", "Tag Attributes");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, tagAttributes,
        context);

    // Assert
    verify(context).parseExpression(eq("Tag Attributes"));
    assertEquals(3, actualBuildMvelParametersResult.size());
    assertEquals("Parse Expression", actualBuildMvelParametersResult.get("category"));
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
    assertTrue(actualBuildMvelParametersResult.containsKey("time"));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@code Parse Expression}.</li>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_givenParseExpression_thenReturnSizeIsFour() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", "ThreadLocalManager.notify.orphans");
    tagAttributes.put("category", "Tag Attributes");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, tagAttributes,
        context);

    // Assert
    verify(context, atLeast(1)).parseExpression(Mockito.<String>any());
    assertEquals(4, actualBuildMvelParametersResult.size());
    assertEquals("Parse Expression", actualBuildMvelParametersResult.get("product"));
    assertTrue(actualBuildMvelParametersResult.containsKey("category"));
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
    assertTrue(actualBuildMvelParametersResult.containsKey("time"));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then {@code category} return {@link BroadleafRequestContext}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_thenCategoryReturnBroadleafRequestContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", "Tag Attributes");
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);
    TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
    broadleafRequestContext.setTimeZone(timeZone);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(broadleafRequestContext);

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, tagAttributes,
        context);

    // Assert
    verify(context).parseExpression(eq("Tag Attributes"));
    assertEquals(3, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    Object getResult = actualBuildMvelParametersResult.get("category");
    assertTrue(getResult instanceof BroadleafRequestContext);
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
    assertSame(timeZone, ((BroadleafRequestContext) getResult).getTimeZone());
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return {@code category} is BroadleafRequestContext is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_thenReturnCategoryIsBroadleafRequestContextIsTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", "Tag Attributes");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(broadleafRequestContext);

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, tagAttributes,
        context);

    // Assert
    verify(context).parseExpression(eq("Tag Attributes"));
    assertEquals(3, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
    assertTrue(actualBuildMvelParametersResult.containsKey("time"));
    assertSame(broadleafRequestContext, actualBuildMvelParametersResult.get("category"));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", "Tag Attributes");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> contentProcessor.buildMvelParameters(request, tagAttributes, context));
    verify(context).parseExpression(eq("Tag Attributes"));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_thenThrowIllegalArgumentException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", "ThreadLocalManager.notify.orphans");
    tagAttributes.put("category", "Tag Attributes");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> contentProcessor.buildMvelParameters(request, tagAttributes, context));
    verify(context).parseExpression(eq("ThreadLocalManager.notify.orphans"));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link BroadleafTemplateContext}
   * {@link BroadleafTemplateContext#parseExpression(String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_whenBroadleafTemplateContextParseExpressionReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", null);
    tagAttributes.put("category", "Tag Attributes");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(null);

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, tagAttributes,
        context);

    // Assert
    verify(context).parseExpression(eq("Tag Attributes"));
    assertEquals(2, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link BroadleafTemplateContext}
   * {@link BroadleafTemplateContext#parseExpression(String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_whenBroadleafTemplateContextParseExpressionReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> tagAttributes = new HashMap<>();
    tagAttributes.put("product", "ThreadLocalManager.notify.orphans");
    tagAttributes.put("category", "Tag Attributes");
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(null);

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, tagAttributes,
        context);

    // Assert
    verify(context, atLeast(1)).parseExpression(Mockito.<String>any());
    assertEquals(2, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
  }

  /**
   * Test
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessor#buildMvelParameters(HttpServletRequest, Map, BroadleafTemplateContext)}
   */
  @Test
  public void testBuildMvelParameters_whenHashMap_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    Map<String, Object> actualBuildMvelParametersResult = contentProcessor.buildMvelParameters(request, new HashMap<>(),
        mock(BroadleafTemplateContext.class));

    // Assert
    assertEquals(2, actualBuildMvelParametersResult.size());
    assertTrue(actualBuildMvelParametersResult.get("time") instanceof TimeDTO);
    assertTrue(actualBuildMvelParametersResult.containsKey("request"));
  }

  /**
   * Test {@link ContentProcessor#isSecure(HttpServletRequest)}.
   * <p>
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsSecure() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3315 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.ContentProcessor contentProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ContentProcessor contentProcessor2 = new ContentProcessor();

    // Act
    contentProcessor2.isSecure(new MockHttpServletRequest());
  }

  /**
   * Test {@link ContentProcessor#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code HTTPS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_givenHttps() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getScheme()).thenReturn("HTTPS");

    // Act
    boolean actualIsSecureResult = contentProcessor.isSecure(request);

    // Assert
    verify(request).getScheme();
    assertTrue(actualIsSecureResult);
  }

  /**
   * Test {@link ContentProcessor#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code HTTPS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_givenIllegalArgumentExceptionWithHttps() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getScheme()).thenThrow(new IllegalArgumentException("HTTPS"));

    // Act
    contentProcessor.isSecure(request);

    // Assert
    verify(request).getScheme();
  }

  /**
   * Test {@link ContentProcessor#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#isSecure()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_givenTrue_thenCallsIsSecure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.isSecure()).thenReturn(true);
    when(request.getScheme()).thenReturn("Scheme");

    // Act
    boolean actualIsSecureResult = contentProcessor.isSecure(request);

    // Assert
    verify(request).getScheme();
    verify(request).isSecure();
    assertTrue(actualIsSecureResult);
  }

  /**
   * Test {@link ContentProcessor#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_whenMockHttpServletRequest_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessor contentProcessor = new ContentProcessor();

    // Act and Assert
    assertFalse(contentProcessor.isSecure(new MockHttpServletRequest()));
  }

  /**
   * Test {@link ContentProcessor#isSecure(HttpServletRequest)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentProcessor#isSecure(HttpServletRequest)}
   */
  @Test
  public void testIsSecure_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ContentProcessor()).isSecure(null));
  }
}
