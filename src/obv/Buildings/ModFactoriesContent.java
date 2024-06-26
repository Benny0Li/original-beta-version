package obv.Buildings;

import arc.util.*;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.blocks.production.*;
import mindustry.world.meta.*;
import obv.ClassTypes.*;
import obv.ItemAndLiquid.*;

public class ModFactoriesContent implements ModBuildingsContentInterface{
    public GenericCrafter batteryBuilder, charger;
    public assemblyGenerator disCharger;

    public void initFactories(){
        batteryBuilder = new GenericCrafter("batteryBuilder");
        charger = new GenericCrafter("charger");
        disCharger = new assemblyGenerator("disCharger");
    }

    private void setupFactoryConfig(){
        batteryBuilder.hasItems = true;
        charger.hasItems = true;
        disCharger.hasItems = true;

        batteryBuilder.craftTime = 60f;
        charger.craftTime = 60f;
        disCharger.itemDuration = 60f;

        batteryBuilder.hasPower = true;
        charger.hasPower = true;
        disCharger.hasPower = true;

        batteryBuilder.consumePower(3f);//1f=60/s
        charger.consumePower(100f);
        disCharger.outputsPower = true;
        disCharger.consumesPower = false;
        disCharger.powerProduction = 95f;

        batteryBuilder.health = 320;
        charger.health = 450;
        disCharger.health = 450;

        batteryBuilder.requirements(Category.crafting, BuildVisibility.shown, new ItemStack[]{
        new ItemStack(Items.titanium, 80),
        new ItemStack(Items.graphite, 50),
        new ItemStack(Items.lead, 125),
        new ItemStack(ModItemsContent.iron, 30)
        });
        charger.requirements(Category.power, BuildVisibility.shown, new ItemStack[]{
        new ItemStack(Items.surgeAlloy, 25),
        new ItemStack(Items.silicon, 80),
        new ItemStack(Items.titanium, 80),
        new ItemStack(Items.graphite, 50),
        new ItemStack(Items.lead, 125),
        new ItemStack(ModItemsContent.iron, 30),
        new ItemStack(Items.phaseFabric, 30)
        });
        disCharger.requirements(Category.power, BuildVisibility.shown, new ItemStack[]{
        new ItemStack(Items.surgeAlloy, 30),
        new ItemStack(Items.silicon, 120),
        new ItemStack(Items.titanium, 80),
        new ItemStack(Items.graphite, 50),
        new ItemStack(Items.lead, 125),
        new ItemStack(ModItemsContent.iron, 30),
        new ItemStack(Items.phaseFabric, 15)
        });

        batteryBuilder.consumeItems(new ItemStack[]{
        new ItemStack(Items.surgeAlloy, 1),
        new ItemStack(Items.silicon, 3)
        });
        charger.consumeItems(new ItemStack[]{
        new ItemStack(ModItemsContent.emptyMobileBattery, 1)
        });
        disCharger.consumeItems(new ItemStack[]{
        new ItemStack(ModItemsContent.fullMobileBattery, 1)
        });

        batteryBuilder.outputItems = new ItemStack[]{
        new ItemStack(ModItemsContent.emptyMobileBattery, 1)
        };
        charger.outputItems = new ItemStack[]{
        new ItemStack(ModItemsContent.fullMobileBattery, 1)
        };
        disCharger.outputItems = new ItemStack[]{
        new ItemStack(ModItemsContent.emptyMobileBattery, 1)
        };


        batteryBuilder.size = 3;
        charger.size = 3;
        disCharger.size = 3;
    }

    public void init(){
        Log.info("[OBV-FACTORIES]Start");
        initFactories();
    }

    @Override
    public void load(){
        setupFactoryConfig();
    }

    @Override
    public boolean enable(){
        return true;
    }
}
