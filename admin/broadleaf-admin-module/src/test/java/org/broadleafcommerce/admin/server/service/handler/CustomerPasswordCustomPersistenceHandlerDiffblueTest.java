package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.security.util.PasswordReset;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerPasswordCustomPersistenceHandlerDiffblueTest {
  @InjectMocks
  private CustomerPasswordCustomPersistenceHandler customerPasswordCustomPersistenceHandler;

  @Mock private CustomerService customerService;

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CustomerPasswordCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate() {
    // Arrange
    CustomerPasswordCustomPersistenceHandler customerPasswordCustomPersistenceHandler =
        new CustomerPasswordCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleUpdateResult =
        customerPasswordCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CustomerPasswordCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate2() {
    // Arrange
    CustomerPasswordCustomPersistenceHandler customerPasswordCustomPersistenceHandler =
        new CustomerPasswordCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");

    // Act
    Boolean actualCanHandleUpdateResult =
        customerPasswordCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CustomerPasswordCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_thenReturnTrue() {
    // Arrange
    CustomerPasswordCustomPersistenceHandler customerPasswordCustomPersistenceHandler =
        new CustomerPasswordCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"passwordUpdate", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleUpdateResult =
        customerPasswordCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    assertTrue(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerPasswordCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean CustomerPasswordCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    CustomerPasswordCustomPersistenceHandler customerPasswordCustomPersistenceHandler =
        new CustomerPasswordCustomPersistenceHandler();

    // Act and Assert
    assertFalse(customerPasswordCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) EmailAddress is {@code 42 Main St}.
   *   <li>Then calls {@link CustomerService#resetPassword(PasswordReset)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerPasswordCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CustomerPasswordCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenCustomerImplEmailAddressIs42MainSt_thenCallsResetPassword()
      throws ServiceException {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setEmailAddress("42 Main St");
    when(customerService.resetPassword(Mockito.<PasswordReset>any()))
        .thenReturn(new CustomerImpl());
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"username"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    customerPasswordCustomPersistenceHandler.update(
        persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule());

    // Assert
    verify(entity, atLeast(1)).findProperty("username");
    verify(property, atLeast(1)).getValue();
    verify(customerService).readCustomerByUsername("42");
    verify(customerService).resetPassword(isA(PasswordReset.class));
  }

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) EmailAddress is empty string.
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerPasswordCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CustomerPasswordCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenCustomerImplEmailAddressIsEmptyString_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setEmailAddress("");
    when(customerService.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"username"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            customerPasswordCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).findProperty("username");
    verify(property).getValue();
    verify(customerService).readCustomerByUsername("42");
  }

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerPasswordCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CustomerPasswordCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenPropertyGetValueReturn42_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"username"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            customerPasswordCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).findProperty("username");
    verify(property).getValue();
    verify(customerService).readCustomerByUsername("42");
  }

  /**
   * Test {@link CustomerPasswordCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@link
   *       Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerPasswordCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity CustomerPasswordCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenProperty_whenEntityFindPropertyReturnProperty()
      throws ServiceException {
    // Arrange
    when(customerService.readCustomerByUsername(Mockito.<String>any()))
        .thenReturn(new CustomerImpl());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    String[] customCriteria = new String[] {"username"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            customerPasswordCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).findProperty("username");
    verify(customerService).readCustomerByUsername(null);
  }
}
