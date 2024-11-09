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
package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.presentation.AdminGroupPresentation;
import org.broadleafcommerce.common.presentation.AdminTabPresentation;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.GroupMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaAnnotationRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.mockito.Mockito;

public class BasicEntityMetadataProviderDiffblueTest {
  /**
   * Test
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadata(AddMetadataRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadata(AddMetadataRequest, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    AddMetadataRequest addMetadataRequest = new AddMetadataRequest(parentClass, targetClass, new DynamicEntityDaoImpl(),
        "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        basicEntityMetadataProvider.addTabAndGroupMetadata(addMetadataRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadata(AddMetadataRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadata(AddMetadataRequest, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    AddMetadataRequest addMetadataRequest = new AddMetadataRequest(parentClass, targetClass,
        mock(DynamicEntityDao.class), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        basicEntityMetadataProvider.addTabAndGroupMetadata(addMetadataRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#overrideMetadataViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#overrideMetadataViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideMetadataViaAnnotation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        basicEntityMetadataProvider.overrideMetadataViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#overrideMetadataViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#overrideMetadataViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideMetadataViaAnnotation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        mock(DynamicEntityDao.class), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        basicEntityMetadataProvider.overrideMetadataViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#overrideMetadataViaXml(OverrideViaXmlRequest, Map)}.
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#overrideMetadataViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideMetadataViaXml() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, mock(DynamicEntityDaoImpl.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        basicEntityMetadataProvider.overrideMetadataViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#overrideMetadataViaXml(OverrideViaXmlRequest, Map)}.
   * <ul>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#overrideMetadataViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideMetadataViaXml_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        basicEntityMetadataProvider.overrideMetadataViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}.
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadataFromCmdProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{new Property()});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);
    HashMap<String, TabMetadata> metadata = new HashMap<>();

    // Act
    MetadataProviderResponse actualAddTabAndGroupMetadataFromCmdPropertiesResult = basicEntityMetadataProvider
        .addTabAndGroupMetadataFromCmdProperties(cmd, metadata);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    assertEquals(MetadataProviderResponse.HANDLED, actualAddTabAndGroupMetadataFromCmdPropertiesResult);
    assertEquals(tabAndGroupMetadata, metadata);
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}.
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadataFromCmdProperties2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);
    HashMap<String, TabMetadata> metadata = new HashMap<>();

    // Act
    MetadataProviderResponse actualAddTabAndGroupMetadataFromCmdPropertiesResult = basicEntityMetadataProvider
        .addTabAndGroupMetadataFromCmdProperties(cmd, metadata);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
    assertEquals(MetadataProviderResponse.HANDLED, actualAddTabAndGroupMetadataFromCmdPropertiesResult);
    assertEquals(tabAndGroupMetadata, metadata);
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}.
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadataFromCmdProperties3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);
    HashMap<String, TabMetadata> metadata = new HashMap<>();

    // Act
    MetadataProviderResponse actualAddTabAndGroupMetadataFromCmdPropertiesResult = basicEntityMetadataProvider
        .addTabAndGroupMetadataFromCmdProperties(cmd, metadata);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(property).getMetadata();
    assertEquals(MetadataProviderResponse.HANDLED, actualAddTabAndGroupMetadataFromCmdPropertiesResult);
    assertEquals(tabAndGroupMetadata, metadata);
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}.
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadataFromCmdProperties4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getGroupOrder()).thenReturn(1);
    when(adornedTargetCollectionMetadata.getTabOrder()).thenReturn(1);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(false);
    when(adornedTargetCollectionMetadata.getGroup()).thenReturn("Group");
    when(adornedTargetCollectionMetadata.getTab()).thenReturn("Tab");
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getPolymorphicEntities()).thenReturn(new ClassTree());
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    HashMap<String, TabMetadata> metadata = new HashMap<>();

    // Act
    basicEntityMetadataProvider.addTabAndGroupMetadataFromCmdProperties(cmd, metadata);

    // Assert
    verify(cmd, atLeast(1)).getPolymorphicEntities();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGroup();
    verify(adornedTargetCollectionMetadata).getGroupOrder();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTab();
    verify(adornedTargetCollectionMetadata).getTabOrder();
    verify(property).getMetadata();
    assertEquals(1, metadata.size());
    TabMetadata getResult = metadata.get("Tab");
    GroupMetadata firstGroup = getResult.getFirstGroup();
    assertEquals("Group", firstGroup.getGroupName());
    assertNull(firstGroup.getOwningClass());
    assertNull(firstGroup.getTooltip());
    assertEquals(0, firstGroup.getColumn().intValue());
    assertEquals(1, firstGroup.getGroupOrder().intValue());
    Map<String, GroupMetadata> groupMetadata = getResult.getGroupMetadata();
    assertEquals(1, groupMetadata.size());
    assertFalse(firstGroup.getCollapsed());
    assertFalse(firstGroup.getUntitled());
    assertSame(firstGroup, groupMetadata.get("Group"));
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}.
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadataFromCmdProperties5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getGroupOrder()).thenReturn(1);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(false);
    when(adornedTargetCollectionMetadata.getGroup()).thenReturn("Group");
    when(adornedTargetCollectionMetadata.getTab()).thenReturn("");
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getPolymorphicEntities()).thenReturn(new ClassTree());
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);
    HashMap<String, TabMetadata> metadata = new HashMap<>();

    // Act
    MetadataProviderResponse actualAddTabAndGroupMetadataFromCmdPropertiesResult = basicEntityMetadataProvider
        .addTabAndGroupMetadataFromCmdProperties(cmd, metadata);

    // Assert
    verify(cmd).getPolymorphicEntities();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGroup();
    verify(adornedTargetCollectionMetadata).getGroupOrder();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTab();
    verify(property).getMetadata();
    assertEquals(MetadataProviderResponse.HANDLED, actualAddTabAndGroupMetadataFromCmdPropertiesResult);
    assertEquals(tabAndGroupMetadata, metadata);
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}.
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadataFromCmdProperties6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getGroupOrder()).thenReturn(1);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(false);
    when(adornedTargetCollectionMetadata.getGroup()).thenReturn("Group");
    when(adornedTargetCollectionMetadata.getTab()).thenReturn("foo");
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getPolymorphicEntities()).thenReturn(new ClassTree());
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    HashMap<String, TabMetadata> metadata = new HashMap<>();
    metadata.put("foo", new TabMetadata());

    // Act
    MetadataProviderResponse actualAddTabAndGroupMetadataFromCmdPropertiesResult = basicEntityMetadataProvider
        .addTabAndGroupMetadataFromCmdProperties(cmd, metadata);

    // Assert
    verify(cmd).getPolymorphicEntities();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGroup();
    verify(adornedTargetCollectionMetadata).getGroupOrder();
    verify(adornedTargetCollectionMetadata).getTab();
    verify(property).getMetadata();
    assertEquals(1, metadata.size());
    assertEquals(MetadataProviderResponse.HANDLED, actualAddTabAndGroupMetadataFromCmdPropertiesResult);
    assertTrue(metadata.containsKey("foo"));
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}.
   * <ul>
   *   <li>Then calls {@link TabMetadata#getGroupMetadata()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadataFromCmdProperties_thenCallsGetGroupMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getGroupOrder()).thenReturn(1);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(false);
    when(adornedTargetCollectionMetadata.getGroup()).thenReturn("Group");
    when(adornedTargetCollectionMetadata.getTab()).thenReturn("foo");
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getPolymorphicEntities()).thenReturn(new ClassTree());
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getGroupMetadata()).thenReturn(new HashMap<>());

    HashMap<String, TabMetadata> metadata = new HashMap<>();
    metadata.put("foo", tabMetadata);

    // Act
    MetadataProviderResponse actualAddTabAndGroupMetadataFromCmdPropertiesResult = basicEntityMetadataProvider
        .addTabAndGroupMetadataFromCmdProperties(cmd, metadata);

    // Assert
    verify(cmd).getPolymorphicEntities();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGroup();
    verify(adornedTargetCollectionMetadata).getGroupOrder();
    verify(adornedTargetCollectionMetadata).getTab();
    verify(property).getMetadata();
    verify(tabMetadata, atLeast(1)).getGroupMetadata();
    assertEquals(1, metadata.size());
    assertEquals(MetadataProviderResponse.HANDLED, actualAddTabAndGroupMetadataFromCmdPropertiesResult);
    assertTrue(metadata.containsKey("foo"));
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadataFromCmdProperties_thenHashMapSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getGroupOrder()).thenReturn(1);
    when(adornedTargetCollectionMetadata.getTabOrder()).thenReturn(1);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(false);
    when(adornedTargetCollectionMetadata.getGroup()).thenReturn("Group");
    when(adornedTargetCollectionMetadata.getTab()).thenReturn("Tab");
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getPolymorphicEntities()).thenReturn(new ClassTree());
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    HashMap<String, TabMetadata> metadata = new HashMap<>();
    metadata.put("foo", new TabMetadata());

    // Act
    basicEntityMetadataProvider.addTabAndGroupMetadataFromCmdProperties(cmd, metadata);

    // Assert
    verify(cmd, atLeast(1)).getPolymorphicEntities();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGroup();
    verify(adornedTargetCollectionMetadata).getGroupOrder();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTab();
    verify(adornedTargetCollectionMetadata).getTabOrder();
    verify(property).getMetadata();
    assertEquals(2, metadata.size());
    TabMetadata getResult = metadata.get("Tab");
    GroupMetadata firstGroup = getResult.getFirstGroup();
    assertEquals("Group", firstGroup.getGroupName());
    assertNull(firstGroup.getOwningClass());
    assertNull(firstGroup.getTooltip());
    assertEquals(0, firstGroup.getColumn().intValue());
    assertEquals(1, firstGroup.getGroupOrder().intValue());
    Map<String, GroupMetadata> groupMetadata = getResult.getGroupMetadata();
    assertEquals(1, groupMetadata.size());
    assertFalse(firstGroup.getCollapsed());
    assertFalse(firstGroup.getUntitled());
    assertTrue(metadata.containsKey("foo"));
    assertSame(firstGroup, groupMetadata.get("Group"));
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadataFromCmdProperties_thenHashMapSizeIsTwo2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getGroupOrder()).thenReturn(1);
    when(adornedTargetCollectionMetadata.getTabOrder()).thenReturn(1);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(false);
    when(adornedTargetCollectionMetadata.getGroup()).thenReturn("Group");
    when(adornedTargetCollectionMetadata.getTab()).thenReturn("Tab");
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getPolymorphicEntities()).thenReturn(new ClassTree());
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getGroupMetadata()).thenReturn(new HashMap<>());

    HashMap<String, TabMetadata> metadata = new HashMap<>();
    metadata.put("foo", tabMetadata);

    // Act
    basicEntityMetadataProvider.addTabAndGroupMetadataFromCmdProperties(cmd, metadata);

    // Assert
    verify(cmd, atLeast(1)).getPolymorphicEntities();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGroup();
    verify(adornedTargetCollectionMetadata).getGroupOrder();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTab();
    verify(adornedTargetCollectionMetadata).getTabOrder();
    verify(property).getMetadata();
    verify(tabMetadata).getGroupMetadata();
    assertEquals(2, metadata.size());
    TabMetadata getResult = metadata.get("Tab");
    GroupMetadata firstGroup = getResult.getFirstGroup();
    assertEquals("Group", firstGroup.getGroupName());
    assertNull(firstGroup.getOwningClass());
    assertNull(firstGroup.getTooltip());
    assertEquals(0, firstGroup.getColumn().intValue());
    assertEquals(1, firstGroup.getGroupOrder().intValue());
    Map<String, GroupMetadata> groupMetadata = getResult.getGroupMetadata();
    assertEquals(1, groupMetadata.size());
    assertFalse(firstGroup.getCollapsed());
    assertFalse(firstGroup.getUntitled());
    assertTrue(metadata.containsKey("foo"));
    assertSame(firstGroup, groupMetadata.get("Group"));
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code Tab} TabName is {@code Tab}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadataFromCmdProperties_thenHashMapTabTabNameIsTab() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getTabOrder()).thenReturn(1);
    when(adornedTargetCollectionMetadata.getExcluded()).thenReturn(false);
    when(adornedTargetCollectionMetadata.getGroup()).thenReturn("");
    when(adornedTargetCollectionMetadata.getTab()).thenReturn("Tab");
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getPolymorphicEntities()).thenReturn(new ClassTree());
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    HashMap<String, TabMetadata> metadata = new HashMap<>();

    // Act
    basicEntityMetadataProvider.addTabAndGroupMetadataFromCmdProperties(cmd, metadata);

    // Assert
    verify(cmd).getPolymorphicEntities();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getExcluded();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getGroup();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getTab();
    verify(adornedTargetCollectionMetadata).getTabOrder();
    verify(property).getMetadata();
    assertEquals(1, metadata.size());
    TabMetadata getResult = metadata.get("Tab");
    assertEquals("Tab", getResult.getTabName());
    assertNull(getResult.getOwningClass());
    assertNull(getResult.getFirstGroup());
    assertEquals(1, getResult.getTabOrder().intValue());
    assertTrue(getResult.getGroupMetadata().isEmpty());
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}.
   * <ul>
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadataFromCmdProperties_whenClassMetadataCeilingTypeIsType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);
    HashMap<String, TabMetadata> metadata = new HashMap<>();

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        basicEntityMetadataProvider.addTabAndGroupMetadataFromCmdProperties(cmd, metadata));
    assertEquals(tabAndGroupMetadata, metadata);
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#buildTabMetadata(AdminTabPresentation, Class, Map)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@link TabMetadata}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#buildTabMetadata(AdminTabPresentation, Class, Map)}
   */
  @Test
  public void testBuildTabMetadata_givenTabMetadata_whenHashMapFooIsTabMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    AdminGroupPresentation adminGroupPresentation = mock(AdminGroupPresentation.class);
    when(adminGroupPresentation.collapsed()).thenReturn(true);
    when(adminGroupPresentation.untitled()).thenReturn(true);
    when(adminGroupPresentation.column()).thenReturn(1);
    when(adminGroupPresentation.order()).thenReturn(1);
    when(adminGroupPresentation.name()).thenReturn("Name");
    when(adminGroupPresentation.tooltip()).thenReturn("127.0.0.1");
    AdminTabPresentation tabPresentation = mock(AdminTabPresentation.class);
    when(tabPresentation.order()).thenReturn(1);
    when(tabPresentation.name()).thenReturn("Name");
    when(tabPresentation.groups()).thenReturn(new AdminGroupPresentation[]{adminGroupPresentation});
    Class<Object> owningClass = Object.class;

