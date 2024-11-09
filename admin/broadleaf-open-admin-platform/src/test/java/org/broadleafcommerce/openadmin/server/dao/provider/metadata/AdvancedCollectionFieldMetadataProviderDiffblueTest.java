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
package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class AdvancedCollectionFieldMetadataProviderDiffblueTest {
  /**
   * Test new {@link AdvancedCollectionFieldMetadataProvider} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AdvancedCollectionFieldMetadataProvider}
   */
  @Test
  public void testNewAdvancedCollectionFieldMetadataProvider() {
    // Arrange and Act
    AdvancedCollectionFieldMetadataProvider actualAdvancedCollectionFieldMetadataProvider = new AdvancedCollectionFieldMetadataProvider();

    // Assert
    assertNull(actualAdvancedCollectionFieldMetadataProvider.metadataOverrides);
    assertNull(actualAdvancedCollectionFieldMetadataProvider.entityConfiguration);
    assertNull(actualAdvancedCollectionFieldMetadataProvider.enumerationUtility);
    assertNull(actualAdvancedCollectionFieldMetadataProvider.defaultMetadataProvider);
    assertEquals(FieldMetadataProvider.BASIC, actualAdvancedCollectionFieldMetadataProvider.getOrder());
  }
}
