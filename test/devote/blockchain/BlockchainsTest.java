package devote.blockchain;

import com.typesafe.config.Config;
import devote.blockchain.api.IssuerAccount;
import devote.blockchain.mockblockchain.MockBlockchainIssuerAccount;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlockchainsTest {
    @Mock
    private Config mockConfig;

    private Blockchains blockchains;

    @Before
    public void setupTest() {
        MockitoAnnotations.initMocks(this);
        blockchains = new Blockchains(mockConfig);
    }

    @Test
    public void testDiscovery() {
        // Given
        // When
        BlockchainFactory factoryForMockBlockchain = blockchains.getFactoryByNetwork("mockblockchain");

        // Then
        assertThat(factoryForMockBlockchain, notNullValue());

        IssuerAccount issuerAccount = factoryForMockBlockchain.createIssuerAccount();
        assertThat(issuerAccount, instanceOf(MockBlockchainIssuerAccount.class));

        MockBlockchainIssuerAccount mockIssuerAccount = (MockBlockchainIssuerAccount) factoryForMockBlockchain.createIssuerAccount();
        assertBlockchainConfigInitCalled(mockIssuerAccount);
        assertTrue(mockIssuerAccount.isInitCalled());
    }

    private void assertBlockchainConfigInitCalled(MockBlockchainIssuerAccount mockIssuerAccount) {
        assertTrue(mockIssuerAccount.getConfig().isInitCalled());
    }
}