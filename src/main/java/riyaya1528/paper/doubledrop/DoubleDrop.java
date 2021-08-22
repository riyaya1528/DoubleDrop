package riyaya1528.paper.doubledrop;

import org.bukkit.configuration.Configuration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DoubleDrop extends JavaPlugin implements Listener {
    public static Configuration config;
    public static DoubleDrop instance;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Drop(),this);
        getCommand("doubledrop").setExecutor(new Commands());

        config = getConfig();
        instance = this;
        System.out.println("[DoubleDrop]プラグインが有効になりました");
    }

    @Override
    public void onDisable() {
        System.out.println("[DoubleDrop]プラグインが無効になりました");
    }

    public static void SetDrop(int Drop) {
        config.set("drop",Drop);
        instance.saveConfig();
    }
    public static int Drop() {
        return instance.getConfig().getInt("drop") - 1;
    }
}
