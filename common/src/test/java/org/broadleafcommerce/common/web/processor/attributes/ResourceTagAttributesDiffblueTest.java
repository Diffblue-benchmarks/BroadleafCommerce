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
package org.broadleafcommerce.common.web.processor.attributes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ResourceTagAttributesDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceTagAttributes#ResourceTagAttributes()}
   *   <li>{@link ResourceTagAttributes#async(boolean)}
   *   <li>{@link ResourceTagAttributes#bundleCompletedEvent(String)}
   *   <li>{@link ResourceTagAttributes#bundleDependencyEvent(String)}
   *   <li>{@link ResourceTagAttributes#defer(boolean)}
   *   <li>{@link ResourceTagAttributes#files(String)}
   *   <li>{@link ResourceTagAttributes#includeAsyncDeferUnbundled(boolean)}
   *   <li>{@link ResourceTagAttributes#mappingPrefix(String)}
   *   <li>{@link ResourceTagAttributes#name(String)}
   *   <li>{@link ResourceTagAttributes#src(String)}
   *   <li>{@link ResourceTagAttributes#async()}
   *   <li>{@link ResourceTagAttributes#bundleCompletedEvent()}
   *   <li>{@link ResourceTagAttributes#bundleDependencyEvent()}
   *   <li>{@link ResourceTagAttributes#defer()}
   *   <li>{@link ResourceTagAttributes#files()}
   *   <li>{@link ResourceTagAttributes#includeAsyncDeferUnbundled()}
   *   <li>{@link ResourceTagAttributes#mappingPrefix()}
   *   <li>{@link ResourceTagAttributes#name()}
   *   <li>{@link ResourceTagAttributes#src()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ResourceTagAttributes actualResourceTagAttributes = new ResourceTagAttributes();
    ResourceTagAttributes actualAsyncResult = actualResourceTagAttributes.async(true);
    ResourceTagAttributes actualBundleCompletedEventResult = actualResourceTagAttributes
        .bundleCompletedEvent("Bundle Completed Event");
    ResourceTagAttributes actualBundleDependencyEventResult = actualResourceTagAttributes
        .bundleDependencyEvent("Bundle Dependency Event");
    ResourceTagAttributes actualDeferResult = actualResourceTagAttributes.defer(true);
    ResourceTagAttributes actualFilesResult = actualResourceTagAttributes.files("Files");
    ResourceTagAttributes actualIncludeAsyncDeferUnbundledResult = actualResourceTagAttributes
        .includeAsyncDeferUnbundled(true);
    ResourceTagAttributes actualMappingPrefixResult = actualResourceTagAttributes.mappingPrefix("Mapping Prefix");
    ResourceTagAttributes actualNameResult = actualResourceTagAttributes.name("Name");
    ResourceTagAttributes actualSrcResult = actualResourceTagAttributes.src("Src");
    boolean actualAsyncResult2 = actualResourceTagAttributes.async();
    String actualBundleCompletedEventResult2 = actualResourceTagAttributes.bundleCompletedEvent();
    String actualBundleDependencyEventResult2 = actualResourceTagAttributes.bundleDependencyEvent();
    boolean actualDeferResult2 = actualResourceTagAttributes.defer();
    String actualFilesResult2 = actualResourceTagAttributes.files();
    boolean actualIncludeAsyncDeferUnbundledResult2 = actualResourceTagAttributes.includeAsyncDeferUnbundled();
    String actualMappingPrefixResult2 = actualResourceTagAttributes.mappingPrefix();
    String actualNameResult2 = actualResourceTagAttributes.name();

    // Assert
    assertEquals("Bundle Completed Event", actualBundleCompletedEventResult2);
    assertEquals("Bundle Dependency Event", actualBundleDependencyEventResult2);
    assertEquals("Files", actualFilesResult2);
    assertEquals("Mapping Prefix", actualMappingPrefixResult2);
    assertEquals("Name", actualNameResult2);
    assertEquals("Src", actualResourceTagAttributes.src());
    assertTrue(actualAsyncResult2);
    assertTrue(actualDeferResult2);
    assertTrue(actualIncludeAsyncDeferUnbundledResult2);
    assertSame(actualResourceTagAttributes, actualAsyncResult);
    assertSame(actualResourceTagAttributes, actualBundleCompletedEventResult);
    assertSame(actualResourceTagAttributes, actualBundleDependencyEventResult);
    assertSame(actualResourceTagAttributes, actualDeferResult);
    assertSame(actualResourceTagAttributes, actualFilesResult);
    assertSame(actualResourceTagAttributes, actualIncludeAsyncDeferUnbundledResult);
    assertSame(actualResourceTagAttributes, actualMappingPrefixResult);
    assertSame(actualResourceTagAttributes, actualNameResult);
    assertSame(actualResourceTagAttributes, actualSrcResult);
  }

  /**
   * Test
   * {@link ResourceTagAttributes#ResourceTagAttributes(ResourceTagAttributes)}.
   * <ul>
   *   <li>Then return bundleCompletedEvent is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceTagAttributes#ResourceTagAttributes(ResourceTagAttributes)}
   */
  @Test
  public void testNewResourceTagAttributes_thenReturnBundleCompletedEventIsNull() {
    // Arrange and Act
    ResourceTagAttributes actualResourceTagAttributes = new ResourceTagAttributes(new ResourceTagAttributes());

    // Assert
    assertNull(actualResourceTagAttributes.bundleCompletedEvent());
    assertNull(actualResourceTagAttributes.bundleDependencyEvent());
    assertNull(actualResourceTagAttributes.files());
    assertNull(actualResourceTagAttributes.mappingPrefix());
    assertNull(actualResourceTagAttributes.name());
    assertNull(actualResourceTagAttributes.src());
    assertFalse(actualResourceTagAttributes.async());
    assertFalse(actualResourceTagAttributes.defer());
    assertFalse(actualResourceTagAttributes.includeAsyncDeferUnbundled());
  }
}
