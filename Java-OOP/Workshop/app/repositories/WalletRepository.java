package repositories;

import entities.wallet.Wallet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class WalletRepository implements Repository<Wallet, UUID> {

    private final Map<UUID, Wallet> walletStorage = new HashMap<>();

    @Override
    public void save(UUID id, Wallet entity) {
        this.walletStorage.put(id, entity);
    }

    @Override
    public Wallet getById(UUID id) {
        return this.walletStorage.get(id);
    }

    @Override
    public List<Wallet> getAll() {
        return this.walletStorage.values().stream().toList();
    }
}
