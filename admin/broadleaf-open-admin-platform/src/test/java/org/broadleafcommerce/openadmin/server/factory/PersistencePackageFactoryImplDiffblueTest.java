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
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MapStructure;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PersistencePackageFactoryImplDiffblueTest {
  @Autowired
  private PersistencePackageFactoryImpl persistencePackageFactoryImpl;

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.factory;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.factory.PersistencePackageFactoryImpl persistencePackageFactoryImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl2 = new PersistencePackageFactoryImpl();

    // Act
    persistencePackageFactoryImpl2.create(PersistencePackageRequest.adorned());
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>Given {@link AdornedTargetList#AdornedTargetList()}.</li>
   *   <li>Then calls {@link PersistencePackageRequest#getAdornedList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  public void testCreate_givenAdornedTargetList_thenCallsGetAdornedList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl = new PersistencePackageFactoryImpl();
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getAdornedList()).thenReturn(new AdornedTargetList());
    when(request.getOperationTypesOverride()).thenThrow(new RuntimeException("foo"));
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[]{new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(PersistencePackageRequest.Type.ADORNED);
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getAdornedList();
    verify(request, atLeast(1)).getForeignKey();
    verify(request).getOperationTypesOverride();
    verify(request).getType();
  }

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
   *   <li>Given {@link MapStructure#MapStructure()}.</li>
   *   <li>Then calls {@link PersistencePackageRequest#getMapStructure()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  public void testCreate_givenMapStructure_thenCallsGetMapStructure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl = new PersistencePackageFactoryImpl();
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getMapStructure()).thenReturn(new MapStructure());
    when(request.getOperationTypesOverride()).thenThrow(new RuntimeException("foo"));
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[]{new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(PersistencePackageRequest.Type.MAP);
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getForeignKey();
    verify(request, atLeast(1)).getMapStructure();
    verify(request).getOperationTypesOverride();
    verify(request).getType();
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#create(PersistencePackageRequest)}
   */
  @Test
  public void testCreate_givenRuntimeExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackageFactoryImpl persistencePackageFactoryImpl = new PersistencePackageFactoryImpl();
    PersistencePackageRequest request = mock(PersistencePackageRequest.class);
    when(request.getOperationTypesOverride()).thenThrow(new RuntimeException("foo"));
    when(request.getForeignKey()).thenReturn(new ForeignKey());
    when(request.getAdditionalForeignKeys()).thenReturn(new ForeignKey[]{new ForeignKey()});
    when(request.addAdditionalForeignKey(Mockito.<ForeignKey>any())).thenReturn(PersistencePackageRequest.adorned());
    when(request.getType()).thenReturn(PersistencePackageRequest.Type.STANDARD);
    request.addAdditionalForeignKey(new ForeignKey());

    // Act
    persistencePackageFactoryImpl.create(request);

    // Assert
    verify(request).addAdditionalForeignKey(isA(ForeignKey.class));
    verify(request).getAdditionalForeignKeys();
    verify(request, atLeast(1)).getForeignKey();
    verify(request).getOperationTypesOverride();
    verify(request).getType();
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
   * Test {@link PersistencePackageFactoryImpl#getDefaultOperationTypes()}.
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#getDefaultOperationTypes()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultOperationTypes2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.factory;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass60 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.factory.PersistencePackageFactoryImpl persistencePackageFactoryImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PersistencePackageFactoryImpl()).getDefaultOperationTypes();
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

  /**
   * Test {@link PersistencePackageFactoryImpl#getOperationTypes(OperationType)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#getOperationTypes(OperationType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOperationTypes2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.factory;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass76 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.factory.PersistencePackageFactoryImpl persistencePackageFactoryImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PersistencePackageFactoryImpl()).getOperationTypes(OperationType.NONDESTRUCTIVEREMOVE);
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#getClassNameForSection(String)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#getClassNameForSection(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetClassNameForSection() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.factory;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass45 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.factory.PersistencePackageFactoryImpl persistencePackageFactoryImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PersistencePackageFactoryImpl()).getClassNameForSection("Section Key");
  }

  /**
   * Test {@link PersistencePackageFactoryImpl#getEntityManager(String)}.
   * <p>
   * Method under test:
   * {@link PersistencePackageFactoryImpl#getEntityManager(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetEntityManager() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.factory;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass61 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.factory.PersistencePackageFactoryImpl persistencePackageFactoryImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PersistencePackageFactoryImpl()).getEntityManager("Class Name");
  }
}