    HashMap<String, TabMetadata> metadata = new HashMap<>();
    metadata.put("foo", new TabMetadata());

    // Act
    TabMetadata actualBuildTabMetadataResult = basicEntityMetadataProvider.buildTabMetadata(tabPresentation,
        owningClass, metadata);

    // Assert
    verify(adminGroupPresentation).collapsed();
    verify(adminGroupPresentation).column();
    verify(adminGroupPresentation, atLeast(1)).name();
    verify(adminGroupPresentation).order();
    verify(adminGroupPresentation).tooltip();
    verify(adminGroupPresentation).untitled();
    verify(tabPresentation).groups();
    verify(tabPresentation, atLeast(1)).name();
    verify(tabPresentation).order();
    GroupMetadata firstGroup = actualBuildTabMetadataResult.getFirstGroup();
    assertEquals("Name", firstGroup.getGroupName());
    assertEquals("Name", actualBuildTabMetadataResult.getTabName());
    assertEquals("java.lang.Object", firstGroup.getOwningClass());
    assertEquals("java.lang.Object", actualBuildTabMetadataResult.getOwningClass());
    assertEquals(1, firstGroup.getColumn().intValue());
    assertEquals(1, firstGroup.getGroupOrder().intValue());
    assertEquals(1, actualBuildTabMetadataResult.getTabOrder().intValue());
    Map<String, GroupMetadata> groupMetadata = actualBuildTabMetadataResult.getGroupMetadata();
    assertEquals(1, groupMetadata.size());
    assertTrue(firstGroup.getCollapsed());
    assertTrue(firstGroup.getUntitled());
    assertSame(firstGroup, groupMetadata.get("Name"));
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#buildTabMetadata(AdminTabPresentation, Class, Map)}.
   * <ul>
   *   <li>Then calls {@link TabMetadata#getGroupMetadata()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#buildTabMetadata(AdminTabPresentation, Class, Map)}
   */
  @Test
  public void testBuildTabMetadata_thenCallsGetGroupMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    AdminGroupPresentation adminGroupPresentation = mock(AdminGroupPresentation.class);
    when(adminGroupPresentation.collapsed()).thenReturn(true);
    when(adminGroupPresentation.untitled()).thenReturn(true);
    when(adminGroupPresentation.column()).thenReturn(1);
    when(adminGroupPresentation.order()).thenReturn(1);
    when(adminGroupPresentation.name()).thenReturn("Name");
    when(adminGroupPresentation.tooltip()).thenReturn("127.0.0.1");
    AdminTabPresentation tabPresentation = mock(AdminTabPresentation.class);
    when(tabPresentation.order()).thenReturn(1);
    when(tabPresentation.name()).thenReturn("Name");
    when(tabPresentation.groups()).thenReturn(new AdminGroupPresentation[]{adminGroupPresentation});
    Class<Object> owningClass = Object.class;
    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getGroupMetadata()).thenReturn(new HashMap<>());

