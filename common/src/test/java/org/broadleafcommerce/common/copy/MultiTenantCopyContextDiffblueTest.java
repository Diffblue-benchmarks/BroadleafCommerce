/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.common.web.DeployBehavior;
import org.broadleafcommerce.common.web.DeployState;
import org.broadleafcommerce.common.web.EnforceEnterpriseCollectionBehaviorState;
import org.broadleafcommerce.common.web.ValidateProductionChangesState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MultiTenantCopyContext.class, MultiTenantCopierExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MultiTenantCopyContextDiffblueTest {
  @MockBean
  private Catalog catalog;

  @MockBean
  private GenericEntityService genericEntityService;

  @Autowired
  private MultiTenantCopierExtensionManager multiTenantCopierExtensionManager;

  @Autowired
  private MultiTenantCopyContext multiTenantCopyContext;

  @MockBean
  private Site site;

  /**
   * Test
   * {@link MultiTenantCopyContext#MultiTenantCopyContext(Catalog, Catalog, Site, Site, GenericEntityService, MultiTenantCopierExtensionManager)}.
   * <p>
   * Method under test:
   * {@link MultiTenantCopyContext#MultiTenantCopyContext(Catalog, Catalog, Site, Site, GenericEntityService, MultiTenantCopierExtensionManager)}
   */
  @Test
  public void testNewMultiTenantCopyContext() {
    // Arrange and Act
    MultiTenantCopyContext actualMultiTenantCopyContext = new MultiTenantCopyContext(catalog, catalog, site, site,
        genericEntityService, multiTenantCopierExtensionManager);

    // Assert
    assertFalse(actualMultiTenantCopyContext.getForDuplicate());
    assertTrue(actualMultiTenantCopyContext.getDeferredOperations().isEmpty());
    assertTrue(actualMultiTenantCopyContext.extensionManager.getHandlers().isEmpty());
    assertTrue(actualMultiTenantCopyContext.getCopyHints().isEmpty());
    assertTrue(actualMultiTenantCopyContext.currentCloneMap.isEmpty());
    assertTrue(actualMultiTenantCopyContext.currentEquivalentMap.isEmpty());
    assertTrue(actualMultiTenantCopyContext.equivalentsMap.isEmpty());
    assertSame(catalog, actualMultiTenantCopyContext.getFromCatalog());
    assertSame(catalog, actualMultiTenantCopyContext.getToCatalog());
    assertSame(site, actualMultiTenantCopyContext.getFromSite());
    assertSame(site, actualMultiTenantCopyContext.getToSite());
  }

  /**
   * Test {@link MultiTenantCopyContext#getClonedVersion(Class, Object)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultiTenantCopyContext#getClonedVersion(Class, Object)}
   */
  @Test
  public void testGetClonedVersion_givenJavaLangObject_thenReturnNull() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    Class<Object> clazz = Object.class;

    // Act
    Object actualClonedVersion = multiTenantCopyContext.getClonedVersion(clazz,
        BroadleafRequestContext.getBroadleafRequestContext(true));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("java.lang.Object"));
    assertNull(actualClonedVersion);
  }

  /**
   * Test {@link MultiTenantCopyContext#getClonedVersion(Class, Object)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultiTenantCopyContext#getClonedVersion(Class, Object)}
   */
  @Test
  public void testGetClonedVersion_givenJavaLangObject_whenNull_field_thenReturnNull() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    Class<Object> clazz = Object.class;

    // Act
    Object actualClonedVersion = multiTenantCopyContext.getClonedVersion(clazz, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("java.lang.Object"));
    assertNull(actualClonedVersion);
  }

  /**
   * Test {@link MultiTenantCopyContext#getClonedVersion(Class, Object)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultiTenantCopyContext#getClonedVersion(Class, Object)}
   */
  @Test
  public void testGetClonedVersion_thenThrowIllegalArgumentException() {
    // Arrange
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> multiTenantCopyContext.getClonedVersion(clazz, BLCFieldUtils.NULL_FIELD));
    verify(genericEntityService).getCeilingImplClass(eq("java.lang.Object"));
  }

  /**
   * Test {@link MultiTenantCopyContext#getClonedVersion(Class, Object)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultiTenantCopyContext#getClonedVersion(Class, Object)}
   */
  @Test
  public void testGetClonedVersion_thenThrowIllegalArgumentException2() {
    // Arrange
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> multiTenantCopyContext.getClonedVersion(clazz, BroadleafRequestContext.getBroadleafRequestContext(true)));
    verify(genericEntityService).getCeilingImplClass(eq("java.lang.Object"));
  }

  /**
   * Test {@link MultiTenantCopyContext#getEquivalentId(String, Object)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultiTenantCopyContext#getEquivalentId(String, Object)}
   */
  @Test
  public void testGetEquivalentId_givenJavaLangObject_thenReturnNull() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);

    // Act
    Object actualEquivalentId = multiTenantCopyContext.getEquivalentId("Class Name", BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("Class Name"));
    assertNull(actualEquivalentId);
  }

  /**
   * Test {@link MultiTenantCopyContext#getEquivalentId(String, Object)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultiTenantCopyContext#getEquivalentId(String, Object)}
   */
  @Test
  public void testGetEquivalentId_thenThrowIllegalArgumentException() {
    // Arrange
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> multiTenantCopyContext.getEquivalentId("Class Name", BLCFieldUtils.NULL_FIELD));
    verify(genericEntityService).getCeilingImplClass(eq("Class Name"));
  }

  /**
   * Test {@link MultiTenantCopyContext#getIdentifier(Object)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopyContext#getIdentifier(Object)}
   */
  @Test
  public void testGetIdentifier_thenReturnNull() {
    // Arrange
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);

    // Act
    Long actualIdentifier = multiTenantCopyContext.getIdentifier(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(genericEntityService).getIdentifier(isA(Object.class));
    assertNull(actualIdentifier);
  }

  /**
   * Test {@link MultiTenantCopyContext#getIdentifier(Object)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopyContext#getIdentifier(Object)}
   */
  @Test
  public void testGetIdentifier_thenThrowIllegalArgumentException() {
    // Arrange
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> multiTenantCopyContext.getIdentifier(BLCFieldUtils.NULL_FIELD));
    verify(genericEntityService).getIdentifier(isA(Object.class));
  }

  /**
   * Test {@link MultiTenantCopyContext#removeOriginalIdentifier(Object)}.
   * <p>
   * Method under test:
   * {@link MultiTenantCopyContext#removeOriginalIdentifier(Object)}
   */
  @Test
  public void testRemoveOriginalIdentifier() {
    // Arrange, Act and Assert
    assertNull(multiTenantCopyContext.removeOriginalIdentifier(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link MultiTenantCopyContext#getAllFields(Class)}.
   * <p>
   * Method under test: {@link MultiTenantCopyContext#getAllFields(Class)}
   */
  @Test
  public void testGetAllFields() {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    multiTenantCopyContext.addDeferredOperation(mock(DeferredOperation.class));
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertEquals(0, multiTenantCopyContext.getAllFields(targetClass).length);
  }

  /**
   * Test {@link MultiTenantCopyContext#getAllFields(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean}.</li>
   *   <li>Then return second element Name is {@code FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopyContext#getAllFields(Class)}
   */
  @Test
  public void testGetAllFields_whenJavaLangBoolean_thenReturnSecondElementNameIsFalse() {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    Class<Boolean> targetClass = Boolean.class;

    // Act
    Field[] actualAllFields = multiTenantCopyContext.getAllFields(targetClass);

    // Assert
    Field field = actualAllFields[1];
    assertEquals("FALSE", field.getName());
    Field field2 = actualAllFields[0];
    assertEquals("TRUE", field2.getName());
    Field field3 = actualAllFields[2];
    assertEquals("TYPE", field3.getName());
    assertEquals("java.lang.Class<java.lang.Boolean>", field3.getGenericType().getTypeName());
    Field field4 = actualAllFields[3];
    assertEquals("private final boolean java.lang.Boolean.value", field4.toGenericString());
    Field field5 = actualAllFields[4];
    assertEquals("private static final long java.lang.Boolean.serialVersionUID", field5.toGenericString());
    assertEquals("public static final java.lang.Boolean java.lang.Boolean.FALSE", field.toGenericString());
    assertEquals("public static final java.lang.Boolean java.lang.Boolean.TRUE", field2.toGenericString());
    assertEquals("public static final java.lang.Class<java.lang.Boolean> java.lang.Boolean.TYPE",
        field3.toGenericString());
    assertEquals("serialVersionUID", field5.getName());
    assertEquals("value", field4.getName());
    Annotation[] annotations = field2.getAnnotations();
    assertEquals(0, annotations.length);
    assertEquals(18, field4.getModifiers());
    assertEquals(25, field2.getModifiers());
    assertEquals(25, field.getModifiers());
    assertEquals(25, field3.getModifiers());
    assertEquals(26, field5.getModifiers());
    assertEquals(5, actualAllFields.length);
    assertFalse(field2.isAccessible());
    assertFalse(field.isAccessible());
    assertFalse(field3.isAccessible());
    assertFalse(field4.isAccessible());
    assertFalse(field5.isAccessible());
    assertFalse(field2.isEnumConstant());
    assertFalse(field.isEnumConstant());
    assertFalse(field3.isEnumConstant());
    assertFalse(field4.isEnumConstant());
    assertFalse(field5.isEnumConstant());
    assertFalse(field2.isSynthetic());
    assertFalse(field.isSynthetic());
    assertFalse(field3.isSynthetic());
    assertFalse(field4.isSynthetic());
    assertFalse(field5.isSynthetic());
    Class<Boolean> expectedDeclaringClass = Boolean.class;
    assertEquals(expectedDeclaringClass, field2.getDeclaringClass());
    Class<Class> expectedType = Class.class;
    assertEquals(expectedType, field3.getType());
    assertSame(annotations, field.getAnnotations());
    assertSame(annotations, field3.getAnnotations());
    assertSame(annotations, field4.getAnnotations());
    assertSame(annotations, field5.getAnnotations());
    assertSame(annotations, field2.getDeclaredAnnotations());
    assertSame(annotations, field.getDeclaredAnnotations());
    assertSame(annotations, field3.getDeclaredAnnotations());
    assertSame(annotations, field4.getDeclaredAnnotations());
    assertSame(annotations, field5.getDeclaredAnnotations());
    assertSame(targetClass, field.getDeclaringClass());
    assertSame(targetClass, field3.getDeclaringClass());
    assertSame(targetClass, field4.getDeclaringClass());
    assertSame(targetClass, field5.getDeclaringClass());
    assertSame(targetClass, field2.getGenericType());
    assertSame(targetClass, field.getGenericType());
    assertSame(targetClass, field2.getType());
    assertSame(targetClass, field.getType());
    assertSame(field4.getGenericType(), field4.getType());
    assertSame(field5.getGenericType(), field5.getType());
  }

  /**
   * Test {@link MultiTenantCopyContext#getAllFields(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopyContext#getAllFields(Class)}
   */
  @Test
  public void testGetAllFields_whenJavaLangObject_thenReturnArrayLengthIsZero() {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertEquals(0, multiTenantCopyContext.getAllFields(targetClass).length);
  }

  /**
   * Test {@link MultiTenantCopyContext#getPreviousClone(Class, Long)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultiTenantCopyContext#getPreviousClone(Class, Long)}
   */
  @Test
  public void testGetPreviousClone_givenJavaLangObject_thenReturnNull() {
    // Arrange
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    Class<Object> instanceClass = Object.class;

    // Act
    Object actualPreviousClone = multiTenantCopyContext.getPreviousClone(instanceClass, 1L);

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("java.lang.Object"));
    assertNull(actualPreviousClone);
  }

  /**
   * Test {@link MultiTenantCopyContext#addDeferredOperation(DeferredOperation)}.
   * <p>
   * Method under test:
   * {@link MultiTenantCopyContext#addDeferredOperation(DeferredOperation)}
   */
  @Test
  public void testAddDeferredOperation() {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    DeferredOperation operation = mock(DeferredOperation.class);

    // Act
    multiTenantCopyContext.addDeferredOperation(operation);

    // Assert
    List<DeferredOperation> deferredOperations = multiTenantCopyContext.getDeferredOperations();
    assertEquals(1, deferredOperations.size());
    assertSame(operation, deferredOperations.get(0));
  }

  /**
   * Test {@link MultiTenantCopyContext#addDeferredOperations(List)}.
   * <p>
   * Method under test: {@link MultiTenantCopyContext#addDeferredOperations(List)}
   */
  @Test
  public void testAddDeferredOperations() {
    // Arrange
    ArrayList<DeferredOperation> operations = new ArrayList<>();
    operations.add(mock(DeferredOperation.class));
    operations.add(mock(DeferredOperation.class));

    // Act
    multiTenantCopyContext.addDeferredOperations(operations);

    // Assert
    assertEquals(operations, multiTenantCopyContext.getDeferredOperations());
  }

  /**
   * Test {@link MultiTenantCopyContext#addDeferredOperations(List)}.
   * <ul>
   *   <li>Then {@link MultiTenantCopyContext} DeferredOperations Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopyContext#addDeferredOperations(List)}
   */
  @Test
  public void testAddDeferredOperations_thenMultiTenantCopyContextDeferredOperationsEmpty() {
    // Arrange and Act
    multiTenantCopyContext.addDeferredOperations(new ArrayList<>());

    // Assert
    assertTrue(multiTenantCopyContext.getDeferredOperations().isEmpty());
  }

  /**
   * Test {@link MultiTenantCopyContext#addDeferredOperations(List)}.
   * <ul>
   *   <li>Then {@link MultiTenantCopyContext} DeferredOperations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopyContext#addDeferredOperations(List)}
   */
  @Test
  public void testAddDeferredOperations_thenMultiTenantCopyContextDeferredOperationsSizeIsOne() {
    // Arrange
    ArrayList<DeferredOperation> operations = new ArrayList<>();
    operations.add(mock(DeferredOperation.class));

    // Act
    multiTenantCopyContext.addDeferredOperations(operations);

    // Assert
    assertEquals(1, multiTenantCopyContext.getDeferredOperations().size());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MultiTenantCopyContext#setCopyHints(Map)}
   *   <li>{@link MultiTenantCopyContext#setForDuplicate(Boolean)}
   *   <li>{@link MultiTenantCopyContext#validateOriginal(Object)}
   *   <li>{@link MultiTenantCopyContext#getCopyHints()}
   *   <li>{@link MultiTenantCopyContext#getDeferredOperations()}
   *   <li>{@link MultiTenantCopyContext#getForDuplicate()}
   *   <li>{@link MultiTenantCopyContext#getFromCatalog()}
   *   <li>{@link MultiTenantCopyContext#getFromSite()}
   *   <li>{@link MultiTenantCopyContext#getToCatalog()}
   *   <li>{@link MultiTenantCopyContext#getToSite()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws CloneNotSupportedException {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    HashMap<String, String> copyHints = new HashMap<>();

    // Act
    multiTenantCopyContext.setCopyHints(copyHints);
    multiTenantCopyContext.setForDuplicate(true);
    multiTenantCopyContext.validateOriginal(BLCFieldUtils.NULL_FIELD);
    Map<String, String> actualCopyHints = multiTenantCopyContext.getCopyHints();
    List<DeferredOperation> actualDeferredOperations = multiTenantCopyContext.getDeferredOperations();
    Boolean actualForDuplicate = multiTenantCopyContext.getForDuplicate();
    Catalog actualFromCatalog = multiTenantCopyContext.getFromCatalog();
    Site actualFromSite = multiTenantCopyContext.getFromSite();
    Catalog actualToCatalog = multiTenantCopyContext.getToCatalog();
    Site actualToSite = multiTenantCopyContext.getToSite();

    // Assert that nothing has changed
    assertTrue(actualDeferredOperations.isEmpty());
    assertTrue(actualCopyHints.isEmpty());
    assertTrue(actualForDuplicate);
    assertSame(copyHints, actualCopyHints);
    assertSame(fromCatalog, actualFromCatalog);
    assertSame(toCatalog, actualToCatalog);
    assertSame(fromSite, actualFromSite);
    assertSame(toSite, actualToSite);
  }

  /**
   * Test {@link MultiTenantCopyContext#tearDownContext(BroadleafRequestContext)}.
   * <p>
   * Method under test:
   * {@link MultiTenantCopyContext#tearDownContext(BroadleafRequestContext)}
   */
  @Test
  public void testTearDownContext() {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    BroadleafRequestContext context = new BroadleafRequestContext();

    // Act
    multiTenantCopyContext.tearDownContext(context);

    // Assert
    assertTrue(multiTenantCopyContext.getToSite() instanceof SiteImpl);
    assertSame(fromCatalog, multiTenantCopyContext.getFromCatalog());
    assertSame(toCatalog, multiTenantCopyContext.getToCatalog());
    assertSame(fromCatalog, context.getCurrentCatalog());
    assertSame(fromSite, multiTenantCopyContext.getFromSite());
    assertSame(fromSite, context.getCurrentProfile());
    assertSame(fromSite, context.getNonPersistentSite());
    assertSame(fromSite, context.getSite());
  }

  /**
   * Test {@link MultiTenantCopyContext#tearDownContext(BroadleafRequestContext)}.
   * <p>
   * Method under test:
   * {@link MultiTenantCopyContext#tearDownContext(BroadleafRequestContext)}
   */
  @Test
  public void testTearDownContext2() {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    multiTenantCopyContext.addDeferredOperation(mock(DeferredOperation.class));
    BroadleafRequestContext context = new BroadleafRequestContext();

    // Act
    multiTenantCopyContext.tearDownContext(context);

    // Assert
    assertTrue(multiTenantCopyContext.getToSite() instanceof SiteImpl);
    assertSame(fromCatalog, multiTenantCopyContext.getFromCatalog());
    assertSame(toCatalog, multiTenantCopyContext.getToCatalog());
    assertSame(fromCatalog, context.getCurrentCatalog());
    assertSame(fromSite, multiTenantCopyContext.getFromSite());
    assertSame(fromSite, context.getCurrentProfile());
    assertSame(fromSite, context.getNonPersistentSite());
    assertSame(fromSite, context.getSite());
  }

  /**
   * Test {@link MultiTenantCopyContext#setupContext()}.
   * <p>
   * Method under test: {@link MultiTenantCopyContext#setupContext()}
   */
  @Test
  public void testSetupContext() throws MissingResourceException {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    BroadleafRequestContext actualSetupContextResult = (new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager())).setupContext();

    // Assert
    java.util.Locale javaLocale = actualSetupContextResult.getJavaLocale();
    assertEquals("", javaLocale.getDisplayScript());
    assertEquals("", javaLocale.getDisplayVariant());
    assertEquals("", javaLocale.getScript());
    assertEquals("", javaLocale.getVariant());
    Currency javaCurrency = actualSetupContextResult.getJavaCurrency();
    assertEquals("British Pound", javaCurrency.getDisplayName());
    assertEquals("English (United Kingdom)", javaLocale.getDisplayName());
    assertEquals("English", javaLocale.getDisplayLanguage());
    assertEquals("GB", javaLocale.getCountry());
    assertEquals("GBP", javaCurrency.getCurrencyCode());
    assertEquals("GBP", javaCurrency.toString());
    assertEquals("GBR", javaLocale.getISO3Country());
    assertEquals("United Kingdom", javaLocale.getDisplayCountry());
    assertEquals("£", javaCurrency.getSymbol());
    assertEquals("en", javaLocale.getLanguage());
    assertEquals("eng", javaLocale.getISO3Language());
    assertNull(actualSetupContextResult.getAdminUserId());
    assertNull(actualSetupContextResult.getSandBoxId());
    assertNull(actualSetupContextResult.getRequestURIWithoutContext());
    assertNull(actualSetupContextResult.getTimeZone());
    assertNull(actualSetupContextResult.getRequest());
    assertNull(actualSetupContextResult.getResponse());
    assertNull(actualSetupContextResult.getRequestDTO());
    assertNull(actualSetupContextResult.getBroadleafCurrency());
    assertNull(actualSetupContextResult.getRequestedBroadleafCurrency());
    assertNull(actualSetupContextResult.getLocale());
    assertNull(actualSetupContextResult.getSandBox());
    assertNull(actualSetupContextResult.getTheme());
    assertNull(actualSetupContextResult.getMessageSource());
    assertNull(actualSetupContextResult.getWebRequest());
    assertEquals(2, javaCurrency.getDefaultFractionDigits());
    assertEquals(826, javaCurrency.getNumericCode());
    assertEquals(DeployBehavior.UNDEFINED, actualSetupContextResult.getDeployBehavior());
    assertEquals(DeployState.UNDEFINED, actualSetupContextResult.getDeployState());
    assertEquals(EnforceEnterpriseCollectionBehaviorState.UNDEFINED,
        actualSetupContextResult.getEnforceEnterpriseCollectionBehaviorState());
    assertEquals(ValidateProductionChangesState.UNDEFINED,
        actualSetupContextResult.getValidateProductionChangesState());
    assertFalse(javaLocale.hasExtensions());
    assertFalse(actualSetupContextResult.getAdmin());
    assertFalse(actualSetupContextResult.getIgnoreSite());
    assertFalse(actualSetupContextResult.getInternalIgnoreFilters());
    assertFalse(actualSetupContextResult.getInternalValidateFind());
    assertTrue(actualSetupContextResult.getExplicitCatalogs().isEmpty());
    assertTrue(actualSetupContextResult.getAdditionalProperties().isEmpty());
    Set<Character> extensionKeys = javaLocale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertTrue(actualSetupContextResult.isProductionSandBox());
    assertSame(toCatalog, actualSetupContextResult.getCurrentCatalog());
    assertSame(toSite, actualSetupContextResult.getCurrentProfile());
    assertSame(toSite, actualSetupContextResult.getNonPersistentSite());
    assertSame(toSite, actualSetupContextResult.getSite());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleKeys());
  }

  /**
   * Test {@link MultiTenantCopyContext#setupContext()}.
   * <p>
   * Method under test: {@link MultiTenantCopyContext#setupContext()}
   */
  @Test
  public void testSetupContext2() throws MissingResourceException {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    multiTenantCopyContext.addDeferredOperation(mock(DeferredOperation.class));

    // Act
    BroadleafRequestContext actualSetupContextResult = multiTenantCopyContext.setupContext();

    // Assert
    java.util.Locale javaLocale = actualSetupContextResult.getJavaLocale();
    assertEquals("", javaLocale.getDisplayScript());
    assertEquals("", javaLocale.getDisplayVariant());
    assertEquals("", javaLocale.getScript());
    assertEquals("", javaLocale.getVariant());
    Currency javaCurrency = actualSetupContextResult.getJavaCurrency();
    assertEquals("British Pound", javaCurrency.getDisplayName());
    assertEquals("English (United Kingdom)", javaLocale.getDisplayName());
    assertEquals("English", javaLocale.getDisplayLanguage());
    assertEquals("GB", javaLocale.getCountry());
    assertEquals("GBP", javaCurrency.getCurrencyCode());
    assertEquals("GBP", javaCurrency.toString());
    assertEquals("GBR", javaLocale.getISO3Country());
    assertEquals("United Kingdom", javaLocale.getDisplayCountry());
    assertEquals("£", javaCurrency.getSymbol());
    assertEquals("en", javaLocale.getLanguage());
    assertEquals("eng", javaLocale.getISO3Language());
    assertNull(actualSetupContextResult.getAdminUserId());
    assertNull(actualSetupContextResult.getSandBoxId());
    assertNull(actualSetupContextResult.getRequestURIWithoutContext());
    assertNull(actualSetupContextResult.getTimeZone());
    assertNull(actualSetupContextResult.getRequest());
    assertNull(actualSetupContextResult.getResponse());
    assertNull(actualSetupContextResult.getRequestDTO());
    assertNull(actualSetupContextResult.getBroadleafCurrency());
    assertNull(actualSetupContextResult.getRequestedBroadleafCurrency());
    assertNull(actualSetupContextResult.getLocale());
    assertNull(actualSetupContextResult.getSandBox());
    assertNull(actualSetupContextResult.getTheme());
    assertNull(actualSetupContextResult.getMessageSource());
    assertNull(actualSetupContextResult.getWebRequest());
    assertEquals(2, javaCurrency.getDefaultFractionDigits());
    assertEquals(826, javaCurrency.getNumericCode());
    assertEquals(DeployBehavior.UNDEFINED, actualSetupContextResult.getDeployBehavior());
    assertEquals(DeployState.UNDEFINED, actualSetupContextResult.getDeployState());
    assertEquals(EnforceEnterpriseCollectionBehaviorState.UNDEFINED,
        actualSetupContextResult.getEnforceEnterpriseCollectionBehaviorState());
    assertEquals(ValidateProductionChangesState.UNDEFINED,
        actualSetupContextResult.getValidateProductionChangesState());
    assertFalse(javaLocale.hasExtensions());
    assertFalse(actualSetupContextResult.getAdmin());
    assertFalse(actualSetupContextResult.getIgnoreSite());
    assertFalse(actualSetupContextResult.getInternalIgnoreFilters());
    assertFalse(actualSetupContextResult.getInternalValidateFind());
    assertTrue(actualSetupContextResult.getExplicitCatalogs().isEmpty());
    assertTrue(actualSetupContextResult.getAdditionalProperties().isEmpty());
    Set<Character> extensionKeys = javaLocale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertTrue(actualSetupContextResult.isProductionSandBox());
    assertSame(toCatalog, actualSetupContextResult.getCurrentCatalog());
    assertSame(toSite, actualSetupContextResult.getCurrentProfile());
    assertSame(toSite, actualSetupContextResult.getNonPersistentSite());
    assertSame(toSite, actualSetupContextResult.getSite());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, javaLocale.getUnicodeLocaleKeys());
  }

  /**
   * Test
   * {@link MultiTenantCopyContext#handleStandardEntity(Object, BroadleafRequestContext, Class)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultiTenantCopyContext#handleStandardEntity(Object, BroadleafRequestContext, Class)}
   */
  @Test
  public void testHandleStandardEntity_thenThrowIllegalArgumentException() throws CloneNotSupportedException {
    // Arrange
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenThrow(new IllegalArgumentException("_"));
    BroadleafRequestContext context = new BroadleafRequestContext();
    Class<Object> instanceClass = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> multiTenantCopyContext.handleStandardEntity(BLCFieldUtils.NULL_FIELD, context, instanceClass));
    verify(genericEntityService).getIdentifier(isA(Object.class));
  }

  /**
   * Test {@link MultiTenantCopyContext#handleEmbedded(Class)}.
   * <p>
   * Method under test: {@link MultiTenantCopyContext#handleEmbedded(Class)}
   */
  @Test
  public void testHandleEmbedded() {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    multiTenantCopyContext.addDeferredOperation(mock(DeferredOperation.class));
    Class<Object> instanceClass = Object.class;

    // Act and Assert
    assertNull(multiTenantCopyContext.handleEmbedded(instanceClass));
  }

  /**
   * Test {@link MultiTenantCopyContext#handleEmbedded(Class)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopyContext#handleEmbedded(Class)}
   */
  @Test
  public void testHandleEmbedded_thenReturnNull() {
    // Arrange
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    Class<Object> instanceClass = Object.class;

    // Act and Assert
    assertNull(multiTenantCopyContext.handleEmbedded(instanceClass));
  }
}
