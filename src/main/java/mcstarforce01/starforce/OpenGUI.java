package mcstarforce01.starforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class OpenGUI implements Listener {
    private Inventory enchant;

    private List<Inventory> enchantList = new ArrayList<>();

    private HashMap<Inventory, Integer> enchantMap = new HashMap<>();

    private Inventory anvil;

    private List<Inventory> anvilList = new ArrayList<>();

    private HashMap<Inventory, Integer> anvilMap = new HashMap<>();

    private Inventory grind;

    private List<Inventory> grindList = new ArrayList<>();

    private HashMap<Inventory, Integer> grindMap = new HashMap<>();

    int abilityCount;

    int force = 0;

    String forceString = "";

    public void EnchantTable(Player a) {
        this.enchant = Bukkit.createInventory(null, 9, ChatColor.BOLD + "마법 부여 장치");
        this.enchantList.add(this.enchant);
        this.enchantMap.put(this.enchant, null);
        ItemStack deco = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta meta = deco.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "마법부여 설정");
        deco.setItemMeta(meta);
        this.enchant.setItem(0, deco);
        this.enchant.setItem(1, deco);
        this.enchant.setItem(2, deco);
        this.enchant.setItem(3, deco);
        this.enchant.setItem(5, deco);
        this.enchant.setItem(6, deco);
        this.enchant.setItem(7, deco);
        this.enchant.setItem(8, deco);
        a.openInventory(this.enchant);
    }

    public void AnvilTable(Player a) {
        this.anvil = Bukkit.createInventory(null, 9, ChatColor.BOLD + "스타포스 강화 장치");
        this.anvilList.add(this.anvil);
        this.anvilMap.put(this.anvil, null);
        ItemStack deco = new ItemStack(Material.ANVIL, 1);
        ItemMeta meta = deco.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "스타포스 강화");
        deco.setItemMeta(meta);
        this.anvil.setItem(0, deco);
        this.anvil.setItem(1, deco);
        this.anvil.setItem(2, deco);
        this.anvil.setItem(3, deco);
        this.anvil.setItem(5, deco);
        this.anvil.setItem(6, deco);
        this.anvil.setItem(7, deco);
        this.anvil.setItem(8, deco);
        a.openInventory(this.anvil);
    }

    public void GrindTable(Player a) {
        this.grind = Bukkit.createInventory(null, 9, ChatColor.BOLD + "마법부여 강화 장치");
        this.grindList.add(this.grind);
        this.grindMap.put(this.grind, null);
        ItemStack deco = new ItemStack(Material.ANVIL, 1);
        ItemMeta meta = deco.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "마법부여 강화");
        deco.setItemMeta(meta);
        this.grind.setItem(0, deco);
        this.grind.setItem(1, deco);
        this.grind.setItem(2, deco);
        this.grind.setItem(3, deco);
        this.grind.setItem(5, deco);
        this.grind.setItem(6, deco);
        this.grind.setItem(7, deco);
        this.grind.setItem(8, deco);
        a.openInventory(this.grind);
    }

    @EventHandler
    public void AnvilGui(InventoryClickEvent event) {
        Inventory anvilInven = null;
        for (Inventory inventory : this.anvilList) {
            if (event.getInventory().equals(inventory))
                anvilInven = inventory;
        }
        if (anvilInven == null)
            return;
        Player a = (Player)event.getWhoClicked();
        PlayerInventory playerInventory = a.getInventory();
        ItemStack upgradeItem = new ItemStack(Material.AIR, 1);
        ItemStack spellBook = new ItemStack(Material.BOOK);
        ItemStack firstSlot = spellBook;
        ItemMeta spell = spellBook.getItemMeta();
        spell.setDisplayName(ChatColor.WHITE + "스타포스 강화 주문서");
        spellBook.setItemMeta(spell);
        firstSlot.setItemMeta(spell);
        int slotId = 50;
        this.forceString = "";
        int shieldId = 50;
        ItemStack shieldSpell = new ItemStack(Material.PAPER, 1);
        ItemMeta shieldMeta = shieldSpell.getItemMeta();
        shieldMeta.setDisplayName(ChatColor.WHITE + "파괴 방지 주문서");
        shieldSpell.setItemMeta(shieldMeta);
        shieldSpell.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        List<String> lore = new ArrayList<>();
        List<String> upgradeLore = new ArrayList<>();
        for (int i = 1; i < playerInventory.getMaxStackSize() + 1; i++) {
            int temp = playerInventory.first(firstSlot);
            if (temp < slotId && temp != -1)
                slotId = temp;
            firstSlot.setAmount(firstSlot.getAmount() + 1);
        }
        for (int j = 1; j < playerInventory.getMaxStackSize() + 1; j++) {
            int temp = playerInventory.first(shieldSpell);
            if (temp < shieldId && temp != -1)
                shieldId = temp;
            shieldSpell.setAmount(shieldSpell.getAmount() + 1);
        }
//        Integer[] successPercentage = {950,900,850,850,800,750,700,650,600,550,500,450,400,350,300,300,300,300,300,300,300,300,30,20,10};
//        Integer[] destroyPercentage = {0,0,0,0,0,0,0,0,0,0,0,0,6,13,14,21,21,21,28,28,70,70,194,294,396};
        Integer[] successPercentage = {950,900,850,850,800,750,700,650,600,550,500,450,400,350,300,300,300,300,300,300,300,300,300,200,100};
        Integer[] destroyPercentage = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        switch (event.getCurrentItem().getType()) {
            case IRON_SWORD:
            case IRON_AXE:
            case IRON_PICKAXE:
            case IRON_HELMET:
            case IRON_CHESTPLATE:
            case IRON_LEGGINGS:
            case IRON_BOOTS:
            case GOLDEN_SWORD:
            case GOLDEN_AXE:
            case GOLDEN_PICKAXE:
            case GOLDEN_HELMET:
            case GOLDEN_CHESTPLATE:
            case GOLDEN_LEGGINGS:
            case GOLDEN_BOOTS:
            case DIAMOND_SWORD:
            case DIAMOND_AXE:
            case DIAMOND_PICKAXE:
            case DIAMOND_HELMET:
            case DIAMOND_CHESTPLATE:
            case DIAMOND_LEGGINGS:
            case DIAMOND_BOOTS:
            case NETHERITE_SWORD:
            case NETHERITE_AXE:
            case NETHERITE_PICKAXE:
            case NETHERITE_HELMET:
            case NETHERITE_CHESTPLATE:
            case NETHERITE_LEGGINGS:
            case NETHERITE_BOOTS:
            case SHIELD:
            case TRIDENT:
            case FISHING_ROD:
            case BOW:
            case CROSSBOW:
                if (!event.getSlotType().equals(InventoryType.SlotType.CONTAINER) || event.getSlot() > 8) {
                    upgradeItem.setType(event.getCurrentItem().getType());
                    upgradeItem.setData(event.getCurrentItem().getData());
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    this.force = 0;
                    if (meta.hasLore()) {
//                        this.forceString = meta.getLore().get(1);
//                        Bukkit.getLogger().info(this.forceString);
//                        for (int k = 0; k < this.forceString.length(); k++) {
//                            if (this.forceString.charAt(k) == '★')
//                                this.force++;
//                        }
                        String forceStringGet1 = meta.getLore().get(0);
                        String forceStringGet2 = meta.getLore().get(1);
                        for (int m = 0; m < forceStringGet1.length(); m++) {
                            if (forceStringGet1.charAt(m) == '★')
                                this.force++;
                        }
                        for (int k = 0; k < forceStringGet2.length(); k++) {
                            if (forceStringGet2.charAt(k) == '★')
                                this.force++;
                        }
                    } else {
                        for (int m = 0; m < this.force; m++)
                            this.forceString += "★";
                        for (int k = 0; k < 25 - this.force; k++)
                            this.forceString += "☆";
                    }
                    meta.setLore(null);
                    // 별
                    String upperStar = String.format("%s %s %s", this.forceString.substring(0, 5), this.forceString.substring(5, 10), this.forceString.substring(10, 15));
                    String underStar = String.format("%s %s", this.forceString.substring(15, 20), this.forceString.substring(20, 25));
                    lore.add(0, ChatColor.GOLD + upperStar);
                    lore.add(1, ChatColor.GOLD + underStar);
                    // 강화표 별
                    upgradeLore.add(0, ChatColor.GOLD + upperStar);
                    upgradeLore.add(1, ChatColor.GOLD + underStar);
                    upgradeLore.add(2, "");
                    // 강화표 확률
                    upgradeLore.add(3, ChatColor.WHITE + String.format("성공: %.1f%%", successPercentage[this.force]*0.1));
                    if (this.force <= 10 || this.force == 15 || this.force == 20) {
                        upgradeLore.add(4, ChatColor.WHITE + String.format("유지: %.1f%%", (1000-successPercentage[this.force]-destroyPercentage[this.force])*0.1));
                    } else {
                        upgradeLore.add(4, ChatColor.WHITE + String.format("하락: %.1f%%", (1000-successPercentage[this.force]-destroyPercentage[this.force])*0.1));
                    }
                    if (this.force >= 12) {
                        upgradeLore.add(5, ChatColor.WHITE + String.format("파괴: %.1f%%", destroyPercentage[this.force]*0.1));
                    } else {
                        upgradeLore.add(5, ChatColor.WHITE + "");
                    }
                    meta.setLore(upgradeLore);
                    upgradeItem.setItemMeta(meta);
                    this.anvilMap.put(anvilInven, Integer.valueOf(event.getSlot()));
                    anvilInven.setItem(4, upgradeItem);
                }
                break;
        }
        switch (event.getSlot()) {
            case 4:
                if (event.getSlotType().equals(InventoryType.SlotType.CONTAINER) && playerInventory.containsAtLeast(spellBook, 1)) {
                    int rand = (int) (Math.random() * 1000);
                    this.forceString = "";
                    if (this.force < 25) {
                        if (rand < successPercentage[this.force]) {
                            // 성공(0~24) -> 상승
                            this.force++;
                            a.playSound(a.getLocation(), Sound.BLOCK_ANVIL_USE, 1.0F, 1.0F);
                        } else if (1000 - destroyPercentage[this.force] < rand && this.force >= 12) {
                            // 파괴(12~24)
                            if (playerInventory.containsAtLeast(shieldSpell, 1)) {
                                // 파괴 방지(12~16) -> 하락
                                this.force--;
                                ItemStack usedShield = new ItemStack(playerInventory.getItem(shieldId).getType(), playerInventory.getItem(shieldId).getAmount() - 1);
                                usedShield.setItemMeta(shieldMeta);
                                usedShield.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                                playerInventory.setItem(shieldId, usedShield);
                                a.playSound(a.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1.0F, 1.0F);
                            } else {
                                // 장비의 흔적(12)
                                this.force = 12;
                                a.playSound(a.getLocation(), Sound.ITEM_SHIELD_BREAK, 1.0F, 1.0F);
                            }
                        } else {
                            // 실패(0~24) -> 하락 or 유지
                            if (this.force <= 10 || this.force == 15 || this.force == 20) {
                                // 유지(0~10,15,20)
                                a.playSound(a.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                            } else {
                                // 하락
                                this.force--;
                                a.playSound(a.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1.0F, 1.0F);
                            }
                        }
                        ItemStack usedSpell = new ItemStack(playerInventory.getItem(slotId).getType(), playerInventory.getItem(slotId).getAmount() - 1);
                        usedSpell.setItemMeta(spell);
                        playerInventory.setItem(slotId, usedSpell);
                    }
                    // 확률 디스플레이
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    if (this.force >= 0) {
                        AttributeModifier ia1, ia2, ip1, ip2, ip3, is1, is2, ih1, ih2, ic1, ic2, ic3, il1, il2, il3, ib1, ib2,
                                          ga1, ga2, gp1, gp2, gp3, gs1, gs2, gh1, gh2, gc1, gc2, gc3, gl1, gl2, gl3, gb1, gb2, gb3,
                                          da1, da2, dp1, dp2, dp3, ds1, ds2, dh1, dh2, dh3, dc1, dc2, dc3, dc4, dl1, dl2, dl3, dl4, db1, db2, db3, db4,
                                          na1, na2, np1, np2, np3, ns1, ns2, nh1, nh2, nh3, nc1, nc2, nc3, nc4, nl1, nl2, nl3, nl4, nb1, nb2, nb3, nb4,
                                          t1, t2, t3, s1, f1, b1, b2, b3, cb1, cb2, cb3;
                        for (int m = 0; m < this.force; m++)
                            this.forceString += "★";
                        for (int k = 0; k < 25 - this.force; k++)
                            this.forceString += "☆";
                        meta.setLore(null);
                        // 별
                        String upperStar = String.format("%s %s %s", this.forceString.substring(0, 5), this.forceString.substring(5, 10), this.forceString.substring(10, 15));
                        String underStar = String.format("%s %s", this.forceString.substring(15, 20), this.forceString.substring(20, 25));
                        lore.add(0, ChatColor.GOLD + upperStar);
                        lore.add(1, ChatColor.GOLD + underStar);
                        // 강화표 별
                        upgradeLore.add(0, ChatColor.GOLD + upperStar);
                        upgradeLore.add(1, ChatColor.GOLD + underStar);
                        upgradeLore.add(2, "");
                        // 강화표 확률
                        upgradeLore.add(3, ChatColor.WHITE + String.format("성공: %.1f%%", successPercentage[this.force]*0.1));
                        if (this.force <= 10 || this.force == 15 || this.force == 20) {
                            upgradeLore.add(4, ChatColor.WHITE + String.format("유지: %.1f%%", (1000-successPercentage[this.force]-destroyPercentage[this.force])*0.1));
                        } else {
                            upgradeLore.add(4, ChatColor.WHITE + String.format("하락: %.1f%%", (1000-successPercentage[this.force]-destroyPercentage[this.force])*0.1));
                        }
                        if (this.force >= 12) {
                            upgradeLore.add(5, ChatColor.WHITE + String.format("파괴: %.1f%%", destroyPercentage[this.force]*0.1));
                        } else {
                            upgradeLore.add(5, ChatColor.WHITE + "");
                        }
                        meta.setLore(lore);
                        meta.removeAttributeModifier(EquipmentSlot.HAND);
                        meta.removeAttributeModifier(EquipmentSlot.OFF_HAND);
                        meta.removeAttributeModifier(EquipmentSlot.HEAD);
                        meta.removeAttributeModifier(EquipmentSlot.CHEST);
                        meta.removeAttributeModifier(EquipmentSlot.LEGS);
                        meta.removeAttributeModifier(EquipmentSlot.FEET);
                        switch (event.getCurrentItem().getType()) {
                            case IRON_AXE:
                                Double[] iron_axeAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] iron_axeAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                ia1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", iron_axeAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                ia2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", iron_axeAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, ia1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, ia2);
                                break;
                            case IRON_PICKAXE:
                                Double[] iron_pickaxeAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] iron_pickaxeAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] iron_pickaxeMS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                ip1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", iron_pickaxeAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                ip2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", iron_pickaxeAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                ip3 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", iron_pickaxeMS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, ip1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, ip2);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, ip3);
                                break;
                            case IRON_SWORD:
                                Double[] iron_swordAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] iron_swordAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                is1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", iron_swordAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                is2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", iron_swordAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, is1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, is2);
                                break;
                            case IRON_HELMET:
                                Double[] iron_helmetAD = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] iron_helmetAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                ih1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", iron_helmetAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                                ih2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", iron_helmetAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, ih1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, ih2);
                                break;
                            case IRON_CHESTPLATE:
                                Double[] iron_chestplateAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] iron_chestplateAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] iron_chestplateMHP = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                ic1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", iron_chestplateAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                                ic2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", iron_chestplateAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                                ic3 = new AttributeModifier(UUID.randomUUID(), "generic.max_health", iron_chestplateMHP[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, ic1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, ic2);
                                meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, ic3);
                                break;
                            case IRON_LEGGINGS:
                                Double[] iron_leggingsAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] iron_leggingsAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] iron_leggingsMHP = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                il1 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", iron_leggingsAD[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.LEGS);
                                il2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", iron_leggingsAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                                il3 = new AttributeModifier(UUID.randomUUID(), "generic.max_health", iron_leggingsMHP[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, il1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, il2);
                                meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, il3);
                                break;
                            case IRON_BOOTS:
                                Double[] iron_bootsSP = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] iron_bootsAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                ib1 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", iron_bootsSP[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.FEET);
                                ib2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", iron_bootsAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, ib1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, ib2);
                                break;
                            case GOLDEN_AXE:
                                Double[] golden_axeAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] golden_axeAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                ga1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", golden_axeAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                ga2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", golden_axeAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, ga1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, ga2);
                                break;
                            case GOLDEN_PICKAXE:
                                Double[] golden_pickaxeAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] golden_pickaxeAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] golden_pickaxeMS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                gp1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", golden_pickaxeAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                gp2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", golden_pickaxeAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                gp3 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", golden_pickaxeMS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, gp1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, gp2);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, gp3);
                                break;
                            case GOLDEN_SWORD:
                                Double[] golden_swordAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] golden_swordAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                gs1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", golden_swordAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                gs2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", golden_swordAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, gs1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, gs2);
                                break;
                            case GOLDEN_HELMET:
                                Double[] golden_helmetAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] golden_helmetAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                gh1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", golden_helmetAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                                gh2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", golden_helmetAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, gh1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, gh2);
                                break;
                            case GOLDEN_CHESTPLATE:
                                Double[] golden_chestplateAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] golden_chestplateAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] golden_chestplateMHP = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                gc1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", golden_chestplateAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                                gc2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", golden_chestplateAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                                gc3 = new AttributeModifier(UUID.randomUUID(), "generic.max_health", golden_chestplateMHP[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, gc1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, gc2);
                                meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, gc3);
                                break;
                            case GOLDEN_LEGGINGS:
                                Double[] golden_leggingsMS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] golden_leggingsAM = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] golden_leggingsMHP = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                gl1 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", golden_leggingsMS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.LEGS);
                                gl2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", golden_leggingsAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                                gl3 = new AttributeModifier(UUID.randomUUID(), "generic.max_health", golden_leggingsMHP[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, gl1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, gl2);
                                meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, gl3);
                                break;
                            case GOLDEN_BOOTS:
                                Double[] golden_bootsMS = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] golden_bootsAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] golden_bootsAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                gb1 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", golden_bootsMS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.FEET);
                                gb2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", golden_bootsAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                                gb3 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", golden_bootsAS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.FEET);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, gb1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, gb2);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, gb3);
                                break;
                            case DIAMOND_AXE:
                                Double[] diamond_axeAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] diamond_axeAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                da1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", diamond_axeAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                da2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", diamond_axeAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, da1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, da2);
                                break;
                            case DIAMOND_PICKAXE:
                                Double[] diamond_pickaxeAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] diamond_pickaxeAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] diamond_pickaxeMS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                dp1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", diamond_pickaxeAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                dp2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", diamond_pickaxeAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                dp3 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", diamond_pickaxeMS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, dp1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, dp2);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, dp3);
                                break;
                            case DIAMOND_SWORD:
                                Double[] diamond_swordAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] diamond_swordAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                ds1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", diamond_swordAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                ds2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", diamond_swordAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, ds1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, ds2);
                                break;
                            case DIAMOND_HELMET:
                                Double[] diamond_helmetAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] diamond_helmetAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] diamond_helmetTN = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                dh1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", diamond_helmetAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                                dh2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", diamond_helmetAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                                dh3 = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", diamond_helmetTN[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, dh1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, dh2);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, dh3);
                                break;
                            case DIAMOND_CHESTPLATE:
                                Double[] diamond_chestplateAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] diamond_chestplateAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] diamond_chestplateMHP = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] diamond_chestplateTN = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                dc1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", diamond_chestplateAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                                dc2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", diamond_chestplateAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                                dc3 = new AttributeModifier(UUID.randomUUID(), "generic.max_health", diamond_chestplateMHP[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                                dc4 = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", diamond_chestplateTN[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, dc1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, dc2);
                                meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, dc3);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, dc4);
                                break;
                            case DIAMOND_LEGGINGS:
                                Double[] diamond_leggingsMS = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] diamond_leggingsAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] diamond_leggingsMHP = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] diamond_leggingsTN = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                dl1 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", diamond_leggingsMS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.LEGS);
                                dl2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", diamond_leggingsAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                                dl3 = new AttributeModifier(UUID.randomUUID(), "generic.max_health", diamond_leggingsMHP[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                                dl4 = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", diamond_leggingsTN[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, dl1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, dl2);
                                meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, dl3);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, dl4);
                                break;
                            case DIAMOND_BOOTS:
                                Double[] diamond_bootsMS = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] diamond_bootsAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] diamond_bootsAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] diamond_bootsTN = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                db1 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", diamond_bootsMS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.FEET);
                                db2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", diamond_bootsAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                                db3 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", diamond_bootsAS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.FEET);
                                db4 = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", diamond_bootsTN[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.FEET);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, db1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, db2);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, db3);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, db4);
                                break;
                            case NETHERITE_AXE:
                                Double[] netherite_axeAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] netherite_axeAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                na1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", netherite_axeAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                na2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", netherite_axeAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, na1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, na2);
                                break;
                            case NETHERITE_PICKAXE:
                                Double[] netherite_pickaxeAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] netherite_pickaxeAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] netherite_pickaxeMS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                np1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", netherite_pickaxeAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                np2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", netherite_pickaxeAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                np3 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", netherite_pickaxeMS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, np1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, np2);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, np3);
                                break;
                            case NETHERITE_SWORD:
                                Double[] netherite_swordAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] netherite_swordAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                ns1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", netherite_swordAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                ns2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", netherite_swordAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, ns1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, ns2);
                                break;
                            case NETHERITE_HELMET:
                                Double[] netherite_helmetAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] netherite_helmetAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] netherite_helmetTN = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                nh1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", netherite_helmetAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                                nh2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", netherite_helmetAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                                nh3 = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", netherite_helmetTN[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, nh1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, nh2);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, nh3);
                                break;
                            case NETHERITE_CHESTPLATE:
                                Double[] netherite_chestplateAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] netherite_chestplateAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] netherite_chestplateMHP = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] netherite_chestplateTN = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                nc1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", netherite_chestplateAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                                nc2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", netherite_chestplateAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                                nc3 = new AttributeModifier(UUID.randomUUID(), "generic.max_health", netherite_chestplateMHP[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                                nc4 = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", netherite_chestplateTN[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, nc1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, nc2);
                                meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, nc3);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, nc4);
                                break;
                            case NETHERITE_LEGGINGS:
                                Double[] netherite_leggingsMS = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] netherite_leggingsAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] netherite_leggingsMHP = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] netherite_leggingsTN = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                nl1 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", netherite_leggingsMS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.LEGS);
                                nl2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", netherite_leggingsAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                                nl3 = new AttributeModifier(UUID.randomUUID(), "generic.max_health", netherite_leggingsMHP[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                                nl4 = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", netherite_leggingsTN[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, nl1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, nl2);
                                meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, nl3);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, nl4);
                                break;
                            case NETHERITE_BOOTS:
                                Double[] netherite_bootsMS = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] netherite_bootsAM = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] netherite_bootsAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] netherite_bootsTN = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                nb1 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", netherite_bootsMS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.FEET);
                                nb2 = new AttributeModifier(UUID.randomUUID(), "generic.armor", netherite_bootsAM[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                                nb3 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", netherite_bootsAS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.FEET);
                                nb4 = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", netherite_bootsTN[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, nb1);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, nb2);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, nb3);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, nb4);
                                break;
                            case TRIDENT:
                                Double[] tridentAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] tridentAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] tridentMS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                t1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", tridentAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                t2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", tridentAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                t3 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", tridentMS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, t1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, t2);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, t3);
                                break;
                            case SHIELD:
                                Double[] shieldTN = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                s1 = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", shieldTN[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, s1);
                                break;
                            case FISHING_ROD:
                                Double[] fishing_rodLUK = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                f1 = new AttributeModifier(UUID.randomUUID(), "generic.luck", fishing_rodLUK[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_LUCK, f1);
                                break;
                            case BOW:
                                Double[] bowAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] bowAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] bowMS = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                b1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", bowAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                b2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", bowAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                b3 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", bowMS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, b1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, b2);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, b3);
                                break;
                            case CROSSBOW:
                                Double[] crossbowAD = {9.0D,9.2D,9.4D,9.6D,9.8D,10.0D,10.3D,10.6D,10.9D,11.2D,11.5D,11.8D,12.1D,12.4D,12.7D,13.0D,13.4D,13.8D,14.2D,14.8D,15.0D,15.5D,16.0D,16.5D,17.0D,18.0D};
                                Double[] crossbowAS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                Double[] crossbowMS = {0.90D,0.92D,0.94D,0.96D,0.98D,1.00D,1.03D,1.06D,1.09D,1.12D,1.15D,1.18D,1.21D,1.24D,1.27D,1.30D,1.35D,1.40D,1.45D,1.50D,1.55D,1.60D,1.70D,1.80D,1.90D,2.00D};
                                cb1 = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", crossbowAD[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                cb2 = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", crossbowAS[this.force], AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                cb3 = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", crossbowMS[this.force], AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, cb1);
                                meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, cb2);
                                meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, cb3);
                                break;

                        }
                        event.getCurrentItem().setItemMeta(meta);
                    } else {
                        event.getCurrentItem().setAmount(0);
                    }
                    playerInventory.setItem(((Integer)this.anvilMap.get(anvilInven)).intValue(), event.getCurrentItem());
                    meta.setLore(upgradeLore);
                    event.getCurrentItem().setItemMeta(meta);
                }
                break;
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void GrindGui(InventoryClickEvent event) {
        Inventory grindInven = null;
        for (Inventory inventory : this.grindList) {
            if (event.getInventory().equals(inventory))
                grindInven = inventory;
        }
        if (grindInven == null)
            return;
        Player a = (Player)event.getWhoClicked();
        ItemStack upgradeItem = new ItemStack(Material.AIR, 1);
        ItemStack spellBook = new ItemStack(Material.BOOK);
        ItemStack firstSlot = new ItemStack(Material.BOOK, 1);
        ItemMeta spell = spellBook.getItemMeta();
        spell.setDisplayName(ChatColor.WHITE + "마법부여 강화 주문서");
        spellBook.setItemMeta(spell);
        firstSlot.setItemMeta(spell);
        PlayerInventory playerInventory = a.getInventory();
        int slotId = 50;
        for (int i = 1; i < playerInventory.getMaxStackSize() + 1; i++) {
            int temp = playerInventory.first(firstSlot);
            if (temp < slotId && temp != -1)
                slotId = temp;
            firstSlot.setAmount(firstSlot.getAmount() + 1);
        }
        switch (event.getCurrentItem().getType()) {
            case IRON_SWORD:
            case IRON_AXE:
            case IRON_PICKAXE:
            case IRON_HELMET:
            case IRON_CHESTPLATE:
            case IRON_LEGGINGS:
            case IRON_BOOTS:
            case GOLDEN_SWORD:
            case GOLDEN_AXE:
            case GOLDEN_PICKAXE:
            case GOLDEN_HELMET:
            case GOLDEN_CHESTPLATE:
            case GOLDEN_LEGGINGS:
            case GOLDEN_BOOTS:
            case DIAMOND_SWORD:
            case DIAMOND_AXE:
            case DIAMOND_PICKAXE:
            case DIAMOND_HELMET:
            case DIAMOND_CHESTPLATE:
            case DIAMOND_LEGGINGS:
            case DIAMOND_BOOTS:
            case NETHERITE_SWORD:
            case NETHERITE_AXE:
            case NETHERITE_PICKAXE:
            case NETHERITE_HELMET:
            case NETHERITE_CHESTPLATE:
            case NETHERITE_LEGGINGS:
            case NETHERITE_BOOTS:
            case SHIELD:
            case TRIDENT:
            case FISHING_ROD:
            case BOW:
            case CROSSBOW:
                if (!event.getSlotType().equals(InventoryType.SlotType.CONTAINER) || event.getSlot() > 8)
                    if (event.getCurrentItem().getItemMeta().hasEnchants()) {
                        upgradeItem.setType(event.getCurrentItem().getType());
                        upgradeItem.setData(event.getCurrentItem().getData());
                        upgradeItem.setItemMeta(event.getCurrentItem().getItemMeta());
                        this.grindMap.put(grindInven, Integer.valueOf(event.getSlot()));
                        grindInven.setItem(4, upgradeItem);
                    }
                break;
        }
        switch (event.getSlot()) {
            case 4:
                if (event.getSlotType().equals(InventoryType.SlotType.CONTAINER) && playerInventory.containsAtLeast(spellBook, 1)) {
                    int upgradeCount = 1;
                    int maxCount = 1;
                    int maxRank = 18;
                    double rand = Math.random();
                    for (int k = 0; k < (Enchantment.values()).length; k++) {
                        if (event.getCurrentItem().containsEnchantment(Enchantment.values()[k])) {
                            maxCount++;
                            maxRank--;
                            event.getCurrentItem().addUnsafeEnchantment(Enchantment.values()[k], 1);
                        }
                    }
                    while (rand < 0.9D) {
                        upgradeCount++;
                        if (upgradeCount >= maxCount)
                            rand = 1.0D;
                    }
                    for (int j = 0; j < upgradeCount; j++) {
                        double ran = Math.random();
                        double lvran = Math.random();
                        if (!event.getCurrentItem().containsEnchantment(Enchantment.values()[(int)(ran * (Enchantment.values()).length)])) {
                            j--;
                        } else if (maxRank > (int)(lvran * 6.0D)) {
                            event.getCurrentItem().addUnsafeEnchantment(Enchantment.values()[(int)(ran * (Enchantment.values()).length)], (int)(lvran * 7.0D) + 1);
                            maxRank -= (int)(lvran * 6.0D);
                        } else {
                            event.getCurrentItem().addUnsafeEnchantment(Enchantment.values()[(int)(ran * (Enchantment.values()).length)], maxRank);
                            break;
                        }
                    }
                    playerInventory.setItem(((Integer)this.grindMap.get(grindInven)).intValue(), event.getCurrentItem());
                    ItemStack usedSpell = new ItemStack(playerInventory.getItem(slotId).getType(), playerInventory.getItem(slotId).getAmount() - 1);
                    usedSpell.setItemMeta(spell);
                    playerInventory.setItem(slotId, usedSpell);
                    a.playSound(a.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1.0F, 0.3F);
                }
                break;
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void EnchantGui(InventoryClickEvent event) {
        Inventory enchantInven = null;
        int slotId = 50;
        for (Inventory inventory : this.enchantList) {
            if (event.getInventory().equals(inventory))
                enchantInven = inventory;
        }
        if (enchantInven == null)
            return;
        Player a = (Player)event.getWhoClicked();
        ItemStack upgradeItem = new ItemStack(Material.AIR, 1);
        ItemStack spellBook = new ItemStack(Material.PAPER);
        ItemStack firstSlot = new ItemStack(Material.PAPER, 1);
        ItemMeta spell = spellBook.getItemMeta();
        spell.setDisplayName(ChatColor.WHITE + "마법부여 설정 주문서");
        spellBook.setItemMeta(spell);
        firstSlot.setItemMeta(spell);
        PlayerInventory playerInventory = a.getInventory();
        int i;
        for (i = 1; i < playerInventory.getMaxStackSize() + 1; i++) {
            int temp = playerInventory.first(firstSlot);
            if (temp < slotId && temp != -1)
                slotId = temp;
            firstSlot.setAmount(firstSlot.getAmount() + 1);
        }
        switch (event.getCurrentItem().getType()) {
            case IRON_SWORD:
            case IRON_AXE:
            case IRON_PICKAXE:
            case IRON_HELMET:
            case IRON_CHESTPLATE:
            case IRON_LEGGINGS:
            case IRON_BOOTS:
            case GOLDEN_SWORD:
            case GOLDEN_AXE:
            case GOLDEN_PICKAXE:
            case GOLDEN_HELMET:
            case GOLDEN_CHESTPLATE:
            case GOLDEN_LEGGINGS:
            case GOLDEN_BOOTS:
            case DIAMOND_SWORD:
            case DIAMOND_AXE:
            case DIAMOND_PICKAXE:
            case DIAMOND_HELMET:
            case DIAMOND_CHESTPLATE:
            case DIAMOND_LEGGINGS:
            case DIAMOND_BOOTS:
            case NETHERITE_SWORD:
            case NETHERITE_AXE:
            case NETHERITE_PICKAXE:
            case NETHERITE_HELMET:
            case NETHERITE_CHESTPLATE:
            case NETHERITE_LEGGINGS:
            case NETHERITE_BOOTS:
            case SHIELD:
            case TRIDENT:
            case FISHING_ROD:
            case BOW:
            case CROSSBOW:
                if (!event.getSlotType().equals(InventoryType.SlotType.CONTAINER) || event.getSlot() > 8) {
                    upgradeItem.setType(event.getCurrentItem().getType());
                    upgradeItem.setData(event.getCurrentItem().getData());
                    upgradeItem.setItemMeta(event.getCurrentItem().getItemMeta());
                    this.enchantMap.put(enchantInven, Integer.valueOf(event.getSlot()));
                    enchantInven.setItem(4, upgradeItem);
                }
                break;
        }
        switch (event.getSlot()) {
            case 4:
                if (event.getSlotType().equals(InventoryType.SlotType.CONTAINER) && playerInventory.containsAtLeast(spellBook, 1)) {
                    this.abilityCount = 1;
                    for (i = 0; i < (Enchantment.values()).length; i++)
                        event.getCurrentItem().removeEnchantment(Enchantment.values()[i]);
                    double rand = Math.random();
                    while (rand < 0.7D) {
                        this.abilityCount++;
                        rand = Math.random();
                        if (this.abilityCount > 5)
                            rand = 1.0D;
                    }
                    for (int j = 0; j < this.abilityCount; j++) {
                        Enchantment randEnchant = Enchantment.values()[(int)(Math.random() * (Enchantment.values()).length)];
                        event.getCurrentItem().addUnsafeEnchantment(randEnchant, 1);
                        playerInventory.setItem(((Integer)this.enchantMap.get(enchantInven)).intValue(), event.getCurrentItem());
                    }
                    ItemStack usedSpell = new ItemStack(playerInventory.getItem(slotId).getType(), playerInventory.getItem(slotId).getAmount() - 1);
                    usedSpell.setItemMeta(spell);
                    playerInventory.setItem(slotId, usedSpell);
                    a.playSound(a.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1.0F, 1.0F);
                }
                break;
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void guiOpen(PlayerInteractEvent event) {
        if (event.getClickedBlock().getType() == Material.ENCHANTING_TABLE) {
            event.setCancelled(true);
            EnchantTable(event.getPlayer());
        } else if (event.getClickedBlock().getType() == Material.ANVIL) {
            event.setCancelled(true);
            AnvilTable(event.getPlayer());
        } else if (event.getClickedBlock().getType() == Material.GRINDSTONE) {
            event.setCancelled(true);
            GrindTable(event.getPlayer());
        }
    }

    @EventHandler
    public void GetSpellBooks(EntityDeathEvent deathEvent) {
        ItemStack drop1 = new ItemStack(Material.PAPER, 1);
        ItemStack drop2 = new ItemStack(Material.BOOK, 1);
        ItemStack drop3 = new ItemStack(Material.BOOK, 1);
        ItemStack drop4 = new ItemStack(Material.PAPER, 1);
        ItemMeta drop1Meta = drop1.getItemMeta();
        ItemMeta drop2Meta = drop2.getItemMeta();
        ItemMeta drop3Meta = drop3.getItemMeta();
        ItemMeta drop4Meta = drop3.getItemMeta();
        double drop1ran = Math.random();
        double drop2ran = Math.random();
        double drop3ran = Math.random();
        double drop4ran = Math.random();
        drop1Meta.setDisplayName(ChatColor.WHITE + "마법부여 설정 주문서");
        drop2Meta.setDisplayName(ChatColor.WHITE + "스타포스 강화 주문서");
        drop3Meta.setDisplayName(ChatColor.WHITE + "마법부여 강화 주문서");
        drop4Meta.setDisplayName(ChatColor.WHITE + "파괴 방지 주문서");
        drop1.setItemMeta(drop1Meta);
        drop2.setItemMeta(drop2Meta);
        drop3.setItemMeta(drop3Meta);
        drop4.setItemMeta(drop4Meta);
        drop4.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        if (drop1ran > 0.8D)
            deathEvent.getDrops().add(drop1);
        if (drop2ran > 0.9D)
            deathEvent.getDrops().add(drop2);
        if (drop3ran > 0.9D)
            deathEvent.getDrops().add(drop3);
        if (drop4ran > 0.95D)
            deathEvent.getDrops().add(drop4);
    }

    /* @EventHandler
    public void EnjoyEvents(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPlayedBefore())
            spellCommand.noOp.put(event.getPlayer().getName(), Integer.valueOf(0));
    } */
}