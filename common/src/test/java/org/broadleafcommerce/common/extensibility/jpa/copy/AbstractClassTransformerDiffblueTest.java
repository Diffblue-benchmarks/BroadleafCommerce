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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extensibility.jpa.convert.AlterTableNameClassTransformer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AlterTableNameClassTransformer.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AbstractClassTransformerDiffblueTest {
  @Autowired
  private AbstractClassTransformer abstractClassTransformer;

  /**
   * Test {@link AbstractClassTransformer#afterPropertiesSet()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractClassTransformer#afterPropertiesSet()}
   */
  @Test
  public void testAfterPropertiesSet_givenArrayListAddFoo_thenThrowRuntimeException() throws Exception {
    // Arrange
    ArrayList<String> fullyQualifiedClassNames = new ArrayList<>();
    fullyQualifiedClassNames.add("foo");

    AlterTableNameClassTransformer alterTableNameClassTransformer = new AlterTableNameClassTransformer();
    alterTableNameClassTransformer.setPreLoadClassNamePatterns(fullyQualifiedClassNames);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> alterTableNameClassTransformer.afterPropertiesSet());
  }

  /**
   * Test {@link AbstractClassTransformer#setPreLoadClassNamePatterns(List)}.
   * <p>
   * Method under test:
   * {@link AbstractClassTransformer#setPreLoadClassNamePatterns(List)}
   */
  @Test
  public void testSetPreLoadClassNamePatterns() {
    // Arrange and Act
    abstractClassTransformer.setPreLoadClassNamePatterns(new ArrayList<>());

    // Assert
    assertTrue(abstractClassTransformer instanceof AlterTableNameClassTransformer);
    assertTrue(((AlterTableNameClassTransformer) abstractClassTransformer).preLoadClassNamePatterns.isEmpty());
  }

  /**
   * Test {@link AbstractClassTransformer#setPreLoadClassNamePatterns(List)}.
   * <p>
   * Method under test:
   * {@link AbstractClassTransformer#setPreLoadClassNamePatterns(List)}
   */
  @Test
  public void testSetPreLoadClassNamePatterns2() {
    // Arrange
    ArrayList<String> fullyQualifiedClassNames = new ArrayList<>();
    fullyQualifiedClassNames.add("foo");

    // Act
    abstractClassTransformer.setPreLoadClassNamePatterns(fullyQualifiedClassNames);

    // Assert
    assertTrue(abstractClassTransformer instanceof AlterTableNameClassTransformer);
    List<String> stringList = ((AlterTableNameClassTransformer) abstractClassTransformer).preLoadClassNamePatterns;
    assertEquals(1, stringList.size());
    assertEquals("foo", stringList.get(0));
  }

  /**
   * Test {@link AbstractClassTransformer#setPreLoadClassNamePatterns(List)}.
   * <p>
   * Method under test:
   * {@link AbstractClassTransformer#setPreLoadClassNamePatterns(List)}
   */
  @Test
  public void testSetPreLoadClassNamePatterns3() {
    // Arrange
    ArrayList<String> fullyQualifiedClassNames = new ArrayList<>();
    fullyQualifiedClassNames.add("42");
    fullyQualifiedClassNames.add("foo");

    // Act
    abstractClassTransformer.setPreLoadClassNamePatterns(fullyQualifiedClassNames);

    // Assert
    assertTrue(abstractClassTransformer instanceof AlterTableNameClassTransformer);
    List<String> stringList = ((AlterTableNameClassTransformer) abstractClassTransformer).preLoadClassNamePatterns;
    assertEquals(2, stringList.size());
    assertEquals("42", stringList.get(0));
    assertEquals("foo", stringList.get(1));
  }
}
