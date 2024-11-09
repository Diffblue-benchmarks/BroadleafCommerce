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
package org.broadleafcommerce.common.extensibility.jpa.copy;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class DirectCopyIgnorePatternDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DirectCopyIgnorePattern}
   *   <li>{@link DirectCopyIgnorePattern#setPatterns(String[])}
   *   <li>{@link DirectCopyIgnorePattern#setTemplateTokenPatterns(String[])}
   *   <li>{@link DirectCopyIgnorePattern#getPatterns()}
   *   <li>{@link DirectCopyIgnorePattern#getTemplateTokenPatterns()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DirectCopyIgnorePattern actualDirectCopyIgnorePattern = new DirectCopyIgnorePattern();
    String[] patterns = new String[]{"Patterns"};
    actualDirectCopyIgnorePattern.setPatterns(patterns);
    String[] templateTokenPatterns = new String[]{"ABC123"};
    actualDirectCopyIgnorePattern.setTemplateTokenPatterns(templateTokenPatterns);
    String[] actualPatterns = actualDirectCopyIgnorePattern.getPatterns();
    String[] actualTemplateTokenPatterns = actualDirectCopyIgnorePattern.getTemplateTokenPatterns();

    // Assert that nothing has changed
    assertSame(templateTokenPatterns, actualTemplateTokenPatterns);
    assertSame(patterns, actualPatterns);
    assertArrayEquals(new String[]{"ABC123"}, actualTemplateTokenPatterns);
    assertArrayEquals(new String[]{"Patterns"}, actualPatterns);
  }
}
