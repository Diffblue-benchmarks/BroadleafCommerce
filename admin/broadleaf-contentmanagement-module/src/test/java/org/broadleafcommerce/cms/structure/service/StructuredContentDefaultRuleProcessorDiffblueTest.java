package org.broadleafcommerce.cms.structure.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.structure.dto.StructuredContentDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {StructuredContentDefaultRuleProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StructuredContentDefaultRuleProcessorDiffblueTest {
  @Autowired private StructuredContentDefaultRuleProcessor structuredContentDefaultRuleProcessor;

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   *
   * <p>Method under test: {@link
   * StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("42");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   *
   * <p>Method under test: {@link
   * StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap2() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("getProductAttributes()[xx]");
    sc.setValues(new HashMap<>());

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("getProductAttributes()[xx]", "42");

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, vars));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap_givenEmptyString() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertTrue(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code getAdditionalAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap_givenGetAdditionalAttributesXx() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("getAdditionalAttributes()[xx]");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code getAdditionalFields()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap_givenGetAdditionalFieldsXx() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("getAdditionalFields()[xx]");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code getCategoryAttributesMap()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap_givenGetCategoryAttributesMapXx() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("getCategoryAttributesMap()[xx]");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code getCustomerAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap_givenGetCustomerAttributesXx() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("getCustomerAttributes()[xx]");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code getOrderItemAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap_givenGetOrderItemAttributesXx() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("getOrderItemAttributes()[xx]");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code getProductAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap_givenGetProductAttributesXx() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("getProductAttributes()[xx]");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code getSkuAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap_givenGetSkuAttributesXx() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("getSkuAttributes()[xx]");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code MVEL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap_givenMvel() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("MVEL");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap_givenNull() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setValues(new HashMap<>());
    sc.setRuleExpression(null);

    // Act and Assert
    assertTrue(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code Sc}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentDefaultRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap_givenSc() {
    // Arrange
    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setValues(new HashMap<>());
    sc.setRuleExpression("Sc");

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#getContextClassNames()}.
   *
   * <p>Method under test: {@link StructuredContentDefaultRuleProcessor#getContextClassNames()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StructuredContentDefaultRuleProcessor.getContextClassNames()"})
  public void testGetContextClassNames() {
    // Arrange and Act
    Map<String, String> actualContextClassNames =
        structuredContentDefaultRuleProcessor.getContextClassNames();

    // Assert
    assertEquals(4, actualContextClassNames.size());
    assertEquals("org.broadleafcommerce.common.RequestDTO", actualContextClassNames.get("request"));
    assertEquals("org.broadleafcommerce.common.TimeDTO", actualContextClassNames.get("time"));
    assertEquals(
        "org.broadleafcommerce.core.catalog.domain.Product",
        actualContextClassNames.get("product"));
    assertEquals(
        "org.broadleafcommerce.profile.core.domain.Customer",
        actualContextClassNames.get("customer"));
  }
}
