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
package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;

@ContextConfiguration(classes = {AbstractAdminBasicOperationsControllerExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractAdminBasicOperationsControllerExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractAdminBasicOperationsControllerExtensionHandler abstractAdminBasicOperationsControllerExtensionHandler;

  /**
   * Test
   * {@link AbstractAdminBasicOperationsControllerExtensionHandler#buildLookupListGrid(PersistencePackageRequest, ClassMetadata, String, List, Model, MultiValueMap)}.
   * <p>
   * Method under test:
   * {@link AbstractAdminBasicOperationsControllerExtensionHandler#buildLookupListGrid(PersistencePackageRequest, ClassMetadata, String, List, Model, MultiValueMap)}
   */
  @Test
  public void testBuildLookupListGrid() {
    // Arrange
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Original Section Identifier");
    sectionCrumb2.setSectionId("Section Id");
    sectionCrumb2.setSectionIdentifier("Section Identifier");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAdminBasicOperationsControllerExtensionHandler
        .buildLookupListGrid(ppr, cmd, "Owning Class", sectionCrumbs, model, new HttpHeaders()));
  }

  /**
   * Test
   * {@link AbstractAdminBasicOperationsControllerExtensionHandler#buildLookupListGrid(PersistencePackageRequest, ClassMetadata, String, List, Model, MultiValueMap)}.
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor)
   * OriginalSectionIdentifier is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminBasicOperationsControllerExtensionHandler#buildLookupListGrid(PersistencePackageRequest, ClassMetadata, String, List, Model, MultiValueMap)}
   */
  @Test
  public void testBuildLookupListGrid_givenSectionCrumbOriginalSectionIdentifierIs42() {
    // Arrange
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAdminBasicOperationsControllerExtensionHandler
        .buildLookupListGrid(ppr, cmd, "Owning Class", sectionCrumbs, model, new HttpHeaders()));
  }

  /**
   * Test
   * {@link AbstractAdminBasicOperationsControllerExtensionHandler#buildLookupListGrid(PersistencePackageRequest, ClassMetadata, String, List, Model, MultiValueMap)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminBasicOperationsControllerExtensionHandler#buildLookupListGrid(PersistencePackageRequest, ClassMetadata, String, List, Model, MultiValueMap)}
   */
  @Test
  public void testBuildLookupListGrid_whenArrayList() {
    // Arrange
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAdminBasicOperationsControllerExtensionHandler
        .buildLookupListGrid(ppr, cmd, "Owning Class", sectionCrumbs, model, new HttpHeaders()));
  }

  /**
   * Test
   * {@link AbstractAdminBasicOperationsControllerExtensionHandler#buildLookupListGrid(PersistencePackageRequest, ClassMetadata, String, List, Model, MultiValueMap)}.
   * <ul>
   *   <li>When {@link PersistencePackageRequest}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminBasicOperationsControllerExtensionHandler#buildLookupListGrid(PersistencePackageRequest, ClassMetadata, String, List, Model, MultiValueMap)}
   */
  @Test
  public void testBuildLookupListGrid_whenPersistencePackageRequest() {
    // Arrange
    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAdminBasicOperationsControllerExtensionHandler
        .buildLookupListGrid(ppr, cmd, "Owning Class", sectionCrumbs, model, new HttpHeaders()));
  }

  /**
   * Test new {@link AbstractAdminBasicOperationsControllerExtensionHandler}
   * (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractAdminBasicOperationsControllerExtensionHandler}
   */
  @Test
  public void testNewAbstractAdminBasicOperationsControllerExtensionHandler() {
    // Arrange and Act
    AbstractAdminBasicOperationsControllerExtensionHandler actualAbstractAdminBasicOperationsControllerExtensionHandler = new AbstractAdminBasicOperationsControllerExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractAdminBasicOperationsControllerExtensionHandler.getPriority());
    assertTrue(actualAbstractAdminBasicOperationsControllerExtensionHandler.isEnabled());
  }
}
