package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldNotAvailableException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
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
public class MoneyFieldPersistenceProviderDiffblueTest {
  @Autowired
  private MoneyFieldPersistenceProvider moneyFieldPersistenceProvider;

  /**
   * Test {@link MoneyFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link MoneyFieldPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.MONEY, (new MoneyFieldPersistenceProvider()).getOrder());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleExtraction() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.MoneyFieldPersistenceProvider moneyFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider2 = new MoneyFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    moneyFieldPersistenceProvider2.canHandleExtraction(extractValueRequest, new Property());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertFalse(moneyFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property()));
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getLocale(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getLocale(ExtractValueRequest, Property)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLocale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass534 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.MoneyFieldPersistenceProvider moneyFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider2 = new MoneyFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    moneyFieldPersistenceProvider2.getLocale(extractValueRequest, new Property());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getLocale(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@link Locale#UK}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getLocale(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetLocale_thenReturnUk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    Locale actualLocale = moneyFieldPersistenceProvider.getLocale(extractValueRequest, new Property());

    // Assert
    assertSame(actualLocale.UK, actualLocale);
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetCurrency() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setCurrencyCodeField("GBP");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Currency actualCurrency = moneyFieldPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    verify(extractValueRequest, atLeast(1)).getEntity();
    verify(extractValueRequest).getFieldManager();
    verify(extractValueRequest).getMetadata();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetCurrency2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setCurrencyCodeField("GBP");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Currency actualCurrency = moneyFieldPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    verify(extractValueRequest, atLeast(1)).getEntity();
    verify(extractValueRequest).getFieldManager();
    verify(extractValueRequest).getMetadata();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetCurrency3() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setCurrencyCodeField("GBP");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(BroadleafRequestContext.getBroadleafRequestContext(true));
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getFieldManager()).thenReturn(fieldManager);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Currency actualCurrency = moneyFieldPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    verify(fieldManager).getFieldValue(isA(Object.class), eq("GBP"));
    verify(extractValueRequest, atLeast(1)).getEntity();
    verify(extractValueRequest).getFieldManager();
    verify(extractValueRequest).getMetadata();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrency4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass267 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.MoneyFieldPersistenceProvider moneyFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider2 = new MoneyFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    moneyFieldPersistenceProvider2.getCurrency(extractValueRequest, new Property());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) CurrencyCodeField
   * is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetCurrency_givenBasicFieldMetadataCurrencyCodeFieldIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setCurrencyCodeField("");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Currency actualCurrency = moneyFieldPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    verify(extractValueRequest).getEntity();
    verify(extractValueRequest).getMetadata();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@link FieldManager}
   * {@link FieldManager#getFieldValue(Object, String)} return
   * {@code Field Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetCurrency_givenFieldManagerGetFieldValueReturnFieldValue()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setCurrencyCodeField("GBP");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getFieldManager()).thenReturn(fieldManager);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Currency actualCurrency = moneyFieldPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    verify(fieldManager).getFieldValue(isA(Object.class), eq("GBP"));
    verify(extractValueRequest, atLeast(1)).getEntity();
    verify(extractValueRequest).getFieldManager();
    verify(extractValueRequest).getMetadata();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@link FieldManager}
   * {@link FieldManager#getFieldValue(Object, String)} return two.</li>
   *   <li>Then calls {@link FieldManager#getFieldValue(Object, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetCurrency_givenFieldManagerGetFieldValueReturnTwo_thenCallsGetFieldValue()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setCurrencyCodeField("GBP");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(2);
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getFieldManager()).thenReturn(fieldManager);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Currency actualCurrency = moneyFieldPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    verify(fieldManager).getFieldValue(isA(Object.class), eq("GBP"));
    verify(extractValueRequest, atLeast(1)).getEntity();
    verify(extractValueRequest).getFieldManager();
    verify(extractValueRequest).getMetadata();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }

  /**
   * Test
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ExtractValueRequest}
   * {@link ExtractValueRequest#getFieldManager()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MoneyFieldPersistenceProvider#getCurrency(ExtractValueRequest, Property)}
   */
  @Test
  public void testGetCurrency_givenNull_whenExtractValueRequestGetFieldManagerReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MoneyFieldPersistenceProvider moneyFieldPersistenceProvider = new MoneyFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setCurrencyCodeField("GBP");
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getEntity()).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    when(extractValueRequest.getFieldManager()).thenReturn(null);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Currency actualCurrency = moneyFieldPersistenceProvider.getCurrency(extractValueRequest, new Property());

    // Assert
    verify(extractValueRequest, atLeast(1)).getEntity();
    verify(extractValueRequest).getFieldManager();
    verify(extractValueRequest).getMetadata();
    assertEquals("British Pound", actualCurrency.getDisplayName());
    assertEquals("GBP", actualCurrency.getCurrencyCode());
    assertEquals("GBP", actualCurrency.toString());
    assertEquals("£", actualCurrency.getSymbol());
    assertEquals(2, actualCurrency.getDefaultFractionDigits());
    assertEquals(826, actualCurrency.getNumericCode());
  }
}
