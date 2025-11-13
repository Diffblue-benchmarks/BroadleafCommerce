package org.broadleafcommerce.common.config.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NullSystemPropertyDiffblueTest {
  /**
   * Test {@link NullSystemProperty#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * NullSystemProperty#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse NullSystemProperty.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    NullSystemProperty nullSystemProperty = new NullSystemProperty();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext context =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    // Act
    CreateResponse<SystemProperty> actualCreateOrRetrieveCopyInstanceResult =
        nullSystemProperty.createOrRetrieveCopyInstance(context);

    // Assert
    assertNull(actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link NullSystemProperty#equals(Object)}, and {@link NullSystemProperty#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NullSystemProperty#equals(Object)}
   *   <li>{@link NullSystemProperty#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NullSystemProperty.equals(Object)",
    "int NullSystemProperty.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NullSystemProperty nullSystemProperty = new NullSystemProperty();
    NullSystemProperty nullSystemProperty2 = new NullSystemProperty();

    // Act and Assert
    assertEquals(nullSystemProperty, nullSystemProperty2);
    assertEquals(nullSystemProperty.hashCode(), nullSystemProperty2.hashCode());
  }

  /**
   * Test {@link NullSystemProperty#equals(Object)}, and {@link NullSystemProperty#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NullSystemProperty#equals(Object)}
   *   <li>{@link NullSystemProperty#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NullSystemProperty.equals(Object)",
    "int NullSystemProperty.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NullSystemProperty nullSystemProperty = new NullSystemProperty();

    // Act and Assert
    assertEquals(nullSystemProperty, nullSystemProperty);
    int expectedHashCodeResult = nullSystemProperty.hashCode();
    assertEquals(expectedHashCodeResult, nullSystemProperty.hashCode());
  }

  /**
   * Test {@link NullSystemProperty#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NullSystemProperty#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NullSystemProperty.equals(Object)",
    "int NullSystemProperty.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NullSystemProperty(), 3);
  }

  /**
   * Test {@link NullSystemProperty#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NullSystemProperty#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NullSystemProperty.equals(Object)",
    "int NullSystemProperty.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NullSystemProperty(), null);
  }

  /**
   * Test {@link NullSystemProperty#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NullSystemProperty#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NullSystemProperty.equals(Object)",
    "int NullSystemProperty.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NullSystemProperty(), "Different type to NullSystemProperty");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NullSystemProperty}
   *   <li>{@link NullSystemProperty#setFriendlyGroup(String)}
   *   <li>{@link NullSystemProperty#setFriendlyName(String)}
   *   <li>{@link NullSystemProperty#setFriendlyTab(String)}
   *   <li>{@link NullSystemProperty#setId(Long)}
   *   <li>{@link NullSystemProperty#setName(String)}
   *   <li>{@link NullSystemProperty#setOverrideGeneratedPropertyName(Boolean)}
   *   <li>{@link NullSystemProperty#setPropertyType(SystemPropertyFieldType)}
   *   <li>{@link NullSystemProperty#setValue(String)}
   *   <li>{@link NullSystemProperty#getFriendlyGroup()}
   *   <li>{@link NullSystemProperty#getFriendlyName()}
   *   <li>{@link NullSystemProperty#getFriendlyTab()}
   *   <li>{@link NullSystemProperty#getId()}
   *   <li>{@link NullSystemProperty#getName()}
   *   <li>{@link NullSystemProperty#getOverrideGeneratedPropertyName()}
   *   <li>{@link NullSystemProperty#getPropertyType()}
   *   <li>{@link NullSystemProperty#getValue()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NullSystemProperty.<init>()",
    "String NullSystemProperty.getFriendlyGroup()",
    "String NullSystemProperty.getFriendlyName()",
    "String NullSystemProperty.getFriendlyTab()",
    "Long NullSystemProperty.getId()",
    "String NullSystemProperty.getName()",
    "Boolean NullSystemProperty.getOverrideGeneratedPropertyName()",
    "SystemPropertyFieldType NullSystemProperty.getPropertyType()",
    "String NullSystemProperty.getValue()",
    "void NullSystemProperty.setFriendlyGroup(String)",
    "void NullSystemProperty.setFriendlyName(String)",
    "void NullSystemProperty.setFriendlyTab(String)",
    "void NullSystemProperty.setId(Long)",
    "void NullSystemProperty.setName(String)",
    "void NullSystemProperty.setOverrideGeneratedPropertyName(Boolean)",
    "void NullSystemProperty.setPropertyType(SystemPropertyFieldType)",
    "void NullSystemProperty.setValue(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    NullSystemProperty actualNullSystemProperty = new NullSystemProperty();
    actualNullSystemProperty.setFriendlyGroup("Friendly Group");
    actualNullSystemProperty.setFriendlyName("Friendly Name");
    actualNullSystemProperty.setFriendlyTab("Friendly Tab");
    actualNullSystemProperty.setId(1L);
    actualNullSystemProperty.setName("Name");
    actualNullSystemProperty.setOverrideGeneratedPropertyName(true);
    actualNullSystemProperty.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    actualNullSystemProperty.setValue("42");
    String actualFriendlyGroup = actualNullSystemProperty.getFriendlyGroup();
    String actualFriendlyName = actualNullSystemProperty.getFriendlyName();
    String actualFriendlyTab = actualNullSystemProperty.getFriendlyTab();
    Long actualId = actualNullSystemProperty.getId();
    String actualName = actualNullSystemProperty.getName();
    Boolean actualOverrideGeneratedPropertyName =
        actualNullSystemProperty.getOverrideGeneratedPropertyName();
    SystemPropertyFieldType actualPropertyType = actualNullSystemProperty.getPropertyType();

    // Assert
    assertNull(actualOverrideGeneratedPropertyName);
    assertNull(actualId);
    assertNull(actualFriendlyGroup);
    assertNull(actualFriendlyName);
    assertNull(actualFriendlyTab);
    assertNull(actualName);
    assertNull(actualNullSystemProperty.getValue());
    assertNull(actualPropertyType);
  }
}
