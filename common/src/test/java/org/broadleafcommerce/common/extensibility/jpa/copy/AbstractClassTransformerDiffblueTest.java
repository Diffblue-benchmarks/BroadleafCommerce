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
package org.broadleafcommerce.common.extensibility.jpa.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extensibility.jpa.cache.RemoveCacheClassTransformer;
import org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AlterTableNameClassTransformer.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractClassTransformerDiffblueTest {
  @Autowired private AbstractClassTransformer abstractClassTransformer;

  /**
   * Test {@link AbstractClassTransformer#afterPropertiesSet()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractClassTransformer#afterPropertiesSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractClassTransformer.afterPropertiesSet()"})
  public void testAfterPropertiesSet_givenArrayListAddFoo_thenThrowRuntimeException()
      throws Exception {
    // Arrange
    ArrayList<String> fullyQualifiedClassNames = new ArrayList<>();
    fullyQualifiedClassNames.add("foo");

    RemoveCacheClassTransformer removeCacheClassTransformer =
        new RemoveCacheClassTransformer("Module Name");
    removeCacheClassTransformer.setPreLoadClassNamePatterns(fullyQualifiedClassNames);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> removeCacheClassTransformer.afterPropertiesSet());
  }

  /**
   * Test {@link AbstractClassTransformer#setPreLoadClassNamePatterns(List)}.
   *
   * <p>Method under test: {@link AbstractClassTransformer#setPreLoadClassNamePatterns(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractClassTransformer.setPreLoadClassNamePatterns(List)"})
  public void testSetPreLoadClassNamePatterns() {
    // Arrange and Act
    abstractClassTransformer.setPreLoadClassNamePatterns(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(abstractClassTransformer instanceof AlterTableNameClassTransformer);
    assertTrue(
        ((AlterTableNameClassTransformer) abstractClassTransformer)
            .preLoadClassNamePatterns.isEmpty());
  }

  /**
   * Test {@link AbstractClassTransformer#setPreLoadClassNamePatterns(List)}.
   *
   * <p>Method under test: {@link AbstractClassTransformer#setPreLoadClassNamePatterns(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractClassTransformer.setPreLoadClassNamePatterns(List)"})
  public void testSetPreLoadClassNamePatterns2() {
    // Arrange
    ArrayList<String> fullyQualifiedClassNames = new ArrayList<>();
    fullyQualifiedClassNames.add("foo");

    // Act
    abstractClassTransformer.setPreLoadClassNamePatterns(fullyQualifiedClassNames);

    // Assert
    assertTrue(abstractClassTransformer instanceof AlterTableNameClassTransformer);
    List<String> stringList =
        ((AlterTableNameClassTransformer) abstractClassTransformer).preLoadClassNamePatterns;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
  }

  /**
   * Test {@link AbstractClassTransformer#setPreLoadClassNamePatterns(List)}.
   *
   * <p>Method under test: {@link AbstractClassTransformer#setPreLoadClassNamePatterns(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractClassTransformer.setPreLoadClassNamePatterns(List)"})
  public void testSetPreLoadClassNamePatterns3() {
    // Arrange
    ArrayList<String> fullyQualifiedClassNames = new ArrayList<>();
    fullyQualifiedClassNames.add("42");
    fullyQualifiedClassNames.add("foo");

    // Act
    abstractClassTransformer.setPreLoadClassNamePatterns(fullyQualifiedClassNames);

    // Assert
    assertTrue(abstractClassTransformer instanceof AlterTableNameClassTransformer);
    List<String> stringList =
        ((AlterTableNameClassTransformer) abstractClassTransformer).preLoadClassNamePatterns;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("foo", stringList.get(1));
  }
}
