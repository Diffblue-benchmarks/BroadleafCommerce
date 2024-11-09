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
package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.junit.Test;

public class PaymentGatewayTamperProofSealServiceImplDiffblueTest {
  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code 0cTiUxuvZqKt3MjpP-1MASO2KNY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturn0cTiUxuvZqKt3MjpP1maso2kny()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("0cTiUxuvZqKt3MjpP-1MASO2KNY", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code 0xuCa4XmNlvaNCW-hGHhYtcAfII}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturn0xuCa4XmNlvaNCWHGHhYtcAfII()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("0xuCa4XmNlvaNCW-hGHhYtcAfII", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code 1FG2gnnvrVQ5SpyDxaD3_gTv-us}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturn1FG2gnnvrVQ5SpyDxaD3GTvUs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("1FG2gnnvrVQ5SpyDxaD3_gTv-us", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code 1oV__tbpXGKi0rq0dDh97i_HHuQ}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturn1oVTbpXGKi0rq0dDh97iHHuQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("1oV__tbpXGKi0rq0dDh97i_HHuQ", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code 7f0cgKmhwUd_tPNoRpfDt_3XL2o}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturn7f0cgKmhwUdTPNoRpfDt3XL2o()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("7f0cgKmhwUd_tPNoRpfDt_3XL2o", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code 240sUHqX-D8nXPbQTqIGyJ9tanI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturn240sUHqXD8nXPbQTqIGyJ9tanI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("240sUHqX-D8nXPbQTqIGyJ9tanI", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code 944XXw0vCyFbIE4-QfJ3HWzXWME}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturn944XXw0vCyFbIE4QfJ3HWzXWME()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("944XXw0vCyFbIE4-QfJ3HWzXWME", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code Af-VMmIUYJ8hSeTiz8sZxnFAu-0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnAfVMmIUYJ8hSeTiz8sZxnFAu0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Af-VMmIUYJ8hSeTiz8sZxnFAu-0", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code CAp7B9ynYEs6skxV6Q3_FjfCxkg}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnCAp7B9ynYEs6skxV6Q3FjfCxkg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("CAp7B9ynYEs6skxV6Q3_FjfCxkg", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code CbSCTyjPn5vF0OgyXrRXj5B3VKM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnCbSCTyjPn5vF0OgyXrRXj5B3VKM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("CbSCTyjPn5vF0OgyXrRXj5B3VKM", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code CzYF3m-tO6XGaLgv59f_-gFkcX0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnCzYF3mTO6XGaLgv59fGFkcX0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("CzYF3m-tO6XGaLgv59f_-gFkcX0", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code E8uB0wx9qTV5boBcN00CH66s_cw}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnE8uB0wx9qTV5boBcN00CH66sCw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("E8uB0wx9qTV5boBcN00CH66s_cw", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code GAn4gYYGpYQsc88VJztrF_v8W4c}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnGAn4gYYGpYQsc88VJztrFV8W4c()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("GAn4gYYGpYQsc88VJztrF_v8W4c", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code h9iN8mYez-IDmhMPRI0W60ofKt8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnH9iN8mYezIDmhMPRI0W60ofKt8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("h9iN8mYez-IDmhMPRI0W60ofKt8", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnHaTqhQ4C8ZHUrFsNEZnmPH6Q()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code hyr6f0l6i3shGZ-tBIVtsmlGPGk}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnHyr6f0l6i3shGZTBIVtsmlGPGk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("hyr6f0l6i3shGZ-tBIVtsmlGPGk", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code m3GIMULiACYDokdOqmpnmlLGDTs}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnM3GIMULiACYDokdOqmpnmlLGDTs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("m3GIMULiACYDokdOqmpnmlLGDTs", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code pPHhTOX7bpS3zBzZgPHIGFinME8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnPPHhTOX7bpS3zBzZgPHIGFinME8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("pPHhTOX7bpS3zBzZgPHIGFinME8", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code pi7Z6_OLowr63TFhzpEi2-vcrgk}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnPi7Z6OLowr63TFhzpEi2Vcrgk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("pi7Z6_OLowr63TFhzpEi2-vcrgk", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code pvbmP5Y3jlUvZ8yjaAbNYKkz9us}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnPvbmP5Y3jlUvZ8yjaAbNYKkz9us()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("pvbmP5Y3jlUvZ8yjaAbNYKkz9us", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code q6pjVjanGrLn0-FHk2SWXBSi5aE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnQ6pjVjanGrLn0FHk2SWXBSi5aE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("q6pjVjanGrLn0-FHk2SWXBSi5aE", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code SNqY6ufenJLOT51LeJyKLF5XsHY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnSNqY6ufenJLOT51LeJyKLF5XsHY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("SNqY6ufenJLOT51LeJyKLF5XsHY", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnSNqsTSzcdqtIvTFHUEVghnf0xHY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("sNqsTSzcdqtIvTFHUEVghnf0xHY", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code sbU42dGCepiXJcDpu6LAYd7bZR0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnSbU42dGCepiXJcDpu6LAYd7bZR0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("sbU42dGCepiXJcDpu6LAYd7bZR0", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code t4O7JXDlKRm_Z6yxPWhnawAzS3c}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnT4O7JXDlKRmZ6yxPWhnawAzS3c()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("t4O7JXDlKRm_Z6yxPWhnawAzS3c", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code uSgW-GUHcUxlkXUs40cppvJsmw0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnUSgWGUHcUxlkXUs40cppvJsmw0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("uSgW-GUHcUxlkXUs40cppvJsmw0", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code unwoUqLrNg8O9Bae56ELJ3Uqb1Q}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnUnwoUqLrNg8O9Bae56ELJ3Uqb1Q()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("unwoUqLrNg8O9Bae56ELJ3Uqb1Q", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code vhSwWFhvNbKEmyaP_jvB97d2R38}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnVhSwWFhvNbKEmyaPJvB97d2R38()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("vhSwWFhvNbKEmyaP_jvB97d2R38", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code w9zO-4-eV0Z4LTKIjubXI9zeaz0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnW9zO4EV0Z4LTKIjubXI9zeaz0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("w9zO-4-eV0Z4LTKIjubXI9zeaz0", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code Yc3IfLaBbSqp9kuxL58YZRlu0hI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnYc3IfLaBbSqp9kuxL58YZRlu0hI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Yc3IfLaBbSqp9kuxL58YZRlu0hI", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code ZatE8KJTwTBQ7jlSjw-ZoR7x2XI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnZatE8KJTwTBQ7jlSjwZoR7x2XI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("ZatE8KJTwTBQ7jlSjw-ZoR7x2XI", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>Then return {@code zhuzagJl7J1hq_o1mUMKPDK2hkw}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_thenReturnZhuzagJl7J1hqO1mUMKPDK2hkw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("zhuzagJl7J1hq_o1mUMKPDK2hkw", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code JtaejkMTk2LMEqShMFY1GTRYxp0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_when42_thenReturnJtaejkMTk2LMEqShMFY1GTRYxp0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("JtaejkMTk2LMEqShMFY1GTRYxp0",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "42", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code 4af_i5eWdzpsBvBoD9A_vptOhxA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturn4afI5eWdzpsBvBoD9AVptOhxA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("4af_i5eWdzpsBvBoD9A_vptOhxA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\r", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code 5YKBudoB1KzRuw9CZ_u5i1Z6VpI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturn5YKBudoB1KzRuw9CZU5i1Z6VpI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("5YKBudoB1KzRuw9CZ_u5i1Z6VpI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\r", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code 6fVQO8Iz_cH_Da3lajTtaaNLiHY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturn6fVQO8IzCHDa3lajTtaaNLiHY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("6fVQO8Iz_cH_Da3lajTtaaNLiHY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code 79-icLuv45Um14pDOoK2S7kht-Y}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturn79IcLuv45Um14pDOoK2S7khtY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("79-icLuv45Um14pDOoK2S7kht-Y",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "42", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code CZRHEvvDmdIJ6XCGZD_DrBL_sDw}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnCZRHEvvDmdIJ6XCGZDDrBLSDw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("CZRHEvvDmdIJ6XCGZD_DrBL_sDw",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "42", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code eQhspWHVS5CqB-S5mY1haaKyyxk}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnEQhspWHVS5CqBS5mY1haaKyyxk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("eQhspWHVS5CqB-S5mY1haaKyyxk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code ETyIyJs7lK1ykyUGjuwqPhvtBAo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnETyIyJs7lK1ykyUGjuwqPhvtBAo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("ETyIyJs7lK1ykyUGjuwqPhvtBAo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\r", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code FcXvaeATPdTjsRW1_oBz5ED3ckY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnFcXvaeATPdTjsRW1OBz5ED3ckY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("FcXvaeATPdTjsRW1_oBz5ED3ckY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\r", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code GbAGpzDDR4HbrQkT9Ae-l1OIUTc}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnGbAGpzDDR4HbrQkT9AeL1OIUTc()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("GbAGpzDDR4HbrQkT9Ae-l1OIUTc",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code k_8FS97EthV3pxCOfGSyXd1RjZA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnK8FS97EthV3pxCOfGSyXd1RjZA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("k_8FS97EthV3pxCOfGSyXd1RjZA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "42", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code LYVGmwZjXmI0USYv8DjWFNoFZLc}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnLYVGmwZjXmI0USYv8DjWFNoFZLc()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("LYVGmwZjXmI0USYv8DjWFNoFZLc",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "HmacSHA1", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code Ln6nNiLKww163oSX6vHrv3NuyaE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnLn6nNiLKww163oSX6vHrv3NuyaE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Ln6nNiLKww163oSX6vHrv3NuyaE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\\r|\\n", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code nRuc5Dw1SGLVEldnmtqPKIjA_yg}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnNRuc5Dw1SGLVEldnmtqPKIjAYg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("nRuc5Dw1SGLVEldnmtqPKIjA_yg",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\r", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnOQbDLn8zttlxvxVF7DhTFV1jdY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("oQbDLn8zttlxvxVF7DhTFV1jd-Y",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "42", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code RiPpb2KwscLxTcKvAY239R9Dr1o}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnRiPpb2KwscLxTcKvAY239R9Dr1o()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("RiPpb2KwscLxTcKvAY239R9Dr1o",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "42", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code -SlQFjnDqiHsBfW8zGZMu1tUaK0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnSlQFjnDqiHsBfW8zGZMu1tUaK0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-SlQFjnDqiHsBfW8zGZMu1tUaK0",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\\r|\\n", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code Tt_3gK3DnJVt3Qy0Ra1bNuZVbCM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnTt3gK3DnJVt3Qy0Ra1bNuZVbCM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Tt_3gK3DnJVt3Qy0Ra1bNuZVbCM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code WseeBqcg5S3cdiIcoBJx14auFcs}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnWseeBqcg5S3cdiIcoBJx14auFcs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("WseeBqcg5S3cdiIcoBJx14auFcs",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\r", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code x1n7atITF0SqSdwCRifqoNxPMew}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnX1n7atITF0SqSdwCRifqoNxPMew()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("x1n7atITF0SqSdwCRifqoNxPMew",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\r", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code xSgXnRtQjjrSTPwOWSBNcl0H4h8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnXSgXnRtQjjrSTPwOWSBNcl0H4h8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("xSgXnRtQjjrSTPwOWSBNcl0H4h8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "HmacSHA1", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code YT5LaGhSGi98t1LY_3DTbqbpYOo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCr_thenReturnYT5LaGhSGi98t1LY3DTbqbpYOo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("YT5LaGhSGi98t1LY_3DTbqbpYOo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\r", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code 1QWOEuh3iLj4ZBjz_pgwqFuWlDg}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturn1QWOEuh3iLj4ZBjzPgwqFuWlDg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("1QWOEuh3iLj4ZBjz_pgwqFuWlDg",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code 1amYbQZvHgCZLYtK8eg0CivLfdQ}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturn1amYbQZvHgCZLYtK8eg0CivLfdQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("1amYbQZvHgCZLYtK8eg0CivLfdQ",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "Customer Id", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code 6cgj6FzexH5PElZa2zfOgccYZkA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturn6cgj6FzexH5PElZa2zfOgccYZkA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("6cgj6FzexH5PElZa2zfOgccYZkA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "Customer Id", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code 6P0_pyBuAWAE5fcFbgp__aHbx2k}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturn6p0PyBuAWAE5fcFbgpAHbx2k()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("6P0_pyBuAWAE5fcFbgp__aHbx2k",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code 57_xUZQ4O5-vUs2oScOrdlFtoyE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturn57XUZQ4O5VUs2oScOrdlFtoyE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("57_xUZQ4O5-vUs2oScOrdlFtoyE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "Customer Id", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code aILCXCOZX7wqasHbiQI1Pe6ie8s}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnAILCXCOZX7wqasHbiQI1Pe6ie8s()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("aILCXCOZX7wqasHbiQI1Pe6ie8s",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "Customer Id", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code AK1QP7g5usw8quMcMHU7PPgXdU4}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnAK1QP7g5usw8quMcMHU7PPgXdU4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("AK1QP7g5usw8quMcMHU7PPgXdU4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "Customer Id", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code HZ8Q5Jv9Tgcpc1LJc0NiKqnrOfo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnHZ8Q5Jv9Tgcpc1LJc0NiKqnrOfo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("HZ8Q5Jv9Tgcpc1LJc0NiKqnrOfo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "Customer Id", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code HhSbrjIWn4WOgkwctW646uWf4Zg}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnHhSbrjIWn4WOgkwctW646uWf4Zg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("HhSbrjIWn4WOgkwctW646uWf4Zg",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "Customer Id", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code IzEdrUsmDR1OZpb7QPnursck8VM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnIzEdrUsmDR1OZpb7QPnursck8VM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("IzEdrUsmDR1OZpb7QPnursck8VM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "Customer Id", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code k4iqQQ4gJsE-d3OJMS86PuaWJfM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnK4iqQQ4gJsED3OJMS86PuaWJfM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("k4iqQQ4gJsE-d3OJMS86PuaWJfM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code ncvvM7lzC6pX-oRzr_QReoMRuY8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnNcvvM7lzC6pXORzrQReoMRuY8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("ncvvM7lzC6pX-oRzr_QReoMRuY8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "Customer Id", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code QDFXJ8lrRWasejqgFqu6GaXU7XA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnQDFXJ8lrRWasejqgFqu6GaXU7XA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("QDFXJ8lrRWasejqgFqu6GaXU7XA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "Customer Id", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code r8qFzFsWTHudoGqSwmoWZj0g4xo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnR8qFzFsWTHudoGqSwmoWZj0g4xo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("r8qFzFsWTHudoGqSwmoWZj0g4xo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code STGAgqhH7U4EU5wmR7UMKpvM8RM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnSTGAgqhH7U4EU5wmR7UMKpvM8RM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("STGAgqhH7U4EU5wmR7UMKpvM8RM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code tb-_zjqDr08WuaSpvpFJ-K-mvuY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnTbZjqDr08WuaSpvpFJKMvuY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("tb-_zjqDr08WuaSpvpFJ-K-mvuY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "Customer Id", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code u1zevV4-jxVinvk2Vw0CX7JJE38}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnU1zevV4JxVinvk2Vw0CX7JJE38()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("u1zevV4-jxVinvk2Vw0CX7JJE38",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "Customer Id", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code u7Cn8yIBSmbfmFJ4AKuvIyTzhGk}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnU7Cn8yIBSmbfmFJ4AKuvIyTzhGk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("u7Cn8yIBSmbfmFJ4AKuvIyTzhGk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "Customer Id", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code UzDK6P_NGwsY7jYY9idqgt9QnG0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnUzDK6PNGwsY7jYY9idqgt9QnG0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("UzDK6P_NGwsY7jYY9idqgt9QnG0",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code V0fZCg5pMaPIYBqmrG0Y3gMZbns}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnV0fZCg5pMaPIYBqmrG0Y3gMZbns()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("V0fZCg5pMaPIYBqmrG0Y3gMZbns",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code X3hva1xmdWKX2P1I0wLj2TpczuE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnX3hva1xmdWKX2P1I0wLj2TpczuE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("X3hva1xmdWKX2P1I0wLj2TpczuE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code xhp6XDhmH1Dc2d9xYCesihrX_D4}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnXhp6XDhmH1Dc2d9xYCesihrXD4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("xhp6XDhmH1Dc2d9xYCesihrX_D4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "Customer Id", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code y7e5MkvHkO1g0bekZwSegC9TNcM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnY7e5MkvHkO1g0bekZwSegC9TNcM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("y7e5MkvHkO1g0bekZwSegC9TNcM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "Customer Id", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code zEhbW5bsG5OQ9DZUNKGW-yxjVoY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenCustomerId_thenReturnZEhbW5bsG5OQ9DZUNKGWYxjVoY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("zEhbW5bsG5OQ9DZUNKGW-yxjVoY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "Customer Id", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code 3BS7a4LwmaD1l6lqK8LBjHr-vgA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturn3BS7a4LwmaD1l6lqK8LBjHrVgA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("3BS7a4LwmaD1l6lqK8LBjHr-vgA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code 7TfFqE43gT4uk0foYCMo9JKk4zw}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturn7TfFqE43gT4uk0foYCMo9JKk4zw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("7TfFqE43gT4uk0foYCMo9JKk4zw",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code auuhV1xDnb8ktZzd8tff-UZ92uM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnAuuhV1xDnb8ktZzd8tffUZ92uM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("auuhV1xDnb8ktZzd8tff-UZ92uM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code B355E25AoLrFMrmvjn__ahU0fa4}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnB355E25AoLrFMrmvjnAhU0fa4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("B355E25AoLrFMrmvjn__ahU0fa4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "HmacSHA1", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code eeJj8ru73d0-4iECLNthWYbBHXw}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnEeJj8ru73d04iECLNthWYbBHXw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("eeJj8ru73d0-4iECLNthWYbBHXw",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code hN2eppko516z5VaLAgXcrkYphQs}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnHN2eppko516z5VaLAgXcrkYphQs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("hN2eppko516z5VaLAgXcrkYphQs",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\\r|\\n", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code JQjvhNx-FpTbRHJi1qBhld59Olw}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnJQjvhNxFpTbRHJi1qBhld59Olw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("JQjvhNx-FpTbRHJi1qBhld59Olw",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code kLqBNAOTfi1Oe9teyghts6jlfe8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnKLqBNAOTfi1Oe9teyghts6jlfe8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("kLqBNAOTfi1Oe9teyghts6jlfe8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\r", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code kUMPgvAgA5T0Kj2bleKR-9PVbZg}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnKUMPgvAgA5T0Kj2bleKR9PVbZg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("kUMPgvAgA5T0Kj2bleKR-9PVbZg",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\\r|\\n", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code Kd2X8f8X2FS1DbGrE4Prsnya22w}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnKd2X8f8X2FS1DbGrE4Prsnya22w()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Kd2X8f8X2FS1DbGrE4Prsnya22w",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\\r|\\n", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code lN0PO7CIrk2Wl462LHgxAEqAIXk}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnLN0PO7CIrk2Wl462LHgxAEqAIXk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("lN0PO7CIrk2Wl462LHgxAEqAIXk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code MRciCXfeaElXsZa_WipdCZXl2ZI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnMRciCXfeaElXsZaWipdCZXl2ZI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("MRciCXfeaElXsZa_WipdCZXl2ZI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "HmacSHA1", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code NmJzZUVEdaMhlP68n-vvAQt7Res}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnNmJzZUVEdaMhlP68nVvAQt7Res()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("NmJzZUVEdaMhlP68n-vvAQt7Res",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\\r|\\n", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code OYSa-F1TykPsyT3j-mUVrZADxsw}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnOYSaF1TykPsyT3jMUVrZADxsw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("OYSa-F1TykPsyT3j-mUVrZADxsw",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "HmacSHA1", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code QALRtNESDXJ7AiDaXTaV-4WnWeo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnQALRtNESDXJ7AiDaXTaV4WnWeo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("QALRtNESDXJ7AiDaXTaV-4WnWeo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code qLpyinyyNQ0JNfbSrYA-_FEYcmY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnQLpyinyyNQ0JNfbSrYAFEYcmY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("qLpyinyyNQ0JNfbSrYA-_FEYcmY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "HmacSHA1", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code u-s6ttrQER2E7F9lnys74vdU7VI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnUS6ttrQER2E7F9lnys74vdU7VI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("u-s6ttrQER2E7F9lnys74vdU7VI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\r", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code v1L5FBjl32VmI2fHiwYaLvPwsK0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnV1L5FBjl32VmI2fHiwYaLvPwsK0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("v1L5FBjl32VmI2fHiwYaLvPwsK0",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\r", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code y2-djIQ8IuU9uX9_0v8gq1jJHjE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnY2DjIQ8IuU9uX90v8gq1jJHjE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("y2-djIQ8IuU9uX9_0v8gq1jJHjE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code yEx9BbISXzx3z3OyBExvrMr7-Vs}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenEmptyString_thenReturnYEx9BbISXzx3z3OyBExvrMr7Vs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("yEx9BbISXzx3z3OyBExvrMr7-Vs",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\r", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code 6sPG1MdgV0yWMccYU786xZL4zII}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturn6sPG1MdgV0yWMccYU786xZL4zII()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("6sPG1MdgV0yWMccYU786xZL4zII",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\r", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code 29cZvFHL1BiopnxiDKwl-gfbgls}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturn29cZvFHL1BiopnxiDKwlGfbgls()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("29cZvFHL1BiopnxiDKwl-gfbgls",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "HmacSHA1", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code 80oK7Knum6cOjZRb4Oxa2ATox3U}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturn80oK7Knum6cOjZRb4Oxa2ATox3U()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("80oK7Knum6cOjZRb4Oxa2ATox3U",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "HmacSHA1", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code ADKW7x46hnNb1EHbrnw_5TnRGsk}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnADKW7x46hnNb1EHbrnw5TnRGsk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("ADKW7x46hnNb1EHbrnw_5TnRGsk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "42", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code C5jjBlb6QlM7Cc4-irOOMgeUWTY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnC5jjBlb6QlM7Cc4IrOOMgeUWTY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("C5jjBlb6QlM7Cc4-irOOMgeUWTY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\\r|\\n", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code CrzNAPnHy9G_waOATyKAE0ZRTBk}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnCrzNAPnHy9GWaOATyKAE0ZRTBk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("CrzNAPnHy9G_waOATyKAE0ZRTBk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code dQ-MTlBbXwNfXcLGA84YP9T9cXs}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnDQMTlBbXwNfXcLGA84YP9T9cXs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("dQ-MTlBbXwNfXcLGA84YP9T9cXs",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code eMdhaldlNjPK0VTwcRCCjQzJfkE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnEMdhaldlNjPK0VTwcRCCjQzJfkE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("eMdhaldlNjPK0VTwcRCCjQzJfkE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\r", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code hRz2dH3-ibGiESQ2kZHr3EC6TvI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnHRz2dH3IbGiESQ2kZHr3EC6TvI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("hRz2dH3-ibGiESQ2kZHr3EC6TvI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "HmacSHA1", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnIgPuvGE50jePFMloMJXfiXBkB8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("IgPuvGE5_0jePFMloMJXfiXBkB8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "42", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code KTmbTv_qZAdQlX41cQTV3FMqeGA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnKTmbTvQZAdQlX41cQTV3FMqeGA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("KTmbTv_qZAdQlX41cQTV3FMqeGA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "HmacSHA1", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code lLqvQD4NaAu4YacPPoVW4Kk9JGA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnLLqvQD4NaAu4YacPPoVW4Kk9JGA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("lLqvQD4NaAu4YacPPoVW4Kk9JGA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code L__ngKnTQDrBl8pDTvvt15QjcmA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnLNgKnTQDrBl8pDTvvt15QjcmA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("L__ngKnTQDrBl8pDTvvt15QjcmA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code RH45VxwkybzBn5fd_zP-yn7u1Og}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnRH45VxwkybzBn5fdZPYn7u1Og()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("RH45VxwkybzBn5fd_zP-yn7u1Og",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "42", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code s9TvOu9HAuD1uNWOWs9Aqn6Q_e0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnS9TvOu9HAuD1uNWOWs9Aqn6QE0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("s9TvOu9HAuD1uNWOWs9Aqn6Q_e0",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code sM5V8ywc2a0KV8IKYIh54Xkpklk}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnSM5V8ywc2a0KV8IKYIh54Xkpklk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("sM5V8ywc2a0KV8IKYIh54Xkpklk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\\r|\\n", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code t20sMpGd9nJzrEA7rULqdrpVKBc}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnT20sMpGd9nJzrEA7rULqdrpVKBc()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("t20sMpGd9nJzrEA7rULqdrpVKBc",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "42", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code tBT9IkrBlGo_aaGw7GjJA3Sf6n4}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnTBT9IkrBlGoAaGw7GjJA3Sf6n4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("tBT9IkrBlGo_aaGw7GjJA3Sf6n4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\r", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code vwWXvQHEVfDexI1q-190cl43Jr8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnVwWXvQHEVfDexI1q190cl43Jr8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("vwWXvQHEVfDexI1q-190cl43Jr8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "42", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code YEe8Zbj12HXypdlqW5fpA9MASjI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnYEe8Zbj12HXypdlqW5fpA9MASjI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("YEe8Zbj12HXypdlqW5fpA9MASjI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\r", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code zuo52h9A9V5XAzI_zpznypMw6Vw}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenHmacSHA1_thenReturnZuo52h9A9V5XAzIZpznypMw6Vw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("zuo52h9A9V5XAzI_zpznypMw6Vw",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code 1VfOoYCXAKA2P3M-R_e4mltDZSk}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturn1VfOoYCXAKA2P3MRE4mltDZSk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("1VfOoYCXAKA2P3M-R_e4mltDZSk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\\r|\\n", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code AX8b4TYA9MpsLrTZLxj-mKFXliQ}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnAX8b4TYA9MpsLrTZLxjMKFXliQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("AX8b4TYA9MpsLrTZLxj-mKFXliQ",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "HmacSHA1", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code CX-3_rrPPwmmqMEr281LSo8QQGU}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnCx3RrPPwmmqMEr281LSo8QQGU()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("CX-3_rrPPwmmqMEr281LSo8QQGU",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "\r", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code EIkRJNg0TZE1TzshK9upv4BjtcY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnEIkRJNg0TZE1TzshK9upv4BjtcY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("EIkRJNg0TZE1TzshK9upv4BjtcY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "42", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code hVa4apvKTYIaIC2umOFItoBD3v0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnHVa4apvKTYIaIC2umOFItoBD3v0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("hVa4apvKTYIaIC2umOFItoBD3v0",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "HmacSHA1", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code k3WhDJbk7t8-T1RYtwnCNnW0w1k}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnK3WhDJbk7t8T1RYtwnCNnW0w1k()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("k3WhDJbk7t8-T1RYtwnCNnW0w1k",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\\r|\\n", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code kqxM8Tzfwsum2nyJr7JwYEFV3n8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnKqxM8Tzfwsum2nyJr7JwYEFV3n8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("kqxM8Tzfwsum2nyJr7JwYEFV3n8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\r", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code NQyD_thR-_aaQBJt1B4fxXeg6bY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnNQyDThRAaQBJt1B4fxXeg6bY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("NQyD_thR-_aaQBJt1B4fxXeg6bY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\r", "", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code NWTMzqcB908ioU4LVaQ1yic21Hs}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnNWTMzqcB908ioU4LVaQ1yic21Hs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("NWTMzqcB908ioU4LVaQ1yic21Hs",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\r", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code PPbOlss1kJA_6Aez09SlKVCThO8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnPPbOlss1kJA6Aez09SlKVCThO8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("PPbOlss1kJA_6Aez09SlKVCThO8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "HmacSHA1", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code rjEgg7TrjD21YbF1Pj2HpuzFD8U}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnRjEgg7TrjD21YbF1Pj2HpuzFD8U()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("rjEgg7TrjD21YbF1Pj2HpuzFD8U",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code RsHATo0gMfYPN-9nn7e2W7PJrvQ}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnRsHATo0gMfYPN9nn7e2W7PJrvQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("RsHATo0gMfYPN-9nn7e2W7PJrvQ",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "42", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code SScqF1YWaUdqIahBm5YPCWZW7g8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnSScqF1YWaUdqIahBm5YPCWZW7g8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("SScqF1YWaUdqIahBm5YPCWZW7g8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code SUHDXUtU6vGkVPFl8Lnl5iOPaYM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnSUHDXUtU6vGkVPFl8Lnl5iOPaYM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("SUHDXUtU6vGkVPFl8Lnl5iOPaYM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("HmacSHA1", "\\r|\\n", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code syis3762QsgnWmaaBsLqBDPNQ3M}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnSyis3762QsgnWmaaBsLqBDPNQ3M()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("syis3762QsgnWmaaBsLqBDPNQ3M",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\r", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code TApyTv5MGy2w7o1fHiPLsjzcnxU}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnTApyTv5MGy2w7o1fHiPLsjzcnxU()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("TApyTv5MGy2w7o1fHiPLsjzcnxU",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "HmacSHA1", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code YEGXTyELVHUPQ1wAAF28Wi8clsE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnYEGXTyELVHUPQ1wAAF28Wi8clsE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("YEGXTyELVHUPQ1wAAF28Wi8clsE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code zOSq2hpABr-LLc1G46RW-8beL1o}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnZOSq2hpABrLLc1G46RW8beL1o()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("zOSq2hpABr-LLc1G46RW-8beL1o",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\\r|\\n", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code zSzsiPkWG1rrMqfODpjYnHIg1K4}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnZSzsiPkWG1rrMqfODpjYnHIg1K4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("zSzsiPkWG1rrMqfODpjYnHIg1K4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "42", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code zth0bsNh58_HOtwKcXJaZnWc4pg}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenOrderId_thenReturnZth0bsNh58HOtwKcXJaZnWc4pg()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("zth0bsNh58_HOtwKcXJaZnWc4pg",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "42", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code 4T9ViMN9kPm2eOfw_lmPTltEpvc}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturn4T9ViMN9kPm2eOfwLmPTltEpvc()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("4T9ViMN9kPm2eOfw_lmPTltEpvc",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "42", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code 7p9RiPGXWv2m6JJmm4FL7WyrTvk}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturn7p9RiPGXWv2m6JJmm4FL7WyrTvk()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("7p9RiPGXWv2m6JJmm4FL7WyrTvk",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "HmacSHA1", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code aLmtqIfRgKMqNUtNJmVhwsMnCSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnALmtqIfRgKMqNUtNJmVhwsMnCSE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("aLmtqIfRgKMqNUtNJmVhwsMnCSE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\\r|\\n", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code BVA1ih2GRXJd5IYwBfK1JMlaD08}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnBVA1ih2GRXJd5IYwBfK1JMlaD08()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("BVA1ih2GRXJd5IYwBfK1JMlaD08",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\r", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code bbvm6hUe446B2WGX20DzQlKkcxI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnBbvm6hUe446B2WGX20DzQlKkcxI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("bbvm6hUe446B2WGX20DzQlKkcxI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "42", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code bcPjL2TRZ5CZBHntd9JYEieUl2s}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnBcPjL2TRZ5CZBHntd9JYEieUl2s()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("bcPjL2TRZ5CZBHntd9JYEieUl2s",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code BnYRKOfRIC9DMJLtCE-2UkiGYak}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnBnYRKOfRIC9DMJLtCE2UkiGYak()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("BnYRKOfRIC9DMJLtCE-2UkiGYak",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "42", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code cAj578aKEA1-EcROx0HTKoc3P-M}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnCAj578aKEA1EcROx0HTKoc3PM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("cAj578aKEA1-EcROx0HTKoc3P-M",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "42", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code cFW-4rT4eP0vgYH2yiPj36-l2a0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnCFW4rT4eP0vgYH2yiPj36L2a0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("cFW-4rT4eP0vgYH2yiPj36-l2a0",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code ihVrSsnC8fiu8SiPivzbAEJj2TI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnIhVrSsnC8fiu8SiPivzbAEJj2TI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("ihVrSsnC8fiu8SiPivzbAEJj2TI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "HmacSHA1", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code jU-zOu3QBocS8YOGlKpC9q6SKmo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnJUZOu3QBocS8YOGlKpC9q6SKmo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("jU-zOu3QBocS8YOGlKpC9q6SKmo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code k_DJ5Vkfw6QlT8qVQfiqTjudhSM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnKDJ5Vkfw6QlT8qVQfiqTjudhSM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("k_DJ5Vkfw6QlT8qVQfiqTjudhSM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code M17yZV_JzszrkxItmiPnRZtQjf4}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnM17yZVJzszrkxItmiPnRZtQjf4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("M17yZV_JzszrkxItmiPnRZtQjf4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code Mcn6nvm1hXpbc9ysXYm3ZfdFB3I}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnMcn6nvm1hXpbc9ysXYm3ZfdFB3I()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Mcn6nvm1hXpbc9ysXYm3ZfdFB3I",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\r", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code nKyXjLcwJ3UGxa7qhAf9EyzKKa4}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnNKyXjLcwJ3UGxa7qhAf9EyzKKa4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("nKyXjLcwJ3UGxa7qhAf9EyzKKa4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\\r|\\n", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code -p9bs-jEtuJAinfLljFDNPVsFUM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnP9bsJEtuJAinfLljFDNPVsFUM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-p9bs-jEtuJAinfLljFDNPVsFUM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("42", "\\r|\\n", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code pdbTTbesJ_schLtfBx1nS23XkDQ}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnPdbTTbesJSchLtfBx1nS23XkDQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("pdbTTbesJ_schLtfBx1nS23XkDQ",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\\r|\\n", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code tlcsbzqr-08sTrthRJsE08u3v68}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnTlcsbzqr08sTrthRJsE08u3v68()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("tlcsbzqr-08sTrthRJsE08u3v68",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "42", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code UP_Ef_7OOdAY8T863w-yy7Nv3ew}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnUpEf7OOdAY8T863wYy7Nv3ew()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("UP_Ef_7OOdAY8T863w-yy7Nv3ew",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code vRD_le7AoG35mJ8TlUxA0CPwcU4}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnVRDLe7AoG35mJ8TlUxA0CPwcU4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("vRD_le7AoG35mJ8TlUxA0CPwcU4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\r", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code WLGwVF86PU5LE9WeuR5R7xswJ0w}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenRN_thenReturnWLGwVF86PU5LE9WeuR5R7xswJ0w()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("WLGwVF86PU5LE9WeuR5R7xswJ0w",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("\\r|\\n", "\r", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code 1gedig7UNOPvzoo0mOLaHAjrZr4}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn1gedig7UNOPvzoo0mOLaHAjrZr4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("1gedig7UNOPvzoo0mOLaHAjrZr4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\\r|\\n", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code 2Exqd7Qu7Il63qyQgE8NZuWKfto}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn2Exqd7Qu7Il63qyQgE8NZuWKfto()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("2Exqd7Qu7Il63qyQgE8NZuWKfto",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "HmacSHA1", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code 3NX10gZmJvHiufpD0-CcPiap4IM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn3NX10gZmJvHiufpD0CcPiap4IM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("3NX10gZmJvHiufpD0-CcPiap4IM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code 6IYHxQarxBQRGHiE8fs5-gQG6yo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn6IYHxQarxBQRGHiE8fs5GQG6yo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("6IYHxQarxBQRGHiE8fs5-gQG6yo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\\r|\\n", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code 7bl62f3uLkgt8Md0c9MlB9EMHIs}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn7bl62f3uLkgt8Md0c9MlB9EMHIs()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("7bl62f3uLkgt8Md0c9MlB9EMHIs",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\r", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code 8VL8c4t0AWnRsN6qijgBKXwzS6A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn8VL8c4t0AWnRsN6qijgBKXwzS6A()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("8VL8c4t0AWnRsN6qijgBKXwzS6A",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\\r|\\n", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code 9vA79KFt3hmcQZ3L3O5QS9P-wqI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn9vA79KFt3hmcQZ3L3O5QS9PWqI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("9vA79KFt3hmcQZ3L3O5QS9P-wqI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\\r|\\n", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code 27pH0rnaUQwJj8kiENtGSSFlcvQ}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn27pH0rnaUQwJj8kiENtGSSFlcvQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("27pH0rnaUQwJj8kiENtGSSFlcvQ",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "HmacSHA1", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code 406Mqqc-tBSOi1sEXVvQWDti9SM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturn406MqqcTBSOi1sEXVvQWDti9SM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("406Mqqc-tBSOi1sEXVvQWDti9SM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "42", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code bgnemZQbnzDK5XEOGDjLPUFnt-c}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnBgnemZQbnzDK5XEOGDjLPUFntC()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("bgnemZQbnzDK5XEOGDjLPUFnt-c",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\r", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code cbYPFheiOZmJ4tmPvSqdxF8SeYU}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnCbYPFheiOZmJ4tmPvSqdxF8SeYU()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("cbYPFheiOZmJ4tmPvSqdxF8SeYU",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code F7aq_FAL-_pyNs64_mctc-U71go}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnF7aqFalPyNs64MctcU71go()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("F7aq_FAL-_pyNs64_mctc-U71go",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "Customer Id", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code gO7ojKOcGuRaE7Ve5whET2sRimI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnGO7ojKOcGuRaE7Ve5whET2sRimI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("gO7ojKOcGuRaE7Ve5whET2sRimI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "Customer Id", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code HZpMLN4MpN49mrtmiBxWaaIOBRA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnHZpMLN4MpN49mrtmiBxWaaIOBRA()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("HZpMLN4MpN49mrtmiBxWaaIOBRA",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "HmacSHA1", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code JJXwLj2TpuC-FWTlZkKZ8qbtKzQ}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnJJXwLj2TpuCFWTlZkKZ8qbtKzQ()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("JJXwLj2TpuC-FWTlZkKZ8qbtKzQ",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code _KbBWddFwcwYG8m4LPuRNAyA1H4}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnKbBWddFwcwYG8m4LPuRNAyA1H4()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("_KbBWddFwcwYG8m4LPuRNAyA1H4",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\r", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code kveMHfkkjyikoL1CzAUD6NOUxXY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnKveMHfkkjyikoL1CzAUD6NOUxXY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("kveMHfkkjyikoL1CzAUD6NOUxXY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\\r|\\n", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code M43QalGWxRXNEX-dPA-mc0TjNJU}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnM43QalGWxRXNEXDPAMc0TjNJU()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("M43QalGWxRXNEX-dPA-mc0TjNJU",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "42", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code -M96SmqBBfSlx8Kn-JdFnMyJmp8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnM96SmqBBfSlx8KnJdFnMyJmp8()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("-M96SmqBBfSlx8Kn-JdFnMyJmp8",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "42", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code mxRCpfGtSfGHtQxPXhZjf1T65dY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnMxRCpfGtSfGHtQxPXhZjf1T65dY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("mxRCpfGtSfGHtQxPXhZjf1T65dY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "42", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code Nh5cUzNCCqFA38q4QksMVXlNQE0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnNh5cUzNCCqFA38q4QksMVXlNQE0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Nh5cUzNCCqFA38q4QksMVXlNQE0", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("Secret Key", "Customer Id", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code OKmQ8uPR9xWh8p_vLCC6ZAvFDXw}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnOKmQ8uPR9xWh8pVLCC6ZAvFDXw()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("OKmQ8uPR9xWh8p_vLCC6ZAvFDXw",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\\r|\\n", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code Ptmxmr_uLGUtOzEIIuyVxPT5sWU}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnPtmxmrULGUtOzEIIuyVxPT5sWU()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Ptmxmr_uLGUtOzEIIuyVxPT5sWU",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\r", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code Q3dYmgPS1YUEB4x-qeMDS6EBsGY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnQ3dYmgPS1YUEB4xQeMDS6EBsGY()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Q3dYmgPS1YUEB4x-qeMDS6EBsGY",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code Q13TRmXqw17rFbL7RkOVUSNR6tI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnQ13TRmXqw17rFbL7RkOVUSNR6tI()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Q13TRmXqw17rFbL7RkOVUSNR6tI",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "HmacSHA1", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code qRZ_ovQP6XPR1gB1Qo_7CjG_FpM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnQRZOvQP6XPR1gB1Qo7CjGFpM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("qRZ_ovQP6XPR1gB1Qo_7CjG_FpM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "Customer Id", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code rS2pgvBS1swthmwG6od86tcenrM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnRS2pgvBS1swthmwG6od86tcenrM()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("rS2pgvBS1swthmwG6od86tcenrM",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "42", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code S3oYZm3Id-Pcddl-XpkH9pWuX1I}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnS3oYZm3IdPcddlXpkH9pWuX1I()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("S3oYZm3Id-Pcddl-XpkH9pWuX1I",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "HmacSHA1", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code tYic8o_A1X8PmAnH4YODNbmBJjo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnTYic8oA1X8PmAnH4YODNbmBJjo()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("tYic8o_A1X8PmAnH4YODNbmBJjo",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\r", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code TZ_g0Hkz9b5skaqHXRWD73nymX0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnTzG0Hkz9b5skaqHXRWD73nymX0()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("TZ_g0Hkz9b5skaqHXRWD73nymX0", (new PaymentGatewayTamperProofSealServiceImpl())
        .createTamperProofSeal("Secret Key", "Customer Id", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code TzOgIV5L0ZJVu9OilTHjWVhbM0A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnTzOgIV5L0ZJVu9OilTHjWVhbM0A()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("TzOgIV5L0ZJVu9OilTHjWVhbM0A",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "HmacSHA1", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code yagqdk_vYDXHPy9dv45-VLnkcoE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#createTamperProofSeal(String, String, String)}
   */
  @Test
  public void testCreateTamperProofSeal_whenSecretKey_thenReturnYagqdkVYDXHPy9dv45VLnkcoE()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("yagqdk_vYDXHPy9dv45-VLnkcoE",
        (new PaymentGatewayTamperProofSealServiceImpl()).createTamperProofSeal("Secret Key", "\r", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code 4OLe0d5c2uJKjCKKf-z6Qe2IlME}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_when4OLe0d5c2uJKjCKKfZ6Qe2IlME_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "4OLe0d5c2uJKjCKKf-z6Qe2IlME", "42",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "4OLe0d5c2uJKjCKKf-z6Qe2IlME", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code 7f0cgKmhwUd_tPNoRpfDt_3XL2o}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_when7f0cgKmhwUdTPNoRpfDt3XL2o_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "7f0cgKmhwUd_tPNoRpfDt_3XL2o",
        "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "7f0cgKmhwUd_tPNoRpfDt_3XL2o"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code 7helzpZSnhza-7W92tJ4mhPlQsg}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_when7helzpZSnhza7W92tJ4mhPlQsg_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "7helzpZSnhza-7W92tJ4mhPlQsg", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "7helzpZSnhza-7W92tJ4mhPlQsg", null));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_when42_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "Seal"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code 406Mqqc-tBSOi1sEXVvQWDti9SM}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_when406MqqcTBSOi1sEXVvQWDti9SM_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key",
        "406Mqqc-tBSOi1sEXVvQWDti9SM", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42",
        "406Mqqc-tBSOi1sEXVvQWDti9SM"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code AK__Dht6Kh9LJgsFSixaNw7owOU}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenAkDht6Kh9LJgsFSixaNw7owOU_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "AK__Dht6Kh9LJgsFSixaNw7owOU",
        "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y",
        "AK__Dht6Kh9LJgsFSixaNw7owOU"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code ByPp6oyyYtSpNy-glhed81Se1G8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenByPp6oyyYtSpNyGlhed81Se1G8_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "ByPp6oyyYtSpNy-glhed81Se1G8",
        "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal",
        "ByPp6oyyYtSpNy-glhed81Se1G8"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When cr.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenCr_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", "Seal"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Customer Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenCustomerId_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Customer Id", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Customer Id", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Customer Id", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code E8uB0wx9qTV5boBcN00CH66s_cw}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenE8uB0wx9qTV5boBcN00CH66sCw_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "E8uB0wx9qTV5boBcN00CH66s_cw", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "E8uB0wx9qTV5boBcN00CH66s_cw", "\r"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenEXAMPLEKEYwjalrXUtnFEMIK7mdengBPxRfiCY_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "Seal"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenEmptyString_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", ""));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code FevQ0jx5od5v1RTYmR3fUt4ToKQ}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenFevQ0jx5od5v1RTYmR3fUt4ToKQ_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "FevQ0jx5od5v1RTYmR3fUt4ToKQ", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42",
        "FevQ0jx5od5v1RTYmR3fUt4ToKQ"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenHaTqhQ4C8ZHUrFsNEZnmPH6Q_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q",
        "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "Ha-Tqh-Q4C8ZHUrFs-nEZnmPH6Q"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code HmacSHA1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenHmacSHA1_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code idRxGCR4HFCuZFP5t1ZPRbbos8Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenIdRxGCR4HFCuZFP5t1ZPRbbos8Y_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "idRxGCR4HFCuZFP5t1ZPRbbos8Y", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "idRxGCR4HFCuZFP5t1ZPRbbos8Y"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code IgPuvGE5_0jePFMloMJXfiXBkB8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenIgPuvGE50jePFMloMJXfiXBkB8_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1",
        "IgPuvGE5_0jePFMloMJXfiXBkB8", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42",
        "IgPuvGE5_0jePFMloMJXfiXBkB8"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code JtaejkMTk2LMEqShMFY1GTRYxp0}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenJtaejkMTk2LMEqShMFY1GTRYxp0_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "JtaejkMTk2LMEqShMFY1GTRYxp0", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "JtaejkMTk2LMEqShMFY1GTRYxp0"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code LLtjqx89gh4mgZX3UphEL5-HiRY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenLLtjqx89gh4mgZX3UphEL5HiRY_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "LLtjqx89gh4mgZX3UphEL5-HiRY", "42",
        "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "LLtjqx89gh4mgZX3UphEL5-HiRY", "Seal"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code LYVGmwZjXmI0USYv8DjWFNoFZLc}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenLYVGmwZjXmI0USYv8DjWFNoFZLc_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "LYVGmwZjXmI0USYv8DjWFNoFZLc",
        "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1",
        "LYVGmwZjXmI0USYv8DjWFNoFZLc"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code m3GIMULiACYDokdOqmpnmlLGDTs}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenM3GIMULiACYDokdOqmpnmlLGDTs_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "m3GIMULiACYDokdOqmpnmlLGDTs", "42",
        "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "m3GIMULiACYDokdOqmpnmlLGDTs", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code nRuc5Dw1SGLVEldnmtqPKIjA_yg}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenNRuc5Dw1SGLVEldnmtqPKIjAYg_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "nRuc5Dw1SGLVEldnmtqPKIjA_yg", "\r", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", "nRuc5Dw1SGLVEldnmtqPKIjA_yg"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenNull_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal(null,
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42", null));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", null, "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", null));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code oQbDLn8zttlxvxVF7DhTFV1jd-Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenOQbDLn8zttlxvxVF7DhTFV1jdY_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "oQbDLn8zttlxvxVF7DhTFV1jd-Y"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1",
        "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n",
        "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal",
        "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key",
        "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y",
        "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y",
        "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y",
        "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y",
        "Order Id"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", null));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "oQbDLn8zttlxvxVF7DhTFV1jd-Y", ""));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Order Id}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenOrderId_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42",
        "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", null, "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "HmacSHA1", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code pPHhTOX7bpS3zBzZgPHIGFinME8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenPPHhTOX7bpS3zBzZgPHIGFinME8_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "pPHhTOX7bpS3zBzZgPHIGFinME8", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "pPHhTOX7bpS3zBzZgPHIGFinME8"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code pi7Z6_OLowr63TFhzpEi2-vcrgk}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenPi7Z6OLowr63TFhzpEi2Vcrgk_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "pi7Z6_OLowr63TFhzpEi2-vcrgk",
        "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Customer Id", "pi7Z6_OLowr63TFhzpEi2-vcrgk"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code q6pjVjanGrLn0-FHk2SWXBSi5aE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenQ6pjVjanGrLn0FHk2SWXBSi5aE_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "q6pjVjanGrLn0-FHk2SWXBSi5aE", "42",
        "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "q6pjVjanGrLn0-FHk2SWXBSi5aE", "HmacSHA1"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code \r|\n}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenRN_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\r", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "Seal", "\\r|\\n"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code SNqY6ufenJLOT51LeJyKLF5XsHY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenSNqY6ufenJLOT51LeJyKLF5XsHY_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "SNqY6ufenJLOT51LeJyKLF5XsHY", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "", "SNqY6ufenJLOT51LeJyKLF5XsHY"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "Seal", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42",
        "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42",
        "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42",
        "Seal"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "Seal"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "HmacSHA1", "42",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse(
        (new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "42", "42", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\r", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "HmacSHA1", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "\\r|\\n", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code sNqsTSzcdqtIvTFHUEVghnf0xHY}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenSNqsTSzcdqtIvTFHUEVghnf0xHY_thenReturnTrue()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("sNqsTSzcdqtIvTFHUEVghnf0xHY",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "42", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Secret Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenSecretKey_thenReturnFalse() throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "\r", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "HmacSHA1", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "Customer Id", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", null, "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42", "\r"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42", "HmacSHA1"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42", "\\r|\\n"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42", "Seal"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42", "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42", null));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Secret Key", "42",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code -SlQFjnDqiHsBfW8zGZMu1tUaK0}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenSlQFjnDqiHsBfW8zGZMu1tUaK0_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "-SlQFjnDqiHsBfW8zGZMu1tUaK0",
        "\\r|\\n", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\r", "\\r|\\n",
        "-SlQFjnDqiHsBfW8zGZMu1tUaK0"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code tlcsbzqr-08sTrthRJsE08u3v68}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenTlcsbzqr08sTrthRJsE08u3v68_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n",
        "tlcsbzqr-08sTrthRJsE08u3v68", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "\\r|\\n", "42",
        "tlcsbzqr-08sTrthRJsE08u3v68"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code u1zevV4-jxVinvk2Vw0CX7JJE38}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenU1zevV4JxVinvk2Vw0CX7JJE38_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "u1zevV4-jxVinvk2Vw0CX7JJE38",
        "Customer Id", "42"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code unwoUqLrNg8O9Bae56ELJ3Uqb1Q}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenUnwoUqLrNg8O9Bae56ELJ3Uqb1Q_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "unwoUqLrNg8O9Bae56ELJ3Uqb1Q", "42",
        "Order Id"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "unwoUqLrNg8O9Bae56ELJ3Uqb1Q", "Order Id"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code YSAJgMDwzoythpbAJ550dp2jGgI}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenYSAJgMDwzoythpbAJ550dp2jGgI_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "YSAJgMDwzoythpbAJ550dp2jGgI",
        "Seal", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "Seal", "YSAJgMDwzoythpbAJ550dp2jGgI"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code ztaecluhjjaSQ7VKdgb97gJ-o2Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenZtaecluhjjaSQ7VKdgb97gJO2Y_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal",
        "ztaecluhjjaSQ7VKdgb97gJ-o2Y", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "Seal", "42",
        "ztaecluhjjaSQ7VKdgb97gJ-o2Y"));
  }

  /**
   * Test
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}.
   * <ul>
   *   <li>When {@code ZyPgyE_wWCyj2sHBmProMtVNsh4}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayTamperProofSealServiceImpl#verifySeal(String, String, String, String)}
   */
  @Test
  public void testVerifySeal_whenZyPgyEWWCyj2sHBmProMtVNsh4_thenReturnFalse()
      throws InvalidKeyException, NoSuchAlgorithmException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal", "ZyPgyE_wWCyj2sHBmProMtVNsh4",
        "sNqsTSzcdqtIvTFHUEVghnf0xHY", "42"));
    assertFalse((new PaymentGatewayTamperProofSealServiceImpl()).verifySeal("Seal",
        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", "sNqsTSzcdqtIvTFHUEVghnf0xHY", "ZyPgyE_wWCyj2sHBmProMtVNsh4"));
  }
}
