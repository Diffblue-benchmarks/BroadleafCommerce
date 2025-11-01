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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
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
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeException;
import org.broadleafcommerce.common.extensibility.context.merge.exceptions.MergeManagerSetupException;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class MergeXmlConfigResourceDiffblueTest {
  /**
   * Method under test:
   * {@link MergeXmlConfigResource#getMergedConfigResource(ResourceInputStream[])}
   */
  @Test
  public void testGetMergedConfigResource() throws IOException, BeansException {
    // Arrange
    MergeXmlConfigResource mergeXmlConfigResource = new MergeXmlConfigResource();
    ResourceInputStream resourceInputStream = new ResourceInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    ResourceInputStream[] sources = new ResourceInputStream[]{resourceInputStream};

    // Act
    Resource actualMergedConfigResource = mergeXmlConfigResource.getMergedConfigResource(sources);

    // Assert
    assertTrue(actualMergedConfigResource instanceof ByteArrayResource);
    assertEquals("Byte array resource [resource loaded from byte array]", actualMergedConfigResource.getDescription());
    assertNull(actualMergedConfigResource.getFilename());
    ResourceInputStream resourceInputStream2 = sources[0];
    assertEquals(-1, resourceInputStream2.read(new byte[]{}));
    assertEquals(1, sources.length);
    byte[] byteArray = new byte[8];
    assertEquals(8, actualMergedConfigResource.getInputStream().read(byteArray));
    assertFalse(actualMergedConfigResource.isFile());
    assertFalse(actualMergedConfigResource.isOpen());
    assertSame(resourceInputStream, resourceInputStream2);
    byte[] expectedByteArray = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedByteArray, ((ByteArrayResource) actualMergedConfigResource).getByteArray());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test:
   * {@link MergeXmlConfigResource#getMergedConfigResource(ResourceInputStream[])}
   */
  @Test
  public void testGetMergedConfigResource2() throws UnsupportedEncodingException, BeansException {
    // Arrange
    MergeXmlConfigResource mergeXmlConfigResource = new MergeXmlConfigResource();
    ResourceInputStream resourceInputStream = new ResourceInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    // Act and Assert
    assertThrows(FatalBeanException.class,
        () -> mergeXmlConfigResource.getMergedConfigResource(new ResourceInputStream[]{resourceInputStream,
            new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")}));
  }

  /**
   * Method under test:
   * {@link MergeXmlConfigResource#getMergedConfigResource(ResourceInputStream[])}
   */
  @Test
  public void testGetMergedConfigResource3() throws UnsupportedEncodingException, BeansException {
    // Arrange
    MergeXmlConfigResource mergeXmlConfigResource = new MergeXmlConfigResource();

    // Act and Assert
    assertThrows(FatalBeanException.class,
        () -> mergeXmlConfigResource.getMergedConfigResource(new ResourceInputStream[]{null,
            new ResourceInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")}));
  }

  /**
   * Method under test:
   * {@link MergeXmlConfigResource#merge(ResourceInputStream[])}
   */
  @Test
  public void testMerge() throws IOException, MergeException, MergeManagerSetupException {
    // Arrange
    MergeXmlConfigResource mergeXmlConfigResource = new MergeXmlConfigResource();
    ResourceInputStream resourceInputStream = new ResourceInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name");

    // Act
    ResourceInputStream actualMergeResult = mergeXmlConfigResource
        .merge(new ResourceInputStream[]{resourceInputStream});

    // Assert
    byte[] bytes = new byte[8];
    assertEquals(8, actualMergeResult.read(bytes));
    assertSame(resourceInputStream, actualMergeResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), bytes);
  }

  /**
   * Method under test: {@link MergeXmlConfigResource#serialize(InputStream)}
   */
  @Test
  public void testSerialize() throws IOException {
    // Arrange
    MergeXmlConfigResource mergeXmlConfigResource = new MergeXmlConfigResource();
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("AXAXAXAX", mergeXmlConfigResource.serialize(in));
    assertEquals(-1, in.read(new byte[]{}));
  }

  /**
   * Method under test: {@link MergeXmlConfigResource#serialize(InputStream)}
   */
  @Test
  public void testSerialize2() throws IOException {
    // Arrange
    MergeXmlConfigResource mergeXmlConfigResource = new MergeXmlConfigResource();
    ObjectInputStream in = mock(ObjectInputStream.class);
    when(in.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(0);
    doNothing().when(in).close();

    // Act
    String actualSerializeResult = mergeXmlConfigResource.serialize(in);

    // Assert
    verify(in).close();
    verify(in).read(isA(byte[].class), eq(0), eq(8192));
    assertEquals("", actualSerializeResult);
  }

  /**
   * Method under test: {@link MergeXmlConfigResource#serialize(Resource)}
   */
  @Test
  public void testSerialize3() {
    // Arrange
    MergeXmlConfigResource mergeXmlConfigResource = new MergeXmlConfigResource();

    // Act and Assert
    assertEquals("", mergeXmlConfigResource.serialize(new GeneratedResource()));
  }

  /**
   * Method under test: {@link MergeXmlConfigResource#serialize(Resource)}
   */
  @Test
  public void testSerialize4() {
    // Arrange
    MergeXmlConfigResource mergeXmlConfigResource = new MergeXmlConfigResource();

    // Act and Assert
    assertEquals("A�A�A�A�",
        mergeXmlConfigResource.serialize(new ByteArrayResource(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1})));
  }

  /**
   * Method under test: {@link MergeXmlConfigResource#serialize(Resource)}
   */
  @Test
  public void testSerialize5() {
    // Arrange
    MergeXmlConfigResource mergeXmlConfigResource = new MergeXmlConfigResource();

    // Act and Assert
    assertEquals("", mergeXmlConfigResource.serialize(new ClassPathResource("Path")));
  }

  /**
   * Method under test: {@link MergeXmlConfigResource#serialize(Resource)}
   */
  @Test
  public void testSerialize6() {
    // Arrange
    MergeXmlConfigResource mergeXmlConfigResource = new MergeXmlConfigResource();

    // Act and Assert
    assertEquals("", mergeXmlConfigResource.serialize(new FileSystemResource("")));
  }

  /**
   * Method under test:
   * {@link MergeXmlConfigResource#buildArrayFromStream(InputStream)}
   */
  @Test
  public void testBuildArrayFromStream() throws IOException {
    // Arrange
    MergeXmlConfigResource mergeXmlConfigResource = new MergeXmlConfigResource();
    ByteArrayInputStream source = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualBuildArrayFromStreamResult = mergeXmlConfigResource.buildArrayFromStream(source);

    // Assert
    assertEquals(-1, source.read(new byte[]{}));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBuildArrayFromStreamResult);
  }

  /**
   * Method under test:
   * {@link MergeXmlConfigResource#buildArrayFromStream(InputStream)}
   */
  @Test
  public void testBuildArrayFromStream2() throws IOException {
    // Arrange
    MergeXmlConfigResource mergeXmlConfigResource = new MergeXmlConfigResource();
    DataInputStream source = mock(DataInputStream.class);
    when(source.read()).thenThrow(new FactoryBeanNotInitializedException("Msg"));
    doThrow(new FactoryBeanNotInitializedException("Msg")).when(source).close();

    // Act and Assert
    assertThrows(FactoryBeanNotInitializedException.class, () -> mergeXmlConfigResource.buildArrayFromStream(source));
    verify(source).close();
    verify(source).read();
  }
}
