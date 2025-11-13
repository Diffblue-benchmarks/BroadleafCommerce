package org.broadleafcommerce.openadmin.web.form.entity;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DynamicEntityFormInfo.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class DynamicEntityFormInfoDiffblueTest {
  @Autowired private DynamicEntityFormInfo dynamicEntityFormInfo;

  /**
   * Test {@link DynamicEntityFormInfo#withCriteriaName(String)}.
   *
   * <p>Method under test: {@link DynamicEntityFormInfo#withCriteriaName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DynamicEntityFormInfo DynamicEntityFormInfo.withCriteriaName(String)"})
  public void testWithCriteriaName() {
    // Arrange and Act
    DynamicEntityFormInfo actualWithCriteriaNameResult =
        dynamicEntityFormInfo.withCriteriaName("Criteria Name");

    // Assert
    assertEquals("Criteria Name", dynamicEntityFormInfo.getCriteriaName());
    assertSame(dynamicEntityFormInfo, actualWithCriteriaNameResult);
  }

  /**
   * Test {@link DynamicEntityFormInfo#withPropertyName(String)}.
   *
   * <p>Method under test: {@link DynamicEntityFormInfo#withPropertyName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DynamicEntityFormInfo DynamicEntityFormInfo.withPropertyName(String)"})
  public void testWithPropertyName() {
    // Arrange and Act
    DynamicEntityFormInfo actualWithPropertyNameResult =
        dynamicEntityFormInfo.withPropertyName("Property Name");

    // Assert
    assertEquals("Property Name", dynamicEntityFormInfo.getPropertyName());
    assertSame(dynamicEntityFormInfo, actualWithPropertyNameResult);
  }

  /**
   * Test {@link DynamicEntityFormInfo#withPropertyValue(String)}.
   *
   * <p>Method under test: {@link DynamicEntityFormInfo#withPropertyValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DynamicEntityFormInfo DynamicEntityFormInfo.withPropertyValue(String)"})
  public void testWithPropertyValue() {
    // Arrange and Act
    DynamicEntityFormInfo actualWithPropertyValueResult =
        dynamicEntityFormInfo.withPropertyValue("42");

    // Assert
    assertEquals("42", dynamicEntityFormInfo.getPropertyValue());
    assertSame(dynamicEntityFormInfo, actualWithPropertyValueResult);
  }

  /**
   * Test {@link DynamicEntityFormInfo#withCeilingClassName(String)}.
   *
   * <p>Method under test: {@link DynamicEntityFormInfo#withCeilingClassName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DynamicEntityFormInfo DynamicEntityFormInfo.withCeilingClassName(String)"})
  public void testWithCeilingClassName() {
    // Arrange and Act
    DynamicEntityFormInfo actualWithCeilingClassNameResult =
        dynamicEntityFormInfo.withCeilingClassName("Ceiling Class Name");

    // Assert
    assertEquals("Ceiling Class Name", dynamicEntityFormInfo.getCeilingClassName());
    assertSame(dynamicEntityFormInfo, actualWithCeilingClassNameResult);
  }

  /**
   * Test {@link DynamicEntityFormInfo#withSecurityCeilingClassName(String)}.
   *
   * <p>Method under test: {@link DynamicEntityFormInfo#withSecurityCeilingClassName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicEntityFormInfo DynamicEntityFormInfo.withSecurityCeilingClassName(String)"
  })
  public void testWithSecurityCeilingClassName() {
    // Arrange and Act
    DynamicEntityFormInfo actualWithSecurityCeilingClassNameResult =
        dynamicEntityFormInfo.withSecurityCeilingClassName("Security Ceiling Class Name");

    // Assert
    assertEquals(
        "Security Ceiling Class Name", dynamicEntityFormInfo.getSecurityCeilingClassName());
    assertSame(dynamicEntityFormInfo, actualWithSecurityCeilingClassNameResult);
  }

  /**
   * Test {@link DynamicEntityFormInfo#withCustomCriteriaOverride(String[])}.
   *
   * <p>Method under test: {@link DynamicEntityFormInfo#withCustomCriteriaOverride(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicEntityFormInfo DynamicEntityFormInfo.withCustomCriteriaOverride(String[])"
  })
  public void testWithCustomCriteriaOverride() {
    // Arrange
    DynamicEntityFormInfo dynamicEntityFormInfo = new DynamicEntityFormInfo();
    String[] customCriteriaOverride = new String[] {"Custom Criteria Override"};

    // Act
    DynamicEntityFormInfo actualWithCustomCriteriaOverrideResult =
        dynamicEntityFormInfo.withCustomCriteriaOverride(customCriteriaOverride);

    // Assert
    assertSame(dynamicEntityFormInfo, actualWithCustomCriteriaOverrideResult);
    assertSame(customCriteriaOverride, dynamicEntityFormInfo.getCustomCriteriaOverride());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DynamicEntityFormInfo}
   *   <li>{@link DynamicEntityFormInfo#setCeilingClassName(String)}
   *   <li>{@link DynamicEntityFormInfo#setCriteriaName(String)}
   *   <li>{@link DynamicEntityFormInfo#setCustomCriteriaOverride(String[])}
   *   <li>{@link DynamicEntityFormInfo#setPropertyName(String)}
   *   <li>{@link DynamicEntityFormInfo#setPropertyValue(String)}
   *   <li>{@link DynamicEntityFormInfo#setSecurityCeilingClassName(String)}
   *   <li>{@link DynamicEntityFormInfo#getCeilingClassName()}
   *   <li>{@link DynamicEntityFormInfo#getCriteriaName()}
   *   <li>{@link DynamicEntityFormInfo#getCustomCriteriaOverride()}
   *   <li>{@link DynamicEntityFormInfo#getPropertyName()}
   *   <li>{@link DynamicEntityFormInfo#getPropertyValue()}
   *   <li>{@link DynamicEntityFormInfo#getSecurityCeilingClassName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicEntityFormInfo.<init>()",
    "String DynamicEntityFormInfo.getCeilingClassName()",
    "String DynamicEntityFormInfo.getCriteriaName()",
    "String[] DynamicEntityFormInfo.getCustomCriteriaOverride()",
    "String DynamicEntityFormInfo.getPropertyName()",
    "String DynamicEntityFormInfo.getPropertyValue()",
    "String DynamicEntityFormInfo.getSecurityCeilingClassName()",
    "void DynamicEntityFormInfo.setCeilingClassName(String)",
    "void DynamicEntityFormInfo.setCriteriaName(String)",
    "void DynamicEntityFormInfo.setCustomCriteriaOverride(String[])",
    "void DynamicEntityFormInfo.setPropertyName(String)",
    "void DynamicEntityFormInfo.setPropertyValue(String)",
    "void DynamicEntityFormInfo.setSecurityCeilingClassName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DynamicEntityFormInfo actualDynamicEntityFormInfo = new DynamicEntityFormInfo();
    actualDynamicEntityFormInfo.setCeilingClassName("Ceiling Class Name");
    actualDynamicEntityFormInfo.setCriteriaName("Criteria Name");
    String[] customCriteriaOverride = new String[] {"Custom Criteria Override"};
    actualDynamicEntityFormInfo.setCustomCriteriaOverride(customCriteriaOverride);
    actualDynamicEntityFormInfo.setPropertyName("Property Name");
    actualDynamicEntityFormInfo.setPropertyValue("42");
    actualDynamicEntityFormInfo.setSecurityCeilingClassName("Security Ceiling Class Name");
    String actualCeilingClassName = actualDynamicEntityFormInfo.getCeilingClassName();
    String actualCriteriaName = actualDynamicEntityFormInfo.getCriteriaName();
    String[] actualCustomCriteriaOverride = actualDynamicEntityFormInfo.getCustomCriteriaOverride();
    String actualPropertyName = actualDynamicEntityFormInfo.getPropertyName();
    String actualPropertyValue = actualDynamicEntityFormInfo.getPropertyValue();

    // Assert
    assertEquals("42", actualPropertyValue);
    assertEquals("Ceiling Class Name", actualCeilingClassName);
    assertEquals("Criteria Name", actualCriteriaName);
    assertEquals("Property Name", actualPropertyName);
    assertEquals(
        "Security Ceiling Class Name", actualDynamicEntityFormInfo.getSecurityCeilingClassName());
    assertSame(customCriteriaOverride, actualCustomCriteriaOverride);
    assertArrayEquals(new String[] {"Custom Criteria Override"}, actualCustomCriteriaOverride);
  }
}
