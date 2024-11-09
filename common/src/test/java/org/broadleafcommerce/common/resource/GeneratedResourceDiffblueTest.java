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
package org.broadleafcommerce.common.resource;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {GeneratedResource.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GeneratedResourceDiffblueTest {
  @Autowired
  private GeneratedResource generatedResource;

  /**
   * Test {@link GeneratedResource#GeneratedResource()}.
   * <p>
   * Method under test: {@link GeneratedResource#GeneratedResource()}
   */
  @Test
  public void testNewGeneratedResource() throws IOException {
    // Arrange and Act
    GeneratedResource actualGeneratedResource = new GeneratedResource();

    // Assert
    assertNull(actualGeneratedResource.getDescription());
    assertNull(actualGeneratedResource.getFilename());
    assertNull(actualGeneratedResource.hashRepresentation);
    assertEquals(-1, actualGeneratedResource.getInputStream().read(new byte[]{}));
    assertEquals(0, actualGeneratedResource.getBytes().length);
    assertFalse(actualGeneratedResource.isFile());
    assertFalse(actualGeneratedResource.isOpen());
  }

  /**
   * Test {@link GeneratedResource#GeneratedResource(byte[], String)}.
   * <p>
   * Method under test:
   * {@link GeneratedResource#GeneratedResource(byte[], String)}
   */
  @Test
  public void testNewGeneratedResource2() throws IOException {
    // Arrange
    byte[] source = "AXAXAXAX".getBytes("UTF-8");

    // Act
    GeneratedResource actualGeneratedResource = new GeneratedResource(source,
        "The characteristics of someone or something");

    // Assert
    assertEquals("The characteristics of someone or something", actualGeneratedResource.getDescription());
    assertEquals("The characteristics of someone or something", actualGeneratedResource.getFilename());
    assertNull(actualGeneratedResource.hashRepresentation);
    byte[] byteArray = new byte[8];
    assertEquals(8, actualGeneratedResource.getInputStream().read(byteArray));
    assertFalse(actualGeneratedResource.isFile());
    assertFalse(actualGeneratedResource.isOpen());
    assertSame(source, actualGeneratedResource.getBytes());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link GeneratedResource#getFilename()}.
   * <p>
   * Method under test: {@link GeneratedResource#getFilename()}
   */
  @Test
  public void testGetFilename() {
    // Arrange, Act and Assert
    assertNull((new GeneratedResource()).getFilename());
  }

  /**
   * Test {@link GeneratedResource#getHashRepresentation()}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeneratedResource#getHashRepresentation()}
   */
  @Test
  public void testGetHashRepresentation_thenReturnFoo() {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();
    generatedResource.setHashRepresentation("foo");

    // Act and Assert
    assertEquals("foo", generatedResource.getHashRepresentation());
  }

  /**
   * Test {@link GeneratedResource#getInputStream()}.
   * <p>
   * Method under test: {@link GeneratedResource#getInputStream()}
   */
  @Test
  public void testGetInputStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new GeneratedResource()).getInputStream().read(new byte[]{}));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GeneratedResource#setHashRepresentation(String)}
   *   <li>{@link GeneratedResource#getBytes()}
   *   <li>{@link GeneratedResource#getDescription()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();

    // Act
    generatedResource.setHashRepresentation("Hash Representation");
    byte[] actualBytes = generatedResource.getBytes();
    generatedResource.getDescription();

    // Assert that nothing has changed
    assertEquals(0, actualBytes.length);
  }

  /**
   * Test {@link GeneratedResource#equals(Object)}, and
   * {@link GeneratedResource#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GeneratedResource#equals(Object)}
   *   <li>{@link GeneratedResource#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();
    GeneratedResource generatedResource2 = new GeneratedResource();

    // Act and Assert
    assertEquals(generatedResource, generatedResource2);
    int expectedHashCodeResult = generatedResource.hashCode();
    assertEquals(expectedHashCodeResult, generatedResource2.hashCode());
  }

  /**
   * Test {@link GeneratedResource#equals(Object)}, and
   * {@link GeneratedResource#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GeneratedResource#equals(Object)}
   *   <li>{@link GeneratedResource#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();

    // Act and Assert
    assertEquals(generatedResource, generatedResource);
    int expectedHashCodeResult = generatedResource.hashCode();
    assertEquals(expectedHashCodeResult, generatedResource.hashCode());
  }

  /**
   * Test {@link GeneratedResource#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeneratedResource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource("AXAXAXAX".getBytes("UTF-8"),
        "The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(generatedResource, new GeneratedResource());
  }

  /**
   * Test {@link GeneratedResource#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeneratedResource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GeneratedResource(), null);
  }

  /**
   * Test {@link GeneratedResource#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeneratedResource#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GeneratedResource(), "Different type to GeneratedResource");
  }
}
