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
package org.broadleafcommerce.openadmin.server.service.artifact;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.service.artifact.image.Operation;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.UnmarshalledParameter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-open-admin-contentClient-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ArtifactServiceImplDiffblueTest {
  @Autowired
  private ArtifactServiceImpl artifactServiceImpl;

  /**
   * Test {@link ArtifactServiceImpl#convert(InputStream, Operation[], String)}.
   * <p>
   * Method under test: {@link ArtifactServiceImpl#convert(InputStream, Operation[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InputStream ArtifactServiceImpl.convert(InputStream, Operation[], String)"})
  public void testConvert() throws Exception {
    // Arrange
    ByteArrayInputStream artifactStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    Operation operation = new Operation();
    operation.setFactor(10.0d);
    operation.setName("Name");

    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");
    operation.setParameters(new UnmarshalledParameter[]{unmarshalledParameter});

    // Act and Assert
    byte[] byteArray = new byte[8];
    int actualReadResult = artifactServiceImpl.convert(artifactStream, new Operation[]{operation}, "Mime Type")
        .read(byteArray);
    assertEquals(-1, artifactStream.read(new byte[]{}));
    assertEquals(8, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ArtifactServiceImpl#buildOperations(Map, InputStream, String)}.
   * <p>
   * Method under test: {@link ArtifactServiceImpl#buildOperations(Map, InputStream, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Operation[] ArtifactServiceImpl.buildOperations(Map, InputStream, String)"})
  public void testBuildOperations() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(artifactServiceImpl.buildOperations(parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")),
        "Mime Type"));
  }
}
