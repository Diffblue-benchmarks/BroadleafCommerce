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
package org.broadleafcommerce.common.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.regex.Pattern;
import org.broadleafcommerce.common.persistence.EntityDuplicatorImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class MultiTenantCopierDiffblueTest {
  /**
   * Test {@link MultiTenantCopier#getOrder()}.
   * <p>
   * Method under test: {@link MultiTenantCopier#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new EntityDuplicatorImpl()).getOrder());
  }

  /**
   * Test {@link MultiTenantCopier#setOrder(int)}.
   * <p>
   * Method under test: {@link MultiTenantCopier#setOrder(int)}
   */
  @Test
  public void testSetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();

    // Act
    entityDuplicatorImpl.setOrder(1);

    // Assert
    assertEquals(1, entityDuplicatorImpl.getOrder());
  }

  /**
   * Test {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}
   */
  @Test
  public void testExcludeFromCopyRegexPattern_givenEntityDuplicatorImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new EntityDuplicatorImpl()).excludeFromCopyRegexPattern(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor) addPattern
   * compile {@code .*\.txt}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}
   */
  @Test
  public void testExcludeFromCopyRegexPattern_givenEntityDuplicatorImplAddPatternCompileTxt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Act and Assert
    assertFalse(entityDuplicatorImpl.excludeFromCopyRegexPattern(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link MultiTenantCopier#addPattern(Pattern)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#addPattern(Pattern)}
   */
  @Test
  public void testAddPattern_givenEntityDuplicatorImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    Pattern pattern = Pattern.compile(".*\\.txt");

    // Act
    entityDuplicatorImpl.addPattern(pattern);

    // Assert
    List<Pattern> patternList = entityDuplicatorImpl.classExcludeRegexPatternList;
    assertEquals(1, patternList.size());
    assertSame(pattern, patternList.get(0));
  }

  /**
   * Test {@link MultiTenantCopier#addPattern(Pattern)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor) addPattern
   * compile {@code .*\.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#addPattern(Pattern)}
   */
  @Test
  public void testAddPattern_givenEntityDuplicatorImplAddPatternCompileTxt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    Pattern pattern = Pattern.compile(".*\\.txt");
    entityDuplicatorImpl.addPattern(pattern);

    // Act
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Assert that nothing has changed
    List<Pattern> patternList = entityDuplicatorImpl.classExcludeRegexPatternList;
    assertEquals(1, patternList.size());
    assertSame(pattern, patternList.get(0));
  }

  /**
   * Test {@link MultiTenantCopier#needToAdd(Pattern)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor) addPattern
   * compile {@code .*\.txt}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#needToAdd(Pattern)}
   */
  @Test
  public void testNeedToAdd_givenEntityDuplicatorImplAddPatternCompileTxt_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Act and Assert
    assertFalse(entityDuplicatorImpl.needToAdd(Pattern.compile(".*\\.txt")));
  }

  /**
   * Test {@link MultiTenantCopier#needToAdd(Pattern)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#needToAdd(Pattern)}
   */
  @Test
  public void testNeedToAdd_givenEntityDuplicatorImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();

    // Act and Assert
    assertTrue(entityDuplicatorImpl.needToAdd(Pattern.compile(".*\\.txt")));
  }
}
