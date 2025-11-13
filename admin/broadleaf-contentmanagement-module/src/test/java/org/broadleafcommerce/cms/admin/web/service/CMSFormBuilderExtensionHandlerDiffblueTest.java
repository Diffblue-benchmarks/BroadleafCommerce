package org.broadleafcommerce.cms.admin.web.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.service.FormBuilderExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CMSFormBuilderExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CMSFormBuilderExtensionHandlerDiffblueTest {
  @Autowired private CMSFormBuilderExtensionHandler cMSFormBuilderExtensionHandler;

  @MockBean(name = "blFormBuilderExtensionManager")
  private FormBuilderExtensionManager formBuilderExtensionManager;

  /**
   * Test {@link CMSFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}.
   *
   * <p>Method under test: {@link CMSFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType CMSFormBuilderExtensionHandler.modifyDetailEntityForm(EntityForm)"
  })
  public void testModifyDetailEntityForm() {
    // Arrange
    EntityForm ef = new EntityForm();
    ef.setCeilingEntityClassname("Ceiling Entity Classname");

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        cMSFormBuilderExtensionHandler.modifyDetailEntityForm(ef));
  }

  /**
   * Test {@link CMSFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityForm#getCeilingEntityClassname()}.
   * </ul>
   *
   * <p>Method under test: {@link CMSFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType CMSFormBuilderExtensionHandler.modifyDetailEntityForm(EntityForm)"
  })
  public void testModifyDetailEntityForm_thenCallsGetCeilingEntityClassname() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    // Act
    ExtensionResultStatusType actualModifyDetailEntityFormResult =
        cMSFormBuilderExtensionHandler.modifyDetailEntityForm(ef);

    // Assert
    verify(ef).getCeilingEntityClassname();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualModifyDetailEntityFormResult);
  }
}
