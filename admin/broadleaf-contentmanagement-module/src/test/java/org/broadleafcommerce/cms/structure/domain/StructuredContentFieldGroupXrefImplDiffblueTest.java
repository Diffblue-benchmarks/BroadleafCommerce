package org.broadleafcommerce.cms.structure.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.field.domain.FieldGroupImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StructuredContentFieldGroupXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentFieldGroupXrefImpl}
   *   <li>{@link StructuredContentFieldGroupXrefImpl#setFieldGroup(FieldGroup)}
   *   <li>{@link StructuredContentFieldGroupXrefImpl#setGroupOrder(Integer)}
   *   <li>{@link StructuredContentFieldGroupXrefImpl#setTemplate(StructuredContentFieldTemplate)}
   *   <li>{@link StructuredContentFieldGroupXrefImpl#getFieldGroup()}
   *   <li>{@link StructuredContentFieldGroupXrefImpl#getGroupOrder()}
   *   <li>{@link StructuredContentFieldGroupXrefImpl#getTemplate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentFieldGroupXrefImpl.<init>()",
    "FieldGroup StructuredContentFieldGroupXrefImpl.getFieldGroup()",
    "Integer StructuredContentFieldGroupXrefImpl.getGroupOrder()",
    "StructuredContentFieldTemplate StructuredContentFieldGroupXrefImpl.getTemplate()",
    "void StructuredContentFieldGroupXrefImpl.setFieldGroup(FieldGroup)",
    "void StructuredContentFieldGroupXrefImpl.setGroupOrder(Integer)",
    "void StructuredContentFieldGroupXrefImpl.setTemplate(StructuredContentFieldTemplate)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentFieldGroupXrefImpl actualStructuredContentFieldGroupXrefImpl =
        new StructuredContentFieldGroupXrefImpl();
    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    actualStructuredContentFieldGroupXrefImpl.setFieldGroup(fieldGroup);
    actualStructuredContentFieldGroupXrefImpl.setGroupOrder(1);
    StructuredContentFieldTemplateImpl template = new StructuredContentFieldTemplateImpl();
    actualStructuredContentFieldGroupXrefImpl.setTemplate(template);
    FieldGroup actualFieldGroup = actualStructuredContentFieldGroupXrefImpl.getFieldGroup();
    Integer actualGroupOrder = actualStructuredContentFieldGroupXrefImpl.getGroupOrder();
    StructuredContentFieldTemplate actualTemplate =
        actualStructuredContentFieldGroupXrefImpl.getTemplate();

    // Assert
    assertEquals(1, actualGroupOrder.intValue());
    assertSame(fieldGroup, actualFieldGroup);
    assertSame(template, actualTemplate);
  }
}
