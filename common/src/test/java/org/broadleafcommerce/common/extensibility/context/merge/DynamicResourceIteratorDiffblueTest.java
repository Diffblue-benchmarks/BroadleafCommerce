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
package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DynamicResourceIterator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DynamicResourceIteratorDiffblueTest {
  @Autowired
  private DynamicResourceIterator dynamicResourceIterator;

  /**
   * Test {@link DynamicResourceIterator#add(int, ResourceInputStream)} with {@code index}, {@code resourceInputStream}.
   * <p>
   * Method under test: {@link DynamicResourceIterator#add(int, ResourceInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicResourceIterator.add(int, ResourceInputStream)"})
  public void testAddWithIndexResourceInputStream() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream = new ResourceInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    // Act
    dynamicResourceIterator.add(0, resourceInputStream);

    // Assert
    assertEquals(-1, resourceInputStream.read(new byte[]{}));
  }

  /**
   * Test {@link DynamicResourceIterator#add(ResourceInputStream)} with {@code resourceInputStream}.
   * <p>
   * Method under test: {@link DynamicResourceIterator#add(ResourceInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicResourceIterator.add(ResourceInputStream)"})
  public void testAddWithResourceInputStream() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream = new ResourceInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    // Act
    boolean actualAddResult = dynamicResourceIterator.add(resourceInputStream);

    // Assert
    assertEquals(-1, resourceInputStream.read(new byte[]{}));
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link DynamicResourceIterator#add(ResourceInputStream)} with {@code resourceInputStream}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicResourceIterator#add(ResourceInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicResourceIterator.add(ResourceInputStream)"})
  public void testAddWithResourceInputStream_givenArrayList() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream = mock(ResourceInputStream.class);
    when(resourceInputStream.getNames()).thenReturn(new ArrayList<>());
    when(resourceInputStream.read()).thenReturn(-1);
    doNothing().when(resourceInputStream).close();

    // Act
    boolean actualAddResult = dynamicResourceIterator.add(resourceInputStream);

    // Assert
    verify(resourceInputStream).close();
    verify(resourceInputStream).getNames();
    verify(resourceInputStream).read();
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link DynamicResourceIterator#addAll(Collection)} with {@code Collection}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicResourceIterator#addAll(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DynamicResourceIterator.addAll(Collection)"})
  public void testAddAllWithCollection_whenArrayList_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(dynamicResourceIterator.addAll(new ArrayList<>()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DynamicResourceIterator}
   *   <li>{@link DynamicResourceIterator#getPosition()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DynamicResourceIterator.<init>()", "int DynamicResourceIterator.getPosition()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new DynamicResourceIterator()).getPosition());
  }
}
