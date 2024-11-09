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
package org.broadleafcommerce.common.extensibility.context.merge.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {AttributePreserveInsert.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseHandlerDiffblueTest {
  @Autowired
  private BaseHandler baseHandler;

  /**
   * Test {@link BaseHandler#getPriority()}.
   * <p>
   * Method under test: {@link BaseHandler#getPriority()}
   */
  @Test
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(0, (new AttributePreserveInsert()).getPriority());
  }

  /**
   * Test {@link BaseHandler#getXPath()}.
   * <p>
   * Method under test: {@link BaseHandler#getXPath()}
   */
  @Test
  public void testGetXPath() {
    // Arrange, Act and Assert
    assertNull((new AttributePreserveInsert()).getXPath());
  }

  /**
   * Test {@link BaseHandler#setPriority(int)}.
   * <p>
   * Method under test: {@link BaseHandler#setPriority(int)}
   */
  @Test
  public void testSetPriority() {
    // Arrange
    AttributePreserveInsert attributePreserveInsert = new AttributePreserveInsert();

    // Act
    attributePreserveInsert.setPriority(1);

    // Assert
    assertEquals(1, attributePreserveInsert.getPriority());
  }

  /**
   * Test {@link BaseHandler#setXPath(String)}.
   * <p>
   * Method under test: {@link BaseHandler#setXPath(String)}
   */
  @Test
  public void testSetXPath() {
    // Arrange and Act
    baseHandler.setXPath("Xpath");

    // Assert
    assertTrue(baseHandler instanceof AttributePreserveInsert);
    assertEquals("Xpath", baseHandler.getXPath());
  }

  /**
   * Test {@link BaseHandler#compareTo(Object)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseHandler#compareTo(Object)}
   */
  @Test
  public void testCompareTo_givenOne_thenReturnMinusOne() {
    // Arrange
    CommaDelimitedNodeValueMerge commaDelimitedNodeValueMerge = mock(CommaDelimitedNodeValueMerge.class);
    when(commaDelimitedNodeValueMerge.getPriority()).thenReturn(1);

    // Act
    int actualCompareToResult = baseHandler.compareTo(commaDelimitedNodeValueMerge);

    // Assert
    verify(commaDelimitedNodeValueMerge).getPriority();
    assertEquals(-1, actualCompareToResult);
  }

  /**
   * Test {@link BaseHandler#getChildren()}.
   * <p>
   * Method under test: {@link BaseHandler#getChildren()}
   */
  @Test
  public void testGetChildren() {
    // Arrange, Act and Assert
    assertEquals(0, (new AttributePreserveInsert()).getChildren().length);
  }

  /**
   * Test {@link BaseHandler#setChildren(MergeHandler[])}.
   * <p>
   * Method under test: {@link BaseHandler#setChildren(MergeHandler[])}
   */
  @Test
  public void testSetChildren() {
    // Arrange
    AttributePreserveInsert attributePreserveInsert = new AttributePreserveInsert();
    MergeHandler[] children = new MergeHandler[]{new AttributePreserveInsert()};

    // Act
    attributePreserveInsert.setChildren(children);

    // Assert
    assertSame(children, attributePreserveInsert.getChildren());
  }

  /**
   * Test {@link BaseHandler#getName()}.
   * <p>
   * Method under test: {@link BaseHandler#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull((new AttributePreserveInsert()).getName());
  }

  /**
   * Test {@link BaseHandler#setName(String)}.
   * <p>
   * Method under test: {@link BaseHandler#setName(String)}
   */
  @Test
  public void testSetName() {
    // Arrange and Act
    baseHandler.setName("Name");

    // Assert
    assertTrue(baseHandler instanceof AttributePreserveInsert);
    assertEquals("Name", baseHandler.getName());
  }
}
