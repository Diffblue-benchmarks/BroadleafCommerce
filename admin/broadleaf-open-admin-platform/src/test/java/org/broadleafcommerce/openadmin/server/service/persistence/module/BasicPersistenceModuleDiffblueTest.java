package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.exception.SecurityServiceException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslator;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.BasicFieldPersistenceProvider;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.FieldPersistenceProvider;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.BeanValidationEntityValidatorServiceImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.EntityValidatorService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

@RunWith(MockitoJUnitRunner.class)
public class BasicPersistenceModuleDiffblueTest {
  @InjectMocks private BasicPersistenceModule basicPersistenceModule;

  /**
   * Test {@link BasicPersistenceModule#add(PersistencePackage)} with {@code persistencePackage}.
   *
   * <ul>
   *   <li>Then throw {@link SecurityServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#add(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity BasicPersistenceModule.add(PersistencePackage)"})
  public void testAddWithPersistencePackage_thenThrowSecurityServiceException()
      throws ServiceException {
    // Arrange
    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getMutable()).thenReturn(false);
    doNothing().when(foreignKey).setSortField(Mockito.<String>any());
    foreignKey.setSortField("Persistence Perspective");

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, foreignKey);
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", new Entity(), persistencePerspective, customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        SecurityServiceException.class, () -> basicPersistenceModule.add(persistencePackage));
    verify(foreignKey).getMutable();
    verify(foreignKey).setSortField("Persistence Perspective");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BasicPersistenceModule#setApplicationContext(ApplicationContext)}
   *   <li>{@link BasicPersistenceModule#setCriteriaTranslator(CriteriaTranslator)}
   *   <li>{@link
   *       BasicPersistenceModule#setDefaultFieldPersistenceProvider(FieldPersistenceProvider)}
   *   <li>{@link BasicPersistenceModule#setEntityValidatorService(EntityValidatorService)}
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CriteriaTranslator BasicPersistenceModule.getCriteriaTranslator()",
    "FieldPersistenceProvider BasicPersistenceModule.getDefaultFieldPersistenceProvider()",
    "EntityValidatorService BasicPersistenceModule.getEntityValidatorService()",
    "List BasicPersistenceModule.getFieldPersistenceProviders()",
    "PersistenceManager BasicPersistenceModule.getPersistenceManager()",
    "RestrictionFactory BasicPersistenceModule.getRestrictionFactory()",
    "void BasicPersistenceModule.setApplicationContext(ApplicationContext)",
    "void BasicPersistenceModule.setCriteriaTranslator(CriteriaTranslator)",
    "void BasicPersistenceModule.setDefaultFieldPersistenceProvider(FieldPersistenceProvider)",
    "void BasicPersistenceModule.setEntityValidatorService(EntityValidatorService)",
    "void BasicPersistenceModule.setFieldPersistenceProviders(List)",
    "void BasicPersistenceModule.setPersistenceManager(PersistenceManager)",
    "void BasicPersistenceModule.setRestrictionFactory(RestrictionFactory)"
  })
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    // Act
    basicPersistenceModule.setApplicationContext(mock(ApplicationContext.class));
    CriteriaTranslatorImpl criteriaTranslator = new CriteriaTranslatorImpl();
    basicPersistenceModule.setCriteriaTranslator(criteriaTranslator);
    BasicFieldPersistenceProvider defaultFieldPersistenceProvider =
        new BasicFieldPersistenceProvider();
    basicPersistenceModule.setDefaultFieldPersistenceProvider(defaultFieldPersistenceProvider);
    BeanValidationEntityValidatorServiceImpl entityValidatorService =
        new BeanValidationEntityValidatorServiceImpl();
    basicPersistenceModule.setEntityValidatorService(entityValidatorService);
    ArrayList<FieldPersistenceProvider> fieldPersistenceProviders = new ArrayList<>();
    basicPersistenceModule.setFieldPersistenceProviders(fieldPersistenceProviders);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    RestrictionFactory restrictionFactory = mock(RestrictionFactory.class);
    basicPersistenceModule.setRestrictionFactory(restrictionFactory);
    CriteriaTranslator actualCriteriaTranslator = basicPersistenceModule.getCriteriaTranslator();
    FieldPersistenceProvider actualDefaultFieldPersistenceProvider =
        basicPersistenceModule.getDefaultFieldPersistenceProvider();
    EntityValidatorService actualEntityValidatorService =
        basicPersistenceModule.getEntityValidatorService();
    List<FieldPersistenceProvider> actualFieldPersistenceProviders =
        basicPersistenceModule.getFieldPersistenceProviders();
    PersistenceManager actualPersistenceManager = basicPersistenceModule.getPersistenceManager();
    RestrictionFactory actualRestrictionFactory = basicPersistenceModule.getRestrictionFactory();

    // Assert
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
}
