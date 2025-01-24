package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.broadleafcommerce.core.search.domain.IndexFieldType;
import org.broadleafcommerce.core.search.domain.IndexFieldTypeImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MvelToSearchCriteriaConversionServiceImplDiffblueTest {
  @Autowired
  private MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvert() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14073 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new MvelToSearchCriteriaConversionServiceImpl()).convert("Mvel Rule");
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   * <ul>
   *   <li>When {@code Mvel Rule}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  public void testConvert_whenMvelRule_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new MvelToSearchCriteriaConversionServiceImpl()).convert("Mvel Rule"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}.
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsProductRule() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14318 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new MvelToSearchCriteriaConversionServiceImpl()).isProductRule("Rule");
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}.
   * <ul>
   *   <li>When {@code product.}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}
   */
  @Test
  public void testIsProductRule_whenProduct_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MvelToSearchCriteriaConversionServiceImpl()).isProductRule("product."));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}.
   * <ul>
   *   <li>When {@code Rule}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}
   */
  @Test
  public void testIsProductRule_whenRule_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MvelToSearchCriteriaConversionServiceImpl()).isProductRule("Rule"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}.
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsCustomFieldIndexed() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14313 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl2 = new MvelToSearchCriteriaConversionServiceImpl();

    // Act
    mvelToSearchCriteriaConversionServiceImpl2.isCustomFieldIndexed(new ArrayList<>());
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}.
   * <ul>
   *   <li>Given {@link IndexFieldTypeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  public void testIsCustomFieldIndexed_givenIndexFieldTypeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl = new MvelToSearchCriteriaConversionServiceImpl();

    ArrayList<IndexFieldType> indexFieldTypes = new ArrayList<>();
    indexFieldTypes.add(new IndexFieldTypeImpl());

    // Act and Assert
    assertTrue(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(indexFieldTypes));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}.
   * <ul>
   *   <li>Given {@link IndexFieldTypeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  public void testIsCustomFieldIndexed_givenIndexFieldTypeImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl = new MvelToSearchCriteriaConversionServiceImpl();

    ArrayList<IndexFieldType> indexFieldTypes = new ArrayList<>();
    indexFieldTypes.add(new IndexFieldTypeImpl());
    indexFieldTypes.add(new IndexFieldTypeImpl());

    // Act and Assert
    assertTrue(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(indexFieldTypes));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}.
   * <ul>
   *   <li>Given {@link IndexFieldTypeImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  public void testIsCustomFieldIndexed_givenIndexFieldTypeImpl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl = new MvelToSearchCriteriaConversionServiceImpl();

    ArrayList<IndexFieldType> indexFieldTypes = new ArrayList<>();
    indexFieldTypes.add(mock(IndexFieldTypeImpl.class));

    // Act and Assert
    assertTrue(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(indexFieldTypes));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  public void testIsCustomFieldIndexed_whenArrayList_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl = new MvelToSearchCriteriaConversionServiceImpl();

    // Act and Assert
    assertFalse(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(new ArrayList<>()));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  public void testIsCustomFieldIndexed_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MvelToSearchCriteriaConversionServiceImpl()).isCustomFieldIndexed(null));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}.
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsCategoryTargetingRule() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14283 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new MvelToSearchCriteriaConversionServiceImpl()).isCategoryTargetingRule("Mvel Rule");
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}
   */
  @Test
  public void testIsCategoryTargetingRule_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MvelToSearchCriteriaConversionServiceImpl()).isCategoryTargetingRule(
        "CollectionUtils.intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}.
   * <ul>
   *   <li>When {@code Mvel Rule}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}
   */
  @Test
  public void testIsCategoryTargetingRule_whenMvelRule_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MvelToSearchCriteriaConversionServiceImpl()).isCategoryTargetingRule("Mvel Rule"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCategoryIds(String)}.
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCategoryIds(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCategoryIds() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14163 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new MvelToSearchCriteriaConversionServiceImpl()).getCategoryIds("Mvel Rule");
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCategoryIds(String)}.
   * <ul>
   *   <li>When {@code 42"]}.</li>
   *   <li>Then return array of {@link Long} with two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCategoryIds(String)}
   */
  @Test
  public void testGetCategoryIds_when42_thenReturnArrayOfLongWithTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertArrayEquals(new Long[]{2L}, (new MvelToSearchCriteriaConversionServiceImpl()).getCategoryIds("42\"]"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertRuleToFilters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14133 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new MvelToSearchCriteriaConversionServiceImpl()).convertRuleToFilters("Match Rule");
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <ul>
   *   <li>When {@code &&}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  public void testConvertRuleToFilters_whenAmpersandAmpersand_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Collection<String> actualConvertRuleToFiltersResult = (new MvelToSearchCriteriaConversionServiceImpl())
        .convertRuleToFilters("&&");

    // Assert
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  public void testConvertRuleToFilters_whenEmptyString_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Collection<String> actualConvertRuleToFiltersResult = (new MvelToSearchCriteriaConversionServiceImpl())
        .convertRuleToFilters("");

    // Assert
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <ul>
   *   <li>When {@code ||}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  public void testConvertRuleToFilters_whenVerticalLineVerticalLine_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Collection<String> actualConvertRuleToFiltersResult = (new MvelToSearchCriteriaConversionServiceImpl())
        .convertRuleToFilters("||");

    // Assert
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertEquals(1, actualConvertRuleToFiltersResult.size());
    assertEquals("", ((List<String>) actualConvertRuleToFiltersResult).get(0));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\"))", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?\"))"));
    assertEquals("\\\"))", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?\"))"));
    assertEquals("\"))", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\"))?"));
    assertEquals("\"))\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\"))\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertFieldName2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14103 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("Field Name");
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code *\}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnAsteriskBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("*\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("*\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \*}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnBackslashAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\*", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?*"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \\}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnBackslashBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \:("}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnBackslashColonLeftParenthesisQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\:(\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?:(\""));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \=}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnBackslashEqualsSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\=", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?="));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \!}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnBackslashExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?!"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \!=}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnBackslashExclamationMarkEqualsSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!=", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?!="));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \!="}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnBackslashExclamationMarkEqualsSignQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\!=\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?!=\""));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnBackslashQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?\""));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \","}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnBackslashQuotationMarkCommaQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\",\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?\",\""));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \")}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnBackslashQuotationMarkRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\\")", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?\")"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code :("}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnColonLeftParenthesisQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(":(\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?:(\""));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code !\}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnExclamationMarkBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("!\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("!\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code !=\}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnExclamationMarkEqualsSignBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("!=\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("!=\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code !="\}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnExclamationMarkEqualsSignQuotationMarkBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("!=\"\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("!=\"\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code ()\}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnLeftParenthesisRightParenthesisBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("()\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("()\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code "\}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnQuotationMarkBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\"\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\"\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code ","\}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnQuotationMarkCommaQuotationMarkBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\",\"\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\",\"\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code ")\}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_thenReturnQuotationMarkRightParenthesisBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\")\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\")\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_when42_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?42"));
    assertEquals("\\42", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?42"));
    assertEquals("42", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("42?"));
    assertEquals("42\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("42\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code *?}.</li>
   *   <li>Then return {@code *}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenAsteriskQuestionMark_thenReturnAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("*", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("*?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code \?()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenBackslashQuestionMarkLeftParenthesisRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?()"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code \??}.</li>
   *   <li>Then return {@code \}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenBackslashQuestionMarkQuestionMark_thenReturnBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\??"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code \?}.</li>
   *   <li>Then return {@code \}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenBackslashQuestionMark_thenReturnBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?.contains}.</li>
   *   <li>Then return {@code .contains}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenContains_thenReturnContains() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(".contains", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?.contains"));
    assertEquals("\\.contains", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?.contains"));
    assertEquals(".contains", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName(".contains?"));
    assertEquals(".contains\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName(".contains\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?.endsWith}.</li>
   *   <li>Then return {@code .endsWith}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenEndsWith_thenReturnEndsWith() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(".endsWith", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?.endsWith"));
    assertEquals("\\.endsWith", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?.endsWith"));
    assertEquals(".endsWith", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName(".endsWith?"));
    assertEquals(".endsWith\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName(".endsWith\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code !=?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenExclamationMarkEqualsSignQuestionMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("!=", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("!=?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code !="?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenExclamationMarkEqualsSignQuotationMarkQuestionMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("!=\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("!=\"?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code !?}.</li>
   *   <li>Then return {@code !}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenExclamationMarkQuestionMark_thenReturnExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("!", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("!?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code Field Name}.</li>
   *   <li>Then return {@code Field Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenFieldName_thenReturnFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Field Name", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("Field Name"));
    assertEquals("Field Name", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?Field Name"));
    assertEquals("\\Field Name", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?Field Name"));
    assertEquals("Field Name", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("Field Name?"));
    assertEquals("Field Name\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("Field Name\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code product.\?}.</li>
   *   <li>Then return {@code \}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenProduct_thenReturnBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("product.\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code product.}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenProduct_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("product."));
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?product."));
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("product.?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code \?product.}.</li>
   *   <li>Then return {@code \product.}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenProduct_thenReturnProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\product.", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?product."));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?*}.</li>
   *   <li>Then return {@code *}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenQuestionMarkAsterisk_thenReturnAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("*", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?*"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?\?}.</li>
   *   <li>Then return {@code \}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenQuestionMarkBackslashQuestionMark_thenReturnBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\\", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?\\?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?=}.</li>
   *   <li>Then return {@code =}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenQuestionMarkEqualsSign_thenReturnEqualsSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("=", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?="));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?!=}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenQuestionMarkExclamationMarkEqualsSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("!=", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?!="));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?!="}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenQuestionMarkExclamationMarkEqualsSignQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("!=\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?!=\""));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?!}.</li>
   *   <li>Then return {@code !}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenQuestionMarkExclamationMark_thenReturnExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("!", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?!"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ??}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenQuestionMarkQuestionMark_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("??"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?","}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenQuestionMarkQuotationMarkCommaQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\",\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?\",\""));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?")}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenQuestionMarkQuotationMarkRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\")", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?\")"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?"}.</li>
   *   <li>Then return {@code "}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenQuestionMarkQuotationMark_thenReturnQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?\""));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenQuestionMark_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ","?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenQuotationMarkCommaQuotationMarkQuestionMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\",\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\",\"?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code "?}.</li>
   *   <li>Then return {@code "}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenQuotationMarkQuestionMark_thenReturnQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\"", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\"?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ")?}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenQuotationMarkRightParenthesisQuestionMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\")", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\")?"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?.startsWith}.</li>
   *   <li>Then return {@code .startsWith}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  public void testConvertFieldName_whenStartsWith_thenReturnStartsWith() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(".startsWith", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("?.startsWith"));
    assertEquals("\\.startsWith", (new MvelToSearchCriteriaConversionServiceImpl()).convertFieldName("\\?.startsWith"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testParseMethod() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14378 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("Field Name");
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code Field Name}.</li>
   *   <li>Then return {@code field Na}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  public void testParseMethod_whenFieldName_thenReturnFieldNa() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("field Na", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("Field Name"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code getField Name}.</li>
   *   <li>Then return {@code field Na}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  public void testParseMethod_whenGetFieldName_thenReturnFieldNa() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("field Na", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("getField Name"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code get(^get)}.</li>
   *   <li>Then return {@code (^ge}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  public void testParseMethod_whenGetGet_thenReturnGe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("(^ge", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("get(^get)"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code get:("}.</li>
   *   <li>Then return {@code :}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  public void testParseMethod_whenGet_thenReturnColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(":", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("get:(\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code get!="}.</li>
   *   <li>Then return {@code !}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  public void testParseMethod_whenGet_thenReturnExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("!", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("get!=\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code get"))}.</li>
   *   <li>Then return {@code "}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  public void testParseMethod_whenGet_thenReturnQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\"", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("get\"))"));
    assertEquals("\"", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("get\",\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code getget}.</li>
   *   <li>Then return {@code g}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  public void testParseMethod_whenGetget_thenReturnG() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("g", (new MvelToSearchCriteriaConversionServiceImpl()).parseMethod("getget"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}.
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsWildCardSearch() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14348 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new MvelToSearchCriteriaConversionServiceImpl()).isWildCardSearch("42");
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}
   */
  @Test
  public void testIsWildCardSearch_when42_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MvelToSearchCriteriaConversionServiceImpl()).isWildCardSearch("42"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}.
   * <ul>
   *   <li>When {@code 42*}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}
   */
  @Test
  public void testIsWildCardSearch_when42_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MvelToSearchCriteriaConversionServiceImpl()).isWildCardSearch("42*"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}.
   * <ul>
   *   <li>When {@code *}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}
   */
  @Test
  public void testIsWildCardSearch_whenAsterisk_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MvelToSearchCriteriaConversionServiceImpl()).isWildCardSearch("*"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  public void testGetCustomFieldPropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org.apache.commons.lang3.StringUtils.contains", (new MvelToSearchCriteriaConversionServiceImpl())
        .getCustomFieldPropertyName("org.apache.commons.lang3.StringUtils.contains,"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCustomFieldPropertyName2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14193 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("Mvel Rule");
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <ul>
   *   <li>Then return {@code !}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  public void testGetCustomFieldPropertyName_thenReturnExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("!", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("!="));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <ul>
   *   <li>Then return {@code ()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  public void testGetCustomFieldPropertyName_thenReturnLeftParenthesisRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("()", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("()"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <ul>
   *   <li>Then return {@code ["}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  public void testGetCustomFieldPropertyName_thenReturnLeftSquareBracketQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("[\"", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("[\"!"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <ul>
   *   <li>Then return {@code "}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  public void testGetCustomFieldPropertyName_thenReturnQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\"", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("(\")"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <ul>
   *   <li>When {@code CollectionUtils,}.</li>
   *   <li>Then return {@code CollectionUtils}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  public void testGetCustomFieldPropertyName_whenCollectionUtils_thenReturnCollectionUtils() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("CollectionUtils",
        (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("CollectionUtils,"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <ul>
   *   <li>When {@code (}.</li>
   *   <li>Then return {@code (}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  public void testGetCustomFieldPropertyName_whenLeftParenthesis_thenReturnLeftParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("(", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("("));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <ul>
   *   <li>When {@code Mvel Rule}.</li>
   *   <li>Then return {@code Mvel Rule}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  public void testGetCustomFieldPropertyName_whenMvelRule_thenReturnMvelRule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Mvel Rule",
        (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldPropertyName("Mvel Rule"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRuleOrPropertyFromFunction() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14253 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new MvelToSearchCriteriaConversionServiceImpl()).getRuleOrPropertyFromFunction("Mvel Rule");
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   * <ul>
   *   <li>Then return {@code =}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  public void testGetRuleOrPropertyFromFunction_thenReturnEqualsSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("=", (new MvelToSearchCriteriaConversionServiceImpl()).getRuleOrPropertyFromFunction("=!"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   * <ul>
   *   <li>Then return {@code !}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  public void testGetRuleOrPropertyFromFunction_thenReturnExclamationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("!", (new MvelToSearchCriteriaConversionServiceImpl()).getRuleOrPropertyFromFunction("!="));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   * <ul>
   *   <li>Then return {@code ()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  public void testGetRuleOrPropertyFromFunction_thenReturnLeftParenthesisRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("()", (new MvelToSearchCriteriaConversionServiceImpl()).getRuleOrPropertyFromFunction("()"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   * <ul>
   *   <li>Then return {@code ")}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  public void testGetRuleOrPropertyFromFunction_thenReturnQuotationMarkRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\")", (new MvelToSearchCriteriaConversionServiceImpl()).getRuleOrPropertyFromFunction("\")"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   * <ul>
   *   <li>When {@code Mvel Rule}.</li>
   *   <li>Then return {@code Mvel Rule}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  public void testGetRuleOrPropertyFromFunction_whenMvelRule_thenReturnMvelRule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Mvel Rule",
        (new MvelToSearchCriteriaConversionServiceImpl()).getRuleOrPropertyFromFunction("Mvel Rule"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCustomFieldValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14223 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue("Mvel Rule");
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   * <ul>
   *   <li>When {@code "))CollectionUtils}.</li>
   *   <li>Then return {@code "}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  public void testGetCustomFieldValue_whenCollectionUtils_thenReturnQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\"", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue("\"))CollectionUtils"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   * <ul>
   *   <li>When {@code .contains"))}.</li>
   *   <li>Then return {@code contains}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  public void testGetCustomFieldValue_whenContains_thenReturnContains() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("contains", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue(".contains\"))"));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   * <ul>
   *   <li>When {@code ==}.</li>
   *   <li>Then return {@code =}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  public void testGetCustomFieldValue_whenEqualsSignEqualsSign_thenReturnEqualsSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("=", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue("=="));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   * <ul>
   *   <li>When {@code !="}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  public void testGetCustomFieldValue_whenExclamationMarkEqualsSignQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue("!=\""));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   * <ul>
   *   <li>When {@code !=}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  public void testGetCustomFieldValue_whenExclamationMarkEqualsSign_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue("!="));
  }

  /**
   * Test
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   * <ul>
   *   <li>When {@code Mvel Rule}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  public void testGetCustomFieldValue_whenMvelRule_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue("Mvel Rule"));
    assertEquals("", (new MvelToSearchCriteriaConversionServiceImpl()).getCustomFieldValue("Mvel Rule=="));
  }
}
