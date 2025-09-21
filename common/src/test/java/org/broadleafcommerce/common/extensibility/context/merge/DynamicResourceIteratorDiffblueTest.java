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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DynamicResourceIterator.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class DynamicResourceIteratorDiffblueTest {
  @Autowired private DynamicResourceIterator dynamicResourceIterator;

  /**
   * Test {@link DynamicResourceIterator#nextResource()}.
   *
   * <ul>
   *   <li>Then return read is eight.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResourceIterator#nextResource()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceInputStream DynamicResourceIterator.nextResource()"})
  public void testNextResource_thenReturnReadIsEight() throws IOException {
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
   * Test {@link DynamicResourceIterator#addEmbeddedResource(ResourceInputStream)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then {@link DynamicResourceIterator} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResourceIterator#addEmbeddedResource(ResourceInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicResourceIterator.addEmbeddedResource(ResourceInputStream)"})
  public void testAddEmbeddedResource_givenA_thenDynamicResourceIteratorSizeIsTwo()
      throws IOException {
    // Arrange
    DynamicResourceIterator dynamicResourceIterator = new DynamicResourceIterator();
    ByteArrayInputStream is =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    dynamicResourceIterator.add(new ResourceInputStream(is, "Name"));

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
    assertEquals(2, dynamicResourceIterator.size());
    int actualReadResult = dynamicResourceIterator.get(0).read(new byte[] {});
    assertEquals(-1, actualReadResult);
    byte[] bytes = new byte[8];
    assertEquals(8, dynamicResourceIterator.get(1).read(bytes));
    assertArrayEquals(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1}, bytes);
  }

  /**
   * Test {@link DynamicResourceIterator#addEmbeddedResource(ResourceInputStream)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResourceIterator#addEmbeddedResource(ResourceInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicResourceIterator.addEmbeddedResource(ResourceInputStream)"})
  public void testAddEmbeddedResource_givenIOException_thenThrowRuntimeException()
      throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenThrow(new IOException());
    doThrow(new IOException()).when(is).close();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> dynamicResourceIterator.addEmbeddedResource(new ResourceInputStream(is, "Name")));
    verify(is).close();
    verify(is).read();
  }

  /**
   * Test {@link DynamicResourceIterator#addEmbeddedResource(ResourceInputStream)}.
   *
   * <ul>
   *   <li>Then {@link DynamicResourceIterator} first read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResourceIterator#addEmbeddedResource(ResourceInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicResourceIterator.addEmbeddedResource(ResourceInputStream)"})
  public void testAddEmbeddedResource_thenDynamicResourceIteratorFirstReadIsMinusOne()
      throws IOException {
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
    ResourceInputStream getResult = dynamicResourceIterator.get(0);
    int actualReadResult = getResult.read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link DynamicResourceIterator#hasNext()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResourceIterator#hasNext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicResourceIterator.hasNext()"})
  public void testHasNext_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<ResourceInputStream> c = new ArrayList<>();
    c.add(new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name"));

    DynamicResourceIterator dynamicResourceIterator = new DynamicResourceIterator();
    dynamicResourceIterator.addAll(c);

    // Act and Assert
    assertTrue(dynamicResourceIterator.hasNext());
  }

  /**
   * Test {@link DynamicResourceIterator#hasNext()}.
   *
   * <ul>
   *   <li>Given {@link DynamicResourceIterator}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResourceIterator#hasNext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicResourceIterator.hasNext()"})
  public void testHasNext_givenDynamicResourceIterator_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(dynamicResourceIterator.hasNext());
  }

  /**
   * Test {@link DynamicResourceIterator#add(int, ResourceInputStream)} with {@code index}, {@code
   * resourceInputStream}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When zero.
   *   <li>Then calls {@link ResourceInputStream#close()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResourceIterator#add(int, ResourceInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicResourceIterator.add(int, ResourceInputStream)"})
  public void testAddWithIndexResourceInputStream_givenArrayList_whenZero_thenCallsClose()
      throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream = mock(ResourceInputStream.class);
    when(resourceInputStream.getNames()).thenReturn(new ArrayList<>());
    when(resourceInputStream.read()).thenReturn(-1);
    doNothing().when(resourceInputStream).close();

    // Act
    dynamicResourceIterator.add(0, resourceInputStream);

    // Assert
    verify(resourceInputStream).close();
    verify(resourceInputStream).getNames();
    verify(resourceInputStream).read();
  }

  /**
   * Test {@link DynamicResourceIterator#add(int, ResourceInputStream)} with {@code index}, {@code
   * resourceInputStream}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResourceIterator#add(int, ResourceInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicResourceIterator.add(int, ResourceInputStream)"})
  public void testAddWithIndexResourceInputStream_givenIOException_thenThrowRuntimeException()
      throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenThrow(new IOException());
    doThrow(new IOException()).when(is).close();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> dynamicResourceIterator.add(1, new ResourceInputStream(is, "Name")));
    verify(is).close();
    verify(is).read();
  }

  /**
   * Test {@link DynamicResourceIterator#add(ResourceInputStream)} with {@code resourceInputStream}.
   *
   * <p>Method under test: {@link DynamicResourceIterator#add(ResourceInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicResourceIterator.add(ResourceInputStream)"})
  public void testAddWithResourceInputStream() throws IOException {
    // Arrange
    ResourceInputStream resourceInputStream =
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    // Act
    boolean actualAddResult = dynamicResourceIterator.add(resourceInputStream);

    // Assert
    int actualReadResult = resourceInputStream.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link DynamicResourceIterator#add(ResourceInputStream)} with {@code resourceInputStream}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResourceIterator#add(ResourceInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link DynamicResourceIterator#add(ResourceInputStream)} with {@code resourceInputStream}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResourceIterator#add(ResourceInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicResourceIterator.add(ResourceInputStream)"})
  public void testAddWithResourceInputStream_givenIOException_thenThrowRuntimeException()
      throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenThrow(new IOException());
    doThrow(new IOException()).when(is).close();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> dynamicResourceIterator.add(new ResourceInputStream(is, "Name")));
    verify(is).close();
    verify(is).read();
  }

  /**
   * Test {@link DynamicResourceIterator#buildArrayFromStream(InputStream)}.
   *
   * <p>Method under test: {@link DynamicResourceIterator#buildArrayFromStream(InputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DynamicResourceIterator.buildArrayFromStream(InputStream)"})
  public void testBuildArrayFromStream() throws IOException {
    // Arrange
    ByteArrayInputStream source = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualBuildArrayFromStreamResult = dynamicResourceIterator.buildArrayFromStream(source);

    // Assert
    int actualReadResult = source.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBuildArrayFromStreamResult);
  }

  /**
   * Test {@link DynamicResourceIterator#buildArrayFromStream(InputStream)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResourceIterator#buildArrayFromStream(InputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DynamicResourceIterator.buildArrayFromStream(InputStream)"})
  public void testBuildArrayFromStream_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream source = mock(DataInputStream.class);
    when(source.read()).thenThrow(new IOException());
    doThrow(new IOException()).when(source).close();

    // Act and Assert
    assertThrows(IOException.class, () -> dynamicResourceIterator.buildArrayFromStream(source));
    verify(source).close();
    verify(source).read();
  }

  /**
   * Test {@link DynamicResourceIterator#addAll(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@link DynamicResourceIterator} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResourceIterator#addAll(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicResourceIterator.addAll(Collection)"})
  public void testAddAllWithCollection_givenDynamicResourceIterator_thenArrayListSizeIsTwo()
      throws IOException {
    // Arrange
    DynamicResourceIterator dynamicResourceIterator = new DynamicResourceIterator();

    ArrayList<ResourceInputStream> c = new ArrayList<>();
    ByteArrayInputStream is = new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    c.add(new ResourceInputStream(is, "Name"));
    ByteArrayInputStream is2 =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    c.add(new ResourceInputStream(is2, "Name"));

    // Act
    dynamicResourceIterator.addAll(c);

    // Assert
    assertEquals(2, c.size());
    int actualReadResult = c.get(0).read(new byte[] {});
    assertEquals(-1, actualReadResult);
    int actualReadResult2 = c.get(1).read(new byte[] {});
    assertEquals(-1, actualReadResult2);
    assertEquals(2, dynamicResourceIterator.size());
    byte[] bytes = new byte[8];
    assertEquals(8, dynamicResourceIterator.get(0).read(bytes));
    byte[] bytes2 = new byte[8];
    assertEquals(8, dynamicResourceIterator.get(1).read(bytes2));
    assertArrayEquals(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, bytes);
    assertArrayEquals(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, bytes2);
  }

  /**
   * Test {@link DynamicResourceIterator#addAll(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DynamicResourceIterator#addAll(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicResourceIterator.addAll(Collection)"})
  public void testAddAllWithCollection_whenArrayList_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(dynamicResourceIterator.addAll(new ArrayList<>()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DynamicResourceIterator}
   *   <li>{@link DynamicResourceIterator#getPosition()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DynamicResourceIterator.<init>()",
    "int DynamicResourceIterator.getPosition()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, new DynamicResourceIterator().getPosition());
  }
}