    HashMap<String, TabMetadata> metadata = new HashMap<>();
    metadata.put("foo", tabMetadata);

    // Act
    TabMetadata actualBuildTabMetadataResult = basicEntityMetadataProvider.buildTabMetadata(tabPresentation,
        owningClass, metadata);

    // Assert
    verify(adminGroupPresentation).collapsed();
    verify(adminGroupPresentation).column();
    verify(adminGroupPresentation, atLeast(1)).name();
    verify(adminGroupPresentation).order();
    verify(adminGroupPresentation).tooltip();
    verify(adminGroupPresentation).untitled();
    verify(tabPresentation).groups();
    verify(tabPresentation, atLeast(1)).name();
    verify(tabPresentation).order();
    verify(tabMetadata).getGroupMetadata();
    GroupMetadata firstGroup = actualBuildTabMetadataResult.getFirstGroup();
    assertEquals("Name", firstGroup.getGroupName());
    assertEquals("Name", actualBuildTabMetadataResult.getTabName());
    assertEquals("java.lang.Object", firstGroup.getOwningClass());
    assertEquals("java.lang.Object", actualBuildTabMetadataResult.getOwningClass());
    assertEquals(1, firstGroup.getColumn().intValue());
    assertEquals(1, firstGroup.getGroupOrder().intValue());
    assertEquals(1, actualBuildTabMetadataResult.getTabOrder().intValue());
    Map<String, GroupMetadata> groupMetadata = actualBuildTabMetadataResult.getGroupMetadata();
    assertEquals(1, groupMetadata.size());
    assertTrue(firstGroup.getCollapsed());
    assertTrue(firstGroup.getUntitled());
    assertSame(firstGroup, groupMetadata.get("Name"));
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#buildTabMetadata(AdminTabPresentation, Class, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return FirstGroup GroupName is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#buildTabMetadata(AdminTabPresentation, Class, Map)}
   */
  @Test
  public void testBuildTabMetadata_whenHashMap_thenReturnFirstGroupGroupNameIsName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    AdminGroupPresentation adminGroupPresentation = mock(AdminGroupPresentation.class);
    when(adminGroupPresentation.collapsed()).thenReturn(true);
    when(adminGroupPresentation.untitled()).thenReturn(true);
    when(adminGroupPresentation.column()).thenReturn(1);
    when(adminGroupPresentation.order()).thenReturn(1);
    when(adminGroupPresentation.name()).thenReturn("Name");
    when(adminGroupPresentation.tooltip()).thenReturn("127.0.0.1");
    AdminTabPresentation tabPresentation = mock(AdminTabPresentation.class);
    when(tabPresentation.order()).thenReturn(1);
    when(tabPresentation.name()).thenReturn("Name");
    when(tabPresentation.groups()).thenReturn(new AdminGroupPresentation[]{adminGroupPresentation});
    Class<Object> owningClass = Object.class;

