package org.broadleafcommerce.cms.field.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.cms.structure.domain.StructuredContentFieldGroupXref;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FieldGroupImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldGroupImpl}
   *   <li>{@link FieldGroupImpl#setFieldDefinitions(List)}
   *   <li>{@link FieldGroupImpl#setFieldGroupXrefs(List)}
   *   <li>{@link FieldGroupImpl#setId(Long)}
   *   <li>{@link FieldGroupImpl#setInitCollapsedFlag(Boolean)}
   *   <li>{@link FieldGroupImpl#setIsMasterFieldGroup(Boolean)}
   *   <li>{@link FieldGroupImpl#setName(String)}
   *   <li>{@link FieldGroupImpl#getFieldDefinitions()}
   *   <li>{@link FieldGroupImpl#getFieldGroupXrefs()}
   *   <li>{@link FieldGroupImpl#getId()}
   *   <li>{@link FieldGroupImpl#getInitCollapsedFlag()}
   *   <li>{@link FieldGroupImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldGroupImpl.<init>()",
    "List FieldGroupImpl.getFieldDefinitions()",
    "List FieldGroupImpl.getFieldGroupXrefs()",
    "Long FieldGroupImpl.getId()",
    "Boolean FieldGroupImpl.getInitCollapsedFlag()",
    "String FieldGroupImpl.getName()",
    "void FieldGroupImpl.setFieldDefinitions(List)",
    "void FieldGroupImpl.setFieldGroupXrefs(List)",
    "void FieldGroupImpl.setId(Long)",
    "void FieldGroupImpl.setInitCollapsedFlag(Boolean)",
    "void FieldGroupImpl.setIsMasterFieldGroup(Boolean)",
    "void FieldGroupImpl.setName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldGroupImpl actualFieldGroupImpl = new FieldGroupImpl();
    ArrayList<FieldDefinition> fieldDefinitions = new ArrayList<>();
    actualFieldGroupImpl.setFieldDefinitions(fieldDefinitions);
    ArrayList<StructuredContentFieldGroupXref> fieldGroupXrefs = new ArrayList<>();
    actualFieldGroupImpl.setFieldGroupXrefs(fieldGroupXrefs);
    actualFieldGroupImpl.setId(1L);
    actualFieldGroupImpl.setInitCollapsedFlag(true);
    actualFieldGroupImpl.setIsMasterFieldGroup(true);
    actualFieldGroupImpl.setName("Name");
    List<FieldDefinition> actualFieldDefinitions = actualFieldGroupImpl.getFieldDefinitions();
    List<StructuredContentFieldGroupXref> actualFieldGroupXrefs =
        actualFieldGroupImpl.getFieldGroupXrefs();
    Long actualId = actualFieldGroupImpl.getId();
    Boolean actualInitCollapsedFlag = actualFieldGroupImpl.getInitCollapsedFlag();

    // Assert
    assertEquals("Name", actualFieldGroupImpl.getName());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualFieldDefinitions.isEmpty());
    assertTrue(actualFieldGroupXrefs.isEmpty());
    assertTrue(actualInitCollapsedFlag);
    assertSame(fieldDefinitions, actualFieldDefinitions);
    assertSame(fieldGroupXrefs, actualFieldGroupXrefs);
  }
}
