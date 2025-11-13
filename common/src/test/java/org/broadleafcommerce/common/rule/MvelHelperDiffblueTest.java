package org.broadleafcommerce.common.rule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MvelHelperDiffblueTest {
  /**
   * Test {@link MvelHelper#convertField(String, String)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MvelHelper.convertField(String, String)"})
  public void testConvertField_whenBoolean_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) MvelHelper.convertField("BOOLEAN", "42"));
  }

  /**
   * Test {@link MvelHelper#convertField(String, String)}.
   *
   * <ul>
   *   <li>When {@code DATE}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MvelHelper.convertField(String, String)"})
  public void testConvertField_whenDate_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> MvelHelper.convertField("DATE", "42"));
  }

  /**
   * Test {@link MvelHelper#convertField(String, String)}.
   *
   * <ul>
   *   <li>When {@code DECIMAL}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MvelHelper.convertField(String, String)"})
  public void testConvertField_whenDecimal_thenDoesNotThrow() {
    // Arrange, Act and Assert
    MvelHelper.convertField("DECIMAL", "42");
  }

  /**
   * Test {@link MvelHelper#convertField(String, String)}.
   *
   * <ul>
   *   <li>When {@code INTEGER}.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MvelHelper.convertField(String, String)"})
  public void testConvertField_whenInteger_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, ((Integer) MvelHelper.convertField("INTEGER", "42")).intValue());
  }

  /**
   * Test {@link MvelHelper#convertField(String, String)}.
   *
   * <ul>
   *   <li>When {@code MONEY}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MvelHelper.convertField(String, String)"})
  public void testConvertField_whenMoney_thenDoesNotThrow() {
    // Arrange, Act and Assert
    MvelHelper.convertField("MONEY", "42");
  }

  /**
   * Test {@link MvelHelper#convertField(String, String)}.
   *
   * <ul>
   *   <li>When {@link Boolean#TRUE} toString.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MvelHelper.convertField(String, String)"})
  public void testConvertField_whenTrueToString_thenReturnTrue() {
    // Arrange and Act
    Object actualConvertFieldResult = MvelHelper.convertField("BOOLEAN", Boolean.TRUE.toString());

    // Assert
    assertTrue((Boolean) actualConvertFieldResult);
  }

  /**
   * Test {@link MvelHelper#convertField(String, String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MvelHelper.convertField(String, String)"})
  public void testConvertField_whenType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(MvelHelper.convertField("Type", null));
  }

  /**
   * Test {@link MvelHelper#convertField(String, String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MvelHelper.convertField(String, String)"})
  public void testConvertField_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MvelHelper.convertField("Type", "42"));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put(
        "Unable to parse and/or execute the mvel expression (", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertFalse(MvelHelper.evaluateRule("Rule", ruleParameters));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>Given {@code getProductAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_givenGetProductAttributesXx() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("getProductAttributes()[xx]", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertFalse(MvelHelper.evaluateRule("Rule", ruleParameters));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>Given {@code Rule}.
   *   <li>When {@link HashMap#HashMap()} {@code Rule} is {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_givenRule_whenHashMapRuleIsNull_field() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("Rule", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertFalse(MvelHelper.evaluateRule("Rule", ruleParameters));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link HashMap#HashMap()} {@code Rule} is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_givenTrue_whenHashMapRuleIsTrue() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("Rule", true);

    // Act and Assert
    assertTrue(MvelHelper.evaluateRule("Rule", ruleParameters));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("42", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When {@code CollectionUtils}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenCollectionUtils_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("CollectionUtils", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MvelHelper.evaluateRule("", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When {@code getAdditionalAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenGetAdditionalAttributesXx() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("getAdditionalAttributes()[xx]", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When {@code getAdditionalFields()[xx]}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenGetAdditionalFieldsXx_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("getAdditionalFields()[xx]", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When {@code getCategoryAttributesMap()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenGetCategoryAttributesMapXx() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("getCategoryAttributesMap()[xx]", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When {@code getCustomerAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenGetCustomerAttributesXx() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("getCustomerAttributes()[xx]", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When {@code getOrderItemAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenGetOrderItemAttributesXx() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("getOrderItemAttributes()[xx]", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When {@code getProductAttributes()[xx]}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenGetProductAttributesXx() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("getProductAttributes()[xx]", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When {@code getSkuAttributes()[xx]}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenGetSkuAttributesXx_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("getSkuAttributes()[xx]", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When {@code mvel2.disable.jit}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenMvel2DisableJit_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("mvel2.disable.jit", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MvelHelper.evaluateRule(null, new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When {@code Rule}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenRule_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("Rule", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When space space.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenSpaceSpace_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MvelHelper.evaluateRule("  ", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   *
   * <ul>
   *   <li>When space space.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenSpaceSpace_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(MvelHelper.evaluateRule("  ", null));
  }

  /**
   * Test {@link MvelHelper#getRuleAttributeMaps()}.
   *
   * <p>Method under test: {@link MvelHelper#getRuleAttributeMaps()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] MvelHelper.getRuleAttributeMaps()"})
  public void testGetRuleAttributeMaps() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {
          "getProductAttributes",
          "getCategoryAttributesMap",
          "getSkuAttributes",
          "getOrderItemAttributes",
          "getCustomerAttributes",
          "getAdditionalAttributes",
          "getAdditionalFields"
        },
        MvelHelper.getRuleAttributeMaps());
  }

  /**
   * Test {@link MvelHelper#buildMvelParameters()}.
   *
   * <p>Method under test: {@link MvelHelper#buildMvelParameters()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MvelHelper.buildMvelParameters()"})
  public void testBuildMvelParameters() {
    // Arrange and Act
    Map<String, Object> actualBuildMvelParametersResult = MvelHelper.buildMvelParameters();

    // Assert
    assertTrue(actualBuildMvelParametersResult.isEmpty());
  }
}
