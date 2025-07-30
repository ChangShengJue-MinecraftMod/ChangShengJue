package com.shengchanshe.chang_sheng_jue.event.kungfu;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.item.combat.knife.KitchenKnife;
import com.shengchanshe.chang_sheng_jue.martial_arts.IInteranlKungFu;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.Paoding;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class PaodingEvent {

    public static void onEntityDeath(LivingDeathEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide) {
            Entity entity = event.getSource().getEntity();
            if (entity instanceof Player player) {
                if (player.getMainHandItem().getItem() instanceof KitchenKnife) {
                    player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                        cap.getKungFu(Paoding.KUNG_FU_ID.toString())
                                .filter(kungFu -> kungFu instanceof Paoding)
                                .map(kungFu -> (IInteranlKungFu) kungFu)
                                .filter(IInteranlKungFu::isReady)
                                .map(active -> {
                                    ((Paoding) active).attack(player, event.getEntity(), event.getSource());
                                    return true;
                                });
                    });
                }
            }
        }
    }
}
