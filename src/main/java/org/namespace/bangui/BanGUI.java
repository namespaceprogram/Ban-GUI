package org.namespace.bangui;

import org.bukkit.plugin.java.JavaPlugin;
import org.namespace.bangui.commands.BanGuiCommand;
import org.namespace.bangui.listeners.BanInventoryListener;

public final class BanGUI extends JavaPlugin {

    private static BanGUI plugin;

    @Override
    public void onEnable() {

        plugin = this;

        getCommand("bangui").setExecutor(new BanGuiCommand());

        getServer().getPluginManager().registerEvents(new BanInventoryListener(), this);

    }

    public static BanGUI getPlugin() {
        return plugin;
    }
}
