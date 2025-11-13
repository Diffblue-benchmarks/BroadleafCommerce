package org.broadleafcommerce.cms.file.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StaticAssetImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StaticAssetImpl}
   *   <li>{@link StaticAssetImpl#setAltText(String)}
   *   <li>{@link StaticAssetImpl#setContentMessageValues(Map)}
   *   <li>{@link StaticAssetImpl#setFileExtension(String)}
   *   <li>{@link StaticAssetImpl#setFileSize(Long)}
   *   <li>{@link StaticAssetImpl#setFullUrl(String)}
   *   <li>{@link StaticAssetImpl#setId(Long)}
   *   <li>{@link StaticAssetImpl#setMimeType(String)}
   *   <li>{@link StaticAssetImpl#setName(String)}
   *   <li>{@link StaticAssetImpl#setTitle(String)}
   *   <li>{@link StaticAssetImpl#getContentMessageValues()}
   *   <li>{@link StaticAssetImpl#getFileExtension()}
   *   <li>{@link StaticAssetImpl#getFileSize()}
   *   <li>{@link StaticAssetImpl#getFullUrl()}
   *   <li>{@link StaticAssetImpl#getId()}
   *   <li>{@link StaticAssetImpl#getMimeType()}
   *   <li>{@link StaticAssetImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetImpl.<init>()",
    "Map StaticAssetImpl.getContentMessageValues()",
    "String StaticAssetImpl.getFileExtension()",
    "Long StaticAssetImpl.getFileSize()",
    "String StaticAssetImpl.getFullUrl()",
    "Long StaticAssetImpl.getId()",
    "String StaticAssetImpl.getMimeType()",
    "String StaticAssetImpl.getName()",
    "void StaticAssetImpl.setAltText(String)",
    "void StaticAssetImpl.setContentMessageValues(Map)",
    "void StaticAssetImpl.setFileExtension(String)",
    "void StaticAssetImpl.setFileSize(Long)",
    "void StaticAssetImpl.setFullUrl(String)",
    "void StaticAssetImpl.setId(Long)",
    "void StaticAssetImpl.setMimeType(String)",
    "void StaticAssetImpl.setName(String)",
    "void StaticAssetImpl.setTitle(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StaticAssetImpl actualStaticAssetImpl = new StaticAssetImpl();
    actualStaticAssetImpl.setAltText("Alt Text");
    HashMap<String, StaticAssetDescription> contentMessageValues = new HashMap<>();
    actualStaticAssetImpl.setContentMessageValues(contentMessageValues);
    actualStaticAssetImpl.setFileExtension("File Extension");
    actualStaticAssetImpl.setFileSize(3L);
    actualStaticAssetImpl.setFullUrl("https://example.org/example");
    actualStaticAssetImpl.setId(1L);
    actualStaticAssetImpl.setMimeType("text/plain");
    actualStaticAssetImpl.setName("Name");
    actualStaticAssetImpl.setTitle("Dr");
    Map<String, StaticAssetDescription> actualContentMessageValues =
        actualStaticAssetImpl.getContentMessageValues();
    String actualFileExtension = actualStaticAssetImpl.getFileExtension();
    Long actualFileSize = actualStaticAssetImpl.getFileSize();
    String actualFullUrl = actualStaticAssetImpl.getFullUrl();
    Long actualId = actualStaticAssetImpl.getId();
    String actualMimeType = actualStaticAssetImpl.getMimeType();

    // Assert
    assertEquals("File Extension", actualFileExtension);
    assertEquals("Name", actualStaticAssetImpl.getName());
    assertEquals("https://example.org/example", actualFullUrl);
    assertEquals("text/plain", actualMimeType);
    assertEquals(1L, actualId.longValue());
    assertEquals(3L, actualFileSize.longValue());
    assertTrue(actualContentMessageValues.isEmpty());
    assertSame(contentMessageValues, actualContentMessageValues);
  }
}
