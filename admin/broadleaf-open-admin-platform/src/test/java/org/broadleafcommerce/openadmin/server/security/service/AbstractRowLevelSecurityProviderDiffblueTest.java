package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.GlobalValidationResult;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractRowLevelSecurityProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractRowLevelSecurityProviderDiffblueTest {
  @Autowired private AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider;

  /**
   * Test {@link AbstractRowLevelSecurityProvider#getFetchRestrictionRoot(AdminUser, Class, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractRowLevelSecurityProvider#getFetchRestrictionRoot(AdminUser, Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class AbstractRowLevelSecurityProvider.getFetchRestrictionRoot(AdminUser, Class, List)"
  })
  public void testGetFetchRestrictionRoot_givenFilterMapping_whenArrayListAddFilterMapping() {
    // Arrange
    AdminUserImpl currentUser = new AdminUserImpl();
    Class<Serializable> ceilingEntity = Serializable.class;

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertNull(
        abstractRowLevelSecurityProvider.getFetchRestrictionRoot(
            currentUser, ceilingEntity, filterMappings));
  }

  /**
   * Test {@link AbstractRowLevelSecurityProvider#getFetchRestrictionRoot(AdminUser, Class, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractRowLevelSecurityProvider#getFetchRestrictionRoot(AdminUser, Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class AbstractRowLevelSecurityProvider.getFetchRestrictionRoot(AdminUser, Class, List)"
  })
  public void testGetFetchRestrictionRoot_givenFilterMapping_whenArrayListAddFilterMapping2() {
    // Arrange
    AdminUserImpl currentUser = new AdminUserImpl();
    Class<Serializable> ceilingEntity = Serializable.class;

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertNull(
        abstractRowLevelSecurityProvider.getFetchRestrictionRoot(
            currentUser, ceilingEntity, filterMappings));
  }

  /**
   * Test {@link AbstractRowLevelSecurityProvider#getFetchRestrictionRoot(AdminUser, Class, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractRowLevelSecurityProvider#getFetchRestrictionRoot(AdminUser, Class, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class AbstractRowLevelSecurityProvider.getFetchRestrictionRoot(AdminUser, Class, List)"
  })
  public void testGetFetchRestrictionRoot_whenArrayList() {
    // Arrange
    AdminUserImpl currentUser = new AdminUserImpl();
    Class<Serializable> ceilingEntity = Serializable.class;

    // Act and Assert
    assertNull(
        abstractRowLevelSecurityProvider.getFetchRestrictionRoot(
            currentUser, ceilingEntity, new ArrayList<>()));
  }

  /**
   * Test {@link AbstractRowLevelSecurityProvider#canUpdate(AdminUser, Entity)}.
   *
   * <p>Method under test: {@link AbstractRowLevelSecurityProvider#canUpdate(AdminUser, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractRowLevelSecurityProvider.canUpdate(AdminUser, Entity)"})
  public void testCanUpdate() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider =
        new AbstractRowLevelSecurityProvider();
    AdminUserImpl currentUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(abstractRowLevelSecurityProvider.canUpdate(currentUser, new Entity()));
  }

  /**
   * Test {@link AbstractRowLevelSecurityProvider#canRemove(AdminUser, Entity)}.
   *
   * <p>Method under test: {@link AbstractRowLevelSecurityProvider#canRemove(AdminUser, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractRowLevelSecurityProvider.canRemove(AdminUser, Entity)"})
  public void testCanRemove() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider =
        new AbstractRowLevelSecurityProvider();
    AdminUserImpl currentUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(abstractRowLevelSecurityProvider.canRemove(currentUser, new Entity()));
  }

  /**
   * Test {@link AbstractRowLevelSecurityProvider#canAdd(AdminUser, String, ClassMetadata)}.
   *
   * <p>Method under test: {@link AbstractRowLevelSecurityProvider#canAdd(AdminUser, String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractRowLevelSecurityProvider.canAdd(AdminUser, String, ClassMetadata)"
  })
  public void testCanAdd() {
    // Arrange
    AdminUserImpl currentUser = new AdminUserImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertTrue(abstractRowLevelSecurityProvider.canAdd(currentUser, "Section Class Name", cmd));
  }

  /**
   * Test {@link AbstractRowLevelSecurityProvider#validateAddRequest(AdminUser, Entity,
   * PersistencePackage)}.
   *
   * <p>Method under test: {@link AbstractRowLevelSecurityProvider#validateAddRequest(AdminUser,
   * Entity, PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GlobalValidationResult AbstractRowLevelSecurityProvider.validateAddRequest(AdminUser, Entity, PersistencePackage)"
  })
  public void testValidateAddRequest() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider =
        new AbstractRowLevelSecurityProvider();
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateAddRequestResult =
        abstractRowLevelSecurityProvider.validateAddRequest(
            currentUser, entity, new PersistencePackage());

    // Assert
    assertNull(actualValidateAddRequestResult.getErrorMessage());
    assertFalse(actualValidateAddRequestResult.isNotValid());
    assertTrue(actualValidateAddRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateAddRequestResult.isValid());
  }

  /**
   * Test {@link AbstractRowLevelSecurityProvider#validateUpdateRequest(AdminUser, Entity,
   * PersistencePackage)}.
   *
   * <p>Method under test: {@link AbstractRowLevelSecurityProvider#validateUpdateRequest(AdminUser,
   * Entity, PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GlobalValidationResult AbstractRowLevelSecurityProvider.validateUpdateRequest(AdminUser, Entity, PersistencePackage)"
  })
  public void testValidateUpdateRequest() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider =
        new AbstractRowLevelSecurityProvider();
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateUpdateRequestResult =
        abstractRowLevelSecurityProvider.validateUpdateRequest(
            currentUser, entity, new PersistencePackage());

    // Assert
    assertNull(actualValidateUpdateRequestResult.getErrorMessage());
    assertFalse(actualValidateUpdateRequestResult.isNotValid());
    assertTrue(actualValidateUpdateRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateUpdateRequestResult.isValid());
  }

  /**
   * Test {@link AbstractRowLevelSecurityProvider#validateRemoveRequest(AdminUser, Entity,
   * PersistencePackage)}.
   *
   * <p>Method under test: {@link AbstractRowLevelSecurityProvider#validateRemoveRequest(AdminUser,
   * Entity, PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GlobalValidationResult AbstractRowLevelSecurityProvider.validateRemoveRequest(AdminUser, Entity, PersistencePackage)"
  })
  public void testValidateRemoveRequest() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider =
        new AbstractRowLevelSecurityProvider();
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateRemoveRequestResult =
        abstractRowLevelSecurityProvider.validateRemoveRequest(
            currentUser, entity, new PersistencePackage());

    // Assert
    assertNull(actualValidateRemoveRequestResult.getErrorMessage());
    assertFalse(actualValidateRemoveRequestResult.isNotValid());
    assertTrue(actualValidateRemoveRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateRemoveRequestResult.isValid());
  }
}
