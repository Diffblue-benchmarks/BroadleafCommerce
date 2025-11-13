package org.broadleafcommerce.common.resource;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {GeneratedResource.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GeneratedResourceDiffblueTest {
  @Autowired private GeneratedResource generatedResource;

  /**
   * Test {@link GeneratedResource#GeneratedResource()}.
   *
   * <p>Method under test: {@link GeneratedResource#GeneratedResource()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GeneratedResource.<init>()"})
  public void testNewGeneratedResource() throws IOException {
    // Arrange and Act
    GeneratedResource actualGeneratedResource = new GeneratedResource();

    // Assert
    assertNull(actualGeneratedResource.getDescription());
    assertNull(actualGeneratedResource.getFilename());
    assertNull(actualGeneratedResource.hashRepresentation);
    int actualReadResult = actualGeneratedResource.getInputStream().read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertFalse(actualGeneratedResource.isFile());
    assertFalse(actualGeneratedResource.isOpen());
    assertArrayEquals(new byte[] {}, actualGeneratedResource.getBytes());
  }

  /**
   * Test {@link GeneratedResource#GeneratedResource(byte[], String)}.
   *
   * <p>Method under test: {@link GeneratedResource#GeneratedResource(byte[], String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GeneratedResource.<init>(byte[], String)"})
  public void testNewGeneratedResource2() throws IOException {
    // Arrange and Act
    GeneratedResource actualGeneratedResource =
        new GeneratedResource(
            "AXAXAXAX".getBytes("UTF-8"), "The characteristics of someone or something");

    // Assert
    assertEquals(
        "The characteristics of someone or something", actualGeneratedResource.getDescription());
    assertEquals(
        "The characteristics of someone or something", actualGeneratedResource.getFilename());
    assertNull(actualGeneratedResource.hashRepresentation);
    byte[] byteArray = new byte[8];
    assertEquals(8, actualGeneratedResource.getInputStream().read(byteArray));
    assertFalse(actualGeneratedResource.isFile());
    assertFalse(actualGeneratedResource.isOpen());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualGeneratedResource.getBytes());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link GeneratedResource#getFilename()}.
   *
   * <p>Method under test: {@link GeneratedResource#getFilename()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GeneratedResource.getFilename()"})
  public void testGetFilename() {
    // Arrange, Act and Assert
    assertNull(new GeneratedResource().getFilename());
  }

  /**
   * Test {@link GeneratedResource#getHashRepresentation()}.
   *
   * <ul>
   *   <li>Then return {@code Hash Representation}.
   * </ul>
   *
   * <p>Method under test: {@link GeneratedResource#getHashRepresentation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GeneratedResource.getHashRepresentation()"})
  public void testGetHashRepresentation_thenReturnHashRepresentation() {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();
    generatedResource.setHashRepresentation("Hash Representation");

    // Act and Assert
    assertEquals("Hash Representation", generatedResource.getHashRepresentation());
  }

  /**
   * Test {@link GeneratedResource#getInputStream()}.
   *
   * <p>Method under test: {@link GeneratedResource#getInputStream()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream GeneratedResource.getInputStream()"})
  public void testGetInputStream() throws IOException {
    // Arrange, Act and Assert
    int actualReadResult = new GeneratedResource().getInputStream().read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GeneratedResource#setHashRepresentation(String)}
   *   <li>{@link GeneratedResource#getBytes()}
   *   <li>{@link GeneratedResource#getDescription()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] GeneratedResource.getBytes()",
    "String GeneratedResource.getDescription()",
    "void GeneratedResource.setHashRepresentation(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();

    // Act
    generatedResource.setHashRepresentation("Hash Representation");
    byte[] actualBytes = generatedResource.getBytes();

    // Assert
    assertNull(generatedResource.getDescription());
    assertArrayEquals(new byte[] {}, actualBytes);
  }

  /**
   * Test {@link GeneratedResource#equals(Object)}, and {@link GeneratedResource#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GeneratedResource#equals(Object)}
   *   <li>{@link GeneratedResource#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GeneratedResource.equals(Object)",
    "int GeneratedResource.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();
    GeneratedResource generatedResource2 = new GeneratedResource();

    // Act and Assert
    assertEquals(generatedResource, generatedResource2);
    assertEquals(generatedResource.hashCode(), generatedResource2.hashCode());
  }

  /**
   * Test {@link GeneratedResource#equals(Object)}, and {@link GeneratedResource#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GeneratedResource#equals(Object)}
   *   <li>{@link GeneratedResource#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GeneratedResource.equals(Object)",
    "int GeneratedResource.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GeneratedResource#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GeneratedResource.equals(Object)",
    "int GeneratedResource.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GeneratedResource generatedResource =
        new GeneratedResource(
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            "The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(generatedResource, new GeneratedResource());
  }

  /**
   * Test {@link GeneratedResource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GeneratedResource#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GeneratedResource.equals(Object)",
    "int GeneratedResource.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GeneratedResource(), null);
  }

  /**
   * Test {@link GeneratedResource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GeneratedResource#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GeneratedResource.equals(Object)",
    "int GeneratedResource.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GeneratedResource(), "Different type to GeneratedResource");
  }
}
