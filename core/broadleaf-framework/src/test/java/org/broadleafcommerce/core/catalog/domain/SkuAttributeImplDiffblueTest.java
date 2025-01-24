package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityService;
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
public class SkuAttributeImplDiffblueTest {
  @Autowired
  private SkuAttributeImpl skuAttributeImpl;

  /**
   * Test {@link SkuAttributeImpl#getValue()}.
   * <p>
   * Method under test: {@link SkuAttributeImpl#getValue()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass404 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.SkuAttributeImpl skuAttributeImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SkuAttributeImpl()).getValue();
  }

  /**
   * Test {@link SkuAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link SkuAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenSkuAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuAttributeImpl()).getValue());
  }

  /**
   * Test {@link SkuAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link SkuAttributeImpl} (default constructor) Sku is
   * {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenSkuAttributeImplSkuIsSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setSku(mock(SkuImpl.class));

    // Act and Assert
    assertNull(skuAttributeImpl.getValue());
  }

  /**
   * Test {@link SkuAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenSkuImplSalePriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setSalePrice(new Money());

    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setSku(sku);

    // Act and Assert
    assertNull(skuAttributeImpl.getValue());
  }

  /**
   * Test {@link SkuAttributeImpl#getName()}.
   * <p>
   * Method under test: {@link SkuAttributeImpl#getName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass398 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.SkuAttributeImpl skuAttributeImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SkuAttributeImpl()).getName();
  }

  /**
   * Test {@link SkuAttributeImpl#getName()}.
   * <ul>
   *   <li>Given {@link SkuAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#getName()}
   */
  @Test
  public void testGetName_givenSkuAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuAttributeImpl()).getName());
  }

  /**
   * Test {@link SkuAttributeImpl#getName()}.
   * <ul>
   *   <li>Given {@link SkuAttributeImpl} (default constructor) Sku is
   * {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#getName()}
   */
  @Test
  public void testGetName_givenSkuAttributeImplSkuIsSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setSku(mock(SkuImpl.class));

    // Act and Assert
    assertNull(skuAttributeImpl.getName());
  }

  /**
   * Test {@link SkuAttributeImpl#getName()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#getName()}
   */
  @Test
  public void testGetName_givenSkuImplSalePriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setSalePrice(new Money());

    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setSku(sku);

    // Act and Assert
    assertNull(skuAttributeImpl.getName());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and
   * {@link SkuAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    int expectedHashCodeResult = skuAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and
   * {@link SkuAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    int expectedHashCodeResult = skuAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and
   * {@link SkuAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(mock(Sku.class));
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    int notExpectedHashCodeResult = skuAttributeImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and
   * {@link SkuAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(null);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    int expectedHashCodeResult = skuAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and
   * {@link SkuAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl);
    int expectedHashCodeResult = skuAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuAttributeImpl.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(2L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName(null);
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(null);
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(mock(SkuImpl.class));
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("Name");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue(null);

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, null);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, "Different type to SkuAttributeImpl");
  }

  /**
   * Test
   * {@link SkuAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link SkuAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuAttribute> actualCreateOrRetrieveCopyInstanceResult = skuAttributeImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link SkuAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link SkuAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.catalog.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass368 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.catalog.domain.SkuAttributeImpl skuAttributeImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    skuAttributeImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test
   * {@link SkuAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link SkuAttributeImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnSkuAttributeImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<SkuAttribute> actualCreateOrRetrieveCopyInstanceResult = skuAttributeImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.catalog.domain.SkuAttributeImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    SkuAttribute clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof SkuAttributeImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(skuAttributeImpl, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SkuAttributeImpl}
   *   <li>{@link SkuAttributeImpl#setId(Long)}
   *   <li>{@link SkuAttributeImpl#setName(String)}
   *   <li>{@link SkuAttributeImpl#setSku(Sku)}
   *   <li>{@link SkuAttributeImpl#setValue(String)}
   *   <li>{@link SkuAttributeImpl#getId()}
   *   <li>{@link SkuAttributeImpl#getSku()}
   *   <li>{@link SkuAttributeImpl#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuAttributeImpl actualSkuAttributeImpl = new SkuAttributeImpl();
    actualSkuAttributeImpl.setId(1L);
    actualSkuAttributeImpl.setName("Name");
    SkuImpl sku = new SkuImpl();
    actualSkuAttributeImpl.setSku(sku);
    actualSkuAttributeImpl.setValue("42");
    Long actualId = actualSkuAttributeImpl.getId();
    Sku actualSku = actualSkuAttributeImpl.getSku();

    // Assert that nothing has changed
    assertEquals("42", actualSkuAttributeImpl.toString());
    assertEquals(1L, actualId.longValue());
    assertSame(sku, actualSku);
  }
}
