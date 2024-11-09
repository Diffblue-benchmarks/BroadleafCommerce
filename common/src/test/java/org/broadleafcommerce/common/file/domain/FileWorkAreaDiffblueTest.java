/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FileWorkArea.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class FileWorkAreaDiffblueTest {
  @Autowired
  private FileWorkArea fileWorkArea;

  /**
   * Test {@link FileWorkArea#getFilePathLocation()}.
   * <ul>
   *   <li>Given {@link FileWorkArea} (default constructor) FilePathLocation is
   * {@code foo}.</li>
   *   <li>Then return {@code foo/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileWorkArea#getFilePathLocation()}
   */
  @Test
  public void testGetFilePathLocation_givenFileWorkAreaFilePathLocationIsFoo_thenReturnFoo() {
    // Arrange
    FileWorkArea fileWorkArea = new FileWorkArea();
    fileWorkArea.setFilePathLocation("foo");

    // Act and Assert
    assertEquals("foo/", fileWorkArea.getFilePathLocation());
  }

  /**
   * Test {@link FileWorkArea#setFilePathLocation(String)}.
   * <p>
   * Method under test: {@link FileWorkArea#setFilePathLocation(String)}
   */
  @Test
  public void testSetFilePathLocation() {
    // Arrange
    FileWorkArea fileWorkArea2 = new FileWorkArea();

    // Act
    fileWorkArea2.setFilePathLocation("/directory/foo.txt");

    // Assert
    assertEquals("/directory/foo.txt/", fileWorkArea2.getFilePathLocation());
    assertEquals("/directory/foo.txt/", fileWorkArea2.filePathLocation);
  }

  /**
   * Test new {@link FileWorkArea} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FileWorkArea}
   */
  @Test
  public void testNewFileWorkArea() {
    // Arrange, Act and Assert
    assertNull((new FileWorkArea()).filePathLocation);
  }
}
