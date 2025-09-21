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
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeException;
import org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeManagerSetupException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class MergeManagerDiffblueTest {
  /**
   * Test {@link MergeManager#merge(ResourceInputStream, ResourceInputStream)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>When {@link DataInputStream} {@link DataInputStream#read()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link DataInputStream#read()}.
   * </ul>
   *
   * <p>Method under test: {@link MergeManager#merge(ResourceInputStream, ResourceInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceInputStream MergeManager.merge(ResourceInputStream, ResourceInputStream)"
  })
  public void testMerge_givenIOException_whenDataInputStreamReadThrowIOException_thenCallsRead()
      throws IOException, MergeException, MergeManagerSetupException {
    // Arrange
    MergeManager mergeManager = new MergeManager();

    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenThrow(new IOException());
    ResourceInputStream stream1 = new ResourceInputStream(is, "Name");

    // Act and Assert
    assertThrows(
        MergeException.class,
        () ->
            mergeManager.merge(
                stream1,
                new ResourceInputStream(
                    new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")));
    verify(is).read();
  }

  /**
   * Test {@link MergeManager#merge(ResourceInputStream, ResourceInputStream)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MergeManager#merge(ResourceInputStream, ResourceInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceInputStream MergeManager.merge(ResourceInputStream, ResourceInputStream)"
  })
  public void testMerge_whenNull()
      throws UnsupportedEncodingException, MergeException, MergeManagerSetupException {
    // Arrange
    MergeManager mergeManager = new MergeManager();

    // Act and Assert
    assertThrows(
        MergeException.class,
        () ->
            mergeManager.merge(
                null,
                new ResourceInputStream(
                    new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")));
  }

  /**
   * Test {@link MergeManager#merge(ResourceInputStream, ResourceInputStream)}.
   *
   * <ul>
   *   <li>When {@link ResourceInputStream#ResourceInputStream(InputStream, String)} with is is
   *       {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link MergeManager#merge(ResourceInputStream, ResourceInputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceInputStream MergeManager.merge(ResourceInputStream, ResourceInputStream)"
  })
  public void testMerge_whenResourceInputStreamWithIsIsByteArrayInputStreamAndName()
      throws UnsupportedEncodingException, MergeException, MergeManagerSetupException {
    // Arrange
    MergeManager mergeManager = new MergeManager();
    ResourceInputStream stream1 =
        new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    // Act and Assert
    assertThrows(
        MergeException.class,
        () ->
            mergeManager.merge(
                stream1,
                new ResourceInputStream(
                    new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")));
  }

  /**
   * Test {@link MergeManager#serialize(InputStream)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ObjectInputStream} {@link ObjectInputStream#read(byte[], int, int)} return
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link MergeManager#serialize(InputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MergeManager.serialize(InputStream)"})
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
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link MergeManager#serialize(InputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MergeManager.serialize(InputStream)"})
  public void testSerialize_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnAxaxaxax()
      throws IOException, MergeManagerSetupException {
    // Arrange
    MergeManager mergeManager = new MergeManager();
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualSerializeResult = mergeManager.serialize(in);

    // Assert
    assertEquals("AXAXAXAX", actualSerializeResult);
    int actualReadResult = in.read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link MergeManager#serialize(InputStream)}.
   *
   * <ul>
   *   <li>When {@link ObjectInputStream} {@link ObjectInputStream#read(byte[], int, int)} throw
   *       {@link IOException#IOException()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link MergeManager#serialize(InputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MergeManager.serialize(InputStream)"})
  public void testSerialize_whenObjectInputStreamReadThrowIOException_thenReturnEmptyString()
      throws IOException, MergeManagerSetupException {
    // Arrange
    MergeManager mergeManager = new MergeManager();

    ObjectInputStream in = mock(ObjectInputStream.class);
    when(in.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException());
    doThrow(new IOException()).when(in).close();

    // Act
    String actualSerializeResult = mergeManager.serialize(in);

    // Assert
    verify(in).close();
    verify(in).read(isA(byte[].class), eq(0), eq(8192));
    assertEquals("", actualSerializeResult);
  }
}
