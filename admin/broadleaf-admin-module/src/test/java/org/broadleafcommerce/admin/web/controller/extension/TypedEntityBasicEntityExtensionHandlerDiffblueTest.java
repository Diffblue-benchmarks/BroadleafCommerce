package org.broadleafcommerce.admin.web.controller.extension;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionHandler;
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TypedEntityBasicEntityExtensionHandler.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class TypedEntityBasicEntityExtensionHandlerDiffblueTest {
  @MockBean(name = "blAdminAbstractControllerExtensionManager")
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Autowired private TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler;

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}.
   *
   * <p>Method under test: {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String TypedEntityBasicEntityExtensionHandler.getDefaultType(Class)"
  })
  public void testGetDefaultType() {
    // Arrange
    Class<TypedEntityBasicEntityExtensionHandler> implClass =
        TypedEntityBasicEntityExtensionHandler.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getDefaultType(implClass));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String TypedEntityBasicEntityExtensionHandler.getDefaultType(Class)"
  })
  public void testGetDefaultType_whenJavaLangObject() {
    // Arrange
    Class<Object> implClass = Object.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getDefaultType(implClass));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String TypedEntityBasicEntityExtensionHandler.getDefaultType(Class)"
  })
  public void testGetDefaultType_whenNull() {
    // Arrange, Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getDefaultType(null));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}.
   *
   * <p>Method under test: {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String TypedEntityBasicEntityExtensionHandler.getTypeFieldName(Class)"
  })
  public void testGetTypeFieldName() {
    // Arrange
    Class<TypedEntityBasicEntityExtensionHandler> implClass =
        TypedEntityBasicEntityExtensionHandler.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getTypeFieldName(implClass));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String TypedEntityBasicEntityExtensionHandler.getTypeFieldName(Class)"
  })
  public void testGetTypeFieldName_whenJavaLangObject() {
    // Arrange
    Class<Object> implClass = Object.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getTypeFieldName(implClass));
  }

  /**
   * Test {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String TypedEntityBasicEntityExtensionHandler.getTypeFieldName(Class)"
  })
  public void testGetTypeFieldName_whenNull() {
    // Arrange, Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getTypeFieldName(null));
  }
}
