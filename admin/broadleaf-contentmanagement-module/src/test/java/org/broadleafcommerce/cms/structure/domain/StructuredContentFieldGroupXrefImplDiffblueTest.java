package org.broadleafcommerce.cms.structure.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.field.domain.FieldGroupImpl;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.mockito.Mockito;

public class StructuredContentFieldGroupXrefImplDiffblueTest {
  /**
   * Test
   * {@link StructuredContentFieldGroupXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StructuredContentFieldGroupXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    StructuredContentFieldGroupXrefImpl structuredContentFieldGroupXrefImpl = new StructuredContentFieldGroupXrefImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StructuredContentFieldGroupXref> actualCreateOrRetrieveCopyInstanceResult = structuredContentFieldGroupXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link StructuredContentFieldGroupXrefImpl}
   *   <li>{@link StructuredContentFieldGroupXrefImpl#setFieldGroup(FieldGroup)}
   *   <li>{@link StructuredContentFieldGroupXrefImpl#setGroupOrder(Integer)}
   *   <li>
   * {@link StructuredContentFieldGroupXrefImpl#setTemplate(StructuredContentFieldTemplate)}
   *   <li>{@link StructuredContentFieldGroupXrefImpl#getFieldGroup()}
   *   <li>{@link StructuredContentFieldGroupXrefImpl#getGroupOrder()}
   *   <li>{@link StructuredContentFieldGroupXrefImpl#getTemplate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentFieldGroupXrefImpl actualStructuredContentFieldGroupXrefImpl = new StructuredContentFieldGroupXrefImpl();
    FieldGroupImpl fieldGroup = new FieldGroupImpl();
    actualStructuredContentFieldGroupXrefImpl.setFieldGroup(fieldGroup);
    actualStructuredContentFieldGroupXrefImpl.setGroupOrder(1);
    StructuredContentFieldTemplateImpl template = new StructuredContentFieldTemplateImpl();
    actualStructuredContentFieldGroupXrefImpl.setTemplate(template);
    FieldGroup actualFieldGroup = actualStructuredContentFieldGroupXrefImpl.getFieldGroup();
    Integer actualGroupOrder = actualStructuredContentFieldGroupXrefImpl.getGroupOrder();
    StructuredContentFieldTemplate actualTemplate = actualStructuredContentFieldGroupXrefImpl.getTemplate();

    // Assert that nothing has changed
    assertEquals(1, actualGroupOrder.intValue());
    assertSame(fieldGroup, actualFieldGroup);
    assertSame(template, actualTemplate);
  }
}
