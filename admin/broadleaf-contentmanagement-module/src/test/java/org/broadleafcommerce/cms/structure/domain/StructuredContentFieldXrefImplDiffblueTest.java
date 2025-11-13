package org.broadleafcommerce.cms.structure.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StructuredContentFieldXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentFieldXrefImpl#StructuredContentFieldXrefImpl()}
   *   <li>{@link StructuredContentFieldXrefImpl#setId(Long)}
   *   <li>{@link StructuredContentFieldXrefImpl#setKey(String)}
   *   <li>{@link StructuredContentFieldXrefImpl#setStructuredContent(StructuredContent)}
   *   <li>{@link StructuredContentFieldXrefImpl#setStrucuturedContentField(StructuredContentField)}
   *   <li>{@link StructuredContentFieldXrefImpl#getId()}
   *   <li>{@link StructuredContentFieldXrefImpl#getKey()}
   *   <li>{@link StructuredContentFieldXrefImpl#getStructuredContent()}
   *   <li>{@link StructuredContentFieldXrefImpl#getStructuredContentField()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentFieldXrefImpl.<init>()",
    "void StructuredContentFieldXrefImpl.<init>(StructuredContent, StructuredContentField, String)",
    "Long StructuredContentFieldXrefImpl.getId()",
    "String StructuredContentFieldXrefImpl.getKey()",
    "StructuredContent StructuredContentFieldXrefImpl.getStructuredContent()",
    "StructuredContentField StructuredContentFieldXrefImpl.getStructuredContentField()",
    "void StructuredContentFieldXrefImpl.setId(Long)",
    "void StructuredContentFieldXrefImpl.setKey(String)",
    "void StructuredContentFieldXrefImpl.setStructuredContent(StructuredContent)",
    "void StructuredContentFieldXrefImpl.setStrucuturedContentField(StructuredContentField)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentFieldXrefImpl actualStructuredContentFieldXrefImpl =
        new StructuredContentFieldXrefImpl();
    actualStructuredContentFieldXrefImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentFieldXrefImpl.setKey("Key");
    StructuredContentImpl sc = new StructuredContentImpl();
    actualStructuredContentFieldXrefImpl.setStructuredContent(sc);
    StructuredContentFieldImpl scField = new StructuredContentFieldImpl();
    actualStructuredContentFieldXrefImpl.setStrucuturedContentField(scField);
    Long actualId = actualStructuredContentFieldXrefImpl.getId();
    String actualKey = actualStructuredContentFieldXrefImpl.getKey();
    StructuredContent actualStructuredContent =
        actualStructuredContentFieldXrefImpl.getStructuredContent();
    StructuredContentField actualStructuredContentField =
        actualStructuredContentFieldXrefImpl.getStructuredContentField();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(scField, actualStructuredContentField);
    assertSame(sc, actualStructuredContent);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link StructuredContentImpl} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentFieldXrefImpl#StructuredContentFieldXrefImpl(StructuredContent,
   *       StructuredContentField, String)}
   *   <li>{@link StructuredContentFieldXrefImpl#setId(Long)}
   *   <li>{@link StructuredContentFieldXrefImpl#setKey(String)}
   *   <li>{@link StructuredContentFieldXrefImpl#setStructuredContent(StructuredContent)}
   *   <li>{@link StructuredContentFieldXrefImpl#setStrucuturedContentField(StructuredContentField)}
   *   <li>{@link StructuredContentFieldXrefImpl#getId()}
   *   <li>{@link StructuredContentFieldXrefImpl#getKey()}
   *   <li>{@link StructuredContentFieldXrefImpl#getStructuredContent()}
   *   <li>{@link StructuredContentFieldXrefImpl#getStructuredContentField()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentFieldXrefImpl.<init>()",
    "void StructuredContentFieldXrefImpl.<init>(StructuredContent, StructuredContentField, String)",
    "Long StructuredContentFieldXrefImpl.getId()",
    "String StructuredContentFieldXrefImpl.getKey()",
    "StructuredContent StructuredContentFieldXrefImpl.getStructuredContent()",
    "StructuredContentField StructuredContentFieldXrefImpl.getStructuredContentField()",
    "void StructuredContentFieldXrefImpl.setId(Long)",
    "void StructuredContentFieldXrefImpl.setKey(String)",
    "void StructuredContentFieldXrefImpl.setStructuredContent(StructuredContent)",
    "void StructuredContentFieldXrefImpl.setStrucuturedContentField(StructuredContentField)"
  })
  public void testGettersAndSetters_whenStructuredContentImpl() {
    // Arrange
    StructuredContentImpl sc = new StructuredContentImpl();

    // Act
    StructuredContentFieldXrefImpl actualStructuredContentFieldXrefImpl =
        new StructuredContentFieldXrefImpl(sc, new StructuredContentFieldImpl(), "Key");
    actualStructuredContentFieldXrefImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentFieldXrefImpl.setKey("Key");
    StructuredContentImpl sc2 = new StructuredContentImpl();
    actualStructuredContentFieldXrefImpl.setStructuredContent(sc2);
    StructuredContentFieldImpl scField = new StructuredContentFieldImpl();
    actualStructuredContentFieldXrefImpl.setStrucuturedContentField(scField);
    Long actualId = actualStructuredContentFieldXrefImpl.getId();
    String actualKey = actualStructuredContentFieldXrefImpl.getKey();
    StructuredContent actualStructuredContent =
        actualStructuredContentFieldXrefImpl.getStructuredContent();
    StructuredContentField actualStructuredContentField =
        actualStructuredContentFieldXrefImpl.getStructuredContentField();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(scField, actualStructuredContentField);
    assertSame(sc2, actualStructuredContent);
  }
}
