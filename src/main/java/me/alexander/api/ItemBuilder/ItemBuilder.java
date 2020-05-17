package me.alexander.api.ItemBuilder;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemBuilder {

    private Material material;
    private int amount;
    private ItemStack itemStack;
    private ItemMeta itemMeta;


    public ItemBuilder (Material material, int amount) {
        this.material = material;
        this.amount = amount;
        this.itemStack = new ItemStack(this.material);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder setDurability(int durability) {
        this.itemStack.setDurability((short) durability);
        return this;
    }

    public ItemBuilder setDisplayName(String name) {
        this.itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        this.itemMeta.addEnchant(enchantment, level, true);
        return this;
    }

    public ItemBuilder addEnchants(Map<Enchantment, Integer> enchantments) {
        if (!enchantments.isEmpty()) {
            for (Enchantment enchantment : enchantments.keySet()) {
                this.itemMeta.addEnchant(enchantment, enchantments.get(enchantment).intValue(), true);
            }
        }
        return this;
    }
    public ItemBuilder addItemFlag(ItemFlag itemFlag) {
        this.itemMeta.addItemFlags(itemFlag);
        return this;
    }

    public ItemBuilder setLore(List<String> lores) {
        ArrayList<String> colouredLores = new ArrayList<>();
        for (String lore : lores) {
            colouredLores.add(ChatColor.translateAlternateColorCodes('&', lore));
        }
        this.itemMeta.setLore(colouredLores);
        return this;
    }

    public ItemBuilder setUnbreakable(boolean unbreakable) {
        this.itemMeta.setUnbreakable(unbreakable);
        return this;
    }

    public String toBase64() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);

            dataOutput.writeObject(this.itemStack);
            dataOutput.close();
            return Base64Coder.encodeLines(outputStream.toByteArray());
        } catch (Exception e) {
            throw new IllegalStateException("Unable to save ItemStack", e);
        }
    }

    public ItemBuilder fromBase64(String from) {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(from));
            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
            this.itemStack = ((ItemStack) dataInput.readObject());
            dataInput.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }

    public void buildPlayer(Player player) {
        player.getInventory().addItem(this.build());
    }


    public Material getMaterial() {
        return this.material;
    }

    public int getAmount() {
        return this.amount;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public ItemMeta getItemMeta() {
        return this.itemMeta;
    }
}