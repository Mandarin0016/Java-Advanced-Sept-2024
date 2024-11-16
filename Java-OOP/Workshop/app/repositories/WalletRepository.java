package repositories;

import entities.wallet.Wallet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class WalletRepository implements Repository<Wallet, UUID> {

    private Map<UUID, Wallet> walletStorage = new HashMap<>();

    @Override
    public void save(UUID id, Wallet wallet) {
        this.walletStorage.put(id, wallet);
    }

    @Override
    public Wallet getById(UUID id) {
        return walletStorage.get(id);
    }

    @Override
    public List<Wallet> getAll() {
        return walletStorage.values().stream().toList();
    }
}
