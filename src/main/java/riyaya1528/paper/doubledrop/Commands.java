package riyaya1528.paper.doubledrop;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(sender.isOp()) {
                if(args.length != 0) {
                    if(isNum(args[0])) {
                        DoubleDrop.SetDrop(Integer.parseInt(args[0]));
                        sender.sendMessage("ドロップ倍率を" + args[0] + "にセットしました");
                    }else{
                        sender.sendMessage("§c§l倍率には整数を入力してください");
                    }
                }else {
                    sender.sendMessage("§c§l引数を指定してください");
                    sender.sendMessage("§c§l例: /doubledrop [ドロップ倍率]");
                }
            }
        }
        return true;
    }

    static boolean isNum(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
