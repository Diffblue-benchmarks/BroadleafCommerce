package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FieldPersistenceProviderAdapterDiffblueTest {
  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            false,
            new Entity());

    // Act and Assert
    assertTrue(fieldPersistenceProviderAdapter.checkDirtyState(request, "Instance", "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link BasicFieldMetadata} (default constructor) DefaultValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState_given42_whenBasicFieldMetadataDefaultValueIs42()
      throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setDefaultValue("42");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertTrue(fieldPersistenceProviderAdapter.checkDirtyState(request, "Instance", "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState_givenDot_whenNull_thenReturnFalse() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertFalse(fieldPersistenceProviderAdapter.checkDirtyState(request, null, "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState_givenDot_whenOne_thenReturnFalse() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertFalse(fieldPersistenceProviderAdapter.checkDirtyState(request, 1, "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link Property#Property()} Name is {@code .}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState_givenDot_whenPropertyNameIsDot_thenReturnFalse()
      throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertFalse(
        fieldPersistenceProviderAdapter.checkDirtyState(request, "Instance", "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link Property#Property()} Name is {@code .}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState_givenDot_whenPropertyNameIsDot_thenReturnFalse2()
      throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertFalse(
        fieldPersistenceProviderAdapter.checkDirtyState(request, "Check Value", "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@code /}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState_givenDot_whenSlash_thenReturnFalse() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertFalse(fieldPersistenceProviderAdapter.checkDirtyState(request, "   /", "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState_givenEmptyString() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setDefaultValue("");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertFalse(
        fieldPersistenceProviderAdapter.checkDirtyState(request, "Instance", "Check Value"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldPersistenceProviderAdapter}
   *   <li>{@link FieldPersistenceProviderAdapter#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldPersistenceProviderAdapter.<init>()",
    "int FieldPersistenceProviderAdapter.getOrder()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.BASIC, new FieldPersistenceProviderAdapter().getOrder());
  }
}
