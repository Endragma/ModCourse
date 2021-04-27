package com.icarocampos.modcourse;

import com.icarocampos.modcourse.block.ModBlocks;
import com.icarocampos.modcourse.block.ModFluids;
import com.icarocampos.modcourse.container.ModContainers;
import com.icarocampos.modcourse.entity.BuffaloEntity;
import com.icarocampos.modcourse.entity.ModEntityTypes;
import com.icarocampos.modcourse.events.ModEvents;
import com.icarocampos.modcourse.item.ModItems;
import com.icarocampos.modcourse.setup.ClientProxy;
import com.icarocampos.modcourse.setup.IProxy;
import com.icarocampos.modcourse.setup.ServerProxy;
import com.icarocampos.modcourse.tileentity.ModTileEntities;
import com.icarocampos.modcourse.util.Config;
import com.icarocampos.modcourse.util.Registration;
import com.icarocampos.modcourse.world.biome.ModBiomes;
import com.icarocampos.modcourse.world.biome.ModSurfaceBuilders;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ModCourse.MOD_ID)
public class ModCourse
{
    public static final String MOD_ID = "modcourse";

    public static final ItemGroup COURSE_TAB = new ItemGroup("courseTab") {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.COPPER_WIRE.get());
        }
    };

    public static IProxy proxy;


    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public ModCourse() {
        proxy = DistExecutor.safeRunForDist(()-> ClientProxy::new,()-> ServerProxy::new);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        registerModAdditions();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        registerConfigs();

        proxy.init();

        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.BUFFALO.get(), BuffaloEntity.setCustomAttribute().create());
        });

        loadConfigs();
    }

        private void registerConfigs()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);

    }

    private void loadConfigs()
    {
        Config.loadConfigFile(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("modcourse-client.toml").toString());
        Config.loadConfigFile(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("modcourse-server.toml").toString());

    }

    private void registerModAdditions()
    {
        Registration.init();


        ModItems.register();
        ModBlocks.register();
        ModFluids.register();
        ModBiomes.register();
        ModSurfaceBuilders.register();
        ModTileEntities.register();
        ModContainers.register();
        ModEntityTypes.register();


        MinecraftForge.EVENT_BUS.register((new ModEvents()));
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
