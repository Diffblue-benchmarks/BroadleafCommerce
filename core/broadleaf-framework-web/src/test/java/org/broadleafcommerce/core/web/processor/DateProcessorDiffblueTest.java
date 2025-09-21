/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DateProcessorDiffblueTest {
  /**
   * Test {@link DateProcessor#getName()}.
   *
   * <p>Method under test: {@link DateProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DateProcessor.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("date", new DateProcessor().getName());
  }

  /**
   * Test {@link DateProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link DateProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DateProcessor.getPrecedence()"})
  void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new DateProcessor().getPrecedence());
  }

  /**
   * Test {@link DateProcessor#renderWithContextTimeZone(Date)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link DateProcessor#renderWithContextTimeZone(Date)}
   */
  @Test
  @DisplayName("Test renderWithContextTimeZone(Date); when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DateProcessor.renderWithContextTimeZone(Date)"})
  void testRenderWithContextTimeZone_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new DateProcessor().renderWithContextTimeZone(null));
  }
}
