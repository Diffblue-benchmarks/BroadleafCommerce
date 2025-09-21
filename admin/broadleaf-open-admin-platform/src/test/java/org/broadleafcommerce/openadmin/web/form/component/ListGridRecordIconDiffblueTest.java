/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.form.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ListGridRecordIcon.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class ListGridRecordIconDiffblueTest {
  @Autowired private ListGridRecordIcon listGridRecordIcon;

  /**
   * Test {@link ListGridRecordIcon#withCssClass(String)}.
   *
   * <p>Method under test: {@link ListGridRecordIcon#withCssClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridRecordIcon ListGridRecordIcon.withCssClass(String)"})
  public void testWithCssClass() {
    // Arrange and Act
    ListGridRecordIcon actualWithCssClassResult = listGridRecordIcon.withCssClass("Css Class");

    // Assert
    assertEquals("Css Class", listGridRecordIcon.getCssClass());
    assertSame(listGridRecordIcon, actualWithCssClassResult);
  }

  /**
   * Test {@link ListGridRecordIcon#withMessage(String)}.
   *
   * <p>Method under test: {@link ListGridRecordIcon#withMessage(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridRecordIcon ListGridRecordIcon.withMessage(String)"})
  public void testWithMessage() {
    // Arrange and Act
    ListGridRecordIcon actualWithMessageResult =
        listGridRecordIcon.withMessage("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", listGridRecordIcon.getMessage());
    assertSame(listGridRecordIcon, actualWithMessageResult);
  }

  /**
   * Test {@link ListGridRecordIcon#withHasDetails(Boolean)}.
   *
   * <p>Method under test: {@link ListGridRecordIcon#withHasDetails(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridRecordIcon ListGridRecordIcon.withHasDetails(Boolean)"})
  public void testWithHasDetails() {
    // Arrange
    ListGridRecordIcon listGridRecordIcon = new ListGridRecordIcon();

    // Act
    ListGridRecordIcon actualWithHasDetailsResult = listGridRecordIcon.withHasDetails(true);

    // Assert
    assertTrue(listGridRecordIcon.getHasDetails());
    assertSame(listGridRecordIcon, actualWithHasDetailsResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ListGridRecordIcon}
   *   <li>{@link ListGridRecordIcon#setCssClass(String)}
   *   <li>{@link ListGridRecordIcon#setHasDetails(Boolean)}
   *   <li>{@link ListGridRecordIcon#setMessage(String)}
   *   <li>{@link ListGridRecordIcon#getCssClass()}
   *   <li>{@link ListGridRecordIcon#getHasDetails()}
   *   <li>{@link ListGridRecordIcon#getMessage()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ListGridRecordIcon.<init>()",
    "String ListGridRecordIcon.getCssClass()",
    "Boolean ListGridRecordIcon.getHasDetails()",
    "String ListGridRecordIcon.getMessage()",
    "void ListGridRecordIcon.setCssClass(String)",
    "void ListGridRecordIcon.setHasDetails(Boolean)",
    "void ListGridRecordIcon.setMessage(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ListGridRecordIcon actualListGridRecordIcon = new ListGridRecordIcon();
    actualListGridRecordIcon.setCssClass("Css Class");
    actualListGridRecordIcon.setHasDetails(true);
    actualListGridRecordIcon.setMessage("Not all who wander are lost");
    String actualCssClass = actualListGridRecordIcon.getCssClass();
    Boolean actualHasDetails = actualListGridRecordIcon.getHasDetails();

    // Assert
    assertEquals("Css Class", actualCssClass);
    assertEquals("Not all who wander are lost", actualListGridRecordIcon.getMessage());
    assertTrue(actualHasDetails);
  }
}
