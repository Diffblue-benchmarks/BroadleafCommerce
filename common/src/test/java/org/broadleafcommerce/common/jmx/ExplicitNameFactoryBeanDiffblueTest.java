/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.common.jmx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExplicitNameFactoryBeanDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExplicitNameFactoryBean#ExplicitNameFactoryBean(String, String)}
   *   <li>{@link ExplicitNameFactoryBean#getObjectType()}
   *   <li>{@link ExplicitNameFactoryBean#isSingleton()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExplicitNameFactoryBean.<init>(String, String)",
    "Class ExplicitNameFactoryBean.getObjectType()",
    "boolean ExplicitNameFactoryBean.isSingleton()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ExplicitNameFactoryBean actualExplicitNameFactoryBean =
        new ExplicitNameFactoryBean("Name", "Suffix");
    Class actualObjectType = actualExplicitNameFactoryBean.getObjectType();

    // Assert
    assertFalse(actualExplicitNameFactoryBean.isSingleton());
    Class<String> expectedObjectType = String.class;
    assertEquals(expectedObjectType, actualObjectType);
  }

  /**
   * Test {@link ExplicitNameFactoryBean#getObject()}.
   *
   * <p>Method under test: {@link ExplicitNameFactoryBean#getObject()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object ExplicitNameFactoryBean.getObject()"})
  public void testGetObject() throws Exception {
    // Arrange, Act and Assert
    assertEquals("Name-Suffix", new ExplicitNameFactoryBean("Name", "Suffix").getObject());
  }
}
