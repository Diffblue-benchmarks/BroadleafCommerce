package org.broadleafcommerce.openadmin.server.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.ParentRecordStructure;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.exception.EntityNotFoundException;
import org.broadleafcommerce.openadmin.server.domain.FetchPageRequest;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.DynamicEntityFormInfo;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.hibernate.exception.ConstraintViolationException;
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
public class AdminEntityServiceImplDiffblueTest {
  @Autowired
  private AdminEntityServiceImpl adminEntityServiceImpl;

  /**
   * Test
   * {@link AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getClassMetadata(PersistencePackageRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetClassMetadata() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3109 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    // Act
    adminEntityServiceImpl2.getClassMetadata(PersistencePackageRequest.adorned());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getRecords(PersistencePackageRequest)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecords(PersistencePackageRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRecords() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4816 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    // Act
    adminEntityServiceImpl2.getRecords(PersistencePackageRequest.adorned());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}
   */
  @Test
  public void testGetRecord() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    PersistencePackageRequest request = PersistencePackageRequest.adorned();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getRecord(request, "42", cmd, true));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRecord2() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4505 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();
    PersistencePackageRequest request = PersistencePackageRequest.adorned();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    adminEntityServiceImpl2.getRecord(request, "42", cmd, true);
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddEntity() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1678 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();
    EntityForm entityForm = new EntityForm();

    // Act
    adminEntityServiceImpl2.addEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>());
  }

  /**
   * Test {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#addEntity(EntityForm, String[], List)}
   */
  @Test
  public void testAddEntity_thenThrowConstraintViolationException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getEntityType())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getIdProperty())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getMainEntityName())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.getFields())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(entityForm.findField(Mockito.<String>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));

    HashMap<String, EntityForm> stringEntityFormMap = new HashMap<>();
    stringEntityFormMap.put("foo", entityForm);
    DynamicEntityFormInfo dynamicEntityFormInfo = mock(DynamicEntityFormInfo.class);
    when(dynamicEntityFormInfo.getCustomCriteriaOverride()).thenReturn(new String[]{"Custom Criteria Override"});
    EntityForm entityForm2 = mock(EntityForm.class);
    when(entityForm2.getDynamicFormInfo(Mockito.<String>any())).thenReturn(dynamicEntityFormInfo);
    when(entityForm2.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm2.getEntityType()).thenReturn("");
    when(entityForm2.getId()).thenReturn("42");
    when(entityForm2.getIdProperty()).thenReturn("Id Property");
    when(entityForm2.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm2.getDynamicForms()).thenReturn(stringEntityFormMap);
    when(entityForm2.getFields()).thenReturn(new HashMap<>());
    when(entityForm2.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(entityForm2).setId(Mockito.<String>any());
    entityForm2.setId("[");

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> adminEntityServiceImpl.addEntity(entityForm2, new String[]{"Custom Criteria"}, new ArrayList<>()));
    verify(dynamicEntityFormInfo, atLeast(1)).getCustomCriteriaOverride();
    verify(entityForm2).findField(eq("Id Property"));
    verify(entityForm2, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm2).getDynamicFormInfo(eq("foo"));
    verify(entityForm2).getDynamicForms();
    verify(entityForm2).getEntityType();
    verify(entityForm2, atLeast(1)).getFields();
    verify(entityForm2).getId();
    verify(entityForm2).getIdProperty();
    verify(entityForm).getIdProperty();
    verify(entityForm2).getMainEntityName();
    verify(entityForm2).setId(eq("["));
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  public void testRemoveEntity() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(entityForm).setId(Mockito.<String>any());
    entityForm.setId("[");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Original Section Identifier");
    sectionCrumb2.setSectionId("Section Id");
    sectionCrumb2.setSectionIdentifier("Section Identifier");

    ArrayList<SectionCrumb> sectionCrumb3 = new ArrayList<>();
    sectionCrumb3.add(sectionCrumb2);
    sectionCrumb3.add(sectionCrumb);

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.removeEntity(entityForm, new String[]{"Custom Criteria"}, sectionCrumb3));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).setId(eq("["));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveEntity2() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6461 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();
    EntityForm entityForm = new EntityForm();

    // Act
    adminEntityServiceImpl2.removeEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>());
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor)
   * OriginalSectionIdentifier is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  public void testRemoveEntity_givenSectionCrumbOriginalSectionIdentifierIs42() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(entityForm).setId(Mockito.<String>any());
    entityForm.setId("[");

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.removeEntity(entityForm, new String[]{"Custom Criteria"}, sectionCrumb2));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).setId(eq("["));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeEntity(EntityForm, String[], List)}
   */
  @Test
  public void testRemoveEntity_thenThrowEntityNotFoundException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(entityForm).setId(Mockito.<String>any());
    entityForm.setId("[");

    // Act and Assert
    assertThrows(EntityNotFoundException.class,
        () -> adminEntityServiceImpl.removeEntity(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>()));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).setId(eq("["));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPropertiesFromEntityForm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4470 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    // Act
    adminEntityServiceImpl2.getPropertiesFromEntityForm(new EntityForm());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  public void testGetPropertiesFromEntityForm_givenHashMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());

    // Act
    List<Property> actualPropertiesFromEntityForm = adminEntityServiceImpl.getPropertiesFromEntityForm(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).getFields();
    assertTrue(actualPropertiesFromEntityForm.isEmpty());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}.
   * <ul>
   *   <li>Then return first DisplayValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  public void testGetPropertiesFromEntityForm_thenReturnFirstDisplayValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    Field field = new Field();
    field.setValue("42");

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", field);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);

    // Act
    List<Property> actualPropertiesFromEntityForm = adminEntityServiceImpl.getPropertiesFromEntityForm(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).getFields();
    assertEquals(1, actualPropertiesFromEntityForm.size());
    Property getResult = actualPropertiesFromEntityForm.get(0);
    assertEquals("42", getResult.getDisplayValue());
    assertEquals("42", getResult.getRawValue());
    assertEquals("42", getResult.getUnHtmlEncodedValue());
    assertEquals("42", getResult.getValue());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}.
   * <ul>
   *   <li>Then return first DisplayValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  public void testGetPropertiesFromEntityForm_thenReturnFirstDisplayValueIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", new Field());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);

    // Act
    List<Property> actualPropertiesFromEntityForm = adminEntityServiceImpl.getPropertiesFromEntityForm(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).getFields();
    assertEquals(1, actualPropertiesFromEntityForm.size());
    Property getResult = actualPropertiesFromEntityForm.get(0);
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getPropertiesFromEntityForm(EntityForm)}
   */
  @Test
  public void testGetPropertiesFromEntityForm_whenEntityForm_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    // Act and Assert
    assertTrue(adminEntityServiceImpl.getPropertiesFromEntityForm(new EntityForm()).isEmpty());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm, atLeast(1)).getIdProperty();
    verify(entityForm).getMainEntityName();
    Entity entity = actualRequestForEntityForm.getEntity();
    Map<String, Property> pMap = entity.getPMap();
    assertEquals(1, pMap.size());
    Property getResult = pMap.get("Id Property");
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("42", getResult.getDisplayValue());
    assertEquals("42", getResult.getRawValue());
    assertEquals("42", getResult.getUnHtmlEncodedValue());
    assertEquals("42", getResult.getValue());
    assertEquals("Id Property", getResult.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    Property[] properties = entity.getProperties();
    assertEquals(1, properties.length);
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
    assertSame(getResult, properties[0]);
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

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

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, sectionCrumbs));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRequestForEntityForm3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5938 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();
    EntityForm entityForm = new EntityForm();

    // Act
    adminEntityServiceImpl2.getRequestForEntityForm(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertEquals("Ceiling Entity Classname", actualRequestForEntityForm.getCeilingEntityClassname());
    assertEquals("Ceiling Entity Classname", actualRequestForEntityForm.getSecurityCeilingEntityClassname());
    assertEquals("Main Entity Name", actualRequestForEntityForm.getRequestingEntityName());
    Entity entity = actualRequestForEntityForm.getEntity();
    assertEquals(0, entity.getProperties().length);
    assertTrue(entity.getPMap().isEmpty());
    assertArrayEquals(new String[]{"Ceiling Entity Classname"}, entity.getType());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@code [}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm_givenLeftSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("[", new EntityForm());

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    Map<String, Property> pMap = actualRequestForEntityForm.getEntity().getPMap();
    assertEquals(1, pMap.size());
    Property getResult2 = pMap.get("id");
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult2.getValue());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor)
   * OriginalSectionIdentifier is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm_givenSectionCrumbOriginalSectionIdentifierIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, sectionCrumbs));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm_givenTabMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    Map<String, Property> pMap = actualRequestForEntityForm.getEntity().getPMap();
    assertEquals(1, pMap.size());
    Property getResult2 = pMap.get("id");
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult2.getValue());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then return Entity PMap {@code id} DisplayValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm_thenReturnEntityPMapIdDisplayValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    EntityForm entityForm = new EntityForm();
    entityForm.setId("42");

    // Act and Assert
    Map<String, Property> pMap = adminEntityServiceImpl
        .getRequestForEntityForm(entityForm, new String[]{"Custom Criteria"}, new ArrayList<>())
        .getEntity()
        .getPMap();
    assertEquals(1, pMap.size());
    Property getResult = pMap.get("id");
    assertEquals("42", getResult.getDisplayValue());
    assertEquals("42", getResult.getRawValue());
    assertEquals("42", getResult.getUnHtmlEncodedValue());
    assertEquals("42", getResult.getValue());
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult2 = fields.get("id");
    assertEquals("42", getResult2.getDisplayValue());
    assertEquals("42", getResult2.getValue());
    assertEquals("null/42", getResult2.getEntityViewPath());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then return Entity Type is array of {@link String} with
   * {@code Entity Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm_thenReturnEntityTypeIsArrayOfStringWithEntityType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertEquals("Ceiling Entity Classname", actualRequestForEntityForm.getCeilingEntityClassname());
    assertEquals("Ceiling Entity Classname", actualRequestForEntityForm.getSecurityCeilingEntityClassname());
    assertEquals("Main Entity Name", actualRequestForEntityForm.getRequestingEntityName());
    Entity entity = actualRequestForEntityForm.getEntity();
    assertEquals(0, entity.getProperties().length);
    assertTrue(entity.getPMap().isEmpty());
    assertArrayEquals(new String[]{"Entity Type"}, entity.getType());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm_thenThrowEntityNotFoundException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    CodeField codeField = mock(CodeField.class);
    doThrow(new EntityNotFoundException("foo")).when(codeField).setValue(Mockito.<String>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>()));
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm_whenEntityForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    EntityForm entityForm = new EntityForm();

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(1, fields.size());
    Field getResult = fields.get("id");
    assertEquals("null/null", getResult.getEntityViewPath());
    Map<String, Property> pMap = actualRequestForEntityForm.getEntity().getPMap();
    assertEquals(1, pMap.size());
    Property getResult2 = pMap.get("id");
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult2.getValue());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getValue());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}.
   * <ul>
   *   <li>When {@link EntityForm} {@link EntityForm#getEntityType()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRequestForEntityForm(EntityForm, String[], List)}
   */
  @Test
  public void testGetRequestForEntityForm_whenEntityFormGetEntityTypeReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getEntityType()).thenReturn(null);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.getIdProperty()).thenReturn("Id Property");
    when(entityForm.getMainEntityName()).thenReturn("Main Entity Name");
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    PersistencePackageRequest actualRequestForEntityForm = adminEntityServiceImpl.getRequestForEntityForm(entityForm,
        new String[]{"Custom Criteria"}, new ArrayList<>());

    // Assert
    verify(entityForm).findField(eq("Id Property"));
    verify(entityForm, atLeast(1)).getCeilingEntityClassname();
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).getId();
    verify(entityForm).getIdProperty();
    verify(entityForm).getMainEntityName();
    assertEquals("Ceiling Entity Classname", actualRequestForEntityForm.getCeilingEntityClassname());
    assertEquals("Ceiling Entity Classname", actualRequestForEntityForm.getSecurityCeilingEntityClassname());
    assertEquals("Main Entity Name", actualRequestForEntityForm.getRequestingEntityName());
    Entity entity = actualRequestForEntityForm.getEntity();
    assertEquals(0, entity.getProperties().length);
    assertTrue(entity.getPMap().isEmpty());
    assertArrayEquals(new String[]{"Ceiling Entity Classname"}, entity.getType());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs},
   * {@code alternateId}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   */
  @Test
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateId()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getAdvancedCollectionRecord(containingClassMetadata, containingEntity,
            collectionProperty, "42", new ArrayList<>(), "42"));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).findProperty(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs},
   * {@code alternateId}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   */
  @Test
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateId2()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenThrow(new EntityNotFoundException("."));
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act
    adminEntityServiceImpl.getAdvancedCollectionRecord(containingClassMetadata, containingEntity, collectionProperty,
        "42", new ArrayList<>(), "42");

    // Assert
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).findProperty(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs},
   * {@code alternateId}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   */
  @Test
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateId3()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(property);

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getAdvancedCollectionRecord(containingClassMetadata, containingEntity,
            collectionProperty, "42", new ArrayList<>(), "42"));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).findProperty(eq("id"));
    verify(property).getValue();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs},
   * {@code alternateId}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   */
  @Test
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateId4()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(property);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    OperationTypes operationTypes = new OperationTypes();
    basicCollectionMetadata.setPersistencePerspective(
        new PersistencePerspective(operationTypes, new String[]{"."}, new ForeignKey[]{new ForeignKey()}));
    Property collectionProperty = mock(Property.class);
    when(collectionProperty.getName()).thenReturn("Name");
    when(collectionProperty.getMetadata()).thenReturn(basicCollectionMetadata);
    doNothing().when(collectionProperty).setName(Mockito.<String>any());
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getAdvancedCollectionRecord(containingClassMetadata, containingEntity,
            collectionProperty, "42", new ArrayList<>(), "42"));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).findProperty(eq("id"));
    verify(collectionProperty, atLeast(1)).getMetadata();
    verify(collectionProperty, atLeast(1)).getName();
    verify(property).getValue();
    verify(collectionProperty).setName(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs},
   * {@code alternateId}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateId5()
      throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2180 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    // Act
    adminEntityServiceImpl2.getAdvancedCollectionRecord(containingClassMetadata, containingEntity, collectionProperty,
        "42", new ArrayList<>(), "42");
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs},
   * {@code alternateId}, {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   */
  @Test
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateIdCustomCriteria()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getAdvancedCollectionRecord(containingClassMetadata, containingEntity,
            collectionProperty, "42", new ArrayList<>(), "42", new String[]{"Custom Criteria"}));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).findProperty(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs},
   * {@code alternateId}, {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   */
  @Test
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateIdCustomCriteria2()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenThrow(new EntityNotFoundException("."));
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act
    adminEntityServiceImpl.getAdvancedCollectionRecord(containingClassMetadata, containingEntity, collectionProperty,
        "42", new ArrayList<>(), "42", new String[]{"Custom Criteria"});

    // Assert
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).findProperty(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs},
   * {@code alternateId}, {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   */
  @Test
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateIdCustomCriteria3()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(property);

    Property collectionProperty = new Property();
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getAdvancedCollectionRecord(containingClassMetadata, containingEntity,
            collectionProperty, "42", new ArrayList<>(), "42", new String[]{"Custom Criteria"}));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).findProperty(eq("id"));
    verify(property).getValue();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs},
   * {@code alternateId}, {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   */
  @Test
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateIdCustomCriteria4()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.findProperty(Mockito.<String>any())).thenReturn(property);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    OperationTypes operationTypes = new OperationTypes();
    basicCollectionMetadata.setPersistencePerspective(
        new PersistencePerspective(operationTypes, new String[]{"."}, new ForeignKey[]{new ForeignKey()}));
    Property collectionProperty = mock(Property.class);
    when(collectionProperty.getName()).thenReturn("Name");
    when(collectionProperty.getMetadata()).thenReturn(basicCollectionMetadata);
    doNothing().when(collectionProperty).setName(Mockito.<String>any());
    collectionProperty.setName("id");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getAdvancedCollectionRecord(containingClassMetadata, containingEntity,
            collectionProperty, "42", new ArrayList<>(), "42", new String[]{"Custom Criteria"}));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).findProperty(eq("id"));
    verify(collectionProperty, atLeast(1)).getMetadata();
    verify(collectionProperty, atLeast(1)).getName();
    verify(property).getValue();
    verify(collectionProperty).setName(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code collectionItemId}, {@code sectionCrumbs},
   * {@code alternateId}, {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAdvancedCollectionRecord(ClassMetadata, Entity, Property, String, List, String, String[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAdvancedCollectionRecordWithContainingClassMetadataContainingEntityCollectionPropertyCollectionItemIdSectionCrumbsAlternateIdCustomCriteria5()
      throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2489 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    // Act
    adminEntityServiceImpl2.getAdvancedCollectionRecord(containingClassMetadata, containingEntity, collectionProperty,
        "42", new ArrayList<>(), "42", new String[]{"Custom Criteria"});
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code fascs}, {@code startIndex},
   * {@code maxIndex}, {@code idValueOverride}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)}
   */
  @Test
  public void testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexIdValueOverrideSectionCrumbs()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, "42",
            new ArrayList<>()));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code fascs}, {@code startIndex},
   * {@code maxIndex}, {@code idValueOverride}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)}
   */
  @Test
  public void testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexIdValueOverrideSectionCrumbs2()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, "42",
            new ArrayList<>()));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code fascs}, {@code startIndex},
   * {@code maxIndex}, {@code idValueOverride}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexIdValueOverrideSectionCrumbs3()
      throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5018 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    // Act
    adminEntityServiceImpl2.getRecordsForCollection(containingClassMetadata, containingEntity, collectionProperty,
        new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, "42", new ArrayList<>());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code fascs}, {@code startIndex},
   * {@code maxIndex}, {@code sectionCrumb}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  public void testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexSectionCrumb()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code fascs}, {@code startIndex},
   * {@code maxIndex}, {@code sectionCrumb}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  public void testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexSectionCrumb2()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, new ArrayList<>()));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code fascs}, {@code startIndex},
   * {@code maxIndex}, {@code sectionCrumb}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  public void testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexSectionCrumb3()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getProperties()).thenReturn(new Property[]{new Property(".", "42")});

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setCollectionCeilingEntity("id");
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property collectionProperty = mock(Property.class);
    when(collectionProperty.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    when(collectionProperty.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> adminEntityServiceImpl.getRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, new ArrayList<>()));
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity, atLeast(1)).getProperties();
    verify(collectionProperty, atLeast(1)).getMetadata();
    verify(collectionProperty).getName();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code fascs}, {@code startIndex},
   * {@code maxIndex}, {@code sectionCrumb}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  public void testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexSectionCrumb4()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getProperties()).thenReturn(new Property[]{property});

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setCollectionCeilingEntity("id");
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property collectionProperty = mock(Property.class);
    when(collectionProperty.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    when(collectionProperty.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> adminEntityServiceImpl.getRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, new ArrayList<>()));
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity, atLeast(1)).getProperties();
    verify(collectionProperty, atLeast(1)).getMetadata();
    verify(collectionProperty).getName();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code fascs}, {@code startIndex},
   * {@code maxIndex}, {@code sectionCrumb}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  public void testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexSectionCrumb5()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getPMap()).thenReturn(new HashMap<>());
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("org.broadleafcommerce.openadmin.dto");
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getProperties()).thenReturn(new Property[]{property});

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setCollectionCeilingEntity("id");
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property collectionProperty = mock(Property.class);
    when(collectionProperty.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    when(collectionProperty.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> adminEntityServiceImpl.getRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, new ArrayList<>()));
    verify(containingClassMetadata).getPMap();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity, atLeast(1)).getProperties();
    verify(collectionProperty, atLeast(1)).getMetadata();
    verify(collectionProperty).getName();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   * with {@code containingClassMetadata}, {@code containingEntity},
   * {@code collectionProperty}, {@code fascs}, {@code startIndex},
   * {@code maxIndex}, {@code sectionCrumb}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], Integer, Integer, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRecordsForCollectionWithContainingClassMetadataContainingEntityCollectionPropertyFascsStartIndexMaxIndexSectionCrumb6()
      throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5321 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();

    // Act
    adminEntityServiceImpl2.getRecordsForCollection(containingClassMetadata, containingEntity, collectionProperty,
        new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, 1, 1, new ArrayList<>());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPagedRecordsForCollection() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4164 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    // Act
    adminEntityServiceImpl2.getPagedRecordsForCollection(containingClassMetadata, containingEntity, collectionProperty,
        new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, fetchPageRequest, "42", new ArrayList<>());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}.
   * <ul>
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}
   */
  @Test
  public void testGetPagedRecordsForCollection_whenClassMetadataCeilingTypeIsType() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    ClassMetadata containingClassMetadata = new ClassMetadata();
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getPagedRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, fetchPageRequest, "42",
            new ArrayList<>()));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}.
   * <ul>
   *   <li>When {@link Property#Property()}.</li>
   *   <li>Then calls {@link ClassMetadata#getCeilingType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getPagedRecordsForCollection(ClassMetadata, Entity, Property, FilterAndSortCriteria[], FetchPageRequest, String, List)}
   */
  @Test
  public void testGetPagedRecordsForCollection_whenProperty_thenCallsGetCeilingType() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata containingClassMetadata = mock(ClassMetadata.class);
    when(containingClassMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(containingClassMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(containingClassMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(containingClassMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(containingClassMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    containingClassMetadata.setCeilingType("Type");
    containingClassMetadata.setCurrencyCode("GBP");
    containingClassMetadata.setPolymorphicEntities(new ClassTree());
    containingClassMetadata.setProperties(new Property[]{new Property()});
    containingClassMetadata.setSecurityCeilingType("Security Ceiling Type");
    containingClassMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();
    Property collectionProperty = new Property();
    FetchPageRequest fetchPageRequest = new FetchPageRequest();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> adminEntityServiceImpl.getPagedRecordsForCollection(containingClassMetadata, containingEntity,
            collectionProperty, new FilterAndSortCriteria[]{new FilterAndSortCriteria("42")}, fetchPageRequest, "42",
            new ArrayList<>()));
    verify(containingClassMetadata).getCeilingType();
    verify(containingClassMetadata).setCeilingType(eq("Type"));
    verify(containingClassMetadata).setCurrencyCode(eq("GBP"));
    verify(containingClassMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(containingClassMetadata).setProperties(isA(Property[].class));
    verify(containingClassMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(containingClassMetadata).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)}
   * with {@code ppr}, {@code containingEntity}, {@code sectionCrumb}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntitySectionCrumb() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4946 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    Entity containingEntity = new Entity();

    // Act
    adminEntityServiceImpl2.getRecordsForAllSubCollections(ppr, containingEntity, new ArrayList<>());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)}
   * with {@code ppr}, {@code containingEntity}, {@code startIndex},
   * {@code maxIndex}, {@code sectionCrumb}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForAllSubCollections(PersistencePackageRequest, Entity, Integer, Integer, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRecordsForAllSubCollectionsWithPprContainingEntityStartIndexMaxIndexSectionCrumb()
      throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4865 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    Entity containingEntity = new Entity();

    // Act
    adminEntityServiceImpl2.getRecordsForAllSubCollections(ppr, containingEntity, 1, 1, new ArrayList<>());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  public void testGetRecordsForSelectedTab() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
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
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Original Section Identifier");
    sectionCrumb2.setSectionId("Section Id");
    sectionCrumb2.setSectionIdentifier("Section Identifier");

    ArrayList<SectionCrumb> sectionCrumb3 = new ArrayList<>();
    sectionCrumb3.add(sectionCrumb2);
    sectionCrumb3.add(sectionCrumb);

    // Act
    Map<String, DynamicResultSet> actualRecordsForSelectedTab = adminEntityServiceImpl.getRecordsForSelectedTab(cmd,
        containingEntity, sectionCrumb3, "Current Tab Name");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRecordsForSelectedTab2() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5626 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();

    // Act
    adminEntityServiceImpl2.getRecordsForSelectedTab(cmd, containingEntity, new ArrayList<>(), "Current Tab Name");
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}.
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property()} and
   * {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  public void testGetRecordsForSelectedTab_givenArrayOfPropertyWithPropertyAndProperty() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
    Property property = new Property();
    when(cmd.getProperties()).thenReturn(new Property[]{property, new Property()});
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
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForSelectedTab = adminEntityServiceImpl.getRecordsForSelectedTab(cmd,
        containingEntity, new ArrayList<>(), "Current Tab Name");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity, atLeast(1)).getType();
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}.
   * <ul>
   *   <li>Given empty array of {@link Property}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  public void testGetRecordsForSelectedTab_givenEmptyArrayOfProperty() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{});
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
    Entity containingEntity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualRecordsForSelectedTab = adminEntityServiceImpl.getRecordsForSelectedTab(cmd,
        containingEntity, new ArrayList<>(), "Current Tab Name");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}.
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor)
   * OriginalSectionIdentifier is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  public void testGetRecordsForSelectedTab_givenSectionCrumbOriginalSectionIdentifierIs42() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
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
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act
    Map<String, DynamicResultSet> actualRecordsForSelectedTab = adminEntityServiceImpl.getRecordsForSelectedTab(cmd,
        containingEntity, sectionCrumb2, "Current Tab Name");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}.
   * <ul>
   *   <li>Then calls {@link FieldMetadata#getAvailableToTypes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getRecordsForSelectedTab(ClassMetadata, Entity, List, String)}
   */
  @Test
  public void testGetRecordsForSelectedTab_thenCallsGetAvailableToTypes() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
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
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    // Act
    Map<String, DynamicResultSet> actualRecordsForSelectedTab = adminEntityServiceImpl.getRecordsForSelectedTab(cmd,
        containingEntity, new ArrayList<>(), "Current Tab Name");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualRecordsForSelectedTab.isEmpty());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetAllRecordsForAllSubCollections() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
    Property property = new Property();
    when(cmd.getProperties()).thenReturn(new Property[]{property, new Property()});
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
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    // Act
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections = adminEntityServiceImpl
        .getAllRecordsForAllSubCollections(cmd, containingEntity, new ArrayList<>());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity, atLeast(1)).getType();
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetAllRecordsForAllSubCollections2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
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
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumb2 = new ArrayList<>();
    sectionCrumb2.add(sectionCrumb);

    // Act
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections = adminEntityServiceImpl
        .getAllRecordsForAllSubCollections(cmd, containingEntity, sectionCrumb2);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetAllRecordsForAllSubCollections3() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
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
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Original Section Identifier");
    sectionCrumb2.setSectionId("Section Id");
    sectionCrumb2.setSectionIdentifier("Section Identifier");

    ArrayList<SectionCrumb> sectionCrumb3 = new ArrayList<>();
    sectionCrumb3.add(sectionCrumb2);
    sectionCrumb3.add(sectionCrumb);

    // Act
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections = adminEntityServiceImpl
        .getAllRecordsForAllSubCollections(cmd, containingEntity, sectionCrumb3);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAllRecordsForAllSubCollections4() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2795 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = new Entity();

    // Act
    adminEntityServiceImpl2.getAllRecordsForAllSubCollections(cmd, containingEntity, new ArrayList<>());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}.
   * <ul>
   *   <li>Given empty array of {@link Property}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetAllRecordsForAllSubCollections_givenEmptyArrayOfProperty() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{});
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
    Entity containingEntity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections = adminEntityServiceImpl
        .getAllRecordsForAllSubCollections(cmd, containingEntity, new ArrayList<>());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}.
   * <ul>
   *   <li>Then calls {@link FieldMetadata#getAvailableToTypes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getAllRecordsForAllSubCollections(ClassMetadata, Entity, List)}
   */
  @Test
  public void testGetAllRecordsForAllSubCollections_thenCallsGetAvailableToTypes() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
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
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity containingEntity = mock(Entity.class);
    when(containingEntity.getType()).thenReturn(new String[]{"Type"});

    // Act
    Map<String, DynamicResultSet> actualAllRecordsForAllSubCollections = adminEntityServiceImpl
        .getAllRecordsForAllSubCollections(cmd, containingEntity, new ArrayList<>());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(containingEntity).getType();
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(actualAllRecordsForAllSubCollections.isEmpty());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  public void testAddSubCollectionEntity() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("The specified field [%s] for class [%s] was not a collection field.", new EntityForm());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  public void testAddSubCollectionEntity2() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("The specified field [%s] for class [%s] was not a collection field.", new Field());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>()));
    verify(entityForm, atLeast(1)).getFields();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddSubCollectionEntity3() throws ClassNotFoundException, ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1739 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();
    EntityForm entityForm = new EntityForm();

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act
    adminEntityServiceImpl2.addSubCollectionEntity(entityForm, mainMetadata, field, parentEntity, new ArrayList<>());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <ul>
   *   <li>Given {@code Ceiling Type}.</li>
   *   <li>When {@link Property#Property()}.</li>
   *   <li>Then calls {@link ClassMetadata#getCeilingType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  public void testAddSubCollectionEntity_givenCeilingType_whenProperty_thenCallsGetCeilingType()
      throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    when(mainMetadata.getCeilingType()).thenReturn("Ceiling Type");
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>()));
    verify(mainMetadata).getCeilingType();
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(entityForm, atLeast(1)).getFields();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  public void testAddSubCollectionEntity_givenTabMetadata() throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <ul>
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is
   * {@code Type}.</li>
   *   <li>Then calls {@link EntityForm#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  public void testAddSubCollectionEntity_whenClassMetadataCeilingTypeIsType_thenCallsGetFields()
      throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>()));
    verify(entityForm, atLeast(1)).getFields();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#addSubCollectionEntity(EntityForm, ClassMetadata, Property, Entity, List)}
   */
  @Test
  public void testAddSubCollectionEntity_whenEntityForm_thenThrowIllegalArgumentException()
      throws ClassNotFoundException, ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    EntityForm entityForm = new EntityForm();

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> adminEntityServiceImpl.addSubCollectionEntity(entityForm,
        mainMetadata, field, parentEntity, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   * with {@code mainMetadata}, {@code field}, {@code parentEntity},
   * {@code itemId}, {@code alternateId}, {@code priorKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntityWithMainMetadataFieldParentEntityItemIdAlternateIdPriorKeySectionCrumbs()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = mock(Property.class);
    when(field.getMetadata()).thenThrow(new EntityNotFoundException("."));
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata, field, parentEntity, "42", "42", "Prior Key",
        new ArrayList<>());

    // Assert
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(parentEntity).findProperty(eq("id"));
    verify(field).getMetadata();
    verify(field).getName();
    verify(field).setName(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   * with {@code mainMetadata}, {@code field}, {@code parentEntity},
   * {@code itemId}, {@code alternateId}, {@code priorKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntityWithMainMetadataFieldParentEntityItemIdAlternateIdPriorKeySectionCrumbs2()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{new Property(".", "42")});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata, field,
        parentEntity, "42", "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity, atLeast(1)).getProperties();
    verify(field).getName();
    verify(field).setName(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   * with {@code mainMetadata}, {@code field}, {@code parentEntity},
   * {@code itemId}, {@code alternateId}, {@code priorKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntityWithMainMetadataFieldParentEntityItemIdAlternateIdPriorKeySectionCrumbs3()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{property});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata, field,
        parentEntity, "42", "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity, atLeast(1)).getProperties();
    verify(field).getName();
    verify(property, atLeast(1)).getName();
    verify(field).setName(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   * with {@code mainMetadata}, {@code field}, {@code parentEntity},
   * {@code itemId}, {@code alternateId}, {@code priorKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntityWithMainMetadataFieldParentEntityItemIdAlternateIdPriorKeySectionCrumbs4()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("\\.");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new EntityNotFoundException("."));
    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{property2});
    when(parentEntity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata,
        field, parentEntity, "42", "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity).findProperty(eq("id"));
    verify(parentEntity).getProperties();
    verify(field).getName();
    verify(property2).getName();
    verify(property).getValue();
    verify(field).setName(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   * with {@code mainMetadata}, {@code field}, {@code parentEntity},
   * {@code itemId}, {@code alternateId}, {@code priorKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntityWithMainMetadataFieldParentEntityItemIdAlternateIdPriorKeySectionCrumbs5()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    when(mainMetadata.getPMap()).thenReturn(new HashMap<>());
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("org.broadleafcommerce.openadmin.dto");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{property});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata, field,
        parentEntity, "42", "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).getPMap();
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity, atLeast(1)).getProperties();
    verify(field).getName();
    verify(property, atLeast(1)).getName();
    verify(field).setName(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   * with {@code mainMetadata}, {@code field}, {@code parentEntity},
   * {@code itemId}, {@code alternateId}, {@code priorKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveSubCollectionEntityWithMainMetadataFieldParentEntityItemIdAlternateIdPriorKeySectionCrumbs6()
      throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6522 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act
    adminEntityServiceImpl2.removeSubCollectionEntity(mainMetadata, field, parentEntity, "42", "42", "Prior Key",
        new ArrayList<>());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   * with {@code mainMetadata}, {@code field}, {@code parentEntity},
   * {@code itemId}, {@code priorKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntityWithMainMetadataFieldParentEntityItemIdPriorKeySectionCrumbs()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = mock(Property.class);
    when(field.getMetadata()).thenThrow(new EntityNotFoundException("."));
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata, field, parentEntity, "42", "Prior Key",
        new ArrayList<>());

    // Assert
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(parentEntity).findProperty(eq("id"));
    verify(field).getMetadata();
    verify(field).getName();
    verify(field).setName(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   * with {@code mainMetadata}, {@code field}, {@code parentEntity},
   * {@code itemId}, {@code priorKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntityWithMainMetadataFieldParentEntityItemIdPriorKeySectionCrumbs2()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{new Property(".", "42")});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata, field,
        parentEntity, "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity, atLeast(1)).getProperties();
    verify(field).getName();
    verify(field).setName(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   * with {@code mainMetadata}, {@code field}, {@code parentEntity},
   * {@code itemId}, {@code priorKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntityWithMainMetadataFieldParentEntityItemIdPriorKeySectionCrumbs3()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{property});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata, field,
        parentEntity, "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity, atLeast(1)).getProperties();
    verify(field).getName();
    verify(property, atLeast(1)).getName();
    verify(field).setName(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   * with {@code mainMetadata}, {@code field}, {@code parentEntity},
   * {@code itemId}, {@code priorKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntityWithMainMetadataFieldParentEntityItemIdPriorKeySectionCrumbs4()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("\\.");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new EntityNotFoundException("."));
    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{property2});
    when(parentEntity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata,
        field, parentEntity, "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity).findProperty(eq("id"));
    verify(parentEntity).getProperties();
    verify(field).getName();
    verify(property2).getName();
    verify(property).getValue();
    verify(field).setName(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   * with {@code mainMetadata}, {@code field}, {@code parentEntity},
   * {@code itemId}, {@code priorKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  public void testRemoveSubCollectionEntityWithMainMetadataFieldParentEntityItemIdPriorKeySectionCrumbs5()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata mainMetadata = mock(ClassMetadata.class);
    when(mainMetadata.getPMap()).thenReturn(new HashMap<>());
    doNothing().when(mainMetadata).setCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setCurrencyCode(Mockito.<String>any());
    doNothing().when(mainMetadata).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(mainMetadata).setProperties(Mockito.<Property[]>any());
    doNothing().when(mainMetadata).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(mainMetadata).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    doNothing().when(field).setName(Mockito.<String>any());
    field.setName("id");

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.ADORNEDTARGETLIST,
        new AdornedTargetList());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("org.broadleafcommerce.openadmin.dto");
    Entity parentEntity = mock(Entity.class);
    when(parentEntity.getProperties()).thenReturn(new Property[]{property});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminEntityServiceImpl.removeSubCollectionEntity(mainMetadata, field,
        parentEntity, "42", "Prior Key", new ArrayList<>()));
    verify(mainMetadata).getPMap();
    verify(mainMetadata).setCeilingType(eq("Type"));
    verify(mainMetadata).setCurrencyCode(eq("GBP"));
    verify(mainMetadata).setPolymorphicEntities(isA(ClassTree.class));
    verify(mainMetadata).setProperties(isA(Property[].class));
    verify(mainMetadata).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(mainMetadata).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(parentEntity, atLeast(1)).getProperties();
    verify(field).getName();
    verify(property, atLeast(1)).getName();
    verify(field).setName(eq("id"));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   * with {@code mainMetadata}, {@code field}, {@code parentEntity},
   * {@code itemId}, {@code priorKey}, {@code sectionCrumbs}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#removeSubCollectionEntity(ClassMetadata, Property, Entity, String, String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveSubCollectionEntityWithMainMetadataFieldParentEntityItemIdPriorKeySectionCrumbs6()
      throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6829 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    ClassMetadata mainMetadata = new ClassMetadata();
    mainMetadata.setCeilingType("Type");
    mainMetadata.setCurrencyCode("GBP");
    mainMetadata.setPolymorphicEntities(new ClassTree());
    mainMetadata.setProperties(new Property[]{new Property()});
    mainMetadata.setSecurityCeilingType("Security Ceiling Type");
    mainMetadata.setTabAndGroupMetadata(new HashMap<>());
    Property field = new Property();
    Entity parentEntity = new Entity();

    // Act
    adminEntityServiceImpl2.removeSubCollectionEntity(mainMetadata, field, parentEntity, "42", "Prior Key",
        new ArrayList<>());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property(".", "42")});

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity, "java.lang.Integer"));
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity, atLeast(1)).getProperties();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetContextSpecificRelationshipId2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3158 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    adminEntityServiceImpl2.getContextSpecificRelationshipId(cmd, new Entity(), "Property Name");
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}.
   * <ul>
   *   <li>Given {@link EntityNotFoundException#EntityNotFoundException(String)}
   * with s is {@code .}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId_givenEntityNotFoundExceptionWithSIsDot() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getPMap()).thenThrow(new EntityNotFoundException("."));
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
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("java.lang");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});

    // Act
    adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity, "java.lang.Integer");

    // Assert
    verify(cmd).getPMap();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity, atLeast(1)).getProperties();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId_givenPropertyGetNameReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity, "java.lang.Integer"));
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity, atLeast(1)).getProperties();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId_givenPropertyGetValueReturn42_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    String actualContextSpecificRelationshipId = adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity,
        "Property Name");

    // Assert
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity).findProperty(eq("id"));
    verify(property).getValue();
    assertEquals("42", actualContextSpecificRelationshipId);
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId_givenProperty_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    String actualContextSpecificRelationshipId = adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity,
        "Property Name");

    // Assert
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity).findProperty(eq("id"));
    assertNull(actualContextSpecificRelationshipId);
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}.
   * <ul>
   *   <li>When {@link ClassMetadata} {@link ClassMetadata#getPMap()} return
   * {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId_whenClassMetadataGetPMapReturnHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getPMap()).thenReturn(new HashMap<>());
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
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("java.lang");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity, "java.lang.Integer"));
    verify(cmd).getPMap();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity, atLeast(1)).getProperties();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId_whenDot_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
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
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    String actualContextSpecificRelationshipId = adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity,
        ".");

    // Assert
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity).findProperty(eq("id"));
    verify(property).getValue();
    assertEquals("42", actualContextSpecificRelationshipId);
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}.
   * <ul>
   *   <li>When {@code java.lang}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getContextSpecificRelationshipId(ClassMetadata, Entity, String)}
   */
  @Test
  public void testGetContextSpecificRelationshipId_whenJavaLang_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getPMap()).thenReturn(new HashMap<>());
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
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("java.lang");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property2});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    String actualContextSpecificRelationshipId = adminEntityServiceImpl.getContextSpecificRelationshipId(cmd, entity,
        "java.lang");

    // Assert
    verify(cmd).getPMap();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity).findProperty(eq("id"));
    verify(entity).getProperties();
    verify(property2, atLeast(1)).getName();
    verify(property).getValue();
    assertEquals("42", actualContextSpecificRelationshipId);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenReturn("Ceiling Type");
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

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(cmd).getCeilingType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIdProperty2() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3848 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    adminEntityServiceImpl2.getIdProperty(cmd);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata}
   * {@link BasicFieldMetadata#getFieldType()} return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty_givenBasicFieldMetadataGetFieldTypeReturnUnknown() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenReturn("Ceiling Type");
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
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(basicFieldMetadata).getFieldType();
    verify(cmd).getCeilingType();
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
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link EntityNotFoundException#EntityNotFoundException(String)}
   * with s is {@code Could not determine ID field for}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty_givenEntityNotFoundExceptionWithSIsCouldNotDetermineIdFieldFor()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenThrow(new EntityNotFoundException("Could not determine ID field for "));
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
    adminEntityServiceImpl.getIdProperty(cmd);

    // Assert
    verify(cmd).getCeilingType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return
   * {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty_givenPropertyGetMetadataReturnAdornedTargetCollectionMetadata()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenReturn("Ceiling Type");
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
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(cmd).getCeilingType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return
   * {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty_givenPropertyGetMetadataReturnBasicFieldMetadata() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenReturn("Ceiling Type");
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
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(cmd).getCeilingType();
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
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code .}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty_givenPropertyGetNameReturnDot_thenCallsGetName() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn(".");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getCeilingType()).thenReturn("Ceiling Type");
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
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(basicFieldMetadata).getFieldType();
    verify(cmd).getCeilingType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty_givenPropertyGetNameReturnName_thenReturnName() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
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
    String actualIdProperty = adminEntityServiceImpl.getIdProperty(cmd);

    // Assert
    verify(basicFieldMetadata).getFieldType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
    assertEquals("Name", actualIdProperty);
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>Then throw {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty_thenThrowEntityNotFoundException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);
    Property property = mock(Property.class);
    when(property.getName()).thenThrow(new EntityNotFoundException("."));
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
    assertThrows(EntityNotFoundException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
    verify(basicFieldMetadata).getFieldType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}.
   * <ul>
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is
   * {@code Type}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getIdProperty(ClassMetadata)}
   */
  @Test
  public void testGetIdProperty_whenClassMetadataCeilingTypeIsType_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminEntityServiceImpl.getIdProperty(cmd));
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest)} with
   * {@code request}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#add(PersistencePackageRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithRequest() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1579 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    // Act
    adminEntityServiceImpl2.add(PersistencePackageRequest.adorned());
  }

  /**
   * Test {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   * with {@code request}, {@code transactional}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#add(PersistencePackageRequest, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithRequestTransactional() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1628 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    // Act
    adminEntityServiceImpl2.add(PersistencePackageRequest.adorned(), true);
  }

  /**
   * Test {@link AdminEntityServiceImpl#inspect(PersistencePackageRequest)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#inspect(PersistencePackageRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInspect() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5999 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    // Act
    adminEntityServiceImpl2.inspect(PersistencePackageRequest.adorned());
  }

  /**
   * Test {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)} with
   * {@code request}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#remove(PersistencePackageRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveWithRequest() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6362 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    // Act
    adminEntityServiceImpl2.remove(PersistencePackageRequest.adorned());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   * with {@code request}, {@code transactional}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#remove(PersistencePackageRequest, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveWithRequestTransactional() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6411 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    // Act
    adminEntityServiceImpl2.remove(PersistencePackageRequest.adorned(), true);
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  public void testEnsureEntityMarkedAsValidationFailure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ValidationException e = new ValidationException(new Entity());

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    List<String> globalValidationErrors = e.getEntity().getGlobalValidationErrors();
    assertEquals(1, globalValidationErrors.size());
    assertNull(globalValidationErrors.get(0));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  public void testEnsureEntityMarkedAsValidationFailure2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    ValidationException e = new ValidationException(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    verify(entity).isValidationFailure();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  public void testEnsureEntityMarkedAsValidationFailure3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ValidationException e = mock(ValidationException.class);
    when(e.containsCause(Mockito.<Class<Throwable>>any())).thenReturn(true);
    when(e.getEntity()).thenReturn(new Entity());

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    verify(e).containsCause(isA(Class.class));
    verify(e).getEntity();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  public void testEnsureEntityMarkedAsValidationFailure4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    Entity entity = new Entity();
    entity.addValidationError("Field Name", "An error occurred");
    ValidationException e = mock(ValidationException.class);
    when(e.containsCause(Mockito.<Class<Throwable>>any())).thenReturn(false);
    when(e.getEntity()).thenReturn(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    verify(e).containsCause(isA(Class.class));
    verify(e).getEntity();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  public void testEnsureEntityMarkedAsValidationFailure5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();

    Entity entity = new Entity();
    entity.addGlobalValidationError("An error occurred");
    ValidationException e = mock(ValidationException.class);
    when(e.containsCause(Mockito.<Class<Throwable>>any())).thenReturn(false);
    when(e.getEntity()).thenReturn(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    verify(e).containsCause(isA(Class.class));
    verify(e).getEntity();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEnsureEntityMarkedAsValidationFailure6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2056 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();
    ValidationException e = new ValidationException(new Entity());

    // Act
    adminEntityServiceImpl2.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}.
   * <ul>
   *   <li>Then calls {@link Entity#addGlobalValidationError(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  public void testEnsureEntityMarkedAsValidationFailure_thenCallsAddGlobalValidationError() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(false);
    doNothing().when(entity).addGlobalValidationError(Mockito.<String>any());
    doNothing().when(entity).setValidationFailure(anyBoolean());
    ValidationException e = new ValidationException(entity);

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    verify(entity).addGlobalValidationError(isNull());
    verify(entity).isValidationFailure();
    verify(entity).setValidationFailure(eq(true));
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}.
   * <ul>
   *   <li>Then calls {@link Throwable#getMessage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#ensureEntityMarkedAsValidationFailure(ValidationException, PersistencePackageRequest)}
   */
  @Test
  public void testEnsureEntityMarkedAsValidationFailure_thenCallsGetMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    ValidationException e = mock(ValidationException.class);
    when(e.getMessage()).thenThrow(new EntityNotFoundException("foo"));
    when(e.containsCause(Mockito.<Class<Throwable>>any())).thenReturn(false);
    when(e.getEntity()).thenReturn(new Entity());

    // Act
    adminEntityServiceImpl.ensureEntityMarkedAsValidationFailure(e, PersistencePackageRequest.adorned());

    // Assert
    verify(e).getMessage();
    verify(e).containsCause(isA(Class.class));
    verify(e, atLeast(1)).getEntity();
  }

  /**
   * Test {@link AdminEntityServiceImpl#fetch(PersistencePackageRequest)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#fetch(PersistencePackageRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFetch() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2131 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();

    // Act
    adminEntityServiceImpl2.fetch(PersistencePackageRequest.adorned());
  }

  /**
   * Test {@link AdminEntityServiceImpl#getDefaultCto()}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getDefaultCto()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultCto() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3471 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminEntityServiceImpl()).getDefaultCto();
  }

  /**
   * Test {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetForeignEntityName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3805 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminEntityServiceImpl()).getForeignEntityName("Owning Class", "42");
  }

  /**
   * Test {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}
   */
  @Test
  public void testGetForeignEntityName_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminEntityServiceImpl()).getForeignEntityName(null, null));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}.
   * <ul>
   *   <li>When {@code Owning Class}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#getForeignEntityName(String, String)}
   */
  @Test
  public void testGetForeignEntityName_whenOwningClass_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdminEntityServiceImpl()).getForeignEntityName("Owning Class", null));
  }

  /**
   * Test {@link AdminEntityServiceImpl#getDynamicEntityDao(String)}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getDynamicEntityDao(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDynamicEntityDao() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3481 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminEntityServiceImpl()).getDynamicEntityDao("Owning Class");
  }

  /**
   * Test {@link AdminEntityServiceImpl#getDefaultMaxResults()}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#getDefaultMaxResults()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultMaxResults() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3476 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminEntityServiceImpl()).getDefaultMaxResults();
  }

  /**
   * Test {@link AdminEntityServiceImpl#clearEntityManager()}.
   * <p>
   * Method under test: {@link AdminEntityServiceImpl#clearEntityManager()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearEntityManager() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2051 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminEntityServiceImpl()).clearEntityManager();
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#populateParentRecordStructure(PersistencePackage, Entity, ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#populateParentRecordStructure(PersistencePackage, Entity, ClassMetadata)}
   */
  @Test
  public void testPopulateParentRecordStructure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    Entity entity = new Entity();
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");

    Entity entity2 = new Entity();

    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    ClassTree polymorphicEntities = new ClassTree();
    parentMetadata.setPolymorphicEntities(polymorphicEntities);
    parentMetadata.setProperties(new Property[]{new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    parentMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act
    adminEntityServiceImpl.populateParentRecordStructure(persistencePackage, entity2, parentMetadata);

    // Assert
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePackage
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult = persistencePerspectiveItems
        .get(PersistencePerspectiveItemType.PARENTRECORDSTRUCTURE);
    assertTrue(getResult instanceof ParentRecordStructure);
    assertSame(tabAndGroupMetadata, parentMetadata.getTabAndGroupMetadata());
    assertSame(parentMetadata, ((ParentRecordStructure) getResult).getParentMetadata());
    assertSame(polymorphicEntities, parentMetadata.getPolymorphicEntities());
    assertSame(entity2, ((ParentRecordStructure) getResult).getParentRecord());
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#populateParentRecordStructure(PersistencePackage, Entity, ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#populateParentRecordStructure(PersistencePackage, Entity, ClassMetadata)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateParentRecordStructure2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6048 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.AdminEntityServiceImpl adminEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl2 = new AdminEntityServiceImpl();
    PersistencePackage persistencePackage = new PersistencePackage();
    Entity entity = new Entity();

    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[]{new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());

    // Act
    adminEntityServiceImpl2.populateParentRecordStructure(persistencePackage, entity, parentMetadata);
  }

  /**
   * Test
   * {@link AdminEntityServiceImpl#populateParentRecordStructure(PersistencePackage, Entity, ClassMetadata)}.
   * <ul>
   *   <li>Then {@link ClassMetadata} (default constructor) PMap size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminEntityServiceImpl#populateParentRecordStructure(PersistencePackage, Entity, ClassMetadata)}
   */
  @Test
  public void testPopulateParentRecordStructure_thenClassMetadataPMapSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminEntityServiceImpl adminEntityServiceImpl = new AdminEntityServiceImpl();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    Entity entity = new Entity();

    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    ClassTree polymorphicEntities = new ClassTree();
    parentMetadata.setPolymorphicEntities(polymorphicEntities);
    parentMetadata.setProperties(new Property[]{new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());

    // Act
    adminEntityServiceImpl.populateParentRecordStructure(persistencePackage, entity, parentMetadata);

    // Assert
    verify(persistencePackage).getPersistencePerspective();
    Map<String, Property> pMap = parentMetadata.getPMap();
    assertEquals(1, pMap.size());
    assertEquals(1, parentMetadata.getProperties().length);
    assertTrue(pMap.containsKey(null));
    assertTrue(parentMetadata.getTabAndGroupMetadata().isEmpty());
    assertSame(polymorphicEntities, parentMetadata.getPolymorphicEntities());
  }
}
