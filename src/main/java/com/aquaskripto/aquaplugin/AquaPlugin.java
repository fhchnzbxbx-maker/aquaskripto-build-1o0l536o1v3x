package com.aquaskripto.aquaplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class AquaPlugin extends JavaPlugin {

    private Command aquaCommand;

    @Override
    public void onEnable() {
        aquaCommand = new Command("aqua") {
            @Override
            public boolean execute(CommandSender sender, String label, String[] args) {
                if (sender instanceof Player) {
                    sender.sendMessage("Aqua działa.");
                } else {
                    sender.sendMessage("Ta komenda jest dostępna tylko dla graczy.");
                }
                return true;
            }
        };

        aquaCommand.setDescription("Sprawdza działanie pluginu AquaPlugin.");
        aquaCommand.setUsage("/aqua");
        getServer().getCommandMap().register("aquaplugin", aquaCommand);
    }

    @Override
    public void onDisable() {
        if (aquaCommand != null) {
            aquaCommand.unregister(getServer().getCommandMap());
        }
    }
}