/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.openadmin.web.form.entity;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DynamicEntityFormInfo.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DynamicEntityFormInfoDiffblueTest {
  @Autowired
  private DynamicEntityFormInfo dynamicEntityFormInfo;

  /**
   * Test {@link DynamicEntityFormInfo#withCriteriaName(String)}.
   * <p>
   * Method under test: {@link DynamicEntityFormInfo#withCriteriaName(String)}
   */
  @Test
  public void testWithCriteriaName() {
    // Arrange and Act
    DynamicEntityFormInfo actualWithCriteriaNameResult = dynamicEntityFormInfo.withCriteriaName("Criteria Name");

    // Assert
    assertEquals("Criteria Name", dynamicEntityFormInfo.getCriteriaName());
    assertSame(dynamicEntityFormInfo, actualWithCriteriaNameResult);
  }

  /**
   * Test {@link DynamicEntityFormInfo#withPropertyName(String)}.
   * <p>
   * Method under test: {@link DynamicEntityFormInfo#withPropertyName(String)}
   */
  @Test
  public void testWithPropertyName() {
    // Arrange and Act
    DynamicEntityFormInfo actualWithPropertyNameResult = dynamicEntityFormInfo.withPropertyName("Property Name");

    // Assert
    assertEquals("Property Name", dynamicEntityFormInfo.getPropertyName());
    assertSame(dynamicEntityFormInfo, actualWithPropertyNameResult);
  }

  /**
   * Test {@link DynamicEntityFormInfo#withPropertyValue(String)}.
   * <p>
   * Method under test: {@link DynamicEntityFormInfo#withPropertyValue(String)}
   */
  @Test
  public void testWithPropertyValue() {
    // Arrange and Act
    DynamicEntityFormInfo actualWithPropertyValueResult = dynamicEntityFormInfo.withPropertyValue("42");

    // Assert
    assertEquals("42", dynamicEntityFormInfo.getPropertyValue());
    assertSame(dynamicEntityFormInfo, actualWithPropertyValueResult);
  }

  /**
   * Test {@link DynamicEntityFormInfo#withCeilingClassName(String)}.
   * <p>
   * Method under test: {@link DynamicEntityFormInfo#withCeilingClassName(String)}
   */
  @Test
  public void testWithCeilingClassName() {
    // Arrange and Act
    DynamicEntityFormInfo actualWithCeilingClassNameResult = dynamicEntityFormInfo
        .withCeilingClassName("Ceiling Class Name");

    // Assert
    assertEquals("Ceiling Class Name", dynamicEntityFormInfo.getCeilingClassName());
    assertSame(dynamicEntityFormInfo, actualWithCeilingClassNameResult);
  }

  /**
   * Test {@link DynamicEntityFormInfo#withSecurityCeilingClassName(String)}.
   * <p>
   * Method under test:
   * {@link DynamicEntityFormInfo#withSecurityCeilingClassName(String)}
   */
  @Test
  public void testWithSecurityCeilingClassName() {
    // Arrange and Act
    DynamicEntityFormInfo actualWithSecurityCeilingClassNameResult = dynamicEntityFormInfo
        .withSecurityCeilingClassName("Security Ceiling Class Name");

    // Assert
    assertEquals("Security Ceiling Class Name", dynamicEntityFormInfo.getSecurityCeilingClassName());
    assertSame(dynamicEntityFormInfo, actualWithSecurityCeilingClassNameResult);
  }

  /**
   * Test {@link DynamicEntityFormInfo#withCustomCriteriaOverride(String[])}.
   * <p>
   * Method under test:
   * {@link DynamicEntityFormInfo#withCustomCriteriaOverride(String[])}
   */
  @Test
  public void testWithCustomCriteriaOverride() {
    // Arrange
    DynamicEntityFormInfo dynamicEntityFormInfo = new DynamicEntityFormInfo();
    String[] customCriteriaOverride = new String[]{"Custom Criteria Override"};

    // Act and Assert
    assertSame(dynamicEntityFormInfo, dynamicEntityFormInfo.withCustomCriteriaOverride(customCriteriaOverride));
    assertSame(customCriteriaOverride, dynamicEntityFormInfo.getCustomCriteriaOverride());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    DynamicEntityFormInfo actualDynamicEntityFormInfo = new DynamicEntityFormInfo();
    actualDynamicEntityFormInfo.setCeilingClassName("Ceiling Class Name");
    actualDynamicEntityFormInfo.setCriteriaName("Criteria Name");
    String[] customCriteriaOverride = new String[]{"Custom Criteria Override"};
    actualDynamicEntityFormInfo.setCustomCriteriaOverride(customCriteriaOverride);
    actualDynamicEntityFormInfo.setPropertyName("Property Name");
    actualDynamicEntityFormInfo.setPropertyValue("42");
    actualDynamicEntityFormInfo.setSecurityCeilingClassName("Security Ceiling Class Name");
    String actualCeilingClassName = actualDynamicEntityFormInfo.getCeilingClassName();
    String actualCriteriaName = actualDynamicEntityFormInfo.getCriteriaName();
    String[] actualCustomCriteriaOverride = actualDynamicEntityFormInfo.getCustomCriteriaOverride();
    String actualPropertyName = actualDynamicEntityFormInfo.getPropertyName();
    String actualPropertyValue = actualDynamicEntityFormInfo.getPropertyValue();

    // Assert that nothing has changed
    assertEquals("42", actualPropertyValue);
    assertEquals("Ceiling Class Name", actualCeilingClassName);
    assertEquals("Criteria Name", actualCriteriaName);
    assertEquals("Property Name", actualPropertyName);
    assertEquals("Security Ceiling Class Name", actualDynamicEntityFormInfo.getSecurityCeilingClassName());
    assertSame(customCriteriaOverride, actualCustomCriteriaOverride);
    assertArrayEquals(new String[]{"Custom Criteria Override"}, actualCustomCriteriaOverride);
  }
}
