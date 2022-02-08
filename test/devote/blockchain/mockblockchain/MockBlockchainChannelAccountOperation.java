package devote.blockchain.mockblockchain;

import devote.blockchain.api.BlockchainConfiguration;
import devote.blockchain.api.ChannelAccountOperation;
import devote.blockchain.api.Account;

public class MockBlockchainChannelAccountOperation implements ChannelAccountOperation {
    public static final int NUM_OF_CHANNEL_ACCOUNTS_TO_CREATE_IN_ON_BATCH = 11;

    private static int currentChannelAccountId = 0;

    @Override
    public void init(BlockchainConfiguration configuration) {
    }

    @Override
    public int maxNumOfAccountsToCreateInOneBatch() {
        return NUM_OF_CHANNEL_ACCOUNTS_TO_CREATE_IN_ON_BATCH;
    }

    @Override
    public Account create(long votesCap, Account issuerAccount) {
        currentChannelAccountId++;
        String currentChannelAccountIdAsString = Integer.toString(currentChannelAccountId);
        return new Account(currentChannelAccountIdAsString, currentChannelAccountIdAsString);
    }

    public static boolean isCreated(String accountSecret) {
        int accountValue = Integer.parseInt(accountSecret);
        return accountValue <= currentChannelAccountId;
    }
}
