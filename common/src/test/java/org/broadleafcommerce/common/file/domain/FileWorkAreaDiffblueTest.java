/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.file.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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

@ContextConfiguration(classes = {FileWorkArea.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class FileWorkAreaDiffblueTest {
  @Autowired private FileWorkArea fileWorkArea;

  /**
   * Test {@link FileWorkArea#getFilePathLocation()}.
   *
   * <ul>
   *   <li>Given {@link FileWorkArea} (default constructor) FilePathLocation is {@code foo}.
   *   <li>Then return {@code foo/}.
   * </ul>
   *
   * <p>Method under test: {@link FileWorkArea#getFilePathLocation()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileWorkArea.getFilePathLocation()"})
  public void testGetFilePathLocation_givenFileWorkAreaFilePathLocationIsFoo_thenReturnFoo() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("foo");

    // Act and Assert
    assertEquals("foo/", fileWorkArea.getFilePathLocation());
  }

  /**
   * Test {@link FileWorkArea#setFilePathLocation(String)}.
   *
   * <ul>
   *   <li>Then {@link FileWorkArea} FilePathLocation is {@code /directory/foo.txt/}.
   * </ul>
   *
   * <p>Method under test: {@link FileWorkArea#setFilePathLocation(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileWorkArea.setFilePathLocation(String)"})
  public void testSetFilePathLocation_thenFileWorkAreaFilePathLocationIsDirectoryFooTxt() {
    // Arrange and Act
    fileWorkArea.setFilePathLocation("/directory/foo.txt");

    // Assert
    assertEquals("/directory/foo.txt/", fileWorkArea.getFilePathLocation());
    assertEquals("/directory/foo.txt/", fileWorkArea.filePathLocation);
  }

  /**
   * Test new {@link FileWorkArea} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FileWorkArea}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileWorkArea.<init>()"})
  public void testNewFileWorkArea() {
    // Arrange, Act and Assert
    assertNull(new FileWorkArea().filePathLocation);
  }
}
