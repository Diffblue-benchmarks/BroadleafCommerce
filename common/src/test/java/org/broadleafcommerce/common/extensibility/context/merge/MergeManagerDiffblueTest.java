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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeException;
import org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeManagerSetupException;
import org.junit.Test;
import org.mockito.Mockito;

public class MergeManagerDiffblueTest {
  /**
   * Test {@link MergeManager#merge(ResourceInputStream, ResourceInputStream)}.
   * <ul>
   *   <li>Given
   * {@link UnsupportedEncodingException#UnsupportedEncodingException(String)}
   * with {@code foo}.</li>
   *   <li>Then calls {@link FilterInputStream#read()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeManager#merge(ResourceInputStream, ResourceInputStream)}
   */
  @Test
  public void testMerge_givenUnsupportedEncodingExceptionWithFoo_thenCallsRead()
      throws IOException, MergeException, MergeManagerSetupException {
    // Arrange
    MergeManager mergeManager = new MergeManager();
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenThrow(new UnsupportedEncodingException("foo"));
    ResourceInputStream stream1 = new ResourceInputStream(is, "Name");

    // Act and Assert
    assertThrows(MergeException.class, () -> mergeManager.merge(stream1,
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")));
    verify(is).read();
  }

  /**
   * Test {@link MergeManager#merge(ResourceInputStream, ResourceInputStream)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeManager#merge(ResourceInputStream, ResourceInputStream)}
   */
  @Test
  public void testMerge_whenNull() throws UnsupportedEncodingException, MergeException, MergeManagerSetupException {
    // Arrange
    MergeManager mergeManager = new MergeManager();

    // Act and Assert
    assertThrows(MergeException.class, () -> mergeManager.merge(null,
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")));
  }

  /**
   * Test {@link MergeManager#merge(ResourceInputStream, ResourceInputStream)}.
   * <ul>
   *   <li>When {@link ResourceInputStream#ResourceInputStream(InputStream, String)}
   * with is is {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} and
   * {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MergeManager#merge(ResourceInputStream, ResourceInputStream)}
   */
  @Test
  public void testMerge_whenResourceInputStreamWithIsIsByteArrayInputStreamAndName()
      throws UnsupportedEncodingException, MergeException, MergeManagerSetupException {
    // Arrange
    MergeManager mergeManager = new MergeManager();
    ResourceInputStream stream1 = new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")),
        "Name");

    // Act and Assert
    assertThrows(MergeException.class, () -> mergeManager.merge(stream1,
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")));
  }

  /**
   * Test {@link MergeManager#serialize(InputStream)}.
   * <p>
   * Method under test: {@link MergeManager#serialize(InputStream)}
   */
  @Test
  public void testSerialize() throws IOException, MergeManagerSetupException {
    // Arrange
    MergeManager mergeManager = new MergeManager();
    ObjectInputStream in = mock(ObjectInputStream.class);
    when(in.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new UnsupportedEncodingException("Unable to merge source and patch locations"));
    doThrow(new UnsupportedEncodingException("Unable to merge source and patch locations")).when(in).close();

    // Act
    String actualSerializeResult = mergeManager.serialize(in);

    // Assert
    verify(in).close();
    verify(in).read(isA(byte[].class), eq(0), eq(8192));
    assertEquals("", actualSerializeResult);
  }

  /**
   * Test {@link MergeManager#serialize(InputStream)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ObjectInputStream}
   * {@link ObjectInputStream#read(byte[], int, int)} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeManager#serialize(InputStream)}
   */
  @Test
  public void testSerialize_givenZero_whenObjectInputStreamReadReturnZero()
      throws IOException, MergeManagerSetupException {
    // Arrange
    MergeManager mergeManager = new MergeManager();
    ObjectInputStream in = mock(ObjectInputStream.class);
    when(in.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(0);
    doNothing().when(in).close();

    // Act
    String actualSerializeResult = mergeManager.serialize(in);

    // Assert
    verify(in).close();
    verify(in).read(isA(byte[].class), eq(0), eq(8192));
    assertEquals("", actualSerializeResult);
  }

  /**
   * Test {@link MergeManager#serialize(InputStream)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code AXAXAXAX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeManager#serialize(InputStream)}
   */
  @Test
  public void testSerialize_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnAxaxaxax()
      throws IOException, MergeManagerSetupException {
    // Arrange
    MergeManager mergeManager = new MergeManager();
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("AXAXAXAX", mergeManager.serialize(in));
    assertEquals(-1, in.read(new byte[]{}));
  }
}