    // Act
    TabMetadata actualBuildTabMetadataResult = basicEntityMetadataProvider.buildTabMetadata(tabPresentation,
        owningClass, new HashMap<>());

    // Assert
    verify(adminGroupPresentation).collapsed();
    verify(adminGroupPresentation).column();
    verify(adminGroupPresentation, atLeast(1)).name();
    verify(adminGroupPresentation).order();
    verify(adminGroupPresentation).tooltip();
    verify(adminGroupPresentation).untitled();
    verify(tabPresentation).groups();
    verify(tabPresentation, atLeast(1)).name();
    verify(tabPresentation).order();
    GroupMetadata firstGroup = actualBuildTabMetadataResult.getFirstGroup();
    assertEquals("Name", firstGroup.getGroupName());
    assertEquals("Name", actualBuildTabMetadataResult.getTabName());
    assertEquals("java.lang.Object", firstGroup.getOwningClass());
    assertEquals("java.lang.Object", actualBuildTabMetadataResult.getOwningClass());
    assertEquals(1, firstGroup.getColumn().intValue());
    assertEquals(1, firstGroup.getGroupOrder().intValue());
    assertEquals(1, actualBuildTabMetadataResult.getTabOrder().intValue());
    Map<String, GroupMetadata> groupMetadata = actualBuildTabMetadataResult.getGroupMetadata();
    assertEquals(1, groupMetadata.size());
    assertTrue(firstGroup.getCollapsed());
    assertTrue(firstGroup.getUntitled());
    assertSame(firstGroup, groupMetadata.get("Name"));
  }

  /**
   * Test
   * {@link BasicEntityMetadataProvider#buildGroupMetadata(AdminGroupPresentation, Class, Map)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return GroupName is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicEntityMetadataProvider#buildGroupMetadata(AdminGroupPresentation, Class, Map)}
   */
  @Test
  public void testBuildGroupMetadata_whenJavaLangObject_thenReturnGroupNameIsName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicEntityMetadataProvider basicEntityMetadataProvider = new BasicEntityMetadataProvider();
    AdminGroupPresentation groupPresentation = mock(AdminGroupPresentation.class);
    when(groupPresentation.collapsed()).thenReturn(true);
    when(groupPresentation.untitled()).thenReturn(true);
    when(groupPresentation.column()).thenReturn(1);
    when(groupPresentation.order()).thenReturn(1);
    when(groupPresentation.name()).thenReturn("Name");
    when(groupPresentation.tooltip()).thenReturn("127.0.0.1");
    Class<Object> owningClass = Object.class;

    // Act
    GroupMetadata actualBuildGroupMetadataResult = basicEntityMetadataProvider.buildGroupMetadata(groupPresentation,
        owningClass, new HashMap<>());

    // Assert
    verify(groupPresentation).collapsed();
    verify(groupPresentation).column();
    verify(groupPresentation).name();
    verify(groupPresentation).order();
    verify(groupPresentation).tooltip();
    verify(groupPresentation).untitled();
    assertEquals("Name", actualBuildGroupMetadataResult.getGroupName());
    assertEquals("java.lang.Object", actualBuildGroupMetadataResult.getOwningClass());
    assertEquals(1, actualBuildGroupMetadataResult.getColumn().intValue());
    assertEquals(1, actualBuildGroupMetadataResult.getGroupOrder().intValue());
    assertTrue(actualBuildGroupMetadataResult.getCollapsed());
    assertTrue(actualBuildGroupMetadataResult.getUntitled());
  }

  /**
   * Test {@link BasicEntityMetadataProvider#getOrder()}.
   * <p>
   * Method under test: {@link BasicEntityMetadataProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.BASIC, (new BasicEntityMetadataProvider()).getOrder());
  }
}
