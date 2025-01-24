package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.config.domain.SystemPropertyImpl;
import org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.common.util.dao.TQRestriction;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.ValidationException;
import org.broadleafcommerce.openadmin.server.service.persistence.ParentEntityPersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaConversionException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslator;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPath;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.FilterValueConverter;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.predicate.PredicateProvider;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.BasicFieldPersistenceProvider;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.FieldPersistenceProvider;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.BeanValidationEntityValidatorServiceImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.EntityValidatorService;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
public class BasicPersistenceModuleDiffblueTest {
  @Autowired
  private BasicPersistenceModule basicPersistenceModule;

  /**
   * Test {@link BasicPersistenceModule#init()}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#init()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5583 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicPersistenceModule()).init();
  }

  /**
   * Test {@link BasicPersistenceModule#isCompatible(OperationType)}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act and Assert
    assertTrue(basicPersistenceModule.isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link BasicPersistenceModule#isCompatible(OperationType)}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsCompatible2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5595 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicPersistenceModule()).isCompatible(OperationType.NONDESTRUCTIVEREMOVE);
  }

  /**
   * Test {@link BasicPersistenceModule#isCompatible(OperationType)}.
   * <ul>
   *   <li>Given {@link AdornedTargetListPersistenceModule} (default
   * constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible_givenAdornedTargetListPersistenceModule_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new AdornedTargetListPersistenceModule()).isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link BasicPersistenceModule#isCompatible(OperationType)}.
   * <ul>
   *   <li>Given {@link BasicPersistenceModule} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible_givenBasicPersistenceModule_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BasicPersistenceModule()).isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link BasicPersistenceModule#isCompatible(OperationType)}.
   * <ul>
   *   <li>Given {@link BasicPersistenceModule} (default constructor).</li>
   *   <li>When {@link OperationType#BASIC}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible_givenBasicPersistenceModule_whenBasic_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BasicPersistenceModule()).isCompatible(OperationType.BASIC));
  }

  /**
   * Test {@link BasicPersistenceModule#isCompatible(OperationType)}.
   * <ul>
   *   <li>When {@code ADORNEDTARGETLIST}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible_whenAdornedtargetlist_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BasicPersistenceModule()).isCompatible(OperationType.ADORNEDTARGETLIST));
  }

  /**
   * Test {@link BasicPersistenceModule#getFieldManager()}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getFieldManager()}
   */
  @Test
  public void testGetFieldManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    FieldManager actualFieldManager = basicPersistenceModule.getFieldManager();

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
    assertSame(fieldManager, actualFieldManager);
  }

  /**
   * Test {@link BasicPersistenceModule#getFieldManager()}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getFieldManager()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFieldManager2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3321 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicPersistenceModule()).getFieldManager();
  }

  /**
   * Test {@link BasicPersistenceModule#getFieldManager(boolean)} with
   * {@code boolean}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getFieldManager(boolean)}
   */
  @Test
  public void testGetFieldManagerWithBoolean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    when(dynamicEntityDaoImpl.getFieldManager(anyBoolean())).thenReturn(fieldManager);
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    FieldManager actualFieldManager = basicPersistenceModule.getFieldManager(true);

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager(eq(true));
    verify(persistenceManager).getDynamicEntityDao();
    assertSame(fieldManager, actualFieldManager);
  }

  /**
   * Test {@link BasicPersistenceModule#getFieldManager(boolean)} with
   * {@code boolean}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getFieldManager(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFieldManagerWithBoolean2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3333 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicPersistenceModule()).getFieldManager(true);
  }

  /**
   * Test {@link BasicPersistenceModule#getFieldManager(boolean)} with
   * {@code boolean}.
   * <ul>
   *   <li>Then return {@link FieldManager#entityManager} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getFieldManager(boolean)}
   */
  @Test
  public void testGetFieldManagerWithBoolean_thenReturnEntityManagerIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    FieldManager actualFieldManager = basicPersistenceModule.getFieldManager(true);

    // Assert
    verify(persistenceManager).getDynamicEntityDao();
    assertNull(actualFieldManager.entityManager);
    assertNull(actualFieldManager.getEntityConfiguration());
    assertTrue(actualFieldManager.middleFields.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFieldManager()}.
   * <ul>
   *   <li>Then return {@link FieldManager#entityManager} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getFieldManager()}
   */
  @Test
  public void testGetFieldManager_thenReturnEntityManagerIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    FieldManager actualFieldManager = basicPersistenceModule.getFieldManager();

    // Assert
    verify(persistenceManager).getDynamicEntityDao();
    assertNull(actualFieldManager.entityManager);
    assertNull(actualFieldManager.getEntityConfiguration());
    assertTrue(actualFieldManager.middleFields.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getDecimalFormatter()}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getDecimalFormatter()}
   */
  @Test
  public void testGetDecimalFormatter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act
    DecimalFormat actualDecimalFormatter = basicPersistenceModule.getDecimalFormatter();

    // Assert
    assertEquals("", actualDecimalFormatter.getNegativeSuffix());
    assertEquals("", actualDecimalFormatter.getPositivePrefix());
    assertEquals("", actualDecimalFormatter.getPositiveSuffix());
    assertEquals("#0.########", actualDecimalFormatter.toLocalizedPattern());
    assertEquals("#0.########", actualDecimalFormatter.toPattern());
    assertEquals("-", actualDecimalFormatter.getNegativePrefix());
    Currency currency = actualDecimalFormatter.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    DecimalFormatSymbols decimalFormatSymbols = actualDecimalFormatter.getDecimalFormatSymbols();
    assertEquals("E", decimalFormatSymbols.getExponentSeparator());
    assertEquals("GBP", decimalFormatSymbols.getInternationalCurrencySymbol());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    assertEquals("£", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("£", currency.getSymbol());
    assertEquals("∞", decimalFormatSymbols.getInfinity());
    assertEquals('#', decimalFormatSymbols.getDigit());
    assertEquals('%', decimalFormatSymbols.getPercent());
    assertEquals(',', decimalFormatSymbols.getGroupingSeparator());
    assertEquals('-', decimalFormatSymbols.getMinusSign());
    assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    assertEquals('.', decimalFormatSymbols.getMonetaryDecimalSeparator());
    assertEquals('0', decimalFormatSymbols.getZeroDigit());
    assertEquals(';', decimalFormatSymbols.getPatternSeparator());
    assertEquals('‰', decimalFormatSymbols.getPerMill());
    assertEquals(0, actualDecimalFormatter.getGroupingSize());
    assertEquals(0, actualDecimalFormatter.getMinimumFractionDigits());
    assertEquals(1, actualDecimalFormatter.getMinimumIntegerDigits());
    assertEquals(1, actualDecimalFormatter.getMultiplier());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(8, actualDecimalFormatter.getMaximumFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, actualDecimalFormatter.getRoundingMode());
    assertFalse(actualDecimalFormatter.isDecimalSeparatorAlwaysShown());
    assertFalse(actualDecimalFormatter.isParseBigDecimal());
    assertFalse(actualDecimalFormatter.isGroupingUsed());
    assertFalse(actualDecimalFormatter.isParseIntegerOnly());
    assertEquals(Integer.MAX_VALUE, actualDecimalFormatter.getMaximumIntegerDigits());
    assertSame(currency, decimalFormatSymbols.getCurrency());
  }

  /**
   * Test {@link BasicPersistenceModule#getDecimalFormatter()}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getDecimalFormatter()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDecimalFormatter2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3309 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicPersistenceModule()).getDecimalFormatter();
  }

  /**
   * Test {@link BasicPersistenceModule#getDecimalFormatter()}.
   * <ul>
   *   <li>Given {@link BasicPersistenceModule} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getDecimalFormatter()}
   */
  @Test
  public void testGetDecimalFormatter_givenBasicPersistenceModule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    DecimalFormat actualDecimalFormatter = (new BasicPersistenceModule()).getDecimalFormatter();

    // Assert
    assertEquals("", actualDecimalFormatter.getNegativeSuffix());
    assertEquals("", actualDecimalFormatter.getPositivePrefix());
    assertEquals("", actualDecimalFormatter.getPositiveSuffix());
    assertEquals("#0.########", actualDecimalFormatter.toLocalizedPattern());
    assertEquals("#0.########", actualDecimalFormatter.toPattern());
    assertEquals("-", actualDecimalFormatter.getNegativePrefix());
    Currency currency = actualDecimalFormatter.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    DecimalFormatSymbols decimalFormatSymbols = actualDecimalFormatter.getDecimalFormatSymbols();
    assertEquals("E", decimalFormatSymbols.getExponentSeparator());
    assertEquals("GBP", decimalFormatSymbols.getInternationalCurrencySymbol());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    assertEquals("£", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("£", currency.getSymbol());
    assertEquals("∞", decimalFormatSymbols.getInfinity());
    assertEquals('#', decimalFormatSymbols.getDigit());
    assertEquals('%', decimalFormatSymbols.getPercent());
    assertEquals(',', decimalFormatSymbols.getGroupingSeparator());
    assertEquals('-', decimalFormatSymbols.getMinusSign());
    assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    assertEquals('.', decimalFormatSymbols.getMonetaryDecimalSeparator());
    assertEquals('0', decimalFormatSymbols.getZeroDigit());
    assertEquals(';', decimalFormatSymbols.getPatternSeparator());
    assertEquals('‰', decimalFormatSymbols.getPerMill());
    assertEquals(0, actualDecimalFormatter.getGroupingSize());
    assertEquals(0, actualDecimalFormatter.getMinimumFractionDigits());
    assertEquals(1, actualDecimalFormatter.getMinimumIntegerDigits());
    assertEquals(1, actualDecimalFormatter.getMultiplier());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(8, actualDecimalFormatter.getMaximumFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, actualDecimalFormatter.getRoundingMode());
    assertFalse(actualDecimalFormatter.isDecimalSeparatorAlwaysShown());
    assertFalse(actualDecimalFormatter.isParseBigDecimal());
    assertFalse(actualDecimalFormatter.isGroupingUsed());
    assertFalse(actualDecimalFormatter.isParseIntegerOnly());
    assertEquals(Integer.MAX_VALUE, actualDecimalFormatter.getMaximumIntegerDigits());
    assertSame(currency, decimalFormatSymbols.getCurrency());
  }

  /**
   * Test {@link BasicPersistenceModule#getSimpleDateFormatter()}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getSimpleDateFormatter()}
   */
  @Test
  public void testGetSimpleDateFormatter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act
    SimpleDateFormat actualSimpleDateFormatter = basicPersistenceModule.getSimpleDateFormatter();

    // Assert
    NumberFormat numberFormat = actualSimpleDateFormatter.getNumberFormat();
    assertTrue(numberFormat instanceof DecimalFormat);
    Calendar calendar = actualSimpleDateFormatter.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals("", ((DecimalFormat) numberFormat).getNegativeSuffix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositivePrefix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositiveSuffix());
    assertEquals("###0", ((DecimalFormat) numberFormat).toLocalizedPattern());
    assertEquals("###0", ((DecimalFormat) numberFormat).toPattern());
    assertEquals("-", ((DecimalFormat) numberFormat).getNegativePrefix());
    Currency currency = numberFormat.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormat).getDecimalFormatSymbols();
    assertEquals("E", decimalFormatSymbols.getExponentSeparator());
    assertEquals("GBP", decimalFormatSymbols.getInternationalCurrencySymbol());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    DateFormatSymbols dateFormatSymbols = actualSimpleDateFormatter.getDateFormatSymbols();
    assertEquals("GyMdkHmsSEDFwWahKzZ", dateFormatSymbols.getLocalPatternChars());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    assertEquals("£", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("£", currency.getSymbol());
    assertEquals("∞", decimalFormatSymbols.getInfinity());
    assertEquals("gregory", calendar.getCalendarType());
    assertEquals("yyyy.MM.dd HH:mm:ss", actualSimpleDateFormatter.toPattern());
    assertEquals('#', decimalFormatSymbols.getDigit());
    assertEquals('%', decimalFormatSymbols.getPercent());
    assertEquals(',', decimalFormatSymbols.getGroupingSeparator());
    assertEquals('-', decimalFormatSymbols.getMinusSign());
    assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    assertEquals('.', decimalFormatSymbols.getMonetaryDecimalSeparator());
    assertEquals('0', decimalFormatSymbols.getZeroDigit());
    assertEquals(';', decimalFormatSymbols.getPatternSeparator());
    assertEquals('‰', decimalFormatSymbols.getPerMill());
    assertNull(actualSimpleDateFormatter.getTimeZone());
    assertNull(calendar.getTimeZone());
    assertEquals(0, numberFormat.getMaximumFractionDigits());
    assertEquals(0, numberFormat.getMinimumFractionDigits());
    assertEquals(1, ((DecimalFormat) numberFormat).getMultiplier());
    assertEquals(1, numberFormat.getMinimumIntegerDigits());
    assertEquals(2, calendar.getFirstDayOfWeek());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(3, ((DecimalFormat) numberFormat).getGroupingSize());
    assertEquals(4, calendar.getMinimalDaysInFirstWeek());
    String[][] zoneStrings = dateFormatSymbols.getZoneStrings();
    assertEquals(601, zoneStrings.length);
    assertEquals(826, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, numberFormat.getRoundingMode());
    assertFalse(((DecimalFormat) numberFormat).isDecimalSeparatorAlwaysShown());
    assertFalse(((DecimalFormat) numberFormat).isParseBigDecimal());
    assertFalse(numberFormat.isGroupingUsed());
    assertTrue(actualSimpleDateFormatter.isLenient());
    assertTrue(numberFormat.isParseIntegerOnly());
    assertTrue(calendar.isLenient());
    assertTrue(calendar.isWeekDateSupported());
    assertEquals(Integer.MAX_VALUE, numberFormat.getMaximumIntegerDigits());
    assertSame(currency, decimalFormatSymbols.getCurrency());
    assertArrayEquals(new String[]{"BC", "AD"}, dateFormatSymbols.getEras());
    assertArrayEquals(new String[]{"am", "pm"}, dateFormatSymbols.getAmPmStrings());
    assertArrayEquals(new String[]{"Africa/Cairo", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[9]);
    assertArrayEquals(new String[]{"Africa/Casablanca", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[1]);
    assertArrayEquals(new String[]{"Africa/El_Aaiun", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[8]);
    assertArrayEquals(new String[]{"America/Argentina/Buenos_Aires", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[598]);
    assertArrayEquals(new String[]{"America/Argentina/ComodRivadavia", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[587]);
    assertArrayEquals(new String[]{"America/Ensenada", "Pacific Standard Time", "GMT-08:00", "Pacific Daylight Time",
        "GMT-07:00", "Pacific Time", "GMT-08:00"}, zoneStrings[581]);
    assertArrayEquals(new String[]{"America/Nuuk", "Western Greenland Time", "WGT", "Western Greenland Summer Time",
        "WGST", "Western Greenland Time", "WGT"}, zoneStrings[590]);
    assertArrayEquals(new String[]{"America/Rosario", "Argentina Standard Time", "ART", "Argentina Summer Time", "ARST",
        "Argentina Time", "ART"}, zoneStrings[595]);
    assertArrayEquals(new String[]{"America/Virgin", "Atlantic Standard Time", "GMT-04:00", "Atlantic Daylight Time",
        "GMT-04:00", "Atlantic Time", "GMT-04:00"}, zoneStrings[582]);
    assertArrayEquals(new String[]{"Asia/Famagusta", "Eastern European Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[588]);
    assertArrayEquals(new String[]{"Asia/Gaza", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[12]);
    assertArrayEquals(new String[]{"Asia/Nicosia", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[5]);
    assertArrayEquals(new String[]{"Asia/Srednekolymsk", "Srednekolymsk Time", "SRET", "Srednekolymsk Daylight Time",
        "SREDT", "Srednekolymsk Time", "SRET"}, zoneStrings[597]);
    assertArrayEquals(new String[]{"Asia/Ulaanbaatar", "Ulan Bator Standard Time", "ULAT", "Ulan Bator Summer Time",
        "ULAST", "Ulan Bator Time", "ULAT"}, zoneStrings[17]);
    assertArrayEquals(new String[]{"Atlantic/Canary", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[20]);
    assertArrayEquals(new String[]{"Atlantic/Faeroe", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[Short.SIZE]);
    assertArrayEquals(new String[]{"Australia/Darwin", "Australian Central Standard Time", "ACST",
        "Australian Central Daylight Time", "ACDT", "Central Australia Time", "ACT"}, zoneStrings[15]);
    assertArrayEquals(new String[]{"Canada/Saskatchewan", "Central Standard Time", "GMT-06:00", "Central Daylight Time",
        "GMT-06:00", "Central Time", "GMT-06:00"}, zoneStrings[594]);
    assertArrayEquals(new String[]{"EET", "Eastern European Time", "EET", "Eastern European Summer Time", "EEST",
        "Eastern European Time", "EET"}, zoneStrings[593]);
    assertArrayEquals(new String[]{"Egypt", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[596]);
    assertArrayEquals(new String[]{"Etc/Greenwich", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT",
        "Greenwich Mean Time", "GMT"}, zoneStrings[580]);
    assertArrayEquals(new String[]{"Europe/Astrakhan", "Astrakhan Standard Time", "GMT+04:00",
        "Astrakhan Standard Time", "GMT+04:00", "Astrakhan Time", "GMT+04:00"}, zoneStrings[579]);
    assertArrayEquals(new String[]{"Europe/Berlin", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[7]);
    assertArrayEquals(new String[]{"Europe/Bratislava", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[21]);
    assertArrayEquals(new String[]{"Europe/Bucharest", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[2]);
    assertArrayEquals(new String[]{"Europe/Budapest", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[19]);
    assertArrayEquals(new String[]{"Europe/Chisinau", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[13]);
    assertArrayEquals(new String[]{"Europe/Copenhagen", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[24]);
    assertArrayEquals(new String[]{"Europe/Kaliningrad", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[6]);
    assertArrayEquals(new String[]{"Europe/Kyiv", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[584]);
    assertArrayEquals(new String[]{"Europe/Lisbon", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[10]);
    assertArrayEquals(new String[]{"Europe/Ljubljana", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[4]);
    assertArrayEquals(new String[]{"Europe/Nicosia", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[599]);
    assertArrayEquals(new String[]{"Europe/Oslo", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[11]);
    assertArrayEquals(new String[]{"Europe/Paris", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[0]);
    assertArrayEquals(new String[]{"Europe/San_Marino", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[22]);
    assertArrayEquals(new String[]{"Europe/Stockholm", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[18]);
    assertArrayEquals(new String[]{"Europe/Ulyanovsk", "Ulyanovsk Standard Time", "GMT+04:00",
        "Ulyanovsk Standard Time", "GMT+04:00", "Ulyanovsk Time", "GMT+04:00"}, zoneStrings[591]);
    assertArrayEquals(new String[]{"Europe/Zagreb", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[23]);
    assertArrayEquals(new String[]{"Hongkong", "Hong Kong Standard Time", "HKT", "Hong Kong Summer Time", "HKST",
        "Hong Kong Time", "HKT"}, zoneStrings[585]);
    assertArrayEquals(new String[]{"Jamaica", "Eastern Standard Time", "GMT-05:00", "Eastern Daylight Time",
        "GMT-05:00", "Eastern Time", "GMT-05:00"}, zoneStrings[577]);
    assertArrayEquals(
        new String[]{"Japan", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[589]);
    assertArrayEquals(
        new String[]{"MST", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT", "Mountain Time", "MT"},
        zoneStrings[583]);
    assertArrayEquals(new String[]{"Turkey", "Turkey Time", "TRT", "Turkey Summer Time", "TRST", "Turkey Time", "TRT"},
        zoneStrings[576]);
    assertArrayEquals(new String[]{"UCT", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[586]);
    assertArrayEquals(new String[]{"US/Pacific", "Pacific Standard Time", "GMT-08:00", "Pacific Daylight Time",
        "GMT-07:00", "Pacific Time", "GMT-08:00"}, zoneStrings[600]);
    assertArrayEquals(new String[]{"UTC", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[3]);
    assertArrayEquals(
        new String[]{"W-SU", "Moscow Standard Time", "MSK", "Moscow Summer Time", "MSD", "Moscow Time", "MT"},
        zoneStrings[592]);
    assertArrayEquals(new String[]{"WET", "Western European Time", "WET", "Western European Summer Time", "WEST",
        "Western European Time", "WET"}, zoneStrings[578]);
    assertArrayEquals(new String[]{System.getProperty("user.timezone"), "Greenwich Mean Time", "GMT",
        "British Summer Time", "BST", "British Time", "BT"}, zoneStrings[14]);
    assertArrayEquals(new String[]{"", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"},
        dateFormatSymbols.getShortWeekdays());
    assertArrayEquals(new String[]{"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"},
        dateFormatSymbols.getWeekdays());
    assertArrayEquals(
        new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", ""},
        dateFormatSymbols.getShortMonths());
    assertArrayEquals(new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December", ""}, dateFormatSymbols.getMonths());
  }

  /**
   * Test {@link BasicPersistenceModule#getSimpleDateFormatter()}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getSimpleDateFormatter()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSimpleDateFormatter2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5278 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicPersistenceModule()).getSimpleDateFormatter();
  }

  /**
   * Test {@link BasicPersistenceModule#getSimpleDateFormatter()}.
   * <ul>
   *   <li>Given {@link BasicPersistenceModule} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getSimpleDateFormatter()}
   */
  @Test
  public void testGetSimpleDateFormatter_givenBasicPersistenceModule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SimpleDateFormat actualSimpleDateFormatter = (new BasicPersistenceModule()).getSimpleDateFormatter();

    // Assert
    NumberFormat numberFormat = actualSimpleDateFormatter.getNumberFormat();
    assertTrue(numberFormat instanceof DecimalFormat);
    Calendar calendar = actualSimpleDateFormatter.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals("", ((DecimalFormat) numberFormat).getNegativeSuffix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositivePrefix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositiveSuffix());
    assertEquals("###0", ((DecimalFormat) numberFormat).toLocalizedPattern());
    assertEquals("###0", ((DecimalFormat) numberFormat).toPattern());
    assertEquals("-", ((DecimalFormat) numberFormat).getNegativePrefix());
    Currency currency = numberFormat.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormat).getDecimalFormatSymbols();
    assertEquals("E", decimalFormatSymbols.getExponentSeparator());
    assertEquals("GBP", decimalFormatSymbols.getInternationalCurrencySymbol());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    DateFormatSymbols dateFormatSymbols = actualSimpleDateFormatter.getDateFormatSymbols();
    assertEquals("GyMdkHmsSEDFwWahKzZ", dateFormatSymbols.getLocalPatternChars());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    assertEquals("£", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("£", currency.getSymbol());
    assertEquals("∞", decimalFormatSymbols.getInfinity());
    assertEquals("gregory", calendar.getCalendarType());
    assertEquals("yyyy.MM.dd HH:mm:ss", actualSimpleDateFormatter.toPattern());
    assertEquals('#', decimalFormatSymbols.getDigit());
    assertEquals('%', decimalFormatSymbols.getPercent());
    assertEquals(',', decimalFormatSymbols.getGroupingSeparator());
    assertEquals('-', decimalFormatSymbols.getMinusSign());
    assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    assertEquals('.', decimalFormatSymbols.getMonetaryDecimalSeparator());
    assertEquals('0', decimalFormatSymbols.getZeroDigit());
    assertEquals(';', decimalFormatSymbols.getPatternSeparator());
    assertEquals('‰', decimalFormatSymbols.getPerMill());
    assertNull(actualSimpleDateFormatter.getTimeZone());
    assertNull(calendar.getTimeZone());
    assertEquals(0, numberFormat.getMaximumFractionDigits());
    assertEquals(0, numberFormat.getMinimumFractionDigits());
    assertEquals(1, ((DecimalFormat) numberFormat).getMultiplier());
    assertEquals(1, numberFormat.getMinimumIntegerDigits());
    assertEquals(2, calendar.getFirstDayOfWeek());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(3, ((DecimalFormat) numberFormat).getGroupingSize());
    assertEquals(4, calendar.getMinimalDaysInFirstWeek());
    String[][] zoneStrings = dateFormatSymbols.getZoneStrings();
    assertEquals(601, zoneStrings.length);
    assertEquals(826, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, numberFormat.getRoundingMode());
    assertFalse(((DecimalFormat) numberFormat).isDecimalSeparatorAlwaysShown());
    assertFalse(((DecimalFormat) numberFormat).isParseBigDecimal());
    assertFalse(numberFormat.isGroupingUsed());
    assertTrue(actualSimpleDateFormatter.isLenient());
    assertTrue(numberFormat.isParseIntegerOnly());
    assertTrue(calendar.isLenient());
    assertTrue(calendar.isWeekDateSupported());
    assertEquals(Integer.MAX_VALUE, numberFormat.getMaximumIntegerDigits());
    assertSame(currency, decimalFormatSymbols.getCurrency());
    assertArrayEquals(new String[]{"BC", "AD"}, dateFormatSymbols.getEras());
    assertArrayEquals(new String[]{"am", "pm"}, dateFormatSymbols.getAmPmStrings());
    assertArrayEquals(new String[]{"Africa/Cairo", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[9]);
    assertArrayEquals(new String[]{"Africa/Casablanca", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[1]);
    assertArrayEquals(new String[]{"Africa/El_Aaiun", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[8]);
    assertArrayEquals(new String[]{"America/Argentina/Buenos_Aires", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[598]);
    assertArrayEquals(new String[]{"America/Argentina/ComodRivadavia", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[587]);
    assertArrayEquals(new String[]{"America/Ensenada", "Pacific Standard Time", "GMT-08:00", "Pacific Daylight Time",
        "GMT-07:00", "Pacific Time", "GMT-08:00"}, zoneStrings[581]);
    assertArrayEquals(new String[]{"America/Nuuk", "Western Greenland Time", "WGT", "Western Greenland Summer Time",
        "WGST", "Western Greenland Time", "WGT"}, zoneStrings[590]);
    assertArrayEquals(new String[]{"America/Rosario", "Argentina Standard Time", "ART", "Argentina Summer Time", "ARST",
        "Argentina Time", "ART"}, zoneStrings[595]);
    assertArrayEquals(new String[]{"America/Virgin", "Atlantic Standard Time", "GMT-04:00", "Atlantic Daylight Time",
        "GMT-04:00", "Atlantic Time", "GMT-04:00"}, zoneStrings[582]);
    assertArrayEquals(new String[]{"Asia/Famagusta", "Eastern European Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[588]);
    assertArrayEquals(new String[]{"Asia/Gaza", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[12]);
    assertArrayEquals(new String[]{"Asia/Nicosia", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[5]);
    assertArrayEquals(new String[]{"Asia/Srednekolymsk", "Srednekolymsk Time", "SRET", "Srednekolymsk Daylight Time",
        "SREDT", "Srednekolymsk Time", "SRET"}, zoneStrings[597]);
    assertArrayEquals(new String[]{"Asia/Ulaanbaatar", "Ulan Bator Standard Time", "ULAT", "Ulan Bator Summer Time",
        "ULAST", "Ulan Bator Time", "ULAT"}, zoneStrings[17]);
    assertArrayEquals(new String[]{"Atlantic/Canary", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[20]);
    assertArrayEquals(new String[]{"Atlantic/Faeroe", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[Short.SIZE]);
    assertArrayEquals(new String[]{"Australia/Darwin", "Australian Central Standard Time", "ACST",
        "Australian Central Daylight Time", "ACDT", "Central Australia Time", "ACT"}, zoneStrings[15]);
    assertArrayEquals(new String[]{"Canada/Saskatchewan", "Central Standard Time", "GMT-06:00", "Central Daylight Time",
        "GMT-06:00", "Central Time", "GMT-06:00"}, zoneStrings[594]);
    assertArrayEquals(new String[]{"EET", "Eastern European Time", "EET", "Eastern European Summer Time", "EEST",
        "Eastern European Time", "EET"}, zoneStrings[593]);
    assertArrayEquals(new String[]{"Egypt", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[596]);
    assertArrayEquals(new String[]{"Etc/Greenwich", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT",
        "Greenwich Mean Time", "GMT"}, zoneStrings[580]);
    assertArrayEquals(new String[]{"Europe/Astrakhan", "Astrakhan Standard Time", "GMT+04:00",
        "Astrakhan Standard Time", "GMT+04:00", "Astrakhan Time", "GMT+04:00"}, zoneStrings[579]);
    assertArrayEquals(new String[]{"Europe/Berlin", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[7]);
    assertArrayEquals(new String[]{"Europe/Bratislava", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[21]);
    assertArrayEquals(new String[]{"Europe/Bucharest", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[2]);
    assertArrayEquals(new String[]{"Europe/Budapest", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[19]);
    assertArrayEquals(new String[]{"Europe/Chisinau", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[13]);
    assertArrayEquals(new String[]{"Europe/Copenhagen", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[24]);
    assertArrayEquals(new String[]{"Europe/Kaliningrad", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[6]);
    assertArrayEquals(new String[]{"Europe/Kyiv", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[584]);
    assertArrayEquals(new String[]{"Europe/Lisbon", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[10]);
    assertArrayEquals(new String[]{"Europe/Ljubljana", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[4]);
    assertArrayEquals(new String[]{"Europe/Nicosia", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[599]);
    assertArrayEquals(new String[]{"Europe/Oslo", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[11]);
    assertArrayEquals(new String[]{"Europe/Paris", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[0]);
    assertArrayEquals(new String[]{"Europe/San_Marino", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[22]);
    assertArrayEquals(new String[]{"Europe/Stockholm", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[18]);
    assertArrayEquals(new String[]{"Europe/Ulyanovsk", "Ulyanovsk Standard Time", "GMT+04:00",
        "Ulyanovsk Standard Time", "GMT+04:00", "Ulyanovsk Time", "GMT+04:00"}, zoneStrings[591]);
    assertArrayEquals(new String[]{"Europe/Zagreb", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[23]);
    assertArrayEquals(new String[]{"Hongkong", "Hong Kong Standard Time", "HKT", "Hong Kong Summer Time", "HKST",
        "Hong Kong Time", "HKT"}, zoneStrings[585]);
    assertArrayEquals(new String[]{"Jamaica", "Eastern Standard Time", "GMT-05:00", "Eastern Daylight Time",
        "GMT-05:00", "Eastern Time", "GMT-05:00"}, zoneStrings[577]);
    assertArrayEquals(
        new String[]{"Japan", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[589]);
    assertArrayEquals(
        new String[]{"MST", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT", "Mountain Time", "MT"},
        zoneStrings[583]);
    assertArrayEquals(new String[]{"Turkey", "Turkey Time", "TRT", "Turkey Summer Time", "TRST", "Turkey Time", "TRT"},
        zoneStrings[576]);
    assertArrayEquals(new String[]{"UCT", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[586]);
    assertArrayEquals(new String[]{"US/Pacific", "Pacific Standard Time", "GMT-08:00", "Pacific Daylight Time",
        "GMT-07:00", "Pacific Time", "GMT-08:00"}, zoneStrings[600]);
    assertArrayEquals(new String[]{"UTC", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[3]);
    assertArrayEquals(
        new String[]{"W-SU", "Moscow Standard Time", "MSK", "Moscow Summer Time", "MSD", "Moscow Time", "MT"},
        zoneStrings[592]);
    assertArrayEquals(new String[]{"WET", "Western European Time", "WET", "Western European Summer Time", "WEST",
        "Western European Time", "WET"}, zoneStrings[578]);
    assertArrayEquals(new String[]{System.getProperty("user.timezone"), "Greenwich Mean Time", "GMT",
        "British Summer Time", "BST", "British Time", "BT"}, zoneStrings[14]);
    assertArrayEquals(new String[]{"", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"},
        dateFormatSymbols.getShortWeekdays());
    assertArrayEquals(new String[]{"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"},
        dateFormatSymbols.getWeekdays());
    assertArrayEquals(
        new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", ""},
        dateFormatSymbols.getShortMonths());
    assertArrayEquals(new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December", ""}, dateFormatSymbols.getMonths());
  }

  /**
   * Test {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFilterOutCollectionMetadata() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3204 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.filterOutCollectionMetadata(new HashMap<>());
  }

  /**
   * Test {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  public void testFilterOutCollectionMetadata_givenAdornedTargetCollectionMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.put("foo", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertTrue(basicPersistenceModule.filterOutCollectionMetadata(metadata).isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  public void testFilterOutCollectionMetadata_givenBasicFieldMetadata_thenReturnHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.put("foo", new BasicFieldMetadata());

    // Act and Assert
    assertEquals(metadata, basicPersistenceModule.filterOutCollectionMetadata(metadata));
  }

  /**
   * Test {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  public void testFilterOutCollectionMetadata_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));
    metadata.put("foo", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertTrue(basicPersistenceModule.filterOutCollectionMetadata(metadata).isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  public void testFilterOutCollectionMetadata_whenHashMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    // Act and Assert
    assertTrue(basicPersistenceModule.filterOutCollectionMetadata(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  public void testFilterOutCollectionMetadata_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BasicPersistenceModule()).filterOutCollectionMetadata(null));
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicBroadleafType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act and Assert
    assertNull(basicPersistenceModule.getBasicBroadleafType(SupportedFieldType.UNKNOWN));
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetBasicBroadleafType2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3263 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicPersistenceModule()).getBasicBroadleafType(SupportedFieldType.UNKNOWN);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   * <ul>
   *   <li>Given {@link BasicPersistenceModule} (default constructor).</li>
   *   <li>When {@code DATE}.</li>
   *   <li>Then return {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicBroadleafType_givenBasicPersistenceModule_whenDate_thenReturnDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicBroadleafType = (new BasicPersistenceModule()).getBasicBroadleafType(SupportedFieldType.DATE);

    // Assert
    Class<Date> expectedBasicBroadleafType = Date.class;
    assertEquals(expectedBasicBroadleafType, actualBasicBroadleafType);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   * <ul>
   *   <li>Given {@link BasicPersistenceModule} (default constructor).</li>
   *   <li>When {@code ID}.</li>
   *   <li>Then return {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicBroadleafType_givenBasicPersistenceModule_whenId_thenReturnString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicBroadleafType = (new BasicPersistenceModule()).getBasicBroadleafType(SupportedFieldType.ID);

    // Assert
    Class<String> expectedBasicBroadleafType = String.class;
    assertEquals(expectedBasicBroadleafType, actualBasicBroadleafType);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   * <ul>
   *   <li>Given {@link BasicPersistenceModule} (default constructor).</li>
   *   <li>When {@code MONEY}.</li>
   *   <li>Then return {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicBroadleafType_givenBasicPersistenceModule_whenMoney_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicBroadleafType = (new BasicPersistenceModule()).getBasicBroadleafType(SupportedFieldType.MONEY);

    // Assert
    Class<Money> expectedBasicBroadleafType = Money.class;
    assertEquals(expectedBasicBroadleafType, actualBasicBroadleafType);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   * <ul>
   *   <li>Given {@link BasicPersistenceModule} (default constructor).</li>
   *   <li>When {@code UNKNOWN}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicBroadleafType_givenBasicPersistenceModule_whenUnknown_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BasicPersistenceModule()).getBasicBroadleafType(SupportedFieldType.UNKNOWN));
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code BOOLEAN}.</li>
   *   <li>Then return Name is {@code boolean}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicBroadleafType_whenBoolean_thenReturnNameIsBoolean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("boolean", (new BasicPersistenceModule()).getBasicBroadleafType(SupportedFieldType.BOOLEAN).getName());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code DECIMAL}.</li>
   *   <li>Then return {@link BigDecimal}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicBroadleafType_whenDecimal_thenReturnBigDecimal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicBroadleafType = (new BasicPersistenceModule())
        .getBasicBroadleafType(SupportedFieldType.DECIMAL);

    // Assert
    Class<BigDecimal> expectedBasicBroadleafType = BigDecimal.class;
    assertEquals(expectedBasicBroadleafType, actualBasicBroadleafType);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code INTEGER}.</li>
   *   <li>Then return Name is {@code int}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicBroadleafType_whenInteger_thenReturnNameIsInt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("int", (new BasicPersistenceModule()).getBasicBroadleafType(SupportedFieldType.INTEGER).getName());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#createPopulatedInstance(Serializable, Entity, Map, Boolean)}
   * with {@code instance}, {@code entity}, {@code unfilteredProperties},
   * {@code setId}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#createPopulatedInstance(Serializable, Entity, Map, Boolean)}
   */
  @Test
  public void testCreatePopulatedInstanceWithInstanceEntityUnfilteredPropertiesSetId() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    Entity entity = new Entity();

    HashMap<String, FieldMetadata> unfilteredProperties = new HashMap<>();
    unfilteredProperties.put("42", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.createPopulatedInstance(instance, entity, unfilteredProperties, true));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#createPopulatedInstance(Serializable, Entity, Map, Boolean)}
   * with {@code instance}, {@code entity}, {@code unfilteredProperties},
   * {@code setId}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#createPopulatedInstance(Serializable, Entity, Map, Boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreatePopulatedInstanceWithInstanceEntityUnfilteredPropertiesSetId2() throws ValidationException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2144 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    Entity entity = new Entity();

    // Act
    basicPersistenceModule2.createPopulatedInstance(instance, entity, new HashMap<>(), true);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#createPopulatedInstance(Serializable, Entity, Map, Boolean, Boolean)}
   * with {@code instance}, {@code entity}, {@code unfilteredProperties},
   * {@code setId}, {@code validateUnsubmittedProperties}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#createPopulatedInstance(Serializable, Entity, Map, Boolean, Boolean)}
   */
  @Test
  public void testCreatePopulatedInstanceWithInstanceEntityUnfilteredPropertiesSetIdValidateUnsubmittedProperties()
      throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    Entity entity = new Entity();

    HashMap<String, FieldMetadata> unfilteredProperties = new HashMap<>();
    unfilteredProperties.put("42", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.createPopulatedInstance(instance, entity, unfilteredProperties, true, true));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#createPopulatedInstance(Serializable, Entity, Map, Boolean, Boolean)}
   * with {@code instance}, {@code entity}, {@code unfilteredProperties},
   * {@code setId}, {@code validateUnsubmittedProperties}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#createPopulatedInstance(Serializable, Entity, Map, Boolean, Boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreatePopulatedInstanceWithInstanceEntityUnfilteredPropertiesSetIdValidateUnsubmittedProperties2()
      throws ValidationException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2263 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    Entity entity = new Entity();

    // Act
    basicPersistenceModule2.createPopulatedInstance(instance, entity, new HashMap<>(), true, true);
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  public void testIsLate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getName()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    basicPersistenceModule.isLate(metadata, "Name");

    // Assert
    verify(metadata).getFieldType();
    verify(metadata).getName();
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  public void testIsLate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenThrow(new ParentEntityPersistenceException("An error occurred"));

    // Act
    basicPersistenceModule.isLate(metadata, FieldManager.MAPFIELDSEPARATOR);

    // Assert
    verify(metadata).getFieldType();
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsLate3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5610 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.isLate(new BasicFieldMetadata(), "Name");
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   * <ul>
   *   <li>Given {@code Metadata}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) Name is
   * {@code Metadata}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  public void testIsLate_givenMetadata_whenBasicFieldMetadataNameIsMetadata_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.UNKNOWN);
    metadata.setName("Metadata");

    // Act and Assert
    assertTrue(basicPersistenceModule.isLate(metadata, FieldManager.MAPFIELDSEPARATOR));
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#getName()}
   * return {@code Name}.</li>
   *   <li>Then calls {@link BasicFieldMetadata#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  public void testIsLate_givenName_whenBasicFieldMetadataGetNameReturnName_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getName()).thenReturn("Name");
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    boolean actualIsLateResult = basicPersistenceModule.isLate(metadata, "Name");

    // Assert
    verify(metadata, atLeast(1)).getFieldType();
    verify(metadata).getName();
    assertFalse(actualIsLateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) Name is
   * {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  public void testIsLate_givenNull_whenBasicFieldMetadataNameIsNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.UNKNOWN);
    metadata.setName(null);

    // Act and Assert
    assertFalse(basicPersistenceModule.isLate(metadata, FieldManager.MAPFIELDSEPARATOR));
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  public void testIsLate_whenBasicFieldMetadata_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    // Act and Assert
    assertFalse(basicPersistenceModule.isLate(new BasicFieldMetadata(), "Name"));
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  public void testIsLate_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BasicPersistenceModule()).isLate(null, FieldManager.MAPFIELDSEPARATOR));
  }

  /**
   * Test
   * {@link BasicPersistenceModule#attemptToPopulateValue(Property, FieldManager, Serializable, Boolean, BasicFieldMetadata, Entity, String)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#attemptToPopulateValue(Property, FieldManager, Serializable, Boolean, BasicFieldMetadata, Entity, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttemptToPopulateValue() throws IllegalAccessException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1686 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    Property property = new Property();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);
    FieldManager fieldManager = new FieldManager(entityConfiguration,
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)));

    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    BasicFieldMetadata metadata = new BasicFieldMetadata();

    // Act
    basicPersistenceModule2.attemptToPopulateValue(property, fieldManager, instance, true, metadata, new Entity(),
        "42");
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecord(Class, PersistencePerspective, Serializable)}
   * with {@code ceilingEntityClass}, {@code persistencePerspective},
   * {@code record}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Class, PersistencePerspective, Serializable)}
   */
  @Test
  public void testGetRecordWithCeilingEntityClassPersistencePerspectiveRecord() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    Entity actualRecord = basicPersistenceModule.getRecord(ceilingEntityClass, persistencePerspective,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl).getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    assertNull(actualRecord.getDeployDate());
    assertEquals(0, actualRecord.getProperties().length);
    assertFalse(actualRecord.getActive());
    assertFalse(actualRecord.getDeleted());
    assertFalse(actualRecord.getInactive());
    assertFalse(actualRecord.isDirty());
    assertFalse(actualRecord.isMultiPartAvailableOnThread());
    assertFalse(actualRecord.isPreAdd());
    assertTrue(actualRecord.getGlobalValidationErrors().isEmpty());
    assertTrue(actualRecord.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = actualRecord.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, actualRecord.getValidationErrors());
    assertArrayEquals(new String[]{"java.text.SimpleDateFormat"}, actualRecord.getType());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecord(Class, PersistencePerspective, Serializable)}
   * with {@code ceilingEntityClass}, {@code persistencePerspective},
   * {@code record}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Class, PersistencePerspective, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRecordWithCeilingEntityClassPersistencePerspectiveRecord2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4283 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    basicPersistenceModule2.getRecord(ceilingEntityClass, persistencePerspective, new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   * with {@code primaryMergedProperties}, {@code record},
   * {@code alternateMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  public void testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act and Assert
    assertThrows(PersistenceException.class, () -> basicPersistenceModule.getRecord(primaryMergedProperties,
        resultRecord, new HashMap<>(), "Path To Target Object"));
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   * with {@code primaryMergedProperties}, {@code record},
   * {@code alternateMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  public void testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act and Assert
    assertThrows(PersistenceException.class, () -> basicPersistenceModule.getRecord(primaryMergedProperties,
        resultRecord, new HashMap<>(), "Path To Target Object"));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   * with {@code primaryMergedProperties}, {@code record},
   * {@code alternateMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  public void testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject3()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Entity actualRecord = basicPersistenceModule.getRecord(primaryMergedProperties, resultRecord, new HashMap<>(),
        "Path To Target Object");

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    assertArrayEquals(new String[]{"java.lang.String"}, actualRecord.getType());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   * with {@code primaryMergedProperties}, {@code record},
   * {@code alternateMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  public void testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject4()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setFriendlyName(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setFriendlyTab(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(new SystemPropertyFieldType(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY,
        BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY));
    systemPropertyImpl.setValue("42");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(systemPropertyImpl);
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Entity actualRecord = basicPersistenceModule.getRecord(primaryMergedProperties, resultRecord, new HashMap<>(),
        "Path To Target Object");

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    Map<String, Property> pMap = actualRecord.getPMap();
    assertEquals(2, pMap.size());
    Property getResult = pMap.get("__adminMainEntity");
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getRawValue());
    Property getResult2 = pMap.get(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getRawValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getUnHtmlEncodedValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getUnHtmlEncodedValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getValue());
    assertArrayEquals(new String[]{"org.broadleafcommerce.common.config.domain.SystemPropertyImpl"},
        actualRecord.getType());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   * with {@code primaryMergedProperties}, {@code record},
   * {@code alternateMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  public void testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject5()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = mock(SystemPropertyImpl.class);
    when(systemPropertyImpl.getMainEntityName()).thenReturn("Main Entity Name");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(systemPropertyImpl);
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    primaryMergedProperties.put("foo", new AdornedTargetCollectionMetadata());
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Entity actualRecord = basicPersistenceModule.getRecord(primaryMergedProperties, resultRecord, new HashMap<>(),
        "Path To Target Object");

    // Assert
    verify(systemPropertyImpl, atLeast(1)).getMainEntityName();
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    Map<String, Property> pMap = actualRecord.getPMap();
    assertEquals(2, pMap.size());
    Property getResult = pMap.get("__adminMainEntity");
    assertEquals("Main Entity Name", getResult.getRawValue());
    Property getResult2 = pMap.get(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    assertEquals("Main Entity Name", getResult2.getRawValue());
    assertEquals("Main Entity Name", getResult.getUnHtmlEncodedValue());
    assertEquals("Main Entity Name", getResult2.getUnHtmlEncodedValue());
    assertEquals("Main Entity Name", getResult.getValue());
    assertEquals("Main Entity Name", getResult2.getValue());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   * with {@code primaryMergedProperties}, {@code record},
   * {@code alternateMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  public void testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject6()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = mock(SystemPropertyImpl.class);
    when(systemPropertyImpl.getMainEntityName()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(systemPropertyImpl);
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    basicPersistenceModule.getRecord(primaryMergedProperties, resultRecord, new HashMap<>(), "Path To Target Object");

    // Assert
    verify(systemPropertyImpl, atLeast(1)).getMainEntityName();
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   * with {@code primaryMergedProperties}, {@code record},
   * {@code alternateMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  public void testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(mock(FieldManager.class));
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Entity actualRecord = basicPersistenceModule.getRecord(primaryMergedProperties, resultRecord, new HashMap<>(),
        null);

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    assertArrayEquals(new String[]{"java.text.SimpleDateFormat"}, actualRecord.getType());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   * with {@code primaryMergedProperties}, {@code record},
   * {@code alternateMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject8() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4611 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    basicPersistenceModule2.getRecord(primaryMergedProperties, resultRecord, new HashMap<>(), "Path To Target Object");
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   * with {@code ceilingEntityClass}, {@code persistencePerspective},
   * {@code records}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   */
  @Test
  public void testGetRecordsWithCeilingEntityClassPersistencePerspectiveRecords() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(ceilingEntityClass, persistencePerspective,
        new ArrayList<>());

    // Assert
    verify(dynamicEntityDaoImpl).getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager).getDynamicEntityDao();
    assertEquals(0, actualRecords.length);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   * with {@code ceilingEntityClass}, {@code persistencePerspective},
   * {@code records}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   */
  @Test
  public void testGetRecordsWithCeilingEntityClassPersistencePerspectiveRecords2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", new AdornedTargetCollectionMetadata());
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(ceilingEntityClass, persistencePerspective,
        new ArrayList<>());

    // Assert
    verify(dynamicEntityDaoImpl).getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager).getDynamicEntityDao();
    assertEquals(0, actualRecords.length);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   * with {@code ceilingEntityClass}, {@code persistencePerspective},
   * {@code records}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   */
  @Test
  public void testGetRecordsWithCeilingEntityClassPersistencePerspectiveRecords3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(ceilingEntityClass, persistencePerspective, records);

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl).getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    Entity entity = actualRecords[0];
    assertNull(entity.getDeployDate());
    assertEquals(0, entity.getProperties().length);
    assertEquals(1, actualRecords.length);
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"java.text.SimpleDateFormat"}, entity.getType());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   * with {@code ceilingEntityClass}, {@code persistencePerspective},
   * {@code records}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   */
  @Test
  public void testGetRecordsWithCeilingEntityClassPersistencePerspectiveRecords4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.getRecords(ceilingEntityClass, persistencePerspective, records));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl).getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   * with {@code ceilingEntityClass}, {@code persistencePerspective},
   * {@code records}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   */
  @Test
  public void testGetRecordsWithCeilingEntityClassPersistencePerspectiveRecords5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.getRecords(ceilingEntityClass, persistencePerspective, records));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl).getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   * with {@code ceilingEntityClass}, {@code persistencePerspective},
   * {@code records}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRecordsWithCeilingEntityClassPersistencePerspectiveRecords6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4736 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    basicPersistenceModule2.getRecords(ceilingEntityClass, persistencePerspective, new ArrayList<>());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(FetchExtractionRequest)} with
   * {@code fetchExtractionRequest}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(FetchExtractionRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRecordsWithFetchExtractionRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5205 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    // Act
    basicPersistenceModule2.getRecords(new FetchExtractionRequest(persistencePackage, cto, "0123456789ABCDEF",
        primaryUnfilteredMergedProperties, new ArrayList<>()));
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List)} with
   * {@code primaryMergedProperties}, {@code records}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  public void testGetRecordsWithPrimaryMergedPropertiesRecords() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    primaryMergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryMergedProperties, new ArrayList<>()).length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List)} with
   * {@code primaryMergedProperties}, {@code records}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  public void testGetRecordsWithPrimaryMergedPropertiesRecords2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    basicPersistenceModule.getRecords(primaryMergedProperties, records);

    // Assert
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List)} with
   * {@code primaryMergedProperties}, {@code records}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRecordsWithPrimaryMergedPropertiesRecords3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5062 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();

    // Act
    basicPersistenceModule2.getRecords(primaryMergedProperties, new ArrayList<>());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List)} with
   * {@code primaryMergedProperties}, {@code records}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  public void testGetRecordsWithPrimaryMergedPropertiesRecords_givenBasicFieldMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    primaryMergedProperties.put("foo", new BasicFieldMetadata());

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryMergedProperties, new ArrayList<>()).length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List)} with
   * {@code primaryMergedProperties}, {@code records}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  public void testGetRecordsWithPrimaryMergedPropertiesRecords_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    primaryMergedProperties.computeIfPresent("foo", mock(BiFunction.class));
    primaryMergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryMergedProperties, new ArrayList<>()).length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List)} with
   * {@code primaryMergedProperties}, {@code records}.
   * <ul>
   *   <li>Then calls {@link DynamicEntityDaoImpl#getFieldManager()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  public void testGetRecordsWithPrimaryMergedPropertiesRecords_thenCallsGetFieldManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    basicPersistenceModule.getRecords(primaryMergedProperties, records);

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List)} with
   * {@code primaryMergedProperties}, {@code records}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  public void testGetRecordsWithPrimaryMergedPropertiesRecords_thenReturnArrayLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryMergedProperties, new ArrayList<>()).length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with
   * {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object").length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with
   * {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.put("foo", new AdornedTargetCollectionMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object").length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with
   * {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.computeIfPresent("foo", mock(BiFunction.class));
    primaryUnfilteredMergedProperties.put("foo", new AdornedTargetCollectionMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object").length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with
   * {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.put("foo", new BasicFieldMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object").length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with
   * {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(PersistenceException.class, () -> basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties,
        records, new HashMap<>(), "Path To Target Object"));
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with
   * {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(PersistenceException.class, () -> basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties,
        records, new HashMap<>(), "Path To Target Object"));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with
   * {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject7()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records,
        new HashMap<>(), "Path To Target Object");

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    assertEquals(1, actualRecords.length);
    assertArrayEquals(new String[]{"java.lang.String"}, (actualRecords[0]).getType());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with
   * {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject8()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setFriendlyName(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setFriendlyTab(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(new SystemPropertyFieldType(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY,
        BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY));
    systemPropertyImpl.setValue("42");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(systemPropertyImpl);
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records,
        new HashMap<>(), "Path To Target Object");

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    Entity entity = actualRecords[0];
    Map<String, Property> pMap = entity.getPMap();
    assertEquals(2, pMap.size());
    Property getResult = pMap.get("__adminMainEntity");
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    Property getResult2 = pMap.get(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    FieldMetadata metadata2 = getResult2.getMetadata();
    assertTrue(metadata2 instanceof BasicFieldMetadata);
    assertEquals("__adminMainEntity", getResult.getName());
    assertNull(((BasicFieldMetadata) metadata2).getCustomCriteria());
    assertNull(metadata2.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata2).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata2).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata2).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata2).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata2).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata2).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata2).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata2).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata2).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata2).getMutable());
    assertNull(((BasicFieldMetadata) metadata2).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata2).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata2).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata2).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata2).getSearchable());
    assertNull(((BasicFieldMetadata) metadata2).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata2).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata2).getUnique());
    assertNull(((BasicFieldMetadata) metadata2).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata2).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata2).isProminent());
    assertNull(metadata2.getChildrenExcluded());
    assertNull(metadata2.getExcluded());
    assertNull(metadata2.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata2).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata2).getLength());
    assertNull(((BasicFieldMetadata) metadata2).getPrecision());
    assertNull(((BasicFieldMetadata) metadata2).getScale());
    assertNull(metadata2.getGroupOrder());
    assertNull(metadata2.getOrder());
    assertNull(metadata2.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata2).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata2).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata2).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata2).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata2).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata2).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata2).getHelpText());
    assertNull(((BasicFieldMetadata) metadata2).getHint());
    assertNull(((BasicFieldMetadata) metadata2).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata2).getManyToField());
    assertNull(((BasicFieldMetadata) metadata2).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata2).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata2).getName());
    assertNull(((BasicFieldMetadata) metadata2).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata2).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata2).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata2).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata2).getTooltip());
    assertNull(metadata2.getAddFriendlyName());
    assertNull(metadata2.getCurrencyCodeField());
    assertNull(metadata2.getFieldName());
    assertNull(metadata2.getFriendlyName());
    assertNull(metadata2.getGroup());
    assertNull(metadata2.getInheritedFromType());
    assertNull(metadata2.getOwningClass());
    assertNull(metadata2.getOwningClassFriendlyName());
    assertNull(metadata2.getPrefix());
    assertNull(metadata2.getSecurityLevel());
    assertNull(metadata2.getShowIfProperty());
    assertNull(metadata2.getTab());
    assertNull(metadata2.getTargetClass());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult2.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult2.getOriginalValue());
    assertNull(getResult.getDeployDate());
    assertNull(getResult2.getDeployDate());
    assertNull(metadata2.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata2).getLookupType());
    assertNull(((BasicFieldMetadata) metadata2).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata2).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata2).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata2).getFieldType());
    assertNull(((BasicFieldMetadata) metadata2).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata2).getVisibility());
    assertNull(((BasicFieldMetadata) metadata2).getMergedPropertyType());
    assertEquals(1, actualRecords.length);
    Property[] properties = entity.getProperties();
    assertEquals(2, properties.length);
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata2).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata2).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata2).getRequired());
    assertFalse(metadata2.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(getResult2.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata2).getValidationConfigurations().isEmpty());
    assertTrue(metadata2.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata2).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
    assertTrue(getResult2.getEnabled());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getName());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getRawValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getRawValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getUnHtmlEncodedValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getUnHtmlEncodedValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getValue());
    assertEquals(metadata2, metadata);
    assertSame(getResult, properties[0]);
    assertSame(getResult2, properties[1]);
    assertArrayEquals(new String[]{"org.broadleafcommerce.common.config.domain.SystemPropertyImpl"}, entity.getType());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with
   * {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject9()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = mock(SystemPropertyImpl.class);
    when(systemPropertyImpl.getMainEntityName()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(systemPropertyImpl);
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records,
        new HashMap<>(), "Path To Target Object");

    // Assert
    verify(systemPropertyImpl, atLeast(1)).getMainEntityName();
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    assertEquals(1, actualRecords.length);
    assertArrayEquals(
        new String[]{"org.broadleafcommerce.common.config.domain.SystemPropertyImpl$MockitoMock$SPTbl1pm"},
        (actualRecords[0]).getType());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with
   * {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(mock(FieldManager.class));
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records,
        new HashMap<>(), null);

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    assertEquals(1, actualRecords.length);
    assertArrayEquals(new String[]{"java.text.SimpleDateFormat"}, (actualRecords[0]).getType());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with
   * {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject11() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5085 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act
    basicPersistenceModule2.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object");
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   * with {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject},
   * {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object", new String[]{"Custom Criteria"}).length);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   * with {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject},
   * {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.put("ProductList", new AdornedTargetCollectionMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object", new String[]{"Custom Criteria"}).length);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   * with {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject},
   * {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.computeIfPresent("ProductList", mock(BiFunction.class));
    primaryUnfilteredMergedProperties.put("ProductList", new AdornedTargetCollectionMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object", new String[]{"Custom Criteria"}).length);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   * with {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject},
   * {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object", new String[]{"ProductList"}).length);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   * with {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject},
   * {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object", null).length);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   * with {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject},
   * {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.put("ProductList", new BasicFieldMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object", new String[]{"Custom Criteria"}).length);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   * with {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject},
   * {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(PersistenceException.class, () -> basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties,
        records, new HashMap<>(), "Path To Target Object", new String[]{"Custom Criteria"}));
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   * with {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject},
   * {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(PersistenceException.class, () -> basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties,
        records, new HashMap<>(), "Path To Target Object", new String[]{"Custom Criteria"}));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   * with {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject},
   * {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria9()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records,
        new HashMap<>(), "Path To Target Object", new String[]{"Custom Criteria"});

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    assertEquals(1, actualRecords.length);
    assertArrayEquals(new String[]{"java.lang.String"}, (actualRecords[0]).getType());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   * with {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject},
   * {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria10()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup("ProductList");
    systemPropertyImpl.setFriendlyName("ProductList");
    systemPropertyImpl.setFriendlyTab("ProductList");
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName("ProductList");
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(new SystemPropertyFieldType("ProductList", "ProductList"));
    systemPropertyImpl.setValue("42");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(systemPropertyImpl);
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records,
        new HashMap<>(), "Path To Target Object", new String[]{"Custom Criteria"});

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    Entity entity = actualRecords[0];
    Map<String, Property> pMap = entity.getPMap();
    assertEquals(2, pMap.size());
    Property getResult = pMap.get("__adminMainEntity");
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    Property getResult2 = pMap.get(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    FieldMetadata metadata2 = getResult2.getMetadata();
    assertTrue(metadata2 instanceof BasicFieldMetadata);
    assertEquals("ProductList", getResult.getRawValue());
    assertEquals("ProductList", getResult2.getRawValue());
    assertEquals("ProductList", getResult.getUnHtmlEncodedValue());
    assertEquals("ProductList", getResult2.getUnHtmlEncodedValue());
    assertEquals("ProductList", getResult.getValue());
    assertEquals("ProductList", getResult2.getValue());
    assertEquals("__adminMainEntity", getResult.getName());
    assertNull(((BasicFieldMetadata) metadata2).getCustomCriteria());
    assertNull(metadata2.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata2).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata2).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata2).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata2).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata2).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata2).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata2).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata2).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata2).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata2).getMutable());
    assertNull(((BasicFieldMetadata) metadata2).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata2).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata2).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata2).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata2).getSearchable());
    assertNull(((BasicFieldMetadata) metadata2).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata2).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata2).getUnique());
    assertNull(((BasicFieldMetadata) metadata2).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata2).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata2).isProminent());
    assertNull(metadata2.getChildrenExcluded());
    assertNull(metadata2.getExcluded());
    assertNull(metadata2.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata2).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata2).getLength());
    assertNull(((BasicFieldMetadata) metadata2).getPrecision());
    assertNull(((BasicFieldMetadata) metadata2).getScale());
    assertNull(metadata2.getGroupOrder());
    assertNull(metadata2.getOrder());
    assertNull(metadata2.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata2).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata2).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata2).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata2).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata2).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata2).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata2).getHelpText());
    assertNull(((BasicFieldMetadata) metadata2).getHint());
    assertNull(((BasicFieldMetadata) metadata2).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata2).getManyToField());
    assertNull(((BasicFieldMetadata) metadata2).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata2).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata2).getName());
    assertNull(((BasicFieldMetadata) metadata2).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata2).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata2).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata2).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata2).getTooltip());
    assertNull(metadata2.getAddFriendlyName());
    assertNull(metadata2.getCurrencyCodeField());
    assertNull(metadata2.getFieldName());
    assertNull(metadata2.getFriendlyName());
    assertNull(metadata2.getGroup());
    assertNull(metadata2.getInheritedFromType());
    assertNull(metadata2.getOwningClass());
    assertNull(metadata2.getOwningClassFriendlyName());
    assertNull(metadata2.getPrefix());
    assertNull(metadata2.getSecurityLevel());
    assertNull(metadata2.getShowIfProperty());
    assertNull(metadata2.getTab());
    assertNull(metadata2.getTargetClass());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult2.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult2.getOriginalValue());
    assertNull(getResult.getDeployDate());
    assertNull(getResult2.getDeployDate());
    assertNull(metadata2.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata2).getLookupType());
    assertNull(((BasicFieldMetadata) metadata2).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata2).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata2).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata2).getFieldType());
    assertNull(((BasicFieldMetadata) metadata2).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata2).getVisibility());
    assertNull(((BasicFieldMetadata) metadata2).getMergedPropertyType());
    assertEquals(1, actualRecords.length);
    Property[] properties = entity.getProperties();
    assertEquals(2, properties.length);
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata2).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata2).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata2).getRequired());
    assertFalse(metadata2.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(getResult2.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata2).getValidationConfigurations().isEmpty());
    assertTrue(metadata2.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata2).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
    assertTrue(getResult2.getEnabled());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getName());
    assertEquals(metadata2, metadata);
    assertSame(getResult, properties[0]);
    assertSame(getResult2, properties[1]);
    assertArrayEquals(new String[]{"org.broadleafcommerce.common.config.domain.SystemPropertyImpl"}, entity.getType());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   * with {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject},
   * {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria11()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = mock(SystemPropertyImpl.class);
    when(systemPropertyImpl.getMainEntityName()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(systemPropertyImpl);
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records,
        new HashMap<>(), "Path To Target Object", new String[]{"Custom Criteria"});

    // Assert
    verify(systemPropertyImpl, atLeast(1)).getMainEntityName();
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    assertEquals(1, actualRecords.length);
    assertArrayEquals(
        new String[]{"org.broadleafcommerce.common.config.domain.SystemPropertyImpl$MockitoMock$SPTbl1pm"},
        (actualRecords[0]).getType());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   * with {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject},
   * {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(mock(FieldManager.class));
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records,
        new HashMap<>(), null, new String[]{"Custom Criteria"});

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    assertEquals(1, actualRecords.length);
    assertArrayEquals(new String[]{"java.text.SimpleDateFormat"}, (actualRecords[0]).getType());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   * with {@code primaryUnfilteredMergedProperties}, {@code records},
   * {@code alternateUnfilteredMergedProperties}, {@code pathToTargetObject},
   * {@code customCriteria}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria13() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5134 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act
    basicPersistenceModule2.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object", new String[]{"Custom Criteria"});
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getSimpleMergedProperties(String, PersistencePerspective)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getSimpleMergedProperties(String, PersistencePerspective)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSimpleMergedProperties() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5290 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.getSimpleMergedProperties("Entity Name", new PersistencePerspective());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getSimpleMergedProperties(String, PersistencePerspective)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getSimpleMergedProperties(String, PersistencePerspective)}
   */
  @Test
  public void testGetSimpleMergedProperties_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    Map<String, FieldMetadata> actualSimpleMergedProperties = basicPersistenceModule
        .getSimpleMergedProperties("Entity Name", new PersistencePerspective());

    // Assert
    verify(dynamicEntityDaoImpl).getSimpleMergedProperties(eq("Entity Name"), isA(PersistencePerspective.class));
    verify(persistenceManager).getDynamicEntityDao();
    assertTrue(actualSimpleMergedProperties.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map, Serializable, List, String[])}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map, Serializable, List, String[])}
   */
  @Test
  public void testExtractPropertiesFromPersistentEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    SimpleDateFormat entity = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    basicPersistenceModule.extractPropertiesFromPersistentEntity(mergedProperties, entity, new ArrayList<>(),
        new String[]{"Custom Criteria"});

    // Assert
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map, Serializable, List, String[])}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map, Serializable, List, String[])}
   */
  @Test
  public void testExtractPropertiesFromPersistentEntity2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    SimpleDateFormat entity = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    basicPersistenceModule.extractPropertiesFromPersistentEntity(mergedProperties, entity, new ArrayList<>(),
        new String[]{"Custom Criteria"});

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map, Serializable, List, String[])}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map, Serializable, List, String[])}
   */
  @Test
  public void testExtractPropertiesFromPersistentEntity3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    SimpleDateFormat entity = new SimpleDateFormat("yyyy/mm/dd");

    ArrayList<Property> props = new ArrayList<>();
    props.add(new Property());

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class, () -> basicPersistenceModule
        .extractPropertiesFromPersistentEntity(mergedProperties, entity, props, new String[]{"Custom Criteria"}));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map, Serializable, List, String[])}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map, Serializable, List, String[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExtractPropertiesFromPersistentEntity4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3029 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    SimpleDateFormat entity = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    basicPersistenceModule2.extractPropertiesFromPersistentEntity(mergedProperties, entity, new ArrayList<>(),
        new String[]{"Custom Criteria"});
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getStringValueFromGetter(Serializable, String)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getStringValueFromGetter(Serializable, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetStringValueFromGetter()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5375 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.getStringValueFromGetter(new SimpleDateFormat("yyyy/mm/dd"), "Property Name");
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getStringValueFromGetter(Serializable, String)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getStringValueFromGetter(Serializable, String)}
   */
  @Test
  public void testGetStringValueFromGetter_givenEmptyString_whenEmptyString_thenReturn42()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<Object, Object> instance = new HashMap<>();
    instance.put("", "42");

    // Act and Assert
    assertEquals("42", basicPersistenceModule.getStringValueFromGetter(instance, ""));
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getStringValueFromGetter(Serializable, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getStringValueFromGetter(Serializable, String)}
   */
  @Test
  public void testGetStringValueFromGetter_whenHashMap_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    // Act and Assert
    assertNull(basicPersistenceModule.getStringValueFromGetter(new HashMap<>(), "Property Name"));
  }

  /**
   * Test {@link BasicPersistenceModule#formatValue(Object)}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#formatValue(Object)}
   */
  @Test
  public void testFormatValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act and Assert
    assertEquals("Value", basicPersistenceModule.formatValue("Value"));
  }

  /**
   * Test {@link BasicPersistenceModule#formatValue(Object)}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#formatValue(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFormatValue2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3223 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicPersistenceModule()).formatValue("Value");
  }

  /**
   * Test {@link BasicPersistenceModule#formatValue(Object)}.
   * <ul>
   *   <li>Given {@link BasicPersistenceModule} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#formatValue(Object)}
   */
  @Test
  public void testFormatValue_givenBasicPersistenceModule_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BasicPersistenceModule()).formatValue(null));
  }

  /**
   * Test {@link BasicPersistenceModule#formatValue(Object)}.
   * <ul>
   *   <li>Given {@link BasicPersistenceModule} (default constructor).</li>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#formatValue(Object)}
   */
  @Test
  public void testFormatValue_givenBasicPersistenceModule_whenValue_thenReturnValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Value", (new BasicPersistenceModule()).formatValue("Value"));
  }

  /**
   * Test {@link BasicPersistenceModule#update(PersistencePackage)} with
   * {@code persistencePackage}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#update(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateWithPersistencePackage() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5763 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.update(new PersistencePackage());
  }

  /**
   * Test {@link BasicPersistenceModule#update(PersistencePackage, boolean)} with
   * {@code persistencePackage}, {@code includeRealEntityObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#update(PersistencePackage, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateWithPersistencePackageIncludeRealEntityObject() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5860 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.update(new PersistencePackage(), true);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#update(PersistencePackage, Object, boolean)}
   * with {@code persistencePackage}, {@code primaryKey},
   * {@code includeRealEntity}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#update(PersistencePackage, Object, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateWithPersistencePackagePrimaryKeyIncludeRealEntity() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5797 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.update(new PersistencePackage(), "Primary Key", true);
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(String)} with
   * {@code entityClass}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIdPropertyNameWithEntityClass() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3485 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicPersistenceModule()).getIdPropertyName("Entity Class");
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(String)} with
   * {@code entityClass}.
   * <ul>
   *   <li>Then return {@code Id Property Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(String)}
   */
  @Test
  public void testGetIdPropertyNameWithEntityClass_thenReturnIdPropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getIdPropertyName(Mockito.<String>any())).thenReturn("Id Property Name");

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    String actualIdPropertyName = basicPersistenceModule.getIdPropertyName("Entity Class");

    // Assert
    verify(persistenceManager).getIdPropertyName(eq("Entity Class"));
    assertEquals("Id Property Name", actualIdPropertyName);
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with
   * {@code mergedUnfilteredProperties}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  public void testGetIdPropertyNameWithMergedUnfilteredProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed merged properties list",
        new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with
   * {@code mergedUnfilteredProperties}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  public void testGetIdPropertyNameWithMergedUnfilteredProperties2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.computeIfPresent(
        "Could not find a primary key property in the passed merged properties list", mock(BiFunction.class));
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed merged properties list",
        basicFieldMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with
   * {@code mergedUnfilteredProperties}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  public void testGetIdPropertyNameWithMergedUnfilteredProperties3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.computeIfPresent(
        "Could not find a primary key property in the passed merged properties list", mock(BiFunction.class));
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed merged properties list",
        basicFieldMetadata);

    // Act
    String actualIdPropertyName = basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties);

    // Assert
    verify(basicFieldMetadata).getFieldType();
    assertEquals("Could not find a primary key property in the passed merged properties list", actualIdPropertyName);
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with
   * {@code mergedUnfilteredProperties}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  public void testGetIdPropertyNameWithMergedUnfilteredProperties4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenThrow(new ParentEntityPersistenceException("An error occurred"));

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.computeIfPresent(
        "Could not find a primary key property in the passed merged properties list", mock(BiFunction.class));
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed merged properties list",
        basicFieldMetadata);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with
   * {@code mergedUnfilteredProperties}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIdPropertyNameWithMergedUnfilteredProperties5() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3813 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.getIdPropertyName(new HashMap<>());
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with
   * {@code mergedUnfilteredProperties}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  public void testGetIdPropertyNameWithMergedUnfilteredProperties_givenBasicFieldMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.computeIfPresent(
        "Could not find a primary key property in the passed merged properties list", mock(BiFunction.class));
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed merged properties list",
        new BasicFieldMetadata());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with
   * {@code mergedUnfilteredProperties}.
   * <ul>
   *   <li>Given {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  public void testGetIdPropertyNameWithMergedUnfilteredProperties_givenDot() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.computeIfPresent(
        "Could not find a primary key property in the passed merged properties list", mock(BiFunction.class));
    mergedUnfilteredProperties.put(".", basicFieldMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with
   * {@code mergedUnfilteredProperties}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  public void testGetIdPropertyNameWithMergedUnfilteredProperties_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicPersistenceModule.getIdPropertyName(new HashMap<>()));
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPrimaryKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4245 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    Entity entity = new Entity();

    // Act
    basicPersistenceModule2.getPrimaryKey(entity, new HashMap<>());
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey_givenAdornedTargetCollectionMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed entity with type: ",
        new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(entity).getType();
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   * <ul>
   *   <li>Given array of {@link Property} with
   * {@link Property#Property(String, String)} with name is {@code .} and value is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey_givenArrayOfPropertyWithPropertyWithNameIsDotAndValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property(".", "42")});
    when(entity.getType()).thenReturn(new String[]{"Type"});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed entity with type: ",
        basicFieldMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(entity).getProperties();
    verify(entity).getType();
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey_givenBasicFieldMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed entity with type: ",
        new BasicFieldMetadata());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(entity).getType();
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata}
   * {@link BasicFieldMetadata#getFieldType()} return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey_givenBasicFieldMetadataGetFieldTypeReturnUnknown() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed entity with type: ",
        basicFieldMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(entity).getType();
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code .} is
   * {@link BasicFieldMetadata}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey_givenDot_whenHashMapDotIsBasicFieldMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put(".", basicFieldMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(entity).getType();
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code Name}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey_givenPropertyGetNameReturnName_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});
    when(entity.getType()).thenReturn(new String[]{"Type"});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed entity with type: ",
        basicFieldMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(entity).getProperties();
    verify(entity).getType();
    verify(property).getName();
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getSecondaryType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey_thenCallsGetSecondaryType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Could not find a primary key property in the passed entity with type: ");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});
    when(entity.getType()).thenReturn(new String[]{"Type"});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getSecondaryType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed entity with type: ",
        basicFieldMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata).getSecondaryType();
    verify(entity).getProperties();
    verify(entity).getType();
    verify(property).getName();
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   * <ul>
   *   <li>Then throw {@link ParentEntityPersistenceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey_thenThrowParentEntityPersistenceException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Could not find a primary key property in the passed entity with type: ");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getSecondaryType()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed entity with type: ",
        basicFieldMetadata);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata).getSecondaryType();
    verify(entity).getProperties();
    verify(property).getName();
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey_whenHashMap_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicPersistenceModule.getPrimaryKey(entity, new HashMap<>()));
    verify(entity).getType();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   * with {@code persistencePerspective}, {@code cto},
   * {@code ceilingEntityFullyQualifiedClassname},
   * {@code mergedUnfilteredProperties}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   */
  @Test
  public void testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act and Assert
    assertTrue(basicPersistenceModule.getFilterMappings(persistencePerspective, cto, "Dr Jane Doe", new HashMap<>())
        .isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   * with {@code persistencePerspective}, {@code cto},
   * {@code ceilingEntityFullyQualifiedClassname},
   * {@code mergedUnfilteredProperties}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   */
  @Test
  public void testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredProperties2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act and Assert
    assertTrue(basicPersistenceModule.getFilterMappings(persistencePerspective, cto, "Dr Jane Doe", new HashMap<>())
        .isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   * with {@code persistencePerspective}, {@code cto},
   * {@code ceilingEntityFullyQualifiedClassname},
   * {@code mergedUnfilteredProperties}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   */
  @Test
  public void testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredProperties3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    // Act
    List<FilterMapping> actualFilterMappings = basicPersistenceModule.getFilterMappings(persistencePerspective, cto,
        "Dr Jane Doe", new HashMap<>());

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   * with {@code persistencePerspective}, {@code cto},
   * {@code ceilingEntityFullyQualifiedClassname},
   * {@code mergedUnfilteredProperties}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   */
  @Test
  public void testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredProperties4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("foo", new FilterAndSortCriteria("42"));
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);

    // Act
    List<FilterMapping> actualFilterMappings = basicPersistenceModule.getFilterMappings(persistencePerspective, cto,
        "Dr Jane Doe", new HashMap<>());

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   * with {@code persistencePerspective}, {@code cto},
   * {@code ceilingEntityFullyQualifiedClassname},
   * {@code mergedUnfilteredProperties}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   */
  @Test
  public void testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredProperties5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    List<FilterMapping> actualFilterMappings = basicPersistenceModule.getFilterMappings(persistencePerspective, cto,
        "Dr Jane Doe", mergedUnfilteredProperties);

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   * with {@code persistencePerspective}, {@code cto},
   * {@code ceilingEntityFullyQualifiedClassname},
   * {@code mergedUnfilteredProperties}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredProperties6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3346 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    basicPersistenceModule2.getFilterMappings(persistencePerspective, cto, "Dr Jane Doe", new HashMap<>());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)}
   * with {@code persistencePerspective}, {@code cto},
   * {@code ceilingEntityFullyQualifiedClassname},
   * {@code mergedUnfilteredProperties}, {@code customRestrictionFactory}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  public void testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredPropertiesCustomRestrictionFactory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act and Assert
    assertTrue(basicPersistenceModule
        .getFilterMappings(persistencePerspective, cto, "Dr Jane Doe", new HashMap<>(), mock(RestrictionFactory.class))
        .isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)}
   * with {@code persistencePerspective}, {@code cto},
   * {@code ceilingEntityFullyQualifiedClassname},
   * {@code mergedUnfilteredProperties}, {@code customRestrictionFactory}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  public void testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredPropertiesCustomRestrictionFactory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    // Act
    List<FilterMapping> actualFilterMappings = basicPersistenceModule.getFilterMappings(persistencePerspective, cto,
        "Dr Jane Doe", new HashMap<>(), mock(RestrictionFactory.class));

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)}
   * with {@code persistencePerspective}, {@code cto},
   * {@code ceilingEntityFullyQualifiedClassname},
   * {@code mergedUnfilteredProperties}, {@code customRestrictionFactory}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  public void testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredPropertiesCustomRestrictionFactory3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("foo", new FilterAndSortCriteria("42"));
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);

    // Act
    List<FilterMapping> actualFilterMappings = basicPersistenceModule.getFilterMappings(persistencePerspective, cto,
        "Dr Jane Doe", new HashMap<>(), mock(RestrictionFactory.class));

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)}
   * with {@code persistencePerspective}, {@code cto},
   * {@code ceilingEntityFullyQualifiedClassname},
   * {@code mergedUnfilteredProperties}, {@code customRestrictionFactory}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  public void testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredPropertiesCustomRestrictionFactory4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    List<FilterMapping> actualFilterMappings = basicPersistenceModule.getFilterMappings(persistencePerspective, cto,
        "Dr Jane Doe", mergedUnfilteredProperties, mock(RestrictionFactory.class));

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)}
   * with {@code persistencePerspective}, {@code cto},
   * {@code ceilingEntityFullyQualifiedClassname},
   * {@code mergedUnfilteredProperties}, {@code customRestrictionFactory}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredPropertiesCustomRestrictionFactory5() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3414 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    basicPersistenceModule2.getFilterMappings(persistencePerspective, cto, "Dr Jane Doe", new HashMap<>(),
        mock(RestrictionFactory.class));
  }

  /**
   * Test {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExtractProperties() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2383 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();

    // Act
    basicPersistenceModule2.extractProperties(new Class[]{forNameResult}, mergedProperties, new ArrayList<>());
  }

  /**
   * Test {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.computeIfPresent(MergedPropertyType.PRIMARY, mock(BiFunction.class));
    mergedProperties.put(MergedPropertyType.PRIMARY, new HashMap<>());
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_givenHashMap_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.PRIMARY, new HashMap<>());
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_thenArrayListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", new AdornedTargetCollectionMetadata());

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.PRIMARY, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(1, properties.size());
    assertEquals("foo", properties.get(0).getName());
  }

  /**
   * Test {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_thenArrayListSizeIsThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("", new AdornedTargetCollectionMetadata());
    stringFieldMetadataMap.put("42", new AdornedTargetCollectionMetadata());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.PRIMARY, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(3, properties.size());
    assertEquals("", properties.get(0).getName());
    assertEquals("42", properties.get(1).getName());
    Property getResult = properties.get(2);
    assertEquals("foo", getResult.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Test {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties_thenArrayListSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("42", new AdornedTargetCollectionMetadata());
    stringFieldMetadataMap.put("foo", new AdornedTargetCollectionMetadata());

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.PRIMARY, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(2, properties.size());
    assertEquals("42", properties.get(0).getName());
    assertEquals("foo", properties.get(1).getName());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties, true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(1, properties.size());
    Property getResult = properties.get(0);
    assertEquals("foo", getResult.getName());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExtractPropertiesFromMetadata2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2708 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    // Act
    basicPersistenceModule2.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties,
        new ArrayList<>(), true, MergedPropertyType.PRIMARY);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata_given42_thenArrayListSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("42", new AdornedTargetCollectionMetadata());
    mergedProperties.put("foo", new AdornedTargetCollectionMetadata());
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties, true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(2, properties.size());
    assertEquals("42", properties.get(0).getName());
    assertEquals("foo", properties.get(1).getName());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata_givenBasicFieldMetadata_thenHashMapSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    mergedProperties.put("foo", basicFieldMetadata);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties, true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("foo");
    assertTrue(getResult instanceof BasicFieldMetadata);
    assertEquals(1, properties.size());
    assertEquals(VisibilityEnum.HIDDEN_ALL, ((BasicFieldMetadata) getResult).getVisibility());
    assertSame(basicFieldMetadata, properties.get(0).getMetadata());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata}.</li>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata_givenBasicFieldMetadata_whenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", mock(BasicFieldMetadata.class));
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties,
        false, MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(1, properties.size());
    assertEquals("foo", properties.get(0).getName());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.computeIfPresent("foo", mock(BiFunction.class));
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties, true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(1, properties.size());
    Property getResult = properties.get(0);
    assertEquals("foo", getResult.getName());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata_givenEmptyString_thenArrayListSizeIsThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("", new AdornedTargetCollectionMetadata());
    mergedProperties.put("42", new AdornedTargetCollectionMetadata());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties, true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(3, properties.size());
    assertEquals("", properties.get(0).getName());
    assertEquals("42", properties.get(1).getName());
    Property getResult = properties.get(2);
    assertEquals("foo", getResult.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#setVisibility(VisibilityEnum)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata_thenCallsSetVisibility() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    doNothing().when(basicFieldMetadata).setVisibility(Mockito.<VisibilityEnum>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", basicFieldMetadata);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties, true,
        MergedPropertyType.PRIMARY);

    // Assert
    verify(basicFieldMetadata).setVisibility(eq(VisibilityEnum.HIDDEN_ALL));
    assertEquals(1, properties.size());
    assertEquals("foo", properties.get(0).getName());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}.
   * <ul>
   *   <li>Then throw {@link ParentEntityPersistenceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata_thenThrowParentEntityPersistenceException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    doThrow(new ParentEntityPersistenceException("An error occurred")).when(basicFieldMetadata)
        .setVisibility(Mockito.<VisibilityEnum>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", basicFieldMetadata);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties,
            new ArrayList<>(), true, MergedPropertyType.PRIMARY));
    verify(basicFieldMetadata).setVisibility(eq(VisibilityEnum.HIDDEN_ALL));
  }

  /**
   * Test
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata_whenHashMap_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties, true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertTrue(properties.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#updateMergedProperties(PersistencePackage, Map)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#updateMergedProperties(PersistencePackage, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateMergedProperties() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5895 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    basicPersistenceModule2.updateMergedProperties(persistencePackage, new HashMap<>());
  }

  /**
   * Test {@link BasicPersistenceModule#add(PersistencePackage)} with
   * {@code persistencePackage}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#add(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithPersistencePackage() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1617 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.add(new PersistencePackage());
  }

  /**
   * Test {@link BasicPersistenceModule#add(PersistencePackage, boolean)} with
   * {@code persistencePackage}, {@code includeRealEntityObject}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#add(PersistencePackage, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddWithPersistencePackageIncludeRealEntityObject() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1651 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.add(new PersistencePackage(), true);
  }

  /**
   * Test {@link BasicPersistenceModule#remove(PersistencePackage)}.
   * <p>
   * Method under test: {@link BasicPersistenceModule#remove(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemove() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5729 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.remove(new PersistencePackage());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getMergedProperties(PersistencePackage, CriteriaTransferObject)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getMergedProperties(PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMergedProperties() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4084 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    basicPersistenceModule2.getMergedProperties(persistencePackage, new CriteriaTransferObject());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#fetch(PersistencePackage, CriteriaTransferObject)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#fetch(PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFetch() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3154 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    basicPersistenceModule2.fetch(persistencePackage, new CriteriaTransferObject());
  }

  /**
   * Test {@link BasicPersistenceModule#getTotalRecords(String, List)} with
   * {@code ceilingEntity}, {@code filterMappings}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getTotalRecords(String, List)}
   */
  @Test
  public void testGetTotalRecordsWithCeilingEntityFilterMappings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao())
        .thenThrow(new CriteriaConversionException("An error occurred", fieldPath));

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act and Assert
    assertThrows(CriteriaConversionException.class,
        () -> basicPersistenceModule.getTotalRecords("Ceiling Entity", new ArrayList<>()));
    verify(persistenceManager).getDynamicEntityDao();
    verify(fieldPath).getTargetProperty();
  }

  /**
   * Test {@link BasicPersistenceModule#getTotalRecords(String, List)} with
   * {@code ceilingEntity}, {@code filterMappings}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getTotalRecords(String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTotalRecordsWithCeilingEntityFilterMappings2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5486 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.getTotalRecords("Ceiling Entity", new ArrayList<>());
  }

  /**
   * Test {@link BasicPersistenceModule#getTotalRecords(FetchRequest)} with
   * {@code fetchRequest}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getTotalRecords(FetchRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTotalRecordsWithFetchRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5521 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    basicPersistenceModule2
        .getTotalRecords(new FetchRequest(persistencePackage, cto, "Ceiling Entity", new ArrayList<>()));
  }

  /**
   * Test {@link BasicPersistenceModule#getMaxValue(String, List, String)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getMaxValue(String, List, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMaxValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4030 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.getMaxValue("Ceiling Entity", new ArrayList<>(), "Max Field");
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getPersistentRecords(String, List, Integer, Integer)}
   * with {@code ceilingEntity}, {@code filterMappings}, {@code firstResult},
   * {@code maxResults}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getPersistentRecords(String, List, Integer, Integer)}
   */
  @Test
  public void testGetPersistentRecordsWithCeilingEntityFilterMappingsFirstResultMaxResults() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao())
        .thenThrow(new CriteriaConversionException("An error occurred", fieldPath));

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act and Assert
    assertThrows(CriteriaConversionException.class,
        () -> basicPersistenceModule.getPersistentRecords("Ceiling Entity", new ArrayList<>(), 1, 3));
    verify(persistenceManager).getDynamicEntityDao();
    verify(fieldPath).getTargetProperty();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getPersistentRecords(String, List, Integer, Integer)}
   * with {@code ceilingEntity}, {@code filterMappings}, {@code firstResult},
   * {@code maxResults}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getPersistentRecords(String, List, Integer, Integer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPersistentRecordsWithCeilingEntityFilterMappingsFirstResultMaxResults2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4134 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.getPersistentRecords("Ceiling Entity", new ArrayList<>(), 1, 3);
  }

  /**
   * Test {@link BasicPersistenceModule#getPersistentRecords(FetchRequest)} with
   * {@code fetchRequest}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getPersistentRecords(FetchRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPersistentRecordsWithFetchRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4183 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    basicPersistenceModule2
        .getPersistentRecords(new FetchRequest(persistencePackage, cto, "Ceiling Entity", new ArrayList<>()));
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map)} with
   * {@code entity}, {@code populatedInstance}, {@code mergedProperties}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#validate(Entity, Serializable, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateWithEntityPopulatedInstanceMergedProperties() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5936 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    Entity entity = new Entity();
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    basicPersistenceModule2.validate(entity, populatedInstance, new HashMap<>());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)}
   * with {@code entity}, {@code populatedInstance}, {@code mergedProperties},
   * {@code validateUnsubmittedProperties}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)}
   */
  @Test
  public void testValidateWithEntityPopulatedInstanceMergedPropertiesValidateUnsubmittedProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorService entityValidatorService = mock(EntityValidatorService.class);
    doNothing().when(entityValidatorService)
        .validate(Mockito.<Entity>any(), Mockito.<Serializable>any(), Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(), anyBoolean());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setEntityValidatorService(entityValidatorService);
    Entity entity = new Entity();
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult = basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>(), true);

    // Assert
    verify(entityValidatorService).validate(isA(Entity.class), isA(Serializable.class), isA(Map.class),
        isA(RecordHelper.class), eq(true));
    assertTrue(actualValidateResult);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)}
   * with {@code entity}, {@code populatedInstance}, {@code mergedProperties},
   * {@code validateUnsubmittedProperties}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)}
   */
  @Test
  public void testValidateWithEntityPopulatedInstanceMergedPropertiesValidateUnsubmittedProperties2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorService entityValidatorService = mock(EntityValidatorService.class);
    doNothing().when(entityValidatorService)
        .validate(Mockito.<Entity>any(), Mockito.<Serializable>any(), Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(), anyBoolean());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setEntityValidatorService(entityValidatorService);
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult = basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>(), true);

    // Assert
    verify(entity).isValidationFailure();
    verify(entityValidatorService).validate(isA(Entity.class), isA(Serializable.class), isA(Map.class),
        isA(RecordHelper.class), eq(true));
    assertFalse(actualValidateResult);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)}
   * with {@code entity}, {@code populatedInstance}, {@code mergedProperties},
   * {@code validateUnsubmittedProperties}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateWithEntityPopulatedInstanceMergedPropertiesValidateUnsubmittedProperties3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6054 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    Entity entity = new Entity();
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    basicPersistenceModule2.validate(entity, populatedInstance, new HashMap<>(), true);
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map)} with
   * {@code entity}, {@code populatedInstance}, {@code mergedProperties}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#validate(Entity, Serializable, Map)}
   */
  @Test
  public void testValidateWithEntityPopulatedInstanceMergedProperties_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorService entityValidatorService = mock(EntityValidatorService.class);
    doNothing().when(entityValidatorService)
        .validate(Mockito.<Entity>any(), Mockito.<Serializable>any(), Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(), anyBoolean());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setEntityValidatorService(entityValidatorService);
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult = basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>());

    // Assert
    verify(entity).isValidationFailure();
    verify(entityValidatorService).validate(isA(Entity.class), isA(Serializable.class), isA(Map.class),
        isA(RecordHelper.class), eq(true));
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map)} with
   * {@code entity}, {@code populatedInstance}, {@code mergedProperties}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#validate(Entity, Serializable, Map)}
   */
  @Test
  public void testValidateWithEntityPopulatedInstanceMergedProperties_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorService entityValidatorService = mock(EntityValidatorService.class);
    doNothing().when(entityValidatorService)
        .validate(Mockito.<Entity>any(), Mockito.<Serializable>any(), Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(), anyBoolean());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setEntityValidatorService(entityValidatorService);
    Entity entity = new Entity();
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult = basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>());

    // Assert
    verify(entityValidatorService).validate(isA(Entity.class), isA(Serializable.class), isA(Map.class),
        isA(RecordHelper.class), eq(true));
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#getCompatibleModule(OperationType)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getCompatibleModule(OperationType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCompatibleModule() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3294 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BasicPersistenceModule()).getCompatibleModule(OperationType.NONDESTRUCTIVEREMOVE);
  }

  /**
   * Test {@link BasicPersistenceModule#getCompatibleModule(OperationType)}.
   * <ul>
   *   <li>Then return {@link AdornedTargetListPersistenceModule} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getCompatibleModule(OperationType)}
   */
  @Test
  public void testGetCompatibleModule_thenReturnAdornedTargetListPersistenceModule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    when(persistenceManager.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    PersistenceModule actualCompatibleModule = basicPersistenceModule
        .getCompatibleModule(OperationType.NONDESTRUCTIVEREMOVE);

    // Assert
    verify(persistenceManager).getCompatibleModule(eq(OperationType.NONDESTRUCTIVEREMOVE));
    assertSame(adornedTargetListPersistenceModule, actualCompatibleModule);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicPersistenceModule#setApplicationContext(ApplicationContext)}
   *   <li>{@link BasicPersistenceModule#setCriteriaTranslator(CriteriaTranslator)}
   *   <li>
   * {@link BasicPersistenceModule#setDefaultFieldPersistenceProvider(FieldPersistenceProvider)}
   *   <li>
   * {@link BasicPersistenceModule#setEntityValidatorService(EntityValidatorService)}
   *   <li>{@link BasicPersistenceModule#setFieldPersistenceProviders(List)}
   *   <li>{@link BasicPersistenceModule#setPersistenceManager(PersistenceManager)}
   *   <li>{@link BasicPersistenceModule#setRestrictionFactory(RestrictionFactory)}
   *   <li>{@link BasicPersistenceModule#getCriteriaTranslator()}
   *   <li>{@link BasicPersistenceModule#getDefaultFieldPersistenceProvider()}
   *   <li>{@link BasicPersistenceModule#getEntityValidatorService()}
   *   <li>{@link BasicPersistenceModule#getFieldPersistenceProviders()}
   *   <li>{@link BasicPersistenceModule#getPersistenceManager()}
   *   <li>{@link BasicPersistenceModule#getRestrictionFactory()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    // Act
    basicPersistenceModule.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    CriteriaTranslatorImpl criteriaTranslator = new CriteriaTranslatorImpl();
    basicPersistenceModule.setCriteriaTranslator(criteriaTranslator);
    BasicFieldPersistenceProvider defaultFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    basicPersistenceModule.setDefaultFieldPersistenceProvider(defaultFieldPersistenceProvider);
    BeanValidationEntityValidatorServiceImpl entityValidatorService = new BeanValidationEntityValidatorServiceImpl();
    basicPersistenceModule.setEntityValidatorService(entityValidatorService);
    ArrayList<FieldPersistenceProvider> fieldPersistenceProviders = new ArrayList<>();
    basicPersistenceModule.setFieldPersistenceProviders(fieldPersistenceProviders);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    RestrictionFactory restrictionFactory = mock(RestrictionFactory.class);
    basicPersistenceModule.setRestrictionFactory(restrictionFactory);
    CriteriaTranslator actualCriteriaTranslator = basicPersistenceModule.getCriteriaTranslator();
    FieldPersistenceProvider actualDefaultFieldPersistenceProvider = basicPersistenceModule
        .getDefaultFieldPersistenceProvider();
    EntityValidatorService actualEntityValidatorService = basicPersistenceModule.getEntityValidatorService();
    List<FieldPersistenceProvider> actualFieldPersistenceProviders = basicPersistenceModule
        .getFieldPersistenceProviders();
    PersistenceManager actualPersistenceManager = basicPersistenceModule.getPersistenceManager();
    RestrictionFactory actualRestrictionFactory = basicPersistenceModule.getRestrictionFactory();

    // Assert that nothing has changed
    assertTrue(actualCriteriaTranslator instanceof CriteriaTranslatorImpl);
    assertTrue(actualDefaultFieldPersistenceProvider instanceof BasicFieldPersistenceProvider);
    assertTrue(actualFieldPersistenceProviders.isEmpty());
    assertSame(fieldPersistenceProviders, actualFieldPersistenceProviders);
    assertSame(persistenceManager, actualPersistenceManager);
    assertSame(criteriaTranslator, actualCriteriaTranslator);
    assertSame(defaultFieldPersistenceProvider, actualDefaultFieldPersistenceProvider);
    assertSame(entityValidatorService, actualEntityValidatorService);
    assertSame(restrictionFactory, actualRestrictionFactory);
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List, String)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSpecialCaseQueryBuilder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5335 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = new FieldPath();

    // Act
    basicPersistenceModule2.getSpecialCaseQueryBuilder(embeddedCollectionPath, new ArrayList<>(), "Collection Class");
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List, String)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List, String)}
   */
  @Test
  public void testGetSpecialCaseQueryBuilder_givenFilterMapping_whenArrayListAddFilterMapping() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn("Target Property");

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertThrows(CriteriaConversionException.class, () -> basicPersistenceModule
        .getSpecialCaseQueryBuilder(embeddedCollectionPath, filterMappings, "Collection Class"));
    verify(embeddedCollectionPath).getTargetProperty();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List, String)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List, String)}
   */
  @Test
  public void testGetSpecialCaseQueryBuilder_givenFilterMapping_whenArrayListAddFilterMapping2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn("Target Property");

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertThrows(CriteriaConversionException.class, () -> basicPersistenceModule
        .getSpecialCaseQueryBuilder(embeddedCollectionPath, filterMappings, "Collection Class"));
    verify(embeddedCollectionPath).getTargetProperty();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List, String)}.
   * <ul>
   *   <li>Then throw {@link CriteriaConversionException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List, String)}
   */
  @Test
  public void testGetSpecialCaseQueryBuilder_thenThrowCriteriaConversionException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn("Target Property");

    // Act and Assert
    assertThrows(CriteriaConversionException.class, () -> basicPersistenceModule
        .getSpecialCaseQueryBuilder(embeddedCollectionPath, new ArrayList<>(), "Collection Class"));
    verify(embeddedCollectionPath).getTargetProperty();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(filterMapping.getFullPropertyName()).thenReturn("Dr Jane Doe");
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings));
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFullPropertyName();
    verify(filterMapping).getRestriction();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(mock(FilterValueConverter.class));
    when(restriction.getPredicateProvider()).thenReturn(mock(PredicateProvider.class));
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFullPropertyName()).thenReturn("Dr Jane Doe");
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings));
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFilterValues();
    verify(filterMapping).getFullPropertyName();
    verify(filterMapping, atLeast(1)).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).getPredicateProvider();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFullPropertyName()).thenReturn("");
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFullPropertyName();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);
    when(filterValueConverter.convert(Mockito.<String>any())).thenReturn("Convert");
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(filterValueConverter);
    when(restriction.getPredicateProvider()).thenReturn(mock(PredicateProvider.class));

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(".");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(fieldPath).getTargetProperty();
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping, atLeast(1)).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).getPredicateProvider();
    verify(filterValueConverter).convert(eq("."));
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings));
    verify(fieldPath).getTargetProperty();
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
  }

  /**
   * Test
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildStandardRestrictions6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2031 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = new FieldPath();

    // Act
    basicPersistenceModule2.buildStandardRestrictions(embeddedCollectionPath, new ArrayList<>());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions_givenDot_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, new ArrayList<>());

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} {@link FilterMapping#getFilterValues()}
   * return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions_givenFilterMappingGetFilterValuesReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(mock(FilterValueConverter.class));
    when(restriction.getPredicateProvider()).thenReturn(mock(PredicateProvider.class));
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(new ArrayList<>());
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFullPropertyName()).thenReturn("Dr Jane Doe");
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFilterValues();
    verify(filterMapping).getFullPropertyName();
    verify(filterMapping, atLeast(1)).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).getPredicateProvider();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} {@link FilterMapping#getFullPropertyName()}
   * return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions_givenFilterMappingGetFullPropertyNameReturnDot() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFullPropertyName()).thenReturn(".");
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFullPropertyName();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} {@link FilterMapping#getRestriction()} return
   * {@link Restriction} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions_givenFilterMappingGetRestrictionReturnRestriction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction()).thenReturn(new Restriction());
    when(filterMapping.getFullPropertyName()).thenReturn("Dr Jane Doe");
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFullPropertyName();
    verify(filterMapping).getRestriction();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions_givenFilterMapping_whenArrayListAddFilterMapping() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   * <ul>
   *   <li>Then calls {@link FilterValueConverter#convert(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions_thenCallsConvert() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);
    when(filterValueConverter.convert(Mockito.<String>any())).thenReturn("Convert");
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(filterValueConverter);
    when(restriction.getPredicateProvider()).thenReturn(mock(PredicateProvider.class));

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(".");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFullPropertyName()).thenReturn("Dr Jane Doe");
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping).getFullPropertyName();
    verify(filterMapping, atLeast(1)).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).getPredicateProvider();
    verify(filterValueConverter).convert(eq("."));
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act and Assert
    assertTrue(basicPersistenceModule.buildSpecialRestrictions("Special Expression", new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(mock(FilterValueConverter.class));
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.buildSpecialRestrictions("", filterMappings));
    verify(fieldPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFilterValues();
    verify(filterMapping).getRestriction();
    verify(restriction).getFilterValueConverter();
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);
    when(filterValueConverter.convert(Mockito.<String>any()))
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(filterValueConverter);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.buildSpecialRestrictions("", filterMappings));
    verify(fieldPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(filterValueConverter).convert(eq("foo"));
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildSpecialRestrictions4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1996 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.buildSpecialRestrictions("Special Expression", new ArrayList<>());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} {@link FilterMapping#getFieldPath()} return
   * {@link FieldPath} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions_givenFilterMappingGetFieldPathReturnFieldPath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult = basicPersistenceModule
        .buildSpecialRestrictions("Special Expression", filterMappings);

    // Assert
    verify(filterMapping, atLeast(1)).getFieldPath();
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} {@link FilterMapping#getFilterValues()}
   * return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions_givenFilterMappingGetFilterValuesReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(mock(FilterValueConverter.class));
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(new ArrayList<>());
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult = basicPersistenceModule.buildSpecialRestrictions("",
        filterMappings);

    // Assert
    verify(fieldPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFilterValues();
    verify(filterMapping).getRestriction();
    verify(restriction).getFilterValueConverter();
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} {@link FilterMapping#getRestriction()} return
   * {@link Restriction} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions_givenFilterMappingGetRestrictionReturnRestriction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction()).thenReturn(new Restriction());
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult = basicPersistenceModule.buildSpecialRestrictions("",
        filterMappings);

    // Assert
    verify(fieldPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getRestriction();
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions_givenFilterMapping_whenArrayListAddFilterMapping() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertTrue(basicPersistenceModule.buildSpecialRestrictions("Special Expression", filterMappings).isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions_givenFilterMapping_whenArrayListAddFilterMapping2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertTrue(basicPersistenceModule.buildSpecialRestrictions("Special Expression", filterMappings).isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);
    when(filterValueConverter.convert(Mockito.<String>any())).thenReturn("Convert");
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(filterValueConverter);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult = basicPersistenceModule.buildSpecialRestrictions("",
        filterMappings);

    // Assert
    verify(fieldPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(filterValueConverter).convert(eq("foo"));
    assertEquals(1, actualBuildSpecialRestrictionsResult.size());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    // Act and Assert
    assertTrue(basicPersistenceModule.buildSpecialRestrictions("Special Expression", new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   * <ul>
   *   <li>When {@code Special Expression}.</li>
   *   <li>Then calls {@link FieldPath#getTargetProperty()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions_whenSpecialExpression_thenCallsGetTargetProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult = basicPersistenceModule
        .buildSpecialRestrictions("Special Expression", filterMappings);

    // Assert
    verify(fieldPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }

  /**
   * Test
   * {@link BasicPersistenceModule#cleanupFailedPersistenceAttempt(Serializable)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#cleanupFailedPersistenceAttempt(Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCleanupFailedPersistenceAttempt() throws IllegalAccessException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2052 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();

    // Act
    basicPersistenceModule2.cleanupFailedPersistenceAttempt(new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link BasicPersistenceModule#getMapFieldType(Serializable, FieldManager, Property)}.
   * <p>
   * Method under test:
   * {@link BasicPersistenceModule#getMapFieldType(Serializable, FieldManager, Property)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMapFieldType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3832 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.BasicPersistenceModule basicPersistenceModule;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BasicPersistenceModule basicPersistenceModule2 = new BasicPersistenceModule();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);
    FieldManager fieldManager = new FieldManager(entityConfiguration,
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)));

    // Act
    basicPersistenceModule2.getMapFieldType(instance, fieldManager, new Property());
  }
}
