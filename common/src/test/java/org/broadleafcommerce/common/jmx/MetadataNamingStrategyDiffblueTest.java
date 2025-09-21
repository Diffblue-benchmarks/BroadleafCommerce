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
import java.util.Hashtable;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.target.EmptyTargetSource;
import org.springframework.aop.target.HotSwappableTargetSource;
import org.springframework.jmx.export.annotation.AnnotationJmxAttributeSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MetadataNamingStrategyDiffblueTest {
  /**
   * Test {@link MetadataNamingStrategy#getObjectName(Object, String)}.
   *
   * <ul>
   *   <li>Then return KeyPropertyList size is two.
   * </ul>
   *
   * <p>Method under test: {@link MetadataNamingStrategy#getObjectName(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectName MetadataNamingStrategy.getObjectName(Object, String)"})
  public void testGetObjectName_thenReturnKeyPropertyListSizeIsTwo()
      throws MalformedObjectNameException {
    // Arrange
    MetadataNamingStrategy metadataNamingStrategy = new MetadataNamingStrategy();
    metadataNamingStrategy.setAttributeSource(new AnnotationJmxAttributeSource());
    metadataNamingStrategy.setDefaultDomain(null);

    AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(BLCFieldUtils.NULL_FIELD);
    EmptyTargetSource forClassResult = EmptyTargetSource.forClass(null, true);
    aspectJProxyFactory.setTargetSource(new HotSwappableTargetSource(forClassResult));

    // Act
    ObjectName actualObjectName =
        metadataNamingStrategy.getObjectName(aspectJProxyFactory, "Bean Key");

    // Assert
    Hashtable<String, String> keyPropertyList = actualObjectName.getKeyPropertyList();
    assertEquals(2, keyPropertyList.size());
    assertEquals("Bean Key", keyPropertyList.get("name"));
    assertEquals("EmptyTargetSource", keyPropertyList.get("type"));
    assertEquals(
        "name=Bean Key,type=EmptyTargetSource",
        actualObjectName.getCanonicalKeyPropertyListString());
    assertEquals(
        "name=Bean Key,type=EmptyTargetSource", actualObjectName.getKeyPropertyListString());
    assertEquals("org.springframework.aop.target", actualObjectName.getDomain());
    assertEquals(
        "org.springframework.aop.target:name=Bean Key,type=EmptyTargetSource",
        actualObjectName.getCanonicalName());
    assertFalse(actualObjectName.isDomainPattern());
    assertFalse(actualObjectName.isPattern());
    assertFalse(actualObjectName.isPropertyListPattern());
    assertFalse(actualObjectName.isPropertyPattern());
    assertFalse(actualObjectName.isPropertyValuePattern());
  }
}
