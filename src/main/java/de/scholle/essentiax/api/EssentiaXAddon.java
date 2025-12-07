package de.scholle.essentiax.api;

import org.bukkit.plugin.Plugin;

public interface EssentiaXAddon {
    void onLoad(Plugin plugin);
    void onEnable(Plugin plugin);
    void onDisable(Plugin plugin);
}
