package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.lang.reflect.Field;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.presentation.AdminPresentation;
import org.broadleafcommerce.common.presentation.RequiredOverride;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class OracleRequiredFieldManagerModifierDiffblueTest {
  @Autowired
  private OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier;

  /**
   * Test
   * {@link OracleRequiredFieldManagerModifier#canHandle(Field, Object, EntityManager)}.
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#canHandle(Field, Object, EntityManager)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandle() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2584 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier2 = new OracleRequiredFieldManagerModifier();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);

    // Act
    oracleRequiredFieldManagerModifier2.canHandle(null, "Value",
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)));
  }

  /**
   * Test
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}.
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsRequiredField() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2881 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OracleRequiredFieldManagerModifier()).isRequiredField(mock(AdminPresentation.class), null);
  }

  /**
   * Test
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}
   */
  @Test
  public void testIsRequiredField_given42_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier = new OracleRequiredFieldManagerModifier();
    AdminPresentation adminPresentation = mock(AdminPresentation.class);
    when(adminPresentation.defaultValue()).thenReturn("42");
    when(adminPresentation.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);

    // Act
    boolean actualIsRequiredFieldResult = oracleRequiredFieldManagerModifier.isRequiredField(adminPresentation, null);

    // Assert
    verify(adminPresentation).defaultValue();
    verify(adminPresentation).requiredOverride();
    assertFalse(actualIsRequiredFieldResult);
  }

  /**
   * Test
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}
   */
  @Test
  public void testIsRequiredField_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier = new OracleRequiredFieldManagerModifier();
    AdminPresentation adminPresentation = mock(AdminPresentation.class);
    when(adminPresentation.defaultValue()).thenReturn("");
    when(adminPresentation.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);

    // Act
    boolean actualIsRequiredFieldResult = oracleRequiredFieldManagerModifier.isRequiredField(adminPresentation, null);

    // Assert
    verify(adminPresentation).defaultValue();
    verify(adminPresentation).requiredOverride();
    assertTrue(actualIsRequiredFieldResult);
  }

  /**
   * Test
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}.
   * <ul>
   *   <li>Given {@code NOT_REQUIRED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}
   */
  @Test
  public void testIsRequiredField_givenNotRequired() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier = new OracleRequiredFieldManagerModifier();
    AdminPresentation adminPresentation = mock(AdminPresentation.class);
    when(adminPresentation.defaultValue()).thenReturn("42");
    when(adminPresentation.requiredOverride()).thenReturn(RequiredOverride.NOT_REQUIRED);

    // Act
    boolean actualIsRequiredFieldResult = oracleRequiredFieldManagerModifier.isRequiredField(adminPresentation, null);

    // Assert
    verify(adminPresentation).defaultValue();
    verify(adminPresentation).requiredOverride();
    assertFalse(actualIsRequiredFieldResult);
  }

  /**
   * Test
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}.
   * <ul>
   *   <li>When {@link AdminPresentation} {@link AdminPresentation#defaultValue()}
   * return {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#isRequiredField(AdminPresentation, Column)}
   */
  @Test
  public void testIsRequiredField_whenAdminPresentationDefaultValueReturnNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier = new OracleRequiredFieldManagerModifier();
    AdminPresentation adminPresentation = mock(AdminPresentation.class);
    when(adminPresentation.defaultValue()).thenReturn(null);
    when(adminPresentation.requiredOverride()).thenReturn(RequiredOverride.REQUIRED);

    // Act
    boolean actualIsRequiredFieldResult = oracleRequiredFieldManagerModifier.isRequiredField(adminPresentation, null);

    // Assert
    verify(adminPresentation).defaultValue();
    verify(adminPresentation).requiredOverride();
    assertTrue(actualIsRequiredFieldResult);
  }

  /**
   * Test
   * {@link OracleRequiredFieldManagerModifier#isStringFieldType(Field, AdminPresentation)}.
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#isStringFieldType(Field, AdminPresentation)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsStringFieldType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2882 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OracleRequiredFieldManagerModifier()).isStringFieldType(null, mock(AdminPresentation.class));
  }

  /**
   * Test
   * {@link OracleRequiredFieldManagerModifier#isStringFieldType(Field, AdminPresentation)}.
   * <ul>
   *   <li>Given {@code ID}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#isStringFieldType(Field, AdminPresentation)}
   */
  @Test
  public void testIsStringFieldType_givenId_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier = new OracleRequiredFieldManagerModifier();
    AdminPresentation adminPresentation = mock(AdminPresentation.class);
    when(adminPresentation.fieldType()).thenReturn(SupportedFieldType.ID);

    // Act
    boolean actualIsStringFieldTypeResult = oracleRequiredFieldManagerModifier.isStringFieldType(null,
        adminPresentation);

    // Assert
    verify(adminPresentation).fieldType();
    assertFalse(actualIsStringFieldTypeResult);
  }

  /**
   * Test
   * {@link OracleRequiredFieldManagerModifier#isStringFieldType(Field, AdminPresentation)}.
   * <ul>
   *   <li>Given {@code STRING}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#isStringFieldType(Field, AdminPresentation)}
   */
  @Test
  public void testIsStringFieldType_givenString_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier = new OracleRequiredFieldManagerModifier();
    AdminPresentation adminPresentation = mock(AdminPresentation.class);
    when(adminPresentation.fieldType()).thenReturn(SupportedFieldType.STRING);

    // Act
    boolean actualIsStringFieldTypeResult = oracleRequiredFieldManagerModifier.isStringFieldType(null,
        adminPresentation);

    // Assert
    verify(adminPresentation).fieldType();
    assertTrue(actualIsStringFieldTypeResult);
  }

  /**
   * Test
   * {@link OracleRequiredFieldManagerModifier#getModifiedWriteValue(Field, Object, Object, EntityManager)}.
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#getModifiedWriteValue(Field, Object, Object, EntityManager)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetModifiedWriteValue() throws IllegalAccessException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2774 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier2 = new OracleRequiredFieldManagerModifier();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);

    // Act
    oracleRequiredFieldManagerModifier2.getModifiedWriteValue(null, "Value", "New Value",
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)));
  }

  /**
   * Test
   * {@link OracleRequiredFieldManagerModifier#getModifiedReadValue(Field, Object, EntityManager)}.
   * <p>
   * Method under test:
   * {@link OracleRequiredFieldManagerModifier#getModifiedReadValue(Field, Object, EntityManager)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetModifiedReadValue() throws IllegalAccessException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2679 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier2 = new OracleRequiredFieldManagerModifier();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);

    // Act
    oracleRequiredFieldManagerModifier2.getModifiedReadValue(null, "Value",
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)));
  }

  /**
   * Test {@link OracleRequiredFieldManagerModifier#getOrder()}.
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1000, (new OracleRequiredFieldManagerModifier()).getOrder());
  }

  /**
   * Test {@link OracleRequiredFieldManagerModifier#getOrder()}.
   * <p>
   * Method under test: {@link OracleRequiredFieldManagerModifier#getOrder()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOrder2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2880 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.OracleRequiredFieldManagerModifier oracleRequiredFieldManagerModifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OracleRequiredFieldManagerModifier()).getOrder();
  }
}
