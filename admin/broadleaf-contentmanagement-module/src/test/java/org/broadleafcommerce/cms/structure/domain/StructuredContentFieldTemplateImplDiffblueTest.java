package org.broadleafcommerce.cms.structure.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StructuredContentFieldTemplateImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentFieldTemplateImpl}
   *   <li>{@link StructuredContentFieldTemplateImpl#setFieldGroupXrefs(List)}
   *   <li>{@link StructuredContentFieldTemplateImpl#setId(Long)}
   *   <li>{@link StructuredContentFieldTemplateImpl#setName(String)}
   *   <li>{@link StructuredContentFieldTemplateImpl#getFieldGroupXrefs()}
   *   <li>{@link StructuredContentFieldTemplateImpl#getId()}
   *   <li>{@link StructuredContentFieldTemplateImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentFieldTemplateImpl.<init>()",
    "List StructuredContentFieldTemplateImpl.getFieldGroupXrefs()",
    "Long StructuredContentFieldTemplateImpl.getId()",
    "String StructuredContentFieldTemplateImpl.getName()",
    "void StructuredContentFieldTemplateImpl.setFieldGroupXrefs(List)",
    "void StructuredContentFieldTemplateImpl.setId(Long)",
    "void StructuredContentFieldTemplateImpl.setName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentFieldTemplateImpl actualStructuredContentFieldTemplateImpl =
        new StructuredContentFieldTemplateImpl();
    ArrayList<StructuredContentFieldGroupXref> fieldGroupXrefs = new ArrayList<>();
    actualStructuredContentFieldTemplateImpl.setFieldGroupXrefs(fieldGroupXrefs);
    actualStructuredContentFieldTemplateImpl.setId(
        StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentFieldTemplateImpl.setName("Name");
    List<StructuredContentFieldGroupXref> actualFieldGroupXrefs =
        actualStructuredContentFieldTemplateImpl.getFieldGroupXrefs();
    Long actualId = actualStructuredContentFieldTemplateImpl.getId();

    // Assert
    assertEquals("Name", actualStructuredContentFieldTemplateImpl.getName());
    assertTrue(actualFieldGroupXrefs.isEmpty());
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(fieldGroupXrefs, actualFieldGroupXrefs);
  }
}
