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

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.metadata.InvalidMetadataException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AnnotationJmxAttributeSource.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AnnotationJmxAttributeSourceDiffblueTest {
  @Autowired private AnnotationJmxAttributeSource annotationJmxAttributeSource;

  /**
   * Test {@link AnnotationJmxAttributeSource#getManagedResource(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationJmxAttributeSource#getManagedResource(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.jmx.export.metadata.ManagedResource AnnotationJmxAttributeSource.getManagedResource(Class)"
  })
  public void testGetManagedResource_whenJavaLangObject_thenReturnNull()
      throws InvalidMetadataException {
    // Arrange
    Class<Object> beanClass = Object.class;

    // Act and Assert
    assertNull(annotationJmxAttributeSource.getManagedResource((Class) beanClass));
  }
}
