/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractPurgeSandboxClonedEntitiesExtensionHandlerDiffblueTest {
  /**
   * Test {@link
   * AbstractPurgeSandboxClonedEntitiesExtensionHandler#cleanUpAndDeleteEntity(Serializable,
   * Object)}.
   *
   * <p>Method under test: {@link
   * AbstractPurgeSandboxClonedEntitiesExtensionHandler#cleanUpAndDeleteEntity(Serializable,
   * Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractPurgeSandboxClonedEntitiesExtensionHandler.cleanUpAndDeleteEntity(Serializable, Object)"
  })
  public void testCleanUpAndDeleteEntity() {
    // Arrange
    AbstractPurgeSandboxClonedEntitiesExtensionHandler
        abstractPurgeSandboxClonedEntitiesExtensionHandler =
            new AbstractPurgeSandboxClonedEntitiesExtensionHandler();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractPurgeSandboxClonedEntitiesExtensionHandler.cleanUpAndDeleteEntity(
            new SimpleDateFormat("yyyy/mm/dd"), "Entity"));
  }

  /**
   * Test new {@link AbstractPurgeSandboxClonedEntitiesExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractPurgeSandboxClonedEntitiesExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractPurgeSandboxClonedEntitiesExtensionHandler.<init>()"})
  public void testNewAbstractPurgeSandboxClonedEntitiesExtensionHandler() {
    // Arrange and Act
    AbstractPurgeSandboxClonedEntitiesExtensionHandler
        actualAbstractPurgeSandboxClonedEntitiesExtensionHandler =
            new AbstractPurgeSandboxClonedEntitiesExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractPurgeSandboxClonedEntitiesExtensionHandler.getPriority());
    assertTrue(actualAbstractPurgeSandboxClonedEntitiesExtensionHandler.isEnabled());
  }
}
