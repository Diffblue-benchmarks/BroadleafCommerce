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
package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DynamicResourceIterator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DynamicResourceIteratorDiffblueTest {
  @Autowired
  private DynamicResourceIterator dynamicResourceIterator;

  /**
   * Test {@link DynamicResourceIterator#nextResource()}.
   * <ul>
   *   <li>Then return read is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicResourceIterator#nextResource()}
   */
  @Test
  public void testNextResource_thenReturnReadIsEight() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<ResourceInputStream> c = new ArrayList<>();
    c.add(new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name"));

    DynamicResourceIterator dynamicResourceIterator = new DynamicResourceIterator();
    dynamicResourceIterator.addAll(c);

    // Act and Assert
    byte[] bytes = new byte[8];
    assertEquals(8, dynamicResourceIterator.nextResource().read(bytes));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Test {@link DynamicResourceIterator#nextResource()}.
   * <ul>
   *   <li>Then return read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicResourceIterator#nextResource()}
   */
  @Test
  public void testNextResource_thenReturnReadIsMinusOne() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceInputStream resourceInputStream = mock(ResourceInputStream.class);
    when(resourceInputStream.getNames()).thenReturn(new ArrayList<>());
    when(resourceInputStream.read()).thenReturn(-1);
    doNothing().when(resourceInputStream).close();

    ArrayList<ResourceInputStream> c = new ArrayList<>();
    c.add(resourceInputStream);

    DynamicResourceIterator dynamicResourceIterator = new DynamicResourceIterator();
    dynamicResourceIterator.addAll(c);

    // Act
    ResourceInputStream actualNextResourceResult = dynamicResourceIterator.nextResource();

    // Assert
    verify(resourceInputStream).close();
    verify(resourceInputStream).getNames();
    verify(resourceInputStream).read();
    assertEquals(-1, actualNextResourceResult.read(new byte[]{}));
  }

  /**
   * Test
   * {@link DynamicResourceIterator#addEmbeddedResource(ResourceInputStream)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicResourceIterator#addEmbeddedResource(ResourceInputStream)}
   */
  @Test
  public void testAddEmbeddedResource_givenArrayList() throws IOException {
    // Arrange
    ResourceInputStream ris = mock(ResourceInputStream.class);
    when(ris.getNames()).thenReturn(new ArrayList<>());
    when(ris.read()).thenReturn(-1);
    doNothing().when(ris).close();

    // Act
    dynamicResourceIterator.addEmbeddedResource(ris);

    // Assert
    verify(ris).close();
    verify(ris).getNames();
    verify(ris).read();
    assertEquals(1, dynamicResourceIterator.size());
    assertEquals(-1, dynamicResourceIterator.get(0).read(new byte[]{}));
  }

  /**
   * Test {@link DynamicResourceIterator#hasNext()}.
   * <p>
   * Method under test: {@link DynamicResourceIterator#hasNext()}
   */
  @Test
  public void testHasNext() {
    // Arrange, Act and Assert
    assertFalse(dynamicResourceIterator.hasNext());
  }

  /**
   * Test {@link DynamicResourceIterator#add(int, ResourceInputStream)} with
   * {@code index}, {@code resourceInputStream}.
   * <p>
   * Method under test:
   * {@link DynamicResourceIterator#add(int, ResourceInputStream)}
   */
  @Test
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
   * Test {@link DynamicResourceIterator#add(ResourceInputStream)} with
   * {@code resourceInputStream}.
   * <p>
   * Method under test: {@link DynamicResourceIterator#add(ResourceInputStream)}
   */
  @Test
  public void testAddWithResourceInputStream() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream = new ResourceInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    // Act
    dynamicResourceIterator.add(resourceInputStream);

    // Assert
    assertEquals(-1, resourceInputStream.read(new byte[]{}));
  }

  /**
   * Test {@link DynamicResourceIterator#add(ResourceInputStream)} with
   * {@code resourceInputStream}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicResourceIterator#add(ResourceInputStream)}
   */
  @Test
  public void testAddWithResourceInputStream_givenArrayList() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream = mock(ResourceInputStream.class);
    when(resourceInputStream.getNames()).thenReturn(new ArrayList<>());
    when(resourceInputStream.read()).thenReturn(-1);
    doNothing().when(resourceInputStream).close();

    // Act
    dynamicResourceIterator.add(resourceInputStream);

    // Assert
    verify(resourceInputStream).close();
    verify(resourceInputStream).getNames();
    verify(resourceInputStream).read();
  }

  /**
   * Test {@link DynamicResourceIterator#buildArrayFromStream(InputStream)}.
   * <p>
   * Method under test:
   * {@link DynamicResourceIterator#buildArrayFromStream(InputStream)}
   */
  @Test
  public void testBuildArrayFromStream() throws IOException {
    // Arrange
    ByteArrayInputStream source = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualBuildArrayFromStreamResult = dynamicResourceIterator.buildArrayFromStream(source);

    // Assert
    assertEquals(-1, source.read(new byte[]{}));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBuildArrayFromStreamResult);
  }

  /**
   * Test {@link DynamicResourceIterator#buildArrayFromStream(InputStream)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicResourceIterator#buildArrayFromStream(InputStream)}
   */
  @Test
  public void testBuildArrayFromStream_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream source = mock(DataInputStream.class);
    when(source.read()).thenThrow(new RuntimeException("foo"));
    doThrow(new RuntimeException("foo")).when(source).close();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicResourceIterator.buildArrayFromStream(source));
    verify(source).close();
    verify(source).read();
  }

  /**
   * Test {@link DynamicResourceIterator#addAll(Collection)} with
   * {@code Collection}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicResourceIterator#addAll(Collection)}
   */
  @Test
  public void testAddAllWithCollection_givenA_thenArrayListSizeIsTwo() throws IOException {
    // Arrange
    ArrayList<ResourceInputStream> c = new ArrayList<>();
    c.add(new ResourceInputStream(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), "Name"));
    c.add(new ResourceInputStream(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), "Name"));

    // Act
    dynamicResourceIterator.addAll(c);

    // Assert
    assertEquals(2, c.size());
    assertEquals(-1, c.get(1).read(new byte[]{}));
  }

  /**
   * Test {@link DynamicResourceIterator#addAll(Collection)} with
   * {@code Collection}.
   * <ul>
   *   <li>Given {@link ResourceInputStream} {@link ResourceInputStream#getNames()}
   * return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicResourceIterator#addAll(Collection)}
   */
  @Test
  public void testAddAllWithCollection_givenResourceInputStreamGetNamesReturnArrayList() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream = mock(ResourceInputStream.class);
    when(resourceInputStream.getNames()).thenReturn(new ArrayList<>());
    when(resourceInputStream.read()).thenReturn(-1);
    doNothing().when(resourceInputStream).close();

    ArrayList<ResourceInputStream> c = new ArrayList<>();
    c.add(resourceInputStream);

    // Act
    dynamicResourceIterator.addAll(c);

    // Assert
    verify(resourceInputStream).close();
    verify(resourceInputStream).getNames();
    verify(resourceInputStream).read();
  }

  /**
   * Test {@link DynamicResourceIterator#addAll(Collection)} with
   * {@code Collection}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicResourceIterator#addAll(Collection)}
   */
  @Test
  public void testAddAllWithCollection_thenThrowRuntimeException() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream = mock(ResourceInputStream.class);
    when(resourceInputStream.getNames()).thenThrow(new RuntimeException("foo"));
    when(resourceInputStream.read()).thenReturn(-1);
    doNothing().when(resourceInputStream).close();

    ArrayList<ResourceInputStream> c = new ArrayList<>();
    c.add(resourceInputStream);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> dynamicResourceIterator.addAll(c));
    verify(resourceInputStream).close();
    verify(resourceInputStream).getNames();
    verify(resourceInputStream).read();
  }

  /**
   * Test {@link DynamicResourceIterator#addAll(Collection)} with
   * {@code Collection}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicResourceIterator#addAll(Collection)}
   */
  @Test
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
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new DynamicResourceIterator()).getPosition());
  }
}
