package net.comorevi.moneyschestshop.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import net.comorevi.moneyschestshop.util.DataCenter;

public class ChestShopCommand extends Command {
    public ChestShopCommand(String name) {
        super(name, "チェストショップの編集モードを有効/無効化します。", "/cshop");
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (!commandSender.isPlayer()) {
            commandSender.sendMessage("このコマンドはゲーム内から実行できます。");
            return true;
        }

        if (DataCenter.existsEditCmdQueue((Player) commandSender)) {
            DataCenter.removeEditCmdQueue((Player) commandSender);
            commandSender.sendMessage(TextFormat.GRAY + "システム>>" + TextFormat.RESET + "チェストショップ編集モードを無効化しました。");
        } else {
            DataCenter.addEditCmdQueue((Player) commandSender);
            commandSender.sendMessage(TextFormat.GRAY + "システム>>" + TextFormat.RESET + "チェストショップ編集モードを有効化しました。");
        }
        return true;
    }
}