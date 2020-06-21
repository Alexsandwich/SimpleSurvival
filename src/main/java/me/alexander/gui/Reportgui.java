package me.alexander.gui;

import me.alexander.SimpleSurvival;
import me.alexander.commands.Report;
import org.bukkit.entity.Player;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;


public class Reportgui {

    SimpleSurvival plugin;


    public Reportgui(SimpleSurvival instance) {
        plugin = instance;
    }

    public static void openReportGUI(Player player) {
        Inventory reportinv = Bukkit.createInventory(null, 9, format("&8Report &3{target}").replace("{target}", (CharSequence) Report.reported.get(player)));
        ItemStack killaura = new ItemStack(Material.IRON_SWORD);
        ItemMeta killauram = killaura.getItemMeta();
        killauram.setDisplayName(format("&bKillAura"));
        //if (!Main.getMain().getConfig().getString("Report-Items.Killaura.lore").equals("none"))
           // killauram.setLore(Arrays.asList(new String[] { Main.getMain().getConfig().getString("Report-Items.Killaura.lore") }));
        killaura.setItemMeta(killauram);
        ItemStack flight = new ItemStack(Material.FEATHER);
        ItemMeta flightm = flight.getItemMeta();
        flightm.setDisplayName(format("&bFlight"));
        //if (!Main.getMain().getConfig().getString("Report-Items.Flight.lore").equals("none"))
          //  killauram.setLore(Arrays.asList(new String[] { Main.getMain().getConfig().getString("Report-Items.Flight.lore") }));
        flight.setItemMeta(flightm);
        ItemStack antikb = new ItemStack(Material.PACKED_ICE);
        ItemMeta antikbm = antikb.getItemMeta();
        antikbm.setDisplayName(format("&bAnti-KB"));
       // if (!Main.getMain().getConfig().getString("Report-Items.Anti-KB.lore").equals("none"))
          //  killauram.setLore(Arrays.asList(new String[] { Main.getMain().getConfig().getString("Report-Items.Anti-KB.lore") }));
        antikb.setItemMeta(antikbm);
        ItemStack speed = new ItemStack(Material.POTION, 1, (short)34);
        ItemMeta speedm = speed.getItemMeta();
        speedm.setDisplayName(format("&bSpeed"));
        //if (!Main.getMain().getConfig().getString("Report-Items.Speed.lore").equals("none"))
           // killauram.setLore(Arrays.asList(new String[] { Main.getMain().getConfig().getString("Report-Items.Speed.lore") }));
        speedm.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_POTION_EFFECTS });
        speed.setItemMeta(speedm);
        ItemStack aimbot = new ItemStack(Material.PLAYER_HEAD, 1, (short)3);
        SkullMeta aimbotm = (SkullMeta)aimbot.getItemMeta();
        aimbotm.setDisplayName(format("&bAimbot"));
       // if (!Main.getMain().getConfig().getString("Report-Items.Aimbot.lore").equals("none"))
         //   killauram.setLore(Arrays.asList(new String[] { Main.getMain().getConfig().getString("Report-Items.Aimbot.lore") }));
        aimbotm.setOwner((String)Report.reported.get(player));
        aimbot.setItemMeta((ItemMeta)aimbotm);
        ItemStack chat = new ItemStack(Material.PAPER);
        ItemMeta chatm = chat.getItemMeta();
        chatm.setDisplayName(format("&bOffensive Chat"));
      //  if (!Main.getMain().getConfig().getString("Report-Items.Off-Chat.lore").equals("none"))
          // killauram.setLore(Arrays.asList(new String[] { Main.getMain().getConfig().getString("Report-Items.Off-Chat.lore") }));
        chat.setItemMeta(chatm);
        ItemStack jesus = new ItemStack(Material.WATER_BUCKET);
        ItemMeta jesusm = jesus.getItemMeta();
        jesusm.setDisplayName(format("&bJesus"));
       // if (!Main.getMain().getConfig().getString("Report-Items.Jesus.lore").equals("none"))
          //  killauram.setLore(Arrays.asList(new String[] { Main.getMain().getConfig().getString("Report-Items.Jesus.lore") }));
        jesus.setItemMeta(jesusm);
        ItemStack fasteat = new ItemStack(Material.BREAD);
        ItemMeta fasteatm = fasteat.getItemMeta();
        fasteatm.setDisplayName(format("&bFastEat"));
       // if (!Main.getMain().getConfig().getString("Report-Items.FastEat.lore").equals("none"))
         //   killauram.setLore(Arrays.asList(new String[] { Main.getMain().getConfig().getString("Report-Items.FastEat.lore") }));
        fasteat.setItemMeta(fasteatm);
        ItemStack cancel = new ItemStack(Material.WHITE_WOOL, 1, (short)14);
        ItemMeta cancelm = cancel.getItemMeta();
        cancelm.setDisplayName(format("&cCancel"));
       // if (!Main.getMain().getConfig().getString("Report-Items.Cancel.lore").equals("none"))
         //   killauram.setLore(Arrays.asList(new String[] { Main.getMain().getConfig().getString("Report-Items.Cancel.lore") }));
        cancel.setItemMeta(cancelm);
        reportinv.setItem(0, killaura);
        reportinv.setItem(1, flight);
        reportinv.setItem(2, antikb);
        reportinv.setItem(3, speed);
        reportinv.setItem(4, aimbot);
        reportinv.setItem(5, jesus);
        reportinv.setItem(6, fasteat);
        reportinv.setItem(7, chat);
        reportinv.setItem(8, cancel);
        player.openInventory(reportinv);
    }

    public static String format(String var) {
        return ChatColor.translateAlternateColorCodes('&', var);
    }

}