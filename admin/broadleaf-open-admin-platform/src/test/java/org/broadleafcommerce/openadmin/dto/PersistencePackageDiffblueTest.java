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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.service.type.ChangeType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PersistencePackage.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PersistencePackageDiffblueTest {
  @Autowired
  private PersistencePackage persistencePackage;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersistencePackage#PersistencePackage()}
   *   <li>{@link PersistencePackage#setAddOperationInspect(boolean)}
   *   <li>
   * {@link PersistencePackage#setCeilingEntityFullyQualifiedClassname(String)}
   *   <li>{@link PersistencePackage#setCsrfToken(String)}
   *   <li>{@link PersistencePackage#setCustomCriteria(String[])}
   *   <li>{@link PersistencePackage#setDeferredOperations(Map)}
   *   <li>{@link PersistencePackage#setEntity(Entity)}
   *   <li>{@link PersistencePackage#setFetchTypeFullyQualifiedClassname(String)}
   *   <li>{@link PersistencePackage#setIsTreeCollection(boolean)}
   *   <li>
   * {@link PersistencePackage#setPersistencePerspective(PersistencePerspective)}
   *   <li>{@link PersistencePackage#setProcessedInternal(boolean)}
   *   <li>{@link PersistencePackage#setRequestingEntityName(String)}
   *   <li>{@link PersistencePackage#setSectionCrumbs(SectionCrumb[])}
   *   <li>{@link PersistencePackage#setSectionEntityField(String)}
   *   <li>
   * {@link PersistencePackage#setSecurityCeilingEntityFullyQualifiedClassname(String)}
   *   <li>{@link PersistencePackage#setSubPackages(Map)}
   *   <li>{@link PersistencePackage#setValidateUnsubmittedProperties(boolean)}
   *   <li>{@link PersistencePackage#toString()}
   *   <li>{@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}
   *   <li>{@link PersistencePackage#getCsrfToken()}
   *   <li>{@link PersistencePackage#getCustomCriteria()}
   *   <li>{@link PersistencePackage#getDeferredOperations()}
   *   <li>{@link PersistencePackage#getEntity()}
   *   <li>{@link PersistencePackage#getFetchTypeFullyQualifiedClassname()}
   *   <li>{@link PersistencePackage#getPersistencePerspective()}
   *   <li>{@link PersistencePackage#getRequestingEntityName()}
   *   <li>{@link PersistencePackage#getSectionCrumbs()}
   *   <li>{@link PersistencePackage#getSectionEntityField()}
   *   <li>{@link PersistencePackage#getSubPackages()}
   *   <li>{@link PersistencePackage#isAddOperationInspect()}
   *   <li>{@link PersistencePackage#isProcessedInternal()}
   *   <li>{@link PersistencePackage#isTreeCollection()}
   *   <li>{@link PersistencePackage#isValidateUnsubmittedProperties()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PersistencePackage actualPersistencePackage = new PersistencePackage();
    actualPersistencePackage.setAddOperationInspect(true);
    actualPersistencePackage.setCeilingEntityFullyQualifiedClassname("Dr Jane Doe");
    actualPersistencePackage.setCsrfToken("ABC123");
    String[] customCriteria = new String[]{"Custom Criteria"};
    actualPersistencePackage.setCustomCriteria(customCriteria);
    HashMap<ChangeType, List<PersistencePackage>> deferredOperations = new HashMap<>();
    actualPersistencePackage.setDeferredOperations(deferredOperations);
    Entity entity = new Entity();
    actualPersistencePackage.setEntity(entity);
    actualPersistencePackage.setFetchTypeFullyQualifiedClassname("Dr Jane Doe");
    actualPersistencePackage.setIsTreeCollection(true);
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    actualPersistencePackage.setPersistencePerspective(persistencePerspective);
    actualPersistencePackage.setProcessedInternal(true);
    actualPersistencePackage.setRequestingEntityName("Requesting Entity Name");
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    SectionCrumb[] sectionCrumbs = new SectionCrumb[]{sectionCrumb};
    actualPersistencePackage.setSectionCrumbs(sectionCrumbs);
    actualPersistencePackage.setSectionEntityField("Section Entity Field");
    actualPersistencePackage.setSecurityCeilingEntityFullyQualifiedClassname("Dr Jane Doe");
    HashMap<String, PersistencePackage> subPackages = new HashMap<>();
    actualPersistencePackage.setSubPackages(subPackages);
    actualPersistencePackage.setValidateUnsubmittedProperties(true);
    String actualToStringResult = actualPersistencePackage.toString();
    String actualCeilingEntityFullyQualifiedClassname = actualPersistencePackage
        .getCeilingEntityFullyQualifiedClassname();
    String actualCsrfToken = actualPersistencePackage.getCsrfToken();
    String[] actualCustomCriteria = actualPersistencePackage.getCustomCriteria();
    Map<ChangeType, List<PersistencePackage>> actualDeferredOperations = actualPersistencePackage
        .getDeferredOperations();
    Entity actualEntity = actualPersistencePackage.getEntity();
    String actualFetchTypeFullyQualifiedClassname = actualPersistencePackage.getFetchTypeFullyQualifiedClassname();
    PersistencePerspective actualPersistencePerspective = actualPersistencePackage.getPersistencePerspective();
    String actualRequestingEntityName = actualPersistencePackage.getRequestingEntityName();
    SectionCrumb[] actualSectionCrumbs = actualPersistencePackage.getSectionCrumbs();
    String actualSectionEntityField = actualPersistencePackage.getSectionEntityField();
    Map<String, PersistencePackage> actualSubPackages = actualPersistencePackage.getSubPackages();
    boolean actualIsAddOperationInspectResult = actualPersistencePackage.isAddOperationInspect();
    boolean actualIsProcessedInternalResult = actualPersistencePackage.isProcessedInternal();
    boolean actualIsTreeCollectionResult = actualPersistencePackage.isTreeCollection();
    boolean actualIsValidateUnsubmittedPropertiesResult = actualPersistencePackage.isValidateUnsubmittedProperties();

    // Assert that nothing has changed
    assertEquals("ABC123", actualCsrfToken);
    assertEquals("Dr Jane Doe", actualCeilingEntityFullyQualifiedClassname);
    assertEquals("Dr Jane Doe", actualFetchTypeFullyQualifiedClassname);
    assertEquals("PersistencePackage{ceilingEntityFullyQualifiedClassname='Dr Jane Doe', securityCeilingEntityFullyQua"
        + "lifiedClassname='Dr Jane Doe', sectionEntityField='Section Entity Field', fetchTypeFullyQualifiedClassname"
        + "='Dr Jane Doe', persistencePerspective=PersistencePerspective{persistencePerspectiveItems={},"
        + " configurationKey='null'}, customCriteria=[Custom Criteria], entity=Entity{isValidationFailure=false,"
        + " isDirty=false, properties=null, type=null}, csrfToken='ABC123', requestingEntityName='Requesting"
        + " Entity Name', subPackages={}, validateUnsubmittedProperties=true, sectionCrumbs=[SectionCrumb"
        + "{sectionIdentifier='42', sectionId='42'}]}", actualToStringResult);
    assertEquals("Requesting Entity Name", actualRequestingEntityName);
    assertEquals("Section Entity Field", actualSectionEntityField);
    assertTrue(actualDeferredOperations.isEmpty());
    assertTrue(actualSubPackages.isEmpty());
    assertTrue(actualIsAddOperationInspectResult);
    assertTrue(actualIsProcessedInternalResult);
    assertTrue(actualIsTreeCollectionResult);
    assertTrue(actualIsValidateUnsubmittedPropertiesResult);
    assertSame(deferredOperations, actualDeferredOperations);
    assertSame(subPackages, actualSubPackages);
    assertSame(entity, actualEntity);
    assertSame(persistencePerspective, actualPersistencePerspective);
    assertSame(customCriteria, actualCustomCriteria);
    assertSame(sectionCrumbs, actualSectionCrumbs);
    assertArrayEquals(new String[]{"Custom Criteria"}, actualCustomCriteria);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PersistencePackage#PersistencePackage(String, String, Entity, PersistencePerspective, String[], String)}
   *   <li>{@link PersistencePackage#setAddOperationInspect(boolean)}
   *   <li>
   * {@link PersistencePackage#setCeilingEntityFullyQualifiedClassname(String)}
   *   <li>{@link PersistencePackage#setCsrfToken(String)}
   *   <li>{@link PersistencePackage#setCustomCriteria(String[])}
   *   <li>{@link PersistencePackage#setDeferredOperations(Map)}
   *   <li>{@link PersistencePackage#setEntity(Entity)}
   *   <li>{@link PersistencePackage#setFetchTypeFullyQualifiedClassname(String)}
   *   <li>{@link PersistencePackage#setIsTreeCollection(boolean)}
   *   <li>
   * {@link PersistencePackage#setPersistencePerspective(PersistencePerspective)}
   *   <li>{@link PersistencePackage#setProcessedInternal(boolean)}
   *   <li>{@link PersistencePackage#setRequestingEntityName(String)}
   *   <li>{@link PersistencePackage#setSectionCrumbs(SectionCrumb[])}
   *   <li>{@link PersistencePackage#setSectionEntityField(String)}
   *   <li>
   * {@link PersistencePackage#setSecurityCeilingEntityFullyQualifiedClassname(String)}
   *   <li>{@link PersistencePackage#setSubPackages(Map)}
   *   <li>{@link PersistencePackage#setValidateUnsubmittedProperties(boolean)}
   *   <li>{@link PersistencePackage#toString()}
   *   <li>{@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}
   *   <li>{@link PersistencePackage#getCsrfToken()}
   *   <li>{@link PersistencePackage#getCustomCriteria()}
   *   <li>{@link PersistencePackage#getDeferredOperations()}
   *   <li>{@link PersistencePackage#getEntity()}
   *   <li>{@link PersistencePackage#getFetchTypeFullyQualifiedClassname()}
   *   <li>{@link PersistencePackage#getPersistencePerspective()}
   *   <li>{@link PersistencePackage#getRequestingEntityName()}
   *   <li>{@link PersistencePackage#getSectionCrumbs()}
   *   <li>{@link PersistencePackage#getSectionEntityField()}
   *   <li>{@link PersistencePackage#getSubPackages()}
   *   <li>{@link PersistencePackage#isAddOperationInspect()}
   *   <li>{@link PersistencePackage#isProcessedInternal()}
   *   <li>{@link PersistencePackage#isTreeCollection()}
   *   <li>{@link PersistencePackage#isValidateUnsubmittedProperties()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenDrJaneDoe() {
    // Arrange
    Entity entity = new Entity();

    // Act
    PersistencePackage actualPersistencePackage = new PersistencePackage("Dr Jane Doe", "Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123");
    actualPersistencePackage.setAddOperationInspect(true);
    actualPersistencePackage.setCeilingEntityFullyQualifiedClassname("Dr Jane Doe");
    actualPersistencePackage.setCsrfToken("ABC123");
    String[] customCriteria = new String[]{"Custom Criteria"};
    actualPersistencePackage.setCustomCriteria(customCriteria);
    HashMap<ChangeType, List<PersistencePackage>> deferredOperations = new HashMap<>();
    actualPersistencePackage.setDeferredOperations(deferredOperations);
    Entity entity2 = new Entity();
    actualPersistencePackage.setEntity(entity2);
    actualPersistencePackage.setFetchTypeFullyQualifiedClassname("Dr Jane Doe");
    actualPersistencePackage.setIsTreeCollection(true);
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    actualPersistencePackage.setPersistencePerspective(persistencePerspective);
    actualPersistencePackage.setProcessedInternal(true);
    actualPersistencePackage.setRequestingEntityName("Requesting Entity Name");
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    SectionCrumb[] sectionCrumbs = new SectionCrumb[]{sectionCrumb};
    actualPersistencePackage.setSectionCrumbs(sectionCrumbs);
    actualPersistencePackage.setSectionEntityField("Section Entity Field");
    actualPersistencePackage.setSecurityCeilingEntityFullyQualifiedClassname("Dr Jane Doe");
    HashMap<String, PersistencePackage> subPackages = new HashMap<>();
    actualPersistencePackage.setSubPackages(subPackages);
    actualPersistencePackage.setValidateUnsubmittedProperties(true);
    String actualToStringResult = actualPersistencePackage.toString();
    String actualCeilingEntityFullyQualifiedClassname = actualPersistencePackage
        .getCeilingEntityFullyQualifiedClassname();
    String actualCsrfToken = actualPersistencePackage.getCsrfToken();
    String[] actualCustomCriteria = actualPersistencePackage.getCustomCriteria();
    Map<ChangeType, List<PersistencePackage>> actualDeferredOperations = actualPersistencePackage
        .getDeferredOperations();
    Entity actualEntity = actualPersistencePackage.getEntity();
    String actualFetchTypeFullyQualifiedClassname = actualPersistencePackage.getFetchTypeFullyQualifiedClassname();
    PersistencePerspective actualPersistencePerspective = actualPersistencePackage.getPersistencePerspective();
    String actualRequestingEntityName = actualPersistencePackage.getRequestingEntityName();
    SectionCrumb[] actualSectionCrumbs = actualPersistencePackage.getSectionCrumbs();
    String actualSectionEntityField = actualPersistencePackage.getSectionEntityField();
    Map<String, PersistencePackage> actualSubPackages = actualPersistencePackage.getSubPackages();
    boolean actualIsAddOperationInspectResult = actualPersistencePackage.isAddOperationInspect();
    boolean actualIsProcessedInternalResult = actualPersistencePackage.isProcessedInternal();
    boolean actualIsTreeCollectionResult = actualPersistencePackage.isTreeCollection();
    boolean actualIsValidateUnsubmittedPropertiesResult = actualPersistencePackage.isValidateUnsubmittedProperties();

    // Assert that nothing has changed
    assertEquals("ABC123", actualCsrfToken);
    assertEquals("Dr Jane Doe", actualCeilingEntityFullyQualifiedClassname);
    assertEquals("Dr Jane Doe", actualFetchTypeFullyQualifiedClassname);
    assertEquals("PersistencePackage{ceilingEntityFullyQualifiedClassname='Dr Jane Doe', securityCeilingEntityFullyQua"
        + "lifiedClassname='Dr Jane Doe', sectionEntityField='Section Entity Field', fetchTypeFullyQualifiedClassname"
        + "='Dr Jane Doe', persistencePerspective=PersistencePerspective{persistencePerspectiveItems={},"
        + " configurationKey='null'}, customCriteria=[Custom Criteria], entity=Entity{isValidationFailure=false,"
        + " isDirty=false, properties=null, type=null}, csrfToken='ABC123', requestingEntityName='Requesting"
        + " Entity Name', subPackages={}, validateUnsubmittedProperties=true, sectionCrumbs=[SectionCrumb"
        + "{sectionIdentifier='42', sectionId='42'}]}", actualToStringResult);
    assertEquals("Requesting Entity Name", actualRequestingEntityName);
    assertEquals("Section Entity Field", actualSectionEntityField);
    assertTrue(actualDeferredOperations.isEmpty());
    assertTrue(actualSubPackages.isEmpty());
    assertTrue(actualIsAddOperationInspectResult);
    assertTrue(actualIsProcessedInternalResult);
    assertTrue(actualIsTreeCollectionResult);
    assertTrue(actualIsValidateUnsubmittedPropertiesResult);
    assertSame(deferredOperations, actualDeferredOperations);
    assertSame(subPackages, actualSubPackages);
    assertSame(entity2, actualEntity);
    assertSame(persistencePerspective, actualPersistencePerspective);
    assertSame(customCriteria, actualCustomCriteria);
    assertSame(sectionCrumbs, actualSectionCrumbs);
    assertArrayEquals(new String[]{"Custom Criteria"}, actualCustomCriteria);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PersistencePackage#PersistencePackage(String, Entity, PersistencePerspective, String[], String)}
   *   <li>{@link PersistencePackage#setAddOperationInspect(boolean)}
   *   <li>
   * {@link PersistencePackage#setCeilingEntityFullyQualifiedClassname(String)}
   *   <li>{@link PersistencePackage#setCsrfToken(String)}
   *   <li>{@link PersistencePackage#setCustomCriteria(String[])}
   *   <li>{@link PersistencePackage#setDeferredOperations(Map)}
   *   <li>{@link PersistencePackage#setEntity(Entity)}
   *   <li>{@link PersistencePackage#setFetchTypeFullyQualifiedClassname(String)}
   *   <li>{@link PersistencePackage#setIsTreeCollection(boolean)}
   *   <li>
   * {@link PersistencePackage#setPersistencePerspective(PersistencePerspective)}
   *   <li>{@link PersistencePackage#setProcessedInternal(boolean)}
   *   <li>{@link PersistencePackage#setRequestingEntityName(String)}
   *   <li>{@link PersistencePackage#setSectionCrumbs(SectionCrumb[])}
   *   <li>{@link PersistencePackage#setSectionEntityField(String)}
   *   <li>
   * {@link PersistencePackage#setSecurityCeilingEntityFullyQualifiedClassname(String)}
   *   <li>{@link PersistencePackage#setSubPackages(Map)}
   *   <li>{@link PersistencePackage#setValidateUnsubmittedProperties(boolean)}
   *   <li>{@link PersistencePackage#toString()}
   *   <li>{@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}
   *   <li>{@link PersistencePackage#getCsrfToken()}
   *   <li>{@link PersistencePackage#getCustomCriteria()}
   *   <li>{@link PersistencePackage#getDeferredOperations()}
   *   <li>{@link PersistencePackage#getEntity()}
   *   <li>{@link PersistencePackage#getFetchTypeFullyQualifiedClassname()}
   *   <li>{@link PersistencePackage#getPersistencePerspective()}
   *   <li>{@link PersistencePackage#getRequestingEntityName()}
   *   <li>{@link PersistencePackage#getSectionCrumbs()}
   *   <li>{@link PersistencePackage#getSectionEntityField()}
   *   <li>{@link PersistencePackage#getSubPackages()}
   *   <li>{@link PersistencePackage#isAddOperationInspect()}
   *   <li>{@link PersistencePackage#isProcessedInternal()}
   *   <li>{@link PersistencePackage#isTreeCollection()}
   *   <li>{@link PersistencePackage#isValidateUnsubmittedProperties()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenDrJaneDoe2() {
    // Arrange
    Entity entity = new Entity();

    // Act
    PersistencePackage actualPersistencePackage = new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123");
    actualPersistencePackage.setAddOperationInspect(true);
    actualPersistencePackage.setCeilingEntityFullyQualifiedClassname("Dr Jane Doe");
    actualPersistencePackage.setCsrfToken("ABC123");
    String[] customCriteria = new String[]{"Custom Criteria"};
    actualPersistencePackage.setCustomCriteria(customCriteria);
    HashMap<ChangeType, List<PersistencePackage>> deferredOperations = new HashMap<>();
    actualPersistencePackage.setDeferredOperations(deferredOperations);
    Entity entity2 = new Entity();
    actualPersistencePackage.setEntity(entity2);
    actualPersistencePackage.setFetchTypeFullyQualifiedClassname("Dr Jane Doe");
    actualPersistencePackage.setIsTreeCollection(true);
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    actualPersistencePackage.setPersistencePerspective(persistencePerspective);
    actualPersistencePackage.setProcessedInternal(true);
    actualPersistencePackage.setRequestingEntityName("Requesting Entity Name");
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    SectionCrumb[] sectionCrumbs = new SectionCrumb[]{sectionCrumb};
    actualPersistencePackage.setSectionCrumbs(sectionCrumbs);
    actualPersistencePackage.setSectionEntityField("Section Entity Field");
    actualPersistencePackage.setSecurityCeilingEntityFullyQualifiedClassname("Dr Jane Doe");
    HashMap<String, PersistencePackage> subPackages = new HashMap<>();
    actualPersistencePackage.setSubPackages(subPackages);
    actualPersistencePackage.setValidateUnsubmittedProperties(true);
    String actualToStringResult = actualPersistencePackage.toString();
    String actualCeilingEntityFullyQualifiedClassname = actualPersistencePackage
        .getCeilingEntityFullyQualifiedClassname();
    String actualCsrfToken = actualPersistencePackage.getCsrfToken();
    String[] actualCustomCriteria = actualPersistencePackage.getCustomCriteria();
    Map<ChangeType, List<PersistencePackage>> actualDeferredOperations = actualPersistencePackage
        .getDeferredOperations();
    Entity actualEntity = actualPersistencePackage.getEntity();
    String actualFetchTypeFullyQualifiedClassname = actualPersistencePackage.getFetchTypeFullyQualifiedClassname();
    PersistencePerspective actualPersistencePerspective = actualPersistencePackage.getPersistencePerspective();
    String actualRequestingEntityName = actualPersistencePackage.getRequestingEntityName();
    SectionCrumb[] actualSectionCrumbs = actualPersistencePackage.getSectionCrumbs();
    String actualSectionEntityField = actualPersistencePackage.getSectionEntityField();
    Map<String, PersistencePackage> actualSubPackages = actualPersistencePackage.getSubPackages();
    boolean actualIsAddOperationInspectResult = actualPersistencePackage.isAddOperationInspect();
    boolean actualIsProcessedInternalResult = actualPersistencePackage.isProcessedInternal();
    boolean actualIsTreeCollectionResult = actualPersistencePackage.isTreeCollection();
    boolean actualIsValidateUnsubmittedPropertiesResult = actualPersistencePackage.isValidateUnsubmittedProperties();

    // Assert that nothing has changed
    assertEquals("ABC123", actualCsrfToken);
    assertEquals("Dr Jane Doe", actualCeilingEntityFullyQualifiedClassname);
    assertEquals("Dr Jane Doe", actualFetchTypeFullyQualifiedClassname);
    assertEquals("PersistencePackage{ceilingEntityFullyQualifiedClassname='Dr Jane Doe', securityCeilingEntityFullyQua"
        + "lifiedClassname='Dr Jane Doe', sectionEntityField='Section Entity Field', fetchTypeFullyQualifiedClassname"
        + "='Dr Jane Doe', persistencePerspective=PersistencePerspective{persistencePerspectiveItems={},"
        + " configurationKey='null'}, customCriteria=[Custom Criteria], entity=Entity{isValidationFailure=false,"
        + " isDirty=false, properties=null, type=null}, csrfToken='ABC123', requestingEntityName='Requesting"
        + " Entity Name', subPackages={}, validateUnsubmittedProperties=true, sectionCrumbs=[SectionCrumb"
        + "{sectionIdentifier='42', sectionId='42'}]}", actualToStringResult);
    assertEquals("Requesting Entity Name", actualRequestingEntityName);
    assertEquals("Section Entity Field", actualSectionEntityField);
    assertTrue(actualDeferredOperations.isEmpty());
    assertTrue(actualSubPackages.isEmpty());
    assertTrue(actualIsAddOperationInspectResult);
    assertTrue(actualIsProcessedInternalResult);
    assertTrue(actualIsTreeCollectionResult);
    assertTrue(actualIsValidateUnsubmittedPropertiesResult);
    assertSame(deferredOperations, actualDeferredOperations);
    assertSame(subPackages, actualSubPackages);
    assertSame(entity2, actualEntity);
    assertSame(persistencePerspective, actualPersistencePerspective);
    assertSame(customCriteria, actualCustomCriteria);
    assertSame(sectionCrumbs, actualSectionCrumbs);
    assertArrayEquals(new String[]{"Custom Criteria"}, actualCustomCriteria);
  }

  /**
   * Test {@link PersistencePackage#findProperty(String)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property()}.</li>
   *   <li>Then return {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#findProperty(String)}
   */
  @Test
  public void testFindProperty_givenEntityFindPropertyReturnProperty_thenReturnProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Entity entity = mock(Entity.class);
    Property property = new Property();
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Property actualFindPropertyResult = (new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123")).findProperty("Name");

    // Assert
    verify(entity).findProperty(eq("Name"));
    assertSame(property, actualFindPropertyResult);
  }

  /**
   * Test {@link PersistencePackage#findProperty(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#findProperty(String)}
   */
  @Test
  public void testFindProperty_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertNull((new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123")).findProperty("Name"));
  }

  /**
   * Test {@link PersistencePackage#getProperties()}.
   * <ul>
   *   <li>Given {@link PersistencePackage#PersistencePackage()} Entity is
   * {@link Entity} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#getProperties()}
   */
  @Test
  public void testGetProperties_givenPersistencePackageEntityIsEntity_thenReturnNull() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(new Entity());

    // Act and Assert
    assertNull(persistencePackage.getProperties());
  }

  /**
   * Test {@link PersistencePackage#getPMap()}.
   * <ul>
   *   <li>Given {@link PersistencePackage#PersistencePackage()} Entity is
   * {@link Entity} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#getPMap()}
   */
  @Test
  public void testGetPMap_givenPersistencePackageEntityIsEntity_thenReturnEmpty() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(new Entity());

    // Act and Assert
    assertTrue(persistencePackage.getPMap().isEmpty());
  }

  /**
   * Test
   * {@link PersistencePackage#getSecurityCeilingEntityFullyQualifiedClassname()}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackage#getSecurityCeilingEntityFullyQualifiedClassname()}
   */
  @Test
  public void testGetSecurityCeilingEntityFullyQualifiedClassname_thenReturnFoo() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setSecurityCeilingEntityFullyQualifiedClassname("foo");

    // Act and Assert
    assertEquals("foo", persistencePackage.getSecurityCeilingEntityFullyQualifiedClassname());
  }

  /**
   * Test
   * {@link PersistencePackage#getSecurityCeilingEntityFullyQualifiedClassname()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackage#getSecurityCeilingEntityFullyQualifiedClassname()}
   */
  @Test
  public void testGetSecurityCeilingEntityFullyQualifiedClassname_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PersistencePackage()).getSecurityCeilingEntityFullyQualifiedClassname());
  }

  /**
   * Test {@link PersistencePackage#addCustomCriteria(String)}.
   * <p>
   * Method under test: {@link PersistencePackage#addCustomCriteria(String)}
   */
  @Test
  public void testAddCustomCriteria() {
    // Arrange and Act
    persistencePackage.addCustomCriteria("Criteria");

    // Assert
    assertArrayEquals(new String[]{"Criteria"}, persistencePackage.getCustomCriteria());
  }

  /**
   * Test {@link PersistencePackage#addCustomCriteria(String)}.
   * <p>
   * Method under test: {@link PersistencePackage#addCustomCriteria(String)}
   */
  @Test
  public void testAddCustomCriteria2() {
    // Arrange and Act
    persistencePackage.addCustomCriteria("PersistencePackage{");

    // Assert
    assertArrayEquals(new String[]{"PersistencePackage{"}, persistencePackage.getCustomCriteria());
  }

  /**
   * Test {@link PersistencePackage#removeCustomCriteria(String)}.
   * <p>
   * Method under test: {@link PersistencePackage#removeCustomCriteria(String)}
   */
  @Test
  public void testRemoveCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");

    // Act
    persistencePackage.removeCustomCriteria("Criteria");

    // Assert that nothing has changed
    assertEquals(1, persistencePackage.getCustomCriteria().length);
  }

  /**
   * Test {@link PersistencePackage#removeCustomCriteria(String)}.
   * <p>
   * Method under test: {@link PersistencePackage#removeCustomCriteria(String)}
   */
  @Test
  public void testRemoveCustomCriteria2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Entity entity = mock(Entity.class);
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");

    // Act
    persistencePackage.removeCustomCriteria("Criteria");

    // Assert that nothing has changed
    assertEquals(1, persistencePackage.getCustomCriteria().length);
  }

  /**
   * Test {@link PersistencePackage#removeCustomCriteria(String)}.
   * <ul>
   *   <li>Given {@link PersistencePackage#PersistencePackage()} addCustomCriteria
   * {@code Criteria}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#removeCustomCriteria(String)}
   */
  @Test
  public void testRemoveCustomCriteria_givenPersistencePackageAddCustomCriteriaCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.addCustomCriteria("Criteria");
    persistencePackage.addCustomCriteria("Criteria");

    // Act
    persistencePackage.removeCustomCriteria("Criteria");

    // Assert
    assertEquals(1, persistencePackage.getCustomCriteria().length);
  }

  /**
   * Test {@link PersistencePackage#removeCustomCriteria(String)}.
   * <ul>
   *   <li>Then array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#removeCustomCriteria(String)}
   */
  @Test
  public void testRemoveCustomCriteria_thenArrayLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.addCustomCriteria("Criteria");

    // Act
    persistencePackage.removeCustomCriteria("Criteria");

    // Assert
    assertEquals(0, persistencePackage.getCustomCriteria().length);
  }

  /**
   * Test {@link PersistencePackage#removeCustomCriteria(String)}.
   * <ul>
   *   <li>Then {@link PersistencePackage#PersistencePackage()} CustomCriteria is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#removeCustomCriteria(String)}
   */
  @Test
  public void testRemoveCustomCriteria_thenPersistencePackageCustomCriteriaIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    persistencePackage.removeCustomCriteria("Criteria");

    // Assert that nothing has changed
    assertNull(persistencePackage.getCustomCriteria());
  }

  /**
   * Test {@link PersistencePackage#getCriteriaIndex(String)}.
   * <p>
   * Method under test: {@link PersistencePackage#getCriteriaIndex(String)}
   */
  @Test
  public void testGetCriteriaIndex() {
    // Arrange, Act and Assert
    assertEquals(-1, persistencePackage.getCriteriaIndex("Criteria"));
  }

  /**
   * Test {@link PersistencePackage#containsCriteria(String)}.
   * <ul>
   *   <li>When {@code Criteria}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#containsCriteria(String)}
   */
  @Test
  public void testContainsCriteria_whenCriteria() {
    // Arrange, Act and Assert
    assertFalse(persistencePackage.containsCriteria("Criteria"));
  }

  /**
   * Test {@link PersistencePackage#containsCriteria(String)}.
   * <ul>
   *   <li>When {@code PersistencePackage{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#containsCriteria(String)}
   */
  @Test
  public void testContainsCriteria_whenPersistencePackage() {
    // Arrange, Act and Assert
    assertFalse(persistencePackage.containsCriteria("PersistencePackage{"));
  }

  /**
   * Test {@link PersistencePackage#getPersistencePerspectiveItems()}.
   * <p>
   * Method under test:
   * {@link PersistencePackage#getPersistencePerspectiveItems()}
   */
  @Test
  public void testGetPersistencePerspectiveItems() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertTrue(persistencePackage.getPersistencePerspectiveItems().isEmpty());
  }

  /**
   * Test {@link PersistencePackage#getPersistencePerspectiveItems()}.
   * <ul>
   *   <li>Given {@link PersistencePackage#PersistencePackage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePackage#getPersistencePerspectiveItems()}
   */
  @Test
  public void testGetPersistencePerspectiveItems_givenPersistencePackage() {
    // Arrange, Act and Assert
    assertTrue((new PersistencePackage()).getPersistencePerspectiveItems().isEmpty());
  }

  /**
   * Test {@link PersistencePackage#getClosetCrumb(String)}.
   * <p>
   * Method under test: {@link PersistencePackage#getClosetCrumb(String)}
   */
  @Test
  public void testGetClosetCrumb() {
    // Arrange and Act
    SectionCrumb actualClosetCrumb = persistencePackage.getClosetCrumb("My Ceiling");

    // Assert
    assertNull(actualClosetCrumb.getOriginalSectionIdentifier());
    assertNull(actualClosetCrumb.getSectionId());
    assertNull(actualClosetCrumb.getSectionIdentifier());
  }

  /**
   * Test {@link PersistencePackage#getBottomCrumb()}.
   * <ul>
   *   <li>Then return OriginalSectionIdentifier is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#getBottomCrumb()}
   */
  @Test
  public void testGetBottomCrumb_thenReturnOriginalSectionIdentifierIsNull() {
    // Arrange and Act
    SectionCrumb actualBottomCrumb = (new PersistencePackage()).getBottomCrumb();

    // Assert
    assertNull(actualBottomCrumb.getOriginalSectionIdentifier());
    assertNull(actualBottomCrumb.getSectionId());
    assertNull(actualBottomCrumb.getSectionIdentifier());
  }

  /**
   * Test {@link PersistencePackage#getBottomCrumb()}.
   * <ul>
   *   <li>Then return {@link SectionCrumb} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#getBottomCrumb()}
   */
  @Test
  public void testGetBottomCrumb_thenReturnSectionCrumb() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setSectionCrumbs(new SectionCrumb[]{sectionCrumb});

    // Act and Assert
    assertSame(sectionCrumb, persistencePackage.getBottomCrumb());
  }

  /**
   * Test {@link PersistencePackage#getTopCrumb()}.
   * <ul>
   *   <li>Then return OriginalSectionIdentifier is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#getTopCrumb()}
   */
  @Test
  public void testGetTopCrumb_thenReturnOriginalSectionIdentifierIsNull() {
    // Arrange and Act
    SectionCrumb actualTopCrumb = (new PersistencePackage()).getTopCrumb();

    // Assert
    assertNull(actualTopCrumb.getOriginalSectionIdentifier());
    assertNull(actualTopCrumb.getSectionId());
    assertNull(actualTopCrumb.getSectionIdentifier());
  }

  /**
   * Test {@link PersistencePackage#getTopCrumb()}.
   * <ul>
   *   <li>Then return {@link SectionCrumb} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#getTopCrumb()}
   */
  @Test
  public void testGetTopCrumb_thenReturnSectionCrumb() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setSectionCrumbs(new SectionCrumb[]{sectionCrumb});

    // Act and Assert
    assertSame(sectionCrumb, persistencePackage.getTopCrumb());
  }

  /**
   * Test
   * {@link PersistencePackage#addDeferredOperation(ChangeType, PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link PersistencePackage#addDeferredOperation(ChangeType, PersistencePackage)}
   */
  @Test
  public void testAddDeferredOperation() {
    // Arrange
    Entity entity = mock(Entity.class);
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    PersistencePackage persistencePackage2 = new PersistencePackage();

    // Act
    persistencePackage.addDeferredOperation(ChangeType.ADD, persistencePackage2);

    // Assert
    Map<ChangeType, List<PersistencePackage>> deferredOperations = persistencePackage.getDeferredOperations();
    assertEquals(1, deferredOperations.size());
    List<PersistencePackage> getResult = deferredOperations.get(ChangeType.ADD);
    assertEquals(1, getResult.size());
    assertSame(persistencePackage2, getResult.get(0));
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}, and
   * {@link PersistencePackage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersistencePackage#equals(Object)}
   *   <li>{@link PersistencePackage#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    PersistencePackage persistencePackage2 = new PersistencePackage();

    // Act and Assert
    assertEquals(persistencePackage, persistencePackage2);
    int expectedHashCodeResult = persistencePackage.hashCode();
    assertEquals(expectedHashCodeResult, persistencePackage2.hashCode());
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}, and
   * {@link PersistencePackage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersistencePackage#equals(Object)}
   *   <li>{@link PersistencePackage#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    Entity entity2 = new Entity();
    PersistencePackage persistencePackage2 = new PersistencePackage("Dr Jane Doe", entity2,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123");

    // Act and Assert
    assertEquals(persistencePackage, persistencePackage2);
    int expectedHashCodeResult = persistencePackage.hashCode();
    assertEquals(expectedHashCodeResult, persistencePackage2.hashCode());
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}, and
   * {@link PersistencePackage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersistencePackage#equals(Object)}
   *   <li>{@link PersistencePackage#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setFetchTypeFullyQualifiedClassname("Dr Jane Doe");

    PersistencePackage persistencePackage2 = new PersistencePackage();
    persistencePackage2.setFetchTypeFullyQualifiedClassname("Dr Jane Doe");

    // Act and Assert
    assertEquals(persistencePackage, persistencePackage2);
    int expectedHashCodeResult = persistencePackage.hashCode();
    assertEquals(expectedHashCodeResult, persistencePackage2.hashCode());
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}, and
   * {@link PersistencePackage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersistencePackage#equals(Object)}
   *   <li>{@link PersistencePackage#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setSectionEntityField("Section Entity Field");

    PersistencePackage persistencePackage2 = new PersistencePackage();
    persistencePackage2.setSectionEntityField("Section Entity Field");

    // Act and Assert
    assertEquals(persistencePackage, persistencePackage2);
    int expectedHashCodeResult = persistencePackage.hashCode();
    assertEquals(expectedHashCodeResult, persistencePackage2.hashCode());
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}, and
   * {@link PersistencePackage#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersistencePackage#equals(Object)}
   *   <li>{@link PersistencePackage#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act and Assert
    assertEquals(persistencePackage, persistencePackage);
    int expectedHashCodeResult = persistencePackage.hashCode();
    assertEquals(expectedHashCodeResult, persistencePackage.hashCode());
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");

    // Act and Assert
    assertNotEquals(persistencePackage, new PersistencePackage());
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.addCustomCriteria("Criteria");

    // Act and Assert
    assertNotEquals(persistencePackage, new PersistencePackage());
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCsrfToken("ABC123");
    persistencePackage.addCustomCriteria("Criteria");

    // Act and Assert
    assertNotEquals(persistencePackage, new PersistencePackage());
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    Entity entity = new Entity();

    // Act and Assert
    assertNotEquals(persistencePackage, new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123"));
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertNotEquals(persistencePackage, new PersistencePackage());
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(new Entity());

    // Act and Assert
    assertNotEquals(persistencePackage, new PersistencePackage());
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setFetchTypeFullyQualifiedClassname("Dr Jane Doe");

    // Act and Assert
    assertNotEquals(persistencePackage, new PersistencePackage());
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setSectionEntityField("Section Entity Field");

    // Act and Assert
    assertNotEquals(persistencePackage, new PersistencePackage());
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Entity entity = mock(Entity.class);
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");

    // Act and Assert
    assertNotEquals(persistencePackage, new PersistencePackage());
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");

    PersistencePackage persistencePackage2 = new PersistencePackage();
    persistencePackage2.setCeilingEntityFullyQualifiedClassname("Dr Jane Doe");

    // Act and Assert
    assertNotEquals(persistencePackage, persistencePackage2);
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    Entity entity2 = new Entity();

    // Act and Assert
    assertNotEquals(persistencePackage, new PersistencePackage("Dr Jane Doe", "Dr Jane Doe", entity2,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123"));
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();

    PersistencePackage persistencePackage2 = new PersistencePackage();
    persistencePackage2.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertNotEquals(persistencePackage, persistencePackage2);
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();

    PersistencePackage persistencePackage2 = new PersistencePackage();
    persistencePackage2.setEntity(new Entity());

    // Act and Assert
    assertNotEquals(persistencePackage, persistencePackage2);
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();

    PersistencePackage persistencePackage2 = new PersistencePackage();
    persistencePackage2.setCsrfToken("ABC123");

    // Act and Assert
    assertNotEquals(persistencePackage, persistencePackage2);
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();

    PersistencePackage persistencePackage2 = new PersistencePackage();
    persistencePackage2.setSectionEntityField("Section Entity Field");

    // Act and Assert
    assertNotEquals(persistencePackage, persistencePackage2);
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PersistencePackage(), null);
  }

  /**
   * Test {@link PersistencePackage#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePackage#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PersistencePackage(), "Different type to PersistencePackage");
  }
}
