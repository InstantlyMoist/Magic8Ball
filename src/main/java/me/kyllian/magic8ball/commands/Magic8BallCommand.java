package me.kyllian.magic8ball.commands;

import me.kyllian.magic8ball.Magic8BallPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Magic8BallCommand implements CommandExecutor {

    private Magic8BallPlugin plugin;

    public Magic8BallCommand(Magic8BallPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (!(sender.hasPermission("magic8ball.reload"))) {
                    sender.sendMessage(plugin.getMessageUtils().getNoPermissionMessage());
                    return true;
                }
                plugin.reloadConfig();
                sender.sendMessage(plugin.getMessageUtils().getReloadMessage());
                return true;
            }
        }
        sender.sendMessage(plugin.getMessageUtils().getUnknownArgumentMessage());
        return true;
    }
}
