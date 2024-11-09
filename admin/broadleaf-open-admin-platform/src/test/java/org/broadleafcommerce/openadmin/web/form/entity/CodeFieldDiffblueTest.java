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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CodeFieldDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CodeField}
   *   <li>{@link CodeField#setFetchUrlSuffix(String)}
   *   <li>{@link CodeField#setFileType(String)}
   *   <li>{@link CodeField#getFetchUrlSuffix()}
   *   <li>{@link CodeField#getFileType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CodeField actualCodeField = new CodeField();
    actualCodeField.setFetchUrlSuffix("https://example.org/example");
    actualCodeField.setFileType("File Type");
    String actualFetchUrlSuffix = actualCodeField.getFetchUrlSuffix();

    // Assert that nothing has changed
    assertEquals("File Type", actualCodeField.getFileType());
    assertEquals("https://example.org/example", actualFetchUrlSuffix);
    assertFalse(actualCodeField.getAllowNoValueEnumOption());
    assertTrue(actualCodeField.getAttributes().isEmpty());
    assertTrue(actualCodeField.getShouldRender());
  }
}
