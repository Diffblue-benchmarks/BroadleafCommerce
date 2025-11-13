package org.broadleafcommerce.admin.web.controller.extension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.LinkedHashSet;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.service.FormBuilderExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ParentCategorySortExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ParentCategorySortExtensionHandlerDiffblueTest {
  @MockBean(name = "blFormBuilderExtensionManager")
  private FormBuilderExtensionManager formBuilderExtensionManager;

  @Autowired private ParentCategorySortExtensionHandler parentCategorySortExtensionHandler;

  /**
   * Test {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}.
   *
   * <ul>
   *   <li>Given {@link CodeField} {@link CodeField#getName()} return {@code Name}.
   *   <li>Then calls {@link CodeField#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link ParentCategorySortExtensionHandler#modifyListGrid(String,
   * ListGrid)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ParentCategorySortExtensionHandler.modifyListGrid(String, ListGrid)"
  })
  public void testModifyListGrid_givenCodeFieldGetNameReturnName_thenCallsGetName() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.getName()).thenReturn("Name");
    doNothing().when(codeField).setName(Mockito.<String>any());
    codeField.setName("defaultCategory");

    LinkedHashSet<Field> fieldSet = new LinkedHashSet<>();
    fieldSet.add(codeField);

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getHeaderFields()).thenReturn(fieldSet);

    // Act
    ExtensionResultStatusType actualModifyListGridResult =
        parentCategorySortExtensionHandler.modifyListGrid(
            "org.broadleafcommerce.core.catalog.domain.Product", listGrid);

    // Assert
    verify(listGrid).getHeaderFields();
    verify(codeField).getName();
    verify(codeField).setName("defaultCategory");
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualModifyListGridResult);
  }

  /**
   * Test {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Name is {@code defaultCategory}.
   *   <li>Then return {@code HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link ParentCategorySortExtensionHandler#modifyListGrid(String,
   * ListGrid)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ParentCategorySortExtensionHandler.modifyListGrid(String, ListGrid)"
  })
  public void testModifyListGrid_givenFieldNameIsDefaultCategory_thenReturnHandled() {
    // Arrange
    Field field = new Field();
    field.setName("defaultCategory");

    LinkedHashSet<Field> fieldSet = new LinkedHashSet<>();
    fieldSet.add(field);

    ListGrid listGrid = mock(ListGrid.class);
    when(listGrid.getHeaderFields()).thenReturn(fieldSet);

    // Act
    ExtensionResultStatusType actualModifyListGridResult =
        parentCategorySortExtensionHandler.modifyListGrid(
            "org.broadleafcommerce.core.catalog.domain.Product", listGrid);

    // Assert
    verify(listGrid).getHeaderFields();
    assertEquals(ExtensionResultStatusType.HANDLED, actualModifyListGridResult);
  }

  /**
   * Test {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link ParentCategorySortExtensionHandler#modifyListGrid(String,
   * ListGrid)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ParentCategorySortExtensionHandler.modifyListGrid(String, ListGrid)"
  })
  public void testModifyListGrid_whenClassName_thenReturnNotHandled() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        parentCategorySortExtensionHandler.modifyListGrid("Class Name", new ListGrid()));
  }

  /**
   * Test {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}.
   *
   * <ul>
   *   <li>When {@link ListGrid} (default constructor).
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link ParentCategorySortExtensionHandler#modifyListGrid(String,
   * ListGrid)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType ParentCategorySortExtensionHandler.modifyListGrid(String, ListGrid)"
  })
  public void testModifyListGrid_whenListGrid_thenReturnNotHandled() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        parentCategorySortExtensionHandler.modifyListGrid(
            "org.broadleafcommerce.core.catalog.domain.Product", new ListGrid()));
  }
}
