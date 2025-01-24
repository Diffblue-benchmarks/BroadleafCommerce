package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DuplicationValidatorExtensionHandlerImplDiffblueTest {
  @Autowired
  private DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl;

  /**
   * Test {@link DuplicationValidatorExtensionHandlerImpl#init()}.
   * <p>
   * Method under test: {@link DuplicationValidatorExtensionHandlerImpl#init()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5851 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DuplicationValidatorExtensionHandlerImpl()).init();
  }

  /**
   * Test {@link DuplicationValidatorExtensionHandlerImpl#getPriority()}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#getPriority()}
   */
  @Test
  public void testGetPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new DuplicationValidatorExtensionHandlerImpl()).getPriority());
  }

  /**
   * Test {@link DuplicationValidatorExtensionHandlerImpl#getPriority()}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#getPriority()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPriority2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5850 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DuplicationValidatorExtensionHandlerImpl()).getPriority();
  }

  /**
   * Test {@link DuplicationValidatorExtensionHandlerImpl#isEnabled()}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new DuplicationValidatorExtensionHandlerImpl()).isEnabled());
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#validateDuplicate(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateDuplicate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5883 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl2 = new DuplicationValidatorExtensionHandlerImpl();

    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act
    duplicationValidatorExtensionHandlerImpl2.validateDuplicate("Entity", resultHolder);
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#validateDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code HANDLED_STOP}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testValidateDuplicate_givenFalse_thenReturnHandledStop() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();
    ExtensionResultHolder<Boolean> resultHolder = mock(ExtensionResultHolder.class);
    when(resultHolder.getResult()).thenReturn(false);
    doNothing().when(resultHolder).setResult(Mockito.<Boolean>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualValidateDuplicateResult = duplicationValidatorExtensionHandlerImpl
        .validateDuplicate("Entity", resultHolder);

    // Assert
    verify(resultHolder).getResult();
    verify(resultHolder, atLeast(1)).setResult(eq(true));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.HANDLED_STOP, actualValidateDuplicateResult);
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#validateDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder}
   * {@link ExtensionResultHolder#getResult()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testValidateDuplicate_whenExtensionResultHolderGetResultReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();
    ExtensionResultHolder<Boolean> resultHolder = mock(ExtensionResultHolder.class);
    when(resultHolder.getResult()).thenReturn(true);
    doNothing().when(resultHolder).setResult(Mockito.<Boolean>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualValidateDuplicateResult = duplicationValidatorExtensionHandlerImpl
        .validateDuplicate("Entity", resultHolder);

    // Assert
    verify(resultHolder).getResult();
    verify(resultHolder, atLeast(1)).setResult(eq(true));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualValidateDuplicateResult);
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#validateDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#validateDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testValidateDuplicate_whenExtensionResultHolderResultIsTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();

    ExtensionResultHolder<Boolean> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(true);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        duplicationValidatorExtensionHandlerImpl.validateDuplicate("Entity", resultHolder));
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#setupDuplicate(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testSetupDuplicate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();

    ExtensionResultHolder<MultiTenantCopyContext> resultHolder = new ExtensionResultHolder<>();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    resultHolder.setResult(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite, genericEntityService,
        new MultiTenantCopierExtensionManager()));
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        duplicationValidatorExtensionHandlerImpl.setupDuplicate("Entity", resultHolder));
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#setupDuplicate(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetupDuplicate2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5852 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl2 = new DuplicationValidatorExtensionHandlerImpl();

    ExtensionResultHolder<MultiTenantCopyContext> resultHolder = new ExtensionResultHolder<>();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    resultHolder.setResult(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite, genericEntityService,
        new MultiTenantCopierExtensionManager()));
    resultHolder.setThrowable(new Throwable());

    // Act
    duplicationValidatorExtensionHandlerImpl2.setupDuplicate("Entity", resultHolder);
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#setupDuplicate(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then calls {@link ExtensionResultHolder#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#setupDuplicate(Object, ExtensionResultHolder)}
   */
  @Test
  public void testSetupDuplicate_thenCallsSetResult() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();
    ExtensionResultHolder<MultiTenantCopyContext> resultHolder = mock(ExtensionResultHolder.class);
    doNothing().when(resultHolder).setResult(Mockito.<MultiTenantCopyContext>any());
    doNothing().when(resultHolder).setThrowable(Mockito.<Throwable>any());
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    resultHolder.setResult(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite, genericEntityService,
        new MultiTenantCopierExtensionManager()));
    resultHolder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualSetupDuplicateResult = duplicationValidatorExtensionHandlerImpl
        .setupDuplicate("Entity", resultHolder);

    // Assert
    verify(resultHolder).setResult(isA(MultiTenantCopyContext.class));
    verify(resultHolder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualSetupDuplicateResult);
  }

  /**
   * Test {@link DuplicationValidatorExtensionHandlerImpl#addToSandbox(Object)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#addToSandbox(Object)}
   */
  @Test
  public void testAddToSandbox() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        (new DuplicationValidatorExtensionHandlerImpl()).addToSandbox("Entity"));
  }

  /**
   * Test {@link DuplicationValidatorExtensionHandlerImpl#addToSandbox(Object)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#addToSandbox(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddToSandbox2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5780 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DuplicationValidatorExtensionHandlerImpl()).addToSandbox("Entity");
  }

  /**
   * Test {@link DuplicationValidatorExtensionHandlerImpl#tearDownDuplicate()}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#tearDownDuplicate()}
   */
  @Test
  public void testTearDownDuplicate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        (new DuplicationValidatorExtensionHandlerImpl()).tearDownDuplicate());
  }

  /**
   * Test {@link DuplicationValidatorExtensionHandlerImpl#tearDownDuplicate()}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#tearDownDuplicate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTearDownDuplicate2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5882 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DuplicationValidatorExtensionHandlerImpl()).tearDownDuplicate();
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        duplicationValidatorExtensionHandlerImpl.getCatalogsForPropagation(context, resultHolder));
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetCatalogsForPropagation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();
    CatalogImpl fromCatalog = mock(CatalogImpl.class);
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        duplicationValidatorExtensionHandlerImpl.getCatalogsForPropagation(context, resultHolder));
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#getCatalogsForPropagation(MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCatalogsForPropagation3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5790 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl2 = new DuplicationValidatorExtensionHandlerImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<List<MultiTenantCopyContext>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new ArrayList<>());
    resultHolder.setThrowable(new Throwable());

    // Act
    duplicationValidatorExtensionHandlerImpl2.getCatalogsForPropagation(context, resultHolder);
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, duplicationValidatorExtensionHandlerImpl
        .getClonesByCatalogs("Table Name", 1L, multiTenantCopyContext, resultHolder));
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  public void testGetClonesByCatalogs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl = new DuplicationValidatorExtensionHandlerImpl();
    CatalogImpl fromCatalog = mock(CatalogImpl.class);
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, duplicationValidatorExtensionHandlerImpl
        .getClonesByCatalogs("Table Name", 1L, multiTenantCopyContext, resultHolder));
  }

  /**
   * Test
   * {@link DuplicationValidatorExtensionHandlerImpl#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link DuplicationValidatorExtensionHandlerImpl#getClonesByCatalogs(String, Long, MultiTenantCopyContext, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetClonesByCatalogs3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5820 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.service.DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DuplicationValidatorExtensionHandlerImpl duplicationValidatorExtensionHandlerImpl2 = new DuplicationValidatorExtensionHandlerImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext multiTenantCopyContext = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    ExtensionResultHolder<Map<Long, Map<Long, Long>>> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(new HashMap<>());
    resultHolder.setThrowable(new Throwable());

    // Act
    duplicationValidatorExtensionHandlerImpl2.getClonesByCatalogs("Table Name", 1L, multiTenantCopyContext,
        resultHolder);
  }
}
