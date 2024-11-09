/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.field.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class FieldEnumerationImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldEnumerationImpl}
   *   <li>{@link FieldEnumerationImpl#setEnumerationItems(List)}
   *   <li>{@link FieldEnumerationImpl#setId(Long)}
   *   <li>{@link FieldEnumerationImpl#setName(String)}
   *   <li>{@link FieldEnumerationImpl#getEnumerationItems()}
   *   <li>{@link FieldEnumerationImpl#getId()}
   *   <li>{@link FieldEnumerationImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldEnumerationImpl actualFieldEnumerationImpl = new FieldEnumerationImpl();
    ArrayList<FieldEnumerationItem> enumerationItems = new ArrayList<>();
    actualFieldEnumerationImpl.setEnumerationItems(enumerationItems);
    actualFieldEnumerationImpl.setId(1L);
    actualFieldEnumerationImpl.setName("Name");
    List<FieldEnumerationItem> actualEnumerationItems = actualFieldEnumerationImpl.getEnumerationItems();
    Long actualId = actualFieldEnumerationImpl.getId();

    // Assert that nothing has changed
    assertEquals("Name", actualFieldEnumerationImpl.getName());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualEnumerationItems.isEmpty());
    assertSame(enumerationItems, actualEnumerationItems);
  }
}
