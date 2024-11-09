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
package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AdminSectionImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSectionImpl#setCeilingEntity(String)}
   *   <li>{@link AdminSectionImpl#setDisplayController(String)}
   *   <li>{@link AdminSectionImpl#setDisplayOrder(Integer)}
   *   <li>{@link AdminSectionImpl#setId(Long)}
   *   <li>{@link AdminSectionImpl#setModule(AdminModule)}
   *   <li>{@link AdminSectionImpl#setName(String)}
   *   <li>{@link AdminSectionImpl#setPermissions(List)}
   *   <li>{@link AdminSectionImpl#setSectionKey(String)}
   *   <li>{@link AdminSectionImpl#setUrl(String)}
   *   <li>{@link AdminSectionImpl#setUseDefaultHandler(Boolean)}
   *   <li>{@link AdminSectionImpl#getCeilingEntity()}
   *   <li>{@link AdminSectionImpl#getDisplayController()}
   *   <li>{@link AdminSectionImpl#getDisplayOrder()}
   *   <li>{@link AdminSectionImpl#getId()}
   *   <li>{@link AdminSectionImpl#getModule()}
   *   <li>{@link AdminSectionImpl#getName()}
   *   <li>{@link AdminSectionImpl#getPermissions()}
   *   <li>{@link AdminSectionImpl#getSectionKey()}
   *   <li>{@link AdminSectionImpl#getUrl()}
   *   <li>{@link AdminSectionImpl#getUseDefaultHandler()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();

    // Act
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setId(1L);
    AdminModuleDTO resultModule = new AdminModuleDTO();
    adminSectionImpl.setModule(resultModule);
    adminSectionImpl.setName("Name");
    ArrayList<AdminPermission> permissions = new ArrayList<>();
    adminSectionImpl.setPermissions(permissions);
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    String actualCeilingEntity = adminSectionImpl.getCeilingEntity();
    String actualDisplayController = adminSectionImpl.getDisplayController();
    Integer actualDisplayOrder = adminSectionImpl.getDisplayOrder();
    Long actualId = adminSectionImpl.getId();
    AdminModule actualModule = adminSectionImpl.getModule();
    String actualName = adminSectionImpl.getName();
    List<AdminPermission> actualPermissions = adminSectionImpl.getPermissions();
    String actualSectionKey = adminSectionImpl.getSectionKey();
    String actualUrl = adminSectionImpl.getUrl();
    Boolean actualUseDefaultHandler = adminSectionImpl.getUseDefaultHandler();

    // Assert that nothing has changed
    assertEquals("Ceiling Entity", actualCeilingEntity);
    assertEquals("Display Controller", actualDisplayController);
    assertEquals("Name", actualName);
    assertEquals("Section Key", actualSectionKey);
    assertEquals("https://example.org/example", actualUrl);
    assertEquals(1, actualDisplayOrder.intValue());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualPermissions.isEmpty());
    assertTrue(actualUseDefaultHandler);
    assertSame(permissions, actualPermissions);
    assertSame(resultModule, actualModule);
  }

  /**
   * Test {@link AdminSectionImpl#isFolderable()}.
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor) Module is
   * {@link AdminModuleDTO} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSectionImpl#isFolderable()}
   */
  @Test
  public void testIsFolderable_givenAdminSectionImplModuleIsAdminModuleDTO_thenReturnTrue() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setPermissions(new ArrayList<>());
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setFolderable(true);

    // Act and Assert
    assertTrue(adminSectionImpl.isFolderable());
  }

  /**
   * Test {@link AdminSectionImpl#isFolderable()}.
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor) Module is
   * {@link AdminModule}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSectionImpl#isFolderable()}
   */
  @Test
  public void testIsFolderable_givenAdminSectionImplModuleIsAdminModule_thenReturnTrue() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderedByDefault(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(mock(AdminModule.class));
    adminSectionImpl.setName("Name");
    adminSectionImpl.setPermissions(new ArrayList<>());
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setFolderable(true);

    // Act and Assert
    assertTrue(adminSectionImpl.isFolderable());
  }

  /**
   * Test {@link AdminSectionImpl#isFolderable()}.
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSectionImpl#isFolderable()}
   */
  @Test
  public void testIsFolderable_givenAdminSectionImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AdminSectionImpl()).isFolderable());
  }

  /**
   * Test {@link AdminSectionImpl#setFolderable(boolean)}.
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSectionImpl#setFolderable(boolean)}
   */
  @Test
  public void testSetFolderable_givenAdminSectionImpl() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();

    // Act
    adminSectionImpl.setFolderable(true);

    // Assert
    assertTrue(adminSectionImpl.folderable);
  }

  /**
   * Test {@link AdminSectionImpl#setFolderable(boolean)}.
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor) Module is
   * {@link AdminModule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSectionImpl#setFolderable(boolean)}
   */
  @Test
  public void testSetFolderable_givenAdminSectionImplModuleIsAdminModule() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setModule(mock(AdminModule.class));

    // Act
    adminSectionImpl.setFolderable(true);

    // Assert
    assertTrue(adminSectionImpl.folderable);
  }

  /**
   * Test {@link AdminSectionImpl#isFolderedByDefault()}.
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor) Module is
   * {@link AdminModuleDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSectionImpl#isFolderedByDefault()}
   */
  @Test
  public void testIsFolderedByDefault_givenAdminSectionImplModuleIsAdminModuleDTO() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(new AdminModuleDTO());
    adminSectionImpl.setName("Name");
    adminSectionImpl.setPermissions(new ArrayList<>());
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setFolderedByDefault(true);

    // Act and Assert
    assertTrue(adminSectionImpl.isFolderedByDefault());
  }

  /**
   * Test {@link AdminSectionImpl#isFolderedByDefault()}.
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor) Module is
   * {@link AdminModule}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSectionImpl#isFolderedByDefault()}
   */
  @Test
  public void testIsFolderedByDefault_givenAdminSectionImplModuleIsAdminModule_thenReturnTrue() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setCeilingEntity("Ceiling Entity");
    adminSectionImpl.setDisplayController("Display Controller");
    adminSectionImpl.setDisplayOrder(1);
    adminSectionImpl.setFolderable(true);
    adminSectionImpl.setId(1L);
    adminSectionImpl.setModule(mock(AdminModule.class));
    adminSectionImpl.setName("Name");
    adminSectionImpl.setPermissions(new ArrayList<>());
    adminSectionImpl.setSectionKey("Section Key");
    adminSectionImpl.setUrl("https://example.org/example");
    adminSectionImpl.setUseDefaultHandler(true);
    adminSectionImpl.setFolderedByDefault(true);

    // Act and Assert
    assertTrue(adminSectionImpl.isFolderedByDefault());
  }

  /**
   * Test {@link AdminSectionImpl#isFolderedByDefault()}.
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSectionImpl#isFolderedByDefault()}
   */
  @Test
  public void testIsFolderedByDefault_givenAdminSectionImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AdminSectionImpl()).isFolderedByDefault());
  }

  /**
   * Test {@link AdminSectionImpl#setFolderedByDefault(boolean)}.
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSectionImpl#setFolderedByDefault(boolean)}
   */
  @Test
  public void testSetFolderedByDefault_givenAdminSectionImpl() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();

    // Act
    adminSectionImpl.setFolderedByDefault(true);

    // Assert
    assertTrue(adminSectionImpl.folderedByDefault);
  }

  /**
   * Test {@link AdminSectionImpl#setFolderedByDefault(boolean)}.
   * <ul>
   *   <li>Given {@link AdminSectionImpl} (default constructor) Module is
   * {@link AdminModule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSectionImpl#setFolderedByDefault(boolean)}
   */
  @Test
  public void testSetFolderedByDefault_givenAdminSectionImplModuleIsAdminModule() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    adminSectionImpl.setModule(mock(AdminModule.class));

    // Act
    adminSectionImpl.setFolderedByDefault(true);

    // Assert
    assertTrue(adminSectionImpl.folderedByDefault);
  }

  /**
   * Test new {@link AdminSectionImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AdminSectionImpl}
   */
  @Test
  public void testNewAdminSectionImpl() {
    // Arrange and Act
    AdminSectionImpl actualAdminSectionImpl = new AdminSectionImpl();

    // Assert
    assertNull(actualAdminSectionImpl.folderable);
    assertNull(actualAdminSectionImpl.folderedByDefault);
    assertNull(actualAdminSectionImpl.getDisplayOrder());
    assertNull(actualAdminSectionImpl.getId());
    assertNull(actualAdminSectionImpl.getCeilingEntity());
    assertNull(actualAdminSectionImpl.getDisplayController());
    assertNull(actualAdminSectionImpl.getName());
    assertNull(actualAdminSectionImpl.getSectionKey());
    assertNull(actualAdminSectionImpl.getUrl());
    assertNull(actualAdminSectionImpl.getModule());
    assertTrue(actualAdminSectionImpl.getPermissions().isEmpty());
    assertTrue(actualAdminSectionImpl.getUseDefaultHandler());
  }
}
