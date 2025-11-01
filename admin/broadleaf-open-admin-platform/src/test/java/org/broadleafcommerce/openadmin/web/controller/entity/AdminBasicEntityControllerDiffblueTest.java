/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.openadmin.web.controller.entity;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class AdminBasicEntityControllerDiffblueTest {
  /**
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  public void testGetCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    // Act and Assert
    assertNull(adminBasicEntityController.getCustomCriteria(new HashMap<>()));
  }

  /**
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  public void testGetCustomCriteria2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminBasicEntityController()).getCustomCriteria(null));
  }

  /**
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  public void testGetCustomCriteria3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put(AdminBasicEntityController.CUSTOM_CRITERIA, stringList);

    // Act and Assert
    assertArrayEquals(new String[]{"Request Params"}, adminBasicEntityController.getCustomCriteria(requestParams));
  }

  /**
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  public void testGetCustomCriteria4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put(AdminBasicEntityController.CUSTOM_CRITERIA, null);

    // Act and Assert
    assertArrayEquals(new String[]{null}, adminBasicEntityController.getCustomCriteria(requestParams));
  }

  /**
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  public void testGetCustomCriteria5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put(AdminBasicEntityController.CUSTOM_CRITERIA, new ArrayList<>());

    // Act and Assert
    assertArrayEquals(new String[]{null}, adminBasicEntityController.getCustomCriteria(requestParams));
  }

  /**
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  public void testGetCustomCriteria6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminBasicEntityController.getCustomCriteria(requestParams));
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  public void testIsNotReadOnly() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertTrue(adminBasicEntityController.isNotReadOnly(cmd));
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  public void testIsNotReadOnly2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
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
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsNotReadOnlyResult = adminBasicEntityController.isNotReadOnly(cmd);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    assertTrue(actualIsNotReadOnlyResult);
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  public void testIsNotReadOnly3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
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
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsNotReadOnlyResult = adminBasicEntityController.isNotReadOnly(cmd);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
    assertFalse(actualIsNotReadOnlyResult);
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  public void testIsNotReadOnly4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
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
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsNotReadOnlyResult = adminBasicEntityController.isNotReadOnly(cmd);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    assertTrue(actualIsNotReadOnlyResult);
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  public void testIsNotReadOnly5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
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
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsNotReadOnlyResult = adminBasicEntityController.isNotReadOnly(cmd);

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    assertFalse(actualIsNotReadOnlyResult);
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  public void testIsNotReadOnly6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenReturn(false);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
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
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsNotReadOnlyResult = adminBasicEntityController.isNotReadOnly(cmd);

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    assertTrue(actualIsNotReadOnlyResult);
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  public void testIsNotReadOnly7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenThrow(new UnsupportedOperationException("foo"));
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
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
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> adminBasicEntityController.isNotReadOnly(cmd));
    verify(basicFieldMetadata).getReadOnly();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}
   */
  @Test
  public void testDetermineEntityType() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals("Entity Type", adminBasicEntityController.determineEntityType("Entity Type", cmd));
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}
   */
  @Test
  public void testDetermineEntityType2() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertNull(adminBasicEntityController.determineEntityType(null, cmd));
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}
   */
  @Test
  public void testDetermineEntityType3() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    ClassMetadata cmd = mock(ClassMetadata.class);
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

    // Act
    String actualDetermineEntityTypeResult = adminBasicEntityController.determineEntityType("Entity Type", cmd);

    // Assert
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    assertEquals("Entity Type", actualDetermineEntityTypeResult);
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}
   */
  @Test
  public void testDetermineEntityType4() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    ClassTree classTree = mock(ClassTree.class);
    when(classTree.getChildren()).thenReturn(new ClassTree[]{new ClassTree()});
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getPolymorphicEntities()).thenReturn(classTree);
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

    // Act
    String actualDetermineEntityTypeResult = adminBasicEntityController.determineEntityType("", cmd);

    // Assert
    verify(cmd).getPolymorphicEntities();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(classTree).getChildren();
    assertNull(actualDetermineEntityTypeResult);
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}
   */
  @Test
  public void testDetermineEntityType5() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    ClassTree classTree = mock(ClassTree.class);
    when(classTree.getFullyQualifiedClassname()).thenThrow(new UnsupportedOperationException("foo"));
    when(classTree.getChildren()).thenReturn(new ClassTree[]{});
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getPolymorphicEntities()).thenReturn(classTree);
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

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> adminBasicEntityController.determineEntityType("", cmd));
    verify(cmd, atLeast(1)).getPolymorphicEntities();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(classTree).getChildren();
    verify(classTree).getFullyQualifiedClassname();
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#getErrorDuplicatingResponse(HttpServletResponse, String)}
   */
  @Test
  public void testGetErrorDuplicatingResponse() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualErrorDuplicatingResponse = adminBasicEntityController.getErrorDuplicatingResponse(response, "Code");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals("{\"errors\":[{\"code\":\"Code\",\"errorType\":\"global\",\"message\":\"Duplication_Failure\"}]}",
        response.getContentAsString());
    assertNull(actualErrorDuplicatingResponse);
    byte[] contentAsByteArray = response.getContentAsByteArray();
    assertEquals(81, contentAsByteArray.length);
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCommitted());
    assertEquals(':', contentAsByteArray[18]);
    assertEquals(':', contentAsByteArray[56]);
    assertEquals(':', contentAsByteArray[9]);
    assertEquals('C', contentAsByteArray[20]);
    assertEquals('D', contentAsByteArray[58]);
    assertEquals('F', contentAsByteArray[70]);
    assertEquals('[', contentAsByteArray[10]);
    assertEquals('"', contentAsByteArray[1]);
    assertEquals('"', contentAsByteArray[12]);
    assertEquals('"', contentAsByteArray[17]);
    assertEquals('"', contentAsByteArray[19]);
    assertEquals('"', contentAsByteArray[24]);
    assertEquals('"', contentAsByteArray[57]);
    assertEquals('"', contentAsByteArray[77]);
    assertEquals('"', contentAsByteArray[8]);
    assertEquals(']', contentAsByteArray[79]);
    assertEquals('_', contentAsByteArray[69]);
    assertEquals('a', contentAsByteArray[71]);
    assertEquals('a', contentAsByteArray[Double.SIZE]);
    assertEquals('c', contentAsByteArray[13]);
    assertEquals('c', contentAsByteArray[63]);
    assertEquals('d', contentAsByteArray[15]);
    assertEquals('d', contentAsByteArray[22]);
    assertEquals('e', contentAsByteArray[2]);
    assertEquals('e', contentAsByteArray[23]);
    assertEquals('e', contentAsByteArray[76]);
    assertEquals('e', contentAsByteArray[Short.SIZE]);
    assertEquals('i', contentAsByteArray[62]);
    assertEquals('i', contentAsByteArray[66]);
    assertEquals('i', contentAsByteArray[72]);
    assertEquals('l', contentAsByteArray[61]);
    assertEquals('l', contentAsByteArray[73]);
    assertEquals('n', contentAsByteArray[68]);
    assertEquals('o', contentAsByteArray[14]);
    assertEquals('o', contentAsByteArray[21]);
    assertEquals('o', contentAsByteArray[5]);
    assertEquals('o', contentAsByteArray[67]);
    assertEquals('p', contentAsByteArray[60]);
    assertEquals('r', contentAsByteArray[3]);
    assertEquals('r', contentAsByteArray[4]);
    assertEquals('r', contentAsByteArray[6]);
    assertEquals('r', contentAsByteArray[75]);
    assertEquals('s', contentAsByteArray[7]);
    assertEquals('t', contentAsByteArray[65]);
    assertEquals('u', contentAsByteArray[59]);
    assertEquals('u', contentAsByteArray[74]);
    assertEquals('{', contentAsByteArray[0]);
    assertEquals('{', contentAsByteArray[11]);
    assertEquals('}', contentAsByteArray[78]);
    assertEquals('}', contentAsByteArray[80]);
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#getErrorDuplicatingResponse(HttpServletResponse, String)}
   */
  @Test
  public void testGetErrorDuplicatingResponse2() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    adminBasicEntityController.addAuditableDisplayFields(new EntityForm());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualErrorDuplicatingResponse = adminBasicEntityController.getErrorDuplicatingResponse(response, "Code");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals("{\"errors\":[{\"code\":\"Code\",\"errorType\":\"global\",\"message\":\"Duplication_Failure\"}]}",
        response.getContentAsString());
    assertNull(actualErrorDuplicatingResponse);
    byte[] contentAsByteArray = response.getContentAsByteArray();
    assertEquals(81, contentAsByteArray.length);
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCommitted());
    assertEquals(':', contentAsByteArray[18]);
    assertEquals(':', contentAsByteArray[56]);
    assertEquals(':', contentAsByteArray[9]);
    assertEquals('C', contentAsByteArray[20]);
    assertEquals('D', contentAsByteArray[58]);
    assertEquals('F', contentAsByteArray[70]);
    assertEquals('[', contentAsByteArray[10]);
    assertEquals('"', contentAsByteArray[1]);
    assertEquals('"', contentAsByteArray[12]);
    assertEquals('"', contentAsByteArray[17]);
    assertEquals('"', contentAsByteArray[19]);
    assertEquals('"', contentAsByteArray[24]);
    assertEquals('"', contentAsByteArray[57]);
    assertEquals('"', contentAsByteArray[77]);
    assertEquals('"', contentAsByteArray[8]);
    assertEquals(']', contentAsByteArray[79]);
    assertEquals('_', contentAsByteArray[69]);
    assertEquals('a', contentAsByteArray[71]);
    assertEquals('a', contentAsByteArray[Double.SIZE]);
    assertEquals('c', contentAsByteArray[13]);
    assertEquals('c', contentAsByteArray[63]);
    assertEquals('d', contentAsByteArray[15]);
    assertEquals('d', contentAsByteArray[22]);
    assertEquals('e', contentAsByteArray[2]);
    assertEquals('e', contentAsByteArray[23]);
    assertEquals('e', contentAsByteArray[76]);
    assertEquals('e', contentAsByteArray[Short.SIZE]);
    assertEquals('i', contentAsByteArray[62]);
    assertEquals('i', contentAsByteArray[66]);
    assertEquals('i', contentAsByteArray[72]);
    assertEquals('l', contentAsByteArray[61]);
    assertEquals('l', contentAsByteArray[73]);
    assertEquals('n', contentAsByteArray[68]);
    assertEquals('o', contentAsByteArray[14]);
    assertEquals('o', contentAsByteArray[21]);
    assertEquals('o', contentAsByteArray[5]);
    assertEquals('o', contentAsByteArray[67]);
    assertEquals('p', contentAsByteArray[60]);
    assertEquals('r', contentAsByteArray[3]);
    assertEquals('r', contentAsByteArray[4]);
    assertEquals('r', contentAsByteArray[6]);
    assertEquals('r', contentAsByteArray[75]);
    assertEquals('s', contentAsByteArray[7]);
    assertEquals('t', contentAsByteArray[65]);
    assertEquals('u', contentAsByteArray[59]);
    assertEquals('u', contentAsByteArray[74]);
    assertEquals('{', contentAsByteArray[0]);
    assertEquals('{', contentAsByteArray[11]);
    assertEquals('}', contentAsByteArray[78]);
    assertEquals('}', contentAsByteArray[80]);
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#getErrorDuplicatingResponse(HttpServletResponse, String)}
   */
  @Test
  public void testGetErrorDuplicatingResponse3() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    adminBasicEntityController.addAuditableDisplayFields(entityForm);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualErrorDuplicatingResponse = adminBasicEntityController.getErrorDuplicatingResponse(response, "Code");

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals("{\"errors\":[{\"code\":\"Code\",\"errorType\":\"global\",\"message\":\"Duplication_Failure\"}]}",
        response.getContentAsString());
    assertNull(actualErrorDuplicatingResponse);
    byte[] contentAsByteArray = response.getContentAsByteArray();
    assertEquals(81, contentAsByteArray.length);
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCommitted());
    assertEquals(':', contentAsByteArray[18]);
    assertEquals(':', contentAsByteArray[56]);
    assertEquals(':', contentAsByteArray[9]);
    assertEquals('C', contentAsByteArray[20]);
    assertEquals('D', contentAsByteArray[58]);
    assertEquals('F', contentAsByteArray[70]);
    assertEquals('[', contentAsByteArray[10]);
    assertEquals('"', contentAsByteArray[1]);
    assertEquals('"', contentAsByteArray[12]);
    assertEquals('"', contentAsByteArray[17]);
    assertEquals('"', contentAsByteArray[19]);
    assertEquals('"', contentAsByteArray[24]);
    assertEquals('"', contentAsByteArray[57]);
    assertEquals('"', contentAsByteArray[77]);
    assertEquals('"', contentAsByteArray[8]);
    assertEquals(']', contentAsByteArray[79]);
    assertEquals('_', contentAsByteArray[69]);
    assertEquals('a', contentAsByteArray[71]);
    assertEquals('a', contentAsByteArray[Double.SIZE]);
    assertEquals('c', contentAsByteArray[13]);
    assertEquals('c', contentAsByteArray[63]);
    assertEquals('d', contentAsByteArray[15]);
    assertEquals('d', contentAsByteArray[22]);
    assertEquals('e', contentAsByteArray[2]);
    assertEquals('e', contentAsByteArray[23]);
    assertEquals('e', contentAsByteArray[76]);
    assertEquals('e', contentAsByteArray[Short.SIZE]);
    assertEquals('i', contentAsByteArray[62]);
    assertEquals('i', contentAsByteArray[66]);
    assertEquals('i', contentAsByteArray[72]);
    assertEquals('l', contentAsByteArray[61]);
    assertEquals('l', contentAsByteArray[73]);
    assertEquals('n', contentAsByteArray[68]);
    assertEquals('o', contentAsByteArray[14]);
    assertEquals('o', contentAsByteArray[21]);
    assertEquals('o', contentAsByteArray[5]);
    assertEquals('o', contentAsByteArray[67]);
    assertEquals('p', contentAsByteArray[60]);
    assertEquals('r', contentAsByteArray[3]);
    assertEquals('r', contentAsByteArray[4]);
    assertEquals('r', contentAsByteArray[6]);
    assertEquals('r', contentAsByteArray[75]);
    assertEquals('s', contentAsByteArray[7]);
    assertEquals('t', contentAsByteArray[65]);
    assertEquals('u', contentAsByteArray[59]);
    assertEquals('u', contentAsByteArray[74]);
    assertEquals('{', contentAsByteArray[0]);
    assertEquals('{', contentAsByteArray[11]);
    assertEquals('}', contentAsByteArray[78]);
    assertEquals('}', contentAsByteArray[80]);
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetViewSubRecords() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    HashMap<String, String> pathVars = new HashMap<>();
    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getTabName()).thenThrow(new UnsupportedOperationException("foo"));
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getFirstTab()).thenReturn(tabMetadata);
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
    Entity entity = new Entity();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.getViewSubRecords(request, pathVars, cmd, entity, new ArrayList<>()));
    verify(cmd, atLeast(1)).getFirstTab();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(tabMetadata).getTabName();
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetViewSubRecords2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    HashMap<String, String> pathVars = new HashMap<>();
    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getTabName()).thenThrow(new UnsupportedOperationException("foo"));
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getFirstTab()).thenReturn(tabMetadata);
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
    Entity entity = new Entity();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> crumbs = new ArrayList<>();
    crumbs.add(sectionCrumb);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.getViewSubRecords(request, pathVars, cmd, entity, crumbs));
    verify(cmd, atLeast(1)).getFirstTab();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(tabMetadata).getTabName();
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetViewSubRecords3() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    HashMap<String, String> pathVars = new HashMap<>();
    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getTabName()).thenThrow(new UnsupportedOperationException("foo"));
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getFirstTab()).thenReturn(tabMetadata);
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
    Entity entity = new Entity();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("tabName");
    sectionCrumb2.setSectionId("tabName");
    sectionCrumb2.setSectionIdentifier("tabName");

    ArrayList<SectionCrumb> crumbs = new ArrayList<>();
    crumbs.add(sectionCrumb2);
    crumbs.add(sectionCrumb);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.getViewSubRecords(request, pathVars, cmd, entity, crumbs));
    verify(cmd, atLeast(1)).getFirstTab();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(tabMetadata).getTabName();
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  public void testResolveAppropriateEntityView() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    MockHttpServletRequest request = new MockHttpServletRequest();
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    ConcurrentModel model = new ConcurrentModel();
    EntityForm entityForm = new EntityForm();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request2,
        model, entityForm);

    // Assert
    assertEquals(2, model.size());
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualResolveAppropriateEntityViewResult);
    assertFalse(entityForm.getReadOnly());
    assertTrue(request2.getTrailerFields().isEmpty());
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    assertTrue(entityForm.getFields().isEmpty());
    assertTrue(model.containsKey("useAjaxUpdate"));
    assertSame(request, request2.getRequest());
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  public void testResolveAppropriateEntityView2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    HttpServletRequestWrapper request = new HttpServletRequestWrapper(
        new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    ConcurrentModel model = new ConcurrentModel();
    EntityForm entityForm = new EntityForm();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request2,
        model, entityForm);

    // Assert
    assertEquals(2, model.size());
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualResolveAppropriateEntityViewResult);
    assertFalse(entityForm.getReadOnly());
    assertTrue(request2.getTrailerFields().isEmpty());
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    assertTrue(entityForm.getFields().isEmpty());
    assertTrue(model.containsKey("useAjaxUpdate"));
    assertSame(request, request2.getRequest());
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  public void testResolveAppropriateEntityView3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    ConcurrentModel model = new ConcurrentModel();
    EntityForm entityForm = new EntityForm();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request2,
        model, entityForm);

    // Assert
    verify(request).getHeader(eq("X-Requested-With"));
    verify(request).getParameter(eq("blcAjax"));
    assertEquals(2, model.size());
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualResolveAppropriateEntityViewResult);
    assertFalse(entityForm.getReadOnly());
    assertTrue(request2.getTrailerFields().isEmpty());
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    assertTrue(entityForm.getFields().isEmpty());
    assertTrue(model.containsKey("useAjaxUpdate"));
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  public void testResolveAppropriateEntityView4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("XMLHttpRequest");
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    ConcurrentModel model = new ConcurrentModel();
    EntityForm entityForm = new EntityForm();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request2,
        model, entityForm);

    // Assert
    verify(request).getHeader(eq("X-Requested-With"));
    verify(request).getParameter(eq("blcAjax"));
    assertEquals(2, model.size());
    assertEquals("modal/entityView", model.get("viewType"));
    assertEquals("modules/modalContainer", actualResolveAppropriateEntityViewResult);
    assertEquals("viewEntity", model.get("modalHeaderType"));
    assertTrue(request2.getTrailerFields().isEmpty());
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    assertTrue(entityForm.getFields().isEmpty());
    assertTrue(entityForm.getReadOnly());
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  public void testResolveAppropriateEntityView5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    when(request.getParameter(Mockito.<String>any())).thenReturn("");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    ConcurrentModel model = new ConcurrentModel();
    EntityForm entityForm = new EntityForm();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request2,
        model, entityForm);

    // Assert
    verify(request).getHeader(eq("X-Requested-With"));
    verify(request).getParameter(eq("blcAjax"));
    assertEquals(2, model.size());
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualResolveAppropriateEntityViewResult);
    assertFalse(entityForm.getReadOnly());
    assertTrue(request2.getTrailerFields().isEmpty());
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    assertTrue(entityForm.getFields().isEmpty());
    assertTrue(model.containsKey("useAjaxUpdate"));
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  public void testResolveAppropriateEntityView6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();
    EntityForm entityForm = new EntityForm();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request,
        model, entityForm);

    // Assert
    assertEquals(2, model.size());
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualResolveAppropriateEntityViewResult);
    assertFalse(entityForm.getReadOnly());
    assertTrue(request.getTrailerFields().isEmpty());
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    assertTrue(entityForm.getFields().isEmpty());
    assertTrue(model.containsKey("useAjaxUpdate"));
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  public void testResolveAppropriateEntityView7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("XMLHttpRequest");
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    ConcurrentModel model = new ConcurrentModel();
    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).setReadOnly();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request2,
        model, entityForm);

    // Assert
    verify(request).getHeader(eq("X-Requested-With"));
    verify(entityForm).setReadOnly();
    verify(request).getParameter(eq("blcAjax"));
    assertEquals(2, model.size());
    assertEquals("modal/entityView", model.get("viewType"));
    assertEquals("modules/modalContainer", actualResolveAppropriateEntityViewResult);
    assertEquals("viewEntity", model.get("modalHeaderType"));
    assertTrue(request2.getTrailerFields().isEmpty());
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#buildSelectizeCustomCriteria()}
   */
  @Test
  public void testBuildSelectizeCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertArrayEquals(new String[]{AdminBasicEntityController.IS_SELECTIZE_REQUEST},
        (new AdminBasicEntityController()).buildSelectizeCustomCriteria());
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}
   */
  @Test
  public void testReinitializeEntityForm() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    EntityForm entityForm = mock(EntityForm.class);
    doThrow(new UnsupportedOperationException("foo")).when(entityForm).clearFieldsMap();

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[]{new Property()});
    collectionMetadata.setSecurityCeilingType("Security Ceiling Type");
    collectionMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();
    HashMap<String, DynamicResultSet> subRecordsMap = new HashMap<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> adminBasicEntityController
        .reinitializeEntityForm(entityForm, collectionMetadata, entity, subRecordsMap, new ArrayList<>()));
    verify(entityForm).clearFieldsMap();
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  public void testAddAuditableDisplayFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminBasicEntityController.addAuditableDisplayFields(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  public void testAddAuditableDisplayFields2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn(null);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminBasicEntityController.addAuditableDisplayFields(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField, atLeast(1)).getValue();
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  public void testGetCurrentTabName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    HashMap<String, String> pathVars = new HashMap<>();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals("General", adminBasicEntityController.getCurrentTabName(pathVars, cmd));
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  public void testGetCurrentTabName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("tabName", "Path Vars");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals("Path Vars", adminBasicEntityController.getCurrentTabName(pathVars, cmd));
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  public void testGetCurrentTabName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    HashMap<String, String> pathVars = new HashMap<>();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getFirstTab()).thenReturn(new TabMetadata());
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

    // Act
    String actualCurrentTabName = adminBasicEntityController.getCurrentTabName(pathVars, cmd);

    // Assert
    verify(cmd).getFirstTab();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    assertNull(actualCurrentTabName);
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  public void testGetCurrentTabName4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    HashMap<String, String> pathVars = new HashMap<>();
    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getTabName()).thenThrow(new UnsupportedOperationException("foo"));
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getFirstTab()).thenReturn(tabMetadata);
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

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.getCurrentTabName(pathVars, cmd));
    verify(cmd).getFirstTab();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(tabMetadata).getTabName();
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}
   */
  @Test
  public void testGetCurrentFolderId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    // Act and Assert
    assertEquals("unassigned",
        adminBasicEntityController.getCurrentFolderId(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}
   */
  @Test
  public void testGetCurrentFolderId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameterMap()).thenReturn(new HashMap<>());

    // Act
    String actualCurrentFolderId = adminBasicEntityController
        .getCurrentFolderId(new JSCompatibilityRequestWrapper(request));

    // Assert
    verify(request).getParameterMap();
    assertEquals("unassigned", actualCurrentFolderId);
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}
   */
  @Test
  public void testGetCurrentFolderId3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    HashMap<String, String[]> stringStringArrayMap = new HashMap<>();
    stringStringArrayMap.put("currentFolderId", new String[]{"currentFolderId"});
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    when(request.getParameterMap()).thenReturn(stringStringArrayMap);

    // Act
    String actualCurrentFolderId = adminBasicEntityController
        .getCurrentFolderId(new JSCompatibilityRequestWrapper(request));

    // Assert
    verify(request).getParameter(eq("currentFolderId"));
    verify(request).getParameterMap();
    assertEquals("https://example.org/example", actualCurrentFolderId);
  }

  /**
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}
   */
  @Test
  public void testGetCurrentFolderId4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    HashMap<String, String[]> stringStringArrayMap = new HashMap<>();
    stringStringArrayMap.put("currentFolderId", new String[]{"currentFolderId"});
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("");
    when(request.getParameterMap()).thenReturn(stringStringArrayMap);

    // Act
    String actualCurrentFolderId = adminBasicEntityController
        .getCurrentFolderId(new JSCompatibilityRequestWrapper(request));

    // Assert
    verify(request).getParameter(eq("currentFolderId"));
    verify(request).getParameterMap();
    assertEquals("", actualCurrentFolderId);
  }
}
