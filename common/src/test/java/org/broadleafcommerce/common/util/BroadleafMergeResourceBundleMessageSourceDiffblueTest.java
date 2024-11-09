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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Set;
import org.junit.Test;
import org.springframework.util.DefaultPropertiesPersister;

public class BroadleafMergeResourceBundleMessageSourceDiffblueTest {
  /**
   * Test new {@link BroadleafMergeResourceBundleMessageSource} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafMergeResourceBundleMessageSource}
   */
  @Test
  public void testNewBroadleafMergeResourceBundleMessageSource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    BroadleafMergeResourceBundleMessageSource actualBroadleafMergeResourceBundleMessageSource = new BroadleafMergeResourceBundleMessageSource();

    // Assert
    assertNull(actualBroadleafMergeResourceBundleMessageSource.extensionManager);
    assertNull(actualBroadleafMergeResourceBundleMessageSource.getParentMessageSource());
    assertTrue(actualBroadleafMergeResourceBundleMessageSource.getBasenameSet().isEmpty());
  }

  /**
   * Test
   * {@link BroadleafMergeResourceBundleMessageSource#setBasenames(String[])}.
   * <p>
   * Method under test:
   * {@link BroadleafMergeResourceBundleMessageSource#setBasenames(String[])}
   */
  @Test
  public void testSetBasenames() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafMergeResourceBundleMessageSource broadleafMergeResourceBundleMessageSource = new BroadleafMergeResourceBundleMessageSource();
    String[] basenames = new String[]{"Basenames"};

    // Act
    broadleafMergeResourceBundleMessageSource.setBasenames(basenames);

    // Assert that nothing has changed
    Set<String> basenameSet = broadleafMergeResourceBundleMessageSource.getBasenameSet();
    assertEquals(1, basenameSet.size());
    assertTrue(basenameSet.contains("Basenames"));
    assertArrayEquals(new String[]{"Basenames"}, basenames);
  }

  /**
   * Test
   * {@link BroadleafMergeResourceBundleMessageSource#setBasenames(String[])}.
   * <p>
   * Method under test:
   * {@link BroadleafMergeResourceBundleMessageSource#setBasenames(String[])}
   */
  @Test
  public void testSetBasenames2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafMergeResourceBundleMessageSource broadleafMergeResourceBundleMessageSource = new BroadleafMergeResourceBundleMessageSource();
    String[] basenames = new String[]{"Basenames", "UTF-8"};

    // Act
    broadleafMergeResourceBundleMessageSource.setBasenames(basenames);

    // Assert
    Set<String> basenameSet = broadleafMergeResourceBundleMessageSource.getBasenameSet();
    assertEquals(2, basenameSet.size());
    assertTrue(basenameSet.contains("Basenames"));
    assertTrue(basenameSet.contains("UTF-8"));
    assertArrayEquals(new String[]{"UTF-8", "Basenames"}, basenames);
  }

  /**
   * Test
   * {@link BroadleafMergeResourceBundleMessageSource#setBasenames(String[])}.
   * <p>
   * Method under test:
   * {@link BroadleafMergeResourceBundleMessageSource#setBasenames(String[])}
   */
  @Test
  public void testSetBasenames3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafMergeResourceBundleMessageSource broadleafMergeResourceBundleMessageSource = new BroadleafMergeResourceBundleMessageSource();
    broadleafMergeResourceBundleMessageSource.setPropertiesPersister(mock(DefaultPropertiesPersister.class));
    String[] basenames = new String[]{"Basenames"};

    // Act
    broadleafMergeResourceBundleMessageSource.setBasenames(basenames);

    // Assert that nothing has changed
    Set<String> basenameSet = broadleafMergeResourceBundleMessageSource.getBasenameSet();
    assertEquals(1, basenameSet.size());
    assertTrue(basenameSet.contains("Basenames"));
    assertArrayEquals(new String[]{"Basenames"}, basenames);
  }
}
