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
package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PaymentGatewayTamperProofSealServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentGatewayTamperProofSealServiceImplDiffblueTest {
  @Autowired
  private PaymentGatewayTamperProofSealServiceImpl paymentGatewayTamperProofSealServiceImpl;

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code 1FG2gnnvrVQ5SpyDxaD3_gTv-us}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturn1FG2gnnvrVQ5SpyDxaD3GTvUs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("1FG2gnnvrVQ5SpyDxaD3_gTv-us", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code 7f0cgKmhwUd_tPNoRpfDt_3XL2o}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturn7f0cgKmhwUdTPNoRpfDt3XL2o()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("7f0cgKmhwUd_tPNoRpfDt_3XL2o", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code Af-VMmIUYJ8hSeTiz8sZxnFAu-0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturnAfVMmIUYJ8hSeTiz8sZxnFAu0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("Af-VMmIUYJ8hSeTiz8sZxnFAu-0", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code CbSCTyjPn5vF0OgyXrRXj5B3VKM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturnCbSCTyjPn5vF0OgyXrRXj5B3VKM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("CbSCTyjPn5vF0OgyXrRXj5B3VKM", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code E8uB0wx9qTV5boBcN00CH66s_cw}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturnE8uB0wx9qTV5boBcN00CH66sCw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("E8uB0wx9qTV5boBcN00CH66s_cw", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code h9iN8mYez-IDmhMPRI0W60ofKt8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturnH9iN8mYezIDmhMPRI0W60ofKt8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("h9iN8mYez-IDmhMPRI0W60ofKt8", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturnHaTqhQ4C8ZHUrFsNEZnmPH6Q()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code hyr6f0l6i3shGZ-tBIVtsmlGPGk}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturnHyr6f0l6i3shGZTBIVtsmlGPGk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("hyr6f0l6i3shGZ-tBIVtsmlGPGk", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code m3GIMULiACYDokdOqmpnmlLGDTs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturnM3GIMULiACYDokdOqmpnmlLGDTs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("m3GIMULiACYDokdOqmpnmlLGDTs", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code pPHhTOX7bpS3zBzZgPHIGFinME8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturnPPHhTOX7bpS3zBzZgPHIGFinME8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("pPHhTOX7bpS3zBzZgPHIGFinME8", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code pvbmP5Y3jlUvZ8yjaAbNYKkz9us}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturnPvbmP5Y3jlUvZ8yjaAbNYKkz9us()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("pvbmP5Y3jlUvZ8yjaAbNYKkz9us", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code q6pjVjanGrLn0-FHk2SWXBSi5aE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturnQ6pjVjanGrLn0FHk2SWXBSi5aE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("q6pjVjanGrLn0-FHk2SWXBSi5aE", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturnSNqsTSzcdqtIvTFHUEVghnf0xHY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("sNqsTSzcdqtIvTFHUEVghnf0xHY", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code vhSwWFhvNbKEmyaP_jvB97d2R38}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturnVhSwWFhvNbKEmyaPJvB97d2R38()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("vhSwWFhvNbKEmyaP_jvB97d2R38", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code Yc3IfLaBbSqp9kuxL58YZRlu0hI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturnYc3IfLaBbSqp9kuxL58YZRlu0hI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("Yc3IfLaBbSqp9kuxL58YZRlu0hI", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code ZatE8KJTwTBQ7jlSjw-ZoR7x2XI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_thenReturnZatE8KJTwTBQ7jlSjwZoR7x2XI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("ZatE8KJTwTBQ7jlSjw-ZoR7x2XI", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code JtaejkMTk2LMEqShMFY1GTRYxp0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_when42_thenReturnJtaejkMTk2LMEqShMFY1GTRYxp0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("JtaejkMTk2LMEqShMFY1GTRYxp0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code 4af_i5eWdzpsBvBoD9A_vptOhxA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCr_thenReturn4afI5eWdzpsBvBoD9AVptOhxA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("4af_i5eWdzpsBvBoD9A_vptOhxA",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code 79-icLuv45Um14pDOoK2S7kht-Y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCr_thenReturn79IcLuv45Um14pDOoK2S7khtY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("79-icLuv45Um14pDOoK2S7kht-Y",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code ETyIyJs7lK1ykyUGjuwqPhvtBAo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCr_thenReturnETyIyJs7lK1ykyUGjuwqPhvtBAo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("ETyIyJs7lK1ykyUGjuwqPhvtBAo",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\r", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code k_8FS97EthV3pxCOfGSyXd1RjZA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCr_thenReturnK8FS97EthV3pxCOfGSyXd1RjZA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("k_8FS97EthV3pxCOfGSyXd1RjZA",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code nRuc5Dw1SGLVEldnmtqPKIjA_yg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCr_thenReturnNRuc5Dw1SGLVEldnmtqPKIjAYg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("nRuc5Dw1SGLVEldnmtqPKIjA_yg",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCr_thenReturnOQbDLn8zttlxvxVF7DhTFV1jdY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("oQbDLn8zttlxvxVF7DhTFV1jd-Y",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code 0xuCa4XmNlvaNCW-hGHhYtcAfII}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturn0xuCa4XmNlvaNCWHGHhYtcAfII()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("0xuCa4XmNlvaNCW-hGHhYtcAfII", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code 1amYbQZvHgCZLYtK8eg0CivLfdQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturn1amYbQZvHgCZLYtK8eg0CivLfdQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("1amYbQZvHgCZLYtK8eg0CivLfdQ",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "Customer Id", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code 1oV__tbpXGKi0rq0dDh97i_HHuQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturn1oVTbpXGKi0rq0dDh97iHHuQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("1oV__tbpXGKi0rq0dDh97i_HHuQ", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code 6cgj6FzexH5PElZa2zfOgccYZkA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturn6cgj6FzexH5PElZa2zfOgccYZkA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("6cgj6FzexH5PElZa2zfOgccYZkA",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code AK1QP7g5usw8quMcMHU7PPgXdU4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnAK1QP7g5usw8quMcMHU7PPgXdU4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("AK1QP7g5usw8quMcMHU7PPgXdU4",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "Customer Id", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code IzEdrUsmDR1OZpb7QPnursck8VM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnIzEdrUsmDR1OZpb7QPnursck8VM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("IzEdrUsmDR1OZpb7QPnursck8VM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "Customer Id", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code pi7Z6_OLowr63TFhzpEi2-vcrgk}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnPi7Z6OLowr63TFhzpEi2Vcrgk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("pi7Z6_OLowr63TFhzpEi2-vcrgk", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code QDFXJ8lrRWasejqgFqu6GaXU7XA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnQDFXJ8lrRWasejqgFqu6GaXU7XA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("QDFXJ8lrRWasejqgFqu6GaXU7XA",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code STGAgqhH7U4EU5wmR7UMKpvM8RM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnSTGAgqhH7U4EU5wmR7UMKpvM8RM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("STGAgqhH7U4EU5wmR7UMKpvM8RM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code sbU42dGCepiXJcDpu6LAYd7bZR0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnSbU42dGCepiXJcDpu6LAYd7bZR0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("sbU42dGCepiXJcDpu6LAYd7bZR0", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code t4O7JXDlKRm_Z6yxPWhnawAzS3c}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnT4O7JXDlKRmZ6yxPWhnawAzS3c()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("t4O7JXDlKRm_Z6yxPWhnawAzS3c", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code u1zevV4-jxVinvk2Vw0CX7JJE38}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnU1zevV4JxVinvk2Vw0CX7JJE38()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("u1zevV4-jxVinvk2Vw0CX7JJE38",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code u7Cn8yIBSmbfmFJ4AKuvIyTzhGk}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnU7Cn8yIBSmbfmFJ4AKuvIyTzhGk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("u7Cn8yIBSmbfmFJ4AKuvIyTzhGk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code X3hva1xmdWKX2P1I0wLj2TpczuE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnX3hva1xmdWKX2P1I0wLj2TpczuE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("X3hva1xmdWKX2P1I0wLj2TpczuE",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code zhuzagJl7J1hq_o1mUMKPDK2hkw}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnZhuzagJl7J1hqO1mUMKPDK2hkw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("zhuzagJl7J1hq_o1mUMKPDK2hkw", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code 7TfFqE43gT4uk0foYCMo9JKk4zw}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenEmptyString_thenReturn7TfFqE43gT4uk0foYCMo9JKk4zw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("7TfFqE43gT4uk0foYCMo9JKk4zw",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code 240sUHqX-D8nXPbQTqIGyJ9tanI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenEmptyString_thenReturn240sUHqXD8nXPbQTqIGyJ9tanI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("240sUHqX-D8nXPbQTqIGyJ9tanI", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code 944XXw0vCyFbIE4-QfJ3HWzXWME}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenEmptyString_thenReturn944XXw0vCyFbIE4QfJ3HWzXWME()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("944XXw0vCyFbIE4-QfJ3HWzXWME", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code eeJj8ru73d0-4iECLNthWYbBHXw}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnEeJj8ru73d04iECLNthWYbBHXw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("eeJj8ru73d0-4iECLNthWYbBHXw",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code JQjvhNx-FpTbRHJi1qBhld59Olw}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnJQjvhNxFpTbRHJi1qBhld59Olw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("JQjvhNx-FpTbRHJi1qBhld59Olw",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code kUMPgvAgA5T0Kj2bleKR-9PVbZg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnKUMPgvAgA5T0Kj2bleKR9PVbZg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("kUMPgvAgA5T0Kj2bleKR-9PVbZg",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\\r|\\n", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code MRciCXfeaElXsZa_WipdCZXl2ZI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnMRciCXfeaElXsZaWipdCZXl2ZI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("MRciCXfeaElXsZa_WipdCZXl2ZI",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "HmacSHA1", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code QALRtNESDXJ7AiDaXTaV-4WnWeo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnQALRtNESDXJ7AiDaXTaV4WnWeo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("QALRtNESDXJ7AiDaXTaV-4WnWeo",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code SNqY6ufenJLOT51LeJyKLF5XsHY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnSNqY6ufenJLOT51LeJyKLF5XsHY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("SNqY6ufenJLOT51LeJyKLF5XsHY", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code uSgW-GUHcUxlkXUs40cppvJsmw0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnUSgWGUHcUxlkXUs40cppvJsmw0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("uSgW-GUHcUxlkXUs40cppvJsmw0", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code v1L5FBjl32VmI2fHiwYaLvPwsK0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnV1L5FBjl32VmI2fHiwYaLvPwsK0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("v1L5FBjl32VmI2fHiwYaLvPwsK0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\r", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code w9zO-4-eV0Z4LTKIjubXI9zeaz0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnW9zO4EV0Z4LTKIjubXI9zeaz0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("w9zO-4-eV0Z4LTKIjubXI9zeaz0", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", ""));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code y2-djIQ8IuU9uX9_0v8gq1jJHjE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnY2DjIQ8IuU9uX90v8gq1jJHjE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("y2-djIQ8IuU9uX9_0v8gq1jJHjE",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code 6fVQO8Iz_cH_Da3lajTtaaNLiHY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturn6fVQO8IzCHDa3lajTtaaNLiHY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("6fVQO8Iz_cH_Da3lajTtaaNLiHY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code 29cZvFHL1BiopnxiDKwl-gfbgls}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturn29cZvFHL1BiopnxiDKwlGfbgls()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("29cZvFHL1BiopnxiDKwl-gfbgls",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code ADKW7x46hnNb1EHbrnw_5TnRGsk}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnADKW7x46hnNb1EHbrnw5TnRGsk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("ADKW7x46hnNb1EHbrnw_5TnRGsk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code eMdhaldlNjPK0VTwcRCCjQzJfkE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnEMdhaldlNjPK0VTwcRCCjQzJfkE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("eMdhaldlNjPK0VTwcRCCjQzJfkE",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code GbAGpzDDR4HbrQkT9Ae-l1OIUTc}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnGbAGpzDDR4HbrQkT9AeL1OIUTc()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("GbAGpzDDR4HbrQkT9Ae-l1OIUTc",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code hRz2dH3-ibGiESQ2kZHr3EC6TvI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnHRz2dH3IbGiESQ2kZHr3EC6TvI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("hRz2dH3-ibGiESQ2kZHr3EC6TvI",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnIgPuvGE50jePFMloMJXfiXBkB8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("IgPuvGE5_0jePFMloMJXfiXBkB8",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code LYVGmwZjXmI0USYv8DjWFNoFZLc}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnLYVGmwZjXmI0USYv8DjWFNoFZLc()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("LYVGmwZjXmI0USYv8DjWFNoFZLc",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code RH45VxwkybzBn5fd_zP-yn7u1Og}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnRH45VxwkybzBn5fdZPYn7u1Og()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("RH45VxwkybzBn5fd_zP-yn7u1Og",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code RiPpb2KwscLxTcKvAY239R9Dr1o}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnRiPpb2KwscLxTcKvAY239R9Dr1o()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("RiPpb2KwscLxTcKvAY239R9Dr1o",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code sM5V8ywc2a0KV8IKYIh54Xkpklk}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnSM5V8ywc2a0KV8IKYIh54Xkpklk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("sM5V8ywc2a0KV8IKYIh54Xkpklk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code t20sMpGd9nJzrEA7rULqdrpVKBc}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnT20sMpGd9nJzrEA7rULqdrpVKBc()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("t20sMpGd9nJzrEA7rULqdrpVKBc",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code vwWXvQHEVfDexI1q-190cl43Jr8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnVwWXvQHEVfDexI1q190cl43Jr8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("vwWXvQHEVfDexI1q-190cl43Jr8",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code x1n7atITF0SqSdwCRifqoNxPMew}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnX1n7atITF0SqSdwCRifqoNxPMew()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("x1n7atITF0SqSdwCRifqoNxPMew",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\r", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code xSgXnRtQjjrSTPwOWSBNcl0H4h8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnXSgXnRtQjjrSTPwOWSBNcl0H4h8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("xSgXnRtQjjrSTPwOWSBNcl0H4h8",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "HmacSHA1", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code 0cTiUxuvZqKt3MjpP-1MASO2KNY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenOrderId_thenReturn0cTiUxuvZqKt3MjpP1maso2kny()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("0cTiUxuvZqKt3MjpP-1MASO2KNY", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code 1VfOoYCXAKA2P3M-R_e4mltDZSk}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenOrderId_thenReturn1VfOoYCXAKA2P3MRE4mltDZSk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("1VfOoYCXAKA2P3M-R_e4mltDZSk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\\r|\\n", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code AX8b4TYA9MpsLrTZLxj-mKFXliQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenOrderId_thenReturnAX8b4TYA9MpsLrTZLxjMKFXliQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("AX8b4TYA9MpsLrTZLxj-mKFXliQ",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "HmacSHA1", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code CAp7B9ynYEs6skxV6Q3_FjfCxkg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenOrderId_thenReturnCAp7B9ynYEs6skxV6Q3FjfCxkg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("CAp7B9ynYEs6skxV6Q3_FjfCxkg", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code CX-3_rrPPwmmqMEr281LSo8QQGU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenOrderId_thenReturnCx3RrPPwmmqMEr281LSo8QQGU()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("CX-3_rrPPwmmqMEr281LSo8QQGU",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\r", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code CzYF3m-tO6XGaLgv59f_-gFkcX0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenOrderId_thenReturnCzYF3mTO6XGaLgv59fGFkcX0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("CzYF3m-tO6XGaLgv59f_-gFkcX0", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code EIkRJNg0TZE1TzshK9upv4BjtcY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenOrderId_thenReturnEIkRJNg0TZE1TzshK9upv4BjtcY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("EIkRJNg0TZE1TzshK9upv4BjtcY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code GAn4gYYGpYQsc88VJztrF_v8W4c}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenOrderId_thenReturnGAn4gYYGpYQsc88VJztrFV8W4c()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("GAn4gYYGpYQsc88VJztrF_v8W4c", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code NQyD_thR-_aaQBJt1B4fxXeg6bY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenOrderId_thenReturnNQyDThRAaQBJt1B4fxXeg6bY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("NQyD_thR-_aaQBJt1B4fxXeg6bY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code RsHATo0gMfYPN-9nn7e2W7PJrvQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenOrderId_thenReturnRsHATo0gMfYPN9nn7e2W7PJrvQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("RsHATo0gMfYPN-9nn7e2W7PJrvQ",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("HmacSHA1", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code unwoUqLrNg8O9Bae56ELJ3Uqb1Q}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenOrderId_thenReturnUnwoUqLrNg8O9Bae56ELJ3Uqb1Q()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("unwoUqLrNg8O9Bae56ELJ3Uqb1Q", paymentGatewayTamperProofSealServiceImpl
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code zSzsiPkWG1rrMqfODpjYnHIg1K4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenOrderId_thenReturnZSzsiPkWG1rrMqfODpjYnHIg1K4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("zSzsiPkWG1rrMqfODpjYnHIg1K4",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code zth0bsNh58_HOtwKcXJaZnWc4pg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenOrderId_thenReturnZth0bsNh58HOtwKcXJaZnWc4pg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("zth0bsNh58_HOtwKcXJaZnWc4pg",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code 4T9ViMN9kPm2eOfw_lmPTltEpvc}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturn4T9ViMN9kPm2eOfwLmPTltEpvc()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("4T9ViMN9kPm2eOfw_lmPTltEpvc",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code 7p9RiPGXWv2m6JJmm4FL7WyrTvk}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturn7p9RiPGXWv2m6JJmm4FL7WyrTvk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("7p9RiPGXWv2m6JJmm4FL7WyrTvk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code BVA1ih2GRXJd5IYwBfK1JMlaD08}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturnBVA1ih2GRXJd5IYwBfK1JMlaD08()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("BVA1ih2GRXJd5IYwBfK1JMlaD08",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code bbvm6hUe446B2WGX20DzQlKkcxI}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturnBbvm6hUe446B2WGX20DzQlKkcxI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("bbvm6hUe446B2WGX20DzQlKkcxI",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code BnYRKOfRIC9DMJLtCE-2UkiGYak}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturnBnYRKOfRIC9DMJLtCE2UkiGYak()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("BnYRKOfRIC9DMJLtCE-2UkiGYak",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code cAj578aKEA1-EcROx0HTKoc3P-M}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturnCAj578aKEA1EcROx0HTKoc3PM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("cAj578aKEA1-EcROx0HTKoc3P-M",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code CZRHEvvDmdIJ6XCGZD_DrBL_sDw}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturnCZRHEvvDmdIJ6XCGZDDrBLSDw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("CZRHEvvDmdIJ6XCGZD_DrBL_sDw",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code eQhspWHVS5CqB-S5mY1haaKyyxk}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturnEQhspWHVS5CqBS5mY1haaKyyxk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("eQhspWHVS5CqB-S5mY1haaKyyxk",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code Ln6nNiLKww163oSX6vHrv3NuyaE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturnLn6nNiLKww163oSX6vHrv3NuyaE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("Ln6nNiLKww163oSX6vHrv3NuyaE",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\\r|\\n", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code nKyXjLcwJ3UGxa7qhAf9EyzKKa4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturnNKyXjLcwJ3UGxa7qhAf9EyzKKa4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("nKyXjLcwJ3UGxa7qhAf9EyzKKa4",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code -p9bs-jEtuJAinfLljFDNPVsFUM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturnP9bsJEtuJAinfLljFDNPVsFUM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("-p9bs-jEtuJAinfLljFDNPVsFUM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("42", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code -SlQFjnDqiHsBfW8zGZMu1tUaK0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturnSlQFjnDqiHsBfW8zGZMu1tUaK0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("-SlQFjnDqiHsBfW8zGZMu1tUaK0",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code tlcsbzqr-08sTrthRJsE08u3v68}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturnTlcsbzqr08sTrthRJsE08u3v68()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("tlcsbzqr-08sTrthRJsE08u3v68",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\\r|\\n", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code Tt_3gK3DnJVt3Qy0Ra1bNuZVbCM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturnTt3gK3DnJVt3Qy0Ra1bNuZVbCM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("Tt_3gK3DnJVt3Qy0Ra1bNuZVbCM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code WseeBqcg5S3cdiIcoBJx14auFcs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenRN_thenReturnWseeBqcg5S3cdiIcoBJx14auFcs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("WseeBqcg5S3cdiIcoBJx14auFcs",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("\r", "\r", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code 406Mqqc-tBSOi1sEXVvQWDti9SM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn406MqqcTBSOi1sEXVvQWDti9SM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("406Mqqc-tBSOi1sEXVvQWDti9SM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code HZpMLN4MpN49mrtmiBxWaaIOBRA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnHZpMLN4MpN49mrtmiBxWaaIOBRA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("HZpMLN4MpN49mrtmiBxWaaIOBRA",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code JJXwLj2TpuC-FWTlZkKZ8qbtKzQ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnJJXwLj2TpuCFWTlZkKZ8qbtKzQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("JJXwLj2TpuC-FWTlZkKZ8qbtKzQ",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code _KbBWddFwcwYG8m4LPuRNAyA1H4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnKbBWddFwcwYG8m4LPuRNAyA1H4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("_KbBWddFwcwYG8m4LPuRNAyA1H4",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code kveMHfkkjyikoL1CzAUD6NOUxXY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnKveMHfkkjyikoL1CzAUD6NOUxXY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("kveMHfkkjyikoL1CzAUD6NOUxXY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code M43QalGWxRXNEX-dPA-mc0TjNJU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnM43QalGWxRXNEXDPAMc0TjNJU()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("M43QalGWxRXNEX-dPA-mc0TjNJU",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code -M96SmqBBfSlx8Kn-JdFnMyJmp8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnM96SmqBBfSlx8KnJdFnMyJmp8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("-M96SmqBBfSlx8Kn-JdFnMyJmp8",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code mxRCpfGtSfGHtQxPXhZjf1T65dY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnMxRCpfGtSfGHtQxPXhZjf1T65dY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("mxRCpfGtSfGHtQxPXhZjf1T65dY",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code qRZ_ovQP6XPR1gB1Qo_7CjG_FpM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnQRZOvQP6XPR1gB1Qo7CjGFpM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("qRZ_ovQP6XPR1gB1Qo_7CjG_FpM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code rS2pgvBS1swthmwG6od86tcenrM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PaymentGatewayTamperProofSealServiceImpl.createTamperProofSeal(String, String, String)"})
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnRS2pgvBS1swthmwG6od86tcenrM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("rS2pgvBS1swthmwG6od86tcenrM",
        paymentGatewayTamperProofSealServiceImpl.createTamperProofSeal("Secret Key", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code 406Mqqc-tBSOi1sEXVvQWDti9SM}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_when406MqqcTBSOi1sEXVvQWDti9SM_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "406Mqqc-tBSOi1sEXVvQWDti9SM", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code 406Mqqc-tBSOi1sEXVvQWDti9SM}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_when406MqqcTBSOi1sEXVvQWDti9SM_thenReturnFalse2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "42", "406Mqqc-tBSOi1sEXVvQWDti9SM"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCr_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCr_thenReturnFalse2() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCr_thenReturnFalse3() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCr_thenReturnFalse4() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCr_thenReturnFalse5() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCr_thenReturnFalse6() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCr_thenReturnFalse7() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCr_thenReturnFalse8() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCr_thenReturnFalse9() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCr_thenReturnFalse10() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCr_thenReturnFalse11() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCr_thenReturnFalse12() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCr_thenReturnFalse13() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCustomerId_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCustomerId_thenReturnFalse2() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCustomerId_thenReturnFalse3() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCustomerId_thenReturnFalse4() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCustomerId_thenReturnFalse5() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCustomerId_thenReturnFalse6() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCustomerId_thenReturnFalse7() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenCustomerId_thenReturnFalse8() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "Customer Id", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnFalse2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnFalse3()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnFalse4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnFalse5()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnFalse6()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnFalse7()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnFalse8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnFalse9()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnFalse10()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnFalse11()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnFalse12()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnFalse13()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnTrue()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertTrue(paymentGatewayTamperProofSealServiceImpl.verifySeal("sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEmptyString_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEmptyString_thenReturnFalse2() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEmptyString_thenReturnFalse3() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEmptyString_thenReturnFalse4() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEmptyString_thenReturnFalse5() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEmptyString_thenReturnFalse6() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEmptyString_thenReturnFalse7() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenEmptyString_thenReturnFalse8() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code FevQ0jx5od5v1RTYmR3fUt4ToKQ}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenFevQ0jx5od5v1RTYmR3fUt4ToKQ_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "FevQ0jx5od5v1RTYmR3fUt4ToKQ", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code FevQ0jx5od5v1RTYmR3fUt4ToKQ}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenFevQ0jx5od5v1RTYmR3fUt4ToKQ_thenReturnFalse2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42",
        "FevQ0jx5od5v1RTYmR3fUt4ToKQ"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenHmacSHA1_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenHmacSHA1_thenReturnFalse2() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenHmacSHA1_thenReturnFalse3() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenHmacSHA1_thenReturnFalse4() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenHmacSHA1_thenReturnFalse5() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenHmacSHA1_thenReturnFalse6() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenHmacSHA1_thenReturnFalse7() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenHmacSHA1_thenReturnFalse8() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenHmacSHA1_thenReturnFalse9() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenHmacSHA1_thenReturnFalse10() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenHmacSHA1_thenReturnFalse11() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenHmacSHA1_thenReturnFalse12() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenHmacSHA1_thenReturnFalse13() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB8_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "IgPuvGE5_0jePFMloMJXfiXBkB8", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB8_thenReturnFalse2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", "IgPuvGE5_0jePFMloMJXfiXBkB8"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code JtaejkMTk2LMEqShMFY1GTRYxp0}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenJtaejkMTk2LMEqShMFY1GTRYxp0_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "JtaejkMTk2LMEqShMFY1GTRYxp0", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code JtaejkMTk2LMEqShMFY1GTRYxp0}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenJtaejkMTk2LMEqShMFY1GTRYxp0_thenReturnFalse2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", "JtaejkMTk2LMEqShMFY1GTRYxp0"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenNull_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal(null, "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenNull_thenReturnFalse2() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenNull_thenReturnFalse3() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenNull_thenReturnFalse4() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenNull_thenReturnFalse5() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenNull_thenReturnFalse6() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenNull_thenReturnFalse7() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenNull_thenReturnFalse8() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenNull_thenReturnFalse9() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenNull_thenReturnFalse10() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenNull_thenReturnFalse11() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenNull_thenReturnFalse12() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenNull_thenReturnFalse13() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY_thenReturnFalse2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenOrderId_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenOrderId_thenReturnFalse2() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\r", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenOrderId_thenReturnFalse3() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "HmacSHA1", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenOrderId_thenReturnFalse4() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenOrderId_thenReturnFalse5() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenOrderId_thenReturnFalse6() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenOrderId_thenReturnFalse7() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenOrderId_thenReturnFalse8() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", "Order Id"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenRN_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenRN_thenReturnFalse2() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenRN_thenReturnFalse3() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenRN_thenReturnFalse4() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenRN_thenReturnFalse5() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenRN_thenReturnFalse6() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenRN_thenReturnFalse7() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenRN_thenReturnFalse8() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenRN_thenReturnFalse9() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenRN_thenReturnFalse10() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenRN_thenReturnFalse11() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenRN_thenReturnFalse12() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenRN_thenReturnFalse13() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY_thenReturnFalse2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY_thenReturnFalse3()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY_thenReturnFalse4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY_thenReturnFalse5()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY_thenReturnFalse6()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY_thenReturnFalse7()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY_thenReturnFalse8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY_thenReturnFalse9()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Seal}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSeal_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Seal}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSeal_thenReturnFalse2() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Seal}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSeal_thenReturnFalse3() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Seal}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSeal_thenReturnFalse4() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Seal}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSeal_thenReturnFalse5() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Seal}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSeal_thenReturnFalse6() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "42", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSecretKey_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "42", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSecretKey_thenReturnFalse2() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "\r", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSecretKey_thenReturnFalse3() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "HmacSHA1", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSecretKey_thenReturnFalse4() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "\\r|\\n", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSecretKey_thenReturnFalse5() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "Seal", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSecretKey_thenReturnFalse6() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", null, "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSecretKey_thenReturnFalse7() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "42", "\r"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSecretKey_thenReturnFalse8() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "42", "HmacSHA1"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSecretKey_thenReturnFalse9() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "42", "\\r|\\n"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSecretKey_thenReturnFalse10() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "42", "Seal"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenSecretKey_thenReturnFalse11() throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Secret Key", "42", null));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code tlcsbzqr-08sTrthRJsE08u3v68}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenTlcsbzqr08sTrthRJsE08u3v68_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "tlcsbzqr-08sTrthRJsE08u3v68", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code tlcsbzqr-08sTrthRJsE08u3v68}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenTlcsbzqr08sTrthRJsE08u3v68_thenReturnFalse2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "\\r|\\n", "42", "tlcsbzqr-08sTrthRJsE08u3v68"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code ztaecluhjjaSQ7VKdgb97gJ-o2Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenZtaecluhjjaSQ7VKdgb97gJO2Y_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "ztaecluhjjaSQ7VKdgb97gJ-o2Y", "42"));
  }

  /**
   * Test {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code ztaecluhjjaSQ7VKdgb97gJ-o2Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "java.lang.Boolean PaymentGatewayTamperProofSealServiceImpl.verifySeal(String, String, String, String)"})
  public void testVerifySeal_whenZtaecluhjjaSQ7VKdgb97gJO2Y_thenReturnFalse2()
      throws InvalidKeyException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertFalse(
        paymentGatewayTamperProofSealServiceImpl.verifySeal("Seal", "Seal", "42", "ztaecluhjjaSQ7VKdgb97gJ-o2Y"));
  }
}
