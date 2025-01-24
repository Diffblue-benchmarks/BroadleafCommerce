package org.broadleafcommerce.openadmin.server.service.persistence.module;

import java.lang.reflect.Field;
import javax.persistence.EntityManager;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldModifierManagerDiffblueTest {
  @Autowired
  private FieldModifierManager fieldModifierManager;

  /**
   * Test {@link FieldModifierManager#getFieldModifierManager()}.
   * <p>
   * Method under test: {@link FieldModifierManager#getFieldModifierManager()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFieldModifierManager() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@11c1a7c5 has not been refreshed yet
    //       at org.broadleafcommerce.openadmin.server.service.persistence.module.FieldModifierManager.getFieldModifierManager(FieldModifierManager.java:48)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    FieldModifierManager.getFieldModifierManager();
  }

  /**
   * Test {@link FieldModifierManager#setApplicationContext(ApplicationContext)}.
   * <p>
   * Method under test:
   * {@link FieldModifierManager#setApplicationContext(ApplicationContext)}
   */
  @Test
  public void testSetApplicationContext() throws BeansException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     FieldModifierManager.applicationContext
    //     FieldModifierManager.fieldManagerModifiers
    //     FieldModifierManager.fieldModifierManager

    // Arrange
    FieldModifierManager fieldModifierManager = new FieldModifierManager();

    // Act
    fieldModifierManager.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
  }

  /**
   * Test
   * {@link FieldModifierManager#getModifiedWriteValue(Field, Object, Object, EntityManager)}.
   * <p>
   * Method under test:
   * {@link FieldModifierManager#getModifiedWriteValue(Field, Object, Object, EntityManager)}
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
    //   public class DiffblueFakeClass1513 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.FieldModifierManager fieldModifierManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FieldModifierManager fieldModifierManager2 = new FieldModifierManager();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);

    // Act
    fieldModifierManager2.getModifiedWriteValue(null, "Value", "New Value",
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)));
  }

  /**
   * Test
   * {@link FieldModifierManager#getModifiedReadValue(Field, Object, EntityManager)}.
   * <p>
   * Method under test:
   * {@link FieldModifierManager#getModifiedReadValue(Field, Object, EntityManager)}
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
    //   public class DiffblueFakeClass1419 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.FieldModifierManager fieldModifierManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FieldModifierManager fieldModifierManager2 = new FieldModifierManager();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);

    // Act
    fieldModifierManager2.getModifiedReadValue(null, "Value",
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)));
  }
}
