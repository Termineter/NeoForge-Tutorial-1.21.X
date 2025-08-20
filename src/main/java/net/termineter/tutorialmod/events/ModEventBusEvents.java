package net.termineter.tutorialmod.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.termineter.tutorialmod.TutorialMod;
import net.termineter.tutorialmod.entity.ModEntities;
import net.termineter.tutorialmod.entity.client.GeckoAnimations;
import net.termineter.tutorialmod.entity.client.GeckoModel;
import net.termineter.tutorialmod.entity.custom.GeckoEntity;

@EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GeckoModel.LAYER_LOCATION, GeckoModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GECKO.get(), GeckoEntity.createAttributes().build());
    }
}
