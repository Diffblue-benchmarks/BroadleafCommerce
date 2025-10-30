/*-
 * #%L
 * BroadleafCommerce CMS Module
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.cms.page.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PageAttributeImplDiffblueTest {
  @Autowired
  private PageAttributeImpl pageAttributeImpl;

  /**
   * Test {@link PageAttributeImpl#getValue()}.
   * <p>
   * Method under test: {@link PageAttributeImpl#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PageAttributeImpl.getValue()"})
  public void testGetValue() {
    // Arrange, Act and Assert
    assertNull((new PageAttributeImpl()).getValue());
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}, and {@link PageAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageAttributeImpl#equals(Object)}
   *   <li>{@link PageAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageAttributeImpl.equals(Object)", "int PageAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(pageAttributeImpl, pageAttributeImpl2);
    int notExpectedHashCodeResult = pageAttributeImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, pageAttributeImpl2.hashCode());
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}, and {@link PageAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageAttributeImpl#equals(Object)}
   *   <li>{@link PageAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageAttributeImpl.equals(Object)", "int PageAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(null);
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(null);
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(pageAttributeImpl, pageAttributeImpl2);
    int expectedHashCodeResult = pageAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, pageAttributeImpl2.hashCode());
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}, and {@link PageAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageAttributeImpl#equals(Object)}
   *   <li>{@link PageAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageAttributeImpl.equals(Object)", "int PageAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(pageAttributeImpl, pageAttributeImpl);
    int expectedHashCodeResult = pageAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, pageAttributeImpl.hashCode());
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageAttributeImpl.equals(Object)", "int PageAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(2L);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageAttributeImpl.equals(Object)", "int PageAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageAttributeImpl.equals(Object)", "int PageAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(null);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageAttributeImpl.equals(Object)", "int PageAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName(null);
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageAttributeImpl.equals(Object)", "int PageAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("java.lang.String");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageAttributeImpl.equals(Object)", "int PageAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(null);
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageAttributeImpl.equals(Object)", "int PageAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName(null);
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName(null);
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageAttributeImpl.equals(Object)", "int PageAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(null);
    pageAttributeImpl.setValue("Name");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(null);
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageAttributeImpl.equals(Object)", "int PageAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(null);
    pageAttributeImpl.setValue(null);

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(null);
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageAttributeImpl.equals(Object)", "int PageAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, null);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PageAttributeImpl.equals(Object)", "int PageAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, "Different type to PageAttributeImpl");
  }

  /**
   * Test {@link PageAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link PageAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse PageAttributeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PageAttribute> actualCreateOrRetrieveCopyInstanceResult = pageAttributeImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PageAttributeImpl}
   *   <li>{@link PageAttributeImpl#setId(Long)}
   *   <li>{@link PageAttributeImpl#setName(String)}
   *   <li>{@link PageAttributeImpl#setPage(Page)}
   *   <li>{@link PageAttributeImpl#setValue(String)}
   *   <li>{@link PageAttributeImpl#getId()}
   *   <li>{@link PageAttributeImpl#getName()}
   *   <li>{@link PageAttributeImpl#getPage()}
   *   <li>{@link PageAttributeImpl#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PageAttributeImpl.<init>()", "Long PageAttributeImpl.getId()",
      "String PageAttributeImpl.getName()", "Page PageAttributeImpl.getPage()", "void PageAttributeImpl.setId(Long)",
      "void PageAttributeImpl.setName(String)", "void PageAttributeImpl.setPage(Page)",
      "void PageAttributeImpl.setValue(String)", "String PageAttributeImpl.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    PageAttributeImpl actualPageAttributeImpl = new PageAttributeImpl();
    actualPageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    actualPageAttributeImpl.setName("Name");
    PageImpl page = new PageImpl();
    actualPageAttributeImpl.setPage(page);
    actualPageAttributeImpl.setValue("42");
    Long actualId = actualPageAttributeImpl.getId();
    String actualName = actualPageAttributeImpl.getName();
    Page actualPage = actualPageAttributeImpl.getPage();
    String actualToStringResult = actualPageAttributeImpl.toString();

    // Assert
    assertEquals("42", actualPageAttributeImpl.getValue());
    assertEquals("42", actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(page, actualPage);
  }
}
