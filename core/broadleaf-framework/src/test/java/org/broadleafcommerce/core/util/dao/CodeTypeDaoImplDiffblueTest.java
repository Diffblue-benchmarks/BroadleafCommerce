package org.broadleafcommerce.core.util.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.util.domain.CodeType;
import org.broadleafcommerce.core.util.domain.CodeTypeImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CodeTypeDaoImplDiffblueTest {
  @InjectMocks private CodeTypeDaoImpl codeTypeDaoImpl;

  @Mock private EntityConfiguration entityConfiguration;

  /**
   * Test {@link CodeTypeDaoImpl#create()}.
   *
   * <p>Method under test: {@link CodeTypeDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CodeType CodeTypeDaoImpl.create()"})
  public void testCreate() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(codeTypeImpl);

    // Act
    CodeType actualCreateResult = codeTypeDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.util.domain.CodeType");
    assertSame(codeTypeImpl, actualCreateResult);
  }
}
