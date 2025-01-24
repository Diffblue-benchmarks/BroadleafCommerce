package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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
public class PersonalMessageImplDiffblueTest {
  @Autowired
  private PersonalMessageImpl personalMessageImpl;

  /**
   * Test
   * {@link PersonalMessageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link PersonalMessageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PersonalMessage> actualCreateOrRetrieveCopyInstanceResult = personalMessageImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link PersonalMessageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link PersonalMessageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass284 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.PersonalMessageImpl personalMessageImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PersonalMessageImpl personalMessageImpl2 = new PersonalMessageImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    personalMessageImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test
   * {@link PersonalMessageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link PersonalMessageImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersonalMessageImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnPersonalMessageImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<PersonalMessage> actualCreateOrRetrieveCopyInstanceResult = personalMessageImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.order.domain.PersonalMessageImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    PersonalMessage clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof PersonalMessageImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(personalMessageImpl, clone);
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}, and
   * {@link PersonalMessageImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersonalMessageImpl#equals(Object)}
   *   <li>{@link PersonalMessageImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl.setMessage("Not all who wander are lost");
    personalMessageImpl.setMessageFrom("jane.doe@example.org");
    personalMessageImpl.setMessageTo("alice.liddell@example.org");
    personalMessageImpl.setOccasion("Occasion");

    PersonalMessageImpl personalMessageImpl2 = new PersonalMessageImpl();
    personalMessageImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl2.setMessage("Not all who wander are lost");
    personalMessageImpl2.setMessageFrom("jane.doe@example.org");
    personalMessageImpl2.setMessageTo("alice.liddell@example.org");
    personalMessageImpl2.setOccasion("Occasion");

    // Act and Assert
    assertEquals(personalMessageImpl, personalMessageImpl2);
    int expectedHashCodeResult = personalMessageImpl.hashCode();
    assertEquals(expectedHashCodeResult, personalMessageImpl2.hashCode());
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}, and
   * {@link PersonalMessageImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersonalMessageImpl#equals(Object)}
   *   <li>{@link PersonalMessageImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(null);
    personalMessageImpl.setMessage("Not all who wander are lost");
    personalMessageImpl.setMessageFrom("jane.doe@example.org");
    personalMessageImpl.setMessageTo("alice.liddell@example.org");
    personalMessageImpl.setOccasion("Occasion");

    PersonalMessageImpl personalMessageImpl2 = new PersonalMessageImpl();
    personalMessageImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl2.setMessage("Not all who wander are lost");
    personalMessageImpl2.setMessageFrom("jane.doe@example.org");
    personalMessageImpl2.setMessageTo("alice.liddell@example.org");
    personalMessageImpl2.setOccasion("Occasion");

    // Act and Assert
    assertEquals(personalMessageImpl, personalMessageImpl2);
    int expectedHashCodeResult = personalMessageImpl.hashCode();
    assertEquals(expectedHashCodeResult, personalMessageImpl2.hashCode());
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}, and
   * {@link PersonalMessageImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersonalMessageImpl#equals(Object)}
   *   <li>{@link PersonalMessageImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl.setMessage("Not all who wander are lost");
    personalMessageImpl.setMessageFrom("jane.doe@example.org");
    personalMessageImpl.setMessageTo("alice.liddell@example.org");
    personalMessageImpl.setOccasion("Occasion");

    PersonalMessageImpl personalMessageImpl2 = new PersonalMessageImpl();
    personalMessageImpl2.setId(null);
    personalMessageImpl2.setMessage("Not all who wander are lost");
    personalMessageImpl2.setMessageFrom("jane.doe@example.org");
    personalMessageImpl2.setMessageTo("alice.liddell@example.org");
    personalMessageImpl2.setOccasion("Occasion");

    // Act and Assert
    assertEquals(personalMessageImpl, personalMessageImpl2);
    int expectedHashCodeResult = personalMessageImpl.hashCode();
    assertEquals(expectedHashCodeResult, personalMessageImpl2.hashCode());
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}, and
   * {@link PersonalMessageImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersonalMessageImpl#equals(Object)}
   *   <li>{@link PersonalMessageImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(null);
    personalMessageImpl.setMessage(null);
    personalMessageImpl.setMessageFrom("jane.doe@example.org");
    personalMessageImpl.setMessageTo("alice.liddell@example.org");
    personalMessageImpl.setOccasion("Occasion");

    PersonalMessageImpl personalMessageImpl2 = new PersonalMessageImpl();
    personalMessageImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl2.setMessage(null);
    personalMessageImpl2.setMessageFrom("jane.doe@example.org");
    personalMessageImpl2.setMessageTo("alice.liddell@example.org");
    personalMessageImpl2.setOccasion("Occasion");

    // Act and Assert
    assertEquals(personalMessageImpl, personalMessageImpl2);
    int expectedHashCodeResult = personalMessageImpl.hashCode();
    assertEquals(expectedHashCodeResult, personalMessageImpl2.hashCode());
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}, and
   * {@link PersonalMessageImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersonalMessageImpl#equals(Object)}
   *   <li>{@link PersonalMessageImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(null);
    personalMessageImpl.setMessage("Not all who wander are lost");
    personalMessageImpl.setMessageFrom(null);
    personalMessageImpl.setMessageTo("alice.liddell@example.org");
    personalMessageImpl.setOccasion("Occasion");

    PersonalMessageImpl personalMessageImpl2 = new PersonalMessageImpl();
    personalMessageImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl2.setMessage("Not all who wander are lost");
    personalMessageImpl2.setMessageFrom(null);
    personalMessageImpl2.setMessageTo("alice.liddell@example.org");
    personalMessageImpl2.setOccasion("Occasion");

    // Act and Assert
    assertEquals(personalMessageImpl, personalMessageImpl2);
    int expectedHashCodeResult = personalMessageImpl.hashCode();
    assertEquals(expectedHashCodeResult, personalMessageImpl2.hashCode());
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}, and
   * {@link PersonalMessageImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersonalMessageImpl#equals(Object)}
   *   <li>{@link PersonalMessageImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl.setMessage("Not all who wander are lost");
    personalMessageImpl.setMessageFrom("jane.doe@example.org");
    personalMessageImpl.setMessageTo("alice.liddell@example.org");
    personalMessageImpl.setOccasion("Occasion");

    // Act and Assert
    assertEquals(personalMessageImpl, personalMessageImpl);
    int expectedHashCodeResult = personalMessageImpl.hashCode();
    assertEquals(expectedHashCodeResult, personalMessageImpl.hashCode());
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonalMessageImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(2L);
    personalMessageImpl.setMessage("Not all who wander are lost");
    personalMessageImpl.setMessageFrom("jane.doe@example.org");
    personalMessageImpl.setMessageTo("alice.liddell@example.org");
    personalMessageImpl.setOccasion("Occasion");

    PersonalMessageImpl personalMessageImpl2 = new PersonalMessageImpl();
    personalMessageImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl2.setMessage("Not all who wander are lost");
    personalMessageImpl2.setMessageFrom("jane.doe@example.org");
    personalMessageImpl2.setMessageTo("alice.liddell@example.org");
    personalMessageImpl2.setOccasion("Occasion");

    // Act and Assert
    assertNotEquals(personalMessageImpl, personalMessageImpl2);
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonalMessageImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(null);
    personalMessageImpl.setMessage("jane.doe@example.org");
    personalMessageImpl.setMessageFrom("jane.doe@example.org");
    personalMessageImpl.setMessageTo("alice.liddell@example.org");
    personalMessageImpl.setOccasion("Occasion");

    PersonalMessageImpl personalMessageImpl2 = new PersonalMessageImpl();
    personalMessageImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl2.setMessage("Not all who wander are lost");
    personalMessageImpl2.setMessageFrom("jane.doe@example.org");
    personalMessageImpl2.setMessageTo("alice.liddell@example.org");
    personalMessageImpl2.setOccasion("Occasion");

    // Act and Assert
    assertNotEquals(personalMessageImpl, personalMessageImpl2);
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonalMessageImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(null);
    personalMessageImpl.setMessage(null);
    personalMessageImpl.setMessageFrom("jane.doe@example.org");
    personalMessageImpl.setMessageTo("alice.liddell@example.org");
    personalMessageImpl.setOccasion("Occasion");

    PersonalMessageImpl personalMessageImpl2 = new PersonalMessageImpl();
    personalMessageImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl2.setMessage("Not all who wander are lost");
    personalMessageImpl2.setMessageFrom("jane.doe@example.org");
    personalMessageImpl2.setMessageTo("alice.liddell@example.org");
    personalMessageImpl2.setOccasion("Occasion");

    // Act and Assert
    assertNotEquals(personalMessageImpl, personalMessageImpl2);
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonalMessageImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(null);
    personalMessageImpl.setMessage("Not all who wander are lost");
    personalMessageImpl.setMessageFrom("Not all who wander are lost");
    personalMessageImpl.setMessageTo("alice.liddell@example.org");
    personalMessageImpl.setOccasion("Occasion");

    PersonalMessageImpl personalMessageImpl2 = new PersonalMessageImpl();
    personalMessageImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl2.setMessage("Not all who wander are lost");
    personalMessageImpl2.setMessageFrom("jane.doe@example.org");
    personalMessageImpl2.setMessageTo("alice.liddell@example.org");
    personalMessageImpl2.setOccasion("Occasion");

    // Act and Assert
    assertNotEquals(personalMessageImpl, personalMessageImpl2);
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonalMessageImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(null);
    personalMessageImpl.setMessage("Not all who wander are lost");
    personalMessageImpl.setMessageFrom(null);
    personalMessageImpl.setMessageTo("alice.liddell@example.org");
    personalMessageImpl.setOccasion("Occasion");

    PersonalMessageImpl personalMessageImpl2 = new PersonalMessageImpl();
    personalMessageImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl2.setMessage("Not all who wander are lost");
    personalMessageImpl2.setMessageFrom("jane.doe@example.org");
    personalMessageImpl2.setMessageTo("alice.liddell@example.org");
    personalMessageImpl2.setOccasion("Occasion");

    // Act and Assert
    assertNotEquals(personalMessageImpl, personalMessageImpl2);
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonalMessageImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(null);
    personalMessageImpl.setMessage("Not all who wander are lost");
    personalMessageImpl.setMessageFrom("jane.doe@example.org");
    personalMessageImpl.setMessageTo("Not all who wander are lost");
    personalMessageImpl.setOccasion("Occasion");

    PersonalMessageImpl personalMessageImpl2 = new PersonalMessageImpl();
    personalMessageImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl2.setMessage("Not all who wander are lost");
    personalMessageImpl2.setMessageFrom("jane.doe@example.org");
    personalMessageImpl2.setMessageTo("alice.liddell@example.org");
    personalMessageImpl2.setOccasion("Occasion");

    // Act and Assert
    assertNotEquals(personalMessageImpl, personalMessageImpl2);
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonalMessageImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(null);
    personalMessageImpl.setMessage("Not all who wander are lost");
    personalMessageImpl.setMessageFrom("jane.doe@example.org");
    personalMessageImpl.setMessageTo(null);
    personalMessageImpl.setOccasion("Occasion");

    PersonalMessageImpl personalMessageImpl2 = new PersonalMessageImpl();
    personalMessageImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl2.setMessage("Not all who wander are lost");
    personalMessageImpl2.setMessageFrom("jane.doe@example.org");
    personalMessageImpl2.setMessageTo("alice.liddell@example.org");
    personalMessageImpl2.setOccasion("Occasion");

    // Act and Assert
    assertNotEquals(personalMessageImpl, personalMessageImpl2);
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonalMessageImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl.setMessage("Not all who wander are lost");
    personalMessageImpl.setMessageFrom("jane.doe@example.org");
    personalMessageImpl.setMessageTo("alice.liddell@example.org");
    personalMessageImpl.setOccasion("Occasion");

    // Act and Assert
    assertNotEquals(personalMessageImpl, null);
  }

  /**
   * Test {@link PersonalMessageImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonalMessageImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PersonalMessageImpl personalMessageImpl = new PersonalMessageImpl();
    personalMessageImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    personalMessageImpl.setMessage("Not all who wander are lost");
    personalMessageImpl.setMessageFrom("jane.doe@example.org");
    personalMessageImpl.setMessageTo("alice.liddell@example.org");
    personalMessageImpl.setOccasion("Occasion");

    // Act and Assert
    assertNotEquals(personalMessageImpl, "Different type to PersonalMessageImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PersonalMessageImpl}
   *   <li>{@link PersonalMessageImpl#setId(Long)}
   *   <li>{@link PersonalMessageImpl#setMessage(String)}
   *   <li>{@link PersonalMessageImpl#setMessageFrom(String)}
   *   <li>{@link PersonalMessageImpl#setMessageTo(String)}
   *   <li>{@link PersonalMessageImpl#setOccasion(String)}
   *   <li>{@link PersonalMessageImpl#getId()}
   *   <li>{@link PersonalMessageImpl#getMessage()}
   *   <li>{@link PersonalMessageImpl#getMessageFrom()}
   *   <li>{@link PersonalMessageImpl#getMessageTo()}
   *   <li>{@link PersonalMessageImpl#getOccasion()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PersonalMessageImpl actualPersonalMessageImpl = new PersonalMessageImpl();
    actualPersonalMessageImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    actualPersonalMessageImpl.setMessage("Not all who wander are lost");
    actualPersonalMessageImpl.setMessageFrom("jane.doe@example.org");
    actualPersonalMessageImpl.setMessageTo("alice.liddell@example.org");
    actualPersonalMessageImpl.setOccasion("Occasion");
    Long actualId = actualPersonalMessageImpl.getId();
    String actualMessage = actualPersonalMessageImpl.getMessage();
    String actualMessageFrom = actualPersonalMessageImpl.getMessageFrom();
    String actualMessageTo = actualPersonalMessageImpl.getMessageTo();

    // Assert that nothing has changed
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("Occasion", actualPersonalMessageImpl.getOccasion());
    assertEquals("alice.liddell@example.org", actualMessageTo);
    assertEquals("jane.doe@example.org", actualMessageFrom);
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
  }
}
