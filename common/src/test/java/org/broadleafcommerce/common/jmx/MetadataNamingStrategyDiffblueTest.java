/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.jmx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.Hashtable;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class MetadataNamingStrategyDiffblueTest {
  /**
   * Test {@link MetadataNamingStrategy#getObjectName(Object, String)}.
   * <ul>
   *   <li>Then return KeyPropertyList size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MetadataNamingStrategy#getObjectName(Object, String)}
   */
  @Test
  public void testGetObjectName_thenReturnKeyPropertyListSizeIsTwo() throws MalformedObjectNameException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MetadataNamingStrategy metadataNamingStrategy = new MetadataNamingStrategy();
    metadataNamingStrategy.setAttributeSource(new AnnotationJmxAttributeSource("App Name"));
    metadataNamingStrategy.setDefaultDomain(null);

    // Act
    ObjectName actualObjectName = metadataNamingStrategy.getObjectName(BLCFieldUtils.NULL_FIELD, "Bean Key");

    // Assert
    Hashtable<String, String> keyPropertyList = actualObjectName.getKeyPropertyList();
    assertEquals(2, keyPropertyList.size());
    assertEquals("Bean Key", keyPropertyList.get("name"));
    assertEquals("Object", keyPropertyList.get("type"));
    assertEquals("java.lang", actualObjectName.getDomain());
    assertEquals("java.lang:name=Bean Key,type=Object", actualObjectName.getCanonicalName());
    assertEquals("name=Bean Key,type=Object", actualObjectName.getCanonicalKeyPropertyListString());
    assertEquals("name=Bean Key,type=Object", actualObjectName.getKeyPropertyListString());
    assertFalse(actualObjectName.isDomainPattern());
    assertFalse(actualObjectName.isPattern());
    assertFalse(actualObjectName.isPropertyListPattern());
    assertFalse(actualObjectName.isPropertyPattern());
    assertFalse(actualObjectName.isPropertyValuePattern());
  }
}
