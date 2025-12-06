package de.scholle.essentiax.addons;

import de.scholle.essentiax.EssentiaX;

public interface EssentiaXAddon {
    void onLoad(EssentiaX plugin);
    void onEnable(EssentiaX plugin);
    void onDisable(EssentiaX plugin);
}
