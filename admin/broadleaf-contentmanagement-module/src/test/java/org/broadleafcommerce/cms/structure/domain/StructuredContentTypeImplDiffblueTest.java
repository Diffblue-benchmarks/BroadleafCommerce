package org.broadleafcommerce.cms.structure.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StructuredContentTypeImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentTypeImpl}
   *   <li>{@link StructuredContentTypeImpl#setDescription(String)}
   *   <li>{@link StructuredContentTypeImpl#setId(Long)}
   *   <li>{@link StructuredContentTypeImpl#setName(String)}
   *   <li>{@link
   *       StructuredContentTypeImpl#setStructuredContentFieldTemplate(StructuredContentFieldTemplate)}
   *   <li>{@link StructuredContentTypeImpl#getDescription()}
   *   <li>{@link StructuredContentTypeImpl#getId()}
   *   <li>{@link StructuredContentTypeImpl#getName()}
   *   <li>{@link StructuredContentTypeImpl#getStructuredContentFieldTemplate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentTypeImpl.<init>()",
    "String StructuredContentTypeImpl.getDescription()",
    "Long StructuredContentTypeImpl.getId()",
    "String StructuredContentTypeImpl.getName()",
    "StructuredContentFieldTemplate StructuredContentTypeImpl.getStructuredContentFieldTemplate()",
    "void StructuredContentTypeImpl.setDescription(String)",
    "void StructuredContentTypeImpl.setId(Long)",
    "void StructuredContentTypeImpl.setName(String)",
    "void StructuredContentTypeImpl.setStructuredContentFieldTemplate(StructuredContentFieldTemplate)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentTypeImpl actualStructuredContentTypeImpl = new StructuredContentTypeImpl();
    actualStructuredContentTypeImpl.setDescription("The characteristics of someone or something");
    actualStructuredContentTypeImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentTypeImpl.setName("Name");
    StructuredContentFieldTemplateImpl scft = new StructuredContentFieldTemplateImpl();
    actualStructuredContentTypeImpl.setStructuredContentFieldTemplate(scft);
    String actualDescription = actualStructuredContentTypeImpl.getDescription();
    Long actualId = actualStructuredContentTypeImpl.getId();
    String actualName = actualStructuredContentTypeImpl.getName();
    StructuredContentFieldTemplate actualStructuredContentFieldTemplate =
        actualStructuredContentTypeImpl.getStructuredContentFieldTemplate();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(scft, actualStructuredContentFieldTemplate);
  }
}
