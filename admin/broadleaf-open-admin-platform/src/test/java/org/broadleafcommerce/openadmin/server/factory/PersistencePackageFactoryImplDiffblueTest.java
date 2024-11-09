/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.factory;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.junit.Test;
import org.mockito.Mockito;

public class PersistencePackageFactoryImplDiffblueTest {
  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code /} is adorned.</li>
   *   <li>Then calls
   * {@link PersistencePackageRequest#getCeilingEntityClassname()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  public void testCreate_givenHashMapSlashIsAdorned_thenCallsGetCeilingEntityClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl = new PersistencePackageFactoryImpl();

    HashMap<String, PersistencePackageRequest> stringPersistencePackageRequestMap = new HashMap<>();
    stringPersistencePackageRequestMap.put("/", PersistencePackageRequest.adorned());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(request.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(stringPersistencePackageRequestMap);
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[]{new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(PersistencePackageRequest.Type.STANDARD);
    request.addAdditionalForeignKey(new ForeignKey());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> persistencePackageFactoryImpl.create(request));
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getCeilingEntityClassname();
    verify(request).getCustomCriteria();
    verify(request, atLeast(1)).getEntity();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getOperationTypesOverride();
    verify(request).getRequestingEntityName();
    verify(request, atLeast(1)).getSectionCrumbs();
    verify(request).getSectionEntityField();
    verify(request, atLeast(1)).getSecurityCeilingEntityClassname();
    verify(request).getSubRequests();
    verify(request).getType();
    verify(request).isAddOperationInspect();
    verify(request).isTreeCollection();
    verify(request).isValidateUnsubmittedProperties();
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return first element is {@link ForeignKey#ForeignKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  public void testCreate_givenHashMap_thenReturnFirstElementIsForeignKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl = new PersistencePackageFactoryImpl();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(request.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    when(request.getEntity()).thenReturn(new Entity());
    when(request.getOperationTypesOverride()).thenReturn(new OperationTypes());
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    ForeignKey foreignKey = new ForeignKey();
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[]{foreignKey});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(PersistencePackageRequest.Type.STANDARD);
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getCeilingEntityClassname();
    verify(request).getCustomCriteria();
    verify(request, atLeast(1)).getEntity();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getOperationTypesOverride();
    verify(request).getRequestingEntityName();
    verify(request, atLeast(1)).getSectionCrumbs();
    verify(request).getSectionEntityField();
    verify(request, atLeast(1)).getSecurityCeilingEntityClassname();
    verify(request).getSubRequests();
    verify(request).getType();
    verify(request).isAddOperationInspect();
    verify(request).isTreeCollection();
    verify(request).isValidateUnsubmittedProperties();
    ForeignKey[] additionalForeignKeys = actualCreateResult.getPersistencePerspective().getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    assertSame(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>Then return BottomCrumb OriginalSectionIdentifier is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  public void testCreate_thenReturnBottomCrumbOriginalSectionIdentifierIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl = new PersistencePackageFactoryImpl();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.isAddOperationInspect()).thenReturn(true);
    when(request.isTreeCollection()).thenReturn(true);
    when(request.isValidateUnsubmittedProperties()).thenReturn(true);
    when(request.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(request.getRequestingEntityName()).thenReturn("Requesting Entity Name");
    when(request.getSectionEntityField()).thenReturn("Section Entity Field");
    when(request.getSecurityCeilingEntityClassname()).thenReturn("Security Ceiling Entity Classname");
    when(request.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(request.getSubRequests()).thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(request.getEntity()).thenReturn(entity);
    OperationTypes operationTypes = new OperationTypes();
    when(request.getOperationTypesOverride()).thenReturn(operationTypes);
    when(request.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    ForeignKey foreignKey = new ForeignKey();
    when(request.getForeignKey()).thenReturn(foreignKey);
    when(request.getAdditionalForeignKeys()).thenReturn(null);
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(PersistencePackageRequest.Type.STANDARD);
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getCeilingEntityClassname();
    verify(request).getCustomCriteria();
    verify(request, atLeast(1)).getEntity();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getOperationTypesOverride();
    verify(request).getRequestingEntityName();
    verify(request, atLeast(1)).getSectionCrumbs();
    verify(request).getSectionEntityField();
    verify(request, atLeast(1)).getSecurityCeilingEntityClassname();
    verify(request).getSubRequests();
    verify(request).getType();
    verify(request).isAddOperationInspect();
    verify(request).isTreeCollection();
    verify(request).isValidateUnsubmittedProperties();
    SectionCrumb bottomCrumb = actualCreateResult.getBottomCrumb();
    assertEquals("42", bottomCrumb.getOriginalSectionIdentifier());
    assertEquals("42", bottomCrumb.getSectionId());
    assertEquals("Ceiling Entity Classname", actualCreateResult.getCeilingEntityFullyQualifiedClassname());
    assertEquals("Ceiling Entity Classname", bottomCrumb.getSectionIdentifier());
    assertEquals("Requesting Entity Name", actualCreateResult.getRequestingEntityName());
    assertEquals("Section Entity Field", actualCreateResult.getSectionEntityField());
    assertEquals("Security Ceiling Entity Classname",
        actualCreateResult.getSecurityCeilingEntityFullyQualifiedClassname());
    PersistencePerspective persistencePerspective = actualCreateResult.getPersistencePerspective();
    assertNull(persistencePerspective.getAdditionalForeignKeys());
    assertNull(actualCreateResult.getProperties());
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = actualCreateResult
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    SectionCrumb[] sectionCrumbs = actualCreateResult.getSectionCrumbs();
    assertEquals(1, sectionCrumbs.length);
    assertTrue(actualCreateResult.getPMap().isEmpty());
    assertTrue(actualCreateResult.isAddOperationInspect());
    assertTrue(actualCreateResult.isTreeCollection());
    assertSame(entity, actualCreateResult.getEntity());
    assertSame(foreignKey, persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY));
    assertSame(operationTypes, persistencePerspective.getOperationTypes());
    assertSame(bottomCrumb, actualCreateResult.getTopCrumb());
    assertSame(bottomCrumb, sectionCrumbs[0]);
    assertSame(persistencePerspectiveItems, persistencePerspective.getPersistencePerspectiveItems());
    assertArrayEquals(new String[]{"Custom Criteria"}, actualCreateResult.getCustomCriteria());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>When adorned addAdditionalForeignKey
   * {@link ForeignKey#ForeignKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  public void testCreate_whenAdornedAddAdditionalForeignKeyForeignKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl = new PersistencePackageFactoryImpl();
    PersistencePackageRequest request = PersistencePackageRequest.adorned();
    request.addAdditionalForeignKey(new ForeignKey());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> persistencePackageFactoryImpl.create(request));
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>When adorned.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  public void testCreate_whenAdorned_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl = new PersistencePackageFactoryImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> persistencePackageFactoryImpl.create(PersistencePackageRequest.adorned()));
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>When map.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  public void testCreate_whenMap_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl = new PersistencePackageFactoryImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> persistencePackageFactoryImpl.create(PersistencePackageRequest.map()));
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>When standard.</li>
   *   <li>Then return CeilingEntityFullyQualifiedClassname is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  public void testCreate_whenStandard_thenReturnCeilingEntityFullyQualifiedClassnameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl = new PersistencePackageFactoryImpl();

    // Act
    PersistencePackage actualCreateResult = persistencePackageFactoryImpl.create(PersistencePackageRequest.standard());

    // Assert
    assertNull(actualCreateResult.getCeilingEntityFullyQualifiedClassname());
    assertNull(actualCreateResult.getRequestingEntityName());
    assertNull(actualCreateResult.getSectionEntityField());
    assertNull(actualCreateResult.getSecurityCeilingEntityFullyQualifiedClassname());
    SectionCrumb bottomCrumb = actualCreateResult.getBottomCrumb();
    assertNull(bottomCrumb.getOriginalSectionIdentifier());
    assertNull(bottomCrumb.getSectionId());
    assertNull(bottomCrumb.getSectionIdentifier());
    assertNull(actualCreateResult.getEntity());
    assertEquals(0, actualCreateResult.getCustomCriteria().length);
    assertEquals(0, actualCreateResult.getSectionCrumbs().length);
    PersistencePerspective persistencePerspective = actualCreateResult.getPersistencePerspective();
    assertEquals(0, persistencePerspective.getAdditionalForeignKeys().length);
    assertFalse(actualCreateResult.isAddOperationInspect());
    assertFalse(actualCreateResult.isTreeCollection());
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = actualCreateResult
        .getPersistencePerspectiveItems();
    assertTrue(persistencePerspectiveItems.isEmpty());
    assertEquals(bottomCrumb, actualCreateResult.getTopCrumb());
    assertSame(persistencePerspectiveItems, persistencePerspective.getPersistencePerspectiveItems());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#getDefaultOperationTypes()}.
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#getDefaultOperationTypes()}
   */
  @Test
  public void testGetDefaultOperationTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    OperationTypes actualDefaultOperationTypes = (new PersistencePackageFactoryImpl()).getDefaultOperationTypes();

    // Assert
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getAddType());
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getFetchType());
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getInspectType());
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, actualDefaultOperationTypes.getUpdateType());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#getOperationTypes(OperationType)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#getOperationTypes(OperationType)}
   */
  @Test
  public void testGetOperationTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    OperationTypes actualOperationTypes = (new PersistencePackageFactoryImpl())
        .getOperationTypes(OperationType.NONDESTRUCTIVEREMOVE);

    // Assert
    assertEquals(OperationType.BASIC, actualOperationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getUpdateType());
  }
}
