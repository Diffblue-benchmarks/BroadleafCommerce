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
package org.broadleafcommerce.openadmin.web.controller.entity;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
import javax.servlet.ServletRequest;
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
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return array of {@link String} with {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  public void testGetCustomCriteria_givenArrayList_thenReturnArrayOfStringWithNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put(AdminBasicEntityController.CUSTOM_CRITERIA, new ArrayList<>());

    // Act and Assert
    assertArrayEquals(new String[]{null}, adminBasicEntityController.getCustomCriteria(requestParams));
  }

  /**
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  public void testGetCustomCriteria_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminBasicEntityController.getCustomCriteria(requestParams));
  }

  /**
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()}
   * {@link AdminBasicEntityController#CUSTOM_CRITERIA} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  public void testGetCustomCriteria_givenNull_whenHashMapCustom_criteriaIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put(AdminBasicEntityController.CUSTOM_CRITERIA, null);

    // Act and Assert
    assertArrayEquals(new String[]{null}, adminBasicEntityController.getCustomCriteria(requestParams));
  }

  /**
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code Request Params}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  public void testGetCustomCriteria_thenReturnArrayOfStringWithRequestParams() {
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
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  public void testGetCustomCriteria_whenHashMap_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    // Act and Assert
    assertNull(adminBasicEntityController.getCustomCriteria(new HashMap<>()));
  }

  /**
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  public void testGetCustomCriteria_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminBasicEntityController()).getCustomCriteria(null));
  }

  /**
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  public void testIsNotReadOnly() {
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
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getReadOnly()}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  public void testIsNotReadOnly_givenBasicFieldMetadataGetReadOnlyReturnFalse() {
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
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getReadOnly()}
   * return {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  public void testIsNotReadOnly_givenBasicFieldMetadataGetReadOnlyReturnTrue_thenReturnFalse() {
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
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return
   * {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  public void testIsNotReadOnly_givenPropertyGetMetadataReturnAdornedTargetCollectionMetadata() {
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
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return
   * {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  public void testIsNotReadOnly_givenPropertyGetMetadataReturnBasicFieldMetadata() {
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
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  public void testIsNotReadOnly_thenThrowUnsupportedOperationException() {
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
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   * <ul>
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is
   * {@code Type}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  public void testIsNotReadOnly_whenClassMetadataCeilingTypeIsType_thenReturnTrue() {
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
   * Test
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}
   */
  @Test
  public void testDetermineEntityType() throws UnsupportedEncodingException {
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
   * Test
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}
   */
  @Test
  public void testDetermineEntityType_thenThrowUnsupportedOperationException() throws UnsupportedEncodingException {
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
   * Test
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}.
   * <ul>
   *   <li>When {@code Entity Type}.</li>
   *   <li>Then return {@code Entity Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}
   */
  @Test
  public void testDetermineEntityType_whenEntityType_thenReturnEntityType() throws UnsupportedEncodingException {
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
   * Test
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}.
   * <ul>
   *   <li>When {@code Entity Type}.</li>
   *   <li>Then return {@code Entity Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}
   */
  @Test
  public void testDetermineEntityType_whenEntityType_thenReturnEntityType2() throws UnsupportedEncodingException {
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
   * Test
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}
   */
  @Test
  public void testDetermineEntityType_whenNull_thenReturnNull() throws UnsupportedEncodingException {
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
   * Test
   * {@link AdminBasicEntityController#getErrorDuplicatingResponse(HttpServletResponse, String)}.
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#getErrorDuplicatingResponse(HttpServletResponse, String)}
   */
  @Test
  public void testGetErrorDuplicatingResponse() throws UnsupportedEncodingException {
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
   * Test
   * {@link AdminBasicEntityController#getErrorDuplicatingResponse(HttpServletResponse, String)}.
   * <ul>
   *   <li>Given {@link AdminBasicEntityController} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#getErrorDuplicatingResponse(HttpServletResponse, String)}
   */
  @Test
  public void testGetErrorDuplicatingResponse_givenAdminBasicEntityController() throws UnsupportedEncodingException {
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
   * Test
   * {@link AdminBasicEntityController#getErrorDuplicatingResponse(HttpServletResponse, String)}.
   * <ul>
   *   <li>Then calls {@link EntityForm#findField(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#getErrorDuplicatingResponse(HttpServletResponse, String)}
   */
  @Test
  public void testGetErrorDuplicatingResponse_thenCallsFindField() throws UnsupportedEncodingException {
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
   * Test
   * {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}.
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor)
   * OriginalSectionIdentifier is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetViewSubRecords_givenSectionCrumbOriginalSectionIdentifierIs42() throws Exception {
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
   * Test
   * {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}.
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor)
   * OriginalSectionIdentifier is {@code tabName}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetViewSubRecords_givenSectionCrumbOriginalSectionIdentifierIsTabName() throws Exception {
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
   * Test
   * {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetViewSubRecords_thenThrowUnsupportedOperationException() throws Exception {
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
   * Test
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}.
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  public void testResolveAppropriateEntityView() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
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
    assertTrue(model.containsKey("useAjaxUpdate"));
  }

  /**
   * Test
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}.
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  public void testResolveAppropriateEntityView2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request,
        model, new EntityForm());

    // Assert
    ServletRequest request2 = request.getRequest();
    assertTrue(request2 instanceof HttpServletRequestWrapper);
    assertTrue(((HttpServletRequestWrapper) request2).getRequest() instanceof JSCompatibilityRequestWrapper);
    assertEquals(2, model.size());
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualResolveAppropriateEntityViewResult);
    assertTrue(model.containsKey("useAjaxUpdate"));
  }

  /**
   * Test
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}.
   * <p>
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
    assertTrue(model.containsKey("useAjaxUpdate"));
  }

  /**
   * Test
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  public void testResolveAppropriateEntityView_givenEmptyString() {
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
    assertTrue(model.containsKey("useAjaxUpdate"));
  }

  /**
   * Test
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}.
   * <ul>
   *   <li>Given {@code XMLHttpRequest}.</li>
   *   <li>Then {@link EntityForm} (default constructor) ReadOnly.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  public void testResolveAppropriateEntityView_givenXMLHttpRequest_thenEntityFormReadOnly() {
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
    assertTrue(entityForm.getReadOnly());
  }

  /**
   * Test
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}.
   * <ul>
   *   <li>Then calls {@link EntityForm#setReadOnly()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  public void testResolveAppropriateEntityView_thenCallsSetReadOnly() {
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
  }

  /**
   * Test
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  public void testResolveAppropriateEntityView_whenMockHttpServletRequest() {
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
    assertTrue(model.containsKey("useAjaxUpdate"));
  }

  /**
   * Test {@link AdminBasicEntityController#buildSelectizeCustomCriteria()}.
   * <p>
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
   * Test
   * {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}
   */
  @Test
  public void testReinitializeEntityForm_thenThrowUnsupportedOperationException() throws ServiceException {
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
   * Test
   * {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#getValue()} return
   * {@code null}.</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  public void testAddAuditableDisplayFields_givenCodeFieldGetValueReturnNull_thenCallsGetValue() {
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
   * Test
   * {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return
   * {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  public void testAddAuditableDisplayFields_givenField_whenEntityFormFindFieldReturnField() {
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
   * Test
   * {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  public void testGetCurrentTabName_givenTabMetadata_thenReturnNull() {
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
   * Test
   * {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}.
   * <ul>
   *   <li>Given {@code tabName}.</li>
   *   <li>Then return {@code Path Vars}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  public void testGetCurrentTabName_givenTabName_thenReturnPathVars() {
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
   * Test
   * {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  public void testGetCurrentTabName_thenThrowUnsupportedOperationException() {
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
   * Test
   * {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}.
   * <ul>
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is
   * {@code Type}.</li>
   *   <li>Then return {@code General}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  public void testGetCurrentTabName_whenClassMetadataCeilingTypeIsType_thenReturnGeneral() {
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
   * Test
   * {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}
   */
  @Test
  public void testGetCurrentFolderId_givenEmptyString_thenReturnEmptyString() {
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

  /**
   * Test
   * {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code unassigned}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}
   */
  @Test
  public void testGetCurrentFolderId_givenHashMap_thenReturnUnassigned() {
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
   * Test
   * {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}
   */
  @Test
  public void testGetCurrentFolderId_thenReturnHttpsExampleOrgExample() {
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
   * Test
   * {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code unassigned}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}
   */
  @Test
  public void testGetCurrentFolderId_thenReturnUnassigned() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    // Act and Assert
    assertEquals("unassigned",
        adminBasicEntityController.getCurrentFolderId(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));
  }
}
