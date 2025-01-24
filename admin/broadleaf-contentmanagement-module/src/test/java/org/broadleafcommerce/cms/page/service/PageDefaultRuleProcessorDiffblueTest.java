package org.broadleafcommerce.cms.page.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class PageDefaultRuleProcessorDiffblueTest {
  @Autowired
  private PageDefaultRuleProcessor pageDefaultRuleProcessor;

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getCategoryAttributesMap()[UU]");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckForMatchWithPageDTOMap2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass535 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageDefaultRuleProcessor pageDefaultRuleProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor2 = new PageDefaultRuleProcessor();
    PageDTO page = new PageDTO();

    // Act
    pageDefaultRuleProcessor2.checkForMatch(page, new HashMap<>());
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link NullPageDTO} {@link PageDTO#getRuleExpression()} return
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap_given42_whenNullPageDTOGetRuleExpressionReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("42");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertTrue(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap_givenFoo_whenHashMapFooIs42_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("foo");

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("foo", "42");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, vars);

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code getAdditionalAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap_givenGetAdditionalAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getAdditionalAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code getAdditionalFields()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap_givenGetAdditionalFieldsUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getAdditionalFields()[UU]");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code getCustomerAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap_givenGetCustomerAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getCustomerAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code getOrderItemAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap_givenGetOrderItemAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getOrderItemAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code getProductAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap_givenGetProductAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getProductAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code getSkuAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap_givenGetSkuAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getSkuAttributes()[UU]");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link HashMap#HashMap()} All is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap_givenHashMap_whenHashMapAllIsHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("foo");

    HashMap<String, Object> vars = new HashMap<>();
    vars.putAll(new HashMap<>());

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, vars);

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code MVEL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap_givenMvel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("MVEL");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>());

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code Page}.</li>
   *   <li>When {@link PageDTO} (default constructor) RuleExpression is
   * {@code Page}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap_givenPage_whenPageDTORuleExpressionIsPage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();

    PageDTO page = new PageDTO();
    page.setRuleExpression("Page");

    // Act and Assert
    assertFalse(pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>()));
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code getCategoryAttributesMap()[UU]} is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap_whenHashMapGetCategoryAttributesMapUuIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    NullPageDTO page = mock(NullPageDTO.class);
    when(page.getRuleExpression()).thenReturn("getProductAttributes()[UU]");

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("getCategoryAttributesMap()[UU]", "42");

    // Act
    boolean actualCheckForMatchResult = pageDefaultRuleProcessor.checkForMatch(page, vars);

    // Assert
    verify(page).getRuleExpression();
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)} with
   * {@code PageDTO}, {@code Map}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageDefaultRuleProcessor#checkForMatch(PageDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithPageDTOMap_whenPageDTO_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    PageDTO page = new PageDTO();

    // Act and Assert
    assertTrue(pageDefaultRuleProcessor.checkForMatch(page, new HashMap<>()));
  }

  /**
   * Test {@link PageDefaultRuleProcessor#getContextClassNames()}.
   * <p>
   * Method under test: {@link PageDefaultRuleProcessor#getContextClassNames()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetContextClassNames() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass560 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageDefaultRuleProcessor pageDefaultRuleProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageDefaultRuleProcessor()).getContextClassNames();
  }

  /**
   * Test {@link PageDefaultRuleProcessor#getContextClassNames()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDefaultRuleProcessor#getContextClassNames()}
   */
  @Test
  public void testGetContextClassNames_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, String> contextClassNames = new HashMap<>();
    contextClassNames.computeIfPresent("foo", mock(BiFunction.class));

    PageDefaultRuleProcessor pageDefaultRuleProcessor = new PageDefaultRuleProcessor();
    pageDefaultRuleProcessor.setContextClassNames(contextClassNames);

    // Act
    Map<String, String> actualContextClassNames = pageDefaultRuleProcessor.getContextClassNames();

    // Assert
    assertEquals(3, actualContextClassNames.size());
    assertEquals("org.broadleafcommerce.common.RequestDTO", actualContextClassNames.get("request"));
    assertEquals("org.broadleafcommerce.common.TimeDTO", actualContextClassNames.get("time"));
    assertEquals("org.broadleafcommerce.profile.core.domain.Customer", actualContextClassNames.get("customer"));
  }

  /**
   * Test {@link PageDefaultRuleProcessor#getContextClassNames()}.
   * <ul>
   *   <li>Given {@link PageDefaultRuleProcessor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageDefaultRuleProcessor#getContextClassNames()}
   */
  @Test
  public void testGetContextClassNames_givenPageDefaultRuleProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Map<String, String> actualContextClassNames = (new PageDefaultRuleProcessor()).getContextClassNames();

    // Assert
    assertEquals(3, actualContextClassNames.size());
    assertEquals("org.broadleafcommerce.common.RequestDTO", actualContextClassNames.get("request"));
    assertEquals("org.broadleafcommerce.common.TimeDTO", actualContextClassNames.get("time"));
    assertEquals("org.broadleafcommerce.profile.core.domain.Customer", actualContextClassNames.get("customer"));
  }
}
